package Common_POMs;

import org.openqa.selenium.By;

public class Backofficepom {
	
	//Login_Page
	
	
	static By MUsername = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/input");
	static By MPassword = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[4]/input");
	static By MLogin = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div");
	
	
	//Maintain Customer Agreement

	static By Openfile = By.xpath("//div[text()='Open']");
	static By AgreementServicing = By.xpath("html/body/div[4]/div/div[1]/div[1]");//html/body/div[6]/div/div[2]/div
	static By MaintainCustomerAgreement = By.xpath("html/body/div[5]/div/div[2]");
	static By BOAgreementNumber = By.xpath("html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/input");
	static By FindAgreement = By.xpath("html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div");
	static By Agreementdetails = By.xpath("//div[text()='Agreement Details']");
	
	//Back office Event check

	static By Events_but=By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[2]/div[2]");
	static By EventsFil_but=By.xpath("//div[text()='Filter']");
	static By Eventsname=By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div/div/div/div/div[4]/div[1]/input");
	static By Events_Activity=By.xpath("/html/body/div[11]/div[2]/div/div/div[1]/div/div/div/div/div[4]/div[1]/input");
	static By EventApfil=By.xpath("//div[text()='Apply Filter']");
	static By Event_close1=By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div[1]/div[6]");
	static By Event_close=By.xpath("/html/body/div[10]/div[3]/div[1]");
		
	//Back office Event check2

	static By Events_Activity1=By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div/div/div/div/div[4]/div[1]/input");
	static By Event_close2=By.xpath("/html/body/div[8]/div[3]/div[1]");
		
	//Back office Transaction

	static By Transaction_but=By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[2]/div[4]");
	static By Transaction_Filter=By.xpath("html/body/div[8]/div[2]/div/div/div[2]/div/div[2]/div[1]");
	static By Transaction_Type=By.xpath("html/body/div[9]/div[2]/div/div/div[1]/div/div/div[6]/div/div/div/div[9]/div[1]/input");
	static By Transaction_Apply_Filter=By.xpath("html/body/div[9]/div[3]/div[1]");
	static By Transaction_verify=By.xpath("html/body/div[8]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[12]");
	static By Transaction_OK=By.xpath("/html/body/div[8]/div[3]/div[1]");
	static By Transaction_Close=By.xpath("/html/body/div[8]/div[1]/div[1]/div[5]/div");
	
	//Settlement Quote
	static By Maintain_Set = By.xpath("//div[text()='Maintain']");
	static By Maintain_Settlement =By.xpath("//div[text()='Settlements']");
	static By Maintain_Settlement_quote =By.xpath("//div[text()='Settlement Quote']");
	static By Settlement_Save =By.xpath("/html/body/div[12]/div[3]/div[1]");
	static By Settlement_Close =By.xpath("//div[@tabindex='17']/div[text()='Close']");
	
	//Back office Notes

	static By Maintain = By.xpath("//div[text()='Maintain']");
	static By MaintainNotes = By.xpath("/html/body/div[8]/div/div[15]");
	static By Note_Context = By.xpath("/html/body/div[10]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div[2]");
	static By Note_Context1 = By.xpath("/html/body/div[10]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div[2]");
	static By Note_reason = By.xpath("/html/body/div[10]/div[2]/div/div/div[3]/div/div/div[2]/textarea");
	static By InsertNotes = By.xpath("/html/body/div[10]/div[2]/div/div/div[2]/div/div[2]/div[7]");
	static By SaveNotes = By.xpath("/html/body/div[10]/div[3]/div[1]");
	
	//Back office Customer Addresses

	static By Customerdetails = By.xpath("//div[text()='Customer Details']");
	static By Addresses= By.xpath("//div[text()='Addresses']");
	static By AddressDetails= By.xpath("/html/body/div[8]/div[2]/div/div/div/div[2]/div[3]");
	static By BO_Moving_date= By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div/div/div/div[2]/input");
	static By AddressOK= By.xpath("/html/body/div[9]/div[3]/div[1]");
	static By AddressOK1=By.xpath("/html/body/div[8]/div[3]/div[1]");
	
	//Back office Payment details Bank

	static By Paymentdetails = By.xpath("//div[text()='Payment Details']");
	static By SortcodeFilter = By.xpath("/html/body/div[8]/div[2]/div/div/div[3]/div/div[1]/div[4]/div[2]/div[2]");
	static By SortcodeNewsearch = By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div[2]/div/div[2]");
	static By Sortcode = By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[8]/div/input");
	static By SortcodeFind = By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div[2]/div/div[1]");
	static By SortcodeOK = By.xpath("/html/body/div[9]/div[3]/div[1]");
	static By SortcodeSave = By.xpath("/html/body/div[8]/div[3]/div[1]");
	
	
	//Back office Document verification

