package Test_Session1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Ses1 {
	
	
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	
	public static void main (String args[]){
		initiate_chrome();
	}
	
public static void initiate_chrome()
{
	

	System.out.println(System.setProperty("webdriver.chrome.driver",  "D:/Repository/Test/Browserdriver/chromedriver.exe"));
	driver =new ChromeDriver();
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://provsys.pancredit.com/panCoreSaas/app");




}

}
