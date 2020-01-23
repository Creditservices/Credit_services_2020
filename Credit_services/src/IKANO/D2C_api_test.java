package IKANO;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Common_Funtions.Agreement_Store;
import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import Common_POMs.*;
import groovy.util.ResourceException;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;




public class D2C_api_test extends Driver  {
	
	public static String agrNum,eSignUrl,decisionCode;
	
	
	public static void d2c_api() throws Exception
	{
		Driver.sheetflag=true;
		String url=Driver.getData("API_url");
		String xmlData1 = Driver.getData("REQUEST_DATA");
		String xmlData2 = Driver.getData("REQUEST_DATA2");
		String xmlData3 = Driver.getData("REQUEST_DATA3");
		Driver.sheetflag=true;
		String usrName = Driver.getData("API_Username");
		Driver.sheetflag=true;
		String passWord = Driver.getData("API_Password");
		agrGenerator(xmlData1, xmlData2, xmlData3, url, usrName, passWord);
		
	}
	
	public static void agrGenerator(String strXmlData1, String strXmlData2, String strXmlData3,
			String StrUrl, String strUsrName, String strPassWord) throws Exception{
				
			MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			Methodid = Long.toString(Thread.currentThread().getId());
			
			String xmlData1=strXmlData1, xmlData2=strXmlData2, xmlData3=strXmlData3;
			String responseData="",apply="",quotationSearch="",eSignatureURL="";
			boolean flag = true;
			String eSignUrl = "", agrStatus ="", contentType = "text/xml";
		
			
						for (int j = 43; j < Driver.recordset1.getFieldNames().size(); j++) 
						{
							String variable = WordUtils.capitalize(Driver.recordset1.getField(j).name().toLowerCase());
							if (xmlData1.contains(variable)) 
							{
								String value =Driver.recordset1.getField(j).value();
								System.out.println(variable+": "+value);
					       	 	xmlData1 =  xmlData1.replace(variable, value);
						    }
				
				 
			}
			
			//System.out.println(StrUrl+"/ikanoD2CApi/token/?username="+strUsrName+"&password="+strPassWord);
			responseData = execute(contentType, StrUrl+"/ikanoD2CApi/token/?username="+strUsrName+"&password="+strPassWord);
			//***quotationSearch
	        if (responseData.contains("<apply>")) 
	        {
	        	
				//Extract token values from responseData
				apply= splitValues(responseData, "<apply>","</apply>");
				quotationSearch= splitValues(responseData, "<quotationSearch>","</quotationSearch>");	
			    eSignatureURL= splitValues(responseData, "<eSignatureURL>","</eSignatureURL>");
			    responseData = execute(contentType, StrUrl+quotationSearch+"?xml="+xmlData1);
		        //Extract person Id from response data
				        if (responseData.contains("<agreementNumber>"))
				        {
				        	 agrNum = splitValues(responseData, "<agreementNumber>","</agreementNumber>");
				        	 Agreement_Store.Store_Data(WhichClient,agrNum,"",Driver.recordset1);
						}
		            
			}
	        
	        //***apply
	        if (!agrNum.equalsIgnoreCase("") && flag)
	        {
	        	apply = apply.replace("AGRNUM", agrNum);
		        
		        responseData = execute(contentType, StrUrl+apply+"?xml="+xmlData2);
		        //Extract agreement number from response data
		        if (responseData.contains("<decision>")) {
		        	decisionCode = splitValues(responseData, "<decision>","</decision>");
				}
		        
			}
	        
	        //***Front office approval
	        if (decisionCode.equalsIgnoreCase("Refer/1")) {
	        	
	    		try {
	    			Driver.sheetflag=true;
	    			String url=Driver.getData("FrontOffice_Url");
	    			Driver.sheetflag=true;
	    			String Username=Driver.getData("FO_Username");
	    			Driver.sheetflag=true;
	    			String Password=Driver.getData("FO_Password");	
	    			
	    			frontofficeLogin(url, Username, Password);
	    			String bindingvalue=Ikano.Ikano_recordset1.getField("DATABINDING");
	    			Driver.refreshSheet1(bindingvalue,Ikano.Ikano_recordset1);
	    			agrStatus = frontofficeApprove(Driver.getData("Agreement_Number"));
					
					
				} catch (Exception e) {
					e.printStackTrace();
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
				}
	    		
			}else if (decisionCode.equalsIgnoreCase("Approved")) {
				System.out.println("Agreement number: "+agrNum+" is in appoved status. So no need to launch fron office****");
			} 
	        
	       
	        if (agrStatus.equalsIgnoreCase("Approved") && flag) 
	        {
	        	eSignatureURL = eSignatureURL.replace("AGRNUM", agrNum);
		        responseData = execute(contentType, StrUrl+eSignatureURL+"?xml="+xmlData3);
		        
				        if (responseData.contains("<eSigURL>")) 
				        {
				        	eSignUrl = splitValues(responseData, "<eSigURL>","</eSigURL>");
				        	flag = eSignAgrDocuments(eSignUrl);
				        	Agreement_Store.Store_Data(WhichClient,agrNum,eSignUrl,Driver.recordset1);
				        }
		        
			}
	        
	      
	   }
	
