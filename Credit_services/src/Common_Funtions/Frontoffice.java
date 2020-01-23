package Common_Funtions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.codoid.products.exception.FilloException;

import Common_Funtions.*;

public class Frontoffice extends Driver {

	static String count1;
	static String Targetdate1;
	static String Settlementvalue = " ";
	static String Updated_Date = " ";
	static int anns = 0;
	static String agr_num = " ";
	static String type_agr_num = " ";
	static String CurrentBal = "";
	static String Zero;

	public static void Paymentdate_FO() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {
			fo_searchAgreement();
			Common_Property.driver
					.findElement(By
							.xpath("//div[@class='outercontent']/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/a"))
					.click();

			// VP1
			if (Driver.getData("PD_Verificationtype").equals("Final_Dates")) {
				List<WebElement> forms = Common_Property.driver
						.findElements(By.xpath("//select[@id='PropertySelection']/option"));
				int count = forms.size();
				count = count - 1;
				if (count == 28) // Verification Point1
				{
					count1 = Integer.toString(count);

					String Desc = "The total payment dates available in the list is 1 to " + count;
					Utilities.ExtentPassReport(methodname);
				} else {
					count1 = Integer.toString(count + 1);

					String Desc = "The total payment dates available in the list is 1 to " + count;
					Utilities.ExtentFailReport1(methodname, Desc);
					Common_Property.driver.findElement(By.xpath("//div[@class='outercontent']")).click();
				}

			}

			// VP2
			else if (Driver.getData("PD_Verificationtype").equals("DateChange")) {
				String Str_Date = Common_Property.driver
						.findElement(By.xpath("//table[@class='entryTable']/tbody/tr[4]/td[2]")).getText().toString();
				DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(formatter.parse(Str_Date));
				String First_Date_Addition_str = Driver.getData("First_Date_Addition");
				int First_Date_Addition_int = Integer.parseInt(First_Date_Addition_str);
				c.add(Calendar.DATE, First_Date_Addition_int);

				String Targetdate = formatter.format(c.getTime());
				System.out.println("The added date is " + Targetdate);
				String full_target_date = Targetdate;

				Targetdate = (Targetdate.substring(0, 2));
				System.out.println("Segricated date " + Targetdate);
				int int_date = Integer.parseInt(Targetdate);

				if (int_date == 29 || int_date == 30 || int_date == 31) {
					DateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					Calendar c1 = Calendar.getInstance();
					c1.setTime(formatter.parse(Str_Date));
					c1.add(Calendar.DATE, 2);
					Targetdate1 = formatter1.format(c1.getTime());
					Targetdate1 = (Targetdate1.substring(0, 2));
					String cond = (Targetdate1.substring(0, 1));
					if (cond.equalsIgnoreCase("0")) {
						anns = 1;
						Targetdate1 = (Targetdate1.substring(1, 2));
					}

					agr_num = Driver.getData("Agreement_Number");
					type_agr_num = (agr_num.substring(0, 1));

					if (type_agr_num.equalsIgnoreCase("8") || Driver.getData("type").equalsIgnoreCase("collections")) {

						if (Common_Property.driver.findElement(By.xpath("//input[@name='newNextPaymentDate']"))
								.isDisplayed())
							;
						{
							Common_Property.driver.findElement(By.xpath("//input[@name='newNextPaymentDate']"))
									.sendKeys(full_target_date);
							Utilities.ExtentPassReport("Agreeement next payment date field is displaying as expected");
						}

					} else {
						Select select = new Select(
								Common_Property.driver.findElement(By.xpath("//select[@id='PropertySelection']")));
						select.selectByValue(Targetdate1);
					}
				}

				else {

					agr_num = Driver.getData("Agreement_Number");
					type_agr_num = (agr_num.substring(0, 1));

					if (type_agr_num.equalsIgnoreCase("8") || Driver.getData("type").equalsIgnoreCase("collections")) {
						Common_Property.driver.findElement(By.xpath("//input[@name='newNextPaymentDate']"))
								.sendKeys(full_target_date);

						Targetdate1 = full_target_date.substring(0, 2);
					} else {
						String cond = (Targetdate.substring(0, 1));

						if (cond.equalsIgnoreCase("0")) {
							anns = 1;

							Targetdate = (Targetdate.substring(1, 2));

						}

						Select select = new Select(
								Common_Property.driver.findElement(By.xpath("//select[@id='PropertySelection']")));
						select.selectByValue(Targetdate);
						Targetdate1 = Targetdate;

					}
				}

				Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
				Thread.sleep(5000);

				Common_Property.driver
						.findElement(By
								.xpath("//div[@class='outercontent']/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/a"))
						.click();
				Thread.sleep(500);
				String Updated_Date1 = Common_Property.driver
						.findElement(By
								.xpath("//div[@class='entry']/table/tbody/tr/td[3][text()='Next Payment Date']/following-sibling::td[1]"))
						.getText().toString();
				String Updated_Date = Updated_Date1;

				Updated_Date = (Updated_Date.substring(0, 2));
				System.out.println(Updated_Date);

				if (anns == 1) {
					Updated_Date = (Updated_Date.substring(1, 2));
				} else {
					Updated_Date = (Updated_Date.substring(0, 2));
				}

				System.out.println(Updated_Date);

				if (Targetdate1.equals(Updated_Date))

				{

					String Desc = "The date has been successfully moved to " + Updated_Date1;
					Utilities.ExtentPassReport(methodname);
				} else {
					String Desc = "The date change was not successful";
					Utilities.ExtentFailReport1(methodname, Desc);

					Common_Property.driver.findElement(By.xpath("//div[@class='outercontent']")).click();

				}

			}

			else if (Driver.getData("PD_Verificationtype").equals("Textbox_Exist")) {
				String Str_Date = Common_Property.driver.findElement(By.xpath("//input[@name='newNextPaymentDate']"))
						.getAttribute("type");
				if (Str_Date.equals("text")) {

					String Desc = "The Page ConMaintains Textbox";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "The Page doesnot ConMaintain the Textbox";
					Utilities.ExtentFailReport1(methodname, Desc);
				}

			}
		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}

	}

	public static void letter_FO() throws Exception {

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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@class='outercontent']/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a"))
					.click();

			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//form[@id='settlementForm']/div[2]/div[2]/a")).click();

			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//*[@id='sitebody']/div[5]/div[3]/div/button[1]/span"))
					.click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//body[@id='sitebody']/div[3]/div[2]/div[2]/div/a[1]"))
					.click();
			Thread.sleep(1000);

			Common_Property.driver
					.findElement(By
							.xpath("//a[@href='/panCoreSaas/app?component=%24PanDirectLink_3&page=Collections%2FCOSettlementQuotes&service=direct&session=T&state:Collections/COSettlementQuotes=BrO0ABXcSAAAAAQAAC2N1cnJlbnRQYWdlc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAE%3D']"))
					.click();// close button
			Thread.sleep(1000);

			String ver = Common_Property.driver
					.findElement(By.xpath("//div[@class='outercontent']/div[3]/div/table/tbody/tr[2]/td[4]")).getText();

			if (ver.equalsIgnoreCase("MOESB Early Settlement Sent")) {

				String Desc = "The letter has been sucessfully generated";
				Utilities.ExtentPassReport(methodname);
			} else {

				String Desc = "The letter geneeration was unsucessfully";
				Utilities.ExtentFailReport1(methodname, Desc);

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

	public static void letterMODN_FO() throws Exception {

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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@class='outercontent']/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a"))
					.click();

			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//form[@id='settlementForm']/div[2]/div[2]/a")).click();

			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//body[@id='sitebody']/div[3]/div[2]/div[2]/div/a[1]"))
					.click();
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//div[@id='']/div[2]/div[2]/div/a[1]")).click();// close
																											// button
			Thread.sleep(1000);

			String ver = Common_Property.driver
					.findElement(By.xpath("//div[@class='outercontent']/div[3]/div/table/tbody/tr[2]/td[4]")).getText();

			if (ver.equalsIgnoreCase("MOESB Early Settlement Sent")) {

				String Desc = "The letter has been sucessfully generated";
				Utilities.ExtentPassReport(methodname);
			} else {

				String Desc = "The letter geneeration was unsucessfully";
				Utilities.ExtentFailReport1(methodname, Desc);

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

	public static void letterMONA_FO() throws Exception

	{
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		try{
		
		Common_Property.driver.findElement(By.xpath("//input[@id='agreementNumber']"))
				.sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
		Thread.sleep(1000);

		Common_Property.driver.findElement(By.xpath("//a[text()='Documents']")).click();
		Thread.sleep(1000);
		Select select = new Select(Common_Property.driver.findElement(By.xpath("//select[@id='documentID']")));
		select.selectByVisibleText("MONA_Initial_NOSIA");
		WebElement elm=Common_Property.driver.findElement(By.xpath("//select[@id='documentID']"));
		Thread.sleep(1000);
		if(elm.getText().contains("MONA_Initial_NOSIA")){
		Utilities.ExtentPassReport("Agreement has Generated the expected document");
		}
		else{
			Utilities.ExtentFailReport1(methodname, "Agreement has not Generated the expected document");
		}
		Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
		Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println(e);
		}
		

	}

	public static void letter_MODN() throws Exception {

		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());

		Common_Property.driver.findElement(By.xpath("//input[@id='agreementNumber']"))
				.sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
		Thread.sleep(1000);

		Common_Property.driver.findElement(By.xpath("//a[text()='Documents']")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		Select select = new Select(Common_Property.driver.findElement(By.xpath("//select[@id='documentID']")));
        select.selectByVisibleText("ZZ_MODN_Default_Notice");
        Thread.sleep(1000);
        WebElement elem=Common_Property.driver.findElement(By.xpath("//select[@id='documentID']"));
        System.out.println(elem.getText());
        if(elem.getText().contains("ZZ_MODN_Default_Notice")){
        	Utilities.ExtentPassReport("Agreement has generated the Document as expected");
        }
        else{
        	Utilities.ExtentFailReport1(methodname, "Agreement has not generated the Document as expected");
        }

		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
		Thread.sleep(3000);

	}

	public static void FO_BankDetails() throws IOException, InterruptedException, FilloException {
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
			// Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			// Common_Property.driver.findElement(By.xpath("//a[text()='Bank
			// Details']")).click();
			// Common_Property.driver.findElement(By.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/a/span")).click();
			String keypress = Driver.getData("VerificationData");
			if (keypress.equalsIgnoreCase("servicing")) {
				Thread.sleep(4000);
				Common_Property.driver.findElement(By.linkText("Bank Details")).click();
			} else {
				Common_Property.driver.findElement(By.linkText("Bank Details")).click();
			}
			Thread.sleep(2000);

			Common_Property.driver.findElement(By.name("accountNumber")).clear();
			Thread.sleep(800);
			Common_Property.driver.findElement(By.name("accountNumber"))
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

			Thread.sleep(2000);

			if (keypress.equalsIgnoreCase("servicing")) {
				Common_Property.driver.findElement(By.linkText("Bank Details")).click();
			} else {
				Common_Property.driver.findElement(By.linkText("Bank Details")).click();
			}

			Thread.sleep(1000);

			String ver = Common_Property.driver.findElement(By.xpath("//input[@name='accountNumber']"))
					.getAttribute("value").toString();
			Common_Property.driver.findElement(By.xpath("//a[text()='Cancel']")).click();
			Thread.sleep(3000);
			Common_Property.driver.findElement(By.xpath("//a[text()='Search']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//span[text()='Home']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@id='agreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			// Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(2000);

			String keypress1 = Driver.getData("VerificationData");
			if (keypress1.equalsIgnoreCase("servicing")) {
				Common_Property.driver.findElement(By.linkText("Bank Details")).click();
			} else {
				Common_Property.driver.findElement(By.linkText("Bank Details")).click();
			}

			String ver1 = Common_Property.driver.findElement(By.name("accountNumber"))
					.getAttribute("value").toString();
			if (ver1.equalsIgnoreCase(Driver.getData("Documentname"))) {

				String Desc = "For The customer agreement Bank_detail has updated";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "For The customer agreement Bank_detail has not been updated ";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

			// }

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);

			Common_Property.driver.findElement(By.xpath("//a[text()='Cancel']")).click();
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

	public static void FO_PAYMENT() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			fo_searchAgreement();
			Common_Property.driver
					.findElement(By
							.xpath("//div[@class='tabs'][2]/div[@class='contentNoMargin']/table[@class='entryTable']/tbody/tr/td[2]/table//tr/td/a[@href='/panCoreSaas/app?page=Collections%2FCOSettlementQuotes&service=page']"))
					.click();
			Thread.sleep(3000);

			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
			Thread.sleep(3000);
			String settle_amount = Common_Property.driver
					.findElement(By.xpath("//div[@class='content']/div[@class='results']/table/tbody/tr[2]/td[7]"))
					.getText();
			Thread.sleep(1700);
			Common_Property.driver.findElement(By.xpath("//div/a[1][text()='Save']")).click();
			Thread.sleep(8000);
			Common_Property.driver.findElement(By.xpath("//div[@class='content'][2]/div/a[1]")).click();
			Thread.sleep(1700);
			Common_Property.driver
					.findElement(By
							.xpath("//div[@class='tabs'][2]/div[@class='contentNoMargin']/table[@class='entryTable']/tbody/tr/td[2]/table//tr[5]/td/a[@href='/panCoreSaas/app?page=Collections%2FCOPostToAgreement&service=page']"))
					.click();
			Thread.sleep(3000);
			Common_Property.driver.findElement(By.xpath("//td[@id='paymentMethodRadio']/p/input[1]")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(settle_amount);
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='reference']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[text()='Post']")).click();
			Thread.sleep(1000);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//div[@class='outercontent']//div[@class='content'][1]//div[@class='content'][1]/div[1]//span"))
					.getText();
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.xpath("//div[@class='content']/div[@class='submitButtons']/form/a[1]")).click();
			Thread.sleep(1000);

			if (ver.equalsIgnoreCase(Driver.getData("VerificationData"))) {

				String Desc = "Payment has successfully done for the Agreement";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "Payment has not done successfully due to some issues";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of " + methodname + " was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");

		}
	}

	public static void FO_PaymentMethod() throws IOException, InterruptedException, FilloException {
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
			Thread.sleep(1500);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			String keypress = Driver.getData("type");
			if (keypress.equalsIgnoreCase("servicing")) {
				Common_Property.driver.findElement(By.linkText("Payment Method")).click();
			} else {
				Common_Property.driver.findElement(By.linkText("Payment Method")).click();
			}
			Thread.sleep(1000);

			String Keypress = Driver.getData("VerificationData");

			if (Keypress.contentEquals("DebitCard")) {
				Select select = new Select(
						Common_Property.driver.findElement(By.xpath("//select[@id='PropertySelection']")));
				select.selectByValue("6");
				Thread.sleep(2000);
				Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
				Thread.sleep(2000);
			}
			if (Keypress.contentEquals("Cash")) {
				Select select = new Select(
						Common_Property.driver.findElement(By.xpath("//select[@id='PropertySelection']")));
				select.selectByValue("1");
				Thread.sleep(1000);
				Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
			Thread.sleep(1000);
			
			 keypress = Driver.getData("type");
			
			if (keypress.equalsIgnoreCase("servicing")) {
				Common_Property.driver.findElement(By.linkText("Payment Method")).click();
			} else {
				Common_Property.driver.findElement(By.linkText("Payment Method")).click();
			}
			Thread.sleep(1000);

			String ver = Common_Property.driver.findElement(By.xpath("//select[@id='PropertySelection']"))
					.getAttribute("value").toString();

			if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

				String Desc = "Successfully  " + Driver.getData("VerificationData") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "For The customer agreement  " + Driver.getData("VerificationData") + " Failed";
				Utilities.ExtentFailReport1(methodname, Desc);

			}
			// Common_Property.driver.findElement(By.xpath("//*[@id='PanDirectLink_699']")).click();

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of " + methodname + " was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

	public static void FO_NewAtAddress() throws IOException, InterruptedException, FilloException {
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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);

			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By
							.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a[1]"))
					.click();

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
			String Keypress = Driver.getData("VerificationData");
			if (Keypress.contentEquals("NewAtAddress")) {
				Common_Property.driver.findElement(By.xpath("//a[@id='insertEarlier']")).click();
				Thread.sleep(2700);
				Common_Property.driver.findElement(By.xpath("//input[@id='propertyNumber']"))
						.sendKeys(Driver.getData("Number"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='streetName']"))
						.sendKeys(Driver.getData("Address1"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='district']"))
						.sendKeys(Driver.getData("District"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='postalTown']"))
						.sendKeys(Driver.getData("Town"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='county']"))
						.sendKeys(Driver.getData("Country"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='movingInDate']"))
						.sendKeys(Driver.getData("date"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='postcode']"))
						.sendKeys(Driver.getData("Postal_Code"));
				Thread.sleep(1000);
				Common_Property.driver.findElement(By.xpath("//a[@id='continue']")).click();

				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a[1]"))
						.click();
				Thread.sleep(000);

				Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
				Thread.sleep(2000);
				String ver = Common_Property.driver.findElement(By.xpath("//input[@id='propertyNumber']"))
						.getAttribute("value").toString();

				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname") + " Failed";
					Utilities.ExtentFailReport1(methodname, Desc);
					Configuration.updatePropertyFile(Methodid, MethodName, "False");
				}

			}
			if (Keypress.contentEquals("EditAtAddress")) {
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='propertyNumber']")).clear();
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='propertyNumber']")).click();
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@id='propertyNumber']"))
						.sendKeys(Driver.getData("Number"));
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//a[@id='continue']")).click();

				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a[1]"))
						.click();

				Thread.sleep(800);

				String ver = Common_Property.driver.findElement(By.xpath("//input[@id='propertyNumber']"))
						.getAttribute("value").toString();

				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
					Utilities.ExtentPassReport(methodname);

				} else {

					String Desc = "For The customer agreement  " + Driver.getData("Documentname") + " Failed";
					Utilities.ExtentFailReport1(methodname, Desc);
					Configuration.updatePropertyFile(Methodid, MethodName, "False");
				}

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void FO_PersonalDetail() throws IOException, InterruptedException, FilloException {
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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By.linkText("Personal Details"))
					.click();
			Thread.sleep(1000);

			String Keypress = Driver.getData("VerificationData");

			if (Keypress.contentEquals("MobileNumber")) {

				Common_Property.driver.findElement(By.xpath("//input[@name='mobileNumber']")).clear();
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@name='mobileNumber']"))
						.sendKeys(Driver.getData("Number"));
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//form[@id='personalDetailsForm']/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input[2]"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
				Thread.sleep(1000);
				Common_Property.driver
				.findElement(By.linkText("Personal Details"))
				.click();
				Thread.sleep(1000);

				String ver = Common_Property.driver.findElement(By.xpath("//input[@name='mobileNumber']"))
						.getAttribute("value").toString();

				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Mobile Number has successfully updated";
					Utilities.ExtentPassReport(Desc);

				} else {

					String Desc = "Mobile Number has not successfully updated";
					Utilities.ExtentFailReport1(methodname, Desc);
					Configuration.updatePropertyFile(Methodid, MethodName, "False");
				}

			}
			if (Keypress.contentEquals("Email")) {
				WebElement element = Common_Property.driver
						.findElement(By.xpath("//div[@class='entry']/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]"));
				Common_Property.driver.findElement(By.xpath("//input[@name='emailAddress']")).clear();
				Thread.sleep(800);
				Common_Property.driver.findElement(By.xpath("//input[@name='emailAddress']"))
						.sendKeys(Driver.getData("Number"));
				Thread.sleep(1000);
				Common_Property.driver
						.findElement(By
								.xpath("//form[@id='personalDetailsForm']/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input[2]"))
						.click();
				Thread.sleep(1000);
				Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();

				Thread.sleep(1000);
				Common_Property.driver
				.findElement(By.linkText("Personal Details"))
				.click();
				Thread.sleep(1000);

				String ver = Common_Property.driver.findElement(By.xpath("//input[@name='emailAddress']"))
						.getAttribute("value").toString();

				if (ver.equalsIgnoreCase(Driver.getData("Documentname"))) {

					String Desc = "Email has successfully updated";
					Utilities.ExtentPassReport(Desc);

				} else {

					String Desc = "Email has not successfully updated";
					Utilities.ExtentFailReport1(methodname, Desc);
					Configuration.updatePropertyFile(Methodid, MethodName, "False");
				}
				

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

	// BARGAVI
	public static void FO_withdrawnotification() throws Exception {

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		fo_searchAgreement();

		// get start date
		// //*[@id="PanForm"]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[6]/td[4]
		String enterdate = Common_Property.driver
				.findElement(By
						.xpath("//div[@class='tabs'][2]//div[@class='contentNoMargin']/table[@class='entryTable']/tbody/tr/td/table/tbody/tr//td[text()='Start Date']/following-sibling::td[1]"))
				.getText();
		System.out.println(enterdate); // div[@class='tabs'][2]//div[@class='contentNoMargin']/table[@class='entryTable']/tbody/tr/td[1]//td[text()='Start
										// Date:']/following-sibling::td[1]
		Thread.sleep(1000);

		// click withdrawnaotifications
		Common_Property.driver
				.findElement(By.xpath("//table[@class='tableOfLinks']//a[text()='Withdrawal Notification']")).click();
		Thread.sleep(1000);
		// enter date
		String checktextbox = Common_Property.driver.findElement(By.id("withdrawalNotificationDate"))
				.getAttribute("type");
		if (checktextbox.equals("text")) {

			Common_Property.driver.findElement(By.id("withdrawalNotificationDate")).sendKeys(enterdate);
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.id("PanLinkSubmit")).click();
			;
			Thread.sleep(1000);

			// click withdrawnaotifications to verify
			Common_Property.driver
					.findElement(By
							.xpath("//div[@class='outercontent']/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[9]/td[2]/a"))
					.click();
			Thread.sleep(1000);

			String verifydate = Common_Property.driver
					.findElement(By.xpath("//table[@class='entryTable']/tbody/tr/td[2]")).getText();
			Thread.sleep(1000);

			if (enterdate.equals(verifydate)) {

				Utilities.ExtentPassReport("Agreement has withdrawed successfully");

			} else {

				String Desc = "Enter date is not equals to VerifyDate";
				Utilities.ExtentFailReport1(methodname, "Agreement has not withdrawed successfully");
				Configuration.updatePropertyFile(Methodid, MethodName, "False");
			}
			Common_Property.driver.findElement(By.id("PanLinkSubmit_0")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//a[text()='Documents']")).click();
			Thread.sleep(1000);
			String withdraw=Common_Property.driver.findElement(By.xpath("//*[@id='main']/div[2]")).getText();
			//System.out.println(withdraw);
			if(withdraw.contains("MOROW_Right_of_Withdrawal")){
				Utilities.ExtentPassReport("Right_of_ Document has generated");
			}
			else {

				String Desc = "Right_of_ Document has not generated";
				Utilities.ExtentFailReport1(methodname, "Agreement has not withdrawed successfully");
				Configuration.updatePropertyFile(Methodid, MethodName, "False");
			}
			
			
			

		}

	}

	// BARGAVI
	public static void FO_ddcashposting() throws Exception {

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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By
							.xpath("//form[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[6]/td/a"))
					.click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//td[@id='paymentMethodRadio']/p/input[3]")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='amount']"))
					.sendKeys(Driver.getData("temp_arg_value"));
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//a[text()='Take Card Payment']")).click();
			Thread.sleep(1000);

			// visa

			Common_Property.driver.findElement(By.xpath("//input[@name='op-DPChoose-VISA^SSL']")).click();
			Thread.sleep(2000);

			Common_Property.driver.findElement(By.xpath("//input[@id='cardNoInput']"))
					.sendKeys(Driver.getData("Card_Number"));
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@id='cardCVV']")).sendKeys(Driver.getData("CVC"));

			Select select = new Select(Common_Property.driver.findElement(By.xpath("//select[@name='cardExp.month']")));
			select.selectByValue(Driver.getData("Exp_Month"));

			select = new Select(Common_Property.driver.findElement(By.xpath("//select[@name='cardExp.year']")));
			select.selectByValue(Driver.getData("Exp_Year"));

			Common_Property.driver.findElement(By.xpath("//input[@id='name']"))
					.sendKeys(Driver.getData("Customer_Name"));
			Common_Property.driver.findElement(By.xpath("//input[@id='address1']"))
					.sendKeys(Driver.getData("Address1"));
			Common_Property.driver.findElement(By.xpath("//input[@id='town']")).sendKeys(Driver.getData("Town"));
			Common_Property.driver.findElement(By.xpath("//input[@id='postcode']"))
					.sendKeys(Driver.getData("Postal_Code"));

			select = new Select(Common_Property.driver.findElement(By.xpath("//select[@name='country']")));
			select.selectByVisibleText(Driver.getData("Country"));
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//input[@id='op-PMMakePayment']")).click();

			Thread.sleep(1000);
			select = new Select(Common_Property.driver.findElement(By.xpath("//select[@name='PaRes']")));
			select.selectByValue("AUTHORISED");

			select = new Select(Common_Property.driver.findElement(By.xpath("//select[@name='CVCRes']")));
			select.selectByVisibleText("Not sent to acquirer");

			select = new Select(Common_Property.driver.findElement(By.xpath("//select[@name='AVSRes']")));
			select.selectByVisibleText("Address matched; postcode not matched");

			Common_Property.driver.findElement(By.xpath("//input[@alt='Continue']")).click();
			Thread.sleep(3000);

			Common_Property.driver
					.findElement(By
							.xpath("//form[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/a"))
					.click();
			Thread.sleep(1000);

			String ver = Common_Property.driver
					.findElement(By.xpath("//div[@id='']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]")).getText()
					.toString();
			Thread.sleep(3000);
			if (ver.equalsIgnoreCase("Debit Card")) {

				String Desc = "Debit transaction done Successfully ";
				Utilities.ExtentPassReport(Desc);

			} else {

				String Desc = "Debit transaction Failed";
				Utilities.ExtentFailReport1(methodname, Desc);
				Configuration.updatePropertyFile(Methodid, MethodName, "False");

			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");

		}
	}

	// BARGAVI
	public static void FO_temporary_arrangement() throws Exception, InterruptedException {
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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.linkText("Temporary Arrangement")).click();
			// Common_Property.driver.get("href="/panCoreSaas/app?component=%24PanDirectLink_22&page=Collections%2FCOSummary&service=direct&session=T&sp=S10015"");

			Thread.sleep(1000);
			// tempary arrangement page

			Common_Property.driver.findElement(By.xpath("//input[@id='numberOfPayments']"))
					.sendKeys(Driver.getData("temp_terms"));
			Common_Property.driver.findElement(By.name("frequency")).click();
			Thread.sleep(1000);
			if(Driver.getData("Agreement_Number").startsWith("8")){
			Common_Property.driver.findElement(By.xpath("//option[@value='296']")).click();
			}
			else{
				Common_Property.driver.findElement(By.xpath("//option[@value='295']")).click();	
			}
			//Select select=new Select(element)

			Common_Property.driver.findElement(By.xpath("//input[@id='payment']"))
					.sendKeys(Driver.getData("temp_arg_value"));
			Thread.sleep(1000);
			// date

			String expected = Common_Property.driver.findElement(By.xpath("//input[@id='startDate']"))
					.getAttribute("value");

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
			Date convertedDate = dateFormat1.parse(expected);
			Calendar c = Calendar.getInstance();
			System.out.println(c);
			c.setTime(convertedDate);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			String target = dateFormat1.format(c.getTime());

			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).clear();
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).sendKeys(target);
			expected = Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).getAttribute("value");
			Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).click();
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//a[text()='Add']")).click();
			Thread.sleep(1000);

			String valdate = Common_Property.driver
					.findElement(By
							.xpath("//form[@id='temporaryArrangementForm']/div[2]/div[1]/table/tbody/tr/td[2]/div/div[3]/table/tbody/tr[2]/td[1]"))
					.getText();
			Thread.sleep(1000);

			if (expected.equalsIgnoreCase(valdate)) {

				String Desc = "temporary arrangement date falls on end of the month ";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "temporary arrangement date does not falls on end of the month ";
				Utilities.ExtentFailReport1(methodname, Desc);
				Configuration.updatePropertyFile(Methodid, MethodName, "False");
			}

			Common_Property.driver.findElement(By.xpath("//a[text()='Save']")).click();
			Thread.sleep(1000);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");

		}
	}

	public static void FO_POSTPAYMENT() throws IOException, InterruptedException, FilloException {
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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.linkText("Post Payment")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//td[@id='paymentMethodRadio']/p/input[1]")).click();
			Thread.sleep(1000);
			String installmentamt = Common_Property.driver
					.findElement(By.xpath("//form[@id='postForm']/div[2]/div[1]/div[1]/table/tbody/tr[4]/td[2]/p"))
					.getText().toString();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(installmentamt);
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='reference']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[text()='Post']")).click();
			Thread.sleep(1000);
			Common_Property.driver
					.findElement(By
							.xpath("//form[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/a"))
					.click();
			Thread.sleep(1000);
			String ver = Common_Property.driver
					.findElement(By.xpath("//*[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]")).getText()
					.toString();

			if (ver.equalsIgnoreCase("Cash")) {

				String Desc = "Successfully  " + Driver.getData("VerificationData") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "For The customer agreement  " + Driver.getData("VerificationData") + " Failed";
				Utilities.ExtentFailReport1(methodname, Desc);
				Configuration.updatePropertyFile(Methodid, MethodName, "False");
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

	// One-off Payment

	public static void FO_Oneoff_Payment() throws IOException, InterruptedException, FilloException {
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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(3000);
			CurrentBal = Common_Property.driver
					.findElement(By  
							.xpath("//*[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[8]/td[2]"))
					.getText().toString();
			Thread.sleep(3000);
			Common_Property.driver
					.findElement(By.linkText("Post Payment"))
					.click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//td[@id='paymentMethodRadio']/p/input[3]")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(CurrentBal);

			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//div[@class='pm-text']/span[text()='VISA']")).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(By.xpath("//input[@name='cardNumber']"))
					.sendKeys(Driver.getData("Card_Number"));
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@name='cardholderName']")).sendKeys("Referred");
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@name='securityCode']"))
					.sendKeys(Driver.getData("CVC"));
			
			Common_Property.driver.findElement(By.xpath("//*[@id='expiryMonth']")).sendKeys("05");

			Common_Property.driver.findElement(By.xpath("//*[@id='expiryYear']")).sendKeys("33");
			
			Common_Property.driver.findElement(By.xpath("//input[@name='billingAddress.line1']"))
					.sendKeys(Driver.getData("Address1"));
			Common_Property.driver.findElement(By.xpath("//input[@name='billingAddress.city']"))
					.sendKeys(Driver.getData("Town"));
			Common_Property.driver.findElement(By.xpath("//input[@name='billingAddress.postcode']"))
					.sendKeys(Driver.getData("Postal_Code"));
			
			Select select = new Select(
					Common_Property.driver.findElement(By.xpath("//select[@name='billingAddress.countryCode']")));
			select.selectByVisibleText("United Kingdom");
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
			Thread.sleep(1000);
			
			 Thread.sleep(5000);
			String ver = Common_Property.driver.findElement(By.xpath("//input[@value='Make Payment']")).getText()
					.toString();
			Thread.sleep(12000);
			

			if (ver.equalsIgnoreCase("Make Payment")) // TRUE
			{

				String Desc = "CPA Procdeure has been created";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "CPI Procdeure failed";
				Utilities.ExtentFailReport1(methodname, Desc);
				Configuration.updatePropertyFile(Methodid, MethodName, "False");
			}

			Common_Property.driver.findElement(By.xpath("//input[@value='Make Payment']")).click();
			Thread.sleep(40000);
			
			String event=Common_Property.driver
			.findElement(By.xpath("//table[@class='resultTable fixedTable']")).getText().toString();

			if (event.contains("One-off card payment")) {

				String Desc = methodname + "Successfully has Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = methodname + "Successfully has Failed";
				Utilities.ExtentFailReport1(methodname, Desc);
			}

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of " + methodname + " was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void FO_highamount_temparg() throws Exception, InterruptedException {
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
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(1000);

			// higher than installment amount
			String scheduleamt = Common_Property.driver
					.findElement(By
							.xpath("//form[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[9]/td[2]"))
					.getText();
			float result = Float.parseFloat(scheduleamt);
			float subtractamount = result + 5;
			String finalamt = String.valueOf(subtractamount);
			Thread.sleep(1000);

			// click temparvory agreement link
			Common_Property.driver.findElement(By.linkText("Temporary Arrangement")).click();
			Thread.sleep(1000);

			// tempary arrangement page

			Common_Property.driver.findElement(By.xpath("//input[@id='numberOfPayments']"))
					.sendKeys(Driver.getData("temp_terms"));
			
			Thread.sleep(1000);
			if(Driver.getData("Agreement_Number").startsWith("8")){
				Common_Property.driver.findElement(By.xpath("//option[@value='296']")).click();
				}
				else{
					Common_Property.driver.findElement(By.xpath("//option[@value='295']")).click();	
				}

			Common_Property.driver.findElement(By.xpath("//input[@id='payment']")).sendKeys(finalamt);
			Thread.sleep(1000);
			// date

			/*
			 * 
			 * Common_Property.driver.findElement(By.xpath(
			 * "//input[@id='startDate']")).sendKeys(Backoffice.systemdate);
			 * Thread.sleep(1000);
			 */

			String expected = Common_Property.driver.findElement(By.xpath("//input[@id='startDate']"))
					.getAttribute("value");

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-YYYY");
			Date convertedDate = dateFormat1.parse(expected);
			Calendar c = Calendar.getInstance();
			c.setTime(convertedDate);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			String target = dateFormat1.format(c.getTime());
			expected = target;
			Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).clear();
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//input[@id='startDate']")).sendKeys(target);
			Thread.sleep(1000);

			Common_Property.driver.findElement(By.xpath("//a[text()='Add']")).click();
			Thread.sleep(1000);

			String valdate = Common_Property.driver
					.findElement(By
							.xpath("//form[@id='temporaryArrangementForm']/div[2]/div[1]/table/tbody/tr/td[2]/div/div[3]/table/tbody/tr[2]/td[1]"))
					.getText();    
			Thread.sleep(1000);

			if (expected.equalsIgnoreCase(valdate)) {

				String Desc = "temporary arrangement date falls on end of the month ";
				Utilities.ExtentPassReport(methodname);

			} else {

				String Desc = "temporary arrangement date does not falls on end of the month ";
				Utilities.ExtentFailReport1(methodname, Desc);

			}
			Common_Property.driver.findElement(By.xpath("//a[text()='Save']")).click();
			Thread.sleep(1000);

		}

		catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");

		}
	}

	public static void CPA_Creation() throws IOException, InterruptedException, FilloException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			/*Common_Property.driver.findElement(By.xpath("//input[@id='agreementNumber']"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//a[text()='Continuous Authority']")).click();
			Thread.sleep(2000);*/
			fo_searchAgreement();
			Common_Property.driver.findElement(By.xpath("//a[text()='Continuous Authority']")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//a[text()='Enter New Card']")).click();
			Thread.sleep(2700);
			Common_Property.driver.findElement(By.xpath("//div[@class='pm-text']/span[text()='VISA']")).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(By.xpath("//input[@name='cardNumber']"))
					.sendKeys(Driver.getData("Card_Number"));
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@name='cardholderName']")).sendKeys("Referred");
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.xpath("//input[@name='securityCode']"))
					.sendKeys(Driver.getData("CVC"));
			// Select select = new
			// Select(Common_Property.driver.findElement(By.xpath("//select[@name='expiryDate.expiryMonth']")));
			// select.selectByValue("04");
			// select = new
			// Select(Common_Property.driver.findElement(By.xpath("//select[@name='expiryDate.expiryYear']")));
			// select.selectByValue("2036");
			Common_Property.driver.findElement(By.xpath("//*[@id='expiryMonth']")).sendKeys("05");

			Common_Property.driver.findElement(By.xpath("//*[@id='expiryYear']")).sendKeys("33");
			// Common_Property.driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Driver.getData("Customer_Name"));
			Common_Property.driver.findElement(By.xpath("//input[@name='billingAddress.line1']"))
					.sendKeys(Driver.getData("Address1"));
			Common_Property.driver.findElement(By.xpath("//input[@name='billingAddress.city']"))
					.sendKeys(Driver.getData("Town"));
			Common_Property.driver.findElement(By.xpath("//input[@name='billingAddress.postcode']"))
					.sendKeys(Driver.getData("Postal_Code"));
			/// *[@id="billingAddressCountry"]
			Select select = new Select(
					Common_Property.driver.findElement(By.xpath("//select[@name='billingAddress.countryCode']")));
			select.selectByVisibleText("United Kingdom");
			Thread.sleep(1000);
			Utilities.ExtentPassReport("Card details have been successfully saved");
			Common_Property.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
			Thread.sleep(1000);
			Common_Property.driver.findElement(By.xpath("//input[@value='Make Payment']")).click();
			Thread.sleep(15000);
			Utilities.ExtentPassReport("Card payment has done successfully saved");
			/*
			 * if(ver1.equals(vertestdata) &&
			 * ver2.equals(Driver.getData("Customer_Name")) ) //TRUE {
			 * 
			 * 
			 * String Desc="CPI Procdeure has been created";
			 * Utilities.ExtentPassReport(methodname);
			 * 
			 * } else {
			 * 
			 * 
			 * String Desc="CPI Procdeure failed";
			 * Utilities.ExtentFailReport1(methodname,Desc); }
			 */

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);

			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");

		}

	}

	public static void fo_searchAgreement() throws FilloException, InterruptedException {
		Thread.sleep(2000);
		Common_Property.driver.findElement(By.xpath("//input[@id='agreementNumber']"))
				.sendKeys(Driver.getData("Agreement_Number"));
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
		Thread.sleep(3000);
		Common_Property.driver.findElement(By.xpath("//a[@class='linkWithBullet']")).click();
		Thread.sleep(6000);
	}

	public static void Fo_refund() throws FilloException, InterruptedException, IOException {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);
		try {
			fo_searchAgreement();
			Common_Property.driver.findElement(By.linkText("Post Payment")).click();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.name("amount")).sendKeys("10");
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.name("reference")).sendKeys("1023");
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.linkText("Post")).click();
			Thread.sleep(5000);
			Common_Property.driver.findElement(By.linkText("Refund")).click();
			Thread.sleep(2000);
			Alert alert = Common_Property.driver.switchTo().alert();
			alert.accept();
			Thread.sleep(2000);
			Common_Property.driver.findElement(By.name("itemsToRefundRadioGroup")).click();
			Thread.sleep(2000);
			Utilities.ExtentPassReport("Refund has successfully done");
			Common_Property.driver.findElement(By.linkText("Refund")).click();

			// FO_PAYMENT();


		} catch (Exception e) {
			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Desc = "Test Run of " + methodname + " was not completed Sucessfully";
			Utilities.ExtentFailReport(methodname, e);
			Configuration.updatePropertyFile(Methodid, MethodName, "False");
		}
	}

}
