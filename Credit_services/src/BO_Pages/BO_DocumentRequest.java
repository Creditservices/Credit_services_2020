package BO_Pages;

import org.openqa.selenium.By;

public class BO_DocumentRequest {
	
	
	static By Request_Document = By.xpath("//div[text()='Request Agreement Document']");
	static By Request_Document_Name = By.xpath("//div[@tabindex='4']/input");
	static By Request_Document_Continue = By.xpath("//div[@tabindex='8']/div");
	static By Request_Document_Req = By.xpath("/html/body/div[11]/div[2]/div/div/div/div/div[2]/div[2]/div[2]");
	static By Request_Document_Acc = By.xpath("/html/body/div[12]/div[3]/div[1]");
	static By Request_Document_OK = By.xpath("/html/body/div[12]/div[4]/div");
	static By Request_Document_Close = By.xpath("/html/body/div[11]/div[3]/div[1]");

}
