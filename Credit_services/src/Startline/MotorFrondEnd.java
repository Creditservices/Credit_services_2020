package Startline;

import java.awt.Robot;
import java.awt.Cursor;
import java.awt.Component;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;


import Common_Funtions.*;
import IKANO.Ikano;
import Startline.SMF_RestAssured;

public class MotorFrondEnd extends Driver {

	private static final long timeOutInSeconds = 0;
	public static String Status = null,VTexposure, Halfway, Batchstatus,TP_Rate_Sheet;
	public static List<String> Testdatasheet = new ArrayList<String>();
	public static int brandflag = 0,flag, TPflag,index, QLoop = 1, AnsLoop = 1, QLoop1 = 1, AnsLoop1 = 1;
	static String  Agreementpdistaus = null,IOCSurl = null,BankEnhancedscore = null,pagename = null,agreementno = null,installment = null, goodscost,Brandname,Query,Balloon = null,Adminfee = null,Status1 = null,Advance = null,Plan = null,Plan1 = null;
	static float DecisionAPR;
	
	public static void PersonSearch() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		

		try {

			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(POM_StartLine.SMF_Surnnamebox).sendKeys(Driver.getData("Srnam"));
			Common_Property.driver.findElement(POM_StartLine.SMF_Forenamebox).sendKeys(Driver.getData("Frnam"));
			Thread.sleep(750);
			Common_Property.driver.findElement(POM_StartLine.SMF_PersonSearchGrid_Searchbutton).click();
			Thread.sleep(2000);

			Common_Property.driver.findElement(POM_StartLine.SMF_SelectOneCustomerlistoptions).click();
			Thread.sleep(750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport1(methodname, Desc);

		}

	}

	public static void Terms() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(POM_StartLine.SMF_Terms_DealerorIntroducercode).sendKeys(Driver.getData("Dealercode1"));
			Thread.sleep(350);

			Common_Property.driver.findElement(POM_StartLine.SMF_Terms_IntroducernameSearch).click();
			Thread.sleep(350);

