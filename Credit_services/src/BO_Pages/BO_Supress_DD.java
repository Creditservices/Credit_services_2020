package BO_Pages;

import org.openqa.selenium.By;

public class BO_Supress_DD {
	
	static By Bo_Paymentdetails = By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[2]/div[3]");
	static By Bo_paymenttype = By.xpath("/html/body/div[8]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[2]/div");
	static By Bo_Paymenttype1 = By.xpath("/html/body/div[9]/div/div[1]/div/div[6]/div");
	static By Bo_Paymenttype2 = By.xpath("/html/body/div[8]/div[2]/div/div/div[1]/div/div/div[2]/div[1]");
	static By Bo_Paymenttype3 = By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div/div[4]/div[2]/div[2]");
	static By Bo_Paymenttype4 = By.xpath("/html/body/div[10]/div/div[1]/div/div[3]/div");
	static By Bo_PaymenttypeOK = By.xpath("/html/body/div[9]/div[3]/div[1]");
	static By Bo_PaymenttypeSave = By.xpath("/html/body/div[8]/div[3]/div[1]");
	
	//unsupress DD
	
	static By Payment_detail_but=By.xpath("//div[@tabindex='257']/div[text()='Payment Details']");
	static By Unsuppressed_but=By.xpath("//div[@tabindex='28']/div[text()='Unsuppress Direct Debit']");
	static By Payment_savebut=By.xpath("//div[@tabindex='78']/div[text()='Save']");
	static By suppressed_but=By.xpath("//div[@tabindex='27']/div[text()='Suppress Direct Debit']");
		
	static By Entr_Agrno=By.xpath("//div[@tabindex='4']/div/div/div[1]/div[2]/input");
	static By Findbut=By.xpath("//div[@tabindex='4']/div/div/div[1]/div[3]");
	static By Agr_detbut=By.xpath("//div[@tabindex='4']/div/div/div[3]/div[2]");
	static By Mad_filebut=By.xpath("//div[@tabindex='1']/div[2]/div[1]/div[text()='File']");
		
	static By Open=By.xpath("//div[text()='Open']");
	static By Agr_ser=By.xpath("//html/body/div[4]/div/div[1]/div[1]");
	static By Matn_ser=By.xpath("//div[text()='Maintain Customer Agreements']");



}