	public static String execute(String strContentType, String str_url) throws Exception,ResourceException{
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		ValidatableResponse response=null;
		try
		{
		         response =RestAssured.given()
				.contentType(strContentType)
		        .when()
		        .post(str_url)
		        .then();
	
		}
		catch(Exception e){
			System.out.println(e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
		return response.extract().body().asString();
	
	}
	
	public static String splitValues(String source, String start, String end)
	{
		String[] parse = source.split(start);
		String stringparse = parse[1];
		String[] newparse = stringparse.split(end);
		String value = newparse[0];
		return value;
	}
	
	public static void frontofficeLogin(String url, String userName, String password) throws Exception
	{
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
	try{
		Common_Property.IntiateBrowser();
		Common_Property.driver.get(url);
		Common_Property.driver.findElement(POM_Repository.UsernameFO).sendKeys(userName);
		Common_Property.driver.findElement(POM_Repository.PasswordFO).sendKeys(password);
		Common_Property.driver.findElement(POM_Repository.SubmitFO).click();
	}
	catch(Exception e){
		System.out.println(e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
		
	}
	}
	
	public static boolean eSignAgrDocuments(String url){
			boolean flag = false;
			MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			Methodid = Long.toString(Thread.currentThread().getId());
			try {
				WebDriverWait wait = new WebDriverWait(Common_Property.driver, 60);
				Common_Property.driver.get(url);
				Common_Property.driver.findElement(POM_Repository.IK_Chk_ESign).click();
				wait.until(ExpectedConditions.visibilityOf(Common_Property.driver.findElement(POM_Repository.IK_Btn_Proceed)));
		    	Common_Property.driver.findElement(POM_Repository.IK_Btn_Proceed).click();
		    	wait.until(ExpectedConditions.visibilityOf(Common_Property.driver.findElement(POM_Repository.IK_Chk_AgrSign)));
		    	Common_Property.driver.findElement(POM_Repository.IK_Chk_AgrSign).click();
		    	Common_Property.driver.findElement(POM_Repository.IK_Chk_WarrantySign).click();
		    	wait.until(ExpectedConditions.visibilityOf(Common_Property.driver.findElement(POM_Repository.IK_Btn_Submit)));
		    	Common_Property.driver.findElement(POM_Repository.IK_Btn_Submit).click();
		    	wait.until(ExpectedConditions.visibilityOf(Common_Property.driver.findElement(POM_Repository.IK_Btn_Next)));
		    	Common_Property.driver.findElement(POM_Repository.IK_Btn_Next).click();
		    	wait.until(ExpectedConditions.visibilityOf(Common_Property.driver.findElement(POM_Repository.IK_Btn_Confirm)));
		    	flag = Common_Property.driver.findElement(POM_Repository.IK_Btn_Confirm).isDisplayed();
		    
			}
        catch (Exception e) {
				System.out.println("The exception was: "+e);
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
			}
			return flag;
	    	
		}
	
	public static String frontofficeApprove(String agrNum) throws  Exception
		{	
			MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			Methodid = Long.toString(Thread.currentThread().getId());
			String agrStatus = "";
			try
			{
				
				Common_Property.driver.findElement(POM_Repository.FO_AgreementNumber).sendKeys(agrNum);
				Common_Property.driver.findElement(POM_Repository.FO_SubmitAgreement).click();
				Common_Property.driver.findElement(POM_Repository.FO_AgreementLink).click();
				Common_Property.driver.findElement(POM_Repository.FO_Approvebutton).click();
				Common_Property.driver.findElement(POM_Repository.FO_Clickapprovebutton).click();
				agrStatus=Common_Property.driver.findElement(POM_Repository.FO_Agrapprovestatus).getText().toString();
				
			}	    
			
			catch (Exception e) 
			{   
				System.out.println("The exception was: "+e);	
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
			}
			return agrStatus;
	    }
	
	
}

