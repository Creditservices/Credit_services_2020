package BO_Pages;

import org.openqa.selenium.By;

public class BO_Temporary_Arrangement {
	
	static By Arrangement=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements']");
	static By Temp_Arrange=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Temporary ']");
	static By Insert_Below=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.insertBelow']");
	static By Insert_Amount=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]");
	static By Schedule_amount=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofRepayment']/div/div/div[2]/div[4]");
    static By Final_amount=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[6]");
    static By Build_profile=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']");
    static By view_amount=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/div/div/div/div[7]");
    static By profile_amount=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[3]");
    static By Arrange_ok=By.xpath("//div[@name='TemporaryArrangementWindow.pbOK']");


}
