package Telefonica;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Common_Funtions.*;
import Common_POMs.*;

public class Backoffice {
	static String Settlementvalue=" ";
	static String EMI_STRING;
	static String Lastduedate; 
	static String Targetdate;
	static String currentdate;

	public static void BO_Login(Recordset recordSet) throws  Exception {
		String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			Common_Property.driver.get(recordSet.getField("BackOffice_Url"));
			Common_Property.waitUntill(POM_Repository.BO_Edt_Username);
		    Common_Property.driver.findElement(POM_Repository.BO_Edt_Username).sendKeys(recordSet.getField("BO_Username"));
		    Common_Property.driver.findElement(POM_Repository.BO_Edt_Password1).sendKeys(recordSet.getField("BO_Password"));
		    Common_Property.driver.findElement(POM_Repository.BO_Edt_Username).click();
		    Common_Property.driver.findElement(POM_Repository.BO_Edt_Password1).click();
		    Common_Property.waitUntill(POM_Repository.BO_Btn_Login);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_Login).click(); 
		    Utilities.ExtentPassReport(methodname);	
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		} 
    }
	
	public static void BO_Attributes(Recordset recordset, String awaitGoods, String delayGoods) throws IOException, FilloException, InterruptedException {
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			searchAgreement(recordset.getField("Agreement_Number"));
			Common_Property.waitUntill(POM_Repository.BO_AgreementDetails);
			Common_Property.driver.findElement(POM_Repository.BO_AgreementDetails).click(); 
			Common_Property.waitUntill(POM_Repository.BO_Btn_SelectAgrLevel);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_SelectAgrLevel).click();
			Common_Property.driver.findElement(POM_Repository.BO_Elm_InterestFreePdt).click();
			Common_Property.waitUntill(POM_Repository.BO_Maintain_OK);
			Common_Property.driver.findElement(POM_Repository.BO_Maintain_OK).click();
			//**maintain
			Thread.sleep(2000);
			Common_Property.waitUntill(POM_Repository.BO_Maintain);
			Common_Property.driver.findElement(POM_Repository.BO_Maintain).click();
			//**Additonal_Addributes
			Common_Property.waitUntill(POM_Repository.BO_AddAttributes);
			Common_Property.driver.findElement(POM_Repository.BO_AddAttributes).click();
			String attributes=Common_Property.driver.findElement(POM_Repository.BO_AttrAwaitGoods).getText().toString();
			String ver1= "";
			//**Check for blank await goods
			if (attributes.length()> 14) {
				ver1= attributes.substring(15, 16);
			}
			for(int i=0; i<4; i++) {
				Common_Property.driver.findElement(POM_Repository.BO_AttributesScrollDown).click();
			}
			String attributes1=Common_Property.driver.findElement(POM_Repository.BO_AttrDelayedGoods).getText().toString();
			String ver2= attributes1.substring(24, 25);	
	
			if(ver1.equalsIgnoreCase(awaitGoods)){
				if(ver2.equalsIgnoreCase(delayGoods)){
					Utilities.ExtentPassReport(methodname);	
				}else{
					Utilities.ExtentFailReport1(methodname,"Verification step failed");
				}
			}else{
				Utilities.ExtentFailReport1(methodname,"Verification step failed");
			}
			Common_Property.driver.findElement(POM_Repository.BO_AttributesCancel).click();
			closeMADwindow();
			 
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
		
	}
	public static void BO_Status_check(Recordset recordset, String status) throws IOException, FilloException, InterruptedException {	
		
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			searchAgreement(recordset.getField("Agreement_Number"));
			Common_Property.waitUntill(POM_Repository.BO_AgreementDetails);
			Common_Property.driver.findElement(POM_Repository.BO_AgreementDetails).click();
			Common_Property.waitUntill(POM_Repository.BO_Edt_AgrStatus);
			String ver =Common_Property.driver.findElement(POM_Repository.BO_Edt_AgrStatus).getAttribute("value");
			if(ver.equalsIgnoreCase(status)){
				Utilities.ExtentPassReport(methodname);	
			}else{
				Utilities.ExtentFailReport1(methodname,"Agreement status verification step failed");
			}
			closeMADwindow();   

		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}
	public static void BO_Nopayment_check(Recordset recordset) throws IOException, FilloException, InterruptedException {	
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			searchAgreement(recordset.getField("Agreement_Number"));
			Common_Property.waitUntill(POM_Repository.BO_AgreementDetails);
			Common_Property.driver.findElement(POM_Repository.BO_AgreementDetails).click();
			Common_Property.waitUntill(POM_Repository.BO_Edt_NumberOfPayments);
			String ver1 =Common_Property.driver.findElement(POM_Repository.BO_Edt_NumberOfPayments).getAttribute("value");
			String ver2 =Common_Property.driver.findElement(POM_Repository.BO_Edt_TermsInMonth).getAttribute("value");
			if(ver1.equalsIgnoreCase(recordset.getField("Numofpayments"))){
				if(ver2.equalsIgnoreCase(recordset.getField("TermInMonths"))){
					Utilities.ExtentPassReport(methodname);	
				}else{
					Utilities.ExtentFailReport1(methodname,"Terms in month verification step failed");
				}
			}else{
				Utilities.ExtentFailReport1(methodname,"Number of Payments verification step failed");
			} 
			closeMADwindow();
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}
	public static void BO_Firstduedate_check(Recordset recordset) throws IOException, FilloException, InterruptedException {	
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			searchAgreement(recordset.getField("Agreement_Number"));
			Common_Property.waitUntill(POM_Repository.BO_AgreementDetails);
			Common_Property.driver.findElement(POM_Repository.BO_AgreementDetails).click();
			Common_Property.waitUntill(POM_Repository.BO_Edt_FrstDueDate);
			String ver1 =Common_Property.driver.findElement(POM_Repository.BO_Edt_FrstDueDate).getAttribute("value");
			String ver2 =Common_Property.driver.findElement(POM_Repository.BO_Edt_EndDueDate).getAttribute("value");
			if(ver1.equalsIgnoreCase(recordset.getField("BO_FirstDueDate"))){
				if(ver2.equalsIgnoreCase(recordset.getField("BO_EndDueDate"))){
					Utilities.ExtentPassReport(methodname);	
				}else{
					Utilities.ExtentFailReport1(methodname,"End due date verification step failed");
				}	
			}else{
				Utilities.ExtentFailReport1(methodname,"First due date verification step failed");
			}
			closeMADwindow();
	 
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}
	public static void BO_Installmentamt_check(Recordset recordset) throws IOException, FilloException, InterruptedException{	
		
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			searchAgreement(recordset.getField("Agreement_Number"));
			Common_Property.waitUntill(POM_Repository.BO_AgreementDetails);
			Common_Property.driver.findElement(POM_Repository.BO_AgreementDetails).click();
			Common_Property.waitUntill(POM_Repository.BO_Btn_View);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_View).click();
			//**scheudle
			Common_Property.waitUntill(POM_Repository.BO_Btn_Schedules);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_Schedules).click();
			
			String Firstduedate =recordset.getField("BO_FirstDueDate");
			String Endduedate =recordset.getField("BO_EndDueDate");
			
			Common_Property.waitUntill(By.xpath("//div[text()='"+Firstduedate+"']//following-sibling::div[1]"));
			String ver1= Common_Property.driver.findElement(By.xpath("//div[text()='"+Firstduedate+"']//following-sibling::div[1]")).getText().toString();
			for(int i=0;i<=20;i++){
				Common_Property.driver.findElement(POM_Repository.BO_InstaAmountScrollDown).click();
			}

			String ver2 = Common_Property.driver.findElement(By.xpath("(//div[text()='"+Endduedate+"'])[2]//following-sibling::div[1]")).getText().toString();
			 
			if(ver1.equalsIgnoreCase(recordset.getField("BO_FrstInstAmnt"))){
				if(ver2.equalsIgnoreCase(recordset.getField("BO_LastInstAmnt"))){
					Utilities.ExtentPassReport(methodname);	
				}else{
					Utilities.ExtentFailReport1(methodname,"Last Installment amount verification step failed");
				}
			}else{
				Utilities.ExtentFailReport1(methodname,"First Installment amount verification step failed");
			}
			
			Common_Property.driver.findElement(POM_Repository.BO_Btn_SchedulesClose).click();
			closeMADwindow();
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}
	
	
	public static void BO_Securities_check(Recordset recordset, boolean equipmentScheduleRun) throws IOException, FilloException, InterruptedException{	
		
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			searchAgreement(recordset.getField("Agreement_Number"));
			Common_Property.waitUntill(POM_Repository.BO_AgreementDetails);
			Common_Property.driver.findElement(POM_Repository.BO_AgreementDetails).click();
			Thread.sleep(2000);
			Common_Property.waitUntill(POM_Repository.BO_Maintain);
			Common_Property.driver.findElement(POM_Repository.BO_Maintain).click();
			Common_Property.waitUntill(POM_Repository.BO_Securities1);
			Common_Property.driver.findElement(POM_Repository.BO_Securities1).click();
			Common_Property.waitUntill(POM_Repository.BO_Securities2);
			Common_Property.driver.findElement(POM_Repository.BO_Securities2).click();
			Common_Property.waitUntill(POM_Repository.BO_Txt_Hardware);
			Common_Property.driver.findElement(POM_Repository.BO_Txt_Hardware).click();
			Common_Property.waitUntill(POM_Repository.BO_Btn_HardwareDetails);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_HardwareDetails).click();
			Common_Property.waitUntill(POM_Repository.BO_Edt_Identifier);
			String ver1= Common_Property.driver.findElement(POM_Repository.BO_Edt_Identifier).getAttribute("value");
			String ver2= Common_Property.driver.findElement(POM_Repository.BO_Edt_Agreementr).getAttribute("value");
			String ver3= Common_Property.driver.findElement(POM_Repository.BO_Edt_Classification).getAttribute("value");
			String ver4= Common_Property.driver.findElement(POM_Repository.BO_Edt_SecurityType).getAttribute("value");
			String ver5= Common_Property.driver.findElement(POM_Repository.BO_Edt_TotalCashPrice).getAttribute("value");
			String ver6= Common_Property.driver.findElement(POM_Repository.BO_Edt_Supplier).getAttribute("value");
			String ver7= Common_Property.driver.findElement(POM_Repository.BO_Edt_DeliveryDate).getAttribute("value");
			
			if(ver1.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Identifier verification step failed");	
			}else if(ver2.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Agreement number verification step failed");
			}else if(ver3.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Classification verification step failed");
			}else if(ver4.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Security Type verification step failed");
			}else if(ver5.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Total Cash Price verification step failed");
			}else if(ver6.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Supplier verification step failed");
			}else if(ver7.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Delivery Date verification step failed");
			}else {
				Utilities.ExtentPassReport(methodname);
			}
			if (equipmentScheduleRun) {
				BO_EquipmentSchdule(recordset);
			}
			Common_Property.waitUntillEnabled(POM_Repository.BO_Btn_SecuritiesCancel);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_SecuritiesCancel).click();
			Common_Property.waitUntillEnabled(POM_Repository.BO_Btn_SecuritiesClose);
			Actions action = new Actions(Common_Property.driver);
			action.moveToElement(Common_Property.driver.findElement(POM_Repository.BO_Btn_SecuritiesClose)).click().perform();
			closeMADwindow();
			
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}
	
	public static void BO_EquipmentSchdule(Recordset recordset) throws IOException, FilloException, InterruptedException{	
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			Common_Property.waitUntill(POM_Repository.BO_Btn_EquipmentScheldule);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_EquipmentScheldule).click();
			Common_Property.waitUntill(POM_Repository.BO_EquipScheduleSideArrow);
			String ver1= Common_Property.driver.findElement(POM_Repository.BO_EquipScheduleQuantity).getText().toString();
			String ver2= Common_Property.driver.findElement(POM_Repository.BO_EquipScheduleCost).getText().toString();
			String ver3= Common_Property.driver.findElement(POM_Repository.BO_EquipScheduleResValue).getText().toString();
			if(ver1.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Quantity verification step failed in Equipment Schedule window");	
			}else if(ver2.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Cost verification step failed in Equipment Schedule window");
			}else if(ver3.isEmpty()){
				Utilities.ExtentFailReport1(methodname,"Residual value verification step failed in Equipment Schedule window");
			}else {
				Utilities.ExtentPassReport(methodname);
			}
			if (Common_Property.driver.findElement(POM_Repository.BO_Btn_InsertChild).isEnabled()) {
				if (!Common_Property.driver.findElement(POM_Repository.BO_Btn_EqScheduleDetails).isEnabled()) {
					Utilities.ExtentFailReport1(methodname,"Details button verification failed in Equipment Schedule window");
				}
			}else{
				Utilities.ExtentFailReport1(methodname,"Insert child button verification failed in Equipment Schedule window");
			}
			String desc = recordset.getField("HardWareDesc");
			String chasisNum = recordset.getField("Misc");
			chasisNum = chasisNum.substring(0,chasisNum.length()-2);
			Common_Property.driver.findElement(POM_Repository.BO_EquipScheduleSideArrow).click();
			//***Hardware count check
			for (int i = 1; i <= Integer.parseInt(recordset.getField("HrdwareCount")); i++) {
				if (Common_Property.driver.findElement(By.xpath("(//div[text()='"+desc+"'])["+i+"]")).isDisplayed()) {
					if (!Common_Property.driver.findElement(By.xpath("(//div[contains(text(),'"+chasisNum+"')])["+i+"]")).isDisplayed()) {
						Utilities.ExtentFailReport1(methodname,"Hardware description verification failed in Equipment Schedule window");
						break;
					}
				}else{
					Utilities.ExtentFailReport1(methodname,"Chasis number verification failed in Equipment Schedule window");
					break;
				}
			}
			Common_Property.waitUntillEnabled(POM_Repository.BO_Btn_EqScheduleCancel);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_EqScheduleCancel).click();
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void BO_Pay_check(Recordset recordset) throws IOException, FilloException, InterruptedException{	
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			//NAVIGATION
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Common_Property.driver.findElement(By.xpath("html/body/div[4]/div/div[5]")).click();
			Common_Property.driver.findElement(By.xpath("html/body/div[6]/div/div[3]")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div")).click();
			//MAINTAIN CUSTOMER AGREEMENT
			Common_Property.driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[2]/div[1]/div")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/div/div[1]/div/div/div/div[6]/div[1]/input")).sendKeys("PROPOSALS");
			Common_Property.driver.findElement(By.xpath("//div[text()='Apply Filter']")).click();
			String ver =Common_Property.driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div[1]/div[15]")).getText().toString();
			System.out.println(ver);
			if(ver.equalsIgnoreCase(currentdate)){
				Utilities.ExtentPassReport(methodname);	
			}else{
				Utilities.ExtentFailReport1(methodname,"Verification step failed");
			}
			//Close MAD Window
			Common_Property.driver.findElement(By.xpath("html/body/div[7]")).sendKeys(Keys.ESCAPE);
			Common_Property.driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div")).click();
		}catch (Exception e) {
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);

		}
	}
	public static void Batchrun(Recordset recordset) throws IOException, FilloException, InterruptedException{	
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			//NAVIGATION
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	        currentdate=Common_Property.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div")).getText().toString();
		    System.out.println(currentdate);
		    String dt = currentdate;  // Start date
		    Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));
			c.add(Calendar.DATE, 7);  // number of days to add 1
			dt = sdf.format(c.getTime()); 
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[1]/div[4]/div[1]/div")).click();//submit
			Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div[2]/div[1]/input")).sendKeys("Overnight Group Excluding Extracts");
			Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div[4]/div[1]/div[1]/input")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/div/div[3]/div")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div[6]/div[2]/div")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div[12]/input")).sendKeys(dt);
			Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[1]/div")).click();
			//click refresh                        
			Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[4]/div[2]/div[1]")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[4]/div")).click();
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div")).click();
			Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[4]/div")).click();
			String Systemdt = Common_Property.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div")).getText().toString();
		    System.out.println(Systemdt);
			if (Systemdt.equals(dt)){
				Utilities.ExtentPassReport(methodname);	
			}else{
				Utilities.ExtentFailReport1(methodname,"Verification step failed");
			}
			Common_Property.driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[4]/div")).click();
		} catch (Exception e){
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
		
	}
	
	public static void closeMADwindow() throws IOException, FilloException, InterruptedException{
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try{
			Thread.sleep(3000);
			Common_Property.waitUntill(POM_Repository.BO_Elm7);
			Common_Property.driver.findElement(POM_Repository.BO_Elm7).sendKeys(Keys.ESCAPE);
			Thread.sleep(2000);
			Common_Property.waitUntillEnabled(POM_Repository.BO_AgrSearchClose);
			Common_Property.driver.findElement(POM_Repository.BO_AgrSearchClose).click();
			
		} catch (Exception e){
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
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
			Common_Property.waitUntillEnabled(POM_Repository.BO_Btn_Find);
			Common_Property.driver.findElement(POM_Repository.BO_Btn_Find).click();
		} catch (Exception e){
			System.out.println("The exception was "+e);
			Configuration.updatePropertyFile("Project", "Startexecuted", "False");
			Utilities.ExtentFailReport(methodname, e);
		}
	}
}
	