package Provident;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;



public class ProvidentAPI extends Driver
{
	
    static String Applicationknownvalue;
	public static String ApplicationValue;
	static String ApplicationBankValue;
	static String ApplicationCardValue;
	static String ApplicationESignatureValue;
	static String UpdateAgreementValue;
	static String personID=null;
	public static String agreementno;
	static String bankstatus;
	static String Cardstatus;
	static String Esignstatus;
	static String Updateagr1,Updateagr2;
	static String  vp;	
	public static int sheetflag;
	
	
	public static void Launch_API_Url() throws IOException, InterruptedException, FilloException{
		
		 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		Common_Property.driver.get(Configuration.ProvAPI);
		Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title=Common_Property.driver.findElement(By.xpath("//html/body/h1")).getText().toString();
		System.out.println(title);
		
		
	if(title.equalsIgnoreCase("Provident Satsuma API"))
	{
		Utilities.ExtentPassReport(MethodName);
		
	}
	else
	{
		String Desc="Provident Satsuma has not logged in";
		Utilities.ExtentFailReport1(MethodName,Desc);
	}
	}
	
	
	public static void APILogin() throws Exception
	{
		Driver.sheetflag=true;
		Common_Property.driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Driver.getData("API_Username"));
		Driver.sheetflag=true;
		Common_Property.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Driver.getData("API_Password"));
		Common_Property.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Utilities.ExtentPassReport(MethodName);
	}
	
	
	public static void Get_XML_Source_Url()
	{
	
		
		
		try
		{		
	 
			String mainsource = Common_Property.driver.getPageSource().toString();
	   Applicationknownvalue= splitURL(mainsource, "<ApplicantKnown>","</ApplicantKnown>");
	    System.out.print(Applicationknownvalue);
	 
	   ApplicationValue= splitURL(mainsource, "<Application>","</Application>");	
	    System.out.print(ApplicationValue);
	 
	   ApplicationBankValue= splitURL(mainsource, "<ApplicationBank>","</ApplicationBank>");
	    System.out.print(ApplicationBankValue);
	 
	   ApplicationCardValue= splitURL(mainsource, "<ApplicationCard>","</ApplicationCard>");
	    System.out.print(ApplicationCardValue);
	 
	   ApplicationESignatureValue= splitURL(mainsource, "<ApplicationESignature>","</ApplicationESignature>");
        System.out.print(ApplicationESignatureValue);
	 
       UpdateAgreementValue= splitURL(mainsource, "<UpdateAgreementDecision>","</UpdateAgreementDecision>");
        System.out.print(UpdateAgreementValue);
	 
		}
		catch (Exception e) 
		{			
			System.out.println(e);
		}
	
	
	}

	public static String splitURL(String source, String start, String end)
	{
		
		String App=null;
		try
		{
		String[] parse = source.split(start);
		String stringparse = parse[1];
		String[] newparse = stringparse.split(end);
		App = newparse[0];
			  
		}
		
		catch (Exception e) 
			{			
				System.out.println(e);
			}
		return App;
		
	}
	
	
	public static void Application_Known() throws Exception
	{		
		
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart=dateFormat.format(sdate);
		
		 try
		 {
		Common_Property.driver.get("https://provsys.pancredit.com/" + Applicationknownvalue);	 			
		Thread.sleep(2000);	
		Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("XMLData"));
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
		String mainsource2 = Common_Property.driver.getPageSource().toString();
		personID= splitURL(mainsource2, "<PersonID>","</PersonID>");
		System.out.println(personID);
		
		

		if(personID!=null) 
	    {
			Utilities.ExtentPassReport(methodname);
			
			String Desc="Person ID is Created Successfully "+personID;		 
        
	    }
	 	else
	 	{
	 		
	 		String Desc="Person ID creation was Unsuccessful";
	 		Utilities.ExtentFailReport1(methodname,Desc);

	 	}
	 
	 
	 
	    }
		catch (Exception e) 
		{
		
			System.out.println("The exception was "+e);
			System.out.println("Abnormal Termination due to "+e);
			String Exce=e.toString();
			String report="Exception "+Exce.substring(0,87);
			String Desc="Test Run of"+methodname+"was not completed Sucessfully";
		}
		
		
	}
	

	 public static void Application(Recordset Rec) throws Exception
		
		{	
	    	
	    	
	    	 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
	     	 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			 Date sdate = new Date();
			 String datetimestart=dateFormat.format(sdate);
			
	    
			 try
			 {

			String appURL="https://provsys.pancredit.com/" + ApplicationValue;
			String url=appURL.replace("PERSONID", personID);
			Common_Property.driver.get(url);	 			
			Thread.sleep(1000);    	
	    	Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("XMLData2"));
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
			Thread.sleep(8000);
			String mainsource3 = Common_Property.driver.getPageSource().toString();
			agreementno= splitURL(mainsource3, "<AgreementNumber>","</AgreementNumber>");
			System.out.println(agreementno);
			
			if(agreementno!=null) 
			 {
				Utilities.ExtentPassReport(methodname);
				
			 String Desc="Agreement is Created Successfully "+agreementno;	
			 Agreement_Store.Store_Data(WhichClient, agreementno, "", Rec);
			 
		        
             }
			else
			 {
						
			    String Desc="Agreement creation was Unsuccessful";
			    Utilities.ExtentFailReport1(methodname,Desc);
			 }
			 
			}
			catch (Exception e) 
			{
					System.out.println("The exception was "+e);
					System.out.println("Abnormal Termination due to "+e);
					String Exce=e.toString();
					String report="Exception "+Exce.substring(0,87);
					
					String Desc="Test Run of"+methodname+"was not completed Sucessfully";
			}
				
	}

	 public static void Launch_ApplicationBank() throws Exception
	   {
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId()); 
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
   	    DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
	    Date sdate = new Date();
	    String datetimestart=dateFormat.format(sdate);	
	 
	    try
		{
		
		
			String URL2="https://provsys.pancredit.com/" + ApplicationBankValue;
			agreementno=Driver.getData("Agreement_Number").toString();
		     String Bankurl=URL2.replace("AGREEMENTNUMBER", agreementno);
			Common_Property.driver.get(Bankurl);	 			
			Thread.sleep(1500);
			Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("ApplicationBank_xml"));
			Thread.sleep(1000);
			 vp=(Common_Property.driver.findElement(By.xpath("/html/body/h1")).getText().toString());
			Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
			
			if(vp.equals("Provident API"))
			 {
				Utilities.ExtentPassReport(methodname);
				
		   		String Desc="Application bank launched Successfully";		 
			 }
			else
			 { 
				   
			 		String Desc="Application bank launch was Unsuccessfully";
			 		 Utilities.ExtentFailReport1(methodname,Desc);
			 }
		     }
		    catch (Exception e)
		    {
				
				String Desc="Test Run of"+methodname+"was not completed Sucessfully";
		    }
		
	}
	

	 public static void Launch_ApplicationCard() throws Exception
	   {
		
			System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			Date sdate = new Date();
			String datetimestart=dateFormat.format(sdate);			
		
		
		try
		{
		    String URL3="https://provsys.pancredit.com/" + ApplicationCardValue;
		    agreementno=Driver.getData("Agreement_Number").toString();
		    String Cardurl=URL3.replace("AGREEMENTNUMBER", agreementno);
			Common_Property.driver.get(Cardurl);	 			
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("ApplicationCard_xml"));
			Thread.sleep(1000);
			vp=(Common_Property.driver.findElement(By.xpath("/html/body/h1")).getText().toString());
			Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
	 
			if(vp.equals("Provident API"))
			 {
				Utilities.ExtentPassReport(methodname);
				
		   			String Desc="Application Card launched Successfully";		 
			 }
			else
			 {
				   
			 		String Desc="Application Card launch was Unsuccessfully";
			 		Utilities.ExtentFailReport1(methodname,Desc);
			 }	 
			 
		}
		catch (Exception e) 
		{
			
			System.out.println("The exception was "+e);
			System.out.println("Abnormal Termination due to "+e);
			String Exce=e.toString();
			String report="Exception "+Exce.substring(0,87);
			String Desc="Test Run of"+methodname+"was not completed Sucessfully";
		 }
		
	 }
	
	 public static void Launch_Esignature() throws Exception
	   {
			System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			Date sdate = new Date();
			String datetimestart=dateFormat.format(sdate);
			
		try
		{
			String URL4="https://provsys.pancredit.com/" + ApplicationESignatureValue;
			agreementno=Driver.getData("Agreement_Number").toString();
		    String eSignurl=URL4.replace("AGREEMENTNUMBER", agreementno);
			Common_Property.driver.get(eSignurl);	 			
			Thread.sleep(2000);
      		Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("Esignature_xml"));
			Thread.sleep(1000);
			vp=(Common_Property.driver.findElement(By.xpath("/html/body/h1")).getText().toString());
			Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
	
			
		if(vp.equals("Provident API"))
			 {
			     Utilities.ExtentPassReport(methodname);
			     
				 String Desc="ESignature Verified Successfully";		 
			       
		   	 }
		else
			 {
			      
			 		String Desc="ESignature Verification was unsuccessfully";
			 		 Utilities.ExtentFailReport1(methodname,Desc);
			 }		 
			 
			 
		
		
		}
		catch (Exception e) 
		{
            System.out.println("The exception was "+e);
			System.out.println("Abnormal Termination due to "+e);
			String Exce=e.toString();
			String report="Exception "+Exce.substring(0,87);
			String Desc="Test Run of"+methodname+"was not completed Sucessfully";
		}
	}
	
	 public static void Launch_updatestatus() throws Exception
	   {
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart=dateFormat.format(sdate);		
		try
		{
		    String URL5="https://provsys.pancredit.com/" + UpdateAgreementValue;
		    agreementno=Driver.getData("Agreement_Number").toString();
		    String Updateurl=URL5.replace("AGREEMENTNUMBER",getData("Agreement_Number"));
			Common_Property.driver.get(Updateurl);	 			
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("updatestatus_xml"));
			Thread.sleep(1000);
			vp=(Common_Property.driver.findElement(By.xpath("/html/body/h1")).getText().toString());
			Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		if(vp.equals("Provident API"))
			 {
			        Utilities.ExtentPassReport(methodname);
			        
					String Desc="Updation Successfully Done";		 
			 }
		else
			{
			       
			 		String Desc="Updation was unsuccessfully";
			 		Utilities.ExtentFailReport1(methodname,Desc);
			}		 
		}
		catch (Exception e) 
		{   
		System.out.println("The exception was "+e);
		System.out.println("Abnormal Termination due to "+e);
		String Exce=e.toString();
		String report="Exception "+Exce.substring(0,87);
		String Desc="Test Run of"+methodname+"was not completed Sucessfully";
			   	      
	   	}
	   
	   }	

	 public static void Launch_updatestatus_Batch() throws Exception
	   {
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart=dateFormat.format(sdate);	
		
		try{
		    String URL5="https://provsys.pancredit.com/" + UpdateAgreementValue;
		    String Updateurl=URL5.replace("AGREEMENTNUMBER", Driver.getData("Agreement_Number"));
			Common_Property.driver.get(Updateurl);	 			
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//textarea[@name='xml']")).sendKeys(Driver.getData("updatestatus_xml"));
			Thread.sleep(1000);
			vp=(Common_Property.driver.findElement(By.xpath("/html/body/h1")).getText().toString());
			Common_Property.driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		if(vp.equals("Provident API"))
			 {
			        Utilities.ExtentPassReport(methodname);
			        
					String Desc="Updation Successfully Done";		 
			 }
		else
			 {
			       
			 		String Desc="Updation was unsuccessfully";
			 		Utilities.ExtentFailReport1(methodname,Desc);
			 }		 
			 
	  }
		catch (Exception e) 
		{  
        
		System.out.println("The exception was "+e);
		System.out.println("Abnormal Termination due to "+e);
		String Exce=e.toString();
		String report="Exception "+Exce.substring(0,87);
		String Desc="Test Run of"+methodname+"was not completed Sucessfully";
		
	   }		

	   }
	 

	 public static void Bank_Status()  throws Exception
		{
			
			
			 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
			 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			 Date sdate = new Date();
			 String datetimestart=dateFormat.format(sdate);	
				
	try
	{	
				
			String mainsource4 = Common_Property.driver.getPageSource().toString();
			bankstatus= splitURL(mainsource4, "<ApplicationDecisionDescription>","</ApplicationDecisionDescription>");
			System.out.println(bankstatus);
			
			
			if(bankstatus.equals(Driver.getData("Bank_Status"))) 
			 {
		   		
				Utilities.ExtentPassReport(methodname);
				
				String Desc="Bank Status verified Successfully";		 
		         
			 }
			else
			 {
				  
			 		String Desc="Bank Status verification failed";
			 		Utilities.ExtentFailReport1(methodname,Desc);
			 }
			 
	}
   catch (Exception e)
	{
									
			System.out.println("The exception was "+e);
			System.out.println("Abnormal Termination due to "+e);
			String Exce=e.toString();
			String report="Exception "+Exce.substring(0,87);
			String Desc="Test Run of"+methodname+"was not completed Sucessfully";
									

   }
		
}

	 public static void AppCard_Status() throws Exception
		{
			
			 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
	     	 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			 Date sdate = new Date();
			 String datetimestart=dateFormat.format(sdate);	
	 try
	 {
				
			String mainsource5 = Common_Property.driver.getPageSource().toString();
			Cardstatus= splitURL(mainsource5, "<ApplicationDecisionDescription>","</ApplicationDecisionDescription>");
			System.out.println(Cardstatus);
			
	if(Cardstatus.equals(Driver.getData("Card_Status"))) 
	{
		Utilities.ExtentPassReport(methodname);
		
	    String Desc="Card Status verified Successfully";		 
    }
	else
	{
		
	    String Desc="Card Status verification failed";
	    Utilities.ExtentFailReport1(methodname,Desc);
			 		
	}
			 
					
	}
	 catch (Exception e) 
	 {
			
			System.out.println("The exception was "+e);
			System.out.println("Abnormal Termination due to "+e);
			String Exce=e.toString();
			String report="Exception "+Exce.substring(0,87);
			String Desc="Test Run of"+methodname+"was not completed Sucessfully";
	 }
}
	

	 public static void E_Signature_Status() throws Exception
		{
			
			 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
	     	 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			 Date sdate = new Date();
			 String datetimestart=dateFormat.format(sdate);
			 Thread.sleep(2000);
			 
	try
	{	
		      	String mainsource5 = Common_Property.driver.getPageSource().toString();
		    	Esignstatus= splitURL(mainsource5, "<ESignatureRecorded>","</ESignatureRecorded>");
		    	System.out.println(Esignstatus);
		        Thread.sleep(2000);	   
	if(Esignstatus.equalsIgnoreCase(Driver.getData("Esignstatus_Status"))) 
			 {
		       Utilities.ExtentPassReport(methodname);
		       
		     }
   else		 		
			 {
	         String Desc="Esignature status is not equal to as Expected ";
	         Utilities.ExtentFailReport1(methodname,Desc);
			 }
			
			
			 
	}
	catch (Exception e) 
	{

				
				System.out.println("The exception was "+e);
				System.out.println("Abnormal Termination due to "+e);
				String Exce=e.toString();
				String report="Exception "+Exce.substring(0,87);
				
				String Desc="Test Run of"+methodname+"was not completed Sucessfully";
				
			
	}	
	}
	 
	

	 public static void UpdateAgreement_Status() throws Exception
		{
			 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
			 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
			 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
			 Methodid = Long.toString(Thread.currentThread().getId());
	    	 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			 Date sdate = new Date();
			 String datetimestart=dateFormat.format(sdate);
			
			
		try
		{
		String mainsource5 = Common_Property.driver.getPageSource().toString();
		Updateagr1= splitURL(mainsource5, "<PrimaryStatusDescription>","</PrimaryStatusDescription>");
		System.out.println(Updateagr1);
		Thread.sleep(3500);
		if(Driver.getData("Updateagr1").equalsIgnoreCase("Rejected"))
		{
			Utilities.ExtentPassReport(methodname); 
			
		if(Updateagr1.equals(Driver.getData("Updateagr1"))) 
		{
			Utilities.ExtentPassReport(methodname); 			 		
		}
		
		}
		else
		{
		Updateagr2= splitURL(mainsource5, "<SecondaryStatusDescription>","</SecondaryStatusDescription>");
		System.out.println(Updateagr2);
		if(Updateagr1.equals(Driver.getData("Updateagr1")) && Updateagr2.equals(Driver.getData("Updateagr2"))) 
		{
			Utilities.ExtentPassReport(methodname);
			
	    }
		else		 		
		{
			String Desc="Updating Agreement is not done as expected";
			Utilities.ExtentFailReport1(methodname,Desc);		
		}
				 		
		}
		 }
			catch(Exception e)
			{
				System.out.println(e);
				
			}
	}
	 
	
	@Test
	 public static void BO_Status_check() throws IOException, InterruptedException //AXC-REGR-190
		{	

				System.out.println("Executing: "+Thread.currentThread().getStackTrace()[1].getMethodName());
				String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
				 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
				 Methodid = Long.toString(Thread.currentThread().getId());
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
				Date sdate = new Date();
				String datetimestart=dateFormat.format(sdate);
				
	try
	{
	    Common_Property.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	//NAVIGATION
		Thread.sleep(2250);	
		Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(700);	
		Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
		Thread.sleep(750);
		Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']")).click();

       //MAINTAIN CUSTOMER AGREEMENT

		Common_Property.driver.findElement(By.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']")).sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(700);
		Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']")).click();
		Thread.sleep(2700);
		Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']")).click();
		Thread.sleep(1700);    		
		String ver =Common_Property.driver.findElement(By.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']")).getAttribute("value");
		Thread.sleep(1750); 
		System.out.println(ver);
		if(ver.equalsIgnoreCase(Driver.getData("Documentname")))
		 {
			Utilities.ExtentPassReport(methodname);
			
			 
		 }
		 	else
		 	{
		 		String Desc="Verification of Checking Status is not displayed as Expected";
		 		Utilities.ExtentFailReport1(methodname,Desc);	
		 	}
		 
		 
		 Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
		 Thread.sleep(750);
		 Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']")).click();
		 Thread.sleep(750);
		 Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']")).click();
		 Thread.sleep(1750);
		 
		   

		}catch (Exception e) {
			
		
				}
			}
	
	
	
	}

