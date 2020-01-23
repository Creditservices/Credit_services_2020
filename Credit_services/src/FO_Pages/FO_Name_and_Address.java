package FO_Pages;

import org.openqa.selenium.By;

public class FO_Name_and_Address {
	
	
	static By Title = By.xpath("//*[@id='title']");
	static By Marital_status = By.xpath("//*[@id='maritalStatus']");
	static By Gender = By.xpath("//*[@id='genderStatus']");
	static By property_number = By.xpath("//input[@id='propertyNumber']");
	static By property_name = By.xpath("//input[@id='propertyName']");
	static By StreetName = By.xpath("//input[@id='streetName']");
	static By PostalTown = By.xpath("//input[@id='postalTown']");
	static By County = By.xpath("//input[@id='county']");
	static By Moving_in_date = By.xpath("//input[@id='movingInDate']");
	static By Time_at_address1 = By.xpath("//input[@id='timeAtAddressYears']");
	static By Time_at_address2 = By.xpath("//*[@id='timeAtAddressMonthsComponent']");
	static By InsertEarlier = By.xpath("//*[@id='insertEarlier']");

}
