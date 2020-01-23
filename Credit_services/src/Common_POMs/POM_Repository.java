package Common_POMs;

import org.openqa.selenium.By;

public class POM_Repository {
	//Back office
	public static By BO_Edt_Username = By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/input");
	public static By BO_Edt_Password = By.xpath("//input[@name='password']");
	public static By BO_Btn_Login = By.xpath("//div[contains(@style,'cursor: pointer;') and div='Login']");
	public static By BO_Edt_Password1 = By.xpath("//input[@type='password']");
	//Back office//
    //NAVIGATION
    public static By BO_Open=By.xpath("//div[text()='Open']");
    public static By BO_Servicing=By.xpath("//div[@name='MainUI.Open.Agreement Servicing']");
    public static By BO_Agreements=By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']");
    public static By BO_MaintainCustAgr=By.xpath("//div[text()='Maintain Customer Agreements']");
    public static By BO_Elm_Nav=By.xpath("html/body/div[5]/div/div[2]/div");
    //MAINTAIN CUSTOMER AGREEMENT
    public static By BO_CA_dfAgreementNumber=By.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']");
    public static By BO_CA_pbFind=By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']");
    public static By BO_CView_pbDetails=By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindCustomersForAgreementsView.pbDetails']");
    public static By BO_CA_pbDetails=By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails']");
    public static By BO_CA_Maintain=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain']");
    public static By BO_CA_Reschedules=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reschedules']");
    public static By BO_CA_Duedate=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Maintain Next Due Date']");
    public static By BO_CA_Docs=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Documents']");
    public static By BO_CA_DocReq=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Document Requests']");
    public static By BO_CA_Filter=By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbFilter']");
    public static By BO_CA_Name=By.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfName']");
    public static By BO_EmailAddr=By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfEmailAddress']");
    public static By BO_CA_File=By.xpath("//div[@name='CustomerWindow.File']");
    public static By BO_CA_FileSave=By.xpath("//div[@name='CustomerWindow.File.Save']");
    public static By BO_CA_FileClose=By.xpath("//div[@name='CustomerWindow.File.Close']");
    
    //Address
    public static By BO_MobNum=By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfMobileNumber']");
    public static By BO_pbQuickAddress=By.xpath("//div[@name='CustomerWindow.cmCombinedCorrespondenceView.pbQuickAddress']");
    public static By BO_pbDetails=By.xpath("//div[@name='HabitationsSelectionWindow.pbDetails']");
    public static By BO_dfPropNum=By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPropertyNumber']");
    public static By BO_AddrPbOK=By.xpath("//div[@name='HabitationsDetailsWindow.pbOK']");
    public static By BO_AddrPbOK1=By.xpath("//div[@name='HabitationsSelectionWindow.pbOK']");
    public static By BO_CW_PropNum=By.xpath("//input[@name='CustomerWindow.cmCombinedCorrespondenceView.dfPropertyNumber']");
    
    //New at address
    public static By BO_pbInsert=By.xpath("//div[@name='HabitationsSelectionWindow.pbInsert']");
    public static By BO_updateStatus=By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPostCode']");
    public static By BO_StreetName=By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfStreetName']");
    public static By BO_District=By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfDistrict']");
    public static By BO_PostalTown=By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfPostalTown']");
    public static By BO_County=By.xpath("//input[@name='HabitationsDetailsWindow.AddressPanel.dfCounty']");
    public static By BO_MovingInDate=By.xpath("//input[@name='HabitationsDetailsWindow.HabitationsTenancyView.dfMovingInDate']");
    
    
    //PATH-CHANGE EXECUTION
    public static By BO_EX_Datetype=By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']");
    public static By BO_DL_Datetype=By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']");
    public static By BO_DL_Duedate=By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']");
    public static By BO_DL_DLDuedate=By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']");
    public static By BO_DL_DLDuedate1=By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']");
    public static By BO_DL_DLDuedate2=By.xpath("//div[@name='DueDateWindow.DueDateView.dlDueDateType']");
    public static By BO_DF_BDuedate=By.xpath("//input[@name='DueDateWindow.DueDateView.dfMaximumBackwardsDueDate']");     
    public static By BO_DF_NewDuedate=By.xpath("//input[@name='DueDateWindow.DueDateView.dfNewNextDueDate']");
    public static By BO_WD_File=By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']");
    public static By BO_WD_Close=By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']");
    public static By BO_WD_Open=By.xpath("//div[text()='Open']");
    public static By BO_AG_Servicing=By.xpath("//div[@name='MainUI.Open.Agreement Servicing']");
    public static By BO_CU_Agreements=By.xpath("//div[@name='MainUI.Open.Maintain Customer Agreements']");

    //MAINTAIN CUSTOMER AGREEMENT
    public static By BO_CA_DFAgreementNumber=By.xpath("//input[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber']");
    public static By BO_CA_PBFind=By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind']");
    public static By BO_CA_PBDetails=By.xpath("//div[@name='FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails");

	//TEMPORARY ARRANGEMENT NAVIGATION
    
