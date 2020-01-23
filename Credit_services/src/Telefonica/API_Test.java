package Telefonica;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.*;
import Common_POMs.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class API_Test extends Driver{
	
	//static String agrNum, customerId, hardwareId, eSignUrl;
	public static JsonPath jsonPath;
	public static String userName;
	public static String passWord;
	public static String baseUrl;
	public static String agrNum;

	public static void applicationKnown(Recordset recordset) throws IOException, FilloException, InterruptedException{
		String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			String jsonData=recordset.getField("JSON_DATA1"), responseData="", customerId="", hardwareId="";
			userName = Driver.recordset.getField("API_Username");	
			passWord = Driver.recordset.getField("API_Password");
			baseUrl = Driver.recordset.getField("API_url");
			//***replace variables with values in parameterised XML
			jsonData = jsonData.replace("Refnum", genUniqueKey());
			for (int j = 0; j < recordset.getFieldNames().size(); j++) {
				String variable = WordUtils.capitalize(recordset.getField(j).name().toLowerCase());
				if (jsonData.contains(variable)) {
					String value =(recordset.getField(j).value());
					//System.out.println(variable+": "+value);
					jsonData =  jsonData.replace(variable, value);
				}
			}
			//System.out.println(jsonData);
									
			responseData = execute(genUniqueKey(), userName, passWord, baseUrl+"HardwareLoanAgreement/"+"?json="+jsonData);
			//System.out.println(responseData);
			
			//**Parse the response with JsonPath	
			jsonPath =  new JsonPath(responseData);
			agrNum = jsonPath.getString("AgreementNumber");
			customerId = jsonPath.getString("CustomerID");
			jsonPath.setRoot("HardwareList");
			hardwareId = jsonPath.getList("HardwareID").get(0).toString();	
			//System.out.println(agrNum+" : "+customerId+" : "+hardwareId);
			
			//**Store the agreement number into the work book
			Agreement_Store.Store_Data(WhichClient,agrNum,hardwareId,recordset);
			Utilities.ExtentPassReport(methodname);
			
		} catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
				
	}
	public static void applicationEsignature(Recordset recordset) throws IOException, FilloException, InterruptedException{
		String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String responseData="", eSignUrl="";
			responseData = execute(genUniqueKey(), userName, passWord, baseUrl+"HardwareLoanAgreement/"+recordset.getField("Agreement_Number")+"/ESignature/?json="+recordset.getField("JSON_DATA2"));
			//**Parse the response with JsonPath
			jsonPath =  new JsonPath(responseData).setRoot("LoanAgreement");
			eSignUrl = jsonPath.getString("ESignatureCallUrl");
			//System.out.println(eSignUrl);
			Common_Property.driver.get(eSignUrl);
			Common_Property.waitUntill(POM_Repository.TUK_Chk_Secci);
	    	Common_Property.driver.findElement(POM_Repository.TUK_Chk_Secci).click();
	    	Common_Property.waitUntillEnabled(POM_Repository.TUK_Btn_Proceed);
	    	Common_Property.driver.findElement(POM_Repository.TUK_Btn_Proceed).click();
	    	Common_Property.waitUntill(POM_Repository.TUK_Chk_AgrSign);
	    	if (Common_Property.driver.findElement(POM_Repository.TUK_Chk_AgrSign).isDisplayed()) {
	    		Common_Property.driver.navigate().refresh();
	    		Common_Property.waitUntill(POM_Repository.TUK_Chk_AgrSign);
	    		Common_Property.driver.findElement(POM_Repository.TUK_Chk_AgrSign).click();
			}
	    	Common_Property.waitUntillEnabled(POM_Repository.TUK_Btn_Submit);
	    	Common_Property.driver.findElement(POM_Repository.TUK_Btn_Submit).click();
	    	Common_Property.waitUntill(POM_Repository.TUK_Btn_Next);
	    	Common_Property.driver.findElement(POM_Repository.TUK_Btn_Next).click();
	    	Common_Property.waitUntill(POM_Repository.TUK_Btn_Continue);
	    	Common_Property.driver.findElement(POM_Repository.TUK_Btn_Continue).click();
	    	Common_Property.waitUntill(POM_Repository.TUK_FinalMsg);
	    	Utilities.ExtentPassReport(methodname);
		} catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
	}
	
	public static void applicationAttribute(Recordset recordset) throws IOException, FilloException, InterruptedException {
		String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			execute(genUniqueKey(), userName, passWord, baseUrl+"HardwareLoanAgreement/"+recordset.getField("Agreement_Number")+"/Attribute/?json="+recordset.getField("JSON_DATA3"));
			Utilities.ExtentPassReport(methodname);
		} catch (Exception e) {
			System.out.println("The exception was "+e);	
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
	}
		
	//***rest assured execution with headers -- Telefonica
	public static String execute(String uniquekey, String strUsrName, String strPassWord, String str_url){
		ValidatableResponse response = RestAssured.given()
				.auth()
				.preemptive()
				.basic(strUsrName, strPassWord)
				//.contentType(strContentType)
				.header("SOATransactionID", uniquekey)
				.header("SOAConsumerTransactionID", uniquekey)
		        .when()
		        .post(str_url)
		        .then();
		
		return response.extract().body().asString();
	}
	
	public static String genUniqueKey(){
		Date date= new Date();
		SimpleDateFormat sf = new SimpleDateFormat("Hms");
		String uniquekey = sf.format(date);
		
		return uniquekey;
	}
	
		
}
