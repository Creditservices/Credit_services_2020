package Startline;


	


	import java.util.ArrayList;

import org.openqa.selenium.By;
	import org.openqa.selenium.support.pagefactory.ByAll;

	public class POM_StartLine {
		
		
		public static ArrayList<String> passevents=new ArrayList<String>();
			
		static By SMF_Username = By.name("userName");
		static By SMF_Password= By.name("passWord");
		static By SMF_Login = By.linkText("Login");
		
		//Motor front end tab-Home page
		
		
		
//Home page
		
	    //Agreement search  
		static By SMF_Agreementnumberbox = By.name("agreementNumber");
		static By SMF_Agreementdecisiononsearch = By.xpath("//*[@id='custSearchBody']/table[1]/tbody/tr[2]/td[5]");
		static By SMF_AgreementSearchGrid_Searchbutton = By.xpath("//*[@id='agrSearchBody']/form/table[2]/tbody/tr/td/div/a");
		static By SMF_Agreementnumber_hyperlink = By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[2]/td[1]/a");
		static By SMF_Agreementnumber_Viewelecproposal = By.linkText("View");
		static By SMF_Agreementnumber_elecproposalclose= By.linkText("Close");
		//Person Search
		static By SMF_Surnnamebox = By.name("surname");
		static By SMF_Forenamebox = By.name("forename");
		static By SMF_PersonSearchGrid_Searchbutton=By.xpath("//*[@id='personSearchBody']/form/table[2]/tbody/tr/td[2]/div/a");
		static By SMF_SelectOneCustomerlistoptions = By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[5]/td[1]/a");
		static By SMF_CusSubaruTierXpath = By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[6]/td[1]/a");
		static By SMF_DOBbox = By.name("dateOfBirth");
		static By SMF_Propertynumberbox = By.name("propertyNumber");
		static By SMF_Streetnamebox = By.name("streetName");
		static By SMF_Postaltownbox = By.name("postalTown");
		static By SMF_Postcode = By.name("postCode");
		
		//Company Search
		static By SMF_Companynamebox = By.name("companyName");
		static By SMF_Registrationnumberbox = By.name("registrationNumber");
		static By SMF_Chasisnumberbox = By.name("chassisNumber");
		
		//Homepage links
		static By SMF_Logutlink= By.linkText("logout CHENNAI");
		static By SMF_Sitesetuplink= By.linkText("site setup");
		static By SMF_Tracelink= By.linkText("trace");
		static By SMF_Aboutlink= By.linkText("about");
		static By SMF_Changepassword= By.linkText("change password");
		static By SMF_QuedAgreements= By.linkText("queued agreements");
	
		
    //Terms page/Tab
		
		 static By SMF_Terms_DealerorIntroducercode = By.name("dealerCode");
		 static By SMF_Terms_IntroducernameSearch= By.linkText("Search");
		 static By SMF_Terms_ClickingDelaerLink = By.xpath("//*[@id='custSearchBody']/table[1]/tbody/tr[2]/td[1]/a");
		 static By SMF_Terms_representativeID=By.name("representativeID");
		 static By SMF_Terms_BranchID=By.name("branchID");
		 static By SMF_Terms_BrandID=By.name("brandID");
		 static By SMF_Terms_DOB=By.name("dateOfBirth");
		 static By SMF_Terms_ClassificationID=By.name("classificationID");
		 static By SMF_Terms_GoodsCost=By.name("costOfGoods");
		 static By SMF_Navigate_TermstoPersonal=By.xpath("//div[@id='navStrip']/p[2]/a[1]");
		 
		 
		 
		 //Common links for all pages
		 
		 //Continue
		 static By SMF_Commonfuntion_Continue=By.linkText("Continue");
		 //Calculate
		 static By SMF_Commonfuntion_Calculate=By.linkText("Calculate");
		 //Refresh
		 static By SMF_Commonfuntion_Refresh= By.linkText("Refresh");
		 
		 static By SMF_CommonPagetitle =By.xpath("//*[@id='panelArea']/h1");
		
		 
		 
	//Personal details page
		 static By SMF_Personaldetailspage_paymethod = By.name("paymentMethodID");
		 static By SMF_Personaldetailspage_Sortcode1 =  By.name("custSortCode1");
		 static By SMF_Personaldetailspage_Sortcode2 = By.name("custSortCode2");
		 static By SMF_Personaldetailspage_Sortcode3 = By.name("custSortCode3");
		 static By SMF_Personaldetailspage_BankAcno = By.name("custAccountNumber");
		 static By SMF_Personaldetailspage_DrivingLicence = By.name("drivingLicence");
		 static By SMF_Personaldetailspage_DrivingLicenceOrgin = By.name("drivingLicenceOriginID");
		 static By SMF_Personaldetailspage_DrivingLicenceType = By.name("drivingLicenceTypeID");
		 static By SMF_Personaldetailspage_NoofDependants= By.name("numberOfDependants");
		 static By SMF_Personaldetailspage_DLErrormsg = By.xpath("//*[@id='errorBody']/table[1]/tbody/tr[2]/td");
		 static By SMF_Personaldetailspage_DLErrormsgBack =By.xpath("//*[@id='errorBody']/table[2]/tbody/tr/td[1]/div/a");
		 static By SMF_Personaldetailspage_MoveinDate=By.name("addresses[0].movingInDate");
		 static By SMF_Personaldetailspage_TimeatAddressYears=By.name("addresses[0].timeAtAddressYears");
		 static By SMF_Personaldetailspage_TimeatAddressMonths=By.name("addresses[0].timeAtAddressMonths");
		 static By SMF_Personaldetailspage_AdresshistoryError=By.xpath("//*[@id='panelBody']/form/p");
		 static By SMF_Navigate_personaltoAffordpage=By.xpath("//div[@id='navStrip']/p[3]/a[1]");
		
		 
	//Affordabilitypage
		
		 static By SMF_navigatefrom_AffortoPersonalTab = By.xpath("//*[@id='navStrip']/p[2]/a[1]");
		 static By SMF_MotorFrontEnd_Agreementnumber=By.xpath("//div[@id='topStrip']/span[4]");
		 static By SMF_Affordpage_Grossamnt=By.name("incomeElement[0].amountAsString");
		 static By SMF_Affordpage_Netamnt=By.name("incomeElement[1].amountAsString");
		 static By SMF_Affordpage_Caramnt=By.name("expenditureElement[0].amountAsString");
		 static By SMF_Affordpage_Rentamnt=By.name("expenditureElement[3].amountAsString");
	
	//Employment page 
		 static By SMF_EMPPage_CmpnyName =By.name("employments[0].companyName");                                     
		 static By SMF_EMPPage_PropertyName =By.name("employments[0].address.propertyName");
		 static By SMF_EMPPage_PostalTown =By.name("employments[0].address.postalTown");
		 static By SMF_EMPPage_PostCode=By.name("employments[0].address.postCode");
		 static By SMF_EMPPage_ClickSMFlistedOptions=By.xpath("//*[@id='panelBody']/form/table[2]/tbody/tr[1]/td[2]/a");
		 static By SMF_EMPPage_EMPSearch= By.xpath("//*[@id='custSearchBody']/table[1]/tbody/tr[2]/td[1]/a");
		 static By SMF_EMPPage_EMPStartdate= By.name("employments[0].employmentStart");
		 static By SMF_EMPPage_EMPdelete=By.xpath("//*[@id='panelBody']/form/table[4]/tbody/tr/td/table/tbody/tr/td[4]/a");
		 static By SMF_EMPPage_EMPADD= By.linkText("Add Employment");
		 static By SMF_EMPPageno=By.xpath("//*[@id='panelBody']/form/table[4]/tbody/tr/td/table/tbody/tr/td[2]");
		
	
	 //Gurantors
		 static By SMF_Guarantorpage_NoGuarantors=By.linkText("No Guarantors");
		 static By SMF_Guarantorpage_Surnname=By.name("guarantorSurname");
		 static By SMF_Guarantorpage_Forename=By.name("guarantorForename");
		 static By SMF_Guarantorpage_Search=By.linkText("Search");
		 static By SMF_Guarantorpage_Guarantornamelink=By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[2]/td[1]/a");
		 static By SMF_Guarantorpage_MotorfrontendAgrno=By.xpath("//div[@id='topStrip']/span[4]");
		 
		 
		 
	 //Security details page
		 static By SMF_Securitypage_NewUserID=By.name("newOrUsedID");
		 static By SMF_Securitypage_RegNumber=By.name("regNumber");
		 static By SMF_Securitypage_Mileage=By.name("mileage");
		 static By SMF_Securitypage_SecuritySearch=By.xpath("//div[@id='panelBody']/form/table[2]/tbody/tr[4]/td[2]/a");
		 static By SMF_Securitypage_AnnualMillege=By.name("annualMileage");
		 static By SMF_Securitypage_Fixvaluetickbox=By.name("secFixValue");
		 static By SMF_Securitypage_ExcessmileageCharge=By.name("excessMileageCharge");
		 static By SMF_Navigate_toSecuritypage=By.xpath("//div[@id='navStrip']/p[6]/a[1]");
		 static By SMF_Vehiclepopup=By.xpath("//*[@id='dialog-reSearchVehicle']/p");
		 static By SMF_VehiclepopupOk=By.xpath("//*[@id='sitebody']/div[6]/div[3]/div/button");
	//Financial page
		 
		 static By SMF_Financialpage_Noofpay=By.name("numberOfPayments");
		 static By SMF_Financialpage_Proposerate=By.name("displayFlatRate");
		 static By SMF_Financialpage_Yieldrate=By.name("displayYield");
		 static By SMF_Financialpage_Adminfeetext=By.xpath("//*[@id='panelBody']/form/table[2]/tbody/tr[4]/td[2]/input[1]");
		 static By SMF_Financialpage_Installmenttext=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[3]/td[2]/input");
		 static By SMF_Financialpage_DelaerDeposit=By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[3]/td[5]/input");
		 static By SMF_Financialpage_PartExchange=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[4]/td[6]/input");
		 static By SMF_Financialpage_Advance=By.xpath("//div[@id='panelBody']/form/table[2]/tbody/tr[2]/td[2]");
		 static By SMF_Financialpage_Goodscost=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[7]/td[3]");
		 static By SMF_Financialpage_Solveforinstallment=By.xpath("//input[@value='instalment']");
		 static By SMF_Financialpage_Solveforrate=By.xpath("//input[@value='rates']");
		 static By SMF_Financialpage_Fixrates=By.name("finFixRate");
		 static By SMF_Financialpage_Goodscostimgplus=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[7]/td[2]/div/a/img");
		 static By SMF_Financialpage_Gapamnt=By.name("costElement[1].grossCost");
		 static By SMF_Financialpage_PaintProamnt=By.name("costElement[2].grossCost");
		 static By SMF_Financialpage_Tyreinsamnt=By.name("costElement[3].grossCost");
		 static By SMF_Financialpage_Warantyamnt=By.name("costElement[4].grossCost");
		 static By SMF_Financialpage_GoodscostbreakBack=By.xpath("//div[@id='agrSearchBody']/table[2]/tbody/tr/td[1]/a");
		 static By SMF_Financialpage_proposeratefield=By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[4]/td[3]");
		 static By SMF_Financialpage_APRratefield=By.xpath("//*[@id='aprData']");
		 static By SMF_Financialpage_Yieldratefield=By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[6]/td[3]");
		 
	//CallvalBureau search  
		 //Dealflo
		 static By SMF_CallvalBureau_Dealfloagency=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[2]/td[3]");
		 static By SMF_CallvalBureau_Dealfloagencylink=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[2]/td[1]/a");
		 static By SMF_CallvalBureau_DealfloBankStandard=By.xpath("//div[@id='bureauPanelBody']/div/div/table[2]/tbody/tr[1]/td[2]/font");
		 static By SMF_CallvalBureau_DealfloBankEnhanced=By.xpath("//div[@id='bureauPanelBody']/div/div/table[2]/tbody/tr[2]/td[2]/font");
		 static By SMF_CallvalBureau_DealfloIDEnhanced=By.xpath("//div[@id='bureauPanelBody']/div/div/table[2]/tbody/tr[5]/td[2]/font");
		 static By SMF_CallvalBureau_DealfloBankEnhacedscore=By.xpath("//div[@id='bureauPanelBody']/div/div/table[9]/tbody/tr[2]/td[2]");
		//Callval common back
		 static By SMF_CallvalBureau_CommonBack=By.xpath("//div[@id='panelBody']/table/tbody/tr/td[1]/a");
		
		 //Calltac
		 static By SMF_CallvalBureau_Calltacagency=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[3]/td[3]");
		 static By SMF_CallvalBureau_CalltacorCallReportagencytext1=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[4]/td[3]");
		 static By SMF_CallvalBureau_CalltacorCallReportagencylink1=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[4]/td[1]/a");
		 static By SMF_CallvalBureau_Calltacagencylink2=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[3]/td[1]/a");
		 static By SMF_CallvalBureau_CalltacWarnmsg=By.xpath("//div[@id='bureauPanelBody']/div/div/span");
		 static By SMF_CallvalBureau_CalltacSearchID=By.xpath("//div[@id='bureauPanelBody']/div/table[2]/tbody/tr[2]/td[2]");
		 
		 //Callreport
		 static By SMF_CallvalBureau_CallReporttext1=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[5]/td[3]");
		 static By SMF_CallvalBureau_CallReportlink1=By.xpath("//div[@id='bureauPanelBody']/table/tbody/tr[5]/td[1]/a");
		 static By SMF_CallvalBureau_CallReportShare=By.xpath("//div[@id='tabs0']/ul/li[3]/a/span");
		 static By SMF_CallvalBureau_CallReportSharetext=By.xpath("//div[@id='share0']/div");
		 static By SMF_Navigate_toDecisionpage=By.xpath("//div[@id='navStrip']/p[9]/a[1]");
		 
	//Decisionpage
		 
		 static By SMF_Navigate_DecisionpagetoCallvalbureapage =By.xpath("//div[@id='navStrip']/p[8]/a[1]");
		 static By SMF_Decisionpage_Installment =By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[6]/td[4]");
		 static By SMF_Decisionpage_Residualval =By.name("residualValue");
		 static By SMF_Decisionpage_Halfwayval =By.name("halfwayValue");
		 static By SMF_Decisionpage_VTexsposure =By.xpath("//*[@id='panelBody']/form/table[2]/tbody/tr/td[2]/table/tbody/tr[6]/td[2]");
		 static By SMF_Decisionpage_Specialterm =By.xpath("//div[@id='panelBody']/form/table[3]/tbody/tr[2]/td[3]");
		 static By SMF_Decisionpage_Manualoverride=By.linkText("Manual Override");
		 static By SMF_Decisionpage_Status=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[1]/td[2]");
		 static By SMF_Decisionpage_Plan=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[2]/td[2]");
		 static By SMF_Decisionpage_EsignURL=By.xpath("//div[@id='panelBody']/form/table[1]/tbody/tr[15]/td[2]");
		 static By SMF_Decisionpage_Documents=By.linkText("Documents");
		 static By SMF_Decisionpage_Document1name= By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[2]/td[1]");
		 static By SMF_Decisionpage_Document2name=By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[3]/td[1]");
		 static By SMF_Decisionpage_Document3name=By.xpath("//div[@id='custSearchBody']/table[1]/tbody/tr[4]/td[1]");
		 static By SMF_Decisionpage_DocumentBack=By.xpath("//div[@id='custSearchBody']/table[3]/tbody/tr/td[1]/a");
		 static By SMF_Decisionpage_ChangeBrandDDL=By.name("changeBrandID");
		 static By SMF_Decisionpage_ReturntoIntroducer=By.linkText("Return to Introducer");
		 static By SMF_Decisionpage_RTIcount=By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[14]/td[2]");
		 static By SMF_Decisionpage_Rejectreason=By.name("rejectionReasonID");
		 static By SMF_Decisionpage_Rejectbutton=By.linkText("Reject");
		 static By SMF_Decisionpage_RejectBack=By.xpath("//div[@id='personSearchBody']/form/table[2]/tbody/tr/td[2]/a");
		 static By SMF_Decisionpage_decisionreason1=By.xpath("//*[@id='panelBody']/form/table[2]/tbody/tr/td[1]/table/tbody/tr[5]/td[1]");
		 static By SMF_Decisionpage_decisionreason2=By.xpath("//*[@id='panelBody']/form/table[2]/tbody/tr/td[1]/table/tbody/tr[5]/td[2]");
		 static By SMF_Decisionpage_decisionreason3=By.xpath("//*[@id='panelBody']/form/table[2]/tbody/tr/td[1]/table/tbody/tr[4]/td[2]");
		 static By SMF_Decisionpage_decisionpageAPR=By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr[9]/td[4]");
	
	//Eignpage	
		//esign common continue
		static By SMF_Esign_Continue=By.id("continue");
		//Esign
		static By SMF_EsigncancelMsg=By.xpath("//*[@id='aws_main_pane']/h1");
		static By SMF_EsignimportantInforpage_Precontract=By.id("printConsent");
		static By SMF_Esign_delaerFirstname=By.id("agentfirstName");
		static By SMF_Esign_delaerLastname=By.id("agentlastName");
		static By SMF_Esign_Drivelicencenumber=By.name("drivingLicenceNumber");
		static By SMF_Esign_Requiredtick_checkbox=By.id("Required_tick");
		static By SMF_Esign_Clickheretosign=By.xpath("//span[@class='to_click signature_block_text']");
		static By SMF_Esign_IAccept=By.id("iAccept");
		static By SMF_Esign_Selectdocumentbuton=By.xpath("//*[@id='file_browse_wrapper']/label");  
		static By SMF_Esign_ConfirmPDFupload=By.id("evidence_upload_submit");
		static By SMF_Esign_ConfirmOkpoup=By.id("confirmPopup");
		static By SMF_Esign_RequestPayment=By.id("request_payment");
		static By SMF_Esign_Thankspage_pdfDoc=By.xpath("//*[@id='awsForm']/div/adobe_reader_link_old/div/a");
		static By SMF_Esign_SECCIPagelink=By.id("printSecciLink");
		static By SMF_Esign_Downloadagr=By.id("printAgreementLink");
		static By SMF_Esign_Fileformatypeerrormsg=By.xpath("//*[@id='evidence_upload_message']");
		static By SMF_Esign_Timeoutwaringmsg=By.id("timeout-watchdog-extend-time");
		static By SMF_Esign_WarningPoUptitle=By.xpath("//*[@id='ui-dialog-title-1']");
		static By SMF_Esign_SessionTimedoutmsg=By.xpath("//*[@id='awsForm']/timeout_instructions/h1");
		static By SMF_Esign_reverttowetsign=By.id("wetSign");
		static By SMF_Esign_DownloadagrPDflink=By.id("wetSignDownloadAgreement");
		static By SMF_Esign_EsignRevertCancelmsg=By.xpath("//*[@id='awsForm']/instructions/h1");
		static By SMF_Esign_EsignDownloadagr_link=By.id("downloadAgreement");
		static By SMF_Esign_EsignSecuritywarningMsg=By.xpath("//*[@id='kba_fail_message']/p/error_message_kba");
		static By SMF_Esign_EsignredoIdentitymsg=By.xpath("//*[@id='awsForm']/h1");
		static By SMF_Esign_EsigndriveerrorMsg=By.id("error-message");
		static By SMF_Esign_EsignDonotProceed=By.id("doNotProceed");
		static By SMF_Esign_EsignCancelagr=By.id("cancelAgreement");
		static By SMF_Esign_Esignagrcancelledmsg=By.xpath("//*[@id='awsForm']/instructions_onpremise/h1");
		static By SMF_Esign_EsignExit=By.id("exit");
		static By SMF_Esign_EsignCloseSaveExitPopup=By.id("closeSaveExit");
		static By SMF_Esign_Fileuploadtickbox=By.id("requiredTick");
	
		
		//Payout and golive page:
		static By SMF_PayoutGolive=By.linkText("Payout & Golive");
		static By SMF_Payout_DocreceivedSpace=By.xpath("//*[@id='panelBody']/form/table[1]/tbody/tr/td[2]");
		static By SMF_Payout_Docreceived=By.linkText("Docs Received");
		static By SMF_Payout_DocreceivePopUp=By.xpath("//*[@id='sitebody']/div[4]/div[3]/div/button[1]/span");
		static By SMF_Payout_TopendStatus=By.xpath("//div[@id='topStrip']/span[10]");
		static By SMF_Payout_Advance=By.name("documentAdvance");
		static By SMF_Payout_Intsallment=By.name("documentInstalment");
		static By SMF_Payout_Balloon=By.name("documentBalloon");
		static By SMF_Payout_DocumentFee=By.name("documentDocumentFee");
		static By SMF_Payout_1stcheckvalidate=By.linkText("1st Check Validated");
		static By SMF_Payout_StatusvalidatePopup=By.xpath("//*[@id='sitebody']/div[5]/div[3]/div/button[1]/span");
		static By SMF_Payout_ConfirmSpecialterms=By.linkText("Confirm Special Terms");
		static By SMF_Payout_UnConfirmSpecialterms=By.linkText("Unconfirm Special Terms");
		static By SMF_Payout_DocsApproved=By.linkText("Docs Approved");
		static By SMF_Navigate_DecisiontoTerms=By.xpath("//*[@id='navStrip']/p[1]/a[1]");
		static By SMF_NavigatetoFinancials=By.xpath("//*[@id='navStrip']/p[7]/a[1]");   
		static By SMF_Payout_ManageDocError=By.linkText("Manage Doc Errors");
		static By SMF_Payout_ClickDrivelicenseConfirmtickbox=By.xpath("//*[@id='docPackErrorsTable']/tbody/tr[22]/td[1]/input[1]");
		static By SMF_Payout_DocsReceivedwithErrors=By.linkText("Docs Received with Errors");
		//Bottom links
		 static By SMF_DecisionbottonNewagreement_Link =By.linkText("new agreement");
		 
		//Back Office login
		//Back Office Login
		static By UsernameBO = By.xpath("//input[@type='text']");
		static By PasswordBO = By.xpath("//input[@type='password']");
		static By LoginbuttonBO=By.xpath("/html/body/div[2]/div[2]/div/div[3]/div");
		
		//Bo home page:
		static By BOhome_Openlink=By.xpath("//div[text()='Open']");
		static By BOhome_Agreementservicing=By.xpath("/html/body/div[4]/div/div[1]/div[1]"); 
		static By BOhome_MainCustomerAgreementslink=By.xpath("/html/body/div[5]/div/div[2]"); 
		static By BOhome_Agreementinputbox=By.xpath("/html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/input"); 
		static By BOhome_Agreementfindlink=By.xpath("/html/body/div[6]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div"); 
		static By BOhome_Agreementdetailslink=By.xpath("/html/body/div[6]/div[2]/div/div/div[1]/div/div/div[3]/div[2]"); 
		static By BOhome_Customerdetailsbuton=By.xpath("/html/body/div[6]/div[2]/div/div/div[2]/div/div/div[3]/div[2]");
		static By BOhome_Batches=By.xpath("/html/body/div[4]/div/div[4]");
		//MAD wndow
		static By BOMADWindow_Agreementstatus=By.xpath("/html/body/div[7]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[2]/input"); 
		static By BOMADWindow_View=By.xpath("/html/body/div[7]/div[2]/div[3]");
		static By BOMADWindow_ViewSchedules=By.xpath("/html/body/div[8]/div/div[13]"); 
		static By BOMADWindow_Installmentamnt=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div[1]/div[2]");
		static By BOMADWindow_InstallmentamntScrolldown=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div[3]/div");
		static By BOMADWindow_Balloonamnt=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div[6]/div[2]");
		static By BOMADWindow_ViewClose=By.xpath("/html/body/div[9]/div[3]/div[1]");
		static By BOMADWindow_Agreementlevelbutton=By.xpath("/html/body/div[7]/div[4]/div/div/div[1]/div/div/div/div/div[2]"); 
		static By BOMADWindow_Selectagreement=By.xpath("/html/body/div[9]/div[2]/div/div/div/div/div/div[1]/div/div[2]");
		static By BOMADWindow_AgreementlevelOKbutton=By.xpath("/html/body/div[9]/div[3]/div[1]/div");
		static By BOMADWindow_Maintainlink=By.xpath("/html/body/div[7]/div[2]/div[4]/div[1]");
		static By BOMADWindow_MaintainAddtionalAttributes=By.xpath("/html/body/div[9]/div/div[1]/div");
		static By BOMADWindow_MaintainAddtionalAttributeScrolldown=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div");  
		static By BOMADWindow_Tracescore=By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div[2]/div[1]/div/div[16]/div[4]");    
		static By BOMADWindow_MaintainAddtionalAttributeSave=By.xpath("/html/body/div[10]/div[3]/div[1]");
		static By BOMADWindow_MadWindowClose=By.xpath("/html/body/div[7]/div[1]/div[1]/div[4]/div");
		static By BOhome_MainCustomerAgreementswindowClose=By.xpath("/html/body/div[6]/div[1]/div[1]/div[5]/div");
		
		
		//new BO:
		static By BOhome_Agreementservicinglink=By.name("MainUI.Open.Agreement Servicing"); 
		static By BOhome_MainCustomerAgreements=By.name("MainUI.Open.Maintain Customer Agreements"); 
		static By BOhome_Agreement=By.name("FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.dfAgreementNumber"); 
		static By BOhome_Agreementfind=By.name("FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbFind"); 
		static By BOhome_Agreementdetails=By.name("FindCustomersAndAgreementsWindow.FindAgreementsForCustomersView.pbDetails"); 
		static By BOhome_Customerdetails=By.name("/html/body/div[6]/div[2]/div/div/div[2]/div/div/div[3]/div[2]");
		
		//Customer details screen
		static By BOhome_CusdetailsViewCreditrefrequest=By.xpath("//html/body/div[8]/div/div[2]");
		static By BOhome_GridFilter=By.xpath("//div[text()='Filter']");
		static By BOhome_CreditrefFilterAgreementnumber=By.xpath("//html/body/div[10]/div[2]/div/div/div[1]/div/div/div/div/div[2]/div[1]/input");
	
		static By BOhome_FilterTypeDDL=By.xpath("/html/body/div[10]/div[2]/div/div/div[1]/div/div/div/div/div[8]/div[2]");
		
		static By BOhome_SelectCallreportBSB=By.xpath("//html/body/div[11]/div/div[1]/div/div[2]/div");
		static By BOhome_GridApplyFilter=By.xpath("//div[text()='Apply Filter']");
		static By BOhome_GridScrolldown=By.xpath("/html/body/div[11]/div/div[3]/div[3]/div");
		static By BOhome_CreditrefResponse=By.xpath("//div[text()='Response']");
		static By BOhome_CreditrefResponseClose=By.xpath("/html/body/div[10]/div[3]/div[1]");
		
		static By BOhome_SelectCallreportAfforadbiltycehck=By.xpath("/html/body/div[11]/div/div[1]/div/div[4]/div");
		
		static By BOhome_SelectDealfloidentity=By.xpath("/html/body/div[11]/div/div[1]/div/div[5]/div");
		
		static By BOhome_CreditrefResponseWindowClose=By.xpath("/html/body/div[9]/div[1]/div[1]/div[4]/div");
		
		//Batches
		static By BOhome_DisplayBatchJobqueues=By.xpath("/html/body/div[5]/div/div[1]");
		static By BOhome_Batchsubmit=By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div[1]/div[4]/div[1]");
		static By BOhome_BatchJobname=By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[2]/div[1]/input");
		static By BOhome_BatchClicknow=By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[6]/div[2]");
		static By BOhome_BatchSave=By.xpath("/html/body/div[7]/div[3]/div[1]");
		static By BOhome_BatchAutomaticRefresh=By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div[4]/div[2]/div[1]");
		static By BOhome_Bocureentsysdate=By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div");
		static By BOhome_Batchrunstatus=By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div[3]/div[3]/div[1]/div/div[1]/div[8]");
		static By BOhome_Batchjobnameingrid=By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div[3]/div[3]/div[1]/div/div[1]/div[2]");
		static By BOhome_Batchstartdate=By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div[3]/div[3]/div[1]/div/div[1]/div[6]");
		static By BOhome_Batchpageclose=By.xpath("/html/body/div[6]/div[3]/div[1]");
		
		//footer
		static By Motorfrontend_footernewAgreement=By.xpath("//div[@id='footer']/p/a[5]");
	}



