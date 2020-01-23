package BO_Pages;

//import org.openqa.selenium.By;

public class BO_AgreementSearch {
	
	static By Openfile = By.xpath("//div[text()='Open']");
	static By AgreementServicing = By.xpath("html/body/div[4]/div/div[1]/div[1]");//html/body/div[6]/div/div[2]/div
	static By MaintainCustomerAgreement = By.xpath("html/body/div[5]/div/div[2]");
	static By BOAgreementNumber = By.xpath("html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/input");
	static By FindAgreement = By.xpath("html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div");
	static By Agreementdetails = By.xpath("//div[text()='Agreement Details']");
	
	//BO_Check Status
	
	static By Check_stat=By.xpath("//div[@tabindex='51']/input[@type='text']");

}
