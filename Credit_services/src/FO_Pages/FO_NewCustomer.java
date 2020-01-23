package FO_Pages;

import org.openqa.selenium.By;

public class FO_NewCustomer {
	
	static By Surname = By.xpath("//input[@name='surname']");
	static By Forename = By.xpath("//input[@name='forename']");
	static By Postcode = By.xpath("//input[@name='postcode']");
	static By Customer_search = By.xpath("//*[@id='PanLinkSubmit']");
	static By Com_Continue = By.xpath("//div[@class='submitButtons']/a");
	static By Exisitng_customer = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td/a");
	static By LO_Close = By.xpath("//div[@class='submitButtons']/a[6]");

}
