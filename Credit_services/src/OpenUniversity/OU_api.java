package OpenUniversity;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import Common_POMs.*;
import IKANO.Ikano;
import groovy.util.ResourceException;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.ValidatableResponse;

public class OU_api extends Driver   {
	
	public static String agrNum,eSignUrl,decisionCode,emailId,pinum;
	
	

public static void OU_api1() throws Exception,InterruptedException
	{
	System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
	Methodid = Long.toString(Thread.currentThread().getId());
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
	Date sdate = new Date();
	String datetimestart = dateFormat.format(sdate);
	
	try{
		Configuration.updatePropertyFile(Methodid,MethodName,"True");
		sheetflag=true;
		String url = recordset.getField("API_url");
		String xmlData = recordset1.getField("XMLData");
		//int count = Integer.parseInt(recordSet.getField("COUNT"));
		agrGenerator(xmlData,url);
		
	}
	catch(Exception e){
		
		Utilities.ExtentFailReport(MethodName, e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
		
	}
		
		
	}

public static void OU_api2() throws Exception,InterruptedException
{
System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
Methodid = Long.toString(Thread.currentThread().getId());
DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
Date sdate = new Date();
String datetimestart = dateFormat.format(sdate);

try{
	Configuration.updatePropertyFile(Methodid,MethodName,"True");
	sheetflag=true;
	String url = recordset.getField("API1_url");
	String xmlData = recordset1.getField("XMLData2");
	
	//int count = Integer.parseInt(recordSet.getField("COUNT"));
	String responseData = execute("text/xml", xmlData, url);
	System.out.println(responseData);
	XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.Fault");
	String status = xml.getString("faultstring");
	
	 if (status.equalsIgnoreCase("Internal server error: Forename must be supplied.")) {
			System.out.println("Status has displaying as expected "+status);
			Utilities.ExtentPassReport("PI Forename should not be null");
	 }
	 else if (status.equalsIgnoreCase("Internal server error: PI must be supplied.")){
	 
		 System.out.println("Status has displaying as expected "+status);
		 Utilities.ExtentPassReport("PI value should not be null");
	 }
	 else if (status.contains("Apprentice details created for student")){
		
		 
		 System.out.println("Status has displaying as expected "+status);
		 Utilities.ExtentPassReport("PI value should not be null");
	 }
	 
	 
	 
	
	//String status = xml.getString("CompletedWithSuccess");
	//agrGenerator(xmlData,url);
	
}
catch(Exception e){
	Configuration.updatePropertyFile(Methodid,MethodName,"False");
	
	Utilities.ExtentFailReport(MethodName, e);
	
	
}
	finally{
		
	}
	
	
}

public static void OU_createStudent() throws Exception,InterruptedException
{
System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
Methodid = Long.toString(Thread.currentThread().getId());
DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
Date sdate = new Date();
String datetimestart = dateFormat.format(sdate);

try{
	Configuration.updatePropertyFile(Methodid,MethodName,"True");
	sheetflag=true;
	String url = recordset.getField("API1_url");
	String xmlData = recordset1.getField("XMLData2");
	
	//int count = Integer.parseInt(recordSet.getField("COUNT"));
	String responseData = execute("text/xml", xmlData, url);
	System.out.println(responseData);
	XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.CreateStudentResponseParameter");
	String status = xml.getString("Response");
	
	 
	  if (status.contains("Apprentice details created for student PI ")){
		
		 
		 System.out.println("Status has displaying as expected :"+ status);
		 Utilities.ExtentPassReport("Without Title able to create the StudentUNL");
	 }
	 
	 
	 
	
	//String status = xml.getString("CompletedWithSuccess");
	//agrGenerator(xmlData,url);
	
}
catch(Exception e){
	Configuration.updatePropertyFile(Methodid,MethodName,"False");
	
	Utilities.ExtentFailReport(MethodName, e);
	
	
}
	
}

public static void OU_api3() throws Exception,InterruptedException
{
System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
Methodid = Long.toString(Thread.currentThread().getId());
DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
Date sdate = new Date();
String datetimestart = dateFormat.format(sdate);

try{
	Configuration.updatePropertyFile(Methodid,MethodName,"True");
	sheetflag=true;
	String url = recordset.getField("API2_url");
	String xmlData = recordset1.getField("XMLData3");
	xmlData = xmlData.replace("Mailid", emailId);
	//int count = Integer.parseInt(recordSet.getField("COUNT"));
	String responseData = execute("text/xml", xmlData, url);
	System.out.println(responseData);
	XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.CreateEmployerAndContactResponseParameter");
	String status = xml.getString("Response");
	
	if(status.contains("Attribute Name not found in parameters to CreateEmployerAndContact")){
		System.out.println("Status has displaying as expected "+status);
		 Utilities.ExtentPassReport(" Company  with reference could not ne created without passing Company name");
	}
	else if(status.contains("Attribute AccountNumber not found in parameters "))
	{
		System.out.println("Status has displaying as expected "+status);
		 Utilities.ExtentPassReport(" Company  with reference could not ne created without passing Account Number");
	}
	
	else if(status.contains("already exists "))
	{
		System.out.println("Status has displaying as expected "+status);
		 Utilities.ExtentPassReport(" passing the exist Account number and details should create new contact");
	}
	
	else if(status.contains("Company Murty Company with reference 9999810887 created. New contact murty  tanuri created"))
	{
		System.out.println("Status has displaying as expected "+status);
		 Utilities.ExtentPassReport(" passing the emaximum lenght of Account number  should create reference");
	}
	
	
	
}
catch(Exception e){
	
	Utilities.ExtentFailReport(MethodName, e);
	Configuration.updatePropertyFile(Methodid,MethodName,"True");
	
}
	
	
	
}
	
public static void agrGenerator(String strXmlData,String strUrl) throws Exception{
		
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try
		{
			Configuration.updatePropertyFile(Methodid,MethodName,"True");
		    String xmlData=strXmlData, responseData="", updateQuery="", agrNum="", studentUrl="";
			String xmlData1=strXmlData;
			boolean flag = true;
			DateFormat df = new SimpleDateFormat("dMyyHms");
			DateFormat df1 = new SimpleDateFormat("dMHms");
			Date date = new Date();
			String uniqueKey = df1.format(date);
			emailId = "fmail"+uniqueKey+"@googly.com";
			pinum = uniqueKey;
			
			xmlData = xmlData.replace("Mailid", emailId);
			xmlData = xmlData.replace("Pinum", pinum);
		
			for (int j = 11; j <=24; j++) {
				String variable = WordUtils.capitalize(Driver.recordset1.getField(j).name().toLowerCase());
				if (xmlData.contains(variable)) {
					String value =recordset1.getField(j).value();
					//System.out.println(variable+": "+value);
					xmlData =  xmlData.replace(variable, value);
		       	 	
				}
			}
			System.out.println(xmlData);
			responseData = execute("text/xml", xmlData, strUrl);
			System.out.println(responseData);
			XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.CreateProposalResponseParameter");
			//Get the value by giving the node name
			String status = xml.getString("CompletedWithSuccess");
						
		    if (status.equalsIgnoreCase("true")) {
				agrNum = xml.getString("AgreementNumber");
			    studentUrl = xml.getString("LoanApplicationURL");
			    System.out.println(studentUrl);
			    System.out.println(agrNum);
			    
			    Agreement_Store.Store_Data(WhichClient,agrNum,studentUrl,recordset1);
			    Driver.refreshSheet1(OpenUniversity.bindingvalue,OpenUniversity.OU_recordset1);
			    System.out.println(recordset1.getField("Misc"));
			    
			    Utilities.ExtentPassReport(MethodName);
			}
		    else{
		    	Configuration.updatePropertyFile(Methodid,MethodName,"True");
		    	updateQuery = "Agreement Creation in API has Failed";
		    }
		}
		catch (Exception e) {
			Configuration.updatePropertyFile(Methodid,MethodName,"True");
            String updateQuery = "Agreement Creation in API has Failed";
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + MethodName + "was not completed Sucessfully";
			Utilities.ExtentFailReport(updateQuery, e);

		}
		
		    
		}
	
public static String execute(String strContentType, String xml_data, String str_url) throws IOException, FilloException, InterruptedException{
	ValidatableResponse response =null;
	MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Methodid = Long.toString(Thread.currentThread().getId());
	Configuration.updatePropertyFile(Methodid,MethodName,"True");
	try
	{
	         response = RestAssured.given()
			.contentType(strContentType)
	        .body(xml_data)
	        .when()
	        .post(str_url)
	        .then();
	
	
	}
	
	catch(Exception e){
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
		Utilities.ExtentFailReport("Api Agreement Creation has Failed", e);
		
	}
	return response.extract().body().asString();
}

public static void ouStudentPortalLogin(Recordset recordset, String Stundentportalurl) throws  Exception
{       
	    System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
	
	try
	{  
		Configuration.updatePropertyFile(Methodid,MethodName,"True");
		Driver.refreshSheet1(OpenUniversity.bindingvalue,OpenUniversity.OU_recordset1);
		System.out.println(Stundentportalurl);
		Common_Property.driver.get(Stundentportalurl);	
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_continuebutton).click();	
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Password).sendKeys(recordset.getField("Pasword"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Confirmpaswd).sendKeys(recordset.getField("Confirmpaswd"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_submitlogin).click();
		Thread.sleep(250);
		if(Common_Property.driver.findElement(POM_Repository.OU_Studentporatl_continueapplicationbutton).isDisplayed()){
			Utilities.ExtentPassReport(MethodName);
		}
	}			    	   
	catch (Exception e) 	
	{   
		
		Utilities.ExtentFailReport(MethodName, e);
		System.out.println("The exception was "+e);		
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
	}
	
}

public static void ouStudentPortal (Recordset recordset) throws  Exception
{   
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
	try
	{
		Configuration.updatePropertyFile(Methodid,MethodName,"True");
		Common_Property.driver.findElement(POM_Repository.OU_Studentporatl_continueapplicationbutton).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentporatl_continueapplicationbutton).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentporatl_UKaddresslink).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Propertynumber).sendKeys(recordset.getField("Searchpropernum"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Postcode).sendKeys(recordset.getField("Searchpostcode"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Searchbutton).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressnotfounlink).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addresspostcode).sendKeys(recordset.getField("Adrspostcode"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressflatnum).sendKeys(recordset.getField("AdrsFlatnum"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addresspropertynum).sendKeys(recordset.getField("Adrspropertynum"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addresspropertyname).sendKeys(recordset.getField("Adrspropertyname"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressstreetname).sendKeys(recordset.getField("AdrsStreetname"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressdistrict).sendKeys(recordset.getField("Adrsdistrict"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addresspostaltown).sendKeys(recordset.getField("AdrsPostaltown"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressflatcounty).sendKeys(recordset.getField("AdrsCounty"));
		Thread.sleep(250);
		Select select = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressday));
		select.selectByValue(recordset.getField("OUday"));
		Thread.sleep(150);
		Select select1 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Addressmonth));
		select1.selectByValue(recordset.getField("OuMonth"));
		Thread.sleep(150);
		Select select2 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_AddressYear));
		select2.selectByValue(recordset.getField("Ouyear"));
		Thread.sleep(150);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Continuebutton).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Continuelink).click();
		Thread.sleep(250);
		
		//financialpage
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Checkbox).click();
		Thread.sleep(250);
		
		Select select3 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Empoccupancy));
		select3.selectByValue(recordset.getField("Empoccupation1"));
		Thread.sleep(250);
		
		Select select4 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Empstatus));
		select4.selectByValue(recordset.getField("Empoccstatus"));
		Thread.sleep(250);
		
		
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Emppaymethod).click();
		Thread.sleep(250);
		
		//income
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Annualincome).sendKeys(recordset.getField("Iannnualincome"));
		Thread.sleep(250);
		Common_Property.driver.findElement(By.name("monthlyIncome")).sendKeys(recordset.getField("Imonthlyincome"));
		Thread.sleep(250);
		Common_Property.driver.findElement(By.name("dividendsReceived")).sendKeys(recordset.getField("Idividend"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Benefit).sendKeys(recordset.getField("Ibenefitreceived"));
		Thread.sleep(250);
		Common_Property.driver.findElement(By.name("rentReceived")).sendKeys(recordset.getField("Irentreceived"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Maintenance).sendKeys(recordset.getField("Imaintenancereceived"));
		Thread.sleep(250);
		//String Totalmonthincome=Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Totalincome).getText().toString();
		//System.out.println(Totalmonthincome);
		
		//expenditure
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Creditcard).sendKeys(recordset.getField("Ecreditcard"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Loans).sendKeys(recordset.getField("Eloans"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Counciltax).sendKeys(recordset.getField("Ecounciltax"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Utilities).sendKeys(recordset.getField("Eutilities"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Mortgage).sendKeys(recordset.getField("Emortgage"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Noofdependants).clear();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Noofdependants).sendKeys(recordset.getField("Enoofdependants"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Noofadults).clear();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Noofadults).sendKeys(recordset.getField("Enoofadults"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Savebutton).click();
		Thread.sleep(250);
								
		//employment
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeename).sendKeys(recordset.getField("Employeename"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeetelephone).sendKeys(recordset.getField("Emptelephonenumber"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeepropertynumber).sendKeys(recordset.getField("Emppropertynumber"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeestreetname).sendKeys(recordset.getField("Empstreetname"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeedistrict).sendKeys(recordset.getField("Empdistrict"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeeposttown).sendKeys(recordset.getField("Emppostaltown"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeepostcode).sendKeys(recordset.getField("Emppostcode"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeecounty).sendKeys(recordset.getField("Empcounty"));
		Thread.sleep(250);			
		Select select5 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeecountry));
		select5.selectByValue(recordset.getField("Empcounty1"));
		Thread.sleep(250);			
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeeyear).sendKeys(recordset.getField("Noofyears"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeemonth).sendKeys(recordset.getField("Noofmonths"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeeoccupation).sendKeys(recordset.getField("Empoccupation"));
		Thread.sleep(250);
		Select select6 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeepositionid));
		select6.selectByValue(recordset.getField("EmpPosition"));
		Thread.sleep(250);			
		Select select7 = new Select (Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeesectorid));
		select7.selectByValue(recordset.getField("Empsectionid"));
		Thread.sleep(1250);			
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Employeesave).click();
		Thread.sleep(2250);
		ou_cpacardpayment();
		JavascriptExecutor scroll1 = (JavascriptExecutor)Common_Property.driver;
		scroll1.executeScript("window.scrollBy(0,25000)", "");
		
					
		//directdebit
		/*Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Banksortcode).sendKeys(recordset.getField("Banksortcode"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Search).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Banknamelink1).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Bankaccountname).sendKeys(recordset.getField("Bankaccountname"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Bankaccountnumber).sendKeys(recordset.getField("Bankaccountnumber"));
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Onesignature).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Directdebitsave).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_Directdebitcontinue).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_DDconitue).click();
		Thread.sleep(250);*/
					
		//Common_Property.driver.findElement(POM_Repository.OU_Studentportal_DDContinuewithapplink).click();
		Thread.sleep(250);
		/***SECCI**** needs to display*******/
		Utilities.ExtentPassReport("SECCI details have read and continue the next page ");
		Common_Property.driver.findElement(POM_Repository.OU_Studentportal_DDContinuewithapplink).click();
		Thread.sleep(2500);
		Utilities.ExtentPassReport("Agreement decession pas Displayed below");
		/***Application successful  Page** needs to display*******/
		Common_Property.driver.findElement(POM_Repository.OU_Student_Checkbox).click();
		Thread.sleep(250);
		JavascriptExecutor scroll2 = (JavascriptExecutor)Common_Property.driver;
		scroll2.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3050);
		Utilities.ExtentPassReport("Agreement Accepting pas Displayed below");
		Common_Property.driver.findElement(POM_Repository.OU_Student_Accept).click();
		Thread.sleep(3500);
		/*String OUrefststus=Common_Property.driver.findElement(By.xpath("//*[@id='ou-content']/h1")).getText().toString();
        Thread.sleep(250);
            if(OUrefststus.contains("Referred"))
            {    
            
            	Utilities.ExtentPassReport(MethodName);
            	Common_Property.driver.findElement(By.linkText("Finish")).click();
            	OU_frontoffice.OU_Frontoffice_Approve();
            }
            else
            {
            	Configuration.updatePropertyFile(Methodid,MethodName,"False");
            	Utilities.ExtentFailReport1(MethodName,"Failed");
            	Common_Property.driver.findElement(By.xpath("//a[@href= '/ousbaStudentNb/accepted-notify-error-close.action']")).click();
            }
            */
            
        
        Thread.sleep(250);
		
	}			    
	catch (Exception e) 
	{   
		Utilities.ExtentFailReport(MethodName, e);
		System.out.println("The exception was "+e);	   	
		Configuration.updatePropertyFile(Methodid,MethodName,"False");     
	}
				
}

public static void ouStaffLogin() throws  Exception
{   
	
	System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Methodid = Long.toString(Thread.currentThread().getId());
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
	Date sdate = new Date();
	String datetimestart = dateFormat.format(sdate);
	try{
	Configuration.updatePropertyFile(Methodid,MethodName,"True");
	Common_Property.driver.get("https://ouint.pancredit.com/ousbaStaff/");
	Thread.sleep(2500);
	Common_Property.driver.findElement(POM_Repository.OU_Staffcontinuelink).click();
	Thread.sleep(250);
	Common_Property.driver.findElement(POM_Repository.OU_Usernamestaff).sendKeys("ouadmin");
	Thread.sleep(250);
	Common_Property.driver.findElement(POM_Repository.OU_Passwordstaff).sendKeys("ouadmin");
	Thread.sleep(250);
	Utilities.ExtentPassReport(MethodName);
	Common_Property.driver.findElement(POM_Repository.OU_Submitlogin).click();
	Thread.sleep(250);
	}
	catch(Exception e){
		Utilities.ExtentFailReport(MethodName, e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
	}
	
}

public static void ouStaffPortal(Recordset recordset, String PiNum) throws  Exception
{       
	    System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	    MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);			
	try
	{
		Configuration.updatePropertyFile(Methodid,MethodName,"True");
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Pinumber).sendKeys(pinum);
		Thread.sleep(250);
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Seacrhbutton).click();
		Thread.sleep(1250);
		//input[@id="search-save_search"]
		Common_Property.driver.findElement(Pom_Openuniversity.OUStaff_PIdetails).click();
        Thread.sleep(250);
		String Acceptstatus=Common_Property.driver.findElement(POM_Repository.OU_Staff_Agrstatus).getText().toString();
		Thread.sleep(250);
		System.out.println(Acceptstatus);
		Thread.sleep(200);
		if(Acceptstatus.equalsIgnoreCase("Active")){
			Thread.sleep(200);
			Utilities.ExtentPassReport("Agreement Activated successfully");
		}
		else{
			
			Utilities.ExtentFailReport1("Agreement activation"," Failed");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
		/*Common_Property.driver.findElement(POM_Repository.OU_Staff_Agreementlink).click();
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Continueapplicationbutton).click();
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Continueapplicationbutton).click();			
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Checkbox).click();
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Save).click();
		
		Common_Property.driver.findElement(POM_Repository.OU_Staffportal_finishbutton).click();
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Pinumber).sendKeys(PiNum);
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Seacrhbutton).click();
		Common_Property.driver.findElement(POM_Repository.OU_Staff_PIdetails).click();
		String ActiveStatus=Common_Property.driver.findElement(POM_Repository.OU_Staff_Agrstatus).getText().toString();
		System.out.println(ActiveStatus);
		Common_Property.driver.findElement(POM_Repository.OU_Staff_Agreementlink).click();
		Common_Property.driver.findElement(POM_Repository.OU_Staff_logout).click();*/
	}			    
	catch (Exception e) 
	{   
	
		Utilities.ExtentFailReport(MethodName, e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
		//System.out.println("The exception was "+e);   	      
	}			
}
public static void ou_cpacardpayment() throws  Exception
{       
	    System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	    MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);			
	try
	{
		Configuration.updatePropertyFile(Methodid,MethodName,"True");
		//Common_Property.driver.findElement(By.xpath("//a[@href='/ousbaStudentNb/cpaConcentContinue.action']")).click();
		Thread.sleep(3000);
		Common_Property.driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("5454545454545454");
		Thread.sleep(200);
		Common_Property.driver.findElement(By.xpath("//input[@id='cardholderName']")).sendKeys("Tester");
		Thread.sleep(200);
		Common_Property.driver.findElement(By.xpath("//input[@id='expiryMonth']")).sendKeys("10");
		Thread.sleep(200);
		Common_Property.driver.findElement(By.xpath("//input[@id='expiryYear']")).sendKeys("32");
		Thread.sleep(1200);
		Common_Property.driver.findElement(By.xpath("//input[@id='securityCode']")).sendKeys("123");
		Thread.sleep(2200);
		Common_Property.driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(85000);
		//Common_Property.driver.findElement(By.xpath("//div[text()='Continue']")).click();
		Thread.sleep(200);
		String carddetails=Common_Property.driver.findElement(By.xpath("//p[2]")).getText();
		System.out.println(carddetails);
		
		Thread.sleep(200);
		String totalamount=Common_Property.driver.findElement(By.xpath("//p[3]")).getText();
		System.out.println(totalamount);
		Thread.sleep(200);
		String No_of_instalments=Common_Property.driver.findElement(By.xpath("//p[4]")).getText();
		System.out.println(No_of_instalments);
		Thread.sleep(200);
		String firstpay=Common_Property.driver.findElement(By.xpath("//p[5]")).getText();
		System.out.println(firstpay);
		Thread.sleep(200);
		String adress=Common_Property.driver.findElement(By.xpath("//p[9]")).getText();
		System.out.println(adress);
		System.out.println(recordset1.getField("Cardnumber"));
		System.out.println(recordset1.getField("Amount"));
		System.out.println(recordset1.getField("Installment"));
		if(carddetails.contains(recordset1.getField("Cardnumber")) 
				&&totalamount.contains(recordset1.getField("Amount"))
				&&No_of_instalments.contains(recordset1.getField("Installment")))
		{
			Utilities.ExtentPassReport("Cardnumber,Totalamount,Installment,first payment are displaying as expected ");	
		}
		else{
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
			Utilities.ExtentFailReport1("Cardnumber,Totalamount,Installment,first payment are not displaying as expected so it ", "");
			
		}
		
		Thread.sleep(200);
		JavascriptExecutor scroll = (JavascriptExecutor)Common_Property.driver;
		scroll.executeScript("window.scrollBy(0,2500)", "");
		Thread.sleep(200);
		Utilities.ExtentPassReport("All the card authorised document had read");
		Common_Property.driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Thread.sleep(200);
		JavascriptExecutor scroll1 = (JavascriptExecutor)Common_Property.driver;
		scroll1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(200);
		Utilities.ExtentPassReport("Schedule and payment page has displayed");
		Common_Property.driver.findElement(By.xpath("//a[text()='Continue with application']")).click();
		Thread.sleep(700);
		Utilities.ExtentPassReport("SECCI page has displayed");
		Thread.sleep(200);
	}
	catch (Exception e) 
	{   
		Utilities.ExtentFailReport(MethodName, e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
		//System.out.println("The exception was "+e);   	      
	}

}
}


