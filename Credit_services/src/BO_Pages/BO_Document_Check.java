package BO_Pages;

import org.openqa.selenium.By;

public class BO_Document_Check {
	
	static By Document=By.xpath("//div[text()='Documents']");
	static By Doc_req=By.xpath("//div[text()='Document Requests']");
	static By Doc_filbut=By.xpath("//div[@tabindex='10']/div[text()='Filter']");
	static By Entr_Agr=By.xpath("//div[@tabindex='13']/input[@maxlength='30']");
    static By Doc_name=By.xpath("//div[@tabindex='16']/input[@maxlength='30']");
	static By Doc_aplfil=By.xpath("//div[text()='Apply Filter']");
	static By Doc_nameres=By.xpath("//div[@tabindex='8']/div[1]/div[1]/div[1]/div[5]");
	static By Doc_close=By.xpath("//div[@tabindex='23']/div[text()='Close']");

}