	static By Maintain_Document = By.xpath("//div[text()='Maintain']");
	static By Document_option = By.xpath("//div[text()='Documents']");
	static By Document_Request = By.xpath("//div[text()='Document Requests']");
	static By Document_Filter = By.xpath("//div[text()='Filter']");
	static By Document_name = By.xpath("/html/body/div[11]/div[2]/div/div/div[1]/div/div/div[6]/div/div/div/div[12]");
	static By Document_name_search = By.xpath("/html/body/div[12]/div[2]/div/div/div[2]/input");
	static By Document_OK = By.xpath("/html/body/div[12]/div[3]/div[1]");
	static By Document_Applyfilter = By.xpath("/html/body/div[11]/div[3]/div[1]");
	static By Document_Close = By.xpath("/html/body/div[10]/div[3]/div[1]");
	
	//BO Request Document

	static By Request_Document = By.xpath("//div[text()='Request Agreement Document']");
	static By Request_Document_Name = By.xpath("//div[@tabindex='4']/input");
	static By Request_Document_Continue = By.xpath("//div[@tabindex='8']/div");
	static By Request_Document_Req = By.xpath("/html/body/div[11]/div[2]/div/div/div/div/div[2]/div[2]/div[2]");
	static By Request_Document_Acc = By.xpath("/html/body/div[12]/div[3]/div[1]");
	static By Request_Document_OK = By.xpath("/html/body/div[12]/div[4]/div");
	static By Request_Document_Close = By.xpath("/html/body/div[11]/div[3]/div[1]");
	
	//BO_Customer Search

	static By Search_Customer = By.xpath("//div[text()='Search For Customer']");
	static By Customer_name = By.xpath("/html/body/div[7]/div[2]/div/div[1]/div[1]/div[1]/div/div/div[6]/div/div/div/div[2]/input");
	static By Find_Customer = By.xpath("//div[@tabindex='37']/div");
	static By Find_CustomerOK = By.xpath("/html/body/div[8]/div[4]/div");
	static By Find_postcode = By.xpath("/html/body/div[7]/div[2]/div/div[1]/div[1]/div[1]/div/div/div[6]/div/div/div/div[4]/input");
	static By Customer_OK = By.xpath("//div[@tabindex='43']/div");
	static By Customer_Cancel = By.xpath("//div[@tabindex='44']/div");
	
	//BO Telephone change

	static By Bo_Telephone = By.xpath("/html/body/div[7]/div[4]/div/div[2]/div[1]/div/div/div[8]/div/div/div[1]/div[3]/div[2]/div[1]/input");
	static By Save_Telephone_change = By.xpath("/html/body/div[7]/div[3]/div[2]");

	//BO Cash Posting

	static By cash_and_post=By.xpath("//html/body/div[4]/div/div[5]");
	static By cash_trans=By.xpath("//div[text()='Cash Transactions']");
	static By cash_post=By.xpath("//div[text()='Cash Posting']");
	static By Cashdate=By.xpath("//div[@tabindex='11']/input");
	static By ref=By.xpath("//div[@tabindex='12']/input");
	static By pay_dd=By.xpath("//div[@tabindex='13']/div[@tabindex='0']/div");
	static By payment_met=By.xpath("//html/body/div/div[1]/div[1]/div/div[2]/div[text()='Cash']");
	static By insert=By.xpath("//div[@tabindex='36']/div");
	static By identical=By.xpath("//html/body/div/div[4]");
	static By agree_num=By.xpath("//div[@tabindex='83']/input");
	static By agree_num1=By.xpath("//div[@tabindex='84']/div");
	static By agree_num2=By.xpath("//div[@tabindex='69']/div");
	static By paytype=By.xpath("//div[@tabindex='88']/div");
	static By paytype1=By.xpath("/html/body/div[8]/div[2]/div/div/div[2]/input");
	static By pay_ok=By.xpath("//html/body/div[8]/div[3]/div[1]");
	static By pay_BRT=By.xpath("//div[@tabindex='96']/div");
	static By pay_BRT1=By.xpath("/html/body/div[7]/div[2]/div/div/div[2]/input");
	static By pay_BRTOK=By.xpath("/html/body/div[7]/div[3]/div[1]");
	static By cp_amount=By.xpath("//div[@tabindex='89']/input");
	static By Apply_trans=By.xpath("//div[@tabindex='107']/div[text()='Apply Transaction']");
	static By Control_path=By.xpath("//div[@tabindex='15']/input");
	static By Batch_path=By.xpath("//div[@tabindex='14']/input");
	static By Post_but=By.xpath("//div[@tabindex='111']/div[text()='Post']");
	static By Amountpay_ok=By.xpath("//div[@tabindex='2']/div[text()='OK']");
	