			Common_Property.driver.findElement(POM_StartLine.SMF_Terms_ClickingDelaerLink).click();
			Thread.sleep(350);
			Thread.sleep(350);

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Terms_representativeID));
			select.selectByValue("100002");
			Thread.sleep(350);

			Select select1 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Terms_BranchID));
			select1.selectByValue("2462770");
			;
			Thread.sleep(350);

			Select select2 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Terms_BrandID));
			select2.selectByVisibleText(Driver.getData("Brnd"));
			Thread.sleep(350);

			Common_Property.driver.findElement(POM_StartLine.SMF_Terms_DOB).clear();
			Thread.sleep(350);
			Common_Property.driver.findElement(POM_StartLine.SMF_Terms_DOB).sendKeys(Driver.getData("DOB"));
			Thread.sleep(350);

			Select select3 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Terms_ClassificationID));
			select3.selectByVisibleText(Driver.getData("Classfname1"));
			Thread.sleep(350);

			Common_Property.driver.findElement(POM_StartLine.SMF_Terms_GoodsCost).sendKeys(Driver.getData("Goodcosts"));
			Thread.sleep(750);

			goodscost = Driver.getData("Goodcosts");
			System.out.println(goodscost);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, "", datetimestart);

		}

	}

	public static void Termscontinue() throws Exception, Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// continue

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void Personaldetails() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_paymethod));
			select.selectByVisibleText(Driver.getData("Methodofpay"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).sendKeys(Driver.getData("Bnksrtcode1"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).sendKeys(Driver.getData("Bnksrtcode2"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).sendKeys(Driver.getData("Bnksrtcode3"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).sendKeys(Driver.getData("Bnkacno"));
			Thread.sleep(750);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicence).clear();

			// continue

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void DL_license_validation() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_paymethod));
			select.selectByVisibleText(Driver.getData("Methodofpay"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).sendKeys(Driver.getData("Bnksrtcode1"));
			Thread.sleep(750);
			
			System.out.println("Bank sort code:"+Driver.getData("Bnksrtcode1"));
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).sendKeys(Driver.getData("Bnksrtcode2"));
			Thread.sleep(750);
			
			System.out.println(Driver.getData("Bnksrtcode2"));
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).sendKeys(Driver.getData("Bnksrtcode3"));
			Thread.sleep(750);
			
			System.out.println(Driver.getData("Bnksrtcode3"));
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).sendKeys(Driver.getData("Bnkacno"));
			Thread.sleep(750);
			
			System.out.println(Driver.getData("Dl_invalidnumber"));
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicence).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicence).sendKeys(Driver.getData("Dl_invalidnumber"));
			Thread.sleep(750);

			Select select1 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicenceOrgin));
			select1.selectByValue(Driver.getData("Dlorginvalue1"));// Uk
			Thread.sleep(750);

			// continue

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			String DL_errormsg = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DLErrormsg).getText().toString();
			Thread.sleep(750);

			if (DL_errormsg.contains(Driver.getData("DL_errormsg"))) {

				Utilities.passresult(methodname,"Error Displayed as expected for UK orgin_invalid DrivingLicensenumber", DL_errormsg,datetimestart);
			} else {

				Utilities.failresult(methodname, "Driving license invalid Error Not Displayed ", DL_errormsg,datetimestart);
			}

			// error back
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DLErrormsgBack).click();
			Thread.sleep(750);

			Select select2 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicenceOrgin));
			select2.selectByValue(Driver.getData("Dlorginvalue2"));// Other
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// pagename
			String pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(750);

			if (pagename.contains(Driver.getData("Pagename")))

			{

				Utilities.passresult(methodname, "DL_orgin:Other-page navigated to nextpage affordability", pagename,
						datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "DL_orgin:Other-page not navigated to nextpage affordability");
				Utilities.failresult(methodname, "DL_orgin:Other-page not navigated to nextpage affordability",pagename, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_navigatefrom_AffortoPersonalTab).click();
			Thread.sleep(750);

			Select select3 = new Select(
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicenceOrgin));
			select3.selectByValue(Driver.getData("Dlorginvalue3"));// northern   ireland
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// pagename
			String pagename1 = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText()
					.toString();
			Thread.sleep(750);

			if (pagename1.contains(Driver.getData("Pagename")))

			{
				Utilities.passresult(methodname, "DL_orgin:Other-page navigated to nextpage affordability", pagename1,datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "DL_orgin:Other-page not navigated to nextpage affordability");
				Utilities.failresult(methodname, "DL_orgin:Other-page not navigated to nextpage affordability",pagename1, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_navigatefrom_AffortoPersonalTab).click();
			Thread.sleep(750);

			Select select4 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicenceOrgin));
			select4.selectByValue(Driver.getData("Dlorginvalue4"));// european
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// pagename
			String pagename3 = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText()
					.toString();
			Thread.sleep(750);

			if (pagename3.contains(Driver.getData("Pagename")))

			{

				Utilities.passresult(methodname, "DL_orgin:Other-page navigated to nextpage affordability", pagename3,datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "DL_orgin:Other-page not navigated to nextpage affordability");
				Utilities.failresult(methodname, "DL_orgin:Other-page not navigated to nextpage affordability",pagename3, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Affordabilitydetails(Recordset record) throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// Affortability
			// continue

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			agreementno = Common_Property.driver.findElement(POM_StartLine.SMF_MotorFrontEnd_Agreementnumber).getText().toString();
			System.out.println(agreementno);
			Driver.get_ag_no = agreementno;
			Agreement_Store.Store_Data(Driver.WhichClient, agreementno, "", record);

			if (agreementno != null) {

				String Desc = "Agreement is Created Successfully " + agreementno;
				Utilities.passresult(methodname, Desc, agreementno, datetimestart);
				Thread.sleep(9000);
				TPflag = 0;
				Agreement_Store.Store_Data(Driver.WhichClient, agreementno, " ", record);

			} else {

				String Desc = "Agreement Number is not Generated ";
				Utilities.failresult(methodname, Desc, agreementno, datetimestart);
				Utilities.ExtentFailReport1(methodname, Desc);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Employmentdetails() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Employment continue

			String EMPMPageno = Common_Property.driver.findElement(POM_StartLine.SMF_EMPPageno).getText().toString();
			System.out.println(EMPMPageno);
			if (EMPMPageno.contains("1 of 2")) {
				Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_EMPdelete).click();
				Thread.sleep(750);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_CmpnyName).click();
			Thread.sleep(750);
			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_CmpnyName).clear();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_PropertyName).click();
			Thread.sleep(750);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_PropertyName).clear();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_PostalTown).click();
			Thread.sleep(750);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_PostalTown).clear();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_PostCode).click();
			Thread.sleep(750);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_PostCode).clear();
			Thread.sleep(750);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_CmpnyName).sendKeys("Startline Motor Finance Limited");
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_ClickSMFlistedOptions).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_EMPSearch).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_EMPStartdate).clear();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_EMPPage_EMPStartdate).sendKeys("01-Jan-2000");
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			String Desc = "Emplyment details are passed";
			Utilities.passresult(methodname, Desc, null, null);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Guarantorsdetails() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			String Desc1 = "Agreement generated Without Guarantors";
			Utilities.passresult(methodname, Desc1, agreementno, datetimestart);
			Thread.sleep(750);
			// NoGuarantors
			Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_NoGuarantors).click();
			Thread.sleep(750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Securitydetails() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(750);
			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_NewUserID));
			select.selectByVisibleText(Driver.getData("Newused1"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_RegNumber).sendKeys(Driver.getData("Regnumber"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_Mileage).sendKeys(Driver.getData("Milge"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_SecuritySearch).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_AnnualMillege).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_AnnualMillege).sendKeys(Driver.getData("Anualmlge"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_Fixvaluetickbox).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_ExcessmileageCharge).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_ExcessmileageCharge).sendKeys(Driver.getData("Exmileagechrge"));
			Thread.sleep(750);

			// continue

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}
	
	public static void Securitydetailsvalidation() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(750);
			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toSecuritypage).click();
			Thread.sleep(750);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_Mileage).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Securitypage_Mileage).sendKeys(Driver.getData("Milge"));
			Thread.sleep(750);


			// continue

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);
			
			
			String Popuptext=Common_Property.driver.findElement(POM_StartLine.SMF_Vehiclepopup).getText().toString();
			Thread.sleep(750);
			System.out.println(Popuptext);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_VehiclepopupOk).click();
			Thread.sleep(750);
			
			if (Popuptext.contains(Driver.getData("Vehiclepopup")))
			{
				Utilities.ExtentPassReport(methodname);
				Utilities.passresult(methodname, "Vehicle validation Pop up displayed", Popuptext, datetimestart);
			}
			else
			{
				Utilities.failresult(methodname, "Vehicle validation Pop up Not displayed", null, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}
	

	public static void Financials() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Noofpay).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Noofpay).sendKeys(Driver.getData("Installment"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).sendKeys(Driver.getData("Proposrate"));
			Thread.sleep(750);

			if (Driver.getData("Brnd").contains("PCP Brand")) {

				Common_Property.driver.findElement(By.name("finFixValue")).click();
				Thread.sleep(750);
				Common_Property.driver.findElement(By.name("balloon")).sendKeys(Driver.getData("Baloon"));
				Thread.sleep(750);
			}

			Adminfee = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Adminfeetext).getAttribute("value");
			Thread.sleep(350);
			System.out.println("admin fee is" + Adminfee);

			Balloon = Driver.getData("Baloon");
			Thread.sleep(350);
			System.out.println(Balloon);

			String Delaerdepo = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_DelaerDeposit).getAttribute("Value");
			Thread.sleep(350);

			String Partex = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_PartExchange).getAttribute("Value");
			Thread.sleep(350);
			Advance = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Advance).getText().toString();
			Thread.sleep(350);
			float Adv = Float.parseFloat(Advance);
			String goodscost = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Goodscost).getText().toString();
			Thread.sleep(350);

			float Delaerdepo1 = Float.parseFloat(Delaerdepo);
			float Partex1 = Float.parseFloat(Partex);
			float totalamnt = Delaerdepo1 + Partex1;
			float goodscost1 = Float.parseFloat(goodscost);
			float Advance1 = goodscost1 - totalamnt;

			if (Advance1 == Adv) {

				String Desc = "Advance amount verified is" + Advance;
				Utilities.passresult(methodname, Desc, Advance, datetimestart);
			} else {

				String Desc = "Advance amount is updated incorrectly";
				Utilities.failresult(methodname, Desc, null, datetimestart);
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			
			if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
				&& Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled())
			{

				Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment are enabled",null, datetimestart);
			}

			else {

				Utilities.ExtentFailReport1(methodname,"Financial page Solve for rates,Solve for installment are  not  enabled and Fixrates are not enabled");
				Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment are  not  enabled and Fixrates are not enabled",null, datetimestart);
			}
			//with secured task
			if ((TieredPricing.STavailable == 1) &&(TieredPricing.DealerTPstatus.contains("Y") && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()))
			{
				Utilities.passresult(methodname,"Fixrates check box is enabled as expected",null, datetimestart);
			}
			else if((TieredPricing.STavailable != 1) && (!Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()))
			{
				Utilities.passresult(methodname,"Fixrates check box is Disabled as expected",null, datetimestart);
			}
			else {

				Utilities.ExtentFailReport1(methodname,"Fixrates checkbox are  not  enabled/disabled as expected");
				Utilities.failresult(methodname,"Fixrates checkbox are  not  enabled/disabled as expected",null, datetimestart);
			}
			
			
			// calculate

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
			Thread.sleep(750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}
	

	public static void Financial_Continue() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Continue
			
			

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}
	public static void PCPballoonAmendment() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(By.name("finFixValue")).click();
			Thread.sleep(750);
			
			Common_Property.driver.findElement(By.name("balloon")).clear();
			Common_Property.driver.findElement(By.name("balloon")).sendKeys(Driver.getData("Amendbaloon"));
			Thread.sleep(750);
			
			// calculate
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
			Thread.sleep(750);
			
			
			
			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();
			activitys.add(0, "Automatically Referred");
			activitys.add(1, "Call Validate Decision Made");
			activitys.add(2, "Additional Attribute Changed");
			activitys.add(3, "Additional Attribute Changed");
			activitys.add(4, "Additional Attribute Added");
			activitys.add(5, "Additional Attribute Added");
			activitys.add(6, "Final Repayment changed");
			activitys.add(7, "Final Repayment changed");
			Primaryvalue.add(0, "SMF VT Exposure");
			Primaryvalue.add(1, "SMF Halfway Value");
			Primaryvalue.add(2, "APR Rate Fixed");
			Primaryvalue.add(3, "Balloon value fixed");
			Secondaryvalue.add(0, "Y");
			Secondaryvalue.add(1, "N");
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "PCPB", "CVAR"); //Status :PCPB -PCP balloon amendment Plan:CVAR-Call validate Auto refer
			
			

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void CallvalBureaudatas() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_DecisionpagetoCallvalbureapage).click();
			Thread.sleep(2000);

			// Dealflo

			String Agency = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Dealfloagency).getText()
					.toString();
			Thread.sleep(800);

			if (Agency.contains(Driver.getData("Agency"))) {

				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Dealfloagencylink).click();
				Thread.sleep(800);

				String BankStandard = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloBankStandard).getText().toString();
				Thread.sleep(700);

				String BankEnhanced = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloBankEnhanced).getText().toString();
				Thread.sleep(700);

				String IDEnhanced = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloIDEnhanced).getText().toString();
				Thread.sleep(700);

				BankEnhancedscore = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloBankEnhacedscore).getText().toString();
				Thread.sleep(700);

				if (BankStandard.equalsIgnoreCase(Driver.getData("BankStandard"))
					&& BankEnhanced.equalsIgnoreCase(Driver.getData("BankEnhanced"))
					&& IDEnhanced.equalsIgnoreCase(Driver.getData("IDEnhanced"))
					&& BankEnhancedscore.equalsIgnoreCase(Driver.getData("BankEnhancedscore"))) {

					Utilities.passresult(methodname, "Bank Standard displayed as" + BankStandard, BankStandard,datetimestart);
					Utilities.passresult(methodname, "BankEnhanced displayed as" + BankEnhanced, BankEnhanced,datetimestart);
					Utilities.passresult(methodname, "IDEnhanced displayed as " + IDEnhanced, IDEnhanced,datetimestart);
					Utilities.passresult(methodname, "BankEnhancedscore displayed as" + BankEnhancedscore,BankEnhancedscore, datetimestart);
				} else {

					Utilities.failresult(methodname, "Bank Standard NOT displayed as YES", null, datetimestart);
					Utilities.failresult(methodname, "BankEnhanced displayed as" + BankEnhanced, BankEnhanced,datetimestart);
					Utilities.failresult(methodname, "IDEnhanced NOT displayed as YES", null, datetimestart);
					Utilities.passresult(methodname, "BankEnhancedscore is less than 45", BankEnhancedscore,datetimestart);

				}

				// Back
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CommonBack).click();
				Thread.sleep(700);

			} else {
				Utilities.failresult(methodname, "Agency is not displayed as Dealflo", null, datetimestart);
			}
			// Call tac

			String Agency1 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Calltacagency).getText().toString();
			Thread.sleep(800);

			if (Agency1.contains("Dealflo")) {
				Agency1 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacorCallReportagencytext1).getText().toString();
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacorCallReportagencylink1).click();

			}

			else if (Agency1.contains(Driver.getData("Agency1"))) {
				Agency1 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Calltacagency).getText().toString();
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Calltacagencylink2).click();

			}

			else {

				Utilities.failresult(methodname, "Agency is not displayed as Calltac", null, datetimestart);
			}

			String Warningmsg = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacWarnmsg).getText().toString();
			Thread.sleep(700);

			if (Warningmsg.contains(Driver.getData("Warningmsg"))) {

				Utilities.passresult(methodname, "Warning message is displayed as expected", Warningmsg, datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "Warning message is NOT displayed");
				Utilities.failresult(methodname, "Warning message is NOT displayed", Warningmsg, datetimestart);

			}

			WebElement searchid = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacSearchID);
			Thread.sleep(700);
			String SearchID = searchid.getText().toString();
			if (searchid.isDisplayed()) {

				Utilities.passresult(methodname, "Search ID is displayed as expected", SearchID, datetimestart);
			} else {

				Utilities.failresult(methodname, "Search ID is NOT displayed ", null, datetimestart);
			}
			// back
			Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CommonBack).click();
			Thread.sleep(700);

			// CallReport

			String Agency2 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacorCallReportagencytext1).getText().toString();
			Thread.sleep(800);
			if (Agency2.contains("CallTac")) { 
				
				Agency1 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReporttext1).getText().toString();
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReportlink1).click();
			} 
			else if (Agency2.contains(Driver.getData("Agency2"))) {
				
				Agency1 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacorCallReportagencytext1).getText().toString();
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacorCallReportagencylink1).click();

			} else {
				Utilities.failresult(methodname, "Agency is not displayed as Callreport", null, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReportShare).click();
			Thread.sleep(700);

			WebElement share = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReportSharetext);
			Thread.sleep(700);

			if (share.isDisplayed()) {

				Utilities.passresult(methodname, "Customer Call Report BSB Quotation row is greater than 0", null,datetimestart);

			} else {

				Utilities.ExtentFailReport1(methodname, "Customer Call Report BSB Quotation is NOT greater than 0");
				Utilities.failresult(methodname, "Customer Call Report BSB Quotation is NOT greater than 0", null,datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CommonBack).click();
			Thread.sleep(1000);

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
			Thread.sleep(1000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void TP_CallvalBureaudatas() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_DecisionpagetoCallvalbureapage).click();
			Thread.sleep(2000);

			// calltac

			String Agency = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Dealfloagency).getText()
					.toString();
			Thread.sleep(800);

			if (Agency.contains(Driver.getData("Agency"))) {
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Dealfloagencylink).click();
				Thread.sleep(700);

				String Warningmsg = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacWarnmsg).getText().toString();
				Thread.sleep(700);

				if (Warningmsg.contains(Driver.getData("Warningmsg"))) {

					Utilities.passresult(methodname, "Warning message is displayed as expected", Warningmsg,datetimestart);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Warning message is NOT displayed");
					Utilities.failresult(methodname, "Warning message is NOT displayed", null, datetimestart);
				}

				WebElement searchid = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CalltacSearchID);
				Thread.sleep(700);
				String SearchID = searchid.getText().toString();
				if (searchid.isDisplayed()) {

					Utilities.passresult(methodname, "Search ID is displayed as expected", SearchID, datetimestart);
				} else {

					Utilities.ExtentFailReport1(methodname, "Search ID is NOT displayed ");
					Utilities.failresult(methodname, "Search ID is NOT displayed ", null, datetimestart);
				}
				// back
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CommonBack).click();
				Thread.sleep(700);
			} else {
				Utilities.failresult(methodname, "Agency is not displayed as Calltac", null, datetimestart);
			}
			// dealflo
			String Agency1 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Calltacagency).getText().toString();
			Thread.sleep(800);
			if (Agency1.contains(Driver.getData("Agency1"))) {

				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_Calltacagencylink2).click();
				Thread.sleep(800);

				String BankStandard = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloBankStandard).getText().toString();
				Thread.sleep(700);

				String BankEnhanced = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloBankEnhanced).getText().toString();
				Thread.sleep(700);

				String IDEnhanced = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloIDEnhanced).getText().toString();
				Thread.sleep(700);

				BankEnhancedscore = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_DealfloBankEnhacedscore).getText().toString();
				Thread.sleep(700);

				if (BankStandard.equalsIgnoreCase(Driver.getData("BankStandard"))
					&& BankEnhanced.equalsIgnoreCase(Driver.getData("BankEnhanced"))
					&& IDEnhanced.equalsIgnoreCase(Driver.getData("IDEnhanced"))
					&& BankEnhancedscore.equalsIgnoreCase(Driver.getData("BankEnhancedscore"))) {

					Utilities.passresult(methodname, "Bank Standard displayed as" + BankStandard, BankStandard,datetimestart);
					Utilities.passresult(methodname, "BankEnhanced displayed as" + BankEnhanced, BankEnhanced,datetimestart);
					Utilities.passresult(methodname, "IDEnhanced displayed as " + IDEnhanced, IDEnhanced,datetimestart);
					Utilities.passresult(methodname, "BankEnhancedscore displayed as" + BankEnhancedscore,BankEnhancedscore, datetimestart);
				} else {

					Utilities.failresult(methodname, "Bank Standard NOT displayed as YES", null, datetimestart);
					Utilities.failresult(methodname, "BankEnhanced displayed as" + BankEnhanced, BankEnhanced,datetimestart);
					Utilities.failresult(methodname, "IDEnhanced NOT displayed as YES", null, datetimestart);
					Utilities.passresult(methodname, "BankEnhancedscore is less than 45", BankEnhancedscore,datetimestart);
				}

				// back
				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CommonBack).click();
				Thread.sleep(700);

			} else {
				Utilities.failresult(methodname, "Agency is not displayed as Dealflo", null, datetimestart);
			}
			// CallReport

			String Agency2 = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReporttext1).getText().toString();
			Thread.sleep(800);
			if (Agency2.contains(Driver.getData("Agency2"))) {

				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReportlink1).click();
				Thread.sleep(700);

				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReportShare).click();
				Thread.sleep(700);

				WebElement share = Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CallReportSharetext);
				Thread.sleep(700);

				if (share.isDisplayed()) {

					Utilities.passresult(methodname, "Customer Call Report BSB Quotation row is greater than 0", null,datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Customer Call Report BSB Quotation is NOT greater than 0");
					Utilities.failresult(methodname, "Customer Call Report BSB Quotation is NOT greater than 0", null,datetimestart);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_CallvalBureau_CommonBack).click();
				Thread.sleep(1000);
			}

			else {
				Utilities.failresult(methodname, "Agency is not displayed as Call report", null, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
			Thread.sleep(1000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void PDIAgrReferred() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			int j = 0;
			for (j = 0; j <= 20; j++) {

				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);
				Thread.sleep(700);
				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				boolean a = Status.contains(Driver.getData("RefStatus"));
				if (a)
				break;
			}
			Utilities.ExtentPassReport(methodname);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
			Thread.sleep(700);

			Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			Thread.sleep(700);

			installment = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Installment).getText().toString();
			Utilities.passresult(methodname, "Installment amount is " + installment, installment, datetimestart);
			Thread.sleep(750);

			String Residualval = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Residualval).getAttribute("value");
			Thread.sleep(750);

			Halfway = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Halfwayval).getAttribute("value");
			Thread.sleep(750);

			VTexposure = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_VTexsposure).getText().toString();
			Thread.sleep(750);

			String specialterm = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Specialterm).getText().toString();
			Thread.sleep(750);

			if (specialterm.contains(Driver.getData("specialterm"))) {
				Utilities.passresult("Event log ", "Special term count is greater than 0 ", null, datetimestart);
				Thread.sleep(750);

			} else {
				Utilities.passresult("Event log ", "Special term count is less than 0 ", null, datetimestart);// pcp brand no special term willpresent
				Thread.sleep(750);

			}

			if (Status.contains(Driver.getData("RefStatus")) && Plan.contains(Driver.getData("Refplanname"))) {

				Utilities.passresult(methodname, "MotorFront end Status" + Status, Status, datetimestart);
				Utilities.passresult(methodname, "MotorFront end Plan" + Plan, Plan, datetimestart);

			}

			else {

				Utilities.failresult(methodname, "MotorFront end Status NOT displayed as expected", null,datetimestart);
				Utilities.passresult(methodname, "MotorFront end Plan NOT displayed as expected", null, datetimestart);

			}

			String bal = Driver.getData("Baloon");
			Float balloon = Float.parseFloat(bal);

			Float HWval = Float.parseFloat(Halfway);
			Float VTexpo = Float.parseFloat(VTexposure);

			if (balloon > 0.00) {
				Float RVvalue = Float.parseFloat(Residualval);
				if ((RVvalue > 0.00) && (HWval > 0.00) && (VTexpo >= 0.00)) {

					String Resvalue = RVvalue.toString();
					String Halfvalue = HWval.toString();
					String Vtex = VTexpo.toString();
					Utilities.passresult(methodname, "Residual value calculated and the value" + RVvalue, Resvalue,datetimestart);
					Utilities.passresult(methodname, "Halfway value calculated and the value is" + HWval, Halfvalue,datetimestart);
					Utilities.passresult(methodname, "VT exposure value calculated and the value is" + VTexpo, Vtex,datetimestart);
				} else {
					Utilities.failresult(methodname,"Residual/HW/Vt exposure value not calculated as expected with balloon", null,datetimestart);
				}

			}

			if (balloon == 0.00) {

				if ((Residualval.isEmpty() || Residualval.equals("0.00")) && (HWval > 0.00) && (VTexpo >= 0.00)) {

					String Resvalue = Residualval.toString();
					String Halfvalue = HWval.toString();
					String Vtex = VTexpo.toString();
					Utilities.passresult(methodname,"Residual value is displayed as blank or equal to Zero" + Residualval, Resvalue,datetimestart);
					Utilities.passresult(methodname, "Halfway value calculated and the value is" + HWval, Halfvalue,datetimestart);
					Utilities.passresult(methodname, "VT exposure value calculated and the value is" + VTexpo, Vtex,datetimestart);
				} else {
					Utilities.failresult(methodname,
							"Residual/HW/Vt exposure value not calculated as expected without a balloon", null,
							datetimestart);
				}

			}

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Redo_Referredevents() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Redo Referred Events Query
			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();
			activitys.add(0, "Automatically Referred");
			activitys.add(1, "Call Validate Decision Made");
			activitys.add(2, "Additional Attribute Changed");
			activitys.add(3, "Additional Attribute Changed");
			activitys.add(4, "Additional Attribute");
			Primaryvalue.add(0, "SMF VT Exposure");
			Primaryvalue.add(1, "SMF Halfway Value");
			Primaryvalue.add(2, "APR Rate Fixed");
			Secondaryvalue.add(0, Driver.getData("Ratefixed"));
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "REF", "CVAR"); // Status:REF-Referred, Plan:CVAR-:CVAR Call validate Auto refer
																										
		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void ReferredEvents() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Referred Events Query

			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();

			if (Driver.getData("Modeofcreation").contains("P")) {

				activitys.add(0, "Automatically Referred");
				activitys.add(1, "Call Validate Decision Made");
				activitys.add(2, "Additional Attribute Added");
				activitys.add(3, "Additional Attribute Added");
				Primaryvalue.add(0, "SMF VT Exposure");
				Primaryvalue.add(1, "SMF Halfway Value");
				Secondaryvalue.add(0, Driver.getData("Ratefixed"));
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "REF", "CVAR");

			} else if (Driver.getData("Modeofcreation").contains("M")) {
				activitys.add(0, "Automatically Referred");
				activitys.add(1, "Call Validate Decision Made");
				activitys.add(2, "Additional Attribute Added");
				activitys.add(3, "Additional Attribute Added");
				activitys.add(4, "Additional Attribute Added");
				activitys.add(5, "Excess Mileage Charge changed");
				activitys.add(6, "Excess Mileage Charge changed");
				activitys.add(7, "Additional Attribute Changed");
				activitys.add(8, "Additional Attribute Add");
				activitys.add(9, "Additional Attribute Add");
				activitys.add(10, "Additional Attribut");
				activitys.add(11, "Additional");
				Primaryvalue.add(0, "CP Agreement Source");
				Primaryvalue.add(1, "SMF VT Exposure");
				Primaryvalue.add(2, "SMF Halfway Value");
				Primaryvalue.add(3, Driver.getData("Exmileagechrge"));
				Primaryvalue.add(4, "Excess Mileage Charge value fixed");
				Primaryvalue.add(5, "Settling Existing Finance");
				Primaryvalue.add(6, "APR Rate Fixed");
				Primaryvalue.add(7, "Balloon value fixed");
				Primaryvalue.add(8, "Excess Mileage Charge fixed");
				Secondaryvalue.add(0, "N");
				Secondaryvalue.add(1, "Y");
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "MREF", "CVAR"); // MREF = Status -Motor frontend Referred,CVAR -Plan Call validate Auto refer
			}

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void Updatereferredevents() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{
			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();
			if (Driver.getData("Referredeventsflag").contains("Y")) {

				// Update events
				activitys.add(0, "Automatically Referred");
				activitys.add(1, "Call Validate Decision Made");
				activitys.add(2, "Cancel IOCSInitiateTransaction");
				activitys.add(3, "Update Proposal");
				activitys.add(4, "IOCS Dealer URL Cleared");
				activitys.add(5, "Bank Details Amended");
				activitys.add(6, "Additional Attribute Changed");
				activitys.add(7, "Additional Attribute Changed");
				activitys.add(8, "Additional Attribute Added");
				Primaryvalue.add(0, "Balloon value fixed");
				Primaryvalue.add(1, "SMF VT Exposure");
				Primaryvalue.add(2, "SMF Halfway Value");
				Secondaryvalue.add(0, "N");
				
								
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "UPDRV", "CVAR"); // UPDRV=Status -Update Referred version,CVAR-Plan Call validate Auto refer
			}
		}

		catch (Exception e) {

			System.out.println("The exception was " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Newagrsearch() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(POM_StartLine.SMF_DecisionbottonNewagreement_Link).click();
			Thread.sleep(1000);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumberbox).sendKeys();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_AgreementSearchGrid_Searchbutton).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(750);
			

			// refresh
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
			Thread.sleep(1000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	/*-------------------------------------------------------------
	  -------------------------------------------------------------
	
	Database:Oracle SQL Developer
	Technology Used:JDBC Driver
	
	Definition : JDBC driver is a software component enabling a 
	Java application to interact with a database.The JDBC driver gives out the 
	connection to the database and implements the protocol for transferring the 
	query and result between client and database.
	
	---------------------------------------------------------------
	--------------------------------------------------------------*/

	public static void SQLrefjdbc() throws Exception

	{

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> activitys1 = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();

			// Activities ArrayList
			activitys.add(0, "Finishline Available Set");
			activitys.add(1, "Product Evaluated");
			activitys.add(2, "Decisioning Started");
			activitys.add(3, "Call Report Search Required");
			activitys.add(4, "Call Report Search Completed");
			activitys.add(5, "Trace Score Set");
			activitys.add(6, "OI Score Set");
			activitys.add(7, "Gauge Score Set");
			activitys.add(8, "Pre Vet Ruleset Evaluated");
			activitys.add(9, "Post Bureau Ruleset Evaluated");
			activitys.add(10, "CallValidate Ruleset Evaluated");
			activitys.add(11, "E-sig required set");
			activitys.add(12, "Quality+ and PCP Exceptions");
			activitys1.add(0, "Dummy");
			Primaryvalue.add(0, "SMF Common Ruleset");
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "SQLREF", "CVAR"); // Status:SQL Referred,plan-call validate auto referred
																		
			Agreementevents.Agr_events_check(activitys1, null, null, "Decision", "Cnt"); // Decision,Cnt:Decision reason Count
			
			} catch (Exception ex) {
			System.err.print("Exception: ");
			System.err.println(ex.getMessage());
		}
	}

	public static void PDI_Score_Validate(Recordset record) throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			int f = Integer.parseInt(BankEnhancedscore);
			System.out.println(f);
			int G = 45;

			if (f == G)

			{
				// manual over ride
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Manualoverride).click();
				Thread.sleep(700);

				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Thread.sleep(700);

				Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Utilities.passresult(methodname, "Agreement plan is" + Plan, Plan, datetimestart);

				int j = 0;

				for (j = 0; j <= 30; j++) {

					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
					Thread.sleep(700);
					String EsignURL = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_EsignURL).getText().toString();
					Thread.sleep(700);
					boolean a = EsignURL.contains("https");
					if (a)
					break;

				}

				String EsignURL = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_EsignURL).getText().toString();
				Thread.sleep(700);

				Utilities.passresult(methodname, "Esign url generated", EsignURL, datetimestart);

				Agreement_Store.Store_Data(Driver.WhichClient, agreementno, EsignURL, record);

				// Accpetd esign events query

				ArrayList<String> activitys = new ArrayList<String>();
				activitys.add(0, "Automatically Approved");
				activitys.add(1, "CV Override Decision Made");
				activitys.add(2, "IOCS Dealer URL Set");
				activitys.add(3, "IOCS Initiate Success");
				activitys.add(4, "Approved Pack Requested");
				activitys.add(5, "Document Emailed");
				activitys.add(6, "Document sent to Dealflo");

				Agreementevents.Agr_events_check(activitys, null, null, "AC", "AWE"); // AC = Status - Accpeted,AWE - Plan Accepted Awaiting Esign
				
				// documents
				Common_Property.driver.findElement(By.linkText("Documents")).click();
				Thread.sleep(850);

				String AcceptDocument1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				String AcceptDocument2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document2name).getText().toString();
				Thread.sleep(850);

				String AcceptDocument3 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document3name).getText().toString();
				Thread.sleep(850);

				if ((AcceptDocument1.contains(Driver.getData("AccEDocumentname1"))|| AcceptDocument1.contains(Driver.getData("AccEDocumentname2")))&& (AcceptDocument2.contains(Driver.getData("AccEDocumentname1"))|| AcceptDocument2.contains(Driver.getData("AccEDocumentname2")))&& AcceptDocument3.contains(Driver.getData("AccEDocumentname3"))) {

					Utilities.passresult(methodname, "Document1" + AcceptDocument1 + " is generated  ", AcceptDocument1,datetimestart);
					Utilities.passresult(methodname, "Document2" + AcceptDocument2 + " is generated ", AcceptDocument2,datetimestart);
					Utilities.passresult(methodname, "Document3" + AcceptDocument3 + " is generated ", AcceptDocument3,datetimestart);

				} else {

					Utilities.ExtentFailReport1(methodname,"Accpeted awaiting esign documents is not generated as expected");
					Utilities.failresult(methodname, "Accpeted awaiting esign documents is not generated as expected",null, datetimestart);

				}

				// Docment back
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);
			} else {

				Utilities.ExtentFailReport1(methodname,"plan and the status is not displayed as Awaiting esign and Accepted");
				Utilities.passresult(methodname, "plan and the status is not displayed as Awaiting esign and Accepted",null, datetimestart);
				Thread.sleep(700);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void GetEsignURL() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			if (Plan.contains(Driver.getData("Esignplan"))) {

				String url1 = Driver.getData("Misc");
				System.out.println(url1);
				Utilities.passresult(methodname, "esign url generated ", url1, datetimestart);
				Driver.refreshSheet1(Startline.bindingvalue,Startline.Startline_recordset1);
				String url = Driver.getData("Misc");
				Common_Property.driver.get(url);
				Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Thread.sleep(2000);
			} else {
				Utilities.passresult(methodname, "The plan is displayed as", Plan, datetimestart);
			}
		} catch (Exception e)

		{

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void IOCSURL() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			if (Plan.contains(Driver.getData("Esignplan"))) {

				IOCSurl = Driver.getData("Misc");
				System.out.println(IOCSurl);
				Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Thread.sleep(2000);
			} else {
				Utilities.passresult(methodname, "The plan is displayed as", Plan, datetimestart);
			}
		} catch (Exception e)

		{

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void PutIOCSURL() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{
			if (Plan.contains(Driver.getData("Esignplan"))) {

				Common_Property.driver.get(IOCSurl);
				Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Thread.sleep(2000);

				String message = Common_Property.driver.findElement(POM_StartLine.SMF_EsigncancelMsg).getText().toString();
				Thread.sleep(2000);

				if (message.contains(Driver.getData("Agrcancel"))) {

					Utilities.passresult(methodname,"IOCS URL is cancelled and cancelled message displayed as" + message, message,datetimestart);
					Thread.sleep(950);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Cancelled message is not displayed");
					Utilities.failresult(methodname, "Cancelled message is not displayed", Plan, datetimestart);
					Thread.sleep(950);
				}

			} else {
				Utilities.passresult(methodname, "The plan is displayed as", Plan, datetimestart);
			}
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	/*-------------------------------------------------------------
	  -------------------------------------------------------------
	
	Class: Esignature Workflow 
	Toolused Used:AutoIT -----ForFilecupload
	
	Definition:Fillo is an Excel API for Java and you can query xls & xlsx files.
	it supports SELECT, UPDATE & INSERT SQL queries with or without WHERE clause.
	Queries Used here in Driver:SELECT
	
	---------------------------------------------------------------
	--------------------------------------------------------------*/
	public static void Esignflow() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan")))

			{

			
				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(5000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(5000);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(5000);
				
				// Create object of WebDriverWait class
				 
				WebDriverWait wait=new WebDriverWait(Common_Property.driver,20);
				 
				// Wait till the element is not visible
				 
			//	WebElement element=wait.until(ExpectedConditions.elementToBeSelected(By.xpath(POM_StartLine.SMF_Esign_Continue));
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(5000);

				
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(8000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(8000);

				Thread.sleep(750);
				ArrayList<String> Questions = new ArrayList<String>();
				Questions.add(0, "How long have you had a personal mobile phone contract with your current provider?*");
				Questions.add(1, "Which one of the following addresses have you been associated with?*");
				Questions.add(2, "When did you last take out a personal loan (excluding student loans)?*");
				Questions.add(3, "When did you last take out a personal mortgage?*");
				Questions.add(4, "What is the current outstanding balance of your most recent mortgage?*");
				Questions.add(5, "When did you last take out a hire purchase agreement?*");
				Questions.add(6, "When did you last take out a personal credit card?*");
				Questions.add(7, "When did you last open a personal current account?*");
				Questions.add(8, "Do you have a personal mobile phone contract registered to your current address?*");
				Questions.add(9, "When did you last open a mail order account with a credit facility?*");
				ArrayList<String> answers = new ArrayList<String>();
				answers.add(0, "4");
				answers.add(1, "4");
				answers.add(2, "1");
				answers.add(3, "1");
				answers.add(4, "0");
				answers.add(5, "3");
				answers.add(6, "3");
				answers.add(7, "3");
				answers.add(8, "0");
				answers.add(9, "3");
				int QLoop = 1, AnsLoop = 1;
				while (QLoop <= 7) {
					String Qnames = Common_Property.driver.findElement(By.xpath("//*[@id='kba_questions_answers']" + "[" + QLoop + "]")).getText().toString();
					System.out.println(Qnames);
					System.out.println(Qnames.length());
					int CntIterator = 0;
					Iterator it = Questions.iterator();
					while (it.hasNext()) {
						Object ele = it.next();
						System.out.println(ele);
						System.out.println(ele.toString().length());

						String Cmp = ele.toString();
						if (Cmp.equalsIgnoreCase(Qnames.trim())) {
							// System.out.println(answers.get(CntIterator));
							java.util.List<WebElement> quetion1 = Common_Property.driver
									.findElements(By.name("kbaQuestion_" + AnsLoop + "_answer"));
							int ActClik = Integer.parseInt(answers.get(CntIterator));
							quetion1.get(ActClik).click();
							AnsLoop++;
							break;
						}
						CntIterator++;
					}

					QLoop = QLoop + 2;

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Drivelicencenumber).sendKeys(Driver.getData("DLnumber"));
				Thread.sleep(5000);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(8000);

				JavascriptExecutor jse6 = (JavascriptExecutor) Common_Property.driver;
				jse6.executeScript("window.scrollBy(0,6000)", "");
				Thread.sleep(10000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Requiredtick_checkbox).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Clickheretosign).click();
				Thread.sleep(5000);

				
				JavascriptExecutor jse7 = (JavascriptExecutor) Common_Property.driver;
				jse7.executeScript("window.scrollBy(0,6000)", "");
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Clickheretosign).click();
				Thread.sleep(8000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_IAccept).click();
				Thread.sleep(8000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(20000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Selectdocumentbuton).click();
				Thread.sleep(30000);

				Runtime.getRuntime().exec("D:/Repository/Credit_services/AutoIT/Fileupload.exe");
				Thread.sleep(20200);
				/*upload a document using robot class
				 * StringSelection stringSelection = new  StringSelection("C:\\Startline file upload\\Print pre document.pdf" ); 
				 * Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				 * clipboard.setContents(stringSelection, null);
				 * Thread.sleep(2000);
				 * Robot robot = new Robot(); robot.setAutoDelay(1000);
				 * robot.keyPress(KeyEvent.VK_CONTROL);
				 * robot.keyPress(KeyEvent.VK_V);
				 * robot.keyRelease(KeyEvent.VK_CONTROL);
				 * robot.keyRelease(KeyEvent.VK_V); robot.setAutoDelay(2000);
				 * robot.keyPress(KeyEvent.VK_ENTER); robot.delay(150);
				 * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(2000);
				 */
				Common_Property.driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				Thread.sleep(7000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_ConfirmPDFupload).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_ConfirmOkpoup).click(); // pop
																									// up
				Thread.sleep(5000);

				JavascriptExecutor jse8 = (JavascriptExecutor) Common_Property.driver;
				jse8.executeScript("window.scrollBy(0,6000)", "");
				Thread.sleep(5000);

				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Fileuploadtickbox);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_RequestPayment).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Thankspage_pdfDoc).click();
				Thread.sleep(5000);

				ArrayList<String> tabs3 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs3.get(1));
				Thread.sleep(5000);
				Common_Property.driver.close();
				Thread.sleep(5000);

				Common_Property.driver.switchTo().window(tabs3.get(0));
				Thread.sleep(5000);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_SECCIPagelink).click();
				Thread.sleep(5000);

				ArrayList<String> tabs4 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs4.get(1));
				Common_Property.driver.close();
				Thread.sleep(5000);

				Common_Property.driver.switchTo().window(tabs4.get(0));
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Downloadagr).click();
				Thread.sleep(5000);

				ArrayList<String> tabs5 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs5.get(1));
				Thread.sleep(5000);
				Common_Property.driver.close();
				Thread.sleep(5000);

				Common_Property.driver.switchTo().window(tabs5.get(0));
				// Common_Property.driver.close();

			}

			else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Fileuploadesignflow() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan"))) {

				Thread.sleep(5000);
				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(5000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(5000);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(8000);

				
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

				
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

			
				ArrayList<String> Questions = new ArrayList<String>();
				Questions.add(0, "How long have you had a personal mobile phone contract with your current provider?*");
				Questions.add(1, "Which one of the following addresses have you been associated with?*");
				Questions.add(2, "When did you last take out a personal loan (excluding student loans)?*");
				Questions.add(3, "When did you last take out a personal mortgage?*");
				Questions.add(4, "What is the current outstanding balance of your most recent mortgage?*");
				Questions.add(5, "When did you last take out a hire purchase agreement?*");
				Questions.add(6, "When did you last take out a personal credit card?*");
				Questions.add(7, "When did you last open a personal current account?*");
				Questions.add(8, "Do you have a personal mobile phone contract registered to your current address?*");
				Questions.add(9, "When did you last open a mail order account with a credit facility?*");
				ArrayList<String> answers = new ArrayList<String>();
				answers.add(0, "4");
				answers.add(1, "4");
				answers.add(2, "1");
				answers.add(3, "1");
				answers.add(4, "0");
				answers.add(5, "3");
				answers.add(6, "3");
				answers.add(7, "3");
				answers.add(8, "0");
				answers.add(9, "3");
				int QLoop = 1, AnsLoop = 1;
				while (QLoop <= 7) {
					String Qnames = Common_Property.driver.findElement(By.xpath("//*[@id='kba_questions_answers']" + "[" + QLoop + "]")).getText().toString();
					System.out.println(Qnames);
					System.out.println(Qnames.length());
					int CntIterator = 0;
					Iterator it = Questions.iterator();
					while (it.hasNext()) {
						Object ele = it.next();
						System.out.println(ele);
						System.out.println(ele.toString().length());

						String Cmp = ele.toString();
						if (Cmp.equalsIgnoreCase(Qnames.trim())) {
							// System.out.println(answers.get(CntIterator));
							java.util.List<WebElement> quetion1 = Common_Property.driver
									.findElements(By.name("kbaQuestion_" + AnsLoop + "_answer"));
							int ActClik = Integer.parseInt(answers.get(CntIterator));
							quetion1.get(ActClik).click();
							AnsLoop++;
							break;
						}
						CntIterator++;

					}

					QLoop = QLoop + 2;

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Drivelicencenumber).sendKeys(Driver.getData("DLnumber"));
				Thread.sleep(5000);
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(6700);
				
				JavascriptExecutor jse6 = (JavascriptExecutor) Common_Property.driver;
				jse6.executeScript("window.scrollBy(0,6000)", "");
				Thread.sleep(7000);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Requiredtick_checkbox).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Clickheretosign).click();
				Thread.sleep(5000);

				
				JavascriptExecutor jse7 = (JavascriptExecutor) Common_Property.driver;
				jse7.executeScript("window.scrollBy(0,6000)", "");
				Thread.sleep(5000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Clickheretosign).click();
				Thread.sleep(6000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_IAccept).click();
				Thread.sleep(6000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(20000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Selectdocumentbuton).click();
				Thread.sleep(20000);

				Runtime.getRuntime().exec(Configuration.Excelfileuploadpath);
				Thread.sleep(20100);

				String fileformaterror = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Fileformatypeerrormsg).getText().toString();
				Thread.sleep(8000);
				System.out.println(fileformaterror);
				System.out.println(Driver.getData("FileUpload_error1"));
				if (fileformaterror.contains(Driver.getData("FileUpload_error1"))) {

					fileformaterror.replace(".", "");
					Utilities.passresult(methodname,"File upload with the format of Excel(xlsx) throws error As expected ", fileformaterror,datetimestart);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "File upload with the format of Excel(xlsx) accepted");
					Utilities.failresult(methodname, "File upload with the format of Excel(xlsx) accepted",fileformaterror, datetimestart);
				}
			}

			else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}
			
			Common_Property.driver.close();
			Common_Property.driver=null;
			
		
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Redoesignflow() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan"))) {

				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(2000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(750);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(750);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(750);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(1000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(1000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(1000);

				String identitymsg = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignredoIdentitymsg).getText().toString();
				Thread.sleep(950);

				if (identitymsg.contains(Driver.getData("Identitymsg"))) {

					Utilities.passresult(methodname,"After redo an agreement Newly generated Esignature URL has been successfully gone through as expected",null, datetimestart);
				}

				else {

					Utilities.ExtentFailReport1(methodname,"After redo an agreement Newly generated Esignature URL Workflow is not successful");
					Utilities.failresult(methodname,"After redo an agreement Newly generated Esignature URL Workflow is not successful", null,datetimestart);
				}

			}

			else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Esignpassevents() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			String FinalStatus = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
			Thread.sleep(700);

			Utilities.passresult(methodname, "Status is displayed as" + FinalStatus, FinalStatus, datetimestart);

			String FinalPlan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			Thread.sleep(700);
			Utilities.passresult(methodname, "Plan is displayed as" + FinalPlan, FinalPlan, datetimestart);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
			Thread.sleep(950);
			
			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();
			// Activities ArrayList
			activitys.add(0, "E-Signature Status Changed");
			activitys.add(1, "E-Signature Status Changed");
			activitys.add(2, "E-Signature Status Changed");
			activitys.add(3, "E-Signature Status Changed");
			activitys.add(4, "Additional Attribute Added");
			activitys.add(5, "Additional Attribute Changed");
			activitys.add(6, "Additional Attribute Changed");
			activitys.add(7, "Additional Attribute Changed");
			Primaryvalue.add(0, "Dealflo Response Status");
			Secondaryvalue.add(0, "KBA_PASS");
			Secondaryvalue.add(1, "DLCHECK_PASS");
			Secondaryvalue.add(2, "ACCEPT");
			Secondaryvalue.add(3, "REQUEST_PAYMENT");
			Secondaryvalue.add(4, "Old value: KBA_PASS, New value: DLCHECK_PASS");
			Secondaryvalue.add(5, "Old value: DLCHECK_PASS, New value: ACCEPT");
			Secondaryvalue.add(6, "Old value: ACCEPT, New value: REQUEST_PAYMENT");
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "EP", "EDR"); //  Status- EP Esignature passevents, Plan -EDR:Esign docs received
			} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Esignsessiontimeout() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			WebDriverWait wait = new WebDriverWait(Common_Property.driver, 840000);
			WebElement alert;
			alert = wait.until(ExpectedConditions.visibilityOfElementLocated(POM_StartLine.SMF_Esign_Timeoutwaringmsg));
			String message = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_WarningPoUptitle).getText()
					.toString();
			Thread.sleep(950);
			System.out.println(message);
			if (message.contains(Driver.getData("Timeoutwarning"))) {

				Utilities.passresult(methodname, "Warning message is displayed as" + message, message, datetimestart);

			}

			else {

				Utilities.ExtentFailReport1(methodname, "Warning message is not displayed");
				Utilities.failresult(methodname, "Warning message is not displayed", Plan, datetimestart);
			}

			WebDriverWait wait1 = new WebDriverWait(Common_Property.driver, 100000);
			WebElement alert1;
			alert1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(POM_StartLine.SMF_Esign_SessionTimedoutmsg));
			String message2 = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_SessionTimedoutmsg).getText().toString();
			Thread.sleep(950);
			System.out.println(message2);
			if (message2.contains(Driver.getData("Timeout"))) {

				Utilities.passresult(methodname, "Session timed out and displayed as" + message2, message2,datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "Session timedout is not displayed");
				Utilities.failresult(methodname, "Session timedout is not displayed", message2, datetimestart);

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}
//Previously we are using the  below url to generate an esign events.N
//Now auto generated events are genearting So this method is not use.
	public static void TemproraryEsigneventpassgeneration() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			ArrayList<String> passevents = new ArrayList<String>();
			passevents.add(0, "KBA_PASS");
			passevents.add(1, "DLCHECK_PASS");
			passevents.add(2, "ACCEPT");
			passevents.add(3, "REQUEST_PAYMENT");
			for (int index = 0; index <= passevents.size() - 1; index++) {

				Common_Property.IntiateBrowser();
				Common_Property.driver.get("https://smfsys.pancredit.com/smfIocsInterface/callback?status="+ passevents.get(index) + "&partner_transaction_verification_token="+ Driver.getData("Agreement_Number") + "&IOCSTransactionId=1234");
				Common_Property.driver.close();
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void Reverttoesign() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			if (Plan.contains(Driver.getData("Esignplan"))) {

				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(2000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(750);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(750);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(750);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(1000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(1000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(1000);

				ArrayList<String> Questions = new ArrayList<String>();

				Questions.add(0, "How long have you had a personal mobile phone contract with your current provider?*");
				Questions.add(1, "Which one of the following addresses have you been associated with?*");
				Questions.add(2, "When did you last take out a personal loan (excluding student loans)?*");
				Questions.add(3, "When did you last take out a personal mortgage?*");
				Questions.add(4, "What is the current outstanding balance of your most recent mortgage?*");
				Questions.add(5, "When did you last take out a hire purchase agreement?*");
				Questions.add(6, "When did you last take out a personal credit card?*");
				Questions.add(7, "When did you last open a personal current account?*");
				Questions.add(8, "Do you have a personal mobile phone contract registered to your current address?*");
				Questions.add(9, "When did you last open a mail order account with a credit facility?*");

				ArrayList<String> answers = new ArrayList<String>();
				answers.add(0, "4");
				answers.add(1, "4");
				answers.add(2, "1");
				answers.add(3, "1");
				answers.add(4, "0");
				answers.add(5, "3");
				answers.add(6, "3");
				answers.add(7, "3");
				answers.add(8, "0");
				answers.add(9, "3");
				int QLoop = 1, AnsLoop = 1;
				while (QLoop <= 7) {
					String Qnames = Common_Property.driver.findElement(By.xpath("//*[@id='kba_questions_answers']" + "[" + QLoop + "]")).getText().toString();
					System.out.println(Qnames);
					System.out.println(Qnames.length());
					int CntIterator = 0;
					Iterator it = Questions.iterator();
					while (it.hasNext()) {

						Object ele = it.next();
						System.out.println(ele);
						System.out.println(ele.toString().length());

						String Cmp = ele.toString();
						if (Cmp.equalsIgnoreCase(Qnames.trim())) {java.util.List<WebElement> quetion1 = Common_Property.driver.findElements(By.name("kbaQuestion_" + AnsLoop + "_answer"));
							int ActClik = Integer.parseInt(answers.get(CntIterator));
							quetion1.get(ActClik).click();
							AnsLoop++;
							break;
						}
						CntIterator++;

					}

					QLoop = QLoop + 2;

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Drivelicencenumber).sendKeys(Driver.getData("DLnumber"));
				Thread.sleep(950);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(6000);

				JavascriptExecutor jse6 = (JavascriptExecutor) Common_Property.driver;
				jse6.executeScript("window.scrollBy(0,6000)", "");
				Thread.sleep(7000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Requiredtick_checkbox).click();
				Thread.sleep(1000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_reverttowetsign).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_DownloadagrPDflink).click();
				Thread.sleep(5000);

				String message = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignRevertCancelmsg).getText().toString();
				Thread.sleep(2000);

				if (message.contains(Driver.getData("Agrcancel"))) {

					Utilities.passresult(methodname, "Agreement cancelled and cancelled message displayed as" + message,message, datetimestart);
					Thread.sleep(950);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Cancelled message is not displayed");
					Utilities.failresult(methodname, "Cancelled message is not displayed", Plan, datetimestart);
					Thread.sleep(950);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignDownloadagr_link).click();
				Thread.sleep(2000);

				ArrayList<String> tabs3 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs3.get(1));
				Common_Property.driver.close();
				Thread.sleep(750);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(750);

				Common_Property.Launch_smf_Url();
				Common_Property.Startline_Login();
				Agreementsearch();
				// Refresh
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(950);

				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Thread.sleep(700);
				Utilities.passresult(methodname, "MotorFrontEnd status" + Status, Status, datetimestart);

				String FinalPlan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Thread.sleep(700);
				Utilities.passresult(methodname, "MotorFrontEnd Plan" + FinalPlan, FinalPlan, datetimestart);
				// RTWS events

				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				activitys.add(0, "E-Signature Status Changed");
				activitys.add(1, "E-Signature Status Changed");
				activitys.add(2, "E-Signature Status Changed");
				activitys.add(3, "Additional Attribute Removed");
				activitys.add(4, "Additional Attribute Changed");
				activitys.add(5, "Additional Attribute Changed");
				activitys.add(6, "Additional Attribute Added");
				activitys.add(7, "Additional Attribute Added");
				activitys.add(8, "Approved Pack Requested");
				Primaryvalue.add(0, "IOCS Dealer URL");
				Secondaryvalue.add(0, "RTWS");
				Secondaryvalue.add(1, "DLCHECK_PASS");
				Secondaryvalue.add(2, "KBA_PASS");
				Secondaryvalue.add(3, "Y");
				Secondaryvalue.add(4, "Old value: KBA_PASS, New value: DLCHECK_PASS");
				Secondaryvalue.add(5, "Old value: DLCHECK_PASS, New value: RTWS");
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "ER", "CMA"); // Status: ER-ESign Revert to wet sign,Plan:CMA-Call validate manual approved
				// document
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(950);

				String AccDocname = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (AccDocname.contains(Driver.getData("AccDocumentname1"))) {

					Utilities.passresult(methodname, "Document is generated sucessfully", AccDocname, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Document is NOT generated ");
					Utilities.failresult(methodname, "Document is NOT generated ", null, datetimestart);
					Thread.sleep(700);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);

				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Thread.sleep(700);

				Utilities.passresult(methodname, "Status is displayed as" + Status, Status, datetimestart);
				String FinalPlan1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Thread.sleep(700);
				Utilities.passresult(methodname, "Plan is displayed as" + FinalPlan1, FinalPlan1, datetimestart);
			}

			else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Esigsecurityfail() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan")))

			{

				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(3000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(3000);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				ArrayList<String> Questions = new ArrayList<String>();
				ArrayList<String> answers = new ArrayList<String>();
				ArrayList<String> Questions1 = new ArrayList<String>();
				ArrayList<String> answers1 = new ArrayList<String>();
				Thread.sleep(8000);
				Questions.add(0, "How long have you had a personal mobile phone contract with your current provider?*");
				Questions.add(1, "Which one of the following addresses have you been associated with?*");
				Questions.add(2, "When did you last take out a personal loan (excluding student loans)?*");
				Questions.add(3, "When did you last take out a personal mortgage?*");
				Questions.add(4, "What is the current outstanding balance of your most recent mortgage?*");
				Questions.add(5, "When did you last take out a hire purchase agreement?*");
				Questions.add(6, "When did you last take out a personal credit card?*");
				Questions.add(7, "When did you last open a personal current account?*");
				Questions.add(8, "Do you have a personal mobile phone contract registered to your current address?*");
				Questions.add(9, "When did you last open a mail order account with a credit facility?*");

				answers.add(0, "3");
				answers.add(1, "3");
				answers.add(2, "0");
				answers.add(3, "0");
				answers.add(4, "1");
				answers.add(5, "2");
				answers.add(6, "2");
				answers.add(7, "2");
				answers.add(8, "1");
				answers.add(9, "2");
				while (QLoop <= 7) {
					String Qnames = Common_Property.driver.findElement(By.xpath("//*[@id='kba_questions_answers']" + "[" + QLoop + "]")).getText().toString();
					System.out.println(Qnames);
					System.out.println(Qnames.length());
					int CntIterator = 0;
					Iterator it = Questions.iterator();
					while (it.hasNext()) {

						Object ele = it.next();
						System.out.println(ele);
						System.out.println(ele.toString().length());
						String Cmp = ele.toString();
						if (Cmp.equalsIgnoreCase(Qnames.trim())) {
							// System.out.println(answers.get(CntIterator));
							java.util.List<WebElement> quetion1 = Common_Property.driver
									.findElements(By.name("kbaQuestion_" + AnsLoop + "_answer"));
							int ActClik = Integer.parseInt(answers.get(CntIterator));
							quetion1.get(ActClik).click();
							AnsLoop++;
							break;
						}
						CntIterator++;
					}

					QLoop = QLoop + 2;

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				String warmessage = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignSecuritywarningMsg).getText().toString();
				Thread.sleep(3000);

				if (warmessage.contains(Driver.getData("Warmessage"))) {
					Utilities.passresult(methodname, " Warning Message is displayed", warmessage, datetimestart);
				}

				else {
					Utilities.failresult(methodname, "Warning message is not displayed", warmessage, datetimestart);
				}

				Questions1.add(0, "How long have you had a personal mobile phone contract with your current provider?*");
				Questions1.add(1, "Which one of the following addresses have you been associated with?*");
				Questions1.add(2, "When did you last take out a personal loan (excluding student loans)?*");
				Questions1.add(3, "When did you last take out a personal mortgage?*");
				Questions1.add(4, "What is the current outstanding balance of your most recent mortgage?*");
				Questions1.add(5, "When did you last take out a hire purchase agreement?*");
				Questions1.add(6, "When did you last take out a personal credit card?*");
				Questions1.add(7, "When did you last open a personal current account?*");
				Questions1.add(8, "Do you have a personal mobile phone contract registered to your current address?*");
				Questions1.add(9, "When did you last open a mail order account with a credit facility?*");
				answers1.add(0, "3");
				answers1.add(1, "3");
				answers1.add(2, "0");
				answers1.add(3, "0");
				answers1.add(4, "1");
				answers1.add(5, "2");
				answers1.add(6, "2");
				answers1.add(7, "2");
				answers1.add(8, "1");
				answers1.add(9, "2");
				int QLoop1 = 1, AnsLoop1 = 1;
				while (QLoop1 <= 7) {
					String Qnames1 = Common_Property.driver
							.findElement(By.xpath("//*[@id='kba_questions_answers']" + "[" + QLoop1 + "]")).getText()
							.toString();
					System.out.println(Qnames1);
					System.out.println(Qnames1.length());
					int CntIterator = 0;
					Iterator it = Questions1.iterator();
					while (it.hasNext()) {

						Object ele = it.next();
						System.out.println(ele);
						System.out.println(ele.toString().length());
						String Cmp = ele.toString();
						if (Cmp.equalsIgnoreCase(Qnames1.trim())) {
							// System.out.println(answers.get(CntIterator));
							java.util.List<WebElement> quetion2 = Common_Property.driver
									.findElements(By.name("kbaQuestion_" + AnsLoop1 + "_answer"));
							int ActClik1 = Integer.parseInt(answers1.get(CntIterator));
							quetion2.get(ActClik1).click();
							AnsLoop1++;
							break;
						}
						CntIterator++;

					}

					QLoop1 = QLoop1 + 2;

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				String wartext1 = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignredoIdentitymsg).getText().toString();
				Thread.sleep(3000);

				if (wartext1.contains(Driver.getData("Wartext1"))) {
					Utilities.passresult(methodname, " Identity Message is displayed", wartext1, datetimestart);
				}

				else {
					Utilities.failresult(methodname, "Identity message is not displayed", wartext1, datetimestart);
				}

				String url = Driver.getData("Misc");
				Common_Property.driver.get(url);
				Thread.sleep(3000);

				String message = Common_Property.driver.findElement(POM_StartLine.SMF_EsigncancelMsg).getText().toString();
				Thread.sleep(3000);

				if (message.contains(Driver.getData("Agrcancel"))) {

					Utilities.passresult(methodname, "Agreement cancelled and cancelled message displayed as" + message,message, datetimestart);
					Thread.sleep(950);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Cancelled message is not displayed");
					Utilities.failresult(methodname, "Cancelled message is not displayed", Plan, datetimestart);
					Thread.sleep(950);
				}

				Common_Property.Launch_smf_Url();
				Common_Property.Startline_Login();
				Agreementsearch();

				// refresh

				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(950);

				// Securityfail events

				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				activitys.add(0, "E-Signature Status Changed");
				activitys.add(1, "Additional Attribute Removed");
				activitys.add(2, "Additional Attribute Added");
				activitys.add(3, "Additional Attribute Added");
				activitys.add(4, "IOCS Esign Failure Email");
				Primaryvalue.add(0, "IOCS Dealer URL");

				Secondaryvalue.add(0, "KBA_FAIL");
				Secondaryvalue.add(1, "Y");
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "SF", "EF"); // Status:SF- Security Fail,Plan:EF-EsignFailure
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(700);
				
				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Thread.sleep(700);
				Utilities.passresult(methodname, "Status is displayed as" + Status, Status, datetimestart);

				String FinalPlan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText()
						.toString();
				Thread.sleep(700);
				Utilities.passresult(methodname, "Plan is displayed as" + FinalPlan, FinalPlan, datetimestart);

				// Documents
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(750);

				String esigndocemail = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (esigndocemail.contains(Driver.getData("AccDocumentname1"))) {

					Utilities.passresult(methodname, "Document is generated sucessfully", esigndocemail, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Document is NOT generated ");
					Utilities.failresult(methodname, "Document is NOT generated ", esigndocemail, datetimestart);
					Thread.sleep(700);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);
			} else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);

			}
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Esigdrivefail() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan")))

			{

				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(3000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(3000);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				ArrayList<String> Questions = new ArrayList<String>();

				Questions.add(0, "How long have you had a personal mobile phone contract with your current provider?*");
				Questions.add(1, "Which one of the following addresses have you been associated with?*");
				Questions.add(2, "When did you last take out a personal loan (excluding student loans)?*");
				Questions.add(3, "When did you last take out a personal mortgage?*");
				Questions.add(4, "What is the current outstanding balance of your most recent mortgage?*");
				Questions.add(5, "When did you last take out a hire purchase agreement?*");
				Questions.add(6, "When did you last take out a personal credit card?*");
				Questions.add(7, "When did you last open a personal current account?*");
				Questions.add(8, "Do you have a personal mobile phone contract registered to your current address?*");
				Questions.add(9, "When did you last open a mail order account with a credit facility?*");

				ArrayList<String> answers = new ArrayList<String>();
				answers.add(0, "4");
				answers.add(1, "4");
				answers.add(2, "1");
				answers.add(3, "1");
				answers.add(4, "0");
				answers.add(5, "3");
				answers.add(6, "3");
				answers.add(7, "3");
				answers.add(8, "0");
				answers.add(9, "3");
				int QLoop = 1, AnsLoop = 1;
				while (QLoop <= 7) {
					String Qnames = Common_Property.driver.findElement(By.xpath("//*[@id='kba_questions_answers']" + "[" + QLoop + "]")).getText().toString();
					System.out.println(Qnames);
					System.out.println(Qnames.length());
					int CntIterator = 0;
					Iterator it = Questions.iterator();
					while (it.hasNext()) {

						Object ele = it.next();
						System.out.println(ele);
						System.out.println(ele.toString().length());

						String Cmp = ele.toString();
						if (Cmp.equalsIgnoreCase(Qnames.trim())) {
							// System.out.println(answers.get(CntIterator));
							java.util.List<WebElement> quetion1 = Common_Property.driver.findElements(By.name("kbaQuestion_" + AnsLoop + "_answer"));
							int ActClik = Integer.parseInt(answers.get(CntIterator));
							quetion1.get(ActClik).click();
							AnsLoop++;
							break;
						}
						CntIterator++;

					}

					QLoop = QLoop + 2;

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(4000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Drivelicencenumber).sendKeys(Driver.getData("DLnumber"));
				Thread.sleep(15000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Drivelicencenumber).click();
				Thread.sleep(15000);

				WebElement element5 = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue);
				JavascriptExecutor jse5 = (JavascriptExecutor) Common_Property.driver;
				Thread.sleep(5000);
				
				jse5.executeScript("arguments[0].click();", element5);
				Thread.sleep(8000);

				String warningmsg = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsigndriveerrorMsg).getText().toString();
				if (warningmsg.contains(Driver.getData("DLwarmessage1"))) {

					Utilities.passresult(methodname, "Agreement warning messageis displayed as expected" + warningmsg,warningmsg, datetimestart);
					Thread.sleep(950);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Warning message is not displayed");
					Utilities.failresult(methodname, "Warning message is not displayed", warningmsg, datetimestart);
					Thread.sleep(950);
				}

				Thread.sleep(6000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(5000);

				String message = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignredoIdentitymsg).getText().toString();
				Thread.sleep(7000);

				if (message.contains(Driver.getData("DLwarmessage2"))) {

					Utilities.passresult(methodname, "Agreement cancelled and cancelled message displayed as" + message,message, datetimestart);
					Thread.sleep(950);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Cancelled message is not displayed");
					Utilities.failresult(methodname, "Cancelled message is not displayed", Plan, datetimestart);
					Thread.sleep(950);
				}
				
				Common_Property.Launch_smf_Url();
				Common_Property.Startline_Login();
				Agreementsearch();
				// refresh
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(950);

				// Driverfail events

				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				activitys.add(0, "E-Signature Status Changed");
				activitys.add(1, "E-Signature Status Changed");
				activitys.add(2, "Additional Attribute Removed");
				activitys.add(3, "Additional Attribute Added");
				activitys.add(4, "Additional Attribute Added");
				activitys.add(5, "IOCS Esign Failure Email");
				activitys.add(6, "Additional Attribute Changed");
				Primaryvalue.add(0, "IOCS Dealer URL");
				Secondaryvalue.add(0, "DLCHECK_FAIL");
				Secondaryvalue.add(1, "KBA_PASS");
				Secondaryvalue.add(2, "Y");
				Secondaryvalue.add(3, "Old value: KBA_PASS, New value: DLCHECK_FAIL");

				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "DL", "EF"); //Status: DL-Driving License Fail,Plan:EF-EsignFailure
				
				// Documents
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(750);

				String esigndocemail = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (esigndocemail.contains(Driver.getData("AccDocumentname1"))) {

					Utilities.passresult(methodname, "Document is generated sucessfully", esigndocemail, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Document is NOT generated ");
					Utilities.failresult(methodname, "Document is NOT generated ", esigndocemail, datetimestart);
					Thread.sleep(700);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);

			} else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Esigncancel() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan"))) {

				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(3000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(3000);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignDonotProceed).click();
				Thread.sleep(3000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignCancelagr).click(); // pop up
				Thread.sleep(3000);

				String message = Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Esignagrcancelledmsg).getText().toString();
				Thread.sleep(3000);

				if (message.contains(Driver.getData("Agrcancel"))) {

					Utilities.passresult(methodname, "Agreement cancelled and cancelled message displayed as" + message,message, datetimestart);
					Thread.sleep(950);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Cancelled message is not displayed");
					Utilities.failresult(methodname, "Cancelled message is not displayed", Plan, datetimestart);
					Thread.sleep(950);
				}

				Common_Property.Launch_smf_Url();
				Common_Property.Startline_Login();
				Agreementsearch();

				// Refresh

				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(950);

				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				activitys.add(0, "E-Signature Status Changed");
				activitys.add(1, "Additional Attribute Removed");
				activitys.add(2, "Additional Attribute Added");
				activitys.add(3, "Additional Attribute Added");
				activitys.add(4, "IOCS Esign Failure Email");
				Primaryvalue.add(0, "IOCS Dealer URL");
				Secondaryvalue.add(0, "CANCEL");
				Secondaryvalue.add(1, "Y");
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "EC", "EF"); // Status:EC-ESign Cancel,Plan:EF-EsignFailure
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(700);
				
				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Thread.sleep(700);
				
				Utilities.passresult(methodname, "Status is displayed as" + Status, Status, datetimestart);
				
				String FinalPlan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Thread.sleep(700);
				
				Utilities.passresult(methodname, "Plan is displayed as" + FinalPlan, FinalPlan, datetimestart);

				// Documents
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(750);

				String esigndocemail = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (esigndocemail.contains(Driver.getData("AccDocumentname1"))) {

					Utilities.passresult(methodname, "Document is generated sucessfully", esigndocemail, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.ExtentFailReport1(methodname, "Document is NOT generated ");
					Utilities.failresult(methodname, "Document is NOT generated ", esigndocemail, datetimestart);
					Thread.sleep(700);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);
			} else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}

		} catch (Exception e)

		{

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Esignsaveexit() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			if (Plan.contains(Driver.getData("Esignplan")))

			{

				Common_Property.driver.findElement(POM_StartLine.SMF_EsignimportantInforpage_Precontract).click();
				Thread.sleep(2000);

				ArrayList<String> tabs2 = new ArrayList<String>(Common_Property.driver.getWindowHandles());
				Common_Property.driver.switchTo().window(tabs2.get(1));
				Common_Property.driver.close();
				Thread.sleep(2000);
				Common_Property.driver.switchTo().window(tabs2.get(0));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignExit).click();
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignCloseSaveExitPopup).click();// popup
				Thread.sleep(2000);

				Utilities.passresult(methodname, "Save and Exit on the Important information page is done Succesfully",null, datetimestart);
				String url = Driver.getData("Misc");
				
				Common_Property.driver.get(url);
				Thread.sleep(2000);
				
				Utilities.passresult(methodname,"After save & Exit and re-Opened Esignature directing the saved page(Important information page) as expected",null, datetimestart);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignExit).click();
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_EsignCloseSaveExitPopup).click();// popup
				Thread.sleep(2000);
				Utilities.passresult(methodname, "Save and Exit on the Dealer's Confirm page is done Succesfully", null,datetimestart);

				String url1 = Driver.getData("Misc");
				Common_Property.driver.get(url1);
				Thread.sleep(2000);

				Utilities.passresult(methodname,"After save & Exit and re-Opened Esignature directing the saved page(Dealer's Confirm page) as expected",null, datetimestart);
				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerFirstname).sendKeys(Driver.getData("EsigdealerSrname"));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_delaerLastname).sendKeys(Driver.getData("Esigdealerfrname"));
				Thread.sleep(2000);

				Common_Property.driver.findElement(POM_StartLine.SMF_Esign_Continue).click();
				Thread.sleep(2000);
				Utilities.passresult(methodname, "Successfully proceed after the save & exit process", null,datetimestart);
			}

			else {
				Utilities.passresult(methodname, "Plan is displayed as", Plan, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	@SuppressWarnings("null")
	public static void Agreementsearch() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumberbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			
			agreementno = Driver.getData("Agreement_Number");
			
			
			Common_Property.driver.findElement(POM_StartLine.SMF_AgreementSearchGrid_Searchbutton).click();
			Thread.sleep(750);
			String decision=Common_Property.driver.findElement(POM_StartLine.SMF_Agreementdecisiononsearch).getText().toString();
			if(decision.contains("No Decision"))
			{
			Thread.sleep(100000);
			// Agreementlink
			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(700);
			}
			else
			{
			 Thread.sleep(1000);
			// Agreementlink
			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(700);
			}
		}

		catch (UnhandledAlertException f) 
		{
			try 
			{
				Alert alert = Common_Property.driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			}

			catch (NoAlertPresentException g) {
				g.printStackTrace();
			}
		}

		catch (Exception e) 
		{

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

		public static void Conditionaldocsrecieved() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Payout golive button
			Common_Property.driver.findElement(POM_StartLine.SMF_PayoutGolive).click();
			Thread.sleep(950);

			// document verify

			String Docrecevidedcomnt = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocreceivedSpace).getText().toString();
			Thread.sleep(1000);
			if (Docrecevidedcomnt.isEmpty()) {

				Utilities.passresult(methodname, "Docs received is displayed without User/Date", Docrecevidedcomnt,datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "Docs received is displayed with User/Date");
				Utilities.failresult(methodname, "Docs received is displayed with User/Date", Docrecevidedcomnt,datetimestart);
			}

			// document verify
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Docreceived).click();
			Thread.sleep(950);

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocreceivePopUp).click();
			Thread.sleep(850);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Utilities.passresult(methodname, "MotorFrontEnd Status" + Status, Status, datetimestart);
			Thread.sleep(700);

			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();

			activitys.add(0, "Conditionally Approved");
			activitys.add(1, "CV Override Decision Made");
			activitys.add(2, "Agreement Status Changed");
			Primaryvalue.add(0, "Docs Received");
			Secondaryvalue.add(0, "Conditionally Accepted");
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "CA", "CVCA"); // Status:CA-Conditionally Accepted,Plan:CVCA-Call validate conditional approved
			} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void DocsReceived() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{
			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);
			
			// Payout golive button
			Common_Property.driver.findElement(POM_StartLine.SMF_PayoutGolive).click();
			Thread.sleep(950);

			// document verify

			String Docrecevidedcomnt = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocreceivedSpace).getText().toString();
			Thread.sleep(1000);
			if (Docrecevidedcomnt.isEmpty()) {

				Utilities.passresult(methodname, "Docs received is displayed without User/Date", Docrecevidedcomnt,datetimestart);
			} else {

				Utilities.ExtentFailReport1(methodname, "Docs received is displayed with User/Date");
				Utilities.failresult(methodname, "Docs received is displayed with User/Date", Docrecevidedcomnt,datetimestart);
			}

			// document verify
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Docreceived).click();
			Thread.sleep(950);

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocreceivePopUp).click();
			Thread.sleep(850);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Utilities.passresult(methodname, "MotorFrontEnd Status" + Status, Status, datetimestart);
			Thread.sleep(700);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void FirstcheckValidated() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Advance).sendKeys(Advance);
			Thread.sleep(700);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Intsallment).sendKeys(installment);
			Thread.sleep(700);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Balloon).sendKeys(Balloon);
			Thread.sleep(700);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocumentFee).sendKeys(Adminfee);
			Thread.sleep(700);
			
			// 1st check validated
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_1stcheckvalidate).click();
			Thread.sleep(950);

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_StatusvalidatePopup).click();
			Thread.sleep(950);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Utilities.passresult(methodname, "MotorFrontEnd Status " + Status, Status, datetimestart);
			Thread.sleep(1000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void ConUNconfirmedSpecialterms() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{
			// confirmspecial terms
			String specialtermcontent = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_ConfirmSpecialterms).getText().toString();
			Thread.sleep(950);
			if (specialtermcontent.contains(Driver.getData("Specialterm1"))) {

				Utilities.passresult(methodname, "Special term content displayed as Confirmed special terms",specialtermcontent, datetimestart);
			}

			else {

				Utilities.failresult(methodname, "Special term content displayed as UnConfirmed special terms",specialtermcontent, datetimestart);
			}
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_ConfirmSpecialterms).click();
			Thread.sleep(950);

			String specialtermcontent1 = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_UnConfirmSpecialterms).getText().toString();
			Thread.sleep(950);
			if (specialtermcontent1.contains(Driver.getData("Specialterm2"))) {

				Utilities.passresult(methodname, "Special term content displayed as UnConfirmed special terms",specialtermcontent1, datetimestart);
			} else {

				Utilities.failresult(methodname, "Special term content displayed as UnConfirmed special terms",specialtermcontent1, datetimestart);
			}
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void AwaitingDocsApproved() throws Exception

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Advance).sendKeys(Advance);
			Thread.sleep(850);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Intsallment).sendKeys(installment);
			Thread.sleep(850);
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Balloon).sendKeys(Balloon);
			Thread.sleep(850);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocumentFee).sendKeys(Adminfee);
			Thread.sleep(850);
			
			// Docs approved
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocsApproved).click();
			Thread.sleep(950);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_StatusvalidatePopup).click();
			Thread.sleep(1000);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Utilities.passresult(methodname, "MotorFrontEnd Status" + Status, Status, datetimestart);
			Thread.sleep(700);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Payoutgolive() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Advance).sendKeys(Advance);
			Thread.sleep(850);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Intsallment).sendKeys(installment);
			Thread.sleep(850);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Balloon).sendKeys(Balloon);
			Thread.sleep(850);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocumentFee).sendKeys(Adminfee);
			Thread.sleep(850);
			
			// PAyout golive
			Common_Property.driver.findElement(POM_StartLine.SMF_PayoutGolive).click();
			Thread.sleep(950);
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_StatusvalidatePopup).click();
			Thread.sleep(1000);

			// PDIpayout events query
			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();

			// Activities ArrayList
			activitys.add(0, "Additional Attribute Added");
			activitys.add(1, "Additional Attribute Added");
			activitys.add(2, "Additional Attribute Added");
			activitys.add(3, "Additional Attribute Added");
			activitys.add(4, "Additional Attribute Added");
			activitys.add(5, "Additional Attribute Added");
			activitys.add(6, "Additional Attribute Added");
			activitys.add(7, "Agreement Status Changed");
			activitys.add(8, "Agreement Status Changed");
			activitys.add(9, "Agreement Status Changed");
			activitys.add(10, "Agreement Status Changed");
			activitys.add(11, "Agreement Activated");
			Primaryvalue.add(0, "CP Special Terms confirmed");
			Primaryvalue.add(1, "CP Advance");
			Primaryvalue.add(2, "Balloon Value");
			Primaryvalue.add(3, "CP Document Fee");
			Primaryvalue.add(4, "CP First Instalment");
			Primaryvalue.add(5, "CP Checks Complete");
			Primaryvalue.add(6, "CP Agreement Source");
			if (Driver.getData("Esign").contains("N")) {
				Secondaryvalue.add(0, "Accepted");
				Secondaryvalue.add(1, "Docs Received");
				Secondaryvalue.add(2, "1st Check Validated");
				Secondaryvalue.add(3, "Awaiting Payout");
				Secondaryvalue.add(4, Driver.getData("Username"));
				Secondaryvalue.add(5, Advance);
				Secondaryvalue.add(6, Balloon);
				Secondaryvalue.add(7, Adminfee);
				Secondaryvalue.add(8, installment);
				Secondaryvalue.add(9, "Y");
			} else {
				Secondaryvalue.add(0, "Accepted");
				Secondaryvalue.add(1, "eSign Docs Received");
				Secondaryvalue.add(2, "1st Check Validated");
				Secondaryvalue.add(3, "Awaiting Payout");
				Secondaryvalue.add(4, Driver.getData("Username"));
				Secondaryvalue.add(5, Advance);
				Secondaryvalue.add(6, Balloon);
				Secondaryvalue.add(7, Adminfee);
				Secondaryvalue.add(8, installment);
				Secondaryvalue.add(9, "Y");
			}
			if (Driver.getData("Modeofcreation").contains("P")) {
				Secondaryvalue.add(10, "Test");
			} else if (Driver.getData("Modeofcreation").contains("M")) {
				Secondaryvalue.add(10, "panCoreSaasMotor");
			}
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "AWP", "EDR"); // Status:AWP-Awaiting payout,Plan:EDR-Esign Docs Received
			
			Common_Property.driver.findElement(POM_StartLine.SMF_DecisionbottonNewagreement_Link).click();
			Thread.sleep(1000);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumberbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_AgreementSearchGrid_Searchbutton).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(750);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Thread.sleep(700);
			
			Utilities.passresult(methodname, "MotorFrontEnd Status" + Status, Status, datetimestart);
			
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Agreementrigrredo() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_DecisiontoTerms).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Forenamebox).click();
			Thread.sleep(750);
			Common_Property.driver.findElement(POM_StartLine.SMF_Forenamebox).clear();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Forenamebox).sendKeys(Driver.getData("Changefrnam"));
			Thread.sleep(750);

			// termscontinue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// Personalcontinue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// afforabilitycontinue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// employmentcontinue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// No Gurantors
			Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_NoGuarantors).click();
			Thread.sleep(750);

			// security continue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// financials continue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(1000);

			// refresh
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
			Thread.sleep(750);

			// status
			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
			Thread.sleep(750);
			
			Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			Utilities.passresult(methodname, "Agreement plan is" + Plan, Plan, datetimestart);
			
			if (Status.contains(Driver.getData("Rejstatus"))) {

				Utilities.passresult(methodname, "Status getting into" + Status + " after redo", Status, datetimestart);
				Thread.sleep(700);
			} else {

				Utilities.ExtentFailReport1(methodname, "Status getting into" + Status + " after redo");
				Utilities.failresult(methodname, "Status getting into" + Status + " after redo", Status, datetimestart);
				Thread.sleep(700);
			}
			if (Plan.contains(Driver.getData("Rejplan"))) {

				Utilities.passresult(methodname, "Status getting into" + Plan + " after redo", Plan, datetimestart);
				Thread.sleep(700);
			} else {

				Utilities.ExtentFailReport1(methodname, "Status getting into" + Plan + " after redo");
				Utilities.failresult(methodname, "Status getting into" + Plan + " after redo", Plan, datetimestart);
				Thread.sleep(700);
			}
			

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Agr_afteresign_redo() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Finiancial tab

			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Noofpay).click();
			Thread.sleep(750);
			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Noofpay).clear();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Noofpay).sendKeys(Driver.getData("Redo_instalamnt"));
			Thread.sleep(750);

			// Financial
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
			Thread.sleep(750);

			// continue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element1);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Managedocerror() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element1);

			// Payout golive button
			Common_Property.driver.findElement(POM_StartLine.SMF_PayoutGolive).click();
			Thread.sleep(950);

			// document verify

			String Docrecevidedcomnt = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocreceivedSpace).getText().toString();
			Thread.sleep(1000);
			if (Docrecevidedcomnt.isEmpty()) {

				Utilities.passresult(methodname, "Docs received is displayed without User/Date", Docrecevidedcomnt,datetimestart);
			} else {

				Utilities.failresult(methodname, "Docs received is displayed with User/Date", Docrecevidedcomnt,datetimestart);
			}

			// document verify
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_Docreceived).click();
			Thread.sleep(950);

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocreceivePopUp).click();
			Thread.sleep(850);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Utilities.passresult(methodname, "MotorFrontEnd Status" + Status, Status, datetimestart);
			Thread.sleep(700);

			SMF_RestAssured.APIHandler(Startline.Startline_recordset1, "CheckDecision");

			// Manage Doc Errors
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_ManageDocError).click();
			Thread.sleep(950);

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_ClickDrivelicenseConfirmtickbox).click();
			Thread.sleep(850);

			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_DocsReceivedwithErrors).click();
			Thread.sleep(950);
			// pop up
			Common_Property.driver.findElement(POM_StartLine.SMF_Payout_StatusvalidatePopup).click();
			Thread.sleep(850);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Payout_TopendStatus).getText().toString();
			Thread.sleep(850);
			
			SMF_RestAssured.APIHandler(Startline.Startline_recordset1, "CheckDecision");
			Utilities.passresult(methodname, "Status is in" + Status, Status, datetimestart);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Agr_checkdeccomaprision() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// PDI check decision
			SMF_RestAssured.APIHandler(recordset1, "CheckDecision");

			if (SMF_RestAssured.AgrCurrentdecision.contains(Status)) {

				Utilities.passresult(methodname, "Agreement staus:PDI-Motorfrontend are " + Status, Status,datetimestart);
				Thread.sleep(700);
			} else {
				Utilities.failresult(methodname, "Agreement staus:PDI-Motorfrontend are not equal" + Status, Status,datetimestart);
				Thread.sleep(700);

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Addresshistory() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_paymethod));
			select.selectByVisibleText(Driver.getData("Methodofpay"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).sendKeys(Driver.getData("Bnksrtcode1"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).sendKeys(Driver.getData("Bnksrtcode2"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).sendKeys(Driver.getData("Bnksrtcode3"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).sendKeys(Driver.getData("Bnkacno"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_MoveinDate).click();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_MoveinDate).clear();

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressYears).click();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressYears).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressYears).sendKeys(Driver.getData("AddressinYears"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressMonths).click();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressMonths).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressMonths).sendKeys(Driver.getData("AddressinMonths"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);
		

			String errortxt = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_AdresshistoryError).getText().toString();
			Thread.sleep(750);

			if (errortxt.contains("3 years of address history")) {
				Utilities.passresult(methodname, " Address years and months lesser than 3 years throws the error", errortxt,datetimestart);

			} else {
				Utilities.failresult(methodname, "Time at Address and Months lesser than 3 is NOT throws an error message ",errortxt, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_MoveinDate).click();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_MoveinDate).clear();

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressYears).click();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressYears).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressYears).sendKeys(Driver.getData("AddressinYears1"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressMonths).click();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressMonths).clear();
			Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_TimeatAddressMonths).sendKeys(Driver.getData("AddressinMonths1"));
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// pagename
			String pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(750);

			if (pagename.contains(Driver.getData("Pagename"))) {

				Utilities.passresult(methodname, "Address history more than 3 navigated to next page affordability", pagename,datetimestart);
			} else {

				Utilities.failresult(methodname, "Address history more than 3  not navigated to next page affordability",pagename, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void Update_comparison() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{

			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);

			Common_Property.driver.findElement(POM_StartLine.SMF_DecisionbottonNewagreement_Link).click();
			Thread.sleep(2000);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumberbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);

			agreementno = Driver.getData("Agreement_Number");

			Utilities.passresult(methodname, "Updated data of an agreement is " + agreementno, agreementno,datetimestart);

			Common_Property.driver.findElement(POM_StartLine.SMF_AgreementSearchGrid_Searchbutton).click();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_TermstoPersonal).click();
			Thread.sleep(1000);

			// drivinglicensetype
			Select comboBox = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicenceType));
			String Dtype = comboBox.getFirstSelectedOption().getText();

			Select comboBox1 = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_DrivingLicenceOrgin));
			String Dorgin = comboBox1.getFirstSelectedOption().getText();

			String noofdependent = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_NoofDependants).getAttribute("value");
			Thread.sleep(1000);

			if (Driver.getData("UpdatePropoVersion").contains("V1")|| Driver.getData("UpdatePropoVersion").contains("V2")) // Code to Update version 1 or Version 2 values comparision 
				{
				String bankacno = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).getAttribute("value");
				Thread.sleep(1000);
				String sortcode1 = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).getAttribute("value");
				String sortcode2 = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).getAttribute("value");
				String sortcode3 = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).getAttribute("value");
				if (sortcode1.contains(Driver.getData("Ubanksrtcode1"))&& sortcode2.contains(Driver.getData("Ubanksrtcode2"))&& sortcode3.contains(Driver.getData("Ubanksrtcode3"))) {

					Utilities.passresult(methodname, "Bank sortcode1 updated successfully with the value" + sortcode1,sortcode1, datetimestart);
					Utilities.passresult(methodname, "Bank sortcode2 updated successfully with the value" + sortcode2,sortcode2, datetimestart);
					Utilities.passresult(methodname, "Bank sortcode3 updated successfully with the value" + sortcode3,sortcode3, datetimestart);
				} else {

					Utilities.failresult(methodname, "Bank sortcode1 is not Updated", sortcode1, datetimestart);
					Utilities.failresult(methodname, "Bank sortcode2 is not Updated", sortcode2, datetimestart);
					Utilities.failresult(methodname, "Bank sortcode3 is not Updated", sortcode3, datetimestart);
				}

				if (bankacno.contains(Driver.getData("Ubankacno"))) {

					Utilities.passresult(methodname,"Bank accountnumber updated successfully with the value" + bankacno, bankacno,datetimestart);
				} else {

					Utilities.failresult(methodname, "Bank accountnumber is not Updated", bankacno, datetimestart);
				}
			}
			if (Driver.getData("UpdatePropoVersion").contains("V2")) // Code to check updated values of Version2 Update
			
			{
				if (Dtype.equalsIgnoreCase(Driver.getData("Udrivetype")))

				{

					Utilities.passresult(methodname, "Driving licence type updated successfully with the value" + Dtype,Dtype, datetimestart);
				} else {

					Utilities.failresult(methodname, "Driving licence type is not Updated", Dtype, datetimestart);
				}
				if (Dorgin.equalsIgnoreCase(Driver.getData("Udriveorgin"))) {

					Utilities.passresult(methodname,"Driving licence orgin updated successfully with the value" + Dorgin, Dorgin,datetimestart);
				} else {

					Utilities.failresult(methodname, "Driving licence orgin is not Updated", Dorgin, datetimestart);
				}
				if (noofdependent.equalsIgnoreCase(Driver.getData("Unoofdepent"))) {

					Utilities.passresult(methodname,"No of Dependants updated successfully with the value" + noofdependent, noofdependent,datetimestart);
				} else {

					Utilities.failresult(methodname, "No of Dependants is not Updated", noofdependent, datetimestart);
				}

				// affordabilitypagetab
				Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_personaltoAffordpage).click();
				Thread.sleep(1000);

				String grossamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Affordpage_Grossamnt).getAttribute("value");
				Thread.sleep(750);
				String netamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Affordpage_Netamnt).getAttribute("value");
				Thread.sleep(750);
				String caramnt = Common_Property.driver.findElement(POM_StartLine.SMF_Affordpage_Caramnt).getAttribute("value");
				Thread.sleep(750);
				String rentamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Affordpage_Rentamnt).getAttribute("value");
				Thread.sleep(750);

				float grossamnt1 = Float.parseFloat(grossamnt);
				String a = Driver.getData("Ugrossamnt");
				float grosamnt2 = Float.parseFloat(a);

				float netamnt1 = Float.parseFloat(netamnt);
				String a1 = Driver.getData("Unetamnt");
				float netamnt2 = Float.parseFloat(a1);

				float caramnt1 = Float.parseFloat(caramnt);
				String a2 = Driver.getData("Ucaramnt");
				float caramnt2 = Float.parseFloat(a2);

				float rentamnt1 = Float.parseFloat(rentamnt);
				String a3 = Driver.getData("Urentamnt");
				float rentamnt2 = Float.parseFloat(a3);

				if (grossamnt1 == grosamnt2) {

					Utilities.passresult(methodname, "Grossamount updated successfully with the value" + grossamnt,grossamnt, datetimestart);
				} else {

					Utilities.failresult(methodname, "Grossamount is not Updated", grossamnt, datetimestart);
				}

				if (netamnt1 == netamnt2) {

					Utilities.passresult(methodname, "netamnt updated successfully with the value" + netamnt, netamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "netamnt is not Updated", netamnt, datetimestart);
				}

				if (caramnt1 == caramnt2) {

					Utilities.passresult(methodname, "caramnt updated successfully with the value" + caramnt, caramnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "caramnt is not Updated", caramnt, datetimestart);
				}
				if (rentamnt1 == rentamnt2) {

					Utilities.passresult(methodname, "rentamnt updated successfully with the value" + rentamnt,rentamnt, datetimestart);
				} else {

					Utilities.failresult(methodname, "rentamnt is not Updated", rentamnt, datetimestart);
				}
			}

			// financials tab
			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(1000);

			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Goodscostimgplus).click();
			Thread.sleep(1000);

			if (Driver.getData("UpdatePropoVersion").contains("V1")) // Update V1 comaprision
			{

				String gapamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Gapamnt).getAttribute("value");
				Thread.sleep(750);
				Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_GoodscostbreakBack).click();
				Thread.sleep(1000);
				String partex = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_PartExchange).getAttribute("value");
				Thread.sleep(750);

				float partex1 = Float.parseFloat(partex);
				String a5 = Driver.getData("Upartex");
				float partex2 = Float.parseFloat(a5);

				float gapamnt1 = Float.parseFloat(gapamnt);
				String a4 = Driver.getData("Ugapamnt");
				float gapamnt2 = Float.parseFloat(a4);

				if (gapamnt1 == gapamnt2) {

					Utilities.passresult(methodname, "Gapamount updated successfully with the value" + gapamnt, gapamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "Gapamount is not Updated", gapamnt, datetimestart);
				}

				if (partex1 == partex2) {

					Utilities.passresult(methodname,"Partexchange amount updated successfully with the value" + gapamnt, gapamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "Partexchange amount is not Updated", gapamnt, datetimestart);
				}

			} else if (Driver.getData("UpdatePropoVersion").contains("V2")) {

				String gapamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Gapamnt).getAttribute("value");
				Thread.sleep(750);
				String paintproamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_PaintProamnt).getAttribute("value");
				Thread.sleep(750);
				String tyreinsamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Tyreinsamnt).getAttribute("value");
				Thread.sleep(750);
				String warrantyamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Warantyamnt).getAttribute("value");
				Thread.sleep(750);

				float gapamnt1 = Float.parseFloat(gapamnt);
				String a4 = Driver.getData("Ugapamnt");
				float gapamnt2 = Float.parseFloat(a4);

				float paintproamnt1 = Float.parseFloat(paintproamnt);
				String a5 = Driver.getData("Upaintproamnt");
				float paintproamnt2 = Float.parseFloat(a5);

				float tyreinsamnt1 = Float.parseFloat(tyreinsamnt);
				String a6 = Driver.getData("Utyreamnt");
				float tyreinsamnt2 = Float.parseFloat(a6);

				float warrantyamnt1 = Float.parseFloat(warrantyamnt);
				String a7 = Driver.getData("Uwarrantyamnt");
				float warrantyamnt2 = Float.parseFloat(a7);

				if (gapamnt1 == gapamnt2) {

					Utilities.passresult(methodname, "Gapamount updated successfully with the value" + gapamnt, gapamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "Gapamount is not Updated", gapamnt, datetimestart);
				}

				if (paintproamnt1 == paintproamnt2) {

					Utilities.passresult(methodname,"Paint protect amount updated successfully with the value" + paintproamnt, paintproamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "Paint protect amount  is not Updated", paintproamnt,datetimestart);
				}
				if (tyreinsamnt1 == tyreinsamnt2) {

					Utilities.passresult(methodname,"Tyre insurance amount updated successfully with the value" + tyreinsamnt, tyreinsamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "Tyre insurance amount is not Updated", tyreinsamnt,datetimestart);
				}

				if (warrantyamnt1 == warrantyamnt2) {

					Utilities.passresult(methodname,
							"Warranty amount updated successfully with the value" + warrantyamnt, warrantyamnt,datetimestart);
				} else {

					Utilities.failresult(methodname, "Warranty amount is not Updated", warrantyamnt, datetimestart);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_GoodscostbreakBack).click();
				Thread.sleep(1000);
			}

			// financial tab
			// calculate
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
			Thread.sleep(1000);
			// continue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(1000);
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Update_compareV1() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);

			Common_Property.driver.findElement(POM_StartLine.Motorfrontend_footernewAgreement).click();
			Thread.sleep(2000);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumberbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);

			agreementno = Driver.getData("Agreement_Number");

			Utilities.passresult(methodname, "Updated data of an agreement is " + agreementno, agreementno,datetimestart);

			Common_Property.driver.findElement(POM_StartLine.SMF_AgreementSearchGrid_Searchbutton).click();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_TermstoPersonal).click();
			Thread.sleep(1000);

			String bankacno = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_BankAcno).getAttribute("value");
			Thread.sleep(1000);

			// drivinglicensetype

			String sortcode1 = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode1).getAttribute("value");
			String sortcode2 = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode2).getAttribute("value");
			String sortcode3 = Common_Property.driver.findElement(POM_StartLine.SMF_Personaldetailspage_Sortcode3).getAttribute("value");

			if (bankacno.contains(Driver.getData("Ubankacno"))) {

				Utilities.passresult(methodname, "Bank accountnumber updated successfully with the value" + bankacno,bankacno, datetimestart);
			} else {

				Utilities.failresult(methodname, "Bank accountnumber is not Updated", bankacno, datetimestart);
			}

			if (sortcode1.contains(Driver.getData("Ubanksrtcode1"))&& sortcode2.contains(Driver.getData("Ubanksrtcode2"))&& sortcode3.contains(Driver.getData("Ubanksrtcode3"))) {

				Utilities.passresult(methodname, "Bank sortcode1 updated successfully with the value" + sortcode1,sortcode1, datetimestart);
				Utilities.passresult(methodname, "Bank sortcode2 updated successfully with the value" + sortcode2,sortcode2, datetimestart);
				Utilities.passresult(methodname, "Bank sortcode3 updated successfully with the value" + sortcode3,sortcode3, datetimestart);
			} else {

				Utilities.failresult(methodname, "Bank sortcode1 is not Updated", sortcode1, datetimestart);
				Utilities.failresult(methodname, "Bank sortcode2 is not Updated", sortcode2, datetimestart);
				Utilities.failresult(methodname, "Bank sortcode3 is not Updated", sortcode3, datetimestart);
			}

			// financials tab
			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Goodscostimgplus).click();
			Thread.sleep(1000);
			String gapamnt = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Gapamnt).getAttribute("value");
			Thread.sleep(750);
			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_GoodscostbreakBack).click();
			Thread.sleep(1000);
			String partex = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_PartExchange).getAttribute("value");
			Thread.sleep(750);

			float partex1 = Float.parseFloat(partex);
			String a5 = Driver.getData("Upartex");
			float partex2 = Float.parseFloat(a5);

			float gapamnt1 = Float.parseFloat(gapamnt);
			String a4 = Driver.getData("Ugapamnt");
			float gapamnt2 = Float.parseFloat(a4);

			if (gapamnt1 == gapamnt2) {

				Utilities.passresult(methodname, "Gapamount updated successfully with the value" + gapamnt, gapamnt,datetimestart);
			} else {

				Utilities.failresult(methodname, "Gapamount is not Updated", gapamnt, datetimestart);
			}

			if (partex1 == partex2) {

				Utilities.passresult(methodname, "Partexchange amount updated successfully with the value" + gapamnt,gapamnt, datetimestart);
			} else {

				Utilities.failresult(methodname, "Partexchange amount is not Updated", gapamnt, datetimestart);
			}

			// financial tab
			// calculate
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
			Thread.sleep(1000);
			// continue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(1000);

		}

		catch (Exception e)

		{

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void Callmanualapproved() throws Exception

	{
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try {

			int f = Integer.parseInt(BankEnhancedscore);
			System.out.println(f);
			int G = 45;
			if (f < G) {
				// manual over ride
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Manualoverride).click();
				Thread.sleep(700);
				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Thread.sleep(700);
				Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Utilities.passresult(methodname, "Agreement plan is" + Plan, Plan, datetimestart);

				// Accpetd without esign events query
				ArrayList<String> activitys = new ArrayList<String>();
				activitys.add(0, "Automatically Approved");
				activitys.add(1, "CV Override Decision Made");
				activitys.add(2, "Approved Pack Requested");
				Agreementevents.Agr_events_check(activitys, null, null, "AC", "CVMA"); // Status:AC-Accepted,Plan:CVMA-Call validate manual approved
			
				// documents
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(850);

				String AccDocname = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (AccDocname.contains(Driver.getData("AccDocumentname1"))) {

					Utilities.passresult(methodname, "Document is generated sucessfully", AccDocname, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.failresult(methodname, "Document is NOT generated ", null, datetimestart);
					Thread.sleep(700);
				}
				// documents back
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Callcondionalapproved() throws Exception

	{
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);

			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Manualoverride).click();
			Thread.sleep(850);

			Status1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();

			String a = new String(Status1);
			Status = a.replace(Status1, "Conditional Accept");

			String plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			System.out.println(Driver.getData("AccStatus"));

			if (Status.contains(Driver.getData("AccStatus"))) {

				Utilities.passresult(methodname, "Status is " + Status, null, datetimestart);
				Thread.sleep(700);
			} else {

				Utilities.failresult(methodname, "Status is " + Status, null, datetimestart);
				Thread.sleep(700);
			}
			if (plan.contains(Driver.getData("AccplannameE"))) {

				Utilities.passresult(methodname, "Status is " + plan, null, datetimestart);
				Thread.sleep(700);
			} else {

				Utilities.failresult(methodname, "Status is " + plan, null, datetimestart);
				Thread.sleep(700);
			}
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void WithGuarantors(Recordset record) throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_Surnname).sendKeys(Driver.getData("Gsurname"));
			Thread.sleep(250);

			Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_Forename).sendKeys(Driver.getData("Gforename"));
			Thread.sleep(250);

			Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_Search).click();
			Thread.sleep(750);

			Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_Guarantornamelink).click();
			Thread.sleep(750);

			// Guarantors continue
			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(750);

			// get agreement number
			agreementno = Common_Property.driver.findElement(POM_StartLine.SMF_Guarantorpage_MotorfrontendAgrno).getText().toString();
			System.out.println(agreementno);
			
			Utilities.passresult(methodname, "Guarantors added successfully", agreementno, datetimestart);
			// Driver.put_agr_no=agreementno;
			if (agreementno != null) {

				String Desc = "Agreement is Created Successfully " + agreementno;
				Utilities.passresult(methodname, Desc, agreementno, datetimestart);
				Thread.sleep(9000);
				Agreement_Store.Store_Data(Driver.WhichClient, agreementno, "", record);

			} else {

				String Desc = "Agreement Number is not Generated ";
				Utilities.failresult(methodname, Desc, agreementno, datetimestart);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Finishlinebrand() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try

		{
			// Refresh

			WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
			jse.executeScript("arguments[0].click();", element);

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_ChangeBrandDDL));
			select.selectByValue("102724");
			Thread.sleep(950);

			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).clear();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).sendKeys(Driver.getData("Fproposrate"));
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
			Thread.sleep(700);

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
			Thread.sleep(700);
			// refresh

			WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element1);

			String Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
			Utilities.passresult(methodname, "Agreement status is" + Status, Status, datetimestart);
			Thread.sleep(700);

			Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			Utilities.passresult(methodname, "Agreement Plan is" + Plan, Plan, datetimestart);

			installment = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Installment).getText().toString();

			Utilities.passresult(methodname, "Installment amount is " + installment, installment, datetimestart);
			Thread.sleep(750);
			// financial tab
			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(700);

			Adminfee = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Adminfeetext).getAttribute("value");
			Thread.sleep(350);
			System.out.println("admin fee is" + Adminfee);

			Balloon = Driver.getData("Baloon");
			Thread.sleep(350);
			System.out.println(Balloon);

			String Delaerdepo = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_DelaerDeposit).getAttribute("Value");
			Thread.sleep(350);

			String Partex = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_PartExchange).getAttribute("Value");
			Thread.sleep(350);

			Advance = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Advance).getText().toString();
			Thread.sleep(350);
			float Adv = Float.parseFloat(Advance);
			String goodscost = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Goodscost).getText().toString();
			Thread.sleep(350);

			float Delaerdepo1 = Float.parseFloat(Delaerdepo);
			float Partex1 = Float.parseFloat(Partex);
			float totalamnt = Delaerdepo1 + Partex1;
			float goodscost1 = Float.parseFloat(goodscost);
			float Advance1 = goodscost1 - totalamnt;
			if (Advance1 == Adv) {

				String Desc = "Advance amount verified is" + Advance;
				Utilities.passresult(methodname, Desc, null, datetimestart);
			} else {

				String Desc = "Advance amount is updated incorrectly";
				Utilities.failresult(methodname, Desc, null, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
			Thread.sleep(950);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Returntointroducer() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// Refresh
			WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element1);
			// Return to introducer

			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_ReturntoIntroducer).click();
			Thread.sleep(950);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
			Thread.sleep(700);

			Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);

			String Returnplan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			Thread.sleep(700);
			Utilities.passresult(methodname, "Plan is " + Returnplan, Returnplan, datetimestart);

			String RTICount = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_RTIcount).getText().toString();
			Thread.sleep(950);

			int count = Integer.parseInt(RTICount);
			if (count == 1) {
				Utilities.passresult(methodname, "Return to introducer count is increased" + RTICount, RTICount,datetimestart);
			}

			else {
				Utilities.failresult(methodname, "Return to introducer count is not increased" + RTICount, RTICount,datetimestart);
			}

			System.out.println(Driver.getData("AccStatus"));
			System.out.println(Driver.getData("AccplannameE"));
			if (Status.contains(Driver.getData("AccStatus")) && Returnplan.contains(Driver.getData("AccplannameE"))) {

				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Utilities.passresult(methodname, "Plan is " + Returnplan, Returnplan, datetimestart);
			} else {

				Utilities.failresult(methodname, "Status is  not as expected" + Status, Status, datetimestart);
				Utilities.failresult(methodname, "Plan is  not as expected" + Returnplan, Returnplan, datetimestart);
			}

			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();
			// Activities ArrayList
			activitys.add(0, "Agreement Status Changed");
			activitys.add(1, "Dealer Refer letter requested");
			Primaryvalue.add(0, "Return to Introducer");
			Secondaryvalue.add(0, "Referred");
			Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "RTI", "CVAR"); // Status:RTI-Retrun to introducer,Plan:CVAR CallvalidateAuto 
		
			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
			Thread.sleep(950);

			String Document = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
			Thread.sleep(700);
			if (Document.contains(Driver.getData("AccEDocumentname1"))) {
				Utilities.passresult(methodname, "Document generated successfullly and its name is" + Document, null,datetimestart);
				Thread.sleep(700);
			} else {

				Utilities.failresult(methodname, "Documentis NOT generated", null, datetimestart);
				Thread.sleep(700);
			}
			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
			Thread.sleep(700);
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Manualrejection() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// Refresh
			WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element1);

			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Rejectbutton).click();
			Thread.sleep(950);

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Rejectreason));
			select.selectByValue("103990");
			Thread.sleep(350);

			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_RejectBack).click();
			Thread.sleep(850);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();

			if (Status.contains(Driver.getData("AccStatus"))) {

				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Thread.sleep(700);
			} else {
				Utilities.failresult(methodname, "Status is " + Status, Status, datetimestart);
				Thread.sleep(700);
			}

			Plan1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();

			if (Plan1.contains(Driver.getData("AccplannameE"))) {

				Utilities.passresult(methodname, "Agreement Plan is under " + Plan1, null, datetimestart);
				Thread.sleep(700);
			} else {
				Utilities.failresult(methodname, "Plan is not under the" + Plan1, null, datetimestart);

			}

			// Manual Rejected Events

			ArrayList<String> activitys = new ArrayList<String>();
			activitys.add(0, "Manually Rejected");
			activitys.add(1, "Reject Letter Requested");
			Agreementevents.Agr_events_check(activitys, null, null, "RD", "CVMD"); // Status:RD-RejecteD,Plan:Call validate Manual decline
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
			Thread.sleep(850);

			String Document = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
			Thread.sleep(850);

			if (Document.contains(Driver.getData("Docname"))) {

				Utilities.passresult(methodname,"Document" + Document + " is generated and it has been validated successfully", Document,datetimestart);
				Thread.sleep(700);
			} else {

				Utilities.failresult(methodname, "Document" + Document + "is NOT generated", Document, datetimestart);
				Thread.sleep(700);
			}

			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
			Thread.sleep(850);
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void FLAutoRejection() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try {

			WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element1);

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_ChangeBrandDDL));
			select.selectByValue("102724");
			Thread.sleep(950);

			WebElement element2 = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
			JavascriptExecutor jse2 = (JavascriptExecutor) Common_Property.driver;
			jse2.executeScript("arguments[0].click();", element2);

			Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
			Utilities.passresult(methodname, "Status is " + Status, null, datetimestart);
			Thread.sleep(700);

			String Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
			Utilities.passresult(methodname, "Status is " + Plan, null, datetimestart);

			if (Status.contains(Driver.getData("AccStatus")) && Plan.contains(Driver.getData("AccplannameE"))) {

				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Utilities.passresult(methodname, "Plan is " + Plan, Plan, datetimestart);
				Thread.sleep(700);
			}

			else {

				Utilities.failresult(methodname, "Status is NOT displayed as" + Status, Status, datetimestart);
				Utilities.failresult(methodname, "Plan is  not displayed as" + Plan, Plan, datetimestart);
				Thread.sleep(700);
			}
			
			
			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
			Thread.sleep(850);

			String Document = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
			Thread.sleep(850);

			if (Document.contains(Driver.getData("Docname"))) {

				Utilities.passresult(methodname,"Document" + Document + " is generated and it has been validated successfully", Document,datetimestart);
				Thread.sleep(700);

			}

			else {

				Utilities.failresult(methodname, "Document" + Document + "is NOT generated", Document, datetimestart);
				Thread.sleep(700);

			}

			Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
			Thread.sleep(850);
			// FL auto Rejected Events
			ArrayList<String> activitys = new ArrayList<String>();

			// Activities ArrayList
				activitys.add(0, "Automatically Rejected");
				activitys.add(1, "Post Bureau Decision Made");
				activitys.add(2, "Reject Letter Requested");
				Agreementevents.Agr_events_check(activitys, null, null, "RD", "FLPreVet"); // Status:RD-RejecteD, Plan:FLPreVet-Finishline Pre vet auto decline

		}

		catch (Exception e)

		{
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	@SuppressWarnings("unused")
	public static void Prevetmanualdecline() throws Exception

	{

		{

			System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			Date sdate = new Date();
			String datetimestart = dateFormat.format(sdate);

			try {

				// new agreements

				Utilities.ExtentPassReport(methodname);
				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				WebElement element1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Rejectbutton);
				JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
				jse1.executeScript("arguments[0].click();", element1);

				Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Rejectreason));
				select.selectByValue("103990");
				Thread.sleep(350);

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_RejectBack).click();
				Thread.sleep(850);

				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();

				if (Status.contains(Driver.getData("AccStatus"))) {

					Utilities.passresult(methodname, "Motor front end Status is " + Status, Status, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.failresult(methodname, "Motor front end ststus is" + Status, Status, datetimestart);
					Thread.sleep(700);
				}

				Plan1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();

				if (Plan1.contains(Driver.getData("AccplannameE")))

				{

					Utilities.passresult(methodname, "Agreement Plan is under " + Plan1, Plan1, datetimestart);
					Thread.sleep(700);

				}

				else {
					Utilities.failresult(methodname, "Plan is not under the" + Plan1, Plan1, datetimestart);

				}

				// Prevetmanual Rejected Events

				ArrayList<String> activitys = new ArrayList<String>();

				// Activities ArrayList
				activitys.add(0, "Manually Rejected");
				activitys.add(1, "Pre Vet Decision Made");
				activitys.add(2, "Call Report Search Required");
				activitys.add(3, "Reject Letter Requested");

				Agreementevents.Agr_events_check(activitys, null, null, "RD", "PreVetManual"); // Status:RD-RejecteD,Plan:PreVetManual-Prevet manual decline
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(850);

				String Document = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (Document.contains(Driver.getData("Docname"))) {

					Utilities.passresult(methodname,"Document" + Document + " is generated and it has been validated successfully", Document,datetimestart);
					Thread.sleep(700);

				}

				else {

					Utilities.failresult(methodname, "Document" + Document + "is NOT generated", Document,datetimestart);
					Thread.sleep(700);
				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);

			}

			catch (Exception e) {

				System.out.println("The exception was " + e);
				System.out.println("Abnormal Termination due to " + e);
				String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
				Utilities.failresult(methodname, Desc, null, datetimestart);

			}

		}

	}

	public static void Declinedecisionresaon() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumberbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			agreementno = Driver.getData("Agreement_Number");
			Thread.sleep(100000);

			Common_Property.driver.findElement(POM_StartLine.SMF_AgreementSearchGrid_Searchbutton).click();
			Thread.sleep(750);
			if (Driver.getData("Modeofcreation").contains("P")) {

				// View
				Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_Viewelecproposal).click();
				Thread.sleep(700);

				// Close
				Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_elecproposalclose).click();
				Thread.sleep(700);
			}
			// Agreementlink
			Common_Property.driver.findElement(POM_StartLine.SMF_Agreementnumber_hyperlink).click();
			Thread.sleep(700);

			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			if (pagename.contains("Financials")) {
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(700);
			} else {
				Common_Property.driver.findElement(By.linkText("Refresh")).click();
			}

			WebElement element = Common_Property.driver.findElement(By.linkText("Refresh"));
			JavascriptExecutor jse1 = (JavascriptExecutor) Common_Property.driver;
			jse1.executeScript("arguments[0].click();", element);

			String Decisionreasons = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionreason1).getText().toString();
			Thread.sleep(700);
			
			String Declinereasons = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionreason2).getText().toString();
			Thread.sleep(700);
			
			if (Decisionreasons.contains(Driver.getData("Decisionreasons"))&& Declinereasons.contains(Driver.getData("Declinedecisionreason1"))) 
				{
				String Declinereason = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionreason2).getText().toString();
				Thread.sleep(700);
				if (Declinereason.contains(Driver.getData("Declinedecisionreason1"))) 
				{
					Utilities.passresult(methodname,"Decline Decision reason is displayed as expceted as" + Declinereason, Declinereason,datetimestart);
				}
			}

			else {
				
				String Decisionreason = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionreason3).getText().toString();
				Thread.sleep(700);
				
				if (Decisionreason.contains(Driver.getData("Declinedecisionreason2")))
				{
					Utilities.passresult(methodname,"Decline Decision reason is displayed as expceted as" + Decisionreason, Decisionreason,datetimestart);
				}
			}

		}

		catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void AutoRejectedPrevet() throws Exception

	{

		
			System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			Date sdate = new Date();
			String datetimestart = dateFormat.format(sdate);

			try {

				// Refresh
				Utilities.ExtentPassReport(methodname);
				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Thread.sleep(700);

				String Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Utilities.passresult(methodname, "Plan is " + Plan, Plan, datetimestart);

				if (Status.contains(Driver.getData("AccStatus")) && Plan.contains(Driver.getData("AccplannameE"))) {

					Utilities.passresult(methodname, "Motor front End Status is " + Status, Status, datetimestart);
					Utilities.passresult(methodname, "Motor front End  Plan is " + Plan, Plan, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.failresult(methodname, "Status is NOT displayed as" + Status, Status, datetimestart);
					Utilities.failresult(methodname, "Plan is  not displayed as" + Plan, Plan, datetimestart);
					Thread.sleep(700);
				}

				// auto Rejected Events

				ArrayList<String> activitys = new ArrayList<String>();
				activitys.add(0, "Automatically Rejected");
				activitys.add(1, "Pre Vet Decision Made");
				activitys.add(2, "Call Report Search Required");
				activitys.add(3, "Reject Letter Requested");
				Agreementevents.Agr_events_check(activitys, null, null, "RD", "PreVet"); //Status: RD-RejecteD,Plan:PreVet-Prevetautodecline
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(850);

				String Document = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);

				if (Document.contains(Driver.getData("Docname"))) {

					Utilities.passresult(methodname,"Document" + Document + " is generated and it has been validated successfully", Document,datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.failresult(methodname, "Document" + Document + "is NOT generated", Document,datetimestart);
					Thread.sleep(700);

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);

			}

			catch (Exception e)

			{
				System.out.println("The exception was " + e);
				System.out.println("Abnormal Termination due to " + e);
				String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
				Utilities.failresult(methodname, Desc, null, datetimestart);

			}

	}

	

	public static void AutoRejectedPostBureau() throws Exception

	{

		{

			System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			Date sdate = new Date();
			String datetimestart = dateFormat.format(sdate);

			try {

				// Refresh
				Utilities.ExtentPassReport(methodname);
				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				Status = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Status).getText().toString();
				Utilities.passresult(methodname, "Status is " + Status, Status, datetimestart);
				Thread.sleep(700);

				String Plan = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Plan).getText().toString();
				Utilities.passresult(methodname, "Plan is " + Plan, Plan, datetimestart);
				

				if (Status.contains(Driver.getData("AccStatus")) && Plan.contains(Driver.getData("AccplannameE"))) {

					Utilities.passresult(methodname, "Motor front End Status is " + Status, Status, datetimestart);
					Utilities.passresult(methodname, "Motor front End  Plan is " + Plan, Plan, datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.failresult(methodname, "Status is NOT displayed as" + Status, Status, datetimestart);
					Utilities.failresult(methodname, "Plan is  not displayed as" + Plan, Plan, datetimestart);
					Thread.sleep(700);
				}

				// auto Rejected Events

				ArrayList<String> activitys = new ArrayList<String>();

				activitys.add(0, "Automatically Rejected");
				activitys.add(1, "Call Report Search Required");
				activitys.add(2, "Post Bureau Decision Made");
				activitys.add(3, "Reject Letter Requested");

				Agreementevents.Agr_events_check(activitys, null, null, "RD", "PostAD"); // Status RD-Rejected,Plan:PostAD-Post bureau declines
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Documents).click();
				Thread.sleep(850);

				String Document = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_Document1name).getText().toString();
				Thread.sleep(850);


				if (Document.contains(Driver.getData("Docname"))) {

					Utilities.passresult(methodname,"Document" + Document + " is generated and it has been validated successfully", Document,datetimestart);
					Thread.sleep(700);
				}

				else {

					Utilities.failresult(methodname, "Document" + Document + "is NOT generated", Document,datetimestart);
					Thread.sleep(700);

				}

				Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_DocumentBack).click();
				Thread.sleep(850);


			}

			catch (Exception e)

			{
				System.out.println("The exception was " + e);
				System.out.println("Abnormal Termination due to " + e);
				String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
				Utilities.failresult(methodname, Desc, null, datetimestart);

			}

		}

	}

	// backoffice

	public static void BO_Status_check() {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(20000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Openlink).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementservicing).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementslink).click();
			Thread.sleep(5000);

			// MAINTAIN CUSTOMER AGREEMENT
			// 6 or 7
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementfindlink).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementdetailslink).click();
			Thread.sleep(10500);
			String ver = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Agreementstatus).getAttribute("value");
			Thread.sleep(5000);
			System.out.println(ver);

			Thread.sleep(2000);

			if (ver.equalsIgnoreCase(Driver.getData("BoStatus"))) {

				String Desc = "Backoffice Status is " + Driver.getData("BoStatus");
				Utilities.passresult(methodname, Desc, null, datetimestart);

			} else {

				String Desc = "Backoffice Status is not " + Driver.getData("BoStatus") + " Failed";
				Utilities.failresult(methodname, Desc, null, datetimestart);
			}

			// view schedules
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_View).click();
			Thread.sleep(5000);

			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_ViewSchedules).click();
			Thread.sleep(5000);

			String insamt = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Installmentamnt).getText().toString();
			Thread.sleep(5000);

			if (insamt.equalsIgnoreCase(installment)) {

				String Desc = "Backoffice Instalamt verified" + insamt;
				Utilities.passresult(methodname, Desc, null, datetimestart);

			} else {

				String Desc = "Backoffice Installment amt is incorrect";
				Utilities.failresult(methodname, Desc, null, datetimestart);
			}
			Thread.sleep(5000);
			// view schedule close
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_ViewClose).click();
			Thread.sleep(8000);

			// agreement level
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Agreementlevelbutton).click();
			Thread.sleep(5000);

			// select an agreement
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Selectagreement).click();
			Thread.sleep(5000);
			// click ok
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_AgreementlevelOKbutton).click();
			Thread.sleep(5000);
			// maintain
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Maintainlink).click();
			Thread.sleep(5000);
			// additional attributes
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MaintainAddtionalAttributes).click();
			Thread.sleep(5000);
			// scrolldown
			int i;
			for (i = 0; i <= 58; i++) {

				Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MaintainAddtionalAttributeScrolldown).click();

			}
			// trace score

			Thread.sleep(8000);

			String Tracescore = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Tracescore).getText().toString();
			System.out.println("Tracecore displayed as"+Tracescore);
			Thread.sleep(8000);

			int t = Integer.parseInt(Tracescore);
			int s = 50;

			if (t > s) {

				Utilities.passresult(methodname, "Trace score of an agreement is greater than 50", Tracescore,datetimestart);
				Thread.sleep(5000);

			}

			else {

				Utilities.failresult(methodname, "Trace score of an agreement is less than 50", Tracescore,	datetimestart);
				Thread.sleep(5000);

			}

			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MaintainAddtionalAttributeSave).click();
			Thread.sleep(5000);

			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MadWindowClose).click();
			Thread.sleep(5000);

		//	Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementswindowClose).click();
			Thread.sleep(5000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

public static void BO_RejStatus_check() {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(10000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Openlink).click();
			Thread.sleep(8000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementservicing).click();
			Thread.sleep(8000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementslink).click();
			Thread.sleep(9000);

			// MAINTAIN CUSTOMER AGREEMENT
			// 6 or 7
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).click();
			Thread.sleep(8000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(6000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementfindlink).click();
			Thread.sleep(8000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementdetailslink).click();
			Thread.sleep(10500);
			String ver = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Agreementstatus).getAttribute("value");
			Thread.sleep(6000);
			System.out.println(ver);

			Thread.sleep(8000);

			if (ver.equalsIgnoreCase(Driver.getData("BoStatus"))) {

				String Desc = "Backoffice Status is " + Driver.getData("BoStatus");
				Utilities.passresult(methodname, Desc, null, datetimestart);

			} else {

				String Desc = "Backoffice Status is not " + Driver.getData("BoStatus") + " Failed";
				Utilities.failresult(methodname, Desc, null, datetimestart);
			}

			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MadWindowClose).click();
			Thread.sleep(6000);

			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementswindowClose).click();
			Thread.sleep(6000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	

	public static void BO_Balloon_verification()   {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(10000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Openlink).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementservicing).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementslink).click();
			Thread.sleep(5000);

			// MAINTAIN CUSTOMER AGREEMENT
			// 6 or 7
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementfindlink).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementdetailslink).click();
			Thread.sleep(10500);
			String ver = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Agreementstatus).getAttribute("value");
			Thread.sleep(5000);
			System.out.println(ver);

			Thread.sleep(2000);

			if (ver.equalsIgnoreCase(Driver.getData("BoStatus"))) {

				String Desc = "Backoffice Status is " + Driver.getData("BoStatus");
				Utilities.passresult(methodname, Desc, null, datetimestart);

			} else {

				String Desc = "Backoffice Status is not " + Driver.getData("BoStatus") + " Failed";
				Utilities.failresult(methodname, Desc, null, datetimestart);
			}			
			// view 
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_View).click();
			Thread.sleep(5000);
			//schedules
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_ViewSchedules).click();
			Thread.sleep(5000);

			String insamt = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Installmentamnt).getText().toString();
			Thread.sleep(5000);

			if (insamt.equalsIgnoreCase(installment)) {

				String Desc = "Backoffice Instalamt verified" + insamt;
				Utilities.passresult(methodname, Desc, null, datetimestart);

			} else {

				String Desc = "Backoffice Installment amt is incorrect";
				Utilities.failresult(methodname, Desc, null, datetimestart);
			}
			Thread.sleep(3000);
		
			int i;
			for (i = 0; i <= 30; i++) {

				Common_Property.driver.findElement(POM_StartLine.BOMADWindow_InstallmentamntScrolldown).click();
			}

			Thread.sleep(1000);
			String balloonamt = Common_Property.driver.findElement(POM_StartLine.BOMADWindow_Balloonamnt).getText().toString();
			System.out.println("ballon amount is" + balloonamt);
			Thread.sleep(1000);

			if (balloonamt.equalsIgnoreCase(Driver.getData("Baloon")))
			{

				String Desc = "Backoffice balloon amt verified : " + balloonamt;
				Utilities.passresult(methodname, Desc, balloonamt, datetimestart);

			} else {

				String Desc = "Backoffice balloon amt is incorrect";
				Utilities.failresult(methodname, Desc, balloonamt, datetimestart);
			}

			// view schedule close
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_ViewClose).click();
			Thread.sleep(6000);

			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MadWindowClose).click();
			Thread.sleep(5000);
