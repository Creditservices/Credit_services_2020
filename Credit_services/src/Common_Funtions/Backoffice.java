package Common_Funtions;

import java.io.IOException;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.mysql.jdbc.ResultSet;

import Common_POMs.*;
//import Common_Funtions.Configuration;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

public class Backoffice extends Driver{
	static String Settlementvalue = " ";
	static String EMI_STRING;
	static String Lastduedate;
	static String Targetdate;
	static String Transamt;
	public static List<String> BatchList = Arrays.asList();

	public static void Date_Fetch() throws Exception {

		String currentdate = Common_Property.driver
				.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div")).getText()
				.toString();
		System.out.println(currentdate);

	}

	public static void Paymentdate_BO() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try {
			// NAVIGATION
			searchAgreement(Driver.getData("Agreement_Number"));
			Thread.sleep(1700);
			
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(2700);
			// Reschedules
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reschedules']"))
					.click();// DOCUMENT
			Thread.sleep(2750);

			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain Next Due Date']"))
					.click();
			Thread.sleep(3200);

			// PATH-CHANGE EXECUTION
			if (Driver.getData("PD_Verificationtype").equalsIgnoreCase("DateChange")) {
				Common_Property.driver.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
						.click();
				Thread.sleep(2700);

				if (Driver.getData("Due_Date_Type").equalsIgnoreCase("All due dates")) {

					Common_Property.driver
							.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
							.sendKeys(Keys.ARROW_DOWN);
					Common_Property.driver
							.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
							.sendKeys(Keys.ENTER);
				}

				else if (Driver.getData("Due_Date_Type").equalsIgnoreCase("Just The Next Due Date"))

				{
					for (int z = 0; z <= 2; z++) {
						Common_Property.driver
								.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
								.sendKeys(Keys.ARROW_DOWN);
					}
					Common_Property.driver
							.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
							.sendKeys(Keys.ENTER);
				}

				Thread.sleep(1750);
				String Str_Date = Common_Property.driver
						.findElement(By.xpath("//input[@name='DueDateWindow.DueDateView.dfMaximumBackwardsDueDate']"))
						.getAttribute("value");
				DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(formatter.parse(Str_Date));
				String First_Date_Addition_str = Driver.getData("First_Date_Addition");
				int First_Date_Addition_int = Integer.parseInt(First_Date_Addition_str);

				c.add(Calendar.DATE, First_Date_Addition_int);
				String Targetdate = formatter.format(c.getTime());
				System.out.println("The added date is " + Targetdate);

				String Targetdate1 = (Targetdate.substring(0, 2));
				System.out.println("Segricated date " + Targetdate1);
				int int_date = Integer.parseInt(Targetdate1);

				if (int_date == 29 || int_date == 30 || int_date == 31) {
					DateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					Calendar c1 = Calendar.getInstance();
					c1.setTime(formatter.parse(Str_Date));
					c1.add(Calendar.DATE, 2);
					Targetdate = formatter1.format(c1.getTime());
				}
				Common_Property.driver
						.findElement(By.xpath("//input[@name='DueDateWindow.DueDateView.dfNewNextDueDate']")).click();
				Common_Property.driver
						.findElement(By.xpath("//input[@name='DueDateWindow.DueDateView.dfNewNextDueDate']"))
						.sendKeys(Targetdate);
				Common_Property.driver.findElement(By.xpath("//div[@name='DueDateWindow.pbOK']")).click();
				Common_Property.driver.findElement(By.xpath("//div[@name='DueDateAcceptWindow.pbOK']")).click();
				Thread.sleep(1750);
				String Str_Date2 = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfNextDueDate']"))
						.getAttribute("value");

				// VP1
				if (Str_Date2.equalsIgnoreCase(Targetdate)) {

					String Desc = "The date got updated to " + Targetdate;
					Utilities.ExtentPassReport(methodname);
				} else {

					String Desc = "The date is not updated as Expected";
					Utilities.ExtentFailReport1(methodname, Desc);

				}
			}
			// PATH-CHANGE EXECUTION
			else if (Driver.getData("PD_Verificationtype").equalsIgnoreCase("Lengthcheck"))

			{
				Common_Property.driver.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
						.click();
				Thread.sleep(700);

				Common_Property.driver.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
						.sendKeys(Keys.ARROW_DOWN);
				Common_Property.driver.findElement(By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']"))
						.sendKeys(Keys.ENTER);

				// Common_Property.driver.findElement(By.xpath("//div[text()='All
				// due dates.']")).click();
				Thread.sleep(1750);

				String Str_Date = Common_Property.driver
						.findElement(By.xpath("//input[@name='DueDateWindow.DueDateView.dfMaximumBackwardsDueDate']"))
						.getAttribute("value");

				int strlen = Str_Date.length();

				// VP2
				if (strlen == 11) {
					String Desc = "The date Fortmat is Correct";
					Utilities.ExtentPassReport(methodname);
				} else {
					String Desc = "The date Fortmat is In-Correct";
					Utilities.ExtentFailReport1(methodname, Desc);

				}

			}

			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);

		}

	}

	public static void Temporary_Arrangement() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			searchAgreement(Driver.getData("Agreement_Number"));

			// TEMPORARY ARRANGEMENT NAVIGATION
			Thread.sleep(2150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements']"))
					.click();
			Thread.sleep(3050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Temporary ']"))
					.click();
			Thread.sleep(6050);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.insertBelow']"))
					.click();
			Thread.sleep(2900);
//			Common_Property.driver
//			.findElement(By
//					.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]"))
//			.click();
//			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]"))
					.click();
			Thread.sleep(2700);
			// Common_Property.driver.findElement(By.xpath("//html/body/div[15]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[1]/div[8]/input")).sendKeys("temp_arg_date");
			String Str_Date = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/div[1]/div/div/div[8]"))
					.getText();
			System.out.println(Str_Date);
			// html/body/div[10]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div[1]/div[4]
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(formatter.parse(Str_Date));
			String First_Date_Addition_str = Driver.getData("First_Date_Addition");
			int First_Date_Addition_int = Integer.parseInt(First_Date_Addition_str);

			c.add(Calendar.DATE, First_Date_Addition_int);
			String Targetdate = formatter.format(c.getTime());
			System.out.println("The added date is " + Targetdate);
			String a = Driver.getData("temp_arg_value");
			
			
			if(Str_Date.startsWith("3")){
				Common_Property.driver
				.findElement(By  //html/body/div[11]/div[3]/div[4]/div[1]
						.xpath("/html/body/div[11]/div[3]/div[4]/div[1]")).click();
			//Thread.sleep(2000);
			}
			
			Thread.sleep(2000);
			
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[6]/child::input[1]"))
					.sendKeys(a);
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//html/body/div[10]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div[1]/div[5]"))
					.click();

			Thread.sleep(2700);
			Actions action = new Actions(Common_Property.driver);
			action.moveToElement(Common_Property.driver.findElement(By
					.xpath("//html/body/div[10]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div[1]/div[5]")))
					.sendKeys("3").build().perform();
			
			Thread.sleep(6000);
			Common_Property.driver.findElement(By 
					.xpath("//div[text()='Monthly']")).click();
			Thread.sleep(4000);
			Common_Property.driver
					.findElement(By
							.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[1]/div[6]/div[2]"))
					.click();
			Thread.sleep(2000);
			String agrNo = Driver.getData("Agreement_Number");

			if (agrNo.startsWith("8")) {
				Common_Property.driver.findElement(By // html/body/div[11]/div/div[1]/div/div[4]/div
						.xpath("//html/body/div[11]/div/div[1]/div/div[4]/div")).click();
			} else {
				Common_Property.driver.findElement(By // html/body/div[11]/div/div[1]/div/div[4]/div
						.xpath("/html/body/div[11]/div/div[1]/div/div[2]/div")).click();

			}

			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']"))
					.click();
			Thread.sleep(4550);
			String b = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[3]"))
					.getText();
			Thread.sleep(2050);
			if (a.contentEquals(b)) {
				System.out.println();
				System.out.println("Temporary Arrangement Build Verifed Succefully");
				String Desc = "Temporary Arrangement Build Verifed Succefully";
				Utilities.ExtentPassReport(methodname);
			} else {
				System.out.println("Temporary Arrangement has not as Expected");
				String Desc = "Temporary Arrangement has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
				Configuration.updatePropertyFile(Methodid, MethodName, "False");
			}
			Thread.sleep(4550);
			Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.pbOK']")).click();
			Thread.sleep(3550);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(3750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}

	}

	public static void BO_Welcomepack() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Document Production']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.View Document Requests']")).click();
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestWindow.DocumentRequestView.pbFilter']")).click();
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.pbDocumentRequestName']"))
					.click();
			Common_Property.driver.findElement(By.xpath("//input[@name='DocumentSearchWindow.dfCriteriaEntry']"))
					.sendKeys(Driver.getData("Documentname")); // Welcome Pack
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentSearchWindow.pbOK']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
			Common_Property.driver.findElement(By.xpath("//div[text()='Welcome Pack']")).click();
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestWindow.DocumentRequestView.pbDetails']"))
					.click();
			String ver = Common_Property.driver
					.findElement(
							By.xpath("//input[@name='DocumentRequestDetailWindow.DocumentRequestDetailView.dfName']"))
					.getAttribute("value");
			Thread.sleep(1750);
			System.out.println(ver);
			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For the customer agreement of " + Driver.getData("Documentname")
						+ " Document has not generated";
				Utilities.ExtentFailReport1(methodname, Desc);
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
			}
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestDetailWindow.pbOK']")).click();
			Thread.sleep(3000);
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestWindow.pbCancel']")).click();

		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void BO_StopCategory() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			/*Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();
			String keypress = Driver.getData("VerificationData2");

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
					
*/			
			searchAgreement(Driver.getData("Agreement_Number"));
			String category=Driver.getData("VerificationData");
			if(category.equalsIgnoreCase("unwind")){
				bacs_Clear();
			}
			
			String keypress = Driver.getData("VerificationData2");
			Thread.sleep(3700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.pbStopCategorySearch']"))
					.click();
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='StopCategorySimpleSearchWindow.dfCriteriaEntry']")).clear();
			Thread.sleep(1500);
			System.out.println(Driver.getData("VerificationData"));
			Common_Property.driver
					.findElement(By.xpath("//input[@name='StopCategorySimpleSearchWindow.dfCriteriaEntry']"))
					.sendKeys(Driver.getData("VerificationData"));
			Thread.sleep(1500);
			Common_Property.driver.findElement(By.xpath("//div[@name='StopCategorySimpleSearchWindow.pbOK']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1550);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Save']"))
					.click();
			Thread.sleep(5000);

			if (keypress.equalsIgnoreCase("unwind")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='OK']")).click();
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
						.sendKeys(Keys.ENTER);

			}
			

			else if (keypress.equalsIgnoreCase("Bankruptcy")) {

				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(4700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
						.click();
				Thread.sleep(2700);

			}

			else if (keypress.equalsIgnoreCase("Abusive")) {
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
						.click();
				Thread.sleep(1700);

			} else if (keypress.equalsIgnoreCase("unwind")) {
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
						.click();
				Thread.sleep(1700);
			}

			else if (keypress.equalsIgnoreCase("unwind1")) {
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']"))
						.click();
				Thread.sleep(1750);
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStopCategory']"))
						.clear();
				Thread.sleep(700);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.ToolBar.Save']")).click();
				Thread.sleep(1000);

			}
			Thread.sleep(2000);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
					.getAttribute("value");
			Thread.sleep(1750);
			System.out.println(ver);

			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For the customer agreement  " + Driver.getData("Documentname")
						+ " Document has not generated";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			Thread.sleep(4550);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(3750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(3750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(4750);

		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void BO_DocumentVerification() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			searchAgreement(Driver.getData("Agreement_Number"));
			
			Thread.sleep(15000);  
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(2700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']"))
					.click();// DOCUMENT
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']")).click();
			Thread.sleep(5000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']"))
					.sendKeys(Driver.getData("Documentname"));
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
			Thread.sleep(1750);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"))
					.getText().toString();
			Thread.sleep(2750);
			System.out.println(ver);
			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For The customer agreement  " + Driver.getData("Documentname")
						+ " Document has not generated";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void documentverifcation_BO() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(2000); // MainUI.Open.Agreement Servicing
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// Maintain CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // Maintain MENU BUTTON
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']"))
					.click();// DOCUMENT
			Thread.sleep(3000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']")).click();
			Thread.sleep(4000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']"))
					.click();
			Thread.sleep(2050);
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']"))
					.sendKeys(Driver.getData("Documentname"));
			Thread.sleep(2050);
			Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
			Thread.sleep(2050);
			//
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"))
					.getText().toString();
			Thread.sleep(3050);
			System.out.println(ver);

			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For The customer agreement  " + Driver.getData("Documentname")
						+ " Document has not generated";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();
			Thread.sleep(3050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(3050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(3050);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(3050);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
            String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void BO_Address() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// NAVIGATION
			Thread.sleep(2250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(3000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(2050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();
			Thread.sleep(2150);
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']"))
					.click();
			Thread.sleep(2700);

			String Keypress = Driver.getData("VerificationData");

			if (Keypress.contentEquals("EmailAddress")) {
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfEmailAddress']"))
						.clear();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfEmailAddress']"))
						.sendKeys(Driver.getData("Documentname"));
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Save']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Close']")).click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']"))
						.click();
				Thread.sleep(700);

				String ver = Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfEmailAddress']"))
						.getAttribute("value").toString();
				Thread.sleep(1750);
				System.out.println(ver);
				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Customer's Email address has successfully updated";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "Customer's Email address has not updated";
					Utilities.ExtentFailReport1(methodname, Desc);
				}

			}
			if (Keypress.contentEquals("Address")) {
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfMobileNumber']"))
						.clear();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfMobileNumber']"))
						.sendKeys(Driver.getData("Documentname"));
				Thread.sleep(1750);
				// Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.ToolBar.Save']")).click();
				// Thread.sleep(2750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Save']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Close']")).click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']"))
						.click();
				Thread.sleep(700);

				String ver = Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfMobileNumber']"))
						.getAttribute("value").toString();
				Thread.sleep(1750);
				System.out.println(ver);
				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname")
							+ " Document has not generated";
					Utilities.ExtentFailReport1(methodname, Desc);
				}

			}

			if (Keypress.contentEquals("EditAtAddress")) {
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//div[@name='CustomerWindow.cmCombinedCorrespondenceView.pbQuickAddress']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='HabitationsSelectionWindow.pbDetails']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPropertyNumber']"))
						.clear();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPropertyNumber']"))
						.sendKeys(Driver.getData("Documentname"));
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='HabitationsDetailsWindow.pbOK']")).click();
				Thread.sleep(2750);
				Common_Property.driver.findElement(By.xpath("//div[@name='HabitationsSelectionWindow.pbOK']")).click();
				Thread.sleep(2750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Save']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(2750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Close']")).click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']"))
						.click();
				Thread.sleep(1700);

				String ver = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfPropertyNumber']"))
						.getAttribute("value").toString();
				Thread.sleep(1750);
				System.out.println(ver);
				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname")
							+ " Document has not generated";
					Utilities.ExtentFailReport1(methodname, Desc);
				}

			}

			if (Keypress.contentEquals("NewAtAddress")) {
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//div[@name='CustomerWindow.cmCombinedCorrespondenceView.pbQuickAddress']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='HabitationsSelectionWindow.pbInsert']"))
						.click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPostCode']"))
						.sendKeys(Driver.getData("Postal_Code"));
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPropertyNumber']"))
						.sendKeys(Driver.getData("Documentname"));
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfStreetName']"))
						.sendKeys(Driver.getData("Address1"));
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfDistrict']"))
						.sendKeys(Driver.getData("District"));
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPostalTown']"))
						.sendKeys(Driver.getData("Town"));
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfCounty']"))
						.sendKeys(Driver.getData("Country"));
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='HabitationsDetailsWindow.HabitationsTenancyView.dfMovingInDate']"))
						.clear();
				Thread.sleep(1750);
				String date=Driver.getData("date");
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(date));
				c.add(Calendar.DAY_OF_MONTH, 5); 
				String moved_date=sdf.format(c.getTime());
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='HabitationsDetailsWindow.HabitationsTenancyView.dfMovingInDate']"))
						.sendKeys(moved_date);
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='HabitationsDetailsWindow.pbOK']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='HabitationsSelectionWindow.pbOK']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Save']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Close']")).click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']"))
						.click();
				Thread.sleep(700);

				String ver = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfPropertyNumber']"))
						.getAttribute("value").toString();
				Thread.sleep(1750);
				System.out.println(ver);
				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname") + "has not updated";
					Utilities.ExtentFailReport1(methodname, Desc);
				}

			}
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Close']")).click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
            String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void BO_BankDetails() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.findElement(By.xpath("//input[@id='agreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			String keypress = Driver.getData("VerificationData");
			if (keypress.equalsIgnoreCase("servicing")) {
				Thread.sleep(4000);
				Common_Property.driver
						.findElement(By
								.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/a/span"))
						.click();
			} else {
				Common_Property.driver.get(
						"https://provsys.pancredit.com/panCoreSaas/app?page=Collections%2FCOBankDetails&service=page");
			}
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@name='accountNumber']")).clear();
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='accountNumber']"))
					.sendKeys(Driver.getData("Number"));
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode1']")).clear();
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode1']"))
					.sendKeys(Driver.getData("sortcode1"));
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode2']")).clear();
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode2']"))
					.sendKeys(Driver.getData("sortcode2"));
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode3']")).clear();
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//input[@name='sortCode3']")).sendKeys(Driver.getData("date"));
			Thread.sleep(800);
			Common_Property.driver.findElement(By.xpath("//a[text()='Save']")).click();
			Thread.sleep(1000);

			if (keypress.equalsIgnoreCase("servicing")) {
				Common_Property.driver
						.findElement(By
								.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/a/span"))
						.click();
			} else {
				Common_Property.driver.get(
						"https://provsys.pancredit.com/panCoreSaas/app?page=Collections%2FCOBankDetails&service=page");
			}
			Thread.sleep(1000);
			String ver = Common_Property.driver.findElement(By.xpath("//input[@name='accountNumber']"))
					.getAttribute("value").toString();

			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For The customer agreement  " + Driver.getData("Documentname") + "has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Common_Property.driver.findElement(By.xpath("//a[text()='Cancel']")).click();

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Common_Property.driver.findElement(By.xpath("//a[text()='Cancel']")).click();
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void BO_Settlement_Quote() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			searchAgreement(Driver.getData("Agreement_Number"));
			Thread.sleep(3000);
			//bacs_Clear();
			//searchAgreement(Driver.getData("Agreement_Number"));
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(2000);
			Common_Property.driver.manage().window().fullscreen();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlements']"))
					.click();// DOCUMENT
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlement Quote']")).click();
			Thread.sleep(8000);
			Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.pbBespoke']")).click();
			Thread.sleep(3000);
			Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.pbBespoke']"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(2550);
			Settlementvalue = Common_Property.driver
					.findElement(By.xpath("//input[@name='QuotationWindow.QuoteTabView.dfSettlement']"))
					.getAttribute("value");// 742.72
			Thread.sleep(2000);
			System.out.println("Value is" + Settlementvalue);
			Thread.sleep(8050); // ModifyDocumentRequestWindow.pbOK
			Common_Property.driver.findElement(By.xpath("//div[@name='ModifyDocumentRequestWindow.pbOK']")).click();
			Thread.sleep(5050);
			Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.buttons']/child::div[2]"))
					.click();
			Thread.sleep(5750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']"))
					.click();// DOCUMENT
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']")).click();
			Thread.sleep(5000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']"))
					.click();
			Thread.sleep(3750);
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']"))
					.sendKeys(Driver.getData("Documentname"));
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
			Thread.sleep(4750);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"))
					.getText().toString();
			Thread.sleep(1750);
			System.out.println(ver);
			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
				String Desc = "Expected Document has successfully generated";
				Utilities.ExtentPassReport(Desc);

			} else {
				String Desc = "Expected Document has not generated";
				Utilities.ExtentFailReport1(methodname, Desc);

			}

			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();
			Thread.sleep(4750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(2750);

		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Exce = e.toString();
			String report = "Exception " + Exce.substring(0, 87);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}

	}

	public static void BO_Logout() throws Exception {
		Thread.sleep(1750);
		Common_Property.driver.findElement(By.xpath("//div[text()='File']")).click();
		Thread.sleep(1750);
		Common_Property.driver.findElement(By.xpath("//div[text()='Exit']")).click();
		Thread.sleep(1750);
		Common_Property.driver.findElement(By.xpath("//div[text()='Yes']")).click();
		Thread.sleep(1750);
	}

	public static void SettlementCheck() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try {
			// MAINTAIN CUSTOMER AGREEMENT
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlements']"))
					.click();// DOCUMENT
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlement Quote']")).click();
			Thread.sleep(1000);
			//
			// Common_Property.driver.findElement(By.xpath("/html/body/div[10]/div[4]/div[1]")).click();
			// Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.pbBespoke']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.pbBespoke']"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(1750);
			Settlementvalue = Common_Property.driver
					.findElement(By.xpath("//input[@name='QuotationWindow.QuoteTabView.dfSettlement']"))
					.getAttribute("value");// 742.72
			Thread.sleep(1750);
			System.out.println("Value is" + Settlementvalue);

			Common_Property.driver.findElement(By.xpath("//div[@name='QuotationWindow.pbOK']")).sendKeys(Keys.ESCAPE);
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='QuotationWindow.pbOK']")).sendKeys(Keys.ENTER);
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.buttons']/child::div[2]"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void Amount() throws Exception {
		// MAINTAIN CUSTOMER AGREEMENT
		WebElement source = Common_Property.driver
				.findElement(By.xpath("//div[@tabindex='1']//div[text()='Create Cash Batch']"));
		WebElement dest = Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Cash and Posting']"));
		Actions action = new Actions(Common_Property.driver);
		action.dragAndDrop(source, dest).build().perform();
		Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(700);
		Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
		Thread.sleep(1750);
		Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']")).click();
		Common_Property.driver
				.findElement(By
						.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
				.sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(1700);
		Common_Property.driver
				.findElement(By
						.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
				.click();
		Thread.sleep(4800);
		Common_Property.driver
				.findElement(By
						.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
				.click();
		Thread.sleep(1700);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.pbTransactions']"))
				.click();
		Thread.sleep(700);
		Transamt = Common_Property.driver
				.findElement(By.xpath("//input[@name='ViewTransactionsWindow.TransactionBalanceView.dfAmountPaid']"))
				.getAttribute("value");
		Thread.sleep(700);

		// ViewTransactionsWindow.TransactionBalanceView.dfAmountPaid
		Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();
		Thread.sleep(2050);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
		Thread.sleep(1750);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
				.click();
		Thread.sleep(1750);
		Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
				.click();
		Thread.sleep(1750);
		WebElement dest1 = Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Audit']"));
		Thread.sleep(3050);
		action.dragAndDrop(source, dest1).build().perform();

	}

	public static void BO_cashposting() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// NAVIGATION
			Thread.sleep(250);
			if (Driver.getData("EMI_RETREVAL").equalsIgnoreCase("Yes")) {

				System.out.println(Settlementvalue);
				// NAVIGATION
				searchAgreement(Driver.getData("Agreement_Number"));
				Thread.sleep(2000);
				String keypress = Driver.getData("VerificationData");
				if(keypress.equalsIgnoreCase("PAY")){
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.View']"))
						.click();
				Thread.sleep(1250);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Schedules']"))
						.click();
				Thread.sleep(1250);
				EMI_STRING = Common_Property.driver
						.findElement(By
								.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']/div/div/div/div[2]"))
						.getText().toString();
				Common_Property.driver.findElement(By.xpath("//div[@name='ViewSchedulesWindow.pbCancel']")).click();
				Thread.sleep(1250);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']"))
						.click();
				Thread.sleep(1050);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
						.click();
				Thread.sleep(1250);
				Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
						.click();
				Thread.sleep(1250);
				}

			}
			// settlement quote amount

			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash and Posting']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Transactions']")).click();
			Thread.sleep(1050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Posting']")).click();
			Thread.sleep(1550); // input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1550);
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='CashPostingWindow.CashBatchDetailsView.dlDefaultPaymentMethod']"))
					.click();
			Common_Property.driver.findElement(By.xpath("//div[text()='Cash']")).click();
			Thread.sleep(2050);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']"))
					.click();
			Thread.sleep(4500);
			boolean present = isAlertPresent();
			if (present == true) // html/body/div[8]/div[4]/div
			{ // html/body/div[8]/div[4]/div
				Common_Property.driver.findElement(By.xpath("//div/div[4]/div[@tabindex='2']")).click();
				Thread.sleep(1500);
			}

			String keypress = Driver.getData("VerificationData");
			System.out.println("Data should be" + keypress);
			
			if (keypress.equalsIgnoreCase("PAY")) {
				if(Driver.getData("PD_Verificationtype").contains("Yes")){
					
						
						Common_Property.driver
								.findElement(
										By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
								.click();
						Thread.sleep(3000);
						Common_Property.driver
								.findElement(
										By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
								.sendKeys(Driver.getData("Agreement_Number"));
						Thread.sleep(3700);
						Common_Property.driver
								.findElement(
										By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
								.click();
						Thread.sleep(1750);
						Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
						
						Thread.sleep(1750);
						Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys("10.00");
						Thread.sleep(3750);
//						Common_Property.driver
//								.findElement(
//										By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
//								.sendKeys(Keys.F11);
						//Common_Property.driver.manage().window().fullscreen();
						System.out.println("Payment");
						boolean element2 = isAlertPresent();
						if (element2 == true) {
							Thread.sleep(2000);
							Common_Property.driver.findElement(By.xpath("//div[text()='OK']")).click();
						}

						boolean element3 = isAlertPresent();
						if (element3 == true) {
							Thread.sleep(2000);
							Common_Property.driver.findElement(By.xpath("//div[text()='OK']")).click();
						}
						Common_Property.driver
								.findElement(By
										.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
								.click();
						
					}
				else{
				
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(3000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(3700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(3750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.sendKeys(Keys.F11);
				Common_Property.driver.manage().window().fullscreen();
				System.out.println("Payment");
				boolean element2 = isAlertPresent();
				if (element2 == true) {
					Thread.sleep(2000);
					Common_Property.driver.findElement(By.xpath("//div[@tabindex='2']/div[text()='OK']")).click();
				}

				boolean element3 = isAlertPresent();
				if (element3 == true) {
					Thread.sleep(2000);
					Common_Property.driver.findElement(By.xpath("//div[@tabindex='2']/div[text()='OK']")).click();
				}
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
			} 
		}
			else if (keypress.equalsIgnoreCase("BRT")) {
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata1"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbBACSFailCodeLoV']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='BACSFailCodeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata2"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='BACSFailCodeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);

			} else if (keypress.equalsIgnoreCase("SET")) {

				/*WebElement source = Common_Property.driver
						.findElement(By.xpath("//div[@tabindex='1']//div[text()='Create Cash Batch']"));
				WebElement dest = Common_Property.driver
						.findElement(By.xpath("//div[@name='MainUI.Cash and Posting']"));
				Actions action = new Actions(Common_Property.driver);
				action.dragAndDrop(source, dest).build().perform();
				BO_Settlement_Quote();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				WebElement dest1 = Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Audit']"));
				action.dragAndDrop(source, dest1).build().perform();
				Common_Property.driver.manage().window().fullscreen();*/
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(3000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				System.out.println("Settlement");
				Thread.sleep(3700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(4000);
				if(Driver.getData("Reshedule_Date").equalsIgnoreCase("Reverse_settlement")){
					int value=Integer.parseInt(Settlementvalue);
					int settlement=value-3;
					Settlementvalue=Integer.toString(settlement);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				}
				else{
					Common_Property.driver
					.findElement(
							By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
					.sendKeys(Settlementvalue);
				}
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(2700);

				boolean present1 = isAlertPresent();
				if (present1 == true) {
					Common_Property.driver.findElement(By.xpath("//div[@tabindex='2']//div[text()='OK']")).click();
				}
				Thread.sleep(1700);
				boolean present2 = isAlertPresent1();
				if (present2 == true) {
					Common_Property.driver.findElement(By.xpath("//div[@tabindex='2']//div[text()='OK']")).click();
				}
			} else if (keypress.equalsIgnoreCase("RET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver.manage().window().fullscreen();
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata1"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);

			} else if (keypress.equalsIgnoreCase("REVSET")) {

				searchAgreement(Driver.getData("Agreement_Number"));
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
				.click(); // MAINTAIN MENU BUTTON
				Thread.sleep(2000);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(2000);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reverse Early Settlement']"))
						.click();
				Thread.sleep(2000);
				Common_Property.driver.findElement(By.xpath("//div[text()='Reverse']"))
				.click();
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("VerificationData3"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Transamt);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("REV")) {

				Thread.sleep(2000);
				Common_Property.driver.manage().window().fullscreen();
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);

				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("CPA_REV")) {
				// Common_Property.driver.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']")).click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(EMI_STRING);
				Thread.sleep(3700);

				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver.manage().window().fullscreen();
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys("REV");
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(EMI_STRING);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			}

			Thread.sleep(1750);
			String Click = Driver.getData("VerificationData");
			System.out.println("Data should be" + keypress);
			if (Click.equalsIgnoreCase("PAY") && Driver.getData("PD_Verificationtype").contains("Yes")) {
				
				boolean element4 = isAlertPresent4();
				if (element4 == true ){
					Thread.sleep(2000);
					Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[4]/div/div")).click();
					Thread.sleep(1000);
				}
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
			}
			else if(Click.equalsIgnoreCase("PAY")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
				// System.out.println("Payment");
			}
			
			else if (Click.equalsIgnoreCase("BRT")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Unpaid BACS']")).click();
				System.out.println("Unpaid BACS");
			} else if (Click.equalsIgnoreCase("SET")) {

				Common_Property.driver.findElement(By.xpath("//div[@tabindex='31']/div/div[1]/div[1]")).click();
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//div[@tabindex='31']/div/div[1]/div[1]/div[text()='Settlement']"))
						.click();
				System.out.println("Settlement");
			} else if (Click.equalsIgnoreCase("RET")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Returned SET']")).click();
				System.out.println("Settlement");
			} else if (Click.equalsIgnoreCase("PayArrearAmt")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
				System.out.println("Payment");
			} else if (Click.equalsIgnoreCase("REVSET")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Reversal']")).click();
				System.out.println("Reverse");
			} else if (keypress.equalsIgnoreCase("REV")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Reversal']")).click();
				System.out.println("Reverse");
			}
			
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.click();
			String BatchTotal = Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.getAttribute("value");
			System.out.println(BatchTotal);
			Thread.sleep(1700);
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.clear();
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.sendKeys(BatchTotal);
			Thread.sleep(1700);
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.buttons']//child::div[2]/child::div[1]"))
					.click();
			Thread.sleep(1700);
			Thread.sleep(15750);
			// NAVIGATION
			Thread.sleep(1250);
			Common_Property.waitUntill(POM_Repository.BO_Open);
			Common_Property.driver.findElement(POM_Repository.BO_Open).click();	
			Common_Property.waitUntillEnabled(POM_Repository.BO_Elm_AgrServicing);
			Common_Property.driver.findElement(POM_Repository.BO_Elm_AgrServicing).click();
			Common_Property.waitUntillEnabled(POM_Repository.BO_MaintainCustAgr);
			Common_Property.driver.findElement(POM_Repository.BO_MaintainCustAgr).click();
			//MAINTAIN CUSTOMER AGREEMENT
			By agr_edit =By.name("FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber");
			Common_Property.waitUntill(agr_edit);
			Common_Property.driver.findElement(agr_edit).click();
			Common_Property.driver.findElement(agr_edit).sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1000);
			//Common_Property.waitUntillEnabled("//html/body/div[9]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div/div");
			Common_Property.driver.findElement(By.name("FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind")).click();
			Thread.sleep(1000);                          //html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div
			Common_Property.driver
			.findElement(By
					.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
			.click();
			Thread.sleep(6000);
			//searchAgreement(Driver.getData("Agreement_Number"));
			Thread.sleep(2700);
			String status = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
					.getAttribute("value");

			String ver = "";
			String Validation = Driver.getData("Status");

			if (Validation.equalsIgnoreCase(status)) {
				//
				ver = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
						.getAttribute("value");
				Thread.sleep(1750);
				System.out.println("1" + ver + "1");
				System.out.println("1" + Driver.getData("Documentname") + "1");

				if (status.contentEquals(Driver.getData("Status"))) {

					String Desc = "Agreement has Successfully settled and showing the status as expected";
					Utilities.ExtentPassReport(Desc);

				} else {

					String Desc = "Agreement has not done settlement";
					Utilities.ExtentFailReport1(methodname, Desc);

				}
			} else { // ViewTransactionsWindow.TransactionBalanceView.dfAmountPaid
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.pbTransactions']")).click();
				Thread.sleep(700);

				Common_Property.driver
						.findElement(
								By.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.pbFilter']"))
						.click();
				Thread.sleep(700);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfTransactionType']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				String currentdate1 = Common_Property.driver
						.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"))
						.getText().toString();
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']"))
						.sendKeys(currentdate1);
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']"))
						.sendKeys(currentdate1);
				Thread.sleep(3700);
				Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsFilterWindow.pbOK']"))
						.click();
				Thread.sleep(5750);

				Thread.sleep(2750);
				ver = Common_Property.driver
						.findElement(By
								.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.ofViewTransactionsPreUpdateOutlineField']/child::div[1]/child::div[1]/child::div[1]/child::div[2]"))
						.getText().toString();
				Thread.sleep(2750);
				
				
				if (ver.contentEquals(Driver.getData("VerificationData"))) {

					String Desc = "Agreement has posted the payment as Settlement as expected";
					Utilities.ExtentPassReport(Desc);
					Thread.sleep(200);
					Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();

				} else {

					String Desc = "Agreement has not posted the payment as Settlement as expected";
					Utilities.ExtentFailReport1(methodname, Desc);
					Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();
				}
			}
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			//Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					//.click();
			Thread.sleep(1750);
		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void BO_cashpostingC1() throws IOException, InterruptedException, FilloException

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// NAVIGATION
			Thread.sleep(250);
			if (Driver.getData("EMI_RETREVAL").equalsIgnoreCase("Yes")) {
				Thread.sleep(250);
				PaymentAmt();
				System.out.println(Settlementvalue);
			}
			// settlement quote amount

			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash and Posting']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Transactions']")).click();
			Thread.sleep(1050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Posting']")).click();
			Thread.sleep(1550);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='CashPostingWindow.CashBatchDetailsView.dlDefaultPaymentMethod']"))
					.click();
			Common_Property.driver.findElement(By.xpath("//div[text()='Cash']")).click();
			Thread.sleep(2050);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']"))
					.click();
			Thread.sleep(1500);
			boolean present = isAlertPresent();

			if (present == true) {
				Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[4]/div")).click();
				Thread.sleep(1500);
			}

			if (Driver.getData("EMI_RETREVAL").equalsIgnoreCase("Yes")) {
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(EMI_STRING);
				Thread.sleep(3700);
			}

			String keypress = Driver.getData("VerificationData");
			System.out.println("Data should be" + keypress);
			if (keypress.equalsIgnoreCase("PAY")) {
				// Common_Property.driver.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']")).click();
				// Thread.sleep(1000);
				// Common_Property.driver.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']")).sendKeys(Driver.getData("Agreement_Number"));
				// Thread.sleep(1700);
				// Common_Property.driver.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']")).click();
				// Thread.sleep(2750);

				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
			} else if (keypress.equalsIgnoreCase("BRT")) {
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata1"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbBACSFailCodeLoV']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='BACSFailCodeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata2"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='BACSFailCodeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);

			} else if (keypress.equalsIgnoreCase("SET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				System.out.println("Settlement");
				Thread.sleep(3700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(4000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(2700);
			} else if (keypress.equalsIgnoreCase("RET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata1"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("REVSET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("REV")) {
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("CPA_REV")) {
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys("REV");
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(EMI_STRING);
				Thread.sleep(1700);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			}

			Thread.sleep(1750);
			String Click = Driver.getData("VerificationData");
			System.out.println("Data should be" + keypress);
			if (Click.equalsIgnoreCase("PAY")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
				System.out.println("Payment");
			} else if (Click.equalsIgnoreCase("BRT")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Unpaid BACS']")).click();
				System.out.println("Unpaid BACS");
			} else if (Click.equalsIgnoreCase("SET")) {
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[text()='Settlement']")).click();
				System.out.println("Settlement");
			} else if (Click.equalsIgnoreCase("RET")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Returned SET']")).click();
				System.out.println("Settlement");
			} else if (Click.equalsIgnoreCase("PayArrearAmt")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
				System.out.println("Payment");
			} else if (Click.equalsIgnoreCase("REVSET")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Reversal']")).click();
				System.out.println("Reverse");
			} else if (keypress.equalsIgnoreCase("REV")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Reversal']")).click();
				System.out.println("Reverse");
			}
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.click();
			String BatchTotal = Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.getAttribute("value");
			System.out.println(BatchTotal);
			Thread.sleep(1700);
			Thread.sleep(2750);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.clear();
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.sendKeys(BatchTotal);
			Thread.sleep(2700);
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.buttons']//child::div[2]/child::div[1]"))
					.click();
			Thread.sleep(1700);
			Thread.sleep(1750);
			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();
			// MAINTAIN CUSTOMER AGREEMENT
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			String ver = "";
			String Validation = Driver.getData("VerificationData");

			if (Validation.equalsIgnoreCase("Status")) {
				ver = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
						.getAttribute("value");
				Thread.sleep(1750);
				System.out.println("1" + ver + "1");
				System.out.println("1" + Driver.getData("Documentname") + "1");
				if (ver.contentEquals(Driver.getData("Documentname"))) {
					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {
					String Desc = "For The customer agreement  " + Driver.getData("Documentname")
							+ " has not as Expected";
					Utilities.ExtentFailReport1(methodname, Desc);
				}
			} else {
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.pbTransactions']")).click();
				Thread.sleep(700);
				Common_Property.driver
						.findElement(
								By.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.pbFilter']"))
						.click();
				Thread.sleep(700);
				// Common_Property.driver.findElement(By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']")).sendKeys(Firstinstaldate);
				// Thread.sleep(700);
				// Common_Property.driver.findElement(By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']")).sendKeys(Firstinstaldate);
				// Thread.sleep(700);
				// Common_Property.driver.findElement(By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfTransactionType']")).sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				String currentdate1 = Common_Property.driver
						.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"))
						.getText().toString();
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']"))
						.sendKeys(currentdate1);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']"))
						.sendKeys(currentdate1);
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsFilterWindow.pbOK']"))
						.click();
				Thread.sleep(1750);
				Thread.sleep(1750);
				ver = Common_Property.driver
						.findElement(By
								.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.ofViewTransactionsPreUpdateOutlineField']/child::div[1]/child::div[1]/child::div[1]/child::div[2]"))
						.getText().toString();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();
				Thread.sleep(700);
				// String amt=Driver.getData("Documentname");
				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					System.out.println(Desc);
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname")
							+ " has not as Expected";
					Utilities.ExtentFailReport1(methodname, Desc);
				}
			}
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
            String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void BO_cashpostingC() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// NAVIGATION
			Thread.sleep(250);
			if (Driver.getData("EMI_RETREVAL").equalsIgnoreCase("Yes")) {
				Thread.sleep(250);
				PaymentAmt();
				System.out.println(Settlementvalue);
			}
			// settlement quote amount

			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash and Posting']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Transactions']")).click();
			Thread.sleep(1050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Posting']")).click();
			Thread.sleep(1550);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='CashPostingWindow.CashBatchDetailsView.dlDefaultPaymentMethod']"))
					.click();
			Common_Property.driver.findElement(By.xpath("//div[text()='Cash']")).click();
			Thread.sleep(2050);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']"))
					.click();
			Thread.sleep(1500);
			boolean present = isAlertPresent();
			if (present == true) {
				Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[4]/div")).click();
				Thread.sleep(1500);
			}
			if (Driver.getData("EMI_RETREVAL").equalsIgnoreCase("Yes")) {
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(EMI_STRING);
				Thread.sleep(3700);
			}
			// END

			String keypress = Driver.getData("VerificationData");
			System.out.println("Data should be" + keypress);
			if (keypress.equalsIgnoreCase("PAY")) {
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);

				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
			} else if (keypress.equalsIgnoreCase("BRT")) {
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata1"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbBACSFailCodeLoV']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='BACSFailCodeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata2"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='BACSFailCodeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);

			} else if (keypress.equalsIgnoreCase("SET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				System.out.println("Settlement");
				Thread.sleep(3700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(4000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.click();
				Thread.sleep(2700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(2700);
			} else if (keypress.equalsIgnoreCase("RET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("Testdata1"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("REVSET")) {
				SettlementCheck();
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(Settlementvalue);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("REV")) {
				// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
						.click();
				Thread.sleep(2750);
				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			} else if (keypress.equalsIgnoreCase("CPA_REV")) {
				Thread.sleep(2000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
						.sendKeys(Driver.getData("Agreement_Number"));
				Thread.sleep(1700);
				// Common_Property.driver.findElement(By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]")).sendKeys("cc");
				System.out.println("Payment");
				Common_Property.driver
						.findElement(By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']"))
						.sendKeys("REV");
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']"))
						.click();
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.clear();
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(
								By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
						.sendKeys(EMI_STRING);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.click();
				Thread.sleep(1700);
			}
			Thread.sleep(1750);
			String Click = Driver.getData("VerificationData");
			System.out.println("Data should be" + keypress);
			if (Click.equalsIgnoreCase("PAY")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
				System.out.println("Payment");
			} else if (Click.equalsIgnoreCase("BRT")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Unpaid BACS']")).click();
				System.out.println("Unpaid BACS");
			} else if (Click.equalsIgnoreCase("SET")) {
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
						.sendKeys(Keys.ENTER);
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[text()='Settlement']")).click();
				System.out.println("Settlement");
			} else if (Click.equalsIgnoreCase("RET")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Returned SET']")).click();
				System.out.println("Settlement");
			} else if (Click.equalsIgnoreCase("PayArrearAmt")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
				System.out.println("Payment");
			} else if (Click.equalsIgnoreCase("REVSET")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Reversal']")).click();
				System.out.println("Reverse");
			} else if (keypress.equalsIgnoreCase("REV")) {
				Common_Property.driver.findElement(By.xpath("//div[text()='Reversal']")).click();
				System.out.println("Reverse");
			}
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.click();
			String BatchTotal = Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.getAttribute("value");
			System.out.println(BatchTotal);
			Thread.sleep(1700);
			Thread.sleep(2750);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.clear();
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.sendKeys(BatchTotal);
			Thread.sleep(2700);
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.buttons']//child::div[2]/child::div[1]"))
					.click();
			Thread.sleep(1700);
			// CashPostingWindow.buttons
			// value[1] =
			// driver.findElement(By.xpath("//div[@name='CashPostingWindow.pbBespoke']")).getText().toString();
			// String
			// str1=driver.findElement(By.xpath("//div[@name='CashPostingWindow.pbBespoke']//child::div[1]/child::div[1]")).getAttribute("value");
			// System.out.println(value[1]);
			// Thread.sleep(700);
			Thread.sleep(1750);
			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();
			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			String ver = "";
			String Validation = Driver.getData("VerificationData");

			if (Validation.equalsIgnoreCase("Status")) {
				//
				ver = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
						.getAttribute("value");
				Thread.sleep(1750);
				System.out.println("1" + ver + "1");
				System.out.println("1" + Driver.getData("Documentname") + "1");

				if (ver.contentEquals(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname")
							+ " has not as Expected";
					Utilities.ExtentFailReport1(methodname, Desc);
				}
			} else {
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.pbTransactions']")).click();
				Thread.sleep(700);
				Common_Property.driver
						.findElement(
								By.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.pbFilter']"))
						.click();
				Thread.sleep(700);
				// Common_Property.driver.findElement(By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']")).sendKeys(Firstinstaldate);
				// Thread.sleep(700);
				// Common_Property.driver.findElement(By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']")).sendKeys(Firstinstaldate);
				// Thread.sleep(700);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfTransactionType']"))
						.sendKeys(Driver.getData("VerificationData"));
				Thread.sleep(1700);
				String currentdate1 = Common_Property.driver
						.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"))
						.getText().toString();
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']"))
						.sendKeys(currentdate1);
				Thread.sleep(1700);
				Common_Property.driver
						.findElement(By
								.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']"))
						.sendKeys(currentdate1);
				Thread.sleep(1700);
				Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsFilterWindow.pbOK']"))
						.click();
				Thread.sleep(1750);
				Thread.sleep(1750);
				ver = Common_Property.driver
						.findElement(By
								.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.ofViewTransactionsPreUpdateOutlineField']/child::div[1]/child::div[1]/child::div[1]/child::div[2]"))
						.getText().toString();
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();
				Thread.sleep(700);
				// String amt=Driver.getData("Documentname");
				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					System.out.println(Desc);
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname")
							+ " has not as Expected";
					Utilities.ExtentFailReport1(methodname, Desc);
				}
			}
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void PaymentAmt() throws Exception {
		// NAVIGATION
		Thread.sleep(1250);
		Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
		Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']")).click();
		// MAINTAIN CUSTOMER AGREEMENT
		Common_Property.driver
				.findElement(By
						.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
				.sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(550);
		Common_Property.driver
				.findElement(By
						.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
				.click();
		Thread.sleep(550);
		Common_Property.driver
				.findElement(By
						.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
				.click();
		Thread.sleep(5250);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.View']")).click();
		Thread.sleep(250);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Schedules']")).click();
		Thread.sleep(250);
		EMI_STRING = Common_Property.driver
				.findElement(By
						.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']/div/div/div/div[2]"))
				.getText().toString();
		Common_Property.driver.findElement(By.xpath("//div[@name='ViewSchedulesWindow.pbCancel']")).click();
		Thread.sleep(1250);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
		Thread.sleep(1050);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
				.click();
		Thread.sleep(1250);
		Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
				.click();
		Thread.sleep(2250);
	}

	public static void BO_Reshedule() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			Thread.sleep(1750);
			Actions axn = new Actions(Common_Property.driver);

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			//bacs_Clear();

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(2700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reschedules']"))
					.click();
			Thread.sleep(8000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reschedule Quote']")).click();
			Thread.sleep(4000);
			Common_Property.driver.findElement(By.xpath("//div[@name='RescheduleSelectComponentsWindow.pbBespoke']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.insertBelow']"))
					.click();
			Common_Property.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Thread.sleep(1550);
			WebElement Number = Common_Property.driver.findElement(By.xpath(
					"//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[4]"));
			Number.click();
			Thread.sleep(1200);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[5]/input[1]"))
					.sendKeys(Driver.getData("Reshedule_NumPay"));
			Thread.sleep(2200);
			WebElement Number1 = Common_Property.driver.findElement(By.xpath(
					"//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"));
			Number1.click();
			Thread.sleep(1500);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[6]/child::div[1]/input[1]"))
					.sendKeys(Driver.getData("Reshedule_Frequency"));
			Thread.sleep(1500);
			WebElement Number3 = Common_Property.driver.findElement(By.xpath(
					"//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[7]"));
			Number3.click();
			Thread.sleep(6200);
			String a = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[8]/input[1]"))
					.getAttribute("value").toString();
			Thread.sleep(5000);
			WebElement web = Common_Property.driver.findElement(By.xpath(
					"//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]"));
			web.click();			
			Thread.sleep(200);
			Thread.sleep(1200);
			axn.contextClick(web).build().perform();
			Thread.sleep(1500);
			Common_Property.driver.findElement(By.xpath("//div[@name='SolvableGuiContextMenu.Solve']")).click();
			Thread.sleep(2550);

			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='RescheduleQuoteWindow.pbBespoke']/child::div[text()='Calculate']"))
					.click();
			Thread.sleep(4000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='RescheduleQuoteWindow.pbBespoke']/child::div[text()='Accept']"))
					.click();
			Thread.sleep(2050);
			Common_Property.driver.findElement(By.xpath("//div[@name='RescheduleAcceptWindow.pbOK']")).click();
			Thread.sleep(4050);
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='RescheduleQuoteWindow.pbBespoke']/child::div[text()='Take Up']"))
					.click();
			Thread.sleep(2900);
			Utilities.ExtentPassReport("Reschedule has taken-up successfully");
			Common_Property.driver.findElement(By.xpath("//div[text()='OK']")).click();
			Thread.sleep(5500);
			Common_Property.driver.findElement(By.xpath("//div[@name='RescheduleSelectComponentsWindow.pbCancel']"))
					.click();
			// String ver
			// =Common_Property.driver.findElement(By.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']")).getAttribute("value");
			Thread.sleep(3500);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfNextDueDate']"))
					.getAttribute("value");
			Thread.sleep(2750);
			String val = "Expected is " + ver + " actual is " + a;
			if (ver.contentEquals(a)) {
				String Desc = "Agreement has successfully created the reschedule Quote";
				Utilities.ExtentPassReport(Desc);

			} else {
				String Desc = "Agreement has not created the reschedule Quote";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Thread.sleep(3750);

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of " + methodname + " was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void BO_Refund() throws Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try {

			Thread.sleep(2050);
			searchAgreement(Driver.getData("Agreement_Number"));
			Thread.sleep(3050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.View']")).click();
			Thread.sleep(3050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Schedules']"))
					.click();
			Thread.sleep(2050);
			EMI_STRING = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']/div/div/div/div[2]"))
					.getText().toString();
			float EMI_NUMBER = Float.parseFloat(EMI_STRING);
			EMI_NUMBER = EMI_NUMBER + 20;
			EMI_STRING = "" + EMI_NUMBER;
			Common_Property.driver.findElement(By.xpath("//div[@name='ViewSchedulesWindow.pbCancel']")).click();
			Thread.sleep(1250);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1250);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1250);
			// Payment
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash and Posting']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Transactions']")).click();
			Thread.sleep(1050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Posting']")).click();
			Thread.sleep(1550); // input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1550);
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='CashPostingWindow.CashBatchDetailsView.dlDefaultPaymentMethod']"))
					.click();
			Common_Property.driver.findElement(By.xpath("//div[text()='Cash']")).click();
			Thread.sleep(2050);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']"))
					.click();
			Thread.sleep(4500);

			boolean present = isAlertPresent();
			if (present == true) // html/body/div[8]/div[4]/div
			{ // html/body/div[8]/div[4]/div
				Common_Property.driver.findElement(By.xpath("//div/div[4]/div[@tabindex='2']")).click();
				Thread.sleep(1500);
			}
			Thread.sleep(4500);      
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
					.click();
			Thread.sleep(2750);

			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
					.clear();
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
					.sendKeys(EMI_STRING);
			Thread.sleep(3700);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
					.sendKeys(Keys.F11);
			//Common_Property.driver.manage().window().fullscreen();
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
					.click();
			Thread.sleep(3700);
			boolean element = isAlertPresent();
			if (element == true) {
				Common_Property.driver
						.findElement(By
								.xpath("//div[@tabindex='1']/following::div[text()='Warning']/following::div[text()='OK']"))
						.click();
			}
			boolean element1 = isAlertPresent();
			if (element1 == true) {
				Thread.sleep(3000);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@tabindex='1']/following::div[text()='Warning']/following::div[text()='OK']"))
						.click();
			}
			Thread.sleep(3000);
			Common_Property.driver.findElement(By.xpath("//div[text()='Payment']")).click();
			System.out.println("Payment");
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.click();
			Thread.sleep(1700);
			String BatchTotal = Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
					.getAttribute("value");
			System.out.println(BatchTotal);
			Thread.sleep(2000);
			// Thread.sleep(1750);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.clear();
			Common_Property.driver
					.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
					.sendKeys(BatchTotal);
			// Thread.sleep(1700);
			Thread.sleep(2000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='CashPostingWindow.buttons']//child::div[2]/child::div[1]"))
					.click();
			Thread.sleep(4000);
			searchAgreement(Driver.getData("Agreement_Number"));
			Thread.sleep(1250);
			//bacs_Clear();
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click();
			Thread.sleep(1250);
			//bacs_Clear();
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Refund']"))
					.click();
			Thread.sleep(2250);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='RefundRequestSearchWindow.RefundRequestSearchView.pbInsert']"))
					.click();
			Thread.sleep(2250);
			// Common_Property.driver.findElement(By.xpath("//html/body/div[13]/div[4]/div")).sendKeys(Keys.ENTER);
			Thread.sleep(250);
			Common_Property.driver
					.findElement(By.xpath("//input[@name='AddRefundRequestWindow.AddRefundRequestView.dfAmount']"))
					.clear();
			Common_Property.driver
					.findElement(By.xpath("//input[@name='AddRefundRequestWindow.AddRefundRequestView.dfAmount']"))
					.sendKeys("10");
			Thread.sleep(1250);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='AddRefundRequestWindow.AddRefundRequestView.dlPaymentMethod']/following-sibling::div[2]/div/div"))
					.click();
			Thread.sleep(2250);
			// Common_Property.driver.findElement(By.xpath("//div[text()='Over
			// Payment']")).click();
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='AddRefundRequestWindow.AddRefundRequestView.dlPaymentMethod']/following-sibling::div[2]/div/input"))
					.sendKeys("Over Payment");
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[@name='AddRefundRequestWindow.pbBespoke']")).click();
			Thread.sleep(2050);
			Common_Property.driver.findElement(By.xpath("//div[@name='AddRefundRequestWindow.pbBespoke']"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(250);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='RefundRequestSearchWindow.RefundRequestSearchView.gfOuter']/div/div/div/div[1]/div[3]"))
					.getText().toString();
			System.out.println(ver);
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//div[@name='RefundRequestSearchWindow.buttons']"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// Common_Property.driver.findElement(By.xpath("//html/body/div[13]/div[4]/div")).sendKeys(Keys.ENTER);

			if (ver.equalsIgnoreCase("20.00")) {
				String Desc = "Agreement Refunded successfully";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "Agreement has not Refunded successfully";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static void BO_CheckFinalDate() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(1750);

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			Lastduedate = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.getAttribute("value").toString();
			Thread.sleep(1700);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
					.getAttribute("value");

			if (ver.contentEquals(Lastduedate)) {
				String Desc = "Successfully  " + Lastduedate + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For The customer agreement  " + Lastduedate + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}

	}

	public static void BO_GetFinalDate() throws IOException, InterruptedException // AXC-REGR-190
			, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Thread.sleep(1750);

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			Lastduedate = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfEndDate']"))
					.getAttribute("value").toString();
			Thread.sleep(1700);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
					.getAttribute("value");

			if (ver.contentEquals("Completed, Term")) {
				String Desc = "Successfully  " + Lastduedate + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "For The customer agreement  " + Lastduedate + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
			// Completed, Term

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void BO_CheckWriteoff() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();
			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			if (Driver.getData("VerificationData").equals("WRT")) {
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
						.click(); // MAINTAIN MENU BUTTON
				Thread.sleep(700);
				Common_Property.driver.manage().window().fullscreen();
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Write-offs']"))
						.click();
				Thread.sleep(700);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Initial Write-off']"))
						.click();
				Thread.sleep(700);
				Thread.sleep(1750);
				// driver.findElement(By.xpath("//div[text()='Warning']")).click();
				// driver.findElement(By.xpath("//div[text()='OK']")).click();
				// driver.findElement(By.xpath("//div[@style='position:
				// absolute; overflow: hidden; white-space: nowrap;
				// text-decoration: inherit; left: 43px; width: 17px; top: 3px;
				// height: 17px;']")).click();
				String Initialwriteamt = Common_Property.driver
						.findElement(
								By.xpath("//input[@name='InitialWriteOffWindow.InitialWriteOffView.dfWriteOffAmount']"))
						.getAttribute("value");
				System.out.println("Initial writeoff amt" + Initialwriteamt);
				Thread.sleep(700);
				Thread.sleep(1750);
				String Balance = Common_Property.driver
						.findElement(By.xpath("//input[@name='InitialWriteOffWindow.InitialWriteOffView.dfBalance']"))
						.getAttribute("value");
				System.out.println("Iniital writeoff balance" + Balance);
				Thread.sleep(700);
				Thread.sleep(1750);
				// String[] value =new String[10];
				// value[1] =
				// driver.findElement(By.xpath("//div[@name='InitialWriteOffWindow.buttons']")).getText().toString();
				// System.out.println(value[1]);
				Common_Property.driver
						.findElement(
								By.xpath("//div[@name='InitialWriteOffWindow.buttons']//child::div[1]/child::div[1]"))
						.click();
				Thread.sleep(700);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@style='position: absolute; overflow: hidden; white-space: nowrap; text-decoration: inherit; left: 43px; width: 17px; top: 3px; height: 17px;']"))
						.click();
				Thread.sleep(700);
				Thread.sleep(1750);
				System.out.println("Initial write off finished");

			}

			if (Driver.getData("VerificationData").equals("Recoveries")) {
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
						.click(); // MAINTAIN MENU BUTTON
				Thread.sleep(1750);
				Common_Property.driver.manage().window().fullscreen();
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Write-offs']"))
						.click();
				Thread.sleep(1750);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Transfer To Recoveries']"))
						.click();
				Thread.sleep(1750);
				Thread.sleep(1750);
				// driver.findElement(By.xpath("//div[text()='Warning']")).click();
				// driver.findElement(By.xpath("//div[text()='OK']")).click();
				// driver.findElement(By.xpath("//div[@style='position:
				// absolute; overflow: hidden; white-space: nowrap;
				// text-decoration: inherit; left: 43px; width: 17px; top: 3px;
				// height: 17px;']")).click();
				String Recoverieswriteamt = Common_Property.driver
						.findElement(By
								.xpath("//input[@name='TransferToRecoveriesWindow.TransferToRecoveriesView.dfWriteOffAmount']"))
						.getAttribute("value");
				System.out.println(Recoverieswriteamt);
				Thread.sleep(700);
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='TransferToRecoveriesWindow.pbBespoke']"))
						.click();
				Thread.sleep(700);
				Thread.sleep(1750);
				// String[] value =new String[10];
				// value[1] =
				// driver.findElement(By.xpath("//div[@name='InitialWriteOffWindow.buttons']")).getText().toString();
				// System.out.println(value[1]);
				// driver.findElement(By.xpath("//div[@name='InitialWriteOffWindow.buttons']//child::div[1]/child::div[1]")).click();
				Common_Property.driver
						.findElement(By
								.xpath("//div[@style='position: absolute; overflow: hidden; white-space: nowrap; text-decoration: inherit; left: 43px; width: 17px; top: 3px; height: 17px;']"))
						.click();
				// System.out.println("Initial write off finished");
				Thread.sleep(700);
				Thread.sleep(1750);

			}
			if (Driver.getData("VerificationData").equals("FinalWRT")) {
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
						.click(); // MAINTAIN MENU BUTTON
				Thread.sleep(1750);
				Common_Property.driver.manage().window().fullscreen();
				Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Write-offs']"))
						.click();
				Thread.sleep(1750);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Final Write-off']")).click();
				Thread.sleep(1750);
				Thread.sleep(1750);

				Thread.sleep(700);
				Thread.sleep(1750);
				Common_Property.driver.findElement(By.xpath("//div[@name='FinalWriteOffWindow.pbOK']")).click();
				Thread.sleep(700);
				Thread.sleep(1750);
				Common_Property.driver
						.findElement(By
								.xpath("//div[@style='position: absolute; overflow: hidden; white-space: nowrap; text-decoration: inherit; left: 43px; width: 17px; top: 3px; height: 17px;']"))
						.click();

				Thread.sleep(1750);
				Thread.sleep(1750);

			}

			Thread.sleep(1750);
			System.out.println("Initial write off finished");
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);

			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
					.getAttribute("value");
			Thread.sleep(1750);
			System.out.println(ver);
			if (ver.contentEquals(Driver.getData("Documentname"))) {
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				String Desc = "For The customer agreement  " + Driver.getData("Documentname") + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void BO_DocumentVerification_WelcomePack() throws IOException, InterruptedException, FilloException {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT
			System.out.println(Driver.getData("Agreement_Number"));
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			String Customername = Common_Property.driver
					.findElement(By.xpath("//input[@name='CustomerWindow.PartyIdentityView.dfFirstname']"))
					.getAttribute("value").toString();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='CustomerWindow.File.Close']")).click();
			Thread.sleep(700);

			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']"))
					.click();// DOCUMENT
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']")).click();
			Thread.sleep(4000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']"))
					.click();
			Thread.sleep(3050);
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']"))
					.sendKeys(Driver.getData("Documentname"));
			Thread.sleep(1550);
			Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"))
					.click();
			Thread.sleep(1750);

			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbDetails']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestDetailWindow.pbBespoke']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='DocumentRequestRecipientWindow.DocumentRequestRecipientView.pbDocuments']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(
							By.xpath("//div[@name='ViewDocumentPagesWindow.ViewDocumentPagesOutlineView.pbDetails']"))
					.click();
			Thread.sleep(5050);
			String ver1 = Common_Property.driver
					.findElement(
							By.xpath("//div[@name='DocumentWindow.DocumentView.ofVariable']/div/div/div[2]/div[4]"))
					.getText().toString();
			Thread.sleep(3050);
			System.out.println("Variable is " + ver1);
			//

			// String ver
			// =Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]")).getText().toString();
			Thread.sleep(5050);
			System.out.println(ver1);
			if (ver1.equalsIgnoreCase(Customername)) {
				System.out.println("pass document welcome" + ver1);

				String Desc = "Successfully  " + Customername + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {
				System.out.println("Fail document welcome" + ver1);

				String Desc = "For The customer agreement  " + Customername + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}
			Thread.sleep(5050);

			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentWindow.pbCancel']")).click();
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='ViewDocumentPagesWindow.pbCancel']"))
					.sendKeys(Keys.ESCAPE);
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestRecipientWindow.pbCancel']"))
					.sendKeys(Keys.ESCAPE);
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestDetailWindow.pbCancel']"))
					.sendKeys(Keys.ESCAPE);
			Thread.sleep(2700);
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();
			Thread.sleep(2050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(2050);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(2750);

		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}
	}

	public static void Batchrun(Recordset record) throws InterruptedException, IOException, FilloException {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		String batchnames = Driver.getData("Batchname");
		BatchList = Driver.Batchwordsheetvalue(batchnames);
//		int height = Integer.parseInt(Configuration.screenheight);
//		int width = Integer.parseInt(Configuration.screenwidth);
		// Configuration.screenresolution;

		for (int c_batch = 0; c_batch <= BatchList.size() - 1; c_batch++) {
			try {

				Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Common_Property.driver.manage().window().setSize(new Dimension(height, width));

				// NAVIGATION
				Thread.sleep(2250);
				String sysdate = Common_Property.driver
						.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div"))
						.getText();
				Driver.get_sysdate(sysdate, record);

				Thread.sleep(2250);

				Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
				Thread.sleep(1050);

				Common_Property.driver.findElement(By.xpath("//div[1][text()='Batches']")).click();
				Thread.sleep(1250);
				Common_Property.driver.findElement(By.xpath("//div[text()='Display Job Queues']")).click();
				Thread.sleep(2050);
				Common_Property.driver.findElement(By.xpath("//div[text()='Submit...']")).click();
				Thread.sleep(1500); // html/body/div[7]/div[2]/div/div/div/div/div/div[2]/div[2]
				Common_Property.driver
						.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[2]/div[2]")).click();
				Thread.sleep(2500);                  
				/*Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div[2]/input"))
						.sendKeys(Keys.F11);
				Common_Property.driver.manage().window().fullscreen();
				Thread.sleep(100);*/

				Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div[2]/input"))
						.sendKeys(BatchList.get(c_batch));
				Thread.sleep(2500);
				Common_Property.driver.findElement(By.xpath("//div[text()='OK']")).click();
				Thread.sleep(500);                              //html/body/div[8]/div[3]/div[1]
				Common_Property.driver
						.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[4]/div[1]/div[2]"))
						.click();              //html/body/div[8]/div[2]/div/div/div/div/div/div[4]/div[1]/div[2]
				Thread.sleep(3500);
				Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div/div[1]/div/div[3]/div")).click();
				Thread.sleep(500);

				Thread.sleep(150);
				Common_Property.driver.findElement(By.xpath("//div[text()='Now']")).click();
				Thread.sleep(500);
				//Driver.add_days(sysdate,record);
				String Start = Common_Property.driver
						.findElement(By.xpath("//div[text()='Now']/ancestor::div[2]/div[1]/input"))
						.getAttribute("value");
				System.out.println(Start);//html/body/div[8]/div[2]/div/div/div/div/div/div[6]/div[1]/input
				String stdate = Start.substring(0, 11);
				if (BatchList.get(c_batch).contains("Overnight")) {
				Common_Property.driver
						.findElement(By.xpath("//div[text()='End date:']/ancestor::div[2]/div[12]/input"))
						.sendKeys(Driver.add_days(sysdate,record));//html/body/div[8]/div[2]/div/div/div/div/div/div[12]/input
				Thread.sleep(200);
				}
				
				else{
					Common_Property.driver
					.findElement(By.xpath("//div[text()='End date:']/ancestor::div[2]/div[12]/input"))
					.sendKeys(sysdate);
				}
				Common_Property.driver.findElement(By.xpath("//div[text()='Save']")).click();
				Thread.sleep(500);
				String days =record.getField("No.of.days");
				int nxt = Integer.parseInt(days);
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
				Calendar c1 = Calendar.getInstance();
				c1.setTime(sdf1.parse(stdate));
				Date date = new Date();
				Common_Property.SQLcon = DriverManager.getConnection("jdbc:oracle:thin:@linux03:1524:provsys", "forte",
						"forte");
				Common_Property.st = Common_Property.SQLcon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				if (BatchList.get(c_batch).contains("Overnight")) {
					for (int i = 1; i <= nxt; i++) {

						c1.add(Calendar.DAY_OF_MONTH, 1);
						date = c1.getTime();
						String date1 = sdf1.format(date);
						System.out.println(sdf1.format(date));
						String Query2 = "select to_char(pp_pan_process_date.gf_date_without_time() ,'dd-MON-YYYY') as Sys_Date from dual";
						Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query2);
						Common_Property.rs1 = Common_Property.st.executeQuery(Query2);
						Common_Property.rs1.next();

						while (true) {

							Common_Property.rs1.refreshRow();
							String currentdate = Common_Property.rs1.getString("Sys_Date");

							if (date1.equalsIgnoreCase(currentdate)) {
								System.out.println("System date has changed to " + currentdate);
								break;
							}

							// Thread.sleep(180000);
						}
					}
				} else {

					
					String Query2 = "select * from BATCH_JOBS job "
							+ "join BATCH_GROUPS_AND_PROCESSES bpr on bpr.bpr_serial = job.JOB_BATCH_ABSTRACT_PROCESS "
							+ " where to_char(JOB_START_DATE_TIME,'DD-MON-YYYY') = to_date('" + sysdate
							+ "','DD-MON-YYYY') " + "and upper(bpr_name) = upper('" + BatchList.get(c_batch) + "')";
					//System.out.println(Query2);
					Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query2);
					Common_Property.rs2 = Common_Property.st.executeQuery(Query2);
					Common_Property.rs2.next();
					while (!Common_Property.rs2.getString("JOB_STATUS").equals("C")) {
						Common_Property.rs2.refreshRow();
					}

				}
				                                              //html/body/div[4]/div[3]/div[1]
				Common_Property.driver.findElement(By.xpath("//div[text()='Close']")).click();
				/*                                           
				 * WebElement close=Common_Property.driver.findElement(By.xpath(
				 * "/html/body/div[7]/div[1]/div[1]/div[4]/div"));
				 * Thread.sleep(500); JavascriptExecutor js =
				 * (JavascriptExecutor)Common_Property.driver;
				 * ((JavascriptExecutor) Common_Property.driver).executeScript(
				 * "arguments[0].click();", close);
				 * //js.executeScript("arguments[0].click()", close);
				 */

			}

			catch (Exception e) {

				System.out.println("The exception was " + e);
				System.out.println("Abnormal Termination due to " + e);
				String Exce = e.toString();
				String report = "Exception " + Exce.substring(0, 87);

				String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
				Utilities.ExtentFailReport(methodname, e);
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
				

			}
		}

	}

	// BARGAVI
	public static void Low_tempoarg() throws Exception, InterruptedException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(700);

			// TEMPORARY ARRANGEMENT NAVIGATION
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements']"))
					.click();
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Temporary ']"))
					.click();
			Thread.sleep(1150);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.insertBelow']"))
					.click();
			Thread.sleep(1900);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]"))
					.click();
			Thread.sleep(1700);
			// gettemp value
			String scheduleamt = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofRepayment']/div/div/div[2]/div[4]"))
					.getText();
			float result = Float.parseFloat(scheduleamt);
			float subtractamount = result - 5;

			String finalamt = String.valueOf(subtractamount);
			Thread.sleep(1150);

			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[6]/child::input[1]"))
					.sendKeys(finalamt);

			// build profile
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']"))
					.click();
			Thread.sleep(1550);
			String a = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/div/div/div/div[7]"))
					.getText().toString();
			// Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']")).sendKeys(Keys.ESCAPE);;
			String b = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[1]"))
					.getText();
			String c = "value of A " + a + " Value of B " + b;

			Thread.sleep(2550);
			if (a.contentEquals(b)) {

				String Desc = "Temporary Arrangement less than the normal scheduled amount-Passed";
				Utilities.ExtentPassReport(methodname);
			} else {

				String Desc = "Temporary Arrangement less than the normal scheduled amount- has not as Expected ";
				Utilities.ExtentFailReport1(methodname, Desc);

			}
			Thread.sleep(1550);

			Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.pbOK']")).click();
			Thread.sleep(2550);

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(2750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();

		}

		catch (Exception e) {
			// TODO: handle exception

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
            String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	// BARGAVI
	public static void high_tempoarg() throws Exception, InterruptedException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(700);

			// TEMPORARY ARRANGEMENT NAVIGATION
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements']"))
					.click();
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Temporary ']"))
					.click();
			Thread.sleep(1150);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.insertBelow']"))
					.click();
			Thread.sleep(1900);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]"))
					.click();
			Thread.sleep(1700);
			// gettemp value
			String scheduleamt = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofRepayment']/div/div/div[2]/div[4]"))
					.getText();
			float result = Float.parseFloat(scheduleamt);
			float subtractamount = result + 5;
			String finalamt = String.valueOf(subtractamount);
			Thread.sleep(1150);

			String a = finalamt;
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[6]/child::input[1]"))
					.sendKeys(finalamt);

			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']"))
					.click();
			Thread.sleep(1550);
			a = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/div/div/div/div[7]"))
					.getText().toString();
			// Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']")).sendKeys(Keys.ESCAPE);;
			String b = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[3]"))
					.getText();

			Thread.sleep(2550);
			;
			if (a.contentEquals(b)) {

				String Desc = "Temporary Arrangement more than the normal scheduled amount-Passed";
				Utilities.ExtentPassReport(methodname);
			} else {

				String Desc = "Temporary Arrangement less more the normal scheduled amount- has not as Expected ";
				Utilities.ExtentFailReport1(methodname, Desc);

			}
			Thread.sleep(1550);

			Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.pbOK']")).click();
			Thread.sleep(1550);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	// BARGAVI
	public static void newmontly_tempoarg() throws Exception, InterruptedException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(700);

			// TEMPORARY ARRANGEMENT NAVIGATION
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements']"))
					.click();
			Thread.sleep(1150);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Temporary ']"))
					.click();
			Thread.sleep(1150);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.insertBelow']"))
					.click();
			Thread.sleep(1900);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]"))
					.click();
			Thread.sleep(1700);
			// gettemp value
			String scheduleamt = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofRepayment']/div/div/div[2]/div[4]"))
					.getText();
			float result = Float.parseFloat(scheduleamt);
			float subtractamount = result + 5;
			String finalamt = String.valueOf(subtractamount);
			Thread.sleep(1150);

			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[6]/child::input[1]"))
					.sendKeys(finalamt);
			Thread.sleep(2700);

			// calculation

			String getdate = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[7]"))
					.getText().toString();
			Thread.sleep(1700);

			/*
			 * SimpleDateFormat dateFormat1 = new
			 * SimpleDateFormat("dd-MMM-YYYY"); Date convertedDate =
			 * dateFormat1.parse(getdate); Calendar c = Calendar.getInstance();
			 * c.setTime(convertedDate); c.set(Calendar.DAY_OF_MONTH,
			 * c.getActualMaximum(Calendar.DAY_OF_MONTH)); String target =
			 * dateFormat1.format(c.getTime());
			 */

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(getdate));
			c.add(Calendar.DATE, 1);
			String target = sdf.format(c.getTime());

			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[7]"))
					.click();

			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[7]/child::input[1]"))
					.sendKeys(target);

			// buildprofile
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']"))
					.click();
			Thread.sleep(1550);
			// Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']")).sendKeys(Keys.ESCAPE);;
			String b = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[1]"))
					.getText();

			Thread.sleep(550);
			if (target.contentEquals(b)) {

				String Desc = "temporary arrangement date falls on end of the month ";
				Utilities.ExtentPassReport(methodname);
			} else {

				String Desc = "temporary arrangement date falls on end of the month ";
				Utilities.ExtentFailReport1(methodname, Desc);

			}
			Thread.sleep(1550);

			Common_Property.driver.findElement(By.xpath("//div[@name='TemporaryArrangementWindow.pbOK']")).click();
			Thread.sleep(1550);

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
            String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void BO_DateMatch() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			// MAINTAIN CUSTOMER AGREEMENT
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.View']")).click(); // MAINTAIN
																														// MENU
																														// BUTTON
			Thread.sleep(3500);
			Common_Property.driver.findElement(By.xpath("//div[text()='Schedules']")).click();
			Thread.sleep(1500);
			Common_Property.driver.findElement(By.xpath("//div[text()='Repayment']")).click();
			Thread.sleep(1500);
			// DISPLAY JOB QUEUE
			// String[] value =new String[10];
			// value[1]
			// =Common_Property.driver.findElement(By.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']//div[1]")).getText().toString();
			// System.out.println("Date and Instalment Amt in Schedule=
			// "+"\n"+value[1]+"\n");
			// String matchdate=value[1];
			// String matchdate1 = matchdate.substring(matchdate.lastIndexOf("
			// ")+1);
			// System.out.println(matchdate1);

			String date = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']//div[1]"))
					.getText();
			String[] det = date.split("/n");
			System.out.println(det.length);
			List<String> det2 = Arrays.asList(date.split("[\\r\\n]+"));
			String result = det2.get(det2.size() - 2);

			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='ViewSchedulesWindow.pbCancel']")).click();
			Thread.sleep(1700);

			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfEndDate']"))
					.getAttribute("value");
			Thread.sleep(1700);
			System.out.println(ver);
			if (ver.contains(result)) {

				String Desc = "Successfully  " + Driver.getData("matchdate") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "For The customer agreement  " + Driver.getData("matchdate") + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
            String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}

	}

	public static void BO_Status_check() throws IOException, InterruptedException // AXC-REGR-190

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']"))
					.getAttribute("value");
			Thread.sleep(1750);
			System.out.println(ver);

			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

				// Utilities.Capture_Screenshot();
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				// Utilities.Capture_Screenshot();
				String Desc = "For The customer agreement  " + Driver.getData("Documentname") + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);

			}

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Exce = e.toString();
			String report = "Exception " + Exce.substring(0, 87);
			// Utilities.Capture_Screenshot();
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}

	}

	public static void BO_DocumentVerification1() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// NAVIGATION
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Agreement Servicing']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
					.click();
			Thread.sleep(1700);

			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
					.click(); // MAINTAIN MENU BUTTON
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']"))
					.click();// DOCUMENT
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']")).click();
			Thread.sleep(4000);
			Common_Property.driver
					.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver
					.findElement(By
							.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']"))
					.sendKeys(Driver.getData("Documentname"));
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
			Thread.sleep(1750);
			//

			String ver = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"))
					.getText().toString();
			Thread.sleep(1750);
			System.out.println(ver);
			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "For The customer agreement  " + Driver.getData("Documentname") + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			//
			Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
					.click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
					.click();
			Thread.sleep(1750);
		} catch (Exception e) {
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid,MethodName,"False");

		}
	}

	public static boolean isAlertPresent() {
		try {
			boolean result = false;
			WebElement alert1 = Common_Property.driver.findElement(By.xpath("//div[text()='Warning']"));
			// Common_Property.driver.switchTo().alert();
			// Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[4]/div")).

			//// div[@tabindex='1']/following::div[text()='Warning']/following::div[text()='OK']
			if (alert1.isDisplayed()) {
				result = true;
			}
			return result;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}

	public static boolean isAlertPresent1() {
		try {
			boolean result = false;
			WebElement alert1 = Common_Property.driver
					.findElement(By.xpath("//div[@tabindex='1']//div[text()='Information']"));
			// Common_Property.driver.switchTo().alert();
			// Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[4]/div")).

			//// div[@tabindex='1']/following::div[text()='Warning']/following::div[text()='OK']
			if (alert1.isDisplayed()) {
				result = true;
			}
			return result;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}
	public static boolean isAlertPresent4() {
		try {
			boolean result = false;
			WebElement alert1 = Common_Property.driver
					.findElement(By.xpath("//div[text()='Warning']"));
			// Common_Property.driver.switchTo().alert();
			// Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[4]/div")).

			//// div[@tabindex='1']/following::div[text()='Warning']/following::div[text()='OK']
			if (alert1.isDisplayed()) {
				result = true;
			}
			return result;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}
	
	
	public static void searchAgreement(String agrNum) throws IOException, FilloException, InterruptedException{
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			Common_Property.waitUntill(POM_Repository.BO_Open);
			Common_Property.driver.findElement(POM_Repository.BO_Open).click();	
			Common_Property.waitUntillEnabled(POM_Repository.BO_Elm_AgrServicing);
			Common_Property.driver.findElement(POM_Repository.BO_Elm_AgrServicing).click();
			Common_Property.waitUntillEnabled(POM_Repository.BO_MaintainCustAgr);
			Common_Property.driver.findElement(POM_Repository.BO_MaintainCustAgr).click();
			//MAINTAIN CUSTOMER AGREEMENT
			Common_Property.waitUntill(POM_Repository.BO_Edt_AgrNum);
			Common_Property.driver.findElement(POM_Repository.BO_Edt_AgrNum).click();
			Common_Property.driver.findElement(POM_Repository.BO_Edt_AgrNum).sendKeys(agrNum);
			Thread.sleep(2000);
			Common_Property.waitUntillEnabled(POM_Repository.BO_Btn_Find);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_Find).click();
			Thread.sleep(1000);
			Common_Property.driver
			.findElement(By
					.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']"))
			.click();
			Thread.sleep(10000);
		} catch (Exception e){
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
	}
	
	public static void bacs_Clear() throws InterruptedException{
		try{
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
		.click();
		Thread.sleep(2000);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.BACS Queue Entry']")).click();
		Thread.sleep(2000);
		//Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div[1]/div[1]")).click();
		//Thread.sleep(2000);                         //html/body/div[7]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div[1]
		Common_Property.driver.findElement(By.xpath("//html/body/div[9]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div[1]")).click();
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//div[@name='BACSQueueEntryFindWindow.BACSQueueEntriesMaintainView.pbDelete']")).click();
		Thread.sleep(2000);
		Common_Property.driver.findElement(By.xpath("//div[@tabindex='2'][1]/div[text()='Yes']")).click();
		Thread.sleep(4000);
		Common_Property.driver.findElement(By.xpath("//div[@name='BACSQueueEntryFindWindow.pbCancel']")).click();
		Thread.sleep(3000);
		
		}
		catch(Exception e){
			
			System.out.println(e);
			
		}
	}
	
	
	public static void Check_autochange() throws InterruptedException, IOException, FilloException {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		try{
			searchAgreement(Driver.getData("Agreement_Number"));
			
			String enddate=Common_Property.driver.findElement(By.name("MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfEndDate")).getAttribute("value");
			System.out.println(enddate);
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.View']"))
					.click();
			Thread.sleep(1250);
			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Schedules']"))
					.click();
			Thread.sleep(1250);
			String grid_enddate = Common_Property.driver
					.findElement(By
							.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']/div/div/div[3]/div[1]"))
					
					                //html/body/div[9]/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div[3]/div[1]
					.getText().toString();
			System.out.println(grid_enddate);
			if(enddate.equalsIgnoreCase(grid_enddate)){
				String Desc="End date doesnot changed";
				Utilities.ExtentPassReport(Desc);
			}
		}
		catch(Exception e){
			System.out.println(e);
			
		}
	
	

}

	public static void BO_Early_settlement() throws IOException, InterruptedException
// AXC-REGR-190
	, FilloException {
System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
 Methodid = Long.toString(Thread.currentThread().getId());
DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
Date sdate = new Date();
String datetimestart = dateFormat.format(sdate);

try {
	searchAgreement(Driver.getData("Agreement_Number"));
	Thread.sleep(3000);
	//bacs_Clear();
	//searchAgreement(Driver.getData("Agreement_Number"));
	Thread.sleep(1000);
	Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
			.click(); // MAINTAIN MENU BUTTON
	Thread.sleep(2000);
	Common_Property.driver.manage().window().fullscreen();
	Thread.sleep(2000);
	Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlements']"))
			.click();// DOCUMENT
	Thread.sleep(2000);
	Common_Property.driver
			.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlement Quote']")).click();
	Thread.sleep(10000);
	Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.pbBespoke']")).click();
	Thread.sleep(3000);
	Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.pbBespoke']"))
			.sendKeys(Keys.ENTER);
	Thread.sleep(2550);
	Settlementvalue = Common_Property.driver
			.findElement(By.xpath("//input[@name='QuotationWindow.QuoteTabView.dfSettlement']"))
			.getAttribute("value");// 742.72
	Thread.sleep(3000);
	System.out.println("Value is" + Settlementvalue);
	Thread.sleep(6050); // ModifyDocumentRequestWindow.pbOK
	Common_Property.driver.findElement(By.xpath("//div[@name='ModifyDocumentRequestWindow.pbOK']")).click();
	Thread.sleep(5050);
	Common_Property.driver.findElement(By.xpath("//div[@name='SelectionWindow.buttons']/child::div[2]"))
			.click();
	/*Thread.sleep(5750);
	Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
			.click(); // MAINTAIN MENU BUTTON
	Thread.sleep(1700);
	Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']"))
			.click();// DOCUMENT
	Thread.sleep(1000);
	Common_Property.driver
			.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']")).click();
	Thread.sleep(5000);
	Common_Property.driver
			.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']"))
			.click();
	Thread.sleep(3750);
	Common_Property.driver
			.findElement(By
					.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']"))
			.sendKeys(Driver.getData("Documentname"));
	Thread.sleep(2750);
	Common_Property.driver.findElement(By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']")).click();
	Thread.sleep(4750);
	String ver = Common_Property.driver
			.findElement(By
					.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]"))
			.getText().toString();
	Thread.sleep(1750);
	System.out.println(ver);
	if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {
		String Desc = "Expected Document has successfully generated";
		Utilities.ExtentPassReport(Desc);

	} else {
		String Desc = "Expected Document has not generated";
		Utilities.ExtentFailReport1(methodname, Desc);

	}

	Common_Property.driver.findElement(By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']")).click();*/
	Thread.sleep(4750);
	Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
	Thread.sleep(2750);
	Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
			.click();
	Thread.sleep(2750);
	Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
			.click();
	Thread.sleep(2750);
	//searchAgreement(Driver.getData("Agreement_Number"));
	Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
	Thread.sleep(700);
	Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash and Posting']")).click();
	Thread.sleep(1750);
	Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Transactions']")).click();
	Thread.sleep(1050);
	Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Open.Cash Posting']")).click();
	Thread.sleep(1550); // input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']
	Common_Property.driver
			.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']"))
			.sendKeys(Driver.getData("Agreement_Number"));
	Thread.sleep(1550);
	Common_Property.driver
			.findElement(
					By.xpath("//div[@name='CashPostingWindow.CashBatchDetailsView.dlDefaultPaymentMethod']"))
			.click();
	Common_Property.driver.findElement(By.xpath("//div[text()='Cash']")).click();
	Thread.sleep(2050);
	Common_Property.driver
			.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']"))
			.click();
	Thread.sleep(4500);
	boolean present = isAlertPresent();
	if (present == true) // html/body/div[8]/div[4]/div
	{ // html/body/div[8]/div[4]/div
		Common_Property.driver.findElement(By.xpath("//div/div[4]/div[@tabindex='2']")).click();
		Thread.sleep(1500);
	}

	String keypress = Driver.getData("VerificationData");
	System.out.println("Data should be" + keypress);
	if (keypress.equalsIgnoreCase("SET")) {

		/*WebElement source = Common_Property.driver
				.findElement(By.xpath("//div[@tabindex='1']//div[text()='Create Cash Batch']"));
		WebElement dest = Common_Property.driver
				.findElement(By.xpath("//div[@name='MainUI.Cash and Posting']"));
		Actions action = new Actions(Common_Property.driver);
		action.dragAndDrop(source, dest).build().perform();*/
		//BO_Settlement_Quote();
		// Common_Property.driver.findElement(By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']")).sendKeys(Keys.ENTER);
//		WebElement dest1 = Common_Property.driver.findElement(By.xpath("//div[@name='MainUI.Audit']"));
//		action.dragAndDrop(source, dest1).build().perform();
//		Common_Property.driver.manage().window().fullscreen();
		Common_Property.driver
				.findElement(
						By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
				.click();
		Thread.sleep(3000);
		Common_Property.driver
				.findElement(
						By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']"))
				.sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(1700);
		Common_Property.driver
				.findElement(
						By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']"))
				.click();
		Thread.sleep(2750);
		System.out.println("Settlement");
		Thread.sleep(3700);
		Common_Property.driver
				.findElement(
						By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
				.clear();
		Thread.sleep(4000);
		//Settlementvalue="101.13";
		if(Driver.getData("Reshedule_Date").equalsIgnoreCase("Reverse_settlement")){
			System.out.println("Settlementvalue");
			float value=Float.parseFloat(Settlementvalue);
			float settlement=value-3;
			Settlementvalue=Float.toString(settlement);
		Common_Property.driver
				.findElement(
						By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
				.sendKeys(Settlementvalue);
		}
		else{
			Common_Property.driver
			.findElement(
					By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
			.sendKeys(Settlementvalue);
		}
		Thread.sleep(2700);
		Common_Property.driver
				.findElement(
						By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']"))
				.click();
		Thread.sleep(2700);
		Common_Property.driver.manage().window().fullscreen();
		Thread.sleep(1000);
		Common_Property.driver
				.findElement(By
						.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']"))
				.click();
		Thread.sleep(2700);

		boolean present1 = isAlertPresent();
		if (present1 == true) {
			Common_Property.driver.findElement(By.xpath("//div[@tabindex='2']//div[text()='OK']")).click();
		}
		Thread.sleep(1700);
		boolean present2 = isAlertPresent1();
		if (present2 == true) {
			Common_Property.driver.findElement(By.xpath("//div[@tabindex='2']//div[text()='OK']")).click();
			Thread.sleep(1700);
		}                                             
		Common_Property.driver.findElement(By.xpath("//div[@tabindex='31']/div/div[1]/div")).click();
		Thread.sleep(2750);
		Common_Property.driver
				.findElement(By.xpath("//div[@tabindex='31']/div/div[1]/div[1]/div[text()='Settlement']"))
				.click();
		Thread.sleep(2750);
		Common_Property.driver
		.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
		.click();
		Thread.sleep(2750);
String BatchTotal = Common_Property.driver
		.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']"))
		.getAttribute("value");
System.out.println(BatchTotal);
Thread.sleep(1700);
Thread.sleep(1750);
Common_Property.driver
		.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
		.clear();
Common_Property.driver
		.findElement(By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']"))
		.sendKeys(BatchTotal);
Thread.sleep(1700);
Thread.sleep(2000);
Common_Property.driver
		.findElement(By.xpath("//div[@name='CashPostingWindow.buttons']//child::div[2]/child::div[1]"))
		.click();
Thread.sleep(1700);
Thread.sleep(15750);

Thread.sleep(1750);

//Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
		//.click();
Thread.sleep(1750);
}


}
catch(Exception e){
	
	String Desc = "Early Settlement payment has not been done successful";
	Utilities.ExtentFailReport(Desc, e);
	Configuration.updatePropertyFile(Methodid,MethodName,"False");


}
}
	
	public static void Reverse_Esettle() throws IOException, InterruptedException,FilloException {
	System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
	MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
	 Methodid = Long.toString(Thread.currentThread().getId());
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
	Date sdate = new Date();
	String datetimestart = dateFormat.format(sdate);

	try {
		searchAgreement(Driver.getData("Agreement_Number"));
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']"))
		.click(); // MAINTAIN MENU BUTTON
		Thread.sleep(2000);
		Common_Property.driver.manage().window().fullscreen();
		Thread.sleep(2000);
		Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reverse Early Settlement']"))
				.click();
		Thread.sleep(4000);
		Common_Property.driver.findElement(By.xpath("//div[text()='Reverse']"))
		.click();                                    //html/body/div[8]/div[3]/div[1]
		Common_Property.driver
		.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.pbTransactions']")).click();
Thread.sleep(700);

Common_Property.driver
		.findElement(
				By.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.pbFilter']"))
		.click();
Thread.sleep(700);
Common_Property.driver
		.findElement(By
				.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfTransactionType']"))
		.sendKeys("RREB");
Thread.sleep(1700);
String currentdate1 = Common_Property.driver
		.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"))
		.getText().toString();
Common_Property.driver
		.findElement(By
				.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']"))
		.sendKeys(currentdate1);
Thread.sleep(2700);
Common_Property.driver
		.findElement(By
				.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']"))
		.sendKeys(currentdate1);
Thread.sleep(3700);
Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsFilterWindow.pbOK']"))
		.click();
Thread.sleep(5750);

Thread.sleep(2750);
String ver = Common_Property.driver
		.findElement(By
				.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.ofViewTransactionsPreUpdateOutlineField']/child::div[1]/child::div[1]/child::div[1]/child::div[2]"))
		.getText().toString();
Thread.sleep(2750);


if (ver.contentEquals("ACD")) {

	String Desc = "Agreement has posted the payment as Settlement as expected";
	Utilities.ExtentPassReport(Desc);
	Thread.sleep(200);
	Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();

} else {

	String Desc = "Agreement has not posted the payment as Settlement as expected";
	Utilities.ExtentFailReport1(methodname, Desc);
	Common_Property.driver.findElement(By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']")).click();
}

Thread.sleep(1750);
Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']")).click();
Thread.sleep(1750);
Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
	.click();
Thread.sleep(1750);
//Common_Property.driver.findElement(By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']"))
	//.click();
Thread.sleep(1750);
}
	catch(Exception e){
		
		String Desc = "Early Settlement  payment has not been reversed successfully";
		Utilities.ExtentFailReport(Desc, e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
	}
		
	}
}