    public static By BO_AN_Agreements=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements");
    public static By BO_AN_Temporary=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Temporary ']");
    public static By BO_AN_Insertbelow=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.insertBelow']");
    public static By BO_AN_S6=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]");
    public static By BO_AN_GFArray=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[6]/child::input[1]");
    public static By BO_AN_PBProfile=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.pbBuildProfile']");
    public static By BO_AN_s3=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[3]");
    public static By BO_AN_PBok=By.xpath("//div[@name='TemporaryArrangementWindow.pbOK']");
    public static By BO_AN_PBCancel=By.xpath("//div[@name='FindCustomersAndAgreementsWindow.pbCancel']");
		
	 //NAVIGATION
    public static By BO_NGT_Production=By.xpath("//div[@name='MainUI.Open.Document Production']");
    public static By BO_NGT_Docreq=By.xpath("//div[@name='MainUI.Open.View Document Requests']");
    public static By BO_NGT_PBFliter=By.xpath("//div[@name='DocumentRequestWindow.DocumentRequestView.pbFilter']");
    public static By BO_NGT_Dfagreementnumber=By.xpath("//input[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.dfAgreementNumber']");
    public static By BO_NGT_PBdocreqname=By.xpath("//div[@name='FilterDocumentRequestsWindow.FilterDocumentRequestsGeneralTabView.pbDocumentRequestName']");
    public static By BO_NGT_DfcriteriaEntry=By.xpath("//input[@name='DocumentSearchWindow.dfCriteriaEntry']");
    public static By BO_NGT_Docpbok=By.xpath("//div[@name='DocumentSearchWindow.pbOK']");
    public static By BO_NGT_Filterpbok=By.xpath("//div[@name='FilterDocumentRequestsWindow.pbOK']");
    public static By BO_NGT_Welpack=By.xpath("//div[text()='Welcome Pack']");
    public static By BO_NGT_Docpbdetails=By.xpath("//div[@name='DocumentRequestWindow.DocumentRequestView.pbDetails']");
    
    public static By BO_Btn_OK=By.xpath("//div[@name='DueDateWindow.pbOK']");
    public static By BO_Btn_OK1=By.xpath("//div[@name='DueDateAcceptWindow.pbOK']");
    public static By BO_NxtDueDate=By.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfNextDueDate']");
    public static By BO_DocReq_OK=By.xpath("//div[@name='DocumentRequestDetailWindow.pbOK']");
    public static By BO_DocReq_Cancel=By.xpath("//div[@name='DocumentRequestWindow.pbCancel']");
    public static By BO_StopCategSearch_OK=By.xpath("//div[@name='StopCategorySimpleSearchWindow.pbOK']");
    public static By BO_Maintain_File=By.xpath("//div[@name='MaintainAgreementDetailsWindow.File']");
    public static By BO_Maintain_FileSave=By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Save']");
    public static By BO_Maintain_OK=By.xpath("//div[text()='OK']");
    public static By BO_StopCat=By.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStopCategory']");
    public static By BO_Maintain_Save=By.xpath("//div[@name='MaintainAgreementDetailsWindow.ToolBar.Save']");
    public static By BO_Maintain_Status=By.xpath("//input[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfStatus']");
    
    public static By TUK_PAN_Elm=By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.gfSurroundOutlineFieldPanel']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]");
    public static By TUK_PAN_Elm_Cancel=By.xpath("//div[@name='DocumentRequestModalWindow.pbCancel']");
    
    //Document Verification
    
    public static By BO_DV_Dfview=By.xpath("//input[@name='DocumentRequestDetailWindow.DocumentRequestDetailView.dfName']");
    
	//NAVIGATION
   public static By BO_NA_Stopcategory=By.xpath("//div[@name='MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.pbStopCategorySearch']");  
   public static By BO_NA_Categorydfentry=By.xpath("//input[@name='StopCategorySimpleSearchWindow.dfCriteriaEntry']");
   
   //Test
   public static By TUK_PAN_Elm_Column=By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th");
   public static By TUK_PAN_Elm_Row=By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]");
   
   //Common_function
   public static By TUK_PAN_Elm_CurrDate=By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div");
   public static By TUK_PAN_Btn_JobsToSubmit=By.xpath("//input[@name='SubmitBatchJobWindow.SubmitBatchJobView.dfJobToSubmit']/parent::div[1]/parent::div[1]/following-sibling::div[2]/child::div[1]/child::div[2]");
   
   //Bank details
   public static By TUK_PAN_Edt_agrnum=By.xpath("//input[@id='agreementNumber']");
   public static By TUK_PAN_Btn_Search=By.xpath("//a[@id='PanLinkSubmit_0']");
   public static By TUK_PAN_Lnk_agrnum=By.xpath("//a[@class='linkWithBullet']");
   public static By TUK_PAN_Lnk_Servicing=By.xpath("//form[@id='PanForm']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/a/span");
   public static By TUK_PAN_Edt_AcctNo=By.xpath("//input[@name='accountNumber']");
   public static By TUK_PAN_Edt_SortCode1=By.xpath("//input[@name='sortCode1']");
   public static By TUK_PAN_Edt_SortCode2=By.xpath("//input[@name='sortCode2']");
   public static By TUK_PAN_Edt_SortCode3=By.xpath("//input[@name='sortCode3']");
   public static By TUK_PAN_Btn_Save=By.xpath("//a[text()='Save']");
   public static By BO_Settlements=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlements']");
   public static By BO_Quote=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Settlement Quote']");
   public static By BO_Bespoke=By.xpath("//div[@name='SelectionWindow.pbBespoke']");
   public static By BO_dfSettlement=By.xpath("//input[@name='QuotationWindow.QuoteTabView.dfSettlement']");
   public static By BO_ModifyDoc_OK=By.xpath("//div[@name='ModifyDocumentRequestWindow.pbOK']");
   public static By BO_SelectionWind_Elm1=By.xpath("//div[@name='SelectionWindow.buttons']/child::div[2]");
   
   //Log out
   public static By BO_LO_File=By.xpath("//div[text()='File']");
   public static By BO_LO_Exit=By.xpath("//div[text()='Exit']");
   public static By BO_LO_Yes=By.xpath("//div[text()='Yes']");
   
   //SettlementCheck
   public static By TUK_PAN_Settlement_OK=By.xpath("//div[@name='QuotationWindow.pbOK']");
   public static By TUK_PAN_Settlement_View=By.xpath("//div[@name='MaintainAgreementDetailsWindow.View']");
   public static By TUK_PAN_Settlement_Schedules=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Schedules']");
   public static By TUK_PAN_Settlement_Elm1=By.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']/div/div/div/div[2]");
   public static By TUK_PAN_Settlement_pbCancel=By.xpath("//div[@name='ViewSchedulesWindow.pbCancel']");
   public static By TUK_PAN_Settlement_CashAndPosting=By.xpath("//div[@name='MainUI.Open.Cash and Posting']");
   public static By TUK_PAN_Settlement_CashTransactions=By.xpath("//div[@name='MainUI.Open.Cash Transactions']");
   public static By TUK_PAN_Settlement_CashPosting=By.xpath("//div[@name='MainUI.Open.Cash Posting']");
   public static By TUK_PAN_Settlement_Reference=By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfReference']");
   public static By TUK_PAN_Settlement_dPaymentMethod=By.xpath("//div[@name='CashPostingWindow.CashBatchDetailsView.dlDefaultPaymentMethod']");
   public static By TUK_PAN_Settlement_Cash=By.xpath("//div[text()='Cash']");
   public static By TUK_PAN_Settlement_pbInsert=By.xpath("//div[@name='CashPostingWindow.DisplayCashTransactionsView.pbInsert']");
   public static By TUK_PAN_Settlement_Edt_Acct=By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAccount']");
   public static By TUK_PAN_Settlement_Comment=By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfComment']");
   public static By TUK_PAN_Settlement_ApplyTransaction=By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbApplyTransaction']");
   public static By TUK_PAN_Settlement_pbTypeLoV=By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbTypeLoV']");
   public static By TUK_PAN_Settlement_CriterialEntry=By.xpath("//input[@name='TransactionTypeSimpleSearchWindow.dfCriteriaEntry']");
   public static By TUK_PAN_Settlement_pbOK=By.xpath("//div[@name='TransactionTypeSimpleSearchWindow.pbOK']");
   public static By TUK_PAN_Settlement_BACSFailCodeLoV=By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.pbBACSFailCodeLoV']");
   public static By TUK_PAN_Settlement_dfCriterialEntry=By.xpath("//input[@name='BACSFailCodeSimpleSearchWindow.dfCriteriaEntry']");
   public static By TUK_PAN_Settlement_pbOK1=By.xpath("//div[@name='BACSFailCodeSimpleSearchWindow.pbOK']");
   public static By TUK_PAN_Settlement_Amount=By.xpath("//input[@name='CashPostingWindow.MaintainCashTransactionView.dfAmount']");
   public static By TUK_PAN_Settlement_Payment=By.xpath("//div[text()='Payment']");
   public static By TUK_PAN_Settlement_UnpaidBACS=By.xpath("//div[text()='Unpaid BACS']");
   public static By TUK_PAN_Settlement=By.xpath("//div[text()='Settlement']");
   public static By TUK_PAN_ReturnedSET=By.xpath("//div[text()='Returned SET']");
   public static By TUK_PAN_Reversal=By.xpath("//div[text()='Reversal']");
   public static By BO_BatchTotal=By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfBatchTotal']");
   public static By BO_ControlTotal=By.xpath("//input[@name='CashPostingWindow.CashBatchDetailsView.dfControlTotal']");
   public static By BO_CP_Elm1=By.xpath("//div[@name='CashPostingWindow.buttons']//child::div[2]/child::div[1]");
   
   public static By BO_pbTransactions=By.xpath("//div[@name='MaintainAgreementDetailsWindow.pbTransactions']");
   public static By BO_pbFilter=By.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.pbFilter']");
   public static By BO_FirstInDate=By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedStart']");
   public static By BO_FirstEndDate=By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfDateAppliedEnd']");
   public static By BO_TransactionType=By.xpath("//input[@name='ViewTransactionsFilterWindow.ViewTransactionsFilterView.dfTransactionType']");
   
   public static By BO_Transaction_pbOK=By.xpath("//div[@name='ViewTransactionsFilterWindow.pbOK']");
   public static By BO_Transaction_Elm1=By.xpath("//div[@name='ViewTransactionsWindow.ViewTransactionsUpdatedView.ofViewTransactionsPreUpdateOutlineField']/child::div[1]/child::div[1]/child::div[1]/child::div[2]");
   public static By BO_Trans_pbCancel=By.xpath("//div[@name='ViewTransactionsWindow.pbCancel']");
   
   public static By BO_gfAccount=By.xpath("//div[@name='CashPostingWindow.MaintainCashTransactionView.gfAccount']");
   public static By BO_Trans_Elm1=By.xpath("//div[@name='PaymentDetailsWindow.PaymentDetailsView.dlPaymentMethod']/child::div[1]/child::input[1]");
   public static By BO_CP_pbBespoke=By.xpath("//div[@name='CashPostingWindow.pbBespoke']");
   public static By BO_CP_pbBespoke_Elm1=By.xpath("//div[@name='CashPostingWindow.pbBespoke']//child::div[1]/child::div[1]");
   
   public static By BO_RescheduleQuote=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Reschedule Quote']");
   public static By BO_ReschedulepbBespoke=By.xpath("//div[@name='RescheduleSelectComponentsWindow.pbBespoke']");
   public static By BO_InsertBelow=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.insertBelow']");
   public static By BO_Reschedule_Elm1=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[4]");
   public static By BO_afSchedules=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[5]/input[1]");
   public static By BO_Reschedule_Elm2=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[5]");
   public static By BO_Reschedule_Freq=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[6]/child::div[1]/input[1]");
   public static By BO_Reschedule_Elm3=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[7]");
   public static By BO_BatchDate=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[8]/input[1]");
   public static By BO_Reschedule_Elm4=By.xpath("//div[@name='RescheduleQuoteWindow.RescheduleQuoteArrayView.afSchedules']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[6]");
   
   public static By BO_Elm_Solve=By.xpath("//div[@name='SolvableGuiContextMenu.Solve']");
   public static By BO_Elm_Calculate=By.xpath("//div[@name='RescheduleQuoteWindow.pbBespoke']/child::div[text()='Calculate']");
   public static By BO_Elm_Accept=By.xpath("//div[@name='RescheduleQuoteWindow.pbBespoke']/child::div[text()='Accept']");
   public static By BO_Reschedule_pbOK=By.xpath("//div[@name='RescheduleAcceptWindow.pbOK']");
   public static By BO_Elm_TakeUp=By.xpath("//div[@name='RescheduleQuoteWindow.pbBespoke']/child::div[text()='Take Up']");
   public static By BO_Reschedule_pbCancel=By.xpath("//div[@name='RescheduleSelectComponentsWindow.pbCancel']");
   public static By BO_Elm_Refund=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Refund']");
   public static By BO_Elm_pbInsert=By.xpath("//div[@name='RefundRequestSearchWindow.RefundRequestSearchView.pbInsert']");
   public static By BO_Refund_dfAmount=By.xpath("//div[@name='AddRefundRequestWindow.AddRefundRequestView.dfAmount']");
   public static By BO_Refund_addAmount=By.xpath("//input[@name='AddRefundRequestWindow.AddRefundRequestView.dfAmount']");
   public static By BO_Refund_Paymethod=By.xpath("//div[@name='AddRefundRequestWindow.AddRefundRequestView.dlPaymentMethod']/following-sibling::div[2]/div/div");
   public static By BO_OverPayment=By.xpath("//div[@name='AddRefundRequestWindow.AddRefundRequestView.dlPaymentMethod']/following-sibling::div[2]/div/input");
   public static By BO_pbSpoke=By.xpath("//div[@name='AddRefundRequestWindow.pbBespoke']");
   public static By BO_Refund_Elm1=By.xpath("//div[@name='RefundRequestSearchWindow.RefundRequestSearchView.gfOuter']/div/div/div/div[1]/div[2]");
   
   public static By BO_WriteOff=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Write-offs']");
   public static By BO_WriteOff1=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Initial Write-off']");
   public static By BO_WriteOffAmnt=By.xpath("//input[@name='InitialWriteOffWindow.InitialWriteOffView.dfWriteOffAmount']");
   public static By BO_WriteOffBal=By.xpath("//input[@name='InitialWriteOffWindow.InitialWriteOffView.dfBalance']");
   public static By BO_WriteOffButtons=By.xpath("//div[@name='InitialWriteOffWindow.buttons']//child::div[1]/child::div[1]");
   public static By BO_Image=By.xpath("//div[@style='position: absolute; overflow: hidden; white-space: nowrap; text-decoration: inherit; left: 43px; width: 17px; top: 3px; height: 17px;']");
   public static By BO_Recoveries=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Transfer To Recoveries']");
   public static By BO_WriteOffAmnt1=By.xpath("//input[@name='TransferToRecoveriesWindow.TransferToRecoveriesView.dfWriteOffAmount']");
   public static By BO_pbBespoke=By.xpath("//div[@name='TransferToRecoveriesWindow.pbBespoke']");
   public static By BO_FinalWriteOff=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Final Write-off']");
   public static By BO_WriteOff_pbOk=By.xpath("//div[@name='FinalWriteOffWindow.pbOK']");
   public static By BO_dfFirstName=By.xpath("//input[@name='CustomerWindow.PartyIdentityView.dfFirstname']");
   public static By BO_pbDetails1=By.xpath("//div[@name='DocumentRequestModalWindow.DocumentRequestView.pbDetails']");
   public static By BO_DocReq_pbBespoke=By.xpath("//div[@name='DocumentRequestDetailWindow.pbBespoke']");
   public static By BO_DocReq_pbDocs=By.xpath("//div[@name='DocumentRequestRecipientWindow.DocumentRequestRecipientView.pbDocuments']");
   public static By BO_DocReq_pbDetails=By.xpath("//div[@name='ViewDocumentPagesWindow.ViewDocumentPagesOutlineView.pbDetails']");
   public static By BO_DocReq_Elm1=By.xpath("//div[@name='DocumentWindow.DocumentView.ofVariable']/div/div/div[2]/div[4]");
   public static By BO_DW_pbCancel=By.xpath("//div[@name='DocumentWindow.pbCancel']");
   public static By BO_DW_pbCancel1=By.xpath("//div[@name='ViewDocumentPagesWindow.pbCancel']");
   public static By BO_DW_pbCancel2=By.xpath("//div[@name='DocumentRequestRecipientWindow.pbCancel']");
   public static By BO_DW_pbCancel3=By.xpath("//div[@name='DocumentRequestDetailWindow.pbCancel']");
   public static By BO_DW_Arrangements=By.xpath("//div[@name='MaintainAgreementDetailsWindow.Arrangements']");
   public static By BO_RepaymentElm1=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofRepayment']/div/div/div[2]/div[4]");
   public static By BO_RepaymentElm2=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/div/div/div/div[7]");
   public static By BO_TempArrange=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.afProfile']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[7]");
   public static By BO_TempArrangeElm1=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.gfArrayDetailGrid']/child::div[1]/child::div[1]/following-sibling::div[7]/child::input[1]"); 
   public static By BO_TempArrangeElm2=By.xpath("//div[@name='TemporaryArrangementWindow.TemporaryDeferralArrangementView.ofArrangement']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/following-sibling::div[1]");
   public static By BO_Schedules=By.xpath("//div[text()='Schedules']");
   public static By BO_Repayment=By.xpath("//div[text()='Repayment']");
   public static By BO_VS_Elm1=By.xpath("//div[@name='ViewSchedulesWindow.ViewSchedulesView.ofDisplayScheduleItems']/div/div/div[7]/div[1]");
   public static By BO_dfEndDate=By.xpath("MaintainAgreementDetailsWindow.MaintainAgreementDetailsView1.dfEndDate");
   public static By BO_Elm1=By.xpath("html/body/div[4]/div/div[5]");
   public static By BO_Elm2=By.xpath("html/body/div[6]/div/div[3]");
   public static By BO_Elm3=By.xpath("/html/body/div[7]/div/div[4]/div");
   public static By BO_Elm4=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[2]/div[1]/div");
   public static By BO_Elm5=By.xpath("/html/body/div[11]/div[2]/div/div/div[1]/div/div/div/div[6]/div[1]/input");
   public static By BO_ApplyFilter=By.xpath("//div[text()='Apply Filter']");
   public static By BO_Elm6=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div[1]/div[15]");
   public static By BO_Elm7=By.xpath("html/body/div[7]");
   public static By BO_Elm8=By.xpath("html/body/div[7]/div[3]/div/div");
   public static By BO_Elm_AgrServicing=By.xpath("html/body/div[4]/div/div[1]");
   public static By BO_Elm10=By.xpath("html/body/div[6]/div/div[2]");
                                            //html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/input
   public static By BO_Edt_AgrNum=By.xpath("//div[text()='Agreement:']/ancestor::div[3]/div[2]/input");
   public static By BO_Btn_Find=By.xpath("//div[text()='Agreement:']/ancestor::div[3]/div[3]");
   public static By BO_AgreementDetails=By.xpath("//div[contains(@style,'cursor: pointer;') and div='Agreement Details']");
   public static By BO_Elm13=By.xpath("/html/body/div[8]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[2]/input");
   public static By BO_Elm14=By.xpath("html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[2]/div/div[2]/div[1]/input");
   public static By BO_Elm15=By.xpath("html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[5]");
   public static By BO_Elm16=By.xpath("/html/body/div[7]/div[3]/div[2]");
   public static By BO_Elm17=By.xpath("html/body/div[6]/div[3]/div/div");
   public static By BO_Elm18=By.xpath("/html/body/div[8]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[4]/input");
   public static By BO_Elm19=By.xpath("/html/body/div[8]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[6]/input");
   public static By BO_Elm20=By.xpath("/html/body/div[7]");
   public static By BO_Elm21=By.xpath("html/body/div[5]/div/div[2]");
   public static By BO_Maintain=By.xpath("//div[text()='Maintain']");
   public static By BO_AddAttributes=By.xpath("//div[text()='Additional Attributes']");
   public static By BO_WriteOffs=By.xpath("//div[text()='Write-offs']");
   public static By BO_InitialWriteOffs=By.xpath("//div[text()='Initial Write-off']");
   public static By BO_WriteOff2=By.xpath("//div[text()='Write off']");
   public static By BO_Elm22=By.xpath("/html/body/div[11]/div[4]/div");
   public static By BO_Elm23=By.xpath("html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[2]/input");
   public static By BO_Elm24=By.xpath("html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[6]/input");
   public static By BO_Elm25=By.xpath("/html/body/div[8]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[22]/input");
   public static By BO_Elm_View=By.xpath("//div[text()='View']");
   public static By BO_Elm26=By.xpath("html/body/div[10]/div[2]/div/div/div/div/div[2]/div[3]");
   public static By BO_Elm27=By.xpath("html/body/div[10]/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div[3]/div");
   public static By BO_Elm28=By.xpath("html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[22]/input");
   public static By BO_Elm29=By.xpath("html/body/div[8]/div/div[25]");
   public static By BO_Elm30=By.xpath("html/body/div[9]/div/div[2]");
   public static By BO_Elm31=By.xpath("html/body/div[10]/div[2]/div/div/div/div/div/div[2]/div");
   public static By BO_Elm32=By.xpath("html/body/div[11]/div[3]/div/div[2]/div/div/div[10]/div/div/div[2]/div[1]/div[1]/div[2]/input");
   public static By BO_Btn_SelectAgrLevel=By.xpath("//div[text()='Select Agreement Level']");
   public static By BO_Elm_InterestFreePdt=By.xpath("//div[text()='Interest Free Product']");
   public static By BO_Elm35=By.xpath("html/body/div[8]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[22]/input");
   public static By BO_Elm36=By.xpath("html/body/div[8]/div/div[1]");
   public static By BO_Elm37=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[2]/div[1]/div/div[3]");
   public static By BO_Elm38=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[2]/div[3]/div[3]");
   public static By BO_Elm39=By.xpath("html/body/div[9]/div/div[1]");
   public static By BO_Elm40=By.xpath("/html/body/div[11]/div[2]/div/div/div/div/div[2]/div[1]/div/div[3]");
   public static By BO_Elm41=By.xpath("/html/body/div[11]/div[2]/div/div/div/div/div[2]/div[3]/div[3]");
   
   public static By BO_AgrSearchClose=By.xpath("//div[text()='Close']");
   public static By BO_AttributesScrollDown = By.xpath(("(//div[contains(@style, 'background: url(\"rwt-resources/themes/images/6edf2b8a.png\") no-repeat;')])[4]"));
   public static By BO_AttributesCancel=By.xpath("//div[text()='Cancel']");
   public static By BO_MAD_Close=By.xpath("(//div[contains(@style, 'background: url(\"rwt-resources/themes/images/4cdd7012.png\") no-repeat;')])[2]");
   public static By BO_AttrAwaitGoods=By.xpath("//div[text()='Awaiting Goods']//parent::div");
   public static By BO_AttrDelayedGoods=By.xpath("//div[text()='Delayed Goods Agreement']//parent::div");
   public static By BO_Edt_AgrStatus=By.xpath("//div[text()='Status:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_NumberOfPayments=By.xpath("(//div[text()='Number of payments:'])[1]//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_TermsInMonth=By.xpath("(//div[text()='Term in months:'])[1]//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_FrstDueDate=By.xpath("//div[text()='First due date:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_EndDueDate=By.xpath("(//div[text()='End date:'])[1]//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Btn_View=By.xpath("//div[text()='View']");
   public static By BO_Btn_Schedules=By.xpath("//div[text()='Schedules']");
   public static By BO_InstaAmountScrollDown=By.xpath("(//div[contains(@style, 'background: url(\"rwt-resources/themes/images/6edf2b8a.png\") no-repeat;')])[5]");
   public static By BO_Btn_SchedulesClose=By.xpath("(//div[text()='Close'])[2]"); 
   public static By BO_Securities1=By.xpath("(//div[text()='Securities'])[2]");
   public static By BO_Securities2=By.xpath("(//div[text()='Securities'])[3]");
   public static By BO_Txt_Hardware=By.xpath("//div[text()='Hardware']");
   public static By BO_Btn_HardwareDetails=By.xpath("(//div[text()='Details'])[2]");
   public static By BO_Edt_Identifier=By.xpath("//div[text()='Identifier:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_Agreementr=By.xpath("//div[text()='Agreement:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_Classification=By.xpath("//div[text()='Classification:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_SecurityType=By.xpath("//div[text()='Security type:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_TotalCashPrice=By.xpath("//div[text()='Total cash price:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_Supplier=By.xpath("//div[text()='Supplier:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Edt_DeliveryDate=By.xpath("//div[text()='Delivery date:']//parent::div[1]//following-sibling::div[1]//child::input");
   public static By BO_Btn_EquipmentScheldule=By.xpath("//div[text()='Equipment Schedule']");
   public static By BO_Btn_EquipSchelduleCancel=By.xpath("(//div[text()='Cancel'])[2]");
   public static By BO_Btn_SecuritiesCancel=By.xpath("//div[contains(@style,'cursor: pointer;') and div='Cancel']");
   public static By BO_Btn_SecuritiesClose=By.xpath("(//div[contains(@style,'cursor: pointer;') and div='Close'])[2]"); 
   public static By BO_EquipScheduleSideArrow=By.xpath("(//div[contains(@style,'background: url(\"rwt-resources/themes/images/4ee00e3c.png\") center center no-repeat;')])[16]"); 
   public static By BO_EquipScheduleQuantity=By.xpath("(//div[contains(@style,'background: url(\"rwt-resources/themes/images/4ee00e3c.png\") center center no-repeat;')])[16]//following-sibling::div[3]");
   public static By BO_EquipScheduleCost=By.xpath("(//div[contains(@style,'background: url(\"rwt-resources/themes/images/4ee00e3c.png\") center center no-repeat;')])[16]//following-sibling::div[6]");
   public static By BO_EquipScheduleResValue=By.xpath("(//div[contains(@style,'background: url(\"rwt-resources/themes/images/4ee00e3c.png\") center center no-repeat;')])[16]//following-sibling::div[9]");
   public static By BO_Btn_InsertChild=By.xpath("//div[text()='Insert Child']");
   public static By BO_Btn_EqScheduleDetails=By.xpath("(//div[text()='Details'])[3]");
   public static By BO_Btn_EqScheduleCancel=By.xpath("(//div[text()='Cancel'])[2]");
   
   
   //Front office Login
	public static By UsernameFO = By.name("username");
	public static By PasswordFO = By.name("password");
	public static By SubmitFO = By.xpath("//a[@id='PanLinkSubmit']");
	
	//Front Office Agreement Search
	public static By FO_Lnk_NewProposal = By.xpath("//span[@id='bannermenu']/a[2]");
	public static By FO_AgreementNumber = By.name("agreementNumber");
	public static By FO_SubmitAgreement = By.xpath("//a[@id='PanLinkSubmit_0']");
	public static By FO_Agreementstatus =By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[2]");
	public static By FO_AgreementLink =By.xpath("//a[@class='linkWithBullet']");
	
	//Front office approve Action
	public static By FO_Approvebutton =By.linkText("Accept Proposal");
	public static By FO_Clickapprovebutton =By.linkText("Approve");
	public static By FO_Agrapprovestatus =By.xpath("//*[@id='PanForm']/div[2]/div/span[1]/span");
	
	//Front Office Logout
	public static By FO_Logout_Button = By.xpath("//a[@id='PanDirectLink_434']");
	
	//Front office servicing
	//Course details action
	public static By FO_Clickcoursedetailslink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[2]/a");
	public static By FO_Getidentifier=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[1]");
	public static By FO_Getreference=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]");
	public static By FO_Getagrnumber=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
	public static By FO_GetStartdate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]");
	public static By FO_GetEnddate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[6]");
	public static By FO_GetCost=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[7]");
	public static By FO_detailstable=By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/table/tbody/tr/td");
	public static By FO_CoursedetailsClosebutton=By.linkText("Close");
	
	//Front office servicing
	//Change of Due date
	public static By FO_Paymentdatelink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/a");
	public static By FO_Duedatetype=By.xpath("//select[@id='dueDateId']");
	public static By FO_Newnextpaymentdate=By.xpath("//input[@id='newNextPaymentDate']");
	public static By FO_Paymentdatesave=By.xpath("//a[@id='PanLinkSubmit']");
	public static By FO_Errormsg=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[2]/td");
	public static By FO_Errormsgback=By.linkText("Back");
	
	//Front office servicing
	//View schedules action 
	public static By FO_Viewscheduleslink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/a");
	public static By FO_Viewschedulefirstrow=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[1]");
	public static By FO_Viewschedulesecondrow=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[1]");
	public static By FO_Viewschedulethirdrow=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[4]/td[1]");
	public static By FO_Viewschedulestype=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[1]");
	public static By FO_Viewschedulesnoofpay=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]");
	public static By FO_Viewschedulesterms=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[3]");
	public static By FO_Viewschedulesstatus=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
	public static By FO_Viewschedulesstartdate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]");
	public static By FO_Viewschedulesenddate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[6]");
	public static By FO_ViewschedulesDuedate=By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]");
	public static By FO_Viewschedulesinsamnt=By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[2]");
	public static By FO_closebutton=By.linkText("Close");
	
	//Front office servicing
	//withdrawal notification
	public static By FO_Withdrawalnotificlink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[9]/td[2]/a");
	public static By FO_Withdrawalnotificdate=By.name("withdrawalNotificationDate");
	public static By FO_Withdrawalnotificsave=By.linkText("Save");
	public static By FO_Withdrawalnotificblock=By.xpath("//*[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[14]/td[4]");
	public static By FO_Withdrawalnotificproporate=By.xpath("//*[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[15]/td[4]");
	
	//Front office servicing
	//Agreement history
	public static By FO_Agreementmorelink=By.linkText("More...");
	public static By FO_Commontypeevent=By.xpath("//*[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
	public static By FO_Withdraweve1=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[4]");
	public static By FO_Withdraweve1value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[5]");
	public static By FO_Withdraweve2=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
	public static By FO_Withdraweve2value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]");
	public static By FO_Withdrweve1=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[20]/td[4]");
	public static By FO_Withdrweve1value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[20]/td[5]");
	public static By FO_Withdrweve2=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[19]/td[4]");
	public static By FO_Withdrweve2value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[19]/td[5]");

	//***IKANO***
	//Esignature elements
	public static By IK_Chk_ESign=By.id("secciSigned");
	public static By IK_Btn_Proceed=By.xpath("//*[@id='ProceedButton']/span");
	public static By IK_Chk_AgrSign=By.id("agreementSigned");
	public static By IK_Chk_WarrantySign=By.id("warrantySigned");
	public static By IK_Btn_Submit=By.id("SubmitButton");
	public static By IK_Btn_Next=By.xpath("//*[@id='main_content']/div[5]/div[2]/a/span");
	public static By IK_Btn_Confirm=By.xpath("//*[@id='main_content']/div[2]/div[2]/a/span");
	
	//*****OPEN UNIVERSITY*****
	//Student portal login
	public static By OU_Studentportal_continuebutton=By.linkText("Continue");
	public static By OU_Studentportal_Password=By.name("password");
	public static By OU_Studentportal_Confirmpaswd=By.name("password2");
	public static By OU_Studentportal_submitlogin=By.name("login");
	
	//Student portal actions
	//Personal details page
	public static By OU_Studentporatl_continueapplicationbutton=By.name("continueApplication");
	
	//Address details page
	public static By OU_Studentporatl_UKaddresslink=By.linkText("Enter UK Address");
	public static By OU_Studentportal_Propertynumber=By.name("propertyNumber");
	public static By OU_Studentportal_Postcode=By.name("postcode");
	public static By OU_Studentportal_Searchbutton=By.name("search");
	public static By OU_Studentportal_Addressnotfounlink=By.linkText("Address not found");
	public static By OU_Studentportal_Addresspostcode=By.name("addressDetails.postcode");
	public static By OU_Studentportal_Addressflatnum=By.name("addressDetails.flat");
	public static By OU_Studentportal_Addresspropertynum=By.name("addressDetails.propertyNumber");
	public static By OU_Studentportal_Addresspropertyname=By.name("addressDetails.propertyName");
	public static By OU_Studentportal_Addressstreetname=By.name("addressDetails.streetName");
	public static By OU_Studentportal_Addressdistrict=By.name("addressDetails.district");
	public static By OU_Studentportal_Addresspostaltown=By.name("addressDetails.postalTown");
	public static By OU_Studentportal_Addressflatcounty=By.name("addressDetails.county");
	public static By OU_Studentportal_Addressday=By.name("day");
	public static By OU_Studentportal_Addressmonth=By.name("month");
	public static By OU_Studentportal_AddressYear=By.name("year");
	public static By OU_Studentportal_Continuebutton=By.name("continue");
	public static By OU_Studentportal_Continuelink=By.linkText("Continue");
	
	//Financial page
	public static By OU_Studentportal_Checkbox=By.name("consentToSearch");
	public static By OU_Studentportal_Empoccupancy=By.name("person.occupancyID");
	public static By OU_Studentportal_Empstatus=By.name("person.employmentStatusID");
	public static By OU_Studentportal_Emppaymethod=By.xpath("//input[@value='90002']");
	//Income
	public static By OU_Studentportal_Annualincome=By.name("annualIncome");
	public static By OU_Studentportal_Monthlyincome=By.name("monthlyIncome");
	public static By OU_Studentportal_Dividend=By.name("dividendsReceived");
	public static By OU_Studentportal_Benefit=By.name("benefitsReceived");
	public static By OU_Studentportal_Rent=By.name("rentReceived");
	public static By OU_Studentportal_Maintenance=By.name("maintenanceReceived");
	public static By OU_Studentportal_Totalincome=By.name("totalMonthlyIncome");
	//Expenditure
	public static By OU_Studentportal_Creditcard=By.name("creditCards");
	public static By OU_Studentportal_Loans=By.name("loans");
	public static By OU_Studentportal_Counciltax=By.name("councilTax");
	public static By OU_Studentportal_Utilities=By.name("utilities");
	public static By OU_Studentportal_Mortgage=By.name("mortgage");
	public static By OU_Studentportal_Noofdependants=By.name("numberOfDependants");
	public static By OU_Studentportal_Noofadults=By.name("numberOfAdults");
	public static By OU_Studentportal_Savebutton=By.name("save");
	//Employment details
	public static By OU_Studentportal_Employeename=By.name("employment.employerName");
	public static By OU_Studentportal_Employeetelephone=By.name("employment.telephone");
	public static By OU_Studentportal_Employeepropertynumber=By.name("address.propertyNumber");
	public static By OU_Studentportal_Employeestreetname=By.name("address.streetName");
	public static By OU_Studentportal_Employeedistrict=By.name("address.district");
	public static By OU_Studentportal_Employeeposttown=By.name("address.postalTown");
	public static By OU_Studentportal_Employeepostcode=By.name("address.postcode");
	public static By OU_Studentportal_Employeecounty=By.name("address.county");
	public static By OU_Studentportal_Employeecountry=By.name("address.countryID");
	public static By OU_Studentportal_Employeeyear=By.name("yearsWith");
	public static By OU_Studentportal_Employeemonth=By.name("monthsWith");
	public static By OU_Studentportal_Employeeoccupation=By.name("employment.occupation");
	public static By OU_Studentportal_Employeepositionid=By.name("employment.positionID");
	public static By OU_Studentportal_Employeesectorid=By.name("employment.sectorID");
	public static By OU_Studentportal_Employeesave=By.name("save");
	
	//Direct Debit
	public static By OU_Studentportal_Banksortcode=By.name("bankAccount.sortCode");
	public static By OU_Studentportal_Search=By.name("search");
	public static By OU_Studentportal_Banknamelink=By.linkText("BARCLAYS BANK PLC");
	public static By OU_Studentportal_Banknamelink1=By.linkText("Halifax");
	public static By OU_Studentportal_Bankaccountname=By.name("bankAccount.accountName");
	public static By OU_Studentportal_Bankaccountnumber=By.name("bankAccount.accountNumber");
	public static By OU_Studentportal_Onesignature=By.name("oneSignature");
	public static By OU_Studentportal_Directdebitsave=By.name("save");
	public static By OU_Studentportal_Directdebitcontinue=By.linkText("Continue");
	public static By OU_Studentportal_DDconitue=By.linkText("Continue");
	public static By OU_Studentportal_DDContinuewithapplink=By.linkText("Continue with application");
	public static By OU_Studentportal_OuStudentstatus=By.xpath("//*[@id='ou-content']/h1");
	public static By OU_Studentportal_finishbutton=By.linkText("Finish");
	public static By OU_Student_Checkbox =By.name("consented");
	public static By OU_Student_Accept =By.id("accepted-save_save");
	
	//OU staff portal login
	public static By OU_Staffcontinuelink =By.linkText("Continue");
	public static By OU_Usernamestaff =By.name("username");
	public static By OU_Passwordstaff =By.name("password");
	public static By OU_Submitlogin=By.name("login");
	
	//OU Staff Portal
	public static By OU_Staff_Pinumber =By.name("piNumber");
	public static By OU_Staff_Seacrhbutton=By.name("search");
	public static By OU_Staff_PIdetails=By.xpath("//*[@id='ou-content']/table/tbody/tr/td[1]/a");
	public static By OU_Staff_Agrstatus=By.xpath("//*[@id='ou-content']/table/tbody/tr/td[5]");
	public static By OU_Staff_Agreementlink=By.xpath("//*[@id='ou-content']/table/tbody/tr/td[1]/a");
	public static By OU_Staff_Continueapplicationbutton=By.name("continueApplication");
	public static By OU_Staff_Checkbox =By.name("consented");
	public static By OU_Staff_Save=By.name("save");
	public static By OU_Staff_logout=By.linkText("Log out");
	public static By OU_Staffportal_finishbutton=By.linkText("Finish");
	
	//********ELL*******
	//Queue Proposal
	public static By EL_Queue_proposal = By.xpath("//*[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBQueueProposal&sp=S100072']");
	public static By EL_Work_queue = By.xpath("//*[@id='plan']");
	public static By EL_Retain_queue = By.xpath("//*[@id='retainPlan']");
	public static By EL_queue = By.xpath("//*[@id='PanLinkSubmit_0']");
	
	//Loan options
	public static By EL_Loanoption = By.linkText("Loan Options");
	public static By EL_Newoption = By.xpath("//div[@class='submitButtons']/a[3]");
	public static By EL_Product = By.xpath("//*[@id='productID']");
	public static By EL_cashtocustomer = By.xpath("//input[@id='cashToCustomer']");
	public static By EL_Rate = By.xpath("//*[@id='rateMarginHeaderIDList']");
	public static By EL_Term = By.xpath("//input[@id='term']");
	public static By EL_Recalculate = By.xpath("//*[@id='PanLinkSubmit_4']");
	public static By EL_Btn_Save = By.xpath("//a[text()='Save']");
	public static By EL_Btn_Takeup = By.xpath("//a[@href='/edlBranch/app?component=%24PanDirectLink_0&page=NewBusiness%2FNBLoanOptions&service=direct&session=T&state:NewBusiness/NBLoanOptions=ZH4sIAAAAAAAAAFvzloG1XIiBgYGZgYE7ubSoKDWvJCAxPbW4iEEwK7EsUS8nMS9dzzOvJDU9tUjo0YIl3xvbLZgYGD0ZWMsSc0pTK4oYBBDq%2FEpzk1KL2tZMleWe8qCbiYGhogBoNCPIAn6Y4fnFmSWZ%2BXnFhQx1DGBQzs%2FAwINktRFcihEAznnhCp4AAAA%3D']");
	
	//Approve loan
	public static By EL_Approve_loan = By.xpath("//a[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBAcceptProposal&sp=S100061']");
	public static By EL_Btn_Approve = By.xpath("//a[text()='Approve']");
	
	//Payout and Activate
	public static By EL_payoutButton = By.xpath("//a[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBPayoutAndActivate&sp=S100067']");
	public static By EL_Payment_method = By.xpath("//*[@id='paymentMethod']");
	public static By EL_Btn_Activate = By.xpath("//a[text()='Activate']");
	public static By EL_ActivationSuccessMsg = By.xpath("//*[@id='main']/div[2]/div[1]/div/div[2]");
	
	//********Telefonica*******
	public static By TUK_Chk_Secci = By.id("secciSigned");
	public static By TUK_Btn_Proceed = By.id("ProceedButton");
	public static By TUK_Chk_AgrSign = By.id("agreementSigned");
	public static By TUK_Btn_Submit = By.id("SubmitButton");
	public static By TUK_Btn_Next = By.linkText("Next");
	public static By TUK_Btn_Continue = By.linkText("Continue");
	public static By TUK_FinalMsg = By.xpath("//h1[text()='This site can’t be reached']");
	
	//********Startline*******
	public static By SL_Lnk_MotorProposal = By.linkText("Motor Proposal");
	public static By SL_Edt_AgrNum = By.name("agreementNumber");
	public static By SL_Lnk_SearchAgr = By.linkText("Search");
	public static By SL_Lnk_AgrNum = By.xpath("//*[@id='custSearchBody']/table[1]/tbody/tr[2]/td[1]/a");
	public static By SL_Btn_Refresh = By.xpath("//*[@id='panelBody']/form/table[4]/tbody/tr[2]/td/div/a[1]");
	public static By SL_Elm_status = By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[1]/td[2]");
	public static By SL_Elm_Financials = By.xpath("//h1[text()='Financials']");
	public static By SL_Btn_Continue = By.linkText("Continue");
	public static By SL_Btn_ManualOverride = By.linkText("Manual Override");
	public static By SL_Btn_PayoutGolive = By.linkText("Payout & Golive");
	public static By SL_Elm_Advance = By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[5]/td[2]");
	public static By SL_Elm_Installment = By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[6]/td[4]");
	public static By SL_Btn_DocsReceived = By.linkText("Docs Received");
	public static By SL_Btn_Yes = By.xpath("//*[@id='sitebody']/div[5]/div[3]/div/button[1]/span");
	public static By SL_Btn_Yes1 = By.xpath("//span[text()='Yes']");
	public static By SL_Edt_Advance = By.name("documentAdvance");
	public static By SL_Edt_Installment = By.name("documentInstalment");
	public static By SL_Edt_Balloon = By.name("documentBalloon");
	public static By SL_Edt_DocFee = By.name("documentDocumentFee");
	public static By SL_Btn_1stCheck = By.linkText("1st Check Validated");
	public static By SL_Btn_ConfSpecTerms = By.linkText("Confirm Special Terms");
	public static By SL_Btn_DocsApproved = By.linkText("Docs Approved");
	public static By SL_Lst_Brand = By.name("changeBrandID");
	public static By SL_Btn_Back = By.xpath("//a[@class='backButton']");
	
}

