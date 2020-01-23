package IKANO;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;

import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;

public class Login_Pages extends Driver {
	
	public static void Tesco_Login() throws Exception
	{
		 Common_Funtions.Configuration.getProperty();
		 
		// System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 Date sdate = new Date();
		 String datetimestart=dateFormat.format(sdate);

		try{
			
		Configuration.updatePropertyFile(Driver.Methodid,Driver.MethodName,"True");
		Driver.sheetflag=true;
		Common_Property.driver.get(Driver.getData("Tesco_web"));
		Driver.sheetflag=true;
		//Common_Property.driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Driver.getData("T_Username"));
		//Driver.sheetflag=true;
		Common_Property.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Driver.getData("T_Password"));
		Common_Property.driver.findElement(By.xpath("//div[4]/a[@id='formSubmit']")).click();
        Thread.sleep(2000);
        WebElement ver=Common_Property.driver.findElement(By.xpath("//h1[text()='Start Page']"));
        if(ver.isDisplayed()){
        	Utilities.ExtentPassReport(Driver.MethodName);
        }
        else
    	{
        	Configuration.updatePropertyFile(Driver.Methodid,Driver.MethodName,"True");
    		String Desc="Login page has not redirected to Start page";
    		Utilities.ExtentFailReport1(Driver.MethodName,Desc);
    	}
		
		}
		catch(Exception e){
			System.out.println("The exception was "+e);
			System.out.println("Abnormal Termination due to "+e);
			String Desc="Test Run of"+Driver.MethodName+"was not completed Sucessfully";
			Utilities.ExtentFailReport(Driver.MethodName,e);
			
		}
        
		
		
	}
	
	public static void Vision_Login() throws InterruptedException, FilloException, IOException
	{
		 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 Date sdate = new Date();
		 String datetimestart=dateFormat.format(sdate);
		 try{
			//Configuration.updatePropertyFile(Methodid,MethodName,"True");
			Driver.sheetflag=true;
			Common_Property.driver.get(Driver.getData("Vision_web"));
			Driver.sheetflag=true;
			//Common_Property.driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Driver.getData("V_Username"));
			//Driver.sheetflag=true;
			Common_Property.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Driver.getData("V_Password"));
			Common_Property.driver.findElement(By.xpath("//div[4]/a[@id='formSubmit']")).click();
		    Thread.sleep(2000);
		 }
		 catch(Exception e){
				System.out.println("The exception was "+e);
				System.out.println("Abnormal Termination due to "+e);
				String Desc="Test Run of"+methodname+"was not completed Sucessfully";
				Utilities.ExtentFailReport(methodname,e);
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
			}
		 
	}

	public static void Frontoffice_Login() throws InterruptedException, FilloException, IOException
	{
		 System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		 String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		 MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 Date sdate = new Date();
		 String datetimestart=dateFormat.format(sdate);
		 try{
		
			Driver.sheetflag=true;
			Common_Property.driver.get(Driver.getData("FrontOffice_Url"));
			Driver.sheetflag=true;
			 
			Common_Property.driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Driver.getData("FO_Username"));
			Driver.sheetflag=true;
			Common_Property.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Driver.getData("FO_Password"));
			Thread.sleep(500);
			WebElement ver=Common_Property.driver.findElement(By.xpath("//div[@id='titlebar']/span[2]"));
	        if(ver.isDisplayed()){
	        	Utilities.ExtentPassReport(methodname);
	        }
	        else
	    	{
	    		String Desc="Login page has not redirected to Start page";
	    		Utilities.ExtentFailReport1(methodname,Desc);
	    	}
			Common_Property.driver.findElement(By.xpath("//a[@type='submit']")).click();
		    Thread.sleep(2000);
		    
		 }
		 catch(Exception e){
				System.out.println("The exception was "+e);
				System.out.println("Abnormal Termination due to "+e);
				String Desc="Test Run of"+methodname+"was not completed Sucessfully";
				Utilities.ExtentFailReport(methodname,e);
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
			}
		 
	}
	
	public static void BO_Login() throws Exception
	{
	String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
	MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
	 Methodid = Long.toString(Thread.currentThread().getId());
	try{
	
		
		Common_Property.driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		Driver.sheetflag=true;
		Thread.sleep(1000);
		Common_Property.driver.get(Driver.getData("BackOffice_Url"));
		Thread.sleep(1000);
		Driver.sheetflag=true;
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(Driver.getData("BO_Username"));
		Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.sheetflag=true;
		Common_Property.driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/input")).sendKeys(Driver.getData("BO_Password"));
		Common_Property.driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(Keys.TAB);
		Common_Property.driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/input")).sendKeys(Keys.TAB);
		Common_Property.driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		Common_Property.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div")).click();
		WebDriverWait wait = new WebDriverWait(Common_Property.driver,10000);
		WebElement file=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Open']")));
		boolean check=file.isDisplayed();
		
	   if(check==true )
	   {
		   System.out.println("Home is displayed");
	   }
	   else
	   {
		 System.out.println("Driver didnot enter into the Homepage");  
	   }
	}
	catch (Exception e) {
		Utilities.ExtentFailReport(methodname,e);
		Configuration.updatePropertyFile(Methodid,MethodName,"False");
	}
		
	}
	
	

}
