package Startline;
import Startline.POM_StartLine;
import Common_Funtions.Configuration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Common_Funtions.Common_Property;
import Common_Funtions.Driver;
import Common_Funtions.Configuration;
import Common_Funtions.*;


public class test extends Configuration{
	
	   public static void main(String[] args) throws IOException, InterruptedException 
	   {
		
		 
		   
		    System.setProperty("webdriver.chrome.driver", "D:/Repository/Credit_services/Browsers/chromedriver.exe");
		    WebDriver driver=new ChromeDriver();
		    driver.get("https://startline.dev.iocs-testing.com/iocs-web/startline/online/689b9cb4-b5d4-4a91-b23f-b4da381a18b5");
			Thread.sleep(750);
		  
		  
		
		driver.findElement(POM_StartLine.SMF_Esign_Selectdocumentbuton).click();
		Thread.sleep(750);
		 System.out.println(".//AutoIT//Fileupload.exe");
		 System.out.println(".//ExceldocAutoIT//ExcelFileupload.exe");
		 System.out.println("/AutoIT/Fileupload.exe");
		 System.out.println("ExceldocAutoIT/ExcelFileupload.exe");
		Runtime.getRuntime().exec("ExceldocAutoIT/ExcelFileupload.exe");
		//Runtime.getRuntime().exec(Configuration.PDFfileuploadpath);
		
	/*	@ScriptDir- return the path where the autoIT script exist and for this directory
	 *  files to be uploaded should be kept in the same location 
	 *  which is-    D:\Repository\Credit_services\ExceldocAutoIT
	 *               D:\Repository\Credit_services\AutoIT
	 *  
	
	 * 
	 * @WorkingDir-return the current working directory
	 * which is-     D:\Repository\Credit_services
	 * inside Credit_services PDF/Excel document can be placed at anywhere path needs to be
	 * included/added in the script.
	 * 
	 *   @WorkingDir & "\Documents\Print pre document.pdf
	 *   @ScriptDir & "\StartlineExcel.xlsx"
		
	*/
		Thread.sleep(750);
	}

	
	
}