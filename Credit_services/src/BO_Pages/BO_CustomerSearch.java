package BO_Pages;

import org.openqa.selenium.By;

public class BO_CustomerSearch {
	
	//BO_Customer Search

		static By Search_Customer = By.xpath("//div[text()='Search For Customer']");
		static By Customer_name = By.xpath("/html/body/div[7]/div[2]/div/div[1]/div[1]/div[1]/div/div/div[6]/div/div/div/div[2]/input");
		static By Find_Customer = By.xpath("//div[@tabindex='37']/div");
		static By Find_CustomerOK = By.xpath("/html/body/div[8]/div[4]/div");
		static By Find_postcode = By.xpath("/html/body/div[7]/div[2]/div/div[1]/div[1]/div[1]/div/div/div[6]/div/div/div/div[4]/input");
		static By Customer_OK = By.xpath("//div[@tabindex='43']/div");
		static By Customer_Cancel = By.xpath("//div[@tabindex='44']/div");
	
	//BO_Customer_address	
		
		static By Customerdetails = By.xpath("//div[text()='Customer Details']");
		static By Addresses= By.xpath("//div[text()='Addresses']");
		static By AddressDetails= By.xpath("/html/body/div[8]/div[2]/div/div/div/div[2]/div[3]");
		static By BO_Moving_date= By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div/div/div/div[2]/input");
		static By AddressOK= By.xpath("/html/body/div[9]/div[3]/div[1]");
		static By AddressOK1=By.xpath("/html/body/div[8]/div[3]/div[1]");
		
	//BO Telephone change

		static By Bo_Telephone = By.xpath("/html/body/div[7]/div[4]/div/div[2]/div[1]/div/div/div[8]/div/div/div[1]/div[3]/div[2]/div[1]/input");
		static By Save_Telephone_change = By.xpath("/html/body/div[7]/div[3]/div[2]");

	//BO_customer_employee_Telephone
		
		static By Customer_employment =By.xpath("/html/body/div[7]/div[4]/div/div[2]/div[2]/div[4]");
		static By employment_details =By.xpath("/html/body/div[8]/div[2]/div/div/div[2]/div[3]");
		static By employment_telephone =By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div/div/div[4]/input");
		static By employment_telephone_OK =By.xpath("/html/body/div[9]/div[3]/div[1]"); 
		static By employment_telephone_Save =By.xpath("/html/body/div[8]/div[3]/div[1]");

		
		
}
