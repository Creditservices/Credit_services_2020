package IKANO;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;

import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;

public class Front_Office extends Driver {
	
	public static void Accept_step() throws IOException, InterruptedException, FilloException 
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
					 
					 
					 
					 Thread.sleep(700);
					 Common_Property.driver.findElement(By.xpath("//input[@name='agreementNumber']")).sendKeys(Driver.getData("Agreement_Number")); 
					 Thread.sleep(700);
					 Common_Property.driver.findElement(By.xpath("//a[@id='PanLinkSubmit_0']")).click();
					 Thread.sleep(700);
					 JavascriptExecutor js1 = (JavascriptExecutor)Common_Property.driver;
					 js1.executeScript("window.scrollBy(0,500)");
					 Thread.sleep(1700);
					 WebElement ver=Common_Property.driver.findElement(By.xpath("//table/tbody/tr[2]/td/a"));
				        if(ver.isDisplayed()){
				        	Utilities.ExtentPassReport(methodname);
				        }
				        else
				    	{
				    		String Desc="Agreement is not in Referred status";
				    		Utilities.ExtentFailReport1(methodname,Desc);
				    	}
					 Common_Property.driver.findElement(By.xpath("//table/tbody/tr[2]/td/a")).click();
					 Thread.sleep(700);
					 JavascriptExecutor js2 = (JavascriptExecutor)Common_Property.driver;
					 js2.executeScript("window.scrollBy(0,1000)");
					 Common_Property.driver.findElement(By.xpath("//table[@class='detailTable']/tbody/tr/td[2]/a")).click();
					 Thread.sleep(700);
					 Common_Property.driver.findElement(By.xpath("//div[@class='content'][3]//div/a[1]")).click();
					 Thread.sleep(700);
					 Common_Property.driver.findElement(By.xpath("//div[@class='submitButtons']/a[3]")).click();
					 Thread.sleep(4000);
				 }
				 
				 catch (Exception e) 
					{
	  				
	  				System.out.println("The exception was "+e);
	  				System.out.println("Abnormal Termination due to "+e);
	  				String Desc="Test Run of"+methodname+"was not completed Sucessfully";
	  				Utilities.ExtentFailReport(methodname,e);
	  				Configuration.updatePropertyFile(Methodid,MethodName,"False");
	  				}
	   }
	

}
