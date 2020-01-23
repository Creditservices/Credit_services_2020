package OpenUniversity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;


public class OU_frontoffice extends Driver
{
	
	//To Approve an agreement through Front office
	public static void OU_Frontoffice_Approve() throws  Exception
    {    	
   
		
		Driver.getTDvalue = 1;	
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Methodid = Long.toString(Thread.currentThread().getId());
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();  
		String datetimestart=dateFormat.format(sdate);		
			
			try
			
			{
				Configuration.updatePropertyFile(Methodid,MethodName,"True");
				//Testdata.GetFiloconnection();
				Common_Property.driver.findElement(Pom_Openuniversity.FO_AgreementNumber).sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1250);
				
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_SubmitAgreement).click();
				Thread.sleep(2250);
				
				String FOstatus=Common_Property.driver.findElement(Pom_Openuniversity.FO_Agreementstatus).getText().toString();
				Thread.sleep(1250);
				if(FOstatus.equalsIgnoreCase("Active")){
					System.out.println("Agreement has Active status");
				}
				else{
					if(FOstatus.contains(Driver.getData("Forefstatus")))
					{
					
					Utilities.ExtentPassReport("Agreement status is in Ou Front office is displayed as "+FOstatus);
					}
					else
					{
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					Utilities.ExtentFailReport1( "Agreement status is in Ou Front office is displayed as ",FOstatus);
					}
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_AgreementLink).click();
				Thread.sleep(250);
				//Approve
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Approvebutton).click();
				Thread.sleep(250);
				//Approvebutton
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Clickapprovebutton).click();
				Thread.sleep(250);
				
				String fostatus=Common_Property.driver.findElement(Pom_Openuniversity.FO_Agrapprovestatus).getText().toString();
				Utilities.ExtentPassReport("After approving front office status is displayed as"+fostatus);
				Thread.sleep(250);
				Driver.getTDvalue = 0;
				}
			}			    
				   
			
			catch (Exception e) 
			{   
			
				String Desc="Test Run of"+MethodName+"was not completed Sucessfully";
				Utilities.ExtentFailReport(Desc, e);
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
					   	      
			}
    				
		

    }
	
	
	public static void OU_Frontoffice_Servicing() throws  Exception
	
    {    	
   
		
		Driver.getTDvalue = 1;
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Methodid = Long.toString(Thread.currentThread().getId());
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();  
		String datetimestart=dateFormat.format(sdate);		
			
			try
			{
				Configuration.updatePropertyFile(Methodid,MethodName,"True");  
				Common_Property.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Common_Property.driver.findElement(Pom_Openuniversity.FO_AgreementNumber).sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(250);
				Common_Property.driver.findElement(Pom_Openuniversity.FO_SubmitAgreement).click();
				Thread.sleep(250);
				String FOstatus=Common_Property.driver.findElement(Pom_Openuniversity.FO_Agreementstatus).getText().toString();
				Thread.sleep(250);
				
				
					if(FOstatus.contains(Driver.getData("Foactivestatus")))
					{
					
					Utilities.ExtentPassReport( "Agreement status is in Ou Front office is displayed as"+FOstatus);
					}
					else
					{
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					Utilities.ExtentFailReport1("Agreement status is in Ou Front office is displayed as"+FOstatus, "It is not not Expected status");
					}
				Common_Property.driver.findElement(Pom_Openuniversity.FO_AgreementLink).click();
				Thread.sleep(250);
				
				//courese details button
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Clickcoursedetailslink).click();
				Thread.sleep(8250);
				//identifier
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Getidentifier).isDisplayed();
				Thread.sleep(1250);
				
				Utilities.ExtentPassReport( "Identifier is displayed ");
				String reference=Common_Property.driver.findElement(Pom_Openuniversity.FO_Getreference).getText().toString();
				Thread.sleep(1250);
				
				String agrnumber=Common_Property.driver.findElement(Pom_Openuniversity.FO_Getagrnumber).getText().toString();
				Thread.sleep(1250);
				
				String strtdate=Common_Property.driver.findElement(Pom_Openuniversity.FO_GetStartdate).getText().toString();
				Thread.sleep(1250);
			
				String enddate=Common_Property.driver.findElement(Pom_Openuniversity.FO_GetEnddate).getText().toString();
				Thread.sleep(1250);
			
				String cost=Common_Property.driver.findElement(Pom_Openuniversity.FO_GetCost).getText().toString();
				Thread.sleep(1250);
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_detailstable).isDisplayed();
				Thread.sleep(1250);
				System.out.println(reference + agrnumber + strtdate + enddate + cost);
				
					if(reference.contains(Driver.getData("Productcode"))
							&&cost.contains(Driver.getData("Loanamount"))
							&&agrnumber.contains(Driver.getData("Agreement_Number"))
							&&strtdate.contains(Driver.getData("Schedulestrtdate"))
							&& enddate.contains(Driver.getData("Scheduleenddate")))
					{
						
					Utilities.ExtentPassReport( "Reference validated as expecetd "+ reference);
					Utilities.ExtentPassReport( "Agreement number is  validated "+ agrnumber);
					Utilities.ExtentPassReport( "Startdate is validated "+ enddate);
					Utilities.ExtentPassReport( "End date is validated "+ enddate);
					Utilities.ExtentPassReport( "Cost is dispalyed as expected "+enddate);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					}
				
					else
					{
						
					Utilities.ExtentFailReport1( "Reference validation failed", reference);
					Utilities.ExtentFailReport1( "Agreement number validation failed", agrnumber);
					Utilities.ExtentFailReport1( "Startdate validation failed", enddate);
					Utilities.ExtentFailReport1( "End date validation failed", enddate);
					Utilities.ExtentFailReport1( "Loan amount displayed incorrectly", enddate);
					}
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_CoursedetailsClosebutton).click();		
				Thread.sleep(2250);
			
				//Due date Changes
				 
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Paymentdatelink).click();		
				Thread.sleep(1250);
				
				
				Select select8 = new Select (Common_Property.driver.findElement(Pom_Openuniversity.FO_Duedatetype));
				select8.selectByValue(Driver.getData("Duedatetype"));
				Thread.sleep(1250);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Newnextpaymentdate).sendKeys(Driver.getData("invalidpaydate"));
				Thread.sleep(1250);
				
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Paymentdatesave).click();
				Thread.sleep(1250);
				
				String erromsg=Common_Property.driver.findElement (Pom_Openuniversity.FO_Errormsg).getText().toString();
				Thread.sleep(2250);
				
				Utilities.ExtentPassReport("error message is displayed as expected as"+erromsg);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Errormsgback).click();	
				Thread.sleep(1250);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Newnextpaymentdate).clear();	
				Thread.sleep(250);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Newnextpaymentdate).sendKeys(Driver.getData("Newpaydate"));	
				Thread.sleep(250);
				
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Paymentdatesave).click();
				Thread.sleep(4250);
				
				
				//view schedules
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewscheduleslink).click();
				Thread.sleep(2250);
				
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulefirstrow).isDisplayed();
				Thread.sleep(250);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesecondrow).isDisplayed();
				Thread.sleep(250);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulethirdrow).isDisplayed();
				Thread.sleep(250);
				
				String type=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulestype).getText().toString();
				Thread.sleep(250);
				
				String NumberOfPayments=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesnoofpay).getText().toString();
				Thread.sleep(250);
				
				String TermInMonths=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesterms).getText().toString();
				Thread.sleep(250);
			
				String Status=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesstatus).getText().toString();
				Thread.sleep(250);
	
				String Startdate=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesstartdate).getText().toString();
				Thread.sleep(250);
		
				String Enddate=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesenddate).getText().toString();
				Thread.sleep(250);
				
				String duedate=Common_Property.driver.findElement (Pom_Openuniversity.FO_ViewschedulesDuedate).getText().toString();
				Thread.sleep(250);
				
				String installmentamount=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesinsamnt).getText().toString();
				Thread.sleep(250);
				
					if (type.contains(Driver.getData("Type"))&& NumberOfPayments.contains(Driver.getData("Noofpay"))&&TermInMonths.contains(Driver.getData("Terms")))
					{
					
					Utilities.ExtentPassReport( "Type is displayed expected as"+type);
					Utilities.ExtentPassReport("NumberOfPayments is displayed as expected as"+NumberOfPayments);
					Utilities.ExtentPassReport("TermInMonths is displayed as expected as"+TermInMonths);
				
					}
					else
					{
					
					Utilities.ExtentFailReport1( "Type is not displayed expected as ",type);
					Utilities.ExtentFailReport1( "NumberOfPayments is not displayed as expected as ",NumberOfPayments);
					Utilities.ExtentFailReport1( "TermInMonths is displayed not as expected as ",TermInMonths);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					}
				
				String Tstatus =Driver.getData("Schedulestatus").trim();
				String Fstatus= Status.trim();
				
				System.out.println("testx   " + Tstatus + "       "  + "Its length" + Tstatus.length() );
				System.out.println("testy   " + Fstatus + "       "  + "Its length" + Fstatus.length() );
				
				
					if (Startdate.contains(Driver.getData("ChangepayStrtdate"))&&Fstatus.contains(Tstatus)&&Enddate.contains(Driver.getData("Changepayenddate")))
					{
					
					Utilities.ExtentPassReport( "Status is displayed expected as"+Status);
					Utilities.ExtentPassReport("Startdate is displayed as expected as"+Startdate);
					Utilities.ExtentPassReport( "Enddate is displayed as expected as"+Enddate);
				
					}
					else
					{
					
					Utilities.ExtentFailReport1( "Status is not displayed expected as ",Status);
					Utilities.ExtentFailReport1("Startdate is not displayed as expected as ",Startdate);
					Utilities.ExtentFailReport1("Enddate is displayed not as expected as ",Enddate);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					}
				
					if (duedate.contains(Driver.getData("Duedate"))&&installmentamount.contains(Driver.getData("Installmentamnt")))
					{
					
					Utilities.ExtentPassReport( "duedate is displayed expected as"+duedate);
					Utilities.ExtentPassReport( "installmentamount is displayed as expected as"+installmentamount);
					
				
					}
					else
					{
					
					Utilities.ExtentFailReport1( "duedate is not displayed expected as",duedate);
					Utilities.ExtentFailReport1( "installmentamount is not displayed as expected as",installmentamount);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
				
					}
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_closebutton).click();	
				Thread.sleep(2250);
				
				
				//withdrawal notification
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrawalnotificlink).click();
				Thread.sleep(250);
				System.out.println(Driver.getData("Wnotifidate"));
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrawalnotificdate).sendKeys(Driver.getData("Wnotifidate"));
				Thread.sleep(250);;
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrawalnotificsave).click();
				Thread.sleep(1250);
				
				
				String Blockcode=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrawalnotificblock).getText().toString();
				Thread.sleep(1250);
				Utilities.ExtentPassReport( "Block code is displayed as"+Blockcode);
				
				String proosaedrate=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrawalnotificproporate).getText().toString();
				Utilities.ExtentPassReport( "Proposaed rate is displayed as"+proosaedrate);
				Thread.sleep(1250);
				
				//Agreement history
				Common_Property.driver.findElement(Pom_Openuniversity.FO_Agreementmorelink).click();
				Thread.sleep(1250);

				String commontype=Common_Property.driver.findElement(Pom_Openuniversity.FO_Commontypeevent).getText().toString();
				Thread.sleep(1250);
				if(commontype.contains(Driver.getData("Wevent2")))
				{
				String withdrweve1=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdraweve1).getText().toString();
				Thread.sleep(1250);
				String withdrweve1value=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdraweve1value).getText().toString();
				Thread.sleep(1250);
				

				String withdrweve2=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdraweve2).getText().toString();
				Thread.sleep(1250);
				
				String withdrweve2value=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdraweve2value).getText().toString();
				Thread.sleep(1250);
				
					if(withdrweve1.contains(Driver.getData("Wevent1"))&&withdrweve1value.contains(Driver.getData("Wevent1value")))
					{
					
					Utilities.ExtentPassReport( "Withdrawal event1 is displayed as expected as"+withdrweve1);
					//Utilities.ExtentPassReport( "Withdrawal event1 value is is displayed as expected as"+withdrweve1value);
					
					}
					else
					{
					
					Utilities.ExtentFailReport1( "Withdrawal event1 is is Not displayed as expected as ",withdrweve1);
					Utilities.ExtentFailReport1( "Withdrawal event1 value is Not displayed as expected as ",withdrweve1value);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					
					}
					if(withdrweve2.contains(Driver.getData("Wevent2"))&&withdrweve2value.contains(Driver.getData("Wevent2value"))){
						Utilities.ExtentPassReport( "Withdrawal event2 is displayed as expected as"+withdrweve2);
						//Utilities.ExtentPassReport( "Withdrawal event2 value is is displayed as expected as"+withdrweve2value);
					}
					else{
						Utilities.ExtentFailReport1( "Withdrawal event2 is is Not displayed as expected as ",withdrweve2);
						Utilities.ExtentFailReport1( "Withdrawal event2 value is Not displayed as expected as ",withdrweve2value);
						Configuration.updatePropertyFile(Methodid,MethodName,"False");
						
					}
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_closebutton).click();
				Thread.sleep(1250);
				}
			
				else
				{
				
				String withdrweve1=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrweve1).getText().toString();
				Thread.sleep(750);

				String withdrweve1value=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrweve1value).getText().toString();
				Thread.sleep(750);
				

				String withdrweve2=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrweve2).getText().toString();
				System.out.println(withdrweve2);
				Thread.sleep(750);
				
				String withdrweve2value=Common_Property.driver.findElement(Pom_Openuniversity.FO_Withdrweve2value).getText().toString();
				Thread.sleep(750);
				
					if(withdrweve1.contains(Driver.getData("Wevent1")))
					{
					
					Utilities.ExtentPassReport( "Withdrawal event1 is displayed as expected as"+withdrweve1);
					Utilities.ExtentPassReport( "Withdrawal event1 value is is displayed as expected as"+withdrweve1value);
					
					}
					else
					{
					
					Utilities.ExtentFailReport1( "Withdrawal event1 is is Not displayed as expected as",withdrweve1);
					Utilities.ExtentFailReport1( "Withdrawal event1 value is Not displayed as expected as ",withdrweve1value);
					
					}
					if(withdrweve1value.contains(Driver.getData("Wevent1value"))&&withdrweve2.contains(Driver.getData("Wevent2"))&&withdrweve2value.contains(Driver.getData("Wevent2value"))){
						
						Utilities.ExtentPassReport( "Withdrawal event2 is displayed as expected as"+withdrweve2);
						Utilities.ExtentPassReport( "Withdrawal event2 value is is displayed as expected as"+withdrweve2value);	
					}
					else{
						
						Utilities.ExtentFailReport1( "Withdrawal event2 is is Not displayed as expected as",withdrweve2);
						Utilities.ExtentFailReport1( "Withdrawal event2 value is Not displayed as expected as",withdrweve2value);
						
					}
				
				Common_Property.driver.findElement(Pom_Openuniversity.FO_closebutton).click();
				Thread.sleep(750);
				}
			
				//View schedules
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewscheduleslink).click();
				Thread.sleep(750);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulefirstrow).isDisplayed();
				Thread.sleep(750);
				//Utilities.passresult(MethodName, "Schedules Firstrow is displayed with Repayment", null, datetimestart);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesecondrow).isDisplayed();
				Thread.sleep(750);
				//Utilities.passresult(MethodName, " Schedules Secondrow is displayed with Interest Capitalisation", null, datetimestart);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulethirdrow).isDisplayed();
				Thread.sleep(750);;
				Utilities.ExtentPassReport("Schedules Thirdrow is displayed with Repayment");
				
				
				String wtype=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulestype).getText().toString();
				Thread.sleep(750);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesnoofpay).isDisplayed();
				Thread.sleep(750);
				
				String WNumberOfPayments=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesnoofpay).getText().toString();
				Thread.sleep(750);
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesterms).isDisplayed();
				Thread.sleep(750);
				
				String WTermInMonths=Common_Property.driver.findElement(Pom_Openuniversity.FO_Viewschedulesterms).getText().toString();
				Thread.sleep(750);
				
				Common_Property.driver.findElement (By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]")).isDisplayed();
				Thread.sleep(750);
				
				String WStatus=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesstatus).getText().toString();
				Thread.sleep(750);
				
				String WEnddate=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesenddate).getText().toString();
				Thread.sleep(750);
				
				String Wduedate=Common_Property.driver.findElement (Pom_Openuniversity.FO_ViewschedulesDuedate).getText().toString();
				Thread.sleep(750);
				
				String Winstallmentamount=Common_Property.driver.findElement (Pom_Openuniversity.FO_Viewschedulesinsamnt).getText().toString();
				Thread.sleep(750);
				
				
				String TWtype =Driver.getData("Wtype").trim();
				String FWtype= wtype.trim();
				
				System.out.println("testx   " + TWtype + "       "  + "Its length " + TWtype.length());
				System.out.println("testy   " + FWtype + "       "  + "Its length " + FWtype.length());
			
				String TWstatus =Driver.getData("Wstatus").trim();
				String FWstatus= WStatus.trim();
				
				System.out.println("testx   " + TWstatus + "       "  + "Its length" + TWstatus.length() );
				System.out.println("testy   " + FWstatus + "       "  + "Its length" + FWstatus.length() );
			
				
					if (FWtype.contains(TWtype)&&WNumberOfPayments.contains(Driver.getData("Wnoofpay"))&&WTermInMonths.contains(Driver.getData("Wterm"))&&FWstatus.contains(TWstatus))
					{
					
					Utilities.ExtentPassReport( "AfterWithdrwal type is displayed as expected as"+wtype);
					Utilities.ExtentPassReport("AfterWithdrwal no of payment is displayed as expected as"+WNumberOfPayments);
					Utilities.ExtentPassReport("AfterWithdrwal terms is displayed as expected as"+WTermInMonths);
					Utilities.ExtentPassReport("AfterWithdrwal Status is displayed as expected as"+WStatus);
					}
					else
					{
					
					Utilities.ExtentFailReport1( "AfterWithdrwal type is Not displayed as expected as ",wtype);
					Utilities.ExtentFailReport1( "AfterWithdrwal no of payment is Not displayed as expected as ",WNumberOfPayments);
					Utilities.ExtentFailReport1( "AfterWithdrwal terms is Not displayed as expected as ",WTermInMonths);
					Utilities.ExtentFailReport1( "AfterWithdrwal Status is Not displayed as expected as ",WStatus);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					}
				
				
					if (Wduedate.equals(WEnddate)&& Winstallmentamount.contains(Driver.getData("WLoanamount")))
					{
					
					Utilities.ExtentPassReport( "AfterWithdrwal new changed due date is displayed as expected as"+Wduedate);
					Utilities.ExtentPassReport( "AfterWithdrwal Installment amount is displayed as expected as"+Winstallmentamount);
				
					}
					else
					{
					
					Utilities.ExtentFailReport1( "AfterWithdrwal new changed due date is Not displayed as expected as ",Wduedate);
					Utilities.ExtentFailReport1("AfterWithdrwal Installment amount is Not displayed as expected as ",Winstallmentamount);
					Configuration.updatePropertyFile(Methodid,MethodName,"False");
					}
				
				Common_Property.driver.findElement (Pom_Openuniversity.FO_closebutton).click();	
				Thread.sleep(750);
				Driver.getTDvalue = 0;
				
				
			}
			
		
			catch (Exception e) 
			{  
				
				
				String Desc="Test Run of"+MethodName+"was not completed Sucessfully";
				Utilities.ExtentFailReport(MethodName, e);	
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
				
			}
    				
		

	}
	
	
	public static void FO_Login() throws  Exception
    {    	
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();  
		String datetimestart=dateFormat.format(sdate);
		
	try{
		Configuration.updatePropertyFile(Methodid,MethodName,"True");
		sheetflag=true;
		Common_Property.driver.get(Driver.getData("FrontOffice_Url"));
		sheetflag=true;
		Common_Property.driver.findElement(Pom_Openuniversity.UsernameFO).sendKeys(Driver.getData("FO_Username"));
		Thread.sleep(250);
		sheetflag=true;
		Common_Property.driver.findElement(Pom_Openuniversity.PasswordFO).sendKeys(Driver.getData("FO_Password"));
		Thread.sleep(250);
		Common_Property.driver.findElement(Pom_Openuniversity.SubmitFO).click();
		Thread.sleep(2000);
		Utilities.ExtentPassReport(MethodName);
	}
	catch(Exception e){
		Utilities.ExtentFailReport(MethodName, e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
	}
		
    				
    }
	
	

}