/*
			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementswindowClose).click();
			Thread.sleep(5000);*/

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void BoCallvalidateresponse()  {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*	// NAVIGATION  when  comment out this block make sure the BO_status_check method agreement details button also commented out. 
			Thread.sleep(10000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Openlink).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementservicing).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementslink).click();
			Thread.sleep(5000);

			// MAINTAIN CUSTOMER AGREEMENT
			// 6 or 7
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementinputbox).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(5000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Agreementfindlink).click();
			Thread.sleep(5000);*/
			
			// customer details
			Common_Property.driver.findElement(POM_StartLine.BOhome_Customerdetailsbuton).click();
			Thread.sleep(10500);
			
		
			
			// view
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_View).click();
			Thread.sleep(5000);
			// credit ref
			Common_Property.driver.findElement(POM_StartLine.BOhome_CusdetailsViewCreditrefrequest).click();
			Thread.sleep(5000);
			// filter
			Common_Property.driver.findElement(POM_StartLine.BOhome_GridFilter).click();
			Thread.sleep(5000);

			// agreement number
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefFilterAgreementnumber).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(5000);

			// DDL button
			Common_Property.driver.findElement(POM_StartLine.BOhome_FilterTypeDDL).click();
			Thread.sleep(5000);

			// select option-Call report BSB quotation
			Common_Property.driver.findElement(POM_StartLine.BOhome_SelectCallreportBSB).click();
			Thread.sleep(5000);

			// applyfilter
			Common_Property.driver.findElement(POM_StartLine.BOhome_GridApplyFilter).click();
			Thread.sleep(5000);

			// Response
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponse).click();
			Thread.sleep(5000);

			Utilities.passresult(methodname, "CallCredit Affordability check response is generated", null,
					datetimestart);
			// responseclose
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponseClose).click();
			Thread.sleep(5000);

			// filter
			Common_Property.driver.findElement(POM_StartLine.BOhome_GridFilter).click();
			Thread.sleep(5000);

			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefFilterAgreementnumber).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(5000);

			// DDL button
			Common_Property.driver.findElement(POM_StartLine.BOhome_FilterTypeDDL).click();
			Thread.sleep(5000);
			
			// select option-Call reportaffortability check
			Common_Property.driver.findElement(POM_StartLine.BOhome_SelectCallreportAfforadbiltycehck).click();
			Thread.sleep(5000);

			// applyfilter
			Common_Property.driver.findElement(POM_StartLine.BOhome_GridApplyFilter).click();
			Thread.sleep(5000);

			// Response
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponse).click();
			Thread.sleep(5000);

			// Response close
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponseClose).click();
			Thread.sleep(5000);

			Utilities.passresult(methodname, "CallCredit Affordability check response is generated", null,datetimestart);

			// filter
			// filter
			Common_Property.driver.findElement(POM_StartLine.BOhome_GridFilter).click();
			Thread.sleep(5000);

			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefFilterAgreementnumber).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(5000);

			// DDL button
			Common_Property.driver.findElement(POM_StartLine.BOhome_FilterTypeDDL).click();
			Thread.sleep(5000);

			for (int i = 0; i <= 13; i++) {
				
				Common_Property.driver.findElement(POM_StartLine.BOhome_GridScrolldown).click();
				
			}
			Thread.sleep(5000);
			// select option-Dealflo identity check
			Common_Property.driver.findElement(POM_StartLine.BOhome_SelectDealfloidentity).click();
			Thread.sleep(5000);

			// applyfilter
			Common_Property.driver.findElement(POM_StartLine.BOhome_GridApplyFilter).click();
			Thread.sleep(5000);

			// Response
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponse).click();
			Thread.sleep(5000);

			Utilities.passresult(methodname, "Dealflo VHub ID And Bank parsed response is generated", null,datetimestart);
			Thread.sleep(5000);
			// Response close
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponseClose).click();
			Thread.sleep(5000);

			// Credit ref close 
			Common_Property.driver.findElement(POM_StartLine.BOhome_CreditrefResponseWindowClose).click();
			Thread.sleep(5000);

			// Mad close
			Common_Property.driver.findElement(POM_StartLine.BOMADWindow_MadWindowClose).click();
			Thread.sleep(5000);

			// Maintain customer agreements Close
			Common_Property.driver.findElement(POM_StartLine.BOhome_MainCustomerAgreementswindowClose).click();
			Thread.sleep(5000);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void PDIAgr_Login() throws Exception {

		{

			System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			Date sdate = new Date();
			String datetimestart = dateFormat.format(sdate);

			try {

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Financials")) {
					if (!Driver.getData("Esign").contains("Y")) {

						if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
							&& Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
							&& !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

							Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment are enabled and Fixrates checkbox is disabled as expected",null, datetimestart);
						}

						else {

							Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled",null, datetimestart);
						}

					}
					Adminfee = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Adminfeetext).getAttribute("value");
					Thread.sleep(350);
					System.out.println("admin fee is" + Adminfee);

					Balloon = Driver.getData("Baloon");
					Thread.sleep(350);
					System.out.println(Balloon);

					installment = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Installmenttext).getAttribute("Value");
					Thread.sleep(350);

					String Delaerdepo = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_DelaerDeposit).getAttribute("Value");
					Thread.sleep(350);

					String Partex = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_PartExchange).getAttribute("Value");
					Thread.sleep(350);

					Advance = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Advance).getText().toString();
					Thread.sleep(350);
					System.out.println(Advance);
					float Adv = Float.parseFloat(Advance);
					String goodscost = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Goodscost).getText().toString();
					Thread.sleep(350);

					float Delaerdepo1 = Float.parseFloat(Delaerdepo);
					float Partex1 = Float.parseFloat(Partex);
					float totalamnt = Delaerdepo1 + Partex1;
					float goodscost1 = Float.parseFloat(goodscost);
					float Advance1 = goodscost1 - totalamnt;

					if (Advance1 == Adv) {

						String Desc = "Advance amount verified is" + Advance;
						Utilities.passresult(methodname, Desc, null, datetimestart);
					} else {

						String Desc = "Advance amount is updated incorrectly";
						Utilities.failresult(methodname, Desc, null, datetimestart);
					}

					// continue
					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
					Thread.sleep(700);

				} else {
					// navigation to financial tab

					pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
					Thread.sleep(700);

					if (pagename.contains("Decision")) {
						Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
						Thread.sleep(700);
						PDIAgr_Login();
					}

				}

			}

			catch (Exception e) {
				System.out.println("The exception was " + e);
				System.out.println("Abnormal Termination due to " + e);
				String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
				Utilities.failresult(methodname, Desc, null, datetimestart);

			}

		}

	}

	//This batch process will run if the tiered pricing loaded as a new  one in SMFSYS data path
	public static void BO_TieredPricing_Batchrun(Recordset record){

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			
			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(10000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Openlink).click();
			Thread.sleep(3000);
			// Batches
			Common_Property.driver.findElement(POM_StartLine.BOhome_Batches).click();
			Thread.sleep(2000);
			// Display job queues
			Common_Property.driver.findElement(POM_StartLine.BOhome_DisplayBatchJobqueues).click();
			Thread.sleep(2000);

			// To enter the batch data's 6 or 7 submit
			Thread.sleep(3000);
			Common_Property.driver.findElement(POM_StartLine.BOhome_Batchsubmit).click();
			Thread.sleep(3000);
			// Job
			Common_Property.driver.findElement(POM_StartLine.BOhome_BatchJobname).sendKeys(Driver.getData("TP_Batchname"));
			Thread.sleep(3000);

			// Click now
			Common_Property.driver.findElement(POM_StartLine.BOhome_BatchClicknow).click();
			Thread.sleep(5000);

			// Click Save
			Common_Property.driver.findElement(POM_StartLine.BOhome_BatchSave).click();
			Thread.sleep(5000);

			// Automatic refresh click
			Common_Property.driver
					.findElement(POM_StartLine.BOhome_BatchAutomaticRefresh).click();
			Thread.sleep(5000);
			// to wait for the batch run completion
			Thread.sleep(100000);

			// Main_Keyword.batchsheet=true;
			String currentdate = Common_Property.driver.findElement(POM_StartLine.BOhome_Bocureentsysdate).getText().toString();
		
			Agreement_Store.Store_Data(Driver.WhichClient, currentdate, "", record);

			Batchstatus = Common_Property.driver.findElement(POM_StartLine.BOhome_Batchrunstatus).getText().toString();
			Thread.sleep(2000);

			String jobname = Common_Property.driver.findElement(POM_StartLine.BOhome_Batchjobnameingrid).getText().toString();
			Thread.sleep(2000);

			String Batchstartdate = Common_Property.driver.findElement(POM_StartLine.BOhome_Batchstartdate).getText().toString();
			Thread.sleep(2000);
			Batchstartdate = Batchstartdate.substring(0, 11);

			if (Batchstatus.equalsIgnoreCase("No") 
				&& currentdate.contains(Batchstartdate)
				&& jobname.contains(Driver.getData("TP_Batchname"))) {

				Utilities.passresult(methodname, "Batch run successful without error", Batchstatus, datetimestart);
			} else {

				Utilities.failresult(methodname, "Batch run not successful error exist", Batchstatus, datetimestart);
			}

			// Click Close
			Common_Property.driver.findElement(POM_StartLine.BOhome_Batchpageclose).click();
			Thread.sleep(2000);

			Common_Property.driver.close();

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void PreRequisite_SMFTP_WST()  {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			TieredPricing.TP_Securedtasks("WST");

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void Prequisite_SMFTP_WOST()  {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			TieredPricing.TP_Securedtasks("NST");

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	@SuppressWarnings("deprecation")
	public static void SMF_TP_WithandWithoutST()  {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			int Eventflag = 0;
			Thread.sleep(1000);
			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			/*
			 * if(Batchstatus.contains("No")) {
			 */
			String Createdtype = Driver.getData("Createdtype");
			Float Createrate = Float.parseFloat(Driver.getData("Proposrate"));
			Float TP_MIN_RATE = Float.parseFloat(Driver.getData("TIP_MIN_RATE")); 
			Float TP_MAX_RATE = Float.parseFloat(Driver.getData("TIP_MAX_RATE")); 
			Float TP_DefaultRate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE")); 
			Float Flatminrate = Float.parseFloat(Driver.getData("Flat_Minrate"));
			Float Flatmaxrate = Float.parseFloat(Driver.getData("Flat_Maxrate"));
			Float Yieldminrate = Float.parseFloat(Driver.getData("Yield_Minrate"));
			Float Yieldmaxrate = Float.parseFloat(Driver.getData("Yield_Maxrate"));
			Float APRminrate = Float.parseFloat(Driver.getData("APR_Minrate"));
			Float APRmaxrate = Float.parseFloat(Driver.getData("APR_Maxrate"));

			if (pagename.contains("Financials")) {

				if ((TieredPricing.STavailable == 1) && (TieredPricing.DealerTPstatus.contains("Y"))) {     //#with secured task

					if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
						&& Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
						&& Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

						Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are enabled",null, datetimestart);
					}

					else {

						Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled",null, datetimestart);
					}

					if (!Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {

						Utilities.passresult(methodname, "Fixrates checkbox is not ticked", null, datetimestart);
					}

					else {

						Utilities.failresult(methodname, "Fixrates checkbox is ticked", null, datetimestart);
					}
				}

				else if ((TieredPricing.STavailable == 0) && (TieredPricing.DealerTPstatus.contains("Y"))) { //Without secured task 

					if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
						 && !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
						 && !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {
						
						Utilities.passresult(methodname,"Financialpage_Solve for rates,Fixrates checkboxes are disabled and Solve for installment enabled",null, datetimestart);
						WebElement proposaedratefield = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_proposeratefield);
						WebElement APRratefield = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield);
						WebElement Yieldfield = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Yieldratefield);
						Boolean Prate = proposaedratefield.getAttribute("class").toString().trim().equalsIgnoreCase("data");
						Boolean Arate = APRratefield.getAttribute("class").toString().trim().equalsIgnoreCase("data");
						Boolean Yrate = Yieldfield.getAttribute("class").toString().trim().equalsIgnoreCase("data");
						if (Prate == true && Arate == true && Yrate == true)
						          
						{

							Utilities.passresult(methodname, "Propose rate,APR rate,Yield rates field are read only",null, datetimestart);
						} else {

							Utilities.failresult(methodname,"Propose rate,APR rate,Yield rates field are not read only", null, datetimestart);

						}

					} else {

						Utilities.failresult(methodname,"Financial page Solve for rates,installment,Fixrates checkboxes not enable/disabled as expected",null, datetimestart);
					}
				} else {

					Utilities.failresult(methodname,"With and without secured task fix rates box validation has failed", null, datetimestart);
				}

				// Calculate
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
				Thread.sleep(2000);

				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(2000);

				// Refresh

				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> activitys1 = new ArrayList<String>();
				ArrayList<String> activitys2 = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Common_Property.SQLcon = DriverManager.getConnection(Configuration.OracleDatabase, "forte", "forte");
				Common_Property.st = Common_Property.SQLcon.createStatement();
				String Agreementno = "'" + Driver.getData("Agreement_Number") + "'";
				System.out.println(Agreementno);
				String Query1 = "select AGR_EFFECTIVE_RATE,agr_customer_effective_rate,ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1),ROUND(AGR_EFFECTIVE_RATE,2),to_char(agr_create_date,'DD-MON-YYYY HH24:MI:SS')from agreements Where AGR_AGREEMENT_NUMBER="+ Agreementno + " ";
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query1);
				Common_Property.rs = Common_Property.st.executeQuery(Query1);
				Common_Property.rs.next();
				String RoundoffAPR = Common_Property.rs.getString("ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1)");
				String RoundoffAER = Common_Property.rs.getString("ROUND(AGR_EFFECTIVE_RATE,2)");
				String APR = Common_Property.rs.getString(("agr_customer_effective_rate"));
				String AER = Common_Property.rs.getString(("AGR_EFFECTIVE_RATE"));
				Utilities.passresult(methodname, "Agr_Customer Effective rate" + APR + "round off to the value",RoundoffAPR, datetimestart);
				Utilities.passresult(methodname, "Agr_Customer APR rate" + AER + "round off to the value", RoundoffAER,datetimestart);

				String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
				System.out.println(DecisionAPR2);
				// To pick APR from the Flat rate / Yield / APR
				String s[] = new String[3];
				int i, j = 0, k = 0;
				for (i = 0; i < 3; i++) {
					j = DecisionAPR2.indexOf('%', k);
					s[i] = DecisionAPR2.substring(k, j);
					k = j + 3;
					System.out.println(s[i]);

				}
				Float DecisionAPR3 = Float.parseFloat(s[2]);
				if (Createdtype.contains("APR")) {
					
					if ((Createrate >= APRminrate && Createrate <= APRmaxrate)) {
						if (DecisionAPR3 >= TP_MIN_RATE && DecisionAPR3 <= TP_MAX_RATE) {

							Utilities.passresult(methodname,"Rate calculated is within the Tiered pricing MINMAX rates as expected","Calculated TP Rate:" + DecisionAPR3 + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,"");
						} else {

							Utilities.failresult(methodname, "Rate calculated is not within the TP MIN-MAX rate","Calculated TP Rate: " + DecisionAPR3 + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
						}
					}

					else if ((Createrate < APRminrate || Createrate > APRmaxrate)) {
						
						if (DecisionAPR3.equals(TP_DefaultRate))

						{
							String APRRATE2 = Float.toString(DecisionAPR3);

							Utilities.passresult(methodname,"APR rate (APR)calculated to the Tierepricing Default rate as expected","Calculated TP rate:" + APRRATE2 + "TP_Defaultrate" + TP_DefaultRate,"");
							Eventflag = 1;

						} else {

							Utilities.failresult(methodname,"APR rate(APR) Not calculated to the Tierepricing Default rate", "",datetimestart);
						}
					}

				} else if (Createdtype.contains("Flat")) {
					
					if ((Createrate >= Flatminrate && Createrate <= Flatmaxrate)) {
						
						if (DecisionAPR3 >= TP_MIN_RATE && DecisionAPR3 <= TP_MAX_RATE) {

							Utilities.passresult(methodname,"Rate(FLAT) calculated is within the Tiered pricing MINMAX rates as expected","Calculated TP Rate:" + DecisionAPR3 + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,"");
						} else {

							Utilities.failresult(methodname, "Rate(FLAT) calculated is not within the TP MIN-MAX rate","Calculated TP Rate: " + DecisionAPR3 + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
						}
					}

					else if ((Createrate < Flatminrate || Createrate > Flatmaxrate)) {
						
						if (DecisionAPR3.equals(TP_DefaultRate))

						{
							String APRRATE2 = Float.toString(DecisionAPR3);

							Utilities.passresult(methodname,"Rate(FLAT)calculated to the Tierepricing Default rate as expected","Calculated TP rate:" + APRRATE2 + "TP_Defaultrate" + TP_DefaultRate,datetimestart);
							Eventflag = 1;

						} else {

							Utilities.failresult(methodname,"Rate(FLAT) Not calculated to the Tierepricing Default rate", null, datetimestart);
						}
					}

				}

				else if (Createdtype.contains("Yield")) 
				{
					if ((Createrate >= Yieldminrate && Createrate <= Yieldmaxrate)) {
						
						if (DecisionAPR3 >= TP_MIN_RATE && DecisionAPR3 <= TP_MAX_RATE) {

							Utilities.passresult(methodname,"Rate(YIELD) calculated is within the Tiered pricing MINMAX rates as expected","Calculated TP Rate: " + DecisionAPR3 + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
						} else {

							Utilities.failresult(methodname, "Rate(YIELD) calculated is not within the TP MIN-MAX rate","Calculated TP Rate: " + DecisionAPR3 + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
						}
					}

					else if ((Createrate < Yieldminrate || Createrate > Yieldmaxrate)) {
						if (DecisionAPR3.equals(TP_DefaultRate))

						{
							String APRRATE2 = Float.toString(DecisionAPR3);

							Utilities.passresult(methodname,"Rate(YIELD)calculated to the Tierepricing Default rate as expected","Calculated TP rate:" + APRRATE2 + "TP_Defaultrate" + TP_DefaultRate,datetimestart);
							Eventflag = 1;

						} else {

							Utilities.failresult(methodname,"Rate(YIELD) Not calculated to the Tierepricing Default rate", null, datetimestart);
						}
					}

				}

				else {
					Utilities.failresult(methodname, "Created rate type is not in APR/Falt/Yield rates", null,datetimestart);

				}

				if (Eventflag == 1) {
					activitys.add(0, "Automatically Referred");
					activitys.add(1, "Call Validate Decision Made");
					activitys.add(2, "Tiered Pricing Exceptions");
					activitys.add(3, "Modelled Using Tiered APR");
					activitys.add(4, "Tiered Pricing Rate Set");
					activitys.add(5, "Additional Attribute Added");
					Primaryvalue.add(0, "Tiered Pricing");
					Primaryvalue.add(1, "APR Rate Fixed");
					Secondaryvalue.add(0, Driver.getData("Ratefixed"));
					Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR"); 
				} else if (Eventflag == 2) {
					activitys.add(0, "Automatically Referred");
					activitys.add(1, "Call Validate Decision Made");
					activitys.add(2, "Tiered Pricing Exceptions");
					activitys.add(3, "Additional Attribute Added");
					Primaryvalue.add(0, "Tiered Pricing");
					Primaryvalue.add(1, "APR Rate Fixed");
					Secondaryvalue.add(0, Driver.getData("Ratefixed"));
					Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR"); 
				}

				activitys1.add(0, "Dummy");
				Primaryvalue.add(0, "Tiered Pricing");
				Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details"); 
				activitys2.add(0, "Specialterms");
				Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details"); 
			} else { // navigation to financial tab

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_TP_WithandWithoutST();
				}
			}

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}


	public static void SMF_TP_Financialfieldvalidation() {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Utilities.ExtentPassReport(methodname);
			if (Batchstatus.contains("No")) {
				
				TieredPricing.TP_Securedtasks("WST");
				
				if (pagename.contains("Financials")) {
					
					if ((TieredPricing.STavailable == 1) && (TieredPricing.DealerTPstatus.contains("Y"))) { //#with secured task

						if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
							&& Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
							&& Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

							Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are enabled",null, datetimestart);
						}

						else {

							Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled",null, datetimestart);
						}
					} else {

						Utilities.failresult(methodname, "Secured task and the dealer is not withST and TP enabled",null, datetimestart);
					}
				}
			}
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void SMF_TP_WOST_FRUnticked() {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Thread.sleep(1000);
			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			if (Batchstatus.contains("No")) {
				TieredPricing.TP_Securedtasks("NST");
				String Createdtype = Driver.getData("Createdtype");
				String a1 = Driver.getData("Createrate");

				// Quality+ rates
				String a = TieredPricing.TIP_MIN_RATE;
				String C = TieredPricing.TIP_MAX_RATE;
				String D = TieredPricing.TIP_DEFAULT_RATE;
				String D1 = Driver.getData("Flat_Minrate");
				String E1 = Driver.getData("Flat_Maxrate");
				String F1 = Driver.getData("Yield_Minrate");
				String G1 = Driver.getData("Yield_Maxrate");
				Brandname = TieredPricing.TIP_PRODUCT_NAME;

				Float Createrate = Float.parseFloat(a1);// created rate
				Float TPminrate = Float.parseFloat(a); // Tp min rate float
				Float TIP_MAX_RATE = Float.parseFloat(C); // Tp max rate float
				Float Defaultrate = Float.parseFloat(D);
				Float Flatminrate = Float.parseFloat(D1);
				Float Flatmaxrate = Float.parseFloat(E1);
				Float Yieldminrate = Float.parseFloat(F1);
				Float Yieldmaxrate = Float.parseFloat(G1);
				if (pagename.contains("Financials")) {
					if ((TieredPricing.STavailable == 0) && (TieredPricing.DealerTPstatus.contains("Y"))) {   //Without secured task

						if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
								&& !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
								&& !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

							Utilities.passresult(methodname,"Financialpage_Solve for rates,Fixrates checkboxes are disabled and Solve for installment enabled",null, datetimestart);
						}

						else {

							Utilities.failresult(methodname,"Financial page Solve for rates,installment,Fixrates checkboxes not enable/disabled as expected",null, datetimestart);
						}
					} else {

						Utilities.failresult(methodname, "Secured task and the dealer is not withST and TP enabled",null, datetimestart);
					}
					// Calculate
					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
					Thread.sleep(700);

					// Continue
					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
					Thread.sleep(2000);

					// Refresh

					WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
					JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
					jse.executeScript("arguments[0].click();", element);

					ArrayList<String> activitys = new ArrayList<String>();
					ArrayList<String> activitys1 = new ArrayList<String>();
					ArrayList<String> activitys2 = new ArrayList<String>();
					ArrayList<String> Primaryvalue = new ArrayList<String>();
					ArrayList<String> Secondaryvalue = new ArrayList<String>();

					if (Createdtype.contains("APR")) {
						if ((Createrate < TPminrate || Createrate > TIP_MAX_RATE)) {

							String DecisionAPR1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
							System.out.println(DecisionAPR1);
							// To pick APR from the Flat rate / Yield / APR
							String s[] = new String[3];
							int i, j = 0, k = 0;
							for (i = 0; i < 3; i++) {
								j = DecisionAPR1.indexOf('%', k);
								s[i] = DecisionAPR1.substring(k, j);
								k = j + 3;

							}
							Float DecisionAPR = Float.parseFloat(s[2]);
							if (DecisionAPR.equals(Defaultrate)) {

								String APRRATE2 = Float.toString(DecisionAPR);

								Utilities.passresult(methodname,"APR rate is recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);

								activitys.add(0, "Automatically Referred");
								activitys.add(1, "Call Validate Decision Made");
								activitys.add(2, "Tiered Pricing Exceptions");
								activitys.add(3, "Modelled Using Tiered APR");
								activitys.add(4, "Tiered Pricing Rate Set");
								activitys.add(5, "Additional Attribute Added");

								Primaryvalue.add(0, "Tiered Pricing");
								Primaryvalue.add(1, "APR Rate Fixed");

								Secondaryvalue.add(0, "N");

								Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
							} else {
								String APRRATE2 = Float.toString(DecisionAPR);

								Utilities.failresult(methodname,	"APR rate is Not recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
							}

						}

						else if ((Createrate >= TPminrate && Createrate <= TIP_MAX_RATE)) {
							String DecisionAPR1 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
							System.out.println(DecisionAPR1);
							// To pick APR from the Flat rate / Yield / APR
							String s[] = new String[3];
							int i, j = 0, k = 0;
							for (i = 0; i < 3; i++) {
								j = DecisionAPR1.indexOf('%', k);
								s[i] = DecisionAPR1.substring(k, j);
								k = j + 3;
								System.out.println(s[i]);

							}
							Float DecisionAPR = Float.parseFloat(s[2]);

							if (Createrate.equals(DecisionAPR))

							{
								String APRRATE2 = Float.toString(DecisionAPR);

								Utilities.passresult(methodname,"APR rate calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);

								activitys.add(0, "Automatically Referred");
								activitys.add(1, "Call Validate Decision Made");
								activitys.add(2, "Tiered Pricing Exceptions");
								activitys.add(3, "Additional Attribute Added");
								Primaryvalue.add(0, "Tiered Pricing");
								Primaryvalue.add(1, "APR Rate Fixed");

								Secondaryvalue.add(0, "N");

								Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

							} else {
								String APRRATE2 = Float.toString(DecisionAPR);

								Utilities.failresult(methodname,"APR rate Not calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
							}
						}

					}
					/*
					 * Flat_Minrate:10.80=21 Flat_Maxrate:12.85 =25
					 */

					else if (Createdtype.contains("Flat")) {

						if ((Createrate >= Flatminrate && Createrate <= Flatmaxrate)) {

							String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
							System.out.println(DecisionAPR2);
							// To pick APR from the Flat rate / Yield / APR
							String s[] = new String[3];
							int i, j = 0, k = 0;
							for (i = 0; i < 3; i++) {
								j = DecisionAPR2.indexOf('%', k);
								s[i] = DecisionAPR2.substring(k, j);
								k = j + 3;
								System.out.println(s[i]);

							}
							Float DecisionAPR3 = Float.parseFloat(s[2]);

							// navigate to Financial
							Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
							Thread.sleep(700);

							String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
							System.out.println(AERAPR2);
							String APR2 = AERAPR2.substring(8, 12);
							Float Createrate1 = Float.parseFloat(APR2);

							// navigate to Decision
							Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
							Thread.sleep(700);

							if (Createrate1.equals(DecisionAPR3)) {
								String APRRATE2 = Float.toString(DecisionAPR3);

								Utilities.passresult(methodname,"APR (Flat) rate calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);

								activitys.add(0, "Automatically Referred");
								activitys.add(1, "Call Validate Decision Made");
								activitys.add(2, "Tiered Pricing Exceptions");
								activitys.add(3, "Additional Attribute Added");
								Primaryvalue.add(0, "Tiered Pricing");
								Primaryvalue.add(1, "APR Rate Fixed");

								Secondaryvalue.add(0, "N");

								Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

							}

							else {

								String APRRATE2 = Float.toString(DecisionAPR3);
								Utilities.failresult(methodname,"APR (Flat) rate is not calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
							}

						} else if ((Createrate < Flatminrate || Createrate > Flatmaxrate)) {
							String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
							System.out.println(DecisionAPR2);
							// To pick APR from the Flat rate / Yield / APR
							String s[] = new String[3];
							int i, j = 0, k = 0;
							for (i = 0; i < 3; i++) {
								j = DecisionAPR2.indexOf('%', k);
								s[i] = DecisionAPR2.substring(k, j);
								k = j + 3;
								System.out.println(s[i]);

							}
							Float DecisionAPR3 = Float.parseFloat(s[2]);

							if (DecisionAPR3.equals(Defaultrate)) {
								String APRRATE2 = Float.toString(DecisionAPR3);

								Utilities.passresult(methodname,"APR(Flat) rate calculated to the Tierepricing Default rate as expected",APRRATE2, datetimestart);

								activitys.add(0, "Automatically Referred");
								activitys.add(1, "Call Validate Decision Made");
								activitys.add(2, "Tiered Pricing Exceptions");
								activitys.add(3, "Modelled Using Tiered APR");
								activitys.add(4, "Tiered Pricing Rate Set");
								activitys.add(5, "Additional Attribute Added");
								Primaryvalue.add(0, "Tiered Pricing");
								Primaryvalue.add(1, "APR Rate Fixed");
								Secondaryvalue.add(0, "N");
								Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
							}

							else {

								Utilities.failresult(methodname,"APR(Flat) rate Not calculated to the Tierepricing Default rate", null,datetimestart);
							}
						}

					}

					/*
					 * Yield_Minrate:19.15 =21 Yield_Maxrate:22.50=25
					 */
					else if (Createdtype.contains("Yield")) {

						if ((Createrate >= Yieldminrate && Createrate <= Yieldmaxrate)) {

							String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
							System.out.println(DecisionAPR2);
							// To pick APR from the Flat rate / Yield / APR
							String s[] = new String[3];
							int i, j = 0, k = 0;
							for (i = 0; i < 3; i++) {
								j = DecisionAPR2.indexOf('%', k);
								System.out.println(j);
								s[i] = DecisionAPR2.substring(k, j);
								k = j + 3;
								System.out.println(s[i]);

							}
							Float DecisionAPR3 = Float.parseFloat(s[2]);
							// navigate to Financial
							Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
							Thread.sleep(700);

							String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
							System.out.println(AERAPR2);
							String APR2 = AERAPR2.substring(8, 12);
							Float Createrate1 = Float.parseFloat(APR2);

							// navigate to Decision
							Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
							Thread.sleep(700);

							if (Createrate1.equals(DecisionAPR3)) {
								String APRRATE2 = Float.toString(DecisionAPR3);

								Utilities.passresult(methodname,"APR (Yield) rate calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);

								activitys.add(0, "Automatically Referred");
								activitys.add(1, "Call Validate Decision Made");
								activitys.add(2, "Tiered Pricing Exceptions");
								activitys.add(3, "Additional Attribute Added");
								Primaryvalue.add(0, "Tiered Pricing");
								Primaryvalue.add(1, "APR Rate Fixed");

								Secondaryvalue.add(0, "N");

								Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

							}

							else {

								String APRRATE2 = Float.toString(DecisionAPR3);
								Utilities.failresult(methodname,"APR (Yield) rate is not calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
							}
						} else if ((Createrate < Yieldminrate || Createrate > Yieldmaxrate)) {

							String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
							System.out.println(DecisionAPR2);
							// To pick APR from the Flat rate / Yield / APR
							String s[] = new String[3];
							int i, j = 0, k = 0;
							for (i = 0; i < 3; i++) {
								j = DecisionAPR2.indexOf('%', k);
								s[i] = DecisionAPR2.substring(k, j);
								k = j + 3;
								System.out.println(s[i]);

							}
							Float DecisionAPR3 = Float.parseFloat(s[2]);
							if (DecisionAPR3.equals(Defaultrate)) {
								String APRRATE2 = Float.toString(DecisionAPR3);

								Utilities.passresult(methodname,"APR(Yield) rate calculated to the Tierepricing Default rate as expected",APRRATE2, datetimestart);

								activitys.add(0, "Automatically Referred");
								activitys.add(1, "Call Validate Decision Made");
								activitys.add(2, "Tiered Pricing Exceptions");
								activitys.add(3, "Modelled Using Tiered APR");
								activitys.add(4, "Tiered Pricing Rate Set");
								activitys.add(5, "Additional Attribute Added");

								Primaryvalue.add(0, "Tiered Pricing");
								Primaryvalue.add(1, "APR Rate Fixed");

								Secondaryvalue.add(0, "N");
								Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

							} else {

								String APRRATE2 = Float.toString(DecisionAPR3);
								Utilities.failresult(methodname,"APR(Yield) rate Not calculated to the Tierepricing Default rate", APRRATE2,datetimestart);
							}
						}

					}

					activitys1.add(0, "Dummy");
					Primaryvalue.add(0, "Tiered Pricing");
					Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details");
					activitys2.add(0, "Specialterms");
					Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details"); 

				}

				else {

					Utilities.failresult(methodname, "Fixrates is not selected i.e. not ticked", null, datetimestart);
				}
			}

			else { // navigation to financial tab

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_TP_WOST_FRUnticked();
				}
			}

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void SMF_TP_WST_FRticked() throws IOException, FilloException

	{
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Thread.sleep(1000);
			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			/*
			 * if(Batchstatus.contains("No")) {
			 */
			// Quality+ rates

			Float TP_MIN_RATE = Float.parseFloat(Driver.getData("TIP_MIN_RATE")); 
			Float TP_MAX_RATE = Float.parseFloat(Driver.getData("TIP_MAX_RATE"));
			Float TP_DefaultRate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE")); 
			if (pagename.contains("Financials")) {

				Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).clear();
				Thread.sleep(700);

				Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).sendKeys(Driver.getData("CreatedPrate"));
				Thread.sleep(700);

				Common_Property.driver.findElement(By.name("finFixRate")).click();
				Thread.sleep(750);
				if ((TieredPricing.STavailable == 1) && (TieredPricing.DealerTPstatus.contains("Y"))) {   //#with secured task

					if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
						 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
						 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

						Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are enabled",null, datetimestart);
					}

					else {

						Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled",null, datetimestart);
					}

				} else {

					Utilities.failresult(methodname, "Secured task and the dealer is not withST and TP enabled", null,datetimestart);
				}

				if (Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {

					Utilities.passresult(methodname, "Fix rates checkbox is  ticked", null, datetimestart);
				}

				else {

					Utilities.failresult(methodname, "Fix rates checkbox not ticked", null, datetimestart);
				}

				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(2000);

				// Switch the driver context to the alert
				Alert alertDialog = Common_Property.driver.switchTo().alert();

				// Get the alert text
				String alertText = alertDialog.getText();
				// Click the OK button on the alert.
				alertDialog.accept();

				Utilities.passresult(methodname, "pop up displayed", alertText, datetimestart);

				Thread.sleep(950);
				// Calculate
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
				Thread.sleep(5000);

				String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
				System.out.println(AERAPR2);
				String APR2 = AERAPR2.substring(8, 12);
				Float Createrate1 = Float.parseFloat(APR2);

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Common_Property.SQLcon = DriverManager.getConnection(Configuration.OracleDatabase, "forte", "forte");
				Common_Property.st = Common_Property.SQLcon.createStatement();
				String Agreementno = "'" + Driver.getData("Agreement_Number") + "'";
				System.out.println(Agreementno);
				String Query1 = "select AGR_EFFECTIVE_RATE,agr_customer_effective_rate,ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1),ROUND(AGR_EFFECTIVE_RATE,2),to_char(agr_create_date,'DD-MON-YYYY HH24:MI:SS')from agreements Where AGR_AGREEMENT_NUMBER="+ Agreementno + " ";
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query1);
				Common_Property.rs = Common_Property.st.executeQuery(Query1);
				Common_Property.rs.next();
				String RoundoffAPR = Common_Property.rs.getString("ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1)");
				String RoundoffAER = Common_Property.rs.getString("ROUND(AGR_EFFECTIVE_RATE,2)");
				String APR = Common_Property.rs.getString(("agr_customer_effective_rate"));
				String AER = Common_Property.rs.getString(("AGR_EFFECTIVE_RATE"));
				Utilities.passresult(methodname, "Agr_Customer Effective rate" + APR + "round off to the value",RoundoffAPR, datetimestart);
				Utilities.passresult(methodname, "Agr_Customer APR rate" + AER + "round off to the value", RoundoffAER,datetimestart);

				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(1050);

				// Refresh

				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
				System.out.println(DecisionAPR2);
				// To pick APR from the Flat rate / Yield / APR
				String s[] = new String[3];
				int i, j = 0, k = 0;
				for (i = 0; i < 3; i++) {
					j = DecisionAPR2.indexOf('%', k);
					s[i] = DecisionAPR2.substring(k, j);
					k = j + 3;

				}
				Float DecisionAPR4 = Float.parseFloat(s[2]);

				if ((Createrate1 < TP_MIN_RATE || Createrate1 > TP_MAX_RATE)) {
					if ((Createrate1.equals(DecisionAPR4) && (!Createrate1.equals(TP_DefaultRate)))) {
						String crtrate = Createrate1.toString();

						Utilities.passresult(methodname, "Tiered pricing rate not used and the rates fixed", crtrate,datetimestart);
					} else {

						String crtrate = Createrate1.toString();

						Utilities.failresult(methodname, "Tiered pricing rate used", crtrate, datetimestart);
					}
				} else if ((Createrate1 >= TP_MIN_RATE && Createrate1 <= TP_MAX_RATE)) {
					if ((Createrate1.equals(DecisionAPR4))) {
						String crtrate = Createrate1.toString();

						Utilities.passresult(methodname, "Tiered pricing rate not used and the rates fixed", crtrate,datetimestart);
					} else {

						String crtrate = Createrate1.toString();

						Utilities.failresult(methodname, "Tiered pricing rate used", crtrate, datetimestart);
					}
				}

				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> activitys1 = new ArrayList<String>();
				ArrayList<String> activitys2 = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				activitys.add(0, "Automatically Referred");
				activitys.add(1, "Call Validate Decision Made");
				activitys.add(2, "Tiered Pricing Exceptions");
				activitys.add(3, "Additional Attribute Added");
				Primaryvalue.add(0, "Tiered Pricing");
				Primaryvalue.add(1, "APR Rate Fixed");
				Secondaryvalue.add(0, "Y");
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");//Status:TP-Tiered Pricing ,Plan:DR-Default rate

				activitys1.add(0, "Dummy");
				Primaryvalue.add(0, "Tiered Pricing");
				Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details");
				activitys2.add(0, "Specialterms");
				Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details"); // status:ST-special terms,plan:details
			}

			else { // navigation to financial tab

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_TP_WST_FRticked();
				}
			}
			/*
			 * } else {
			 * 
			 * 
			 * Utilities.failresult(methodname,
			 * "Batch error status is not displayed as NO", null,
			 * datetimestart); }
			 */

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void SMF_TP_WST_RemoveFRticked() {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Thread.sleep(1000);
			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			int eventflag = 0;
			/*
			 * if(Batchstatus.contains("No")) {
			 */

			// Quality+ rates
			Float TP_MIN_RATE = Float.parseFloat(Driver.getData("TIP_MIN_RATE"));
			Float TP_MAX_RATE = Float.parseFloat(Driver.getData("TIP_MAX_RATE")); 
			Float TP_DefaultRate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE"));
			// navigate to financial
			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(700);

			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			if (pagename.contains("Financials")) {

				if (Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {
					String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
					System.out.println(AERAPR2);
					String APR2 = AERAPR2.substring(8, 12);
					Float Createrate1 = Float.parseFloat(APR2);

					Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).click();
					Thread.sleep(750);

					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
					Thread.sleep(700);

					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
					Thread.sleep(900);

					ArrayList<String> activitys = new ArrayList<String>();
					ArrayList<String> activitys1 = new ArrayList<String>();
					ArrayList<String> activitys2 = new ArrayList<String>();
					ArrayList<String> Primaryvalue = new ArrayList<String>();
					ArrayList<String> Secondaryvalue = new ArrayList<String>();

					String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
					System.out.println(DecisionAPR2);
					// To pick APR from the Flat rate / Yield / APR
					String s[] = new String[3];
					int i, j = 0, k = 0;
					for (i = 0; i < 3; i++) {
						j = DecisionAPR2.indexOf('%', k);
						s[i] = DecisionAPR2.substring(k, j);
						k = j + 3;
						System.out.println(s[i]);

					}
					Float DecisionAPR4 = Float.parseFloat(s[2]);
					if (Createrate1 < TP_MIN_RATE || Createrate1 > TP_MAX_RATE) {
						if (DecisionAPR4.equals(TP_DefaultRate)) {

							String crtrate = DecisionAPR4.toString();

							Utilities.passresult(methodname,"Fixrates removed_rates calculated to Tp's default rate as expected", crtrate,datetimestart);
							eventflag = 1;
						} else {

							String crtrate = Createrate1.toString();

							Utilities.failresult(methodname,"Fixrates removed_rates are not calculated to Tp's default rate", crtrate,datetimestart);
						}

					} else if ((Createrate1 >= TP_MIN_RATE && Createrate1 <= TP_MAX_RATE)) {

						if (Createrate1.equals(DecisionAPR4)) {

							String crtrate = DecisionAPR4.toString();

							Utilities.passresult(methodname,"Fixrates removed_rates calculated within TP's MinMaxRates as expected", crtrate,datetimestart);
							eventflag = 2;
						} else {

							String crtrate = Createrate1.toString();

							Utilities.failresult(methodname,"Fixrates removed_rates are not calculated within TP's MinMaxRates", crtrate,datetimestart);
						}
					}

					if (eventflag == 1) {
						activitys.add(0, "Automatically Referred");
						activitys.add(1, "Call Validate Decision Made");
						activitys.add(2, "Tiered Pricing Exceptions");
						activitys.add(3, "Modelled Using Tiered APR");
						activitys.add(4, "Tiered Pricing Rate Set");
						activitys.add(5, "Additional Attribute Changed");
						Primaryvalue.add(0, "Tiered Pricing");
						Primaryvalue.add(1, "APR Rate Fixed");
						Secondaryvalue.add(0, Driver.getData("Ratefixed1"));
						Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
					} else if (eventflag == 2) {
						activitys.add(0, "Automatically Referred");
						activitys.add(1, "Call Validate Decision Made");
						activitys.add(2, "Tiered Pricing Exceptions");
						activitys.add(3, "Additional Attribute Changed");
						Primaryvalue.add(0, "Tiered Pricing");
						Primaryvalue.add(1, "APR Rate Fixed");
						Secondaryvalue.add(0, Driver.getData("Ratefixed1"));
						Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

					}

					activitys1.add(0, "Dummy");
					Primaryvalue.add(0, "Tiered Pricing");
					Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details");
					activitys2.add(0, "Specialterms");
					Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details");

				}

			} else { // navigation to financial tab

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_TP_WST_RemoveFRticked();
				}
			}
			/*
			 * } else {
			 * 
			 * 
			 * 
			 * 
			 * Utilities.failresult(methodname,
			 * "Batch status is not displayed as no", null, datetimestart); }
			 */
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}
	}

	public static void SMF_TP_WST_UpdateFRticked() {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Thread.sleep(1000);
			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			String Uratetype = Driver.getData("Uratetype");

			Float TP_MIN_RATE = Float.parseFloat(Driver.getData("TIP_MIN_RATE"));
			Float TP_MAX_RATE = Float.parseFloat(Driver.getData("TIP_MAX_RATE")); 
			Float TP_DefaultRate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE")); 
			// Update

			Float UProposalrate = Float.parseFloat(Driver.getData("Uproposalrate"));

			/*
			 * if(Batchstatus.contains("No")) {
			 */
			if (pagename.contains("Financials")) {

				if (Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {
					if ((TieredPricing.STavailable == 1) && (TieredPricing.DealerTPstatus.contains("Y"))) {    //with secured task

						if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
							 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
							 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

							Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are enabled",null, datetimestart);
						}

						else {

							Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled",null, datetimestart);
						}
						if (Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {

							Utilities.passresult(methodname, "Fixrates checkboxes is ticked", null, datetimestart);
						}

						else {

							Utilities.failresult(methodname, "Fixrates checkboxes is not ticked", null, datetimestart);
						}
					} else {

						Utilities.failresult(methodname, "Secured task and the dealer is not withST and TP enabled",null, datetimestart);
					}

					Float Createrate1;

					if (Uratetype.contains("APR")) {

						String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
						System.out.println(AERAPR2);
						String APR2 = AERAPR2.substring(8, 12);
						Createrate1 = Float.parseFloat(APR2);

						Class.forName("oracle.jdbc.driver.OracleDriver");
						Common_Property.SQLcon = DriverManager.getConnection(Configuration.OracleDatabase, "forte","forte");
						Common_Property.st = Common_Property.SQLcon.createStatement();
						String Agreementno = "'" + Driver.getData("Agreement_Number") + "'";
						System.out.println(Agreementno);
						String Query1 = "select AGR_EFFECTIVE_RATE,agr_customer_effective_rate,ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1),ROUND(AGR_EFFECTIVE_RATE,2),to_char(agr_create_date,'DD-MON-YYYY HH24:MI:SS')from agreements Where AGR_AGREEMENT_NUMBER="+ Agreementno + " ";
						Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query1);
						Common_Property.rs = Common_Property.st.executeQuery(Query1);
						Common_Property.rs.next();
						String RoundoffAPR = Common_Property.rs.getString("ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1)");
						String RoundoffAER = Common_Property.rs.getString("ROUND(AGR_EFFECTIVE_RATE,2)");
						String APR = Common_Property.rs.getString(("agr_customer_effective_rate"));
						String AER = Common_Property.rs.getString(("AGR_EFFECTIVE_RATE"));
						Utilities.passresult(methodname, "Agr_Customer Effective rate" + APR + "round off to the value",RoundoffAPR, datetimestart);
						Utilities.passresult(methodname, "Agr_Customer APR rate" + AER + "round off to the value",	RoundoffAER, datetimestart);
						String createrat = Float.toString(Createrate1);
						if (createrat.equalsIgnoreCase(RoundoffAPR)) {

							Utilities.passresult(methodname, "APR rate Updated as expected", RoundoffAPR,datetimestart);
						} else {

							Utilities.failresult(methodname, "APR rate not updated in motorfront end", null,datetimestart);
						}

					} else if (Uratetype.contains("Flat")) {

						String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).getAttribute("value");
						Createrate1 = Float.parseFloat(AERAPR2);
						if (Createrate1.equals(UProposalrate)) {

							Utilities.passresult(methodname, "Proposed/Flat rate Updated as expected",Createrate1.toString(), datetimestart);
						} else {

							Utilities.failresult(methodname, "Proposed/Flat rate not updated in motorfront end", null,datetimestart);
						}

					}

					else if (Uratetype.contains("Yield")) {

						String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Yieldrate).getAttribute("value");
						Createrate1 = Float.parseFloat(AERAPR2);
						if (Createrate1.equals(UProposalrate)) {

							Utilities.passresult(methodname, "Proposed/Yield rate Updated as expected",Createrate1.toString(), datetimestart);
						} else {

							Utilities.failresult(methodname, "Proposed/Yield rate not updated in motorfront end", null,datetimestart);
						}

					}

					String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
					System.out.println(AERAPR2);
					String APR2 = AERAPR2.substring(8, 12);
					Createrate1 = Float.parseFloat(APR2);

					// Continue
					Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
					Thread.sleep(1050);

					// Refresh

					WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
					JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
					jse.executeScript("arguments[0].click();", element);

					String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
					System.out.println(DecisionAPR2);
					// To pick APR from the Flat rate / Yield / APR
					String s[] = new String[3];
					int i, j = 0, k = 0;
					for (i = 0; i < 3; i++) {
						j = DecisionAPR2.indexOf('%', k);
						s[i] = DecisionAPR2.substring(k, j);
						k = j + 3;
						System.out.println(s[i]);

					}
					Float DecisionAPR4 = Float.parseFloat(s[2]);

					if ((Createrate1 < TP_MIN_RATE || Createrate1 > TP_MAX_RATE)) {
						if ((Createrate1.equals(DecisionAPR4) && (!Createrate1.equals(TP_DefaultRate)))) {
							String crtrate = Createrate1.toString();

							Utilities.passresult(methodname, "Tiered pricing rate not used and the rates fixed",crtrate, datetimestart);
						} else {

							String crtrate = Createrate1.toString();

							Utilities.failresult(methodname, "Tiered pricing rate used", crtrate, datetimestart);
						}
					} else if ((Createrate1 >= TP_MIN_RATE && Createrate1 <= TP_MAX_RATE)) {
						
						if ((Createrate1.equals(DecisionAPR4))) {
							
							String crtrate = Createrate1.toString();

							Utilities.passresult(methodname, "Tiered pricing rate not used and the rates fixed",crtrate, datetimestart);
						} 
						else {

							String crtrate = Createrate1.toString();

							Utilities.failresult(methodname, "Tiered pricing rate used", crtrate, datetimestart);
						}
					}

					ArrayList<String> activitys = new ArrayList<String>();
					ArrayList<String> activitys1 = new ArrayList<String>();
					ArrayList<String> activitys2 = new ArrayList<String>();
					ArrayList<String> Primaryvalue = new ArrayList<String>();
					ArrayList<String> Secondaryvalue = new ArrayList<String>();

					activitys.add(0, "Automatically Referred");
					activitys.add(1, "Call Validate Decision Made");
					activitys.add(2, "Update Proposal");
					activitys.add(3, "Tiered Pricing Exceptions");
					activitys.add(4, "Additional Attribute Added");
					Primaryvalue.add(0, "Tiered Pricing");
					Primaryvalue.add(1, "APR Rate Fixed");
					Secondaryvalue.add(0, "Y");
					Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
					activitys1.add(0, "Dummy");
					Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details");
					activitys2.add(0, "Specialterms");
					Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details"); 

				}

			}

			else { // navigation to financial tab

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_TP_WST_UpdateFRticked();
				}
			}
			/*
			 * } else {
			 * 
			 * 
			 * 
			 * Utilities.failresult(methodname,
			 * "Batch error status is not displayed as NO", null,
			 * datetimestart); }
			 */

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void SMF_TieredpricingUpdate() {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Utilities.ExtentPassReport(methodname);

			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			/*
			 * if(Batchstatus.contains("No")) {
			 */ if (pagename.contains("Financials")) {

				int Ueventflag = 0;
				String Uratetype = Driver.getData("Uratetype");
				Float UProposalrate = Float.parseFloat(Driver.getData("Uproposalrate"));
				Float TP_MIN_RATE = Float.parseFloat(Driver.getData("TIP_MIN_RATE"));
				Float TP_MAX_RATE = Float.parseFloat(Driver.getData("TIP_MAX_RATE")); 
				Float TP_DefaultRate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE")); 

				Float Flatminrate = 0.00f, Flatmaxrate = 0.00f, Yieldminrate = 0.00f, Yieldmaxrate = 0.00f,APRminrate = 0.00f, APRmaxrate = 0.00f;

				if (!Driver.getData("TIP_PRODUCT_NAME1").contains("Finishline")&& Driver.getData("TIP_PRODUCT_NAME").contains("Quality+")) {
					Flatminrate = Float.parseFloat(Driver.getData("Flat_Minrate"));
					Flatmaxrate = Float.parseFloat(Driver.getData("Flat_Maxrate"));
					Yieldminrate = Float.parseFloat(Driver.getData("Yield_Minrate"));
					Yieldmaxrate = Float.parseFloat(Driver.getData("Yield_Maxrate"));
					APRminrate = Float.parseFloat(Driver.getData("APR_Minrate"));
					APRmaxrate = Float.parseFloat(Driver.getData("APR_Maxrate"));
					
				} else if (Driver.getData("TIP_PRODUCT_NAME1").contains("Finishline")) {
					Flatminrate = Float.parseFloat(Driver.getData("FFlat_Minrate"));
					Flatmaxrate = Float.parseFloat(Driver.getData("FFlat_Maxrate"));
					Yieldminrate = Float.parseFloat(Driver.getData("FYield_Minrate"));
					Yieldmaxrate = Float.parseFloat(Driver.getData("FYield_Maxrate"));
					APRminrate = Float.parseFloat(Driver.getData("FAPR_Minrate"));
					APRmaxrate = Float.parseFloat(Driver.getData("FAPR_Maxrate"));

				}

				// Calculate
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
				Thread.sleep(700);

				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(700);

				// Refresh
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(700);

				String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
				System.out.println(DecisionAPR2);
				// To pick APR from the Flat rate / Yield / APR
				String s[] = new String[3];
				int i, j = 0, k = 0;
				for (i = 0; i < 3; i++) {
					j = DecisionAPR2.indexOf('%', k);
					s[i] = DecisionAPR2.substring(k, j);
					k = j + 3;
					System.out.println(s[i]);
				}

				Float DecisionpageAPR = Float.parseFloat(s[2]);
				ArrayList<String> activitys = new ArrayList<String>();
				ArrayList<String> Primaryvalue = new ArrayList<String>();
				ArrayList<String> Secondaryvalue = new ArrayList<String>();

				if (Uratetype.contains("APR")) {
					if ((UProposalrate < APRminrate || UProposalrate > APRmaxrate)) {

						if (DecisionpageAPR.equals(TP_DefaultRate)) {

							String APRRATE2 = Float.toString(DecisionpageAPR);

							Utilities.passresult(methodname,"Update_APR rate (APR) is recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
							Ueventflag = 1;

						} else {
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.failresult(methodname,"Update_APR rate(APR) is Not recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
						}

					}

					else if ((UProposalrate >= APRminrate && UProposalrate <= APRmaxrate)) {

						if (DecisionpageAPR >= TP_MIN_RATE && DecisionpageAPR <= TP_MAX_RATE) {

							Utilities.passresult(methodname,"Updated Rate (APR) calculated is within the Tiered pricing MINMAX rates as expected","Calculated Rate: " + DecisionpageAPR + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
							Ueventflag = 2;
						} else {

							Utilities.ExtentFailReport1(methodname,"Updated Rate (APR)calculated is not within the TP MIN-MAX rate");
							Utilities.failresult(methodname,"Updated Rate (APR)calculated is not within the TP MIN-MAX rate","Calculated Rate- " + DecisionpageAPR + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
						}

					}
				}

				else if (Uratetype.contains("Flat")) {
					if ((UProposalrate < Flatminrate || UProposalrate > Flatmaxrate)) {
						if (DecisionpageAPR.equals(TP_DefaultRate)) {

							String APRRATE2 = Float.toString(DecisionpageAPR);
							Utilities.passresult(methodname,"Update_APR rate (Flat) is recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
							Ueventflag = 1;

						} else {
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.failresult(methodname,"Update_APR rate(Flat) is Not recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
						}

					}

					else if ((UProposalrate >= Flatminrate && UProposalrate <= Flatmaxrate)) {

						if (DecisionpageAPR >= TP_MIN_RATE && DecisionpageAPR <= TP_MAX_RATE) {

							Utilities.passresult(methodname,"Updated Rate (FLAT) calculated is within the Tiered pricing MINMAX rates as expected","Calculated Rate- " + DecisionpageAPR + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
							Ueventflag = 2;
						} else {

							Utilities.ExtentFailReport1(methodname,"Updated Rate (FLAT)calculated is not within the TP MIN-MAX rate");
							Utilities.failresult(methodname,"Updated Rate (FLAT)calculated is not within the TP MIN-MAX rate","Calculated Rate- " + DecisionpageAPR + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,datetimestart);
						}

					}
				}

				else if (Uratetype.contains("Yield")) {
					
					if ((UProposalrate < Yieldminrate || UProposalrate > Yieldmaxrate)) {
						
						if (DecisionpageAPR.equals(TP_DefaultRate)) {

							String APRRATE2 = Float.toString(DecisionpageAPR);
							
							Utilities.passresult(methodname,"Update_APR rate (YIELD) is recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
							Thread.sleep(900);
							Ueventflag = 1;

						} else {
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.failresult(methodname,"Update_APR rate(YIELD) is Not recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
						}

					}

					else if ((UProposalrate >= Yieldminrate && UProposalrate <= Yieldmaxrate)) {

						if (DecisionpageAPR >= TP_MIN_RATE && DecisionpageAPR <= TP_MAX_RATE) {

							Utilities.passresult(methodname,"Update_APR rate(YIELD) calculated is within the Tiered pricing MINMAX rates as expected","Calculated Rate- " + DecisionpageAPR + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,null);
							Thread.sleep(900);
							Ueventflag = 2;
						} else {

							Utilities.failresult(methodname,"Update_APR rate(YIELD)calculated is not within the TP MIN-MAX rate","Calculated Rate- " + DecisionpageAPR + " TP_MINRATE: " + TP_MIN_RATE+ " TP_MAXRATE: " + TP_MAX_RATE,null);
						}

					}
				} else {

					Utilities.failresult(methodname, "Update_APR rate is not in APR/FLAT/YIELD rates", null,datetimestart);
				}

				if (Ueventflag == 1) {
					activitys.add(0, "Automatically Referred");
					activitys.add(1, "Call Validate Decision Made");
					activitys.add(2, "Update Proposal");
					activitys.add(3, "Tiered Pricing Exceptions");
					activitys.add(4, "Modelled Using Tiered APR");
					activitys.add(5, "Tiered Pricing Rate Set");
					activitys.add(6, "Additional Attribute Added");
					Primaryvalue.add(0, "Tiered Pricing");
					Primaryvalue.add(1, "APR Rate Fixed");
					Secondaryvalue.add(0, Driver.getData("Ratefixed"));
					Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
				} else if (Ueventflag == 2) {
					activitys.add(0, "Automatically Referred");
					activitys.add(1, "Call Validate Decision Made");
					activitys.add(2, "Update Proposal");
					activitys.add(3, "Tiered Pricing Exceptions");
					activitys.add(4, "Additional Attribute Added");
					Primaryvalue.add(0, "Tiered Pricing");
					Primaryvalue.add(1, "APR Rate Fixed");
					Secondaryvalue.add(0, Driver.getData("Ratefixed"));
					Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
				}

			} else {
				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);
				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_TieredpricingUpdate();
				}
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void SMF_TP_Finishline() {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			/*
			 * if(Batchstatus.contains("No")) {
			 */
			Utilities.ExtentPassReport(methodname);

			// Finishline Tiered pricing rates
			Float Finishlinedefaultrate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE"));
			Float Finishlineminrate = Float.parseFloat(Driver.getData("TIP_MIN_RATE"));
			Float Finishlinemaxrate = Float.parseFloat(Driver.getData("TIP_MAX_RATE"));

			Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
			Thread.sleep(950);

			String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
			System.out.println(DecisionAPR2);
			// To pick APR from the Flat rate / Yield / APR
			String s[] = new String[3];
			int i, j = 0, k = 0;
			for (i = 0; i < 3; i++) {
				j = DecisionAPR2.indexOf('%', k);
				s[i] = DecisionAPR2.substring(k, j);
				k = j + 3;
				System.out.println(s[i]);

			}
			Float DecisionAPR4 = Float.parseFloat(s[2]);

			// finihsline cretaerate
			Float Finishlinecreaterate = DecisionAPR4;

			Select select = new Select(Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_ChangeBrandDDL));
			select.selectByValue("102724");
			Thread.sleep(3000);

			// Financial
			Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
			Thread.sleep(700);

			ArrayList<String> activitys = new ArrayList<String>();
			ArrayList<String> activitys1 = new ArrayList<String>();
			ArrayList<String> activitys2 = new ArrayList<String>();
			ArrayList<String> Primaryvalue = new ArrayList<String>();
			ArrayList<String> Secondaryvalue = new ArrayList<String>();

			if ((TieredPricing.STavailable == 1) && (TieredPricing.DealerTPstatus.contains("Y"))) {  //with secured task
				if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
					 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
					 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

					Utilities.passresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are enabled",null, datetimestart);
				}

				else {

					Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled",null, datetimestart);
				}
			} else if ((TieredPricing.STavailable == 1) && (TieredPricing.DealerTPstatus.contains("N"))) {  //with secured task

				if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
					 && Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
					 && !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

					Utilities.passresult(methodname,"Financial page Solve for rates, and Solve for installment are enabled and Fixrates checkboxes are disabled for non tp dealer",null, datetimestart);
				}

				else {

					Utilities.failresult(methodname,"Financial page Solve for rates, and Solve for installment and Fixrates checkboxes are not enabled / disabled as expected for non tp dealer",null, datetimestart);
				}
			} else if ((TieredPricing.STavailable == 0) && (TieredPricing.DealerTPstatus.contains("Y"))) {   //Without secured task

				if ((Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforinstallment).isEnabled())
					&& !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Solveforrate).isEnabled()
					&& !Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isEnabled()) {

					Utilities.passresult(methodname,"Financial page Solve for rates,Fixrates checkboxes are disabled and Solve for installment are enabled",null, datetimestart);
				}

				else {

					Utilities.failresult(methodname,"Financial page Solve for rates,Fixrates checkboxes are not enabled/disabled as expected",null, datetimestart);
				}
			}

			if (!Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {

				String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
				System.out.println(AERAPR2);
				String APR2 = AERAPR2.substring(8, 12);
				System.out.println(APR2);
				Float DecisionAPR = Float.parseFloat(APR2);
				System.out.println(DecisionAPR);
				if ((Finishlinecreaterate < Finishlineminrate || Finishlinecreaterate > Finishlinemaxrate)) {
					
					if (DecisionAPR.equals(Finishlinedefaultrate)) {

						String APRRATE2 = Float.toString(DecisionAPR);

						Utilities.passresult(methodname,"APR rate is recalculated to the Tiered Pricing  Default rate as Expected","Calculated TP Rate:" + APRRATE2 + " TP_MINRATE: " + Finishlineminrate.toString()+ " TP_MAXRATE: " + Finishlinemaxrate.toString(),datetimestart);
						activitys.add(0, "Automatically Referred");
						activitys.add(1, "Call Validate Decision Made");
						activitys.add(2, "Tiered Pricing Exceptions");
						activitys.add(3, "Modelled Using Tiered APR");
						activitys.add(4, "Tiered Pricing Rate Set");
						activitys.add(5, "Additional Attribute Added");
						Primaryvalue.add(0, "Tiered Pricing");
						Primaryvalue.add(1, "APR Rate Fixed");
						Secondaryvalue.add(0, Driver.getData("Ratefixed"));
						Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

					} else {
						String APRRATE2 = Float.toString(DecisionAPR);

						Utilities.failresult(methodname,"APR rate is Not recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
					}

				}

				else if ((DecisionAPR >= Finishlineminrate && DecisionAPR <= Finishlinemaxrate)) {

					if (DecisionAPR.equals(Finishlinecreaterate)) {
						String APRRATE2 = Float.toString(DecisionAPR);

						Utilities.passresult(methodname,"APR rate is recalculated within the Tiered Pricing  Min max rate as Expected","Calculated TP Rate:" + APRRATE2 + " TP_MINRATE: " + Finishlineminrate.toString()+ " TP_MAXRATE: " + Finishlinemaxrate.toString(),datetimestart);
						activitys.add(0, "Automatically Referred");
						activitys.add(1, "Call Validate Decision Made");
						activitys.add(2, "Tiered Pricing Exceptions");
						activitys.add(3, "Additional Attribute Added");
						Primaryvalue.add(0, "Tiered Pricing");
						Primaryvalue.add(1, "APR Rate Fixed");
						Secondaryvalue.add(0, Driver.getData("Ratefixed"));

						Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");

					}

					else {
						String APRRATE2 = Float.toString(DecisionAPR);

						Utilities.failresult(methodname,
								"APR rate Not calculated within the Tierepricing Min max rates as expected", APRRATE2,
								datetimestart);

					}
				}

				activitys1.add(0, "Dummy");
				Primaryvalue.add(0, "Tiered Pricing");
				Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details");
				activitys2.add(0, "Specialterms");
				Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details"); // status:ST-Special Terms,plan:details
				
			} else if (Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {
				
				Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).clear();
				Thread.sleep(700);

				Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Proposerate).sendKeys(Driver.getData("Fproposrate"));
				Thread.sleep(700);

				if (Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_Fixrates).isSelected()) {

					Utilities.passresult(methodname, "Fix rates checkbox is  ticked", null, datetimestart);
				}

				else {

					Utilities.failresult(methodname, "Fix rates checkbox not ticked", null, datetimestart);
				}

				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(2000);

				// Switch the driver context to the alert
				Alert alertDialog = Common_Property.driver.switchTo().alert();
				// Get the alert text
				String alertText = alertDialog.getText();
				// Click the OK button on the alert.
				alertDialog.accept();
				Thread.sleep(950);
				
				Utilities.passresult(methodname, "pop up displayed", alertText, datetimestart);
				// Calculate
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
				Thread.sleep(1000);

				String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
				System.out.println(AERAPR2);
				String APR2 = AERAPR2.substring(8, 12);
				Float Createrate1 = Float.parseFloat(APR2);

				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(1050);

				// Refresh

				WebElement element = Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh);
				JavascriptExecutor jse = (JavascriptExecutor) Common_Property.driver;
				jse.executeScript("arguments[0].click();", element);

				String DecisionAPR3 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
				System.out.println(DecisionAPR3);
				// To pick APR from the Flat rate / Yield / APR
				String D[] = new String[3];
				int L, M = 0, N = 0;
				for (L = 0; L < 3; L++) {
					
					M = DecisionAPR3.indexOf('%', N);
					D[L] = DecisionAPR3.substring(N, M);
					N = M + 3;
					System.out.println(D[L]);

				}

				Float DecisionAPR5 = Float.parseFloat(D[2]);

				if ((Createrate1 < Finishlineminrate || Createrate1 > Finishlinemaxrate)) {
					
					if ((Createrate1.equals(DecisionAPR5) && (!Createrate1.equals(Finishlinedefaultrate)))) {
						String crtrate = Createrate1.toString();

						Utilities.passresult(methodname,"Tiered pricing rate not used and the fix rates check box is fixed", crtrate,datetimestart);
					} else {

						String crtrate = Createrate1.toString();

						Utilities.failresult(methodname, "Tiered pricing rate used", crtrate, datetimestart);
					}
				} else if ((Createrate1 >= Finishlineminrate && Createrate1 <= Finishlinemaxrate)) {
					
					if ((Createrate1.equals(DecisionAPR5))) {
						String crtrate = Createrate1.toString();

						Utilities.passresult(methodname,"Tiered pricing rate not used and the fix rates check box is fixed", crtrate,datetimestart);
					} else {

						String crtrate = Createrate1.toString();

						Utilities.failresult(methodname, "Tiered pricing rate used", crtrate, datetimestart);
					}
				}

				activitys.add(0, "Automatically Referred");
				activitys.add(1, "Call Validate Decision Made");
				activitys.add(2, "Tiered Pricing Exceptions");
				activitys.add(3, "Additional Attribute Added");
				Primaryvalue.add(0, "Tiered Pricing");
				Primaryvalue.add(1, "APR Rate Fixed");
				Secondaryvalue.add(0, "Y");
				Agreementevents.Agr_events_check(activitys, Primaryvalue, Secondaryvalue, "TP", "DR");
				activitys1.add(0, "Dummy");
				// Primaryvalue.add(0,"Tiered Pricing");
				Agreementevents.Agr_events_check(activitys1, Primaryvalue, null, "Exception", "Details");
				activitys2.add(0, "Specialterms");
				Agreementevents.Agr_events_check(activitys2, null, null, "ST", "Details"); //status:ST-Special Terms,plan:details
			
			}
			/*
			 *} else
			 * {
			 * Utilities.failresult(methodname,
			 * "Batch process ended with error", null, datetimestart); 
			 * }
			 */

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	public static void SMF_Notieredpricingrates()  {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Utilities.ExtentPassReport(methodname);
			Thread.sleep(1000);
			pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
			Thread.sleep(700);

			if (pagename.contains("Financials")) {

				String Createdtype = Driver.getData("Createdtype");
				Float Createrate = Float.parseFloat(Driver.getData("Proposrate"));
				Float TP_MIN_RATE = Float.parseFloat(Driver.getData("TIP_MIN_RATE")); 
				Float TP_MAX_RATE = Float.parseFloat(Driver.getData("TIP_MAX_RATE")); 
				Float TP_DefaultRate = Float.parseFloat(Driver.getData("TIP_DEFAULT_RATE"));
				Float Flatminrate = Float.parseFloat(Driver.getData("Flat_Minrate"));
				Float Flatmaxrate = Float.parseFloat(Driver.getData("Flat_Maxrate"));
				Float Yieldminrate = Float.parseFloat(Driver.getData("Yield_Minrate"));
				Float Yieldmaxrate = Float.parseFloat(Driver.getData("Yield_Maxrate"));

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Common_Property.SQLcon = DriverManager.getConnection(Configuration.OracleDatabase, "forte", "forte");
				Common_Property.st = Common_Property.SQLcon.createStatement();
				String Agreementno = "'" + Driver.getData("Agreement_Number") + "'";
				System.out.println(Agreementno);
				String Query1 = "select AGR_SERIAL from agreements Where AGR_AGREEMENT_NUMBER=" + Agreementno + " ";
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query1);
				Common_Property.rs = Common_Property.st.executeQuery(Query1);
				Common_Property.rs.next();

				String AgrSerial = "'" + Common_Property.rs.getString("AGR_SERIAL") + "'";
				System.out.println(AgrSerial);

				Common_Property.st = Common_Property.SQLcon.createStatement();
				Common_Property.Pst = Common_Property.SQLcon
						.prepareStatement(TieredPricing.TieredpricingSQL("", "", "", "", "", AgrSerial));
				Common_Property.rs = Common_Property.st
						.executeQuery(TieredPricing.TieredpricingSQL("", "", "", "", "", AgrSerial));
				Common_Property.rs.next();

				String DealerTPstatus;
				if ((TieredPricing.STavailable == 1)  //with secured task
					&& (Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED").contains("Y"))) {
					
					
					DealerTPstatus = Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED");
					Utilities.passresult("Tiered pricing", "Dealer used tiered pricing enabled", DealerTPstatus,datetimestart);
					
					if ((Common_Property.driver.findElement(By.xpath("//input[@value='instalment']")).isEnabled())
						 && Common_Property.driver.findElement(By.xpath("//input[@value='rates']")).isEnabled()
						 && Common_Property.driver.findElement(By.name("finFixRate")).isEnabled()) {

						Utilities.passresult(methodname,"Financial page_Solve for rates,Solve for installment are enabled& Fixrates checkboxes are disabled","", datetimestart);
					}

					else {

						Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled/Disabled","", datetimestart);
					}

				} else if (((TieredPricing.STavailable == 0) || (TieredPricing.STavailable == 1))  // Without secured task or with secured task  
						&& (Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED").contains("N"))) {

					DealerTPstatus = Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED");
					Utilities.passresult("Tiered pricing", "Dealer used is not tiered pricing enabled", DealerTPstatus,datetimestart);
					
					if ((Common_Property.driver.findElement(By.xpath("//input[@value='instalment']")).isEnabled())
						 && Common_Property.driver.findElement(By.xpath("//input[@value='rates']")).isEnabled()
						 && !Common_Property.driver.findElement(By.name("finFixRate")).isEnabled()) {

						Utilities.passresult(methodname,"Financial page_Solve for rates,Solve for installment are enabled& Fixrates checkboxes are disabled","", datetimestart);
					}

					else {

						Utilities.failresult(methodname,"Financial page Solve for rates,Solve for installment,Fixrates checkboxes are not enabled/Disabled","", datetimestart);
					}

				}

				// Calculate
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Calculate).click();
				Thread.sleep(700);

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Common_Property.SQLcon = DriverManager.getConnection(Configuration.OracleDatabase, "forte", "forte");
				Common_Property.st = Common_Property.SQLcon.createStatement();
				String Agreementno1 = "'" + Driver.getData("Agreement_Number") + "'";
				System.out.println(Agreementno1);
				String Query2 = "select AGR_EFFECTIVE_RATE,agr_customer_effective_rate,ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1),ROUND(AGR_EFFECTIVE_RATE,2),to_char(agr_create_date,'DD-MON-YYYY HH24:MI:SS')from agreements Where AGR_AGREEMENT_NUMBER="
						+ Agreementno1 + " ";
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query2);
				Common_Property.rs = Common_Property.st.executeQuery(Query2);
				Common_Property.rs.next();
				String RoundoffAPR = Common_Property.rs.getString("ROUND(AGR_CUSTOMER_EFFECTIVE_RATE,1)");
				String RoundoffAER = Common_Property.rs.getString("ROUND(AGR_EFFECTIVE_RATE,2)");
				String APR = Common_Property.rs.getString(("agr_customer_effective_rate"));
				String AER = Common_Property.rs.getString(("AGR_EFFECTIVE_RATE"));
				Utilities.passresult(methodname, "Agr_Customer Effective rate" + APR + "round off to the value",
						RoundoffAPR, datetimestart);
				Utilities.passresult(methodname, "Agr_Customer APR rate" + AER + "round off to the value", RoundoffAER,
						datetimestart);
				// Continue
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Continue).click();
				Thread.sleep(1000);

				// Refresh
				Common_Property.driver.findElement(POM_StartLine.SMF_Commonfuntion_Refresh).click();
				Thread.sleep(700);

				String DecisionAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Decisionpage_decisionpageAPR).getText().toString();
				System.out.println(DecisionAPR2);
				// To pick APR from the Flat rate / Yield / APR
				String s[] = new String[3];
				int i, j = 0, k = 0;
				for (i = 0; i < 3; i++) {
					j = DecisionAPR2.indexOf('%', k);
					s[i] = DecisionAPR2.substring(k, j);
					k = j + 3;
					System.out.println(s[i]);

				}

				Float DecisionAPR = Float.parseFloat(s[2]);

				if (Createdtype.contains("APR")) {
					
					if ((Createrate < TP_MIN_RATE || Createrate > TP_MAX_RATE)) {
						
						if ((RoundoffAPR.toString()).equalsIgnoreCase((DecisionAPR.toString()))) {
							Utilities.passresult(methodname, "APR rate rounded of as expected", RoundoffAPR.toString(),datetimestart);
						} 
						else {
							Utilities.failresult(methodname, "APR rate is not rounded of as expected",RoundoffAPR.toString(), datetimestart);
						}
						if (!DecisionAPR.equals(TP_DefaultRate)) {
							
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.passresult(methodname,"APR rate is not recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
						} else {
							
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.failresult(methodname,"APR rate is recalculated to the Tiered Pricing  Default rate as Expected",APRRATE2, datetimestart);
						}

					}

					else if ((Createrate >= TP_MIN_RATE && Createrate <= TP_MAX_RATE)) {

						if (!Createrate.equals(DecisionAPR))

						{
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.passresult(methodname,"APR rate not calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
						}

						else {
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.failresult(methodname,"APR rate  calculated within the Tierepricing Min max rates as expected", APRRATE2,datetimestart);
						}
					}

				} else if (Createdtype.contains("Flat")) {

					if ((Createrate >= Flatminrate && Createrate <= Flatmaxrate)) {

						// navigate to Financial
						Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
						Thread.sleep(700);

						String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
						System.out.println(AERAPR2);
						String APR2 = AERAPR2.substring(8, 12);
						Float Createrate1 = Float.parseFloat(APR2);

						// navigate to Decision
						Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
						Thread.sleep(700);

						if (Createrate1.equals(DecisionAPR)) {
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.passresult(methodname,"APR (Flat) rate calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
						}

						else {

							String APRRATE2 = Float.toString(DecisionAPR);
							Utilities.failresult(methodname,"APR (Flat) rate is not calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
						}

					} else if ((Createrate < Flatminrate || Createrate > Flatmaxrate)) {
						
						if (!DecisionAPR.equals(TP_DefaultRate)) {
							
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.passresult(methodname,"APR(Flat) rate not calculated to the Tierepricing Default rate as expected",APRRATE2, datetimestart);
						}

						else {

							Utilities.failresult(methodname,"APR(Flat) rate  calculated to the Tierepricing Default rate", null, datetimestart);
						}
					}

				}

				else if (Createdtype.contains("Yield")) {

					if ((Createrate >= Yieldminrate && Createrate <= Yieldmaxrate)) {
						// navigate to Financial
						Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
						Thread.sleep(700);

						String AERAPR2 = Common_Property.driver.findElement(POM_StartLine.SMF_Financialpage_APRratefield).getText().toString();
						System.out.println(AERAPR2);
						String APR2 = AERAPR2.substring(8, 12);
						Float Createrate1 = Float.parseFloat(APR2);

						// navigate to Decision
						Common_Property.driver.findElement(POM_StartLine.SMF_Navigate_toDecisionpage).click();
						Thread.sleep(700);

						if (Createrate1.equals(DecisionAPR)) {
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.passresult(methodname,"APR (Yield) rate calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
						}

						else {

							String APRRATE2 = Float.toString(DecisionAPR);
							Utilities.failresult(methodname,"APR (Yield) rate is not calculated within the Tierepricing Min max rates as expected",APRRATE2, datetimestart);
						}
					} else if ((Createrate < Yieldminrate || Createrate > Yieldmaxrate)) {
						
						if (DecisionAPR.equals(TP_DefaultRate)) {
							
							String APRRATE2 = Float.toString(DecisionAPR);

							Utilities.passresult(methodname,"APR(Yield) rate calculated to the Tierepricing Default rate as expected", APRRATE2,datetimestart);
						}

						else {

							String APRRATE2 = Float.toString(DecisionAPR);
							Utilities.failresult(methodname,"APR(Yield) rate Not calculated to the Tierepricing Default rate", APRRATE2,datetimestart);
						}
					}

				}

			}

			else { // navigation to financial tab

				pagename = Common_Property.driver.findElement(POM_StartLine.SMF_CommonPagetitle).getText().toString();
				Thread.sleep(700);

				if (pagename.contains("Decision")) {
					Common_Property.driver.findElement(POM_StartLine.SMF_NavigatetoFinancials).click();
					Thread.sleep(700);
					SMF_Notieredpricingrates();
				}
			}

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.failresult(methodname, Desc, null, datetimestart);

		}

	}

	
		

	public static void SqlConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Common_Property.SQLcon = DriverManager.getConnection(Configuration.OracleDatabase, "forte", "forte");
			Common_Property.st = Common_Property.SQLcon.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception" + e);
		}

	}
}
