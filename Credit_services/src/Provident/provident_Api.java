package Provident;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.commons.lang3.text.WordUtils;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import OpenUniversity.OpenUniversity;
import io.restassured.response.ValidatableResponse;

  public class provident_Api extends Driver{
	
	public static String applicationKnownvalue,applicationValue,applicationBankValue, applicationCardValue;
	public static String applicationESignatureValue,updateAgreementValue, responseData, contentType = "text/xml";
	public static String xmlData1, xmlData2, xmlData3, xmlData4, xmlData5, xmlData6;
	public static String personId, agrNum,appDecisionCode1, appDecisionCode2, eSignStatus;
	public static String primaryStatus, secondaryStatus, StrUrl, strUsrName, strPassWord;
	
	public static void agrGenerator(Recordset prov_set) throws Exception{
				
		xmlData1=prov_set.getField("XMLData");
		xmlData2=prov_set.getField("XMLData2"); 
		xmlData3=prov_set.getField("ApplicationBank_xml");
		xmlData4=prov_set.getField("ApplicationCard_xml");
		xmlData5=prov_set.getField("Esignature_xml");
		xmlData6=prov_set.getField("updatestatus_xml");
			
			
		boolean flag = true;
				
		//***replace variables with values in parameterised XML
		for (int j = 0; j < prov_set.getFieldNames().size(); j++) {
			String variable = WordUtils.capitalize(prov_set.getField(j).name().toLowerCase());
			
			if (xmlData1.contains(variable)) {
				String value =prov_set.getField(j).value();
				//System.out.println(variable+": "+value);
	       	 	xmlData1 =  xmlData1.replace(variable, value);
	       	 	
			}
			else if (xmlData2.contains(variable)) {
				String value =prov_set.getField(j).value();
				//System.out.println(variable+": "+value);
	       	 	xmlData2 =  xmlData2.replace(variable, value);
	       	 	
	       	 	
			}
			else if (xmlData3.contains(variable)) {
				String value =prov_set.getField(j).value();
				//System.out.println(variable+": "+value);
				xmlData3 =  xmlData3.replace(variable, value);
	       	 	
			}
			else if (xmlData4.contains(variable)) {
				String value =prov_set.getField(j).value();
				//System.out.println(variable+": "+value);
				xmlData4 =  xmlData4.replace(variable, value);
	       	 	
			}
			else if (xmlData5.contains(variable)) {
				String value =prov_set.getField(j).value();
				//System.out.println(variable+": "+value);
				xmlData5 =  xmlData5.replace(variable, value);
	       	 	
			}
			else if (xmlData6.contains(variable)) {
				String value =prov_set.getField(j).value();
				//System.out.println(variable+": "+value);
				xmlData6 =  xmlData6.replace(variable, value);
	       	 	
			}
		}
		
		//System.out.println(xmlData2);
		sheetflag=true;
		StrUrl = recordset.getField("API_url"); 
		sheetflag=true;
		strUsrName = recordset.getField("API_Username");
		sheetflag=true;
		strPassWord = recordset.getField("API_Password");
		responseData = execute(contentType, StrUrl+"/providentSatsumaApi/token/?username="+strUsrName+"&password="+strPassWord);
	
		
		getTokens();
		
		
		 	
	}
	
	public static void get_personID() throws IOException, FilloException, InterruptedException{
		
      responseData = execute(contentType, StrUrl+applicationKnownvalue+"?xml="+xmlData1);
      System.out.println(responseData);
		
		if (responseData.contains("<PersonID>")) {
        	
        	personId = splitValues(responseData, "<PersonID>","</PersonID>");
		}else{
			Utilities.ExtentFailReport1(MethodName, "Person ID not created");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
		
	}
	
	public static void applicationValue(Recordset record2) throws Exception{
		System.out.println("Executing : Agreement Creator");
    	applicationValue = applicationValue.replace("PERSONID", personId);
        
    	System.out.println(applicationValue);
        responseData = execute(contentType, StrUrl+applicationValue+"?xml="+xmlData2);
        System.out.println(responseData);
        //Extract agreement number from response data
        if (responseData.contains("<AgreementNumber>")) {
        	
        	agrNum = splitValues(responseData, "<AgreementNumber>","</AgreementNumber>");
        	 Agreement_Store.Store_Data(WhichClient,agrNum,"",record2);
        	 
			// Driver.refreshSheet1(Provident.bindingvalue);
			 Utilities.ExtentPassReport(MethodName);
		        
		}
        else if (responseData.contains("PreferredRepaymentDayOfTheMonth can only have a value of 1 to 28")){
        
                System.out.println("repayment day of 29th, 30th or 31st is not acceptable while creating Agreement");
                String Desc="repayment day of 29th, 30th or 31st is not acceptable while creating Agreement";
                Utilities.ExtentPassReport(Desc); 
        }
        	else {
        
			Utilities.ExtentFailReport1(MethodName, "Agreement Creation in API has Failed");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
	    	
		}
	}
	
	public static void applicationBankValue(Recordset record2) throws IOException, FilloException, InterruptedException{
		System.out.println("Executing : ApplicationBank");
    	applicationBankValue = applicationBankValue.replace("AGREEMENTNUMBER", agrNum);
        responseData = execute(contentType, StrUrl+applicationBankValue+"?xml="+xmlData3);
        //System.out.println(responseData);
        //Extract application decision code from response data
        if (responseData.contains("<ApplicationDecisionCode>")) {
        	
        	appDecisionCode1 = splitValues(responseData, "<ApplicationDecisionCode>","</ApplicationDecisionCode>");
        	
		}
        else {
			Utilities.ExtentFailReport1(MethodName, "Bank value has not displaying as expected");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
    	}
	}
	
	public static void applicationCardValue(Recordset record2) throws IOException, FilloException, InterruptedException{
		System.out.println("Executing : ApplicationCard");
    	applicationCardValue = applicationCardValue.replace("AGREEMENTNUMBER", agrNum);
        responseData = execute(contentType, StrUrl+applicationCardValue+"?xml="+xmlData4);
        //Extract application decision code from response data
        if (responseData.contains("<ApplicationDecisionCode>")) {
        	appDecisionCode2 = splitValues(responseData, "<ApplicationDecisionCode>","</ApplicationDecisionCode>");
		}
        
		else {
			Utilities.ExtentFailReport1(MethodName, "Bank card value has not displaying as expected");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
    
	}
	public static void applicationESignatureValue(Recordset record2) throws IOException, FilloException, InterruptedException{
		System.out.println("Executing : ApplicationEsign");
    	applicationESignatureValue = applicationESignatureValue.replace("AGREEMENTNUMBER", agrNum);
        responseData = execute(contentType, StrUrl+applicationESignatureValue+"?xml="+xmlData5);
        //Extract ESignatureRecorded from response data
        if (responseData.contains("<ESignatureRecorded>")) {
        	eSignStatus = splitValues(responseData, "<ESignatureRecorded>","</ESignatureRecorded>");
		}
        
		else {
			Utilities.ExtentFailReport1(MethodName, "applicationESignatureValue has not displaying as expected");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");	
		}
	}
	public static void updateAgreementValue(Recordset record2) throws IOException, FilloException, InterruptedException{
		//refreshSheet1(bindingvalue,Prov_recordset1);
		System.out.println("Executing : UpdateStatus");
		//System.out.println(recordset1.getField("Agreement_Number"));
    	updateAgreementValue = updateAgreementValue.replace("AGREEMENTNUMBER",recordset1.getField("Agreement_Number"));
    	responseData = execute(contentType, StrUrl+updateAgreementValue+"?xml="+xmlData6);
       
     
        
        //System.out.println(agrNum);
        //Extract primary and secondary status from response data
        if (responseData.contains("<PrimaryStatusDescription>")) {
        	primaryStatus = splitValues(responseData, "<PrimaryStatusDescription>","</PrimaryStatusDescription>");
        	secondaryStatus = splitValues(responseData, "<SecondaryStatusDescription>","</SecondaryStatusDescription>");
        	System.out.println(primaryStatus);
	      
	       
		}
        
		else {
			
			Utilities.ExtentFailReport1(MethodName, "updateAgreementstatus has not displaying as expected");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");	
		}
       
       //System.out.println(recordset1.getField("Updateagr1")); 
       //System.out.println(recordset1.getField("Updateagr2"));
        if (primaryStatus.equalsIgnoreCase(recordset1.getField("Updateagr1")) && secondaryStatus.equalsIgnoreCase(recordset1.getField("Updateagr2"))) {
        	Utilities.ExtentPassReport("Agreement has successfully created");
		} 
        else if(secondaryStatus.equalsIgnoreCase(recordset1.getField("Updateagr2")) ){
        	System.out.println(secondaryStatus);
			Utilities.ExtentPassReport("Agreement has Referred status");
		}else if(secondaryStatus.equalsIgnoreCase(recordset1.getField("Updateagr2"))){
			System.out.println(secondaryStatus);
			Utilities.ExtentPassReport("Agreement has Declined status");
		}
		 else if(primaryStatus.equalsIgnoreCase(recordset1.getField("Updateagr1")) ){
			    System.out.println(primaryStatus);
				Utilities.ExtentPassReport("Agreement has Referred status");
			}else {
			Utilities.ExtentFailReport1(MethodName, "updateAgreementstatus has not displaying as expected");	
		}
        
	}
	
	public static void getTokens() throws IOException, FilloException, InterruptedException{
		if (responseData.contains("<ApplicantKnown>")) {
        	System.out.println("Executing : PersonID");
			//Extract token values from responseData
			applicationKnownvalue= splitValues(responseData, "<ApplicantKnown>","</ApplicantKnown>");
			applicationValue= splitValues(responseData, "<Application>","</Application>");	
		    applicationBankValue= splitValues(responseData, "<ApplicationBank>","</ApplicationBank>");
		    applicationCardValue= splitValues(responseData, "<ApplicationCard>","</ApplicationCard>");
		    applicationESignatureValue= splitValues(responseData, "<ApplicationESignature>","</ApplicationESignature>");
	        updateAgreementValue= splitValues(responseData, "<UpdateAgreementDecision>","</UpdateAgreementDecision>");
	        			        
	        
		}else {
			Utilities.ExtentFailReport1(MethodName, "Person ID not created");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
	    	
				
		}
	}
	
	public static String execute(String strContentType, String str_url){
		
		ValidatableResponse response = given()
				.contentType(strContentType)
		        .when()
		        .post(str_url)
		        .then();
		
		return response.extract().body().asString();	
	}

	public static String splitValues(String source, String start, String end){
		String[] parse = source.split(start);
		String stringparse = parse[1];
		
		String[] newparse = stringparse.split(end);
		String value = newparse[0];
		
		return value;
	}
	
	
}
	
	
	