	//BO_Arrear Tab

	static By Arrear_Tab =By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[8]");
	
	//BO Financial Tab

	static By Financial_detail =By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[6]");
	
	//BO_Check_Arrears

	static By Arrears_tab=By.xpath("//div[@tabindex='0']/div[text()='Arrears']");
	static By Arrears_amnt=By.xpath("//div[@tabindex='215']/div[2]/input");
	
	//BO_Total_Arrear

	static By Finance_tab=By.xpath("//div[@tabindex='0']/div[text()='Financial Details']");
	static By Total_repay_amnt=By.xpath("//div[@tabindex='146']/input");
	
	//BO Partial Settlement Notification

	static By Partial_Maintain=By.xpath("//div[text()='Maintain']");
	static By Partial_Notification=By.xpath("//div[text()='Partial Settlement Notification']");
	static By Partial_Insert=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[2]/div[1]");
	static By Partial_Insert1=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[1]/div[5]");
	static By Partial_Notification_date=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[1]/div[5]/input");
	static By Partial_Expiry_date=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[1]/div[5]/input");
	static By Partial_Expiry_date1=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[1]/div[6]/input");
	static By Partial_Amount=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[1]/div[7]/input");
	static By Partial_Amount1=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div[1]/div[7]/input");
	static By Partial_Save=By.xpath("/html/body/div[10]/div[3]/div[1]");	

	//BO Partial Settlement

	static By Bo_Partial_Settlement=By.xpath("//div[text()='Partial Settlement']");
	static By Partial_Reschedule_Quote=By.xpath("/html/body/div[10]/div[3]/div[1]");
	static By Partial_Reschedule_OK=By.xpath("/html/body/div[12]/div[4]/div");
	static By Partial_Lump_Sum=By.xpath("/html/body/div[11]/div[2]/div/div/div/div[1]/div/div[1]/div/div/div/div[17]/input");
	static By Partial_Ballon=By.xpath("/html/body/div[11]/div[2]/div/div/div/div[2]/div/div/div/div/div[14]/div[1]/input");
	static By Partial_Settlement_Insert=By.xpath("//div[text()='Insert Below']");
	static By Partial_Settlement_Number=By.xpath("/html/body/div[11]/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]");
	static By Partial_Settlement_Number1=By.xpath("/html/body/div[11]/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[1]/div[5]/input");
	static By Partial_Settlement_Amount=By.xpath("/html/body/div[11]/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[1]/div[7]/input");
	static By Partial_Settlement_date=By.xpath("/html/body/div[11]/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[1]/div[8]/input");
	static By Bo_Partial_Settlement_Cal=By.xpath("/html/body/div[11]/div[3]/div[1]");
	static By Bo_Partial_Settlement_Acc=By.xpath("/html/body/div[11]/div[3]/div[2]");
	static By Partial_Accept_OK=By.xpath("//div[@tabindex='8']/div[text()='OK']");
	static By Partial_Takeup=By.xpath("/html/body/div[11]/div[3]/div[4]");
	static By Partial_close=By.xpath("/html/body/div[10]/div[3]/div[2]");

	//BO View Schedules

	static By BO_Schedules=By.xpath("//div[text()='Schedules']");
	static By BO_Schedules_close=By.xpath("/html/body/div[9]/div[3]/div[1]");

	//BO Supress DD
	
	static By Bo_Paymentdetails = By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[2]/div[3]");
	static By Bo_paymenttype = By.xpath("/html/body/div[8]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[2]/div");
	static By Bo_Paymenttype1 = By.xpath("/html/body/div[9]/div/div[1]/div/div[6]/div");
	static By Bo_Paymenttype2 = By.xpath("/html/body/div[8]/div[2]/div/div/div[1]/div/div/div[2]/div[1]");
	static By Bo_Paymenttype3 = By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div/div[4]/div[2]/div[2]");
	static By Bo_Paymenttype4 = By.xpath("/html/body/div[10]/div/div[1]/div/div[3]/div");
	static By Bo_PaymenttypeOK = By.xpath("/html/body/div[9]/div[3]/div[1]");
	static By Bo_PaymenttypeSave = By.xpath("/html/body/div[8]/div[3]/div[1]");

