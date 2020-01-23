package Common_Funtions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
//import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
////import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;

import Common_POMs.POM_Repository;

//import com.codoid.products.fillo.Connection;
//import com.codoid.products.fillo.Fillo;


public class Common_Property extends Driver {
	public static WebDriver driver;
	public static FluentWait wait;
	public static String directory = System.getProperty("user.dir");
	public static java.sql.Connection SQLcon;
	public static Statement st,updateSt;
	public static PreparedStatement Pst,updatePst;
	
	public static ResultSet rs, rs1, rs3, rs4, rs5, rs6, rs2;

	public static int height = Integer.parseInt(Configuration.screenheight);
	public static int width = Integer.parseInt(Configuration.screenwidth);

	public static void IntiateBrowser() throws Exception

	{
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());	
		try {

			if (driver == null) {
                Configuration.updatePropertyFile(Methodid,MethodName,"True");
				System.setProperty("webdriver.chrome.driver", directory + "/Browsers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
			    options.setExperimentalOption("useAutomationExtension", false); 
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

                wait = new WebDriverWait(driver, 50)

                            .ignoring(StaleElementReferenceException.class)

                            .pollingEvery(2, TimeUnit.SECONDS);
				//Common_Property.driver.manage().window().setSize(new Dimension(height, width));
				Utilities.ExtentPassReport(MethodName);
			} else {
				Configuration.updatePropertyFile(Methodid,MethodName,"True");
				System.out.println("Driver already open,Continue the Execution");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			  Configuration.updatePropertyFile(Methodid,MethodName,"False");
			Utilities.ExtentFailReport(MethodName, e);

		}

	}

	public static void Launch_smf_Url() throws Exception {
		Driver.sheetflag = true;
		driver.get(Driver.getData("MotorfrontEnd"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);

	}

	public static void Startline_Login() throws Exception {

		Driver.sheetflag = true;
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(Driver.getData("API_Username"));
		Driver.sheetflag = true;
		driver.findElement(By.xpath("//input[@name='passWord']")).sendKeys(Driver.getData("API_Password"));
		Thread.sleep(750);
		driver.findElement(By.xpath("//div[@id='loginBody']/form/table[2]/tbody/tr/td[2]/a")).click();
	}

	public static void FO_Login() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {

			Driver.sheetflag = true;
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Driver.getData("FO_Username"));
			Driver.sheetflag = true;
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Driver.getData("FO_Password"));
			driver.findElement(By.xpath("//a[@id='PanLinkSubmit']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {

			Utilities.ExtentFailReport(methodname, e);
		}

	}

	public static void APILogin() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Driver.sheetflag = true;
			Common_Property.driver.findElement(By.xpath("//input[@name='username']"))
					.sendKeys(Driver.getData("API_Username"));
			Driver.sheetflag = true;
			Common_Property.driver.findElement(By.xpath("//input[@name='password']"))
					.sendKeys(Driver.getData("API_Password"));
			Common_Property.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);

		}

	}

	public static void Launch_Backoffice_Url() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Driver.sheetflag = true;
			driver.get(Driver.getData("BackOffice_Url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void Launch_FrontOffice_URL() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Driver.sheetflag = true;
			driver.get(Driver.getData("FrontOffice_URL"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
		}

		catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void Launch_API_Url() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			sheetflag = true;
			driver.get(Driver.getData("API_url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void Launch_ApplicationURL() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			sheetflag = true;
			//driver.get("https://provsys.pancredit.com/" + ProvidentAPI.ApplicationValue);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
		}

		catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);

		}
	}

	public static void BO_Login() throws Exception {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
            sheetflag=true;
			Common_Property.driver.get(Driver.getData("BackOffice_Url"));
			Common_Property.waitUntill(POM_Repository.BO_Edt_Username);
			sheetflag=true;
		    Common_Property.driver.findElement(POM_Repository.BO_Edt_Username).sendKeys(Driver.getData("BO_Username"));
		    sheetflag=true;
		    Common_Property.driver.findElement(POM_Repository.BO_Edt_Password1).sendKeys(Driver.getData("BO_Password"));
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

	public static String InsertQuery(String SheetName,ArrayList<String> UpdateFields, ArrayList<String> Insertarr)
			throws IOException, FilloException, InterruptedException

	{
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String InsQuery = null;
		try {

			
			InsQuery = "INSERT INTO " + SheetName + "(" +UpdateFields.get(0)+","+UpdateFields.get(1)+ ","+ UpdateFields.get(2)+")" + " VALUES (" + Insertarr.get(0)
			+ ",'" + Insertarr.get(1) + "','" + Insertarr.get(2) + "')";
			/*if (Agreement_Store.i == 0)
			{
				InsQuery = "INSERT INTO " + SheetName + "(Refno,Agreement_Number)" + " VALUES (" + Insertarr.get(0)
						+ "," + Insertarr.get(1) + ")";

			} else {

				InsQuery = "INSERT INTO " + SheetName + "(Refno,Agreement_Number,Misc)" + " VALUES (" + Insertarr.get(0)
						+ ",'" + Insertarr.get(1) + "','" + Insertarr.get(2) + "')";
				System.out.println(InsQuery);
			}*/

		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}
		return InsQuery;
	}

	public static String Updatesheet1(String SheetName, ArrayList<String> updatesheet1)
			throws IOException, FilloException, InterruptedException {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String strupdate = null;
		try {
			
			strupdate = "Update " + SheetName + " set Agreement_Number=" + updatesheet1.get(0) + ",Misc="
					+ updatesheet1.get(2) + " where put_ag_no =" + updatesheet1.get(1);

		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return strupdate;

	}

	public static String StrUpdateQuery(String SheetName, ArrayList UpdateFields, ArrayList Updatearr)
			throws IOException, FilloException, InterruptedException {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String UpdateQuery = null;
		System.out.println(UpdateFields.toString());

		try {
			System.out.println(Updatearr.size());
			switch (SheetName) {
			case "Sheet1":
				
				UpdateQuery = "Update " + SheetName + " Set " + UpdateFields.get(1) + "=" + Updatearr.get(1)
						+","+ UpdateFields.get(2) + "=" + Updatearr.get(2)
						+"  where " + UpdateFields.get(0) + "=" + Updatearr.get(0) + "";
				System.out.println(UpdateQuery);
				break;
			case "Sheet2": 
			{
				UpdateQuery = "Update " + SheetName + " Set " + UpdateFields.get(1) + "=" + "'" + Updatearr.get(1) + "'," 
						+ UpdateFields.get(2) + "=" + "'" + Updatearr.get(2)
						+ "' where " + UpdateFields.get(0) + "=" + Updatearr.get(0) + "";
			}
				
				/*if (Agreement_Store.i == 0)

				{
					UpdateQuery = "Update" + SheetName + "Set" + UpdateFields.get(2) + "=" + Updatearr.get(1)
							+ " where Refno =" + Updatearr.get(0);*/

				//} else {
					//UpdateQuery = "Update Sheet2 Set Agreement_Number=" + Updatearr.get(1) + " ,Misc=" + "'"
					//		+ Updatearr.get(2) + "'" + " where Refno =" + Updatearr.get(0) + "";
				}
					

		}

		catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return UpdateQuery;

	}

	@SuppressWarnings("rawtypes")
	public static String SelectQuery(String SheetName, ArrayList data,String method)
			throws IOException, FilloException, InterruptedException {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String strQuery = null;
		try{
			
		switch (method){
		
		case "Project_ToRun":
			 strQuery = "Select * from " + SheetName + " where Projects=" + data.get(0) + " and Run='Yes'";
			 break;
		case "ChooseKeywordSheet":
		case "updateKeywordSheet":
		case "Storequery1":
			 strQuery = "Select * from " + SheetName + " where Run='Yes'";
			 break;
				
		case "Mappingquery":
			 strQuery = "Select * from " + SheetName;
			 break;
		case "Store_Data":
			 strQuery = "Select * from " + SheetName;
			 break;
		case "Mapping":
			 strQuery = "Select * from " + SheetName;
			 break;
			 

       } 
	}
	catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

	return strQuery;

	}

	public static String SelectQ1(String Sheet, String Project,String method) throws IOException, FilloException, InterruptedException

	{
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String strQuery = null;
		try {
			strQuery = "Select * from " + Sheet + " where Run='Yes'";
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return strQuery;

	}

	public static String Storequery(String Sheet) throws IOException, FilloException, InterruptedException {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String storeqry = null;
		try {

			storeqry = "Select * from " + Sheet + " where Run='Yes'";
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return storeqry;

	}

	public static String Storequery1(String Sheet) throws IOException, FilloException, InterruptedException {

		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String storeqry = null;
		try {
			storeqry = "Select * from " + Sheet;
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return storeqry;

	}

	public static String Mappingquery(String Sheet) throws IOException, FilloException, InterruptedException {

		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String storeqry = null;
		try {
			storeqry = "Select * from " + Sheet;
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}
		return storeqry;

	}

	public static String Updatesheet1(String Sheet) throws IOException, FilloException, InterruptedException {

		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String storeqry = null;
		try {
			storeqry = "Select * from " + Sheet;
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return storeqry;

	}

	public static String getagrquery(String Sheet) throws IOException, FilloException, InterruptedException {

		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String getqry = null;
		String Control = "'" + "NO" + "'";

		try {
			getqry = "Select * from " + Sheet + " where Run=" + Control.toUpperCase();
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return getqry;

	}

	public static String loadCSVfile(String Sheet) throws IOException, FilloException, InterruptedException {
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		String storeqry = null;
		try {

			Driver.fillo.getConnection("D:/Repository/Pancredit/IKANO_Load_CSV.csv");
			// String load="select * from Sheet1 "
			storeqry = "Select * from " + Sheet + " where Run='Yes'";
		} catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

		return storeqry;

	}

	public static String DataClear() {
		System.out.println();
		return directory;
	}

	public static void InitiateallURL() {
		System.out.println();
	}

	public static void SqlConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Common_Property.SQLcon = DriverManager.getConnection("jdbc:oracle:thin:@linux03:1524:IKANOTST", "forte",
				"forte");
		Common_Property.st = Common_Property.SQLcon.createStatement();
		Common_Property.updateSt = Common_Property.SQLcon.createStatement();
	}
	@SuppressWarnings("unchecked")

    public static void waitUntill(By element){

          try{

                wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));

          }catch(Exception e){

                System.out.println("Exception occured while finding: "+element);

          }

         

    }

    @SuppressWarnings("unchecked")

    public static void waitUntillEnabled(By element){

          try{

                wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));

                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));

          }catch(Exception e){

                System.out.println("Exception occured while finding: "+element);

          }

    }
    
    public static boolean Spreadsheet_check()throws IOException
    {
    	String cashBookFileName = Configuration.Datapath + WhichClient + ".xlsx";
    	
    	FileOutputStream testOut=null;
        	try {
    	  testOut = new FileOutputStream(cashBookFileName);
    	   testOut.close();
    	   return true;
    	} catch (Exception e) {
    	   //e.printStackTrace();
    	   System.out.println("The TestData file: "
    	                   + cashBookFileName
    	                   + " is already open. Please close it before restarting this application.");
    	   Runtime.getRuntime().exec("taskkill /FI WINDOWTITLE eq OpenUniversity.xlsx - Excel /f");
    	   //testOut.close();
    	   return false;
    	}
    }
    //inserted for Startline
    public static void SMF_logout() throws Exception
	 {
		      
		driver.findElement(By.linkText("logout CHENNAI")).click();
	 			
	 }
	
    
    
}
