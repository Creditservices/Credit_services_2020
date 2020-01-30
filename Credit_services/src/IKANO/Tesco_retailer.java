package IKANO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;

public class Tesco_retailer extends Driver {
	public static ArrayList<String> store_agrs = new ArrayList<String>();
	public static ArrayList<String> status = new ArrayList<String>();
	public static ArrayList<String> attributes = new ArrayList<String>();
	public static Recordset get_agr_sheet;
	public static boolean flag = false;
	public static String filename,AltFilename,fileexe;
	

	public static void Start_App() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@id='privacyStatusCheckBox']")).click();
			Thread.sleep(700);
			JavascriptExecutor js = (JavascriptExecutor) Common_Property.driver;
			js.executeScript("window.scrollBy(0,500)");
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a[@id='formSubmit']")).click();

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Loan_Page() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// Thread.sleep(1200);
			// Common_Property.driver.findElement(By.xpath("//input[@id='privacyStatusCheckBox']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='goodsDescRequired']"))
					.sendKeys(Driver.getData("Goods"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='totalCashPriceRequired']"))
					.sendKeys(Driver.getData("Cash_Price"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='deposit']"))
					.sendKeys(Driver.getData("Deposit"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='warranty']")).sendKeys("0.00");
			Thread.sleep(700);
			Select delivery = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='deliveryTypeID']")));
			delivery.selectByIndex(1);
			Thread.sleep(700);
			Select plan = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='planId']")));
			plan.selectByValue(Driver.getData("Product"));
			Thread.sleep(1000);
			// Select[@name='planId']
			Common_Property.driver.findElement(By.xpath("//a[@id='solvebutton']")).click();
			Thread.sleep(1500);
			// a/span[text()='CHOOSE THIS PAYMENT PLAN ']
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CHOOSE THIS PAYMENT PLAN ']")).click();
			Thread.sleep(6000);
			Utilities.ExtentPassReport("Explanation Page");
			Common_Property.driver.findElement(By.xpath("//a[@id='formSubmit']")).click();
			Thread.sleep(4000);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void Personal_Page() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='staff']")).sendKeys("1234");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='salesPersonFirstName']"))
					.sendKeys(Driver.getData("F_salesman"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='salesPersonLastName']"))
					.sendKeys(Driver.getData("L_salesman"));
			Thread.sleep(700);
			Select title = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='person.titleID']")));
			title.selectByValue(Driver.getData("Title"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.firstname']"))
					.sendKeys(Driver.getData("F_name"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.surname']"))
					.sendKeys(Driver.getData("S_name"));
			Thread.sleep(700);
			Select day = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='day']")));
			day.selectByValue("6");
			Select month = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='month']")));
			month.selectByValue("6");
			Select year = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='year']")));
			year.selectByValue("1990");
			Thread.sleep(700);
			Select Proof = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='proofOfIDMethod']")));
			Proof.selectByValue("100710");
			JavascriptExecutor js = (JavascriptExecutor) Common_Property.driver;
			js.executeScript("window.scrollBy(0,500)");
			Common_Property.driver.findElement(By.xpath("//input[@name='proofOfIDReference']")).sendKeys("1234");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.emailAddress']"))
					.sendKeys("She@gamil.com");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='confirmEmail']")).sendKeys("She@gamil.com");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='employment.telephone']"))
					.sendKeys(Driver.getData("Telephone"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.mobileNumber']"))
					.sendKeys(Driver.getData("Mobile"));
			Thread.sleep(700);
			Select m_status = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='person.maritalStatusID']")));
			m_status.selectByValue(Driver.getData("M_status"));
			Common_Property.driver.findElement(By.xpath("//input[@name='person.numberOfDependants']"))
					.sendKeys(Driver.getData("Dependencies"));
			Thread.sleep(800);
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS AND CONTINUE']")).click();

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Address_Page(Recordset Rec) throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		// System.out.println(Rec.getCount());
		try {
			
			String agreementno = Common_Property.driver.findElement(By.xpath("//div[@id='SaveBox']/div/p/strong[1]"))
					.getText();
			Thread.sleep(700);
			String Loan = Common_Property.driver.findElement(By.xpath("//div[@id='SaveBox']/div/p/strong[2]"))
					.getText();
			System.out.println(Loan);
			Agreement_Store.Store_Data(WhichClient, agreementno, Loan, Rec);
			Utilities.ExtentPassReport("Storing the Agreement_Number");
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@name='currentPostcode']"))
					.sendKeys(Driver.getData("postcode"));
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='Find Address ']")).click();
			Thread.sleep(2700);
			boolean close = Common_Property.driver.findElements(By.xpath("//button/span[text()='Close']")).size()>0;
			if (close==true) {
				Common_Property.driver.findElement(By.xpath("//button/span[text()='Close']")).click();
				Thread.sleep(700);
				Common_Property.driver.findElement(By.xpath("//input[@name='currentFlat']"))
						.sendKeys(Driver.getData("Flat"));
				Thread.sleep(700);
				Common_Property.driver.findElement(By.xpath("//input[@name='currentPropertyNumber']"))
						.sendKeys(Driver.getData("P_Number"));
				Thread.sleep(700);
				Common_Property.driver.findElement(By.xpath("//input[@name='currentStreetName']"))
						.sendKeys(Driver.getData("Street"));
				Thread.sleep(700);
				Common_Property.driver.findElement(By.xpath("//input[@name='currentTown']"))
						.sendKeys(Driver.getData("Town"));
				Thread.sleep(700);
				Common_Property.driver.findElement(By.xpath("//input[@name='currentCounty']"))
						.sendKeys(Driver.getData("County"));

			} else {
				Thread.sleep(1000);
				Common_Property.driver.findElement(By.xpath("//Select[@id='AddressSelectBox']/option[5]")).click();
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//span[text()='Select']")).click();
				Thread.sleep(700);
			}
			Select c_year = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='currentYears']")));
			c_year.selectByValue("5");
			Thread.sleep(700);
			Select c_month = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='currentMonths']")));
			c_month.selectByValue("5");
			Thread.sleep(700);
			JavascriptExecutor js = (JavascriptExecutor) Common_Property.driver;
			js.executeScript("window.scrollBy(0,500)");
			Select r_status = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='occupancyID']")));
			r_status.selectByValue("3"); // Select[@name='proofOfAddressMethod']
			Thread.sleep(700);
			Select Addrs_proof = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='proofOfAddressMethod']")));
			Addrs_proof.selectByValue("100715");
			Common_Property.driver.findElement(By.xpath("//input[@name='proofOfAddressReference']")).sendKeys("1234");
			Thread.sleep(700);
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS AND CONTINUE']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//button/span[text()='OK']")).click();

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Employee_Page() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(700);
			Select emp = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='person.employmentStatusID']")));
			emp.selectByValue("100064");
			Thread.sleep(700);
			Select emp1 = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='grossAnnualIncome']")));
			emp1.selectByValue("9");
			Common_Property.driver.findElement(By.xpath("//input[@name='employment.employerName']"))
					.sendKeys(Driver.getData("emp_name"));
			Thread.sleep(700);
			Select emp_year = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='yearsWith']")));
			emp_year.selectByValue("4");
			Select emp_month = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='monthsWith']")));
			emp_month.selectByValue("4");
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS AND CONTINUE']")).click();
			Thread.sleep(700);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Financial_Page() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode1']")).sendKeys("20");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode2']")).sendKeys("23");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode3']")).sendKeys("97");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='bankAccount.accountNumber']"))
					.sendKeys("23729745");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS']")).click();
			Thread.sleep(700);
			Select bank_year = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='years']")));
			bank_year.selectByValue("5");
			Thread.sleep(700);
			Select bank_month = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='months']")));
			bank_month.selectByValue("5");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='mortgage']")).sendKeys("50");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='creditCards']")).sendKeys("1");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='debitCards']")).sendKeys("1");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='storeCards']")).sendKeys("1");
			Thread.sleep(700);
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS AND CONTINUE']")).click();
		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static boolean Marketing_Page() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@id='marketingDetailsForm_peoplePosttrue']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@id='marketingDetailsForm_peopleMailtrue']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@id='marketingDetailsForm_peopleSmstrue']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@id='marketingDetailsForm_peoplePhonetrue']")).click();
			Thread.sleep(700);
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS AND CONTINUE']")).click();
			Thread.sleep(1500);
			WebElement ver1 = Common_Property.driver.findElement(By.xpath("//a/span[text()='SUBMIT APPLICATION']"));
			if (ver1.isDisplayed()) {
				Utilities.ExtentPassReport("SUBMIT APPLICATION");
			} else {
				String Desc = "Application has not redirected to SUBMIT APPLICATION page";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Common_Property.driver.findElement(By.xpath("//a/span[text()='SUBMIT APPLICATION']")).click();
			Thread.sleep(10000);
			WebElement ver2 = Common_Property.driver.findElement(By.xpath("//a/span[text()='REFRESH STATUS']"));
			if (ver2.isDisplayed()) {
				Utilities.ExtentPassReport("Agreement successfully redirected to refresh page");
				flag = true;
			} else {
				String Desc = "Application has not completed successfully";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
		return flag;

	}

	public static void Search_Agreement() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Actions actions = new Actions(Common_Property.driver);
			WebElement mousehover = Common_Property.driver.findElement(By.xpath("//a/span[text()='MAIN MENU']"));
			actions.moveToElement(mousehover).perform();
			// Common_Property.driver.findElement(By.xpath("//a/span[text()='MAIN
			// MENU']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='SEARCH APPLICATIONS']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='agreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='LIST']")).click();
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//table/tbody/tr[2]/td/a[text()='VIEW']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//button/span[text()='Review']")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) Common_Property.driver;
			js1.executeScript("window.scrollBy(0,500)");
			Thread.sleep(5000);
			Utilities.ExtentPassReport(methodname);
			WebElement retailer = Common_Property.driver
					.findElement(By.xpath("//div[@id='WelcomeBoxContent']/p/span[2]/strong/span"));
			if (retailer.getText().contains("VISION")) {
				System.out.println("This is a Vision Retailer, So No need of e-sign for the agreement");
			} else {
				Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM E-SIGNATURE']")).click();
			}
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void Esign_Agreement() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(6000);
			Common_Property.driver.findElement(By.xpath("//div[@class='popupButtonArea']/input[@id='popupContinue']"))
					.click();
			Thread.sleep(700);
			JavascriptExecutor js = (JavascriptExecutor) Common_Property.driver;
			js.executeScript("window.scrollBy(0,2300)");

			Common_Property.driver
					.findElement(By
							.xpath("//td/div[@id='wwgrp_secciSigned']/div[@id='wwctrl_secciSigned']/input[@name='secciSigned']"))
					.click();
			Thread.sleep(8000);
			WebElement ver = Common_Property.driver.findElement(By.xpath("//div/a[@id='ProceedButton']"));
			if (ver.isEnabled()) {
				Utilities.ExtentPassReport("Legal_Information page ");
			} else {
				String Desc = "Proceed button is not enabled, please make sure all the checkboxes are checked";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Common_Property.driver.findElement(By.xpath("//div/a[@id='ProceedButton']")).click();
			Thread.sleep(6000);
			JavascriptExecutor js1 = (JavascriptExecutor) Common_Property.driver;
			js1.executeScript("window.scrollBy(0,3500)");
			Common_Property.driver.findElement(By.xpath("//input[@name='agreementSigned']")).click();
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//td/div[@id='wwgrp_warrantySigned']/div[@id='wwctrl_warrantySigned']/input[@id='warrantySigned']"))
					.click();
			Thread.sleep(700);
			Common_Property.driver
					.findElement(
							By.xpath("//td/div[@id='wwgrp_coSigned']/div[@id='wwctrl_coSigned']/input[@id='coSigned']"))
					.click();
			Thread.sleep(1700);
			WebElement ver1 = Common_Property.driver.findElement(By.xpath("//div/a[@id='SubmitButton']"));
			if (ver1.isEnabled()) {
				Utilities.ExtentPassReport("E-signature page");
			} else {
				String Desc = "Proceed button is not enabled, please make sure all the checkboxes are checked";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Common_Property.driver.findElement(By.xpath("//div/a[@id='SubmitButton']")).click();
			Thread.sleep(700);
			Utilities.ExtentPassReport("All the PDF document has generated");
			Common_Property.driver.findElement(By.xpath("//a/span[text()='Next']")).click();
			Thread.sleep(1000);
//			Common_Property.driver.findElement(By.xpath("//a/span[text()='Continue']")).click();
//			Thread.sleep(1000);
//			WebElement ver2 = Common_Property.driver.findElement(By.xpath("//a[@id='goodsDelivered']/span"));
//			if (ver2.isEnabled()) {
//				Utilities.ExtentPassReport("Approved Goods ");
//			} else {
//				String Desc = "Agreement is not created as expected,throws unexpected error";
//				Utilities.ExtentFailReport1(methodname, Desc);
//			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void Loan_page_Vision() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//input[@name='loanAmountRequired']"))
					.sendKeys(Driver.getData("Cash_Price"));
			Thread.sleep(700);
			Select plan = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='planId']")));
			plan.selectByValue(Driver.getData("Product"));

			Common_Property.driver.findElement(By.xpath("//a[@id='solvebutton']")).click();
			Thread.sleep(1500);
			// a/span[text()='CHOOSE THIS PAYMENT PLAN ']
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CHOOSE THIS PAYMENT PLAN ']")).click();
			Thread.sleep(6000);
			JavascriptExecutor js1 = (JavascriptExecutor) Common_Property.driver;
			js1.executeScript("window.scrollBy(0,1500)");
			Utilities.ExtentPassReport("Explanation page");
			Thread.sleep(600);
			Common_Property.driver.findElement(By.xpath("//a[@id='formSubmit']")).click();

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Personal_Page_Vision() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='staff']")).sendKeys("1234");
			// Thread.sleep(700);
			// Common_Property.driver.findElement(By.xpath("//input[@name='salesPersonFirstName']")).sendKeys(Driver.getData("F_salesman"));
			// Thread.sleep(700);
			// Common_Property.driver.findElement(By.xpath("//input[@name='salesPersonLastName']")).sendKeys(Driver.getData("L_salesman"));
			Thread.sleep(700);
			Select title = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='person.titleID']")));
			title.selectByValue(Driver.getData("Title"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.firstname']"))
					.sendKeys(Driver.getData("F_name"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.surname']"))
					.sendKeys(Driver.getData("S_name"));
			Thread.sleep(700);
			Select day = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='day']")));
			day.selectByValue("6");
			Select month = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='month']")));
			month.selectByValue("6");
			Select year = new Select(Common_Property.driver.findElement(By.xpath("//Select[@name='year']")));
			year.selectByValue("1990");
			Thread.sleep(700);
			Select Proof = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='proofOfIDMethod']")));
			Proof.selectByValue("100710");
			JavascriptExecutor js = (JavascriptExecutor) Common_Property.driver;
			js.executeScript("window.scrollBy(0,500)");
			Common_Property.driver.findElement(By.xpath("//input[@name='proofOfIDReference']")).sendKeys("1234");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.emailAddress']"))
					.sendKeys("She@gamil.com");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='confirmEmail']")).sendKeys("She@gamil.com");
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='employment.telephone']"))
					.sendKeys(Driver.getData("Telephone"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='person.mobileNumber']"))
					.sendKeys(Driver.getData("Mobile"));
			Thread.sleep(700);
			Select m_status = new Select(
					Common_Property.driver.findElement(By.xpath("//Select[@name='person.maritalStatusID']")));
			m_status.selectByValue(Driver.getData("M_status"));
			Common_Property.driver.findElement(By.xpath("//input[@name='person.numberOfDependants']"))
					.sendKeys(Driver.getData("Dependencies"));
			Thread.sleep(800);
			Utilities.ExtentPassReport(methodname);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='CONFIRM DETAILS AND CONTINUE']")).click();

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Check_status_code() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Common_Property.SqlConnection();
			String Query5 = "select to_char(pp_pan_process_date.gf_date_with_time() ,'ddMMYYYYHH24MISS') as currenttime from dual";
            Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query5);
            Common_Property.rs1 = Common_Property.st.executeQuery(Query5);
            Common_Property.rs1.next();
            fileexe= Common_Property.rs1.getString("currenttime");
			String Agr_num = "'" + recordset1.getField("Agreement_Number")+"'";
			filename = recordset1.getField("ESM_filename");
			AltFilename = filename + "_"+fileexe;
			String Query2 = "select agr_agreement_number, agr_serial, agr_status_1, agr_status_2, agr_status_code_vlc, agr_advance,TO_CHAR(agr_signed_date,'DD-MON-YYYY') as agr_signed_date,TO_CHAR(PP_PAN_PROCESS_DATE.GF_DATE_WITHOUT_TIME(),'DD-MON-YYYY') as Process_date"
					+ " from agreements  where agr_agreement_number =" + Agr_num + "";
			Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query2);
			Common_Property.rs1 = Common_Property.st.executeQuery(Query2);
			Common_Property.rs1.next();

			if (StringUtils.isBlank(Common_Property.rs1.getString("agr_signed_date"))) {
				update_esign_date(Common_Property.rs1.getString("Process_date"), Agr_num);
			}
			// Common_Property.rs1 = Common_Property.st.executeQuery(Query2);
			// Common_Property.rs1.next();
			System.out.println(Common_Property.rs1.getString("agr_status_1"));
			System.out.println(Common_Property.rs1.getString("agr_signed_date"));
			System.out.println(Common_Property.rs1.getString("Process_date"));
			if ((Common_Property.rs1.getString("agr_status_1").equalsIgnoreCase(recordset1.getField("status_code1")))
					&& (Common_Property.rs1.getString("agr_status_2")
							.equalsIgnoreCase(recordset1.getField("status_code2")))
					&& (Common_Property.rs1.getString("agr_status_code_vlc")
							.equalsIgnoreCase(recordset1.getField("vlc_status_code")))
					&& (Common_Property.rs1.getString("Process_date")
							.equalsIgnoreCase(Common_Property.rs1.getString("agr_signed_date"))))

			{
				String filename1 = "'"+recordset1.getField("put_ag_no")+"'";
				FieldNames.add(0, "Agreement_Number");
				FieldNames.add(1, "ESM_validation");
				FieldValues.add(0, Agr_num);
				FieldValues.add(1, "'Yes'");
				FieldNames.add(2, "put_ag_no");
				FieldValues.add(2, filename1);
				String update = Common_Property.StrUpdateQuery("Sheet1", FieldNames, FieldValues);
				connection.executeUpdate(update);
				String Desc = "All the verification has been done successfully";
				Utilities.ExtentPassReport(Desc);
				System.out.println(Agr_num + " Has Passed");
				convertXLSXtoCSV(recordset1, Common_Property.directory + "/" + filename);
				sendCSV(Common_Property.directory+ "/"+AltFilename+".csv");
				

			} else {
				System.out.println(Agr_num + " Has  not Passed");
			}

			// }

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void send(String fileName) {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		String SFTPHOST = "linux02"; // host name
		int SFTPPORT = 22; // Port number
		String SFTPUSER = "emay"; // Linux02 USER"S username
		String SFTPPASS = "sachin@123"; // Linux02 USER"S Password
		String SFTPWORKINGDIR = "/panenv/IKANOTSTENV/data";

		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		System.out.println("preparing the host information for sftp.");

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			System.out.println("Host connected.");
			channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("sftp channel opened and connected.");
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(SFTPWORKINGDIR);
			File f = new File(fileName);
			channelSftp.put(new FileInputStream(f), f.getName());
			System.out.println("File transfered successfully to host.");

		} catch (Exception ex) {
			System.out.println("Exception found while tranfer the response.");
		} finally {
			channelSftp.exit();
			System.out.println("sftp Channel exited.");
			channel.disconnect();
			System.out.println("Channel disconnected.");
			session.disconnect();
			System.out.println("Host Session disconnected.");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void check_agreement_status() throws IOException, FilloException, InterruptedException {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Actions actions = new Actions(Common_Property.driver);
			WebElement mousehover = Common_Property.driver.findElement(By.xpath("//a/span[text()='MAIN MENU']"));
			actions.moveToElement(mousehover).perform();
			// Common_Property.driver.findElement(By.xpath("//a/span[text()='MAIN
			// MENU']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='SEARCH APPLICATIONS']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//input[@name='agreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//a/span[text()='LIST']")).click();
			Thread.sleep(1700);

			WebElement ver = Common_Property.driver.findElement(By.xpath("//table/tbody/tr[2]/td/a[text()='VIEW']"));
			if (ver.isDisplayed()) {
				Utilities.ExtentPassReport("Reviewing the agreement ");
			} else {
				String Desc = "Agreement search is not displaying any agreeemnt, please check the agreement number";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			Common_Property.driver.findElement(By.xpath("//table/tbody/tr[2]/td/a[text()='VIEW']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//button/span[text()='Review']")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) Common_Property.driver;
			js1.executeScript("window.scrollBy(0,500)");
			Thread.sleep(5000);
			Utilities.ExtentPassReport(methodname);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void update_esign_date(String signed_date, String Agr_Num) {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("DD-MMM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			signed_date = "'" + signed_date + "'";
			String update_csv = "update agreements set AGR_STATUS_CODE_VLC='101104',AGR_SIGNED_DATE=to_date("
					+ signed_date + ",'DD-MON-YYYY')" + " where agr_agreement_number=" + Agr_Num + "";
			System.out.println(update_csv);
			Common_Property.updatePst = Common_Property.SQLcon.prepareStatement(update_csv);
			Common_Property.updateSt.executeUpdate(update_csv);

		} catch (Exception e) {
			System.out.println(e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}

	}

	public static void convertXLSXtoCSV(Recordset rs, String outputFile1) {
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		try {
			FileWriter fw = new FileWriter(AltFilename+".csv");
			BufferedWriter bufferedWriter = new BufferedWriter(fw);
			int cnt = 1;
			String data1;
			connection = fillo.getConnection(Configuration.Datapath + WhichClient + ".xlsx");
			
			String query = "Select * from Sheet1 where ESM_validation='Yes' and ESM_filename=" + "'" + filename + "'";
			System.out.println(query);
			rs = connection.executeQuery(query);
			System.out.println(rs.getCount());
			while (rs.next()) {

				if (cnt == 1) {
					data1 = "AgreementNumber" + "," + fileexe.subSequence(0,7) +","+"Order_Number";
					bufferedWriter.write(data1);
					bufferedWriter.newLine();
					data1 = rs.getField("Agreement_Number") + "," + rs.getField("Misc").replaceFirst("£", "").trim()+ ","
							+ rs.getField("put_ag_no");
					bufferedWriter.write(data1);
					cnt++;

				} else {
					bufferedWriter.newLine();
					data1 = rs.getField("Agreement_Number") + "," + rs.getField("Misc") + ","
							+ rs.getField("put_ag_no");
					bufferedWriter.write(data1);

				}
			}

			bufferedWriter.close();
			rs.close();

		} catch (Exception ioe) {
			ioe.printStackTrace();
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}
	
	public static void sendCSV(String fileName) {
	                String SFTPHOST ="linux02";          //host name
	                int SFTPPORT = 22;                                                  //Port number
	                String SFTPUSER = "emay";                         //Linux02 USER"S username
	                String SFTPPASS = "sachin@123";               //Linux02 USER"S Password
	                String SFTPWORKINGDIR = "/panenv/IKANOTSTENV/data";
	                         
	                Session session = null;
	                Channel channel = null;
	                ChannelSftp channelSftp = null;
	                System.out.println("preparing the host information for sftp.");

	                try 
	                {
	                    JSch jsch = new JSch();
	                    session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
	                    session.setPassword(SFTPPASS);
	                    java.util.Properties config = new java.util.Properties();
	                    config.put("StrictHostKeyChecking", "no");
	                    session.setConfig(config);
	                    session.connect();
	                    System.out.println("Host connected.");
	                    channel = session.openChannel("sftp");
	                    channel.connect();
	                    System.out.println("sftp channel opened and connected.");
	                    channelSftp = (ChannelSftp) channel;
	                    channelSftp.cd(SFTPWORKINGDIR);
	                    File f = new File(fileName);
	                    channelSftp.put(new FileInputStream(f), f.getName());
	                    Boolean value=exists(channelSftp,SFTPWORKINGDIR+"/"+AltFilename+".csv");
	                    if(value==true){
	                    System.out.println("File transfered successfully to host.");
	                    }
	                   
	                  
	                } 
	                catch (Exception ex) 
	                {
	                    System.out.println("Exception found while tranfer the response " +ex);
	                } 
	                finally 
	                {
	                    channelSftp.exit();
	                    System.out.println("sftp Channel exited.");
	                    channel.disconnect();
	                    System.out.println("Channel disconnected.");
	                    session.disconnect();
	                    System.out.println("Host Session disconnected.");
	                }
	            } 
	
	public static void download () 
	            {
	                        JSch jsch = new JSch();
	                    Session session = null;
	                    try {
	                        session = jsch.getSession("emay", "Linux02", 22);
	                        session.setConfig("StrictHostKeyChecking", "no");
	                        session.setPassword("sachin@123");
	                        session.connect();

	                        Channel channel = session.openChannel("sftp");
	                        channel.connect();
	                        ChannelSftp sftpChannel = (ChannelSftp) channel;
	                        sftpChannel.get("//panenv//IKANOTSTENV//data//VG_REF_IK_20160421_121000.csv", "C://refunds file//");
	                        sftpChannel.exit();
	                        session.disconnect();
	                    } catch (JSchException e) {
	                        e.printStackTrace();  
	                    } catch (SftpException e) {
	                        e.printStackTrace();
	                    }
	            } 
	
	private static boolean exists(ChannelSftp channelSftp, String path) {
	    Vector res = null;
	    try {
	        res = channelSftp.ls(path);
	    } catch (SftpException e) {
	        if (e.id == ChannelSftp.SSH_FX_NO_SUCH_FILE) {
	            return false;
	        }
	        //log.error("Unexpected exception during ls files on sftp: [{}:{}]", e.id, e.getMessage());
	    }
	    return res != null && !res.isEmpty();
	}
	
	            
}