	//BO_Check Transaction

	static By Tran_but=By.xpath("//div[@tabindex='254']/div[4]");
	static By Tran_type=By.xpath("//html/body/div[8]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[7]");
	//html/body/div[6]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[7]
	//html/body/div[8]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[7]
	static By Tran_close=By.xpath("//html/body/div[6]/div[3]/div[1]");
		                     
	//BO_Check Status
		
	static By Check_stat=By.xpath("//div[@tabindex='51']/input[@type='text']");
		
	//BO_Trigger_Date
		
	static By View_but=By.xpath("//div[text()='View']");
	static By Trigger_date=By.xpath("//div[text()='Trigger Dates']");
	static By Trigger_close=By.xpath("//div[@tabindex='8']/div[text()='Close']");
		
	//BO_Check_Document
		
	static By Document=By.xpath("//div[text()='Documents']");
	static By Doc_req=By.xpath("//div[text()='Document Requests']");
	static By Doc_filbut=By.xpath("//div[@tabindex='10']/div[text()='Filter']");
	static By Entr_Agr=By.xpath("//div[@tabindex='13']/input[@maxlength='30']");
    static By Doc_name=By.xpath("//div[@tabindex='16']/input[@maxlength='30']");
	static By Doc_aplfil=By.xpath("//div[text()='Apply Filter']");
	static By Doc_nameres=By.xpath("//div[@tabindex='8']/div[1]/div[1]/div[1]/div[5]");
	static By Doc_close=By.xpath("//div[@tabindex='23']/div[text()='Close']");
		
	//BO_Refund

	static By Refund_but=By.xpath("//div[text()='Refund']");
	static By Insert_but=By.xpath("//div[text()='Insert']");
	static By Ref_amnt=By.xpath("//div[@tabindex='8']/input[@maxlength='19']");
	static By but=By.xpath("//html/body/div[11]/div[4]/div");
	static By Ref_reas= By.xpath("//html/body/div[10]/div[2]/div/div/div[1]/div/div/div[20]/div[2]");
	static By Ref_reas1=By.xpath("//html/body/div[11]/div[2]/div/div/div[1]/div/div/div[20]/div[2]/div");
	static By Ref_reasel= By.xpath("//html/body/div[11]/div/div[1]/div/div[4]/div");
	static By Ref_reasel1= By.xpath("//html/body/div[12]/div/div[1]/div/div[4]/div");
	static By Ref_but= By.xpath("//div[@tabindex='63']/div[text()='Refund']");
	static By Ref_ok= By.xpath("//div[@tabindex='2']/div[text()='OK']");
	static By Ref_check= By.xpath("//div[@tabindex='7']/div/div[1]/div[1]/div[3]");
	static By Ref_close= By.xpath("//div[@tabindex='12']/div[text()='Close']");
		

	//BO_payment_detail

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
	
		//BACS_Queue
		static By BACS=By.xpath("//div[text()='BACS Queue Entry']");
		static By BACSEntry=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div[1]");
		static By BACSDelete=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[2]/div[5]");
		static By BACSDeleteYes=By.xpath("/html/body/div[10]/div[4]/div[1]");
		static By BACS_Close=By.xpath("//div[@tabindex='16']/div[text()='Close']");
		
		//Customer employment details
		static By Customer_employment =By.xpath("/html/body/div[7]/div[4]/div/div[2]/div[2]/div[4]");
		static By employment_details =By.xpath("/html/body/div[8]/div[2]/div/div/div[2]/div[3]");
		static By employment_telephone =By.xpath("/html/body/div[9]/div[2]/div/div/div[1]/div/div/div[4]/input");
		static By employment_telephone_OK =By.xpath("/html/body/div[9]/div[3]/div[1]"); 
		static By employment_telephone_Save =By.xpath("/html/body/div[8]/div[3]/div[1]");

		//Trigger
		static By BO_View = By.xpath("//div[text()='View']");
		static By View_Trigger = By.xpath("//div[text()='Trigger Dates']");
		static By Close_Trigger = By.xpath("/html/body/div[9]/div[3]/div[1]");
	
		//FAX Number
		static By Fax_Number=By.xpath("/html/body/div[7]/div[4]/div/div[2]/div[1]/div/div/div[8]/div/div/div[1]/div[3]/div[4]/input");

		
		//Back Office Logout

	static By Bo_Home_Button = By.xpath("//div[text()='File']");
	static By Bo_Logout_Button = By.xpath("//div[text()='Exit']");
	static By Submit_Logout_Button = By.xpath("//div[@tabindex='2']/div");
}
