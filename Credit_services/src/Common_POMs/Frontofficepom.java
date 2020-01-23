package Common_POMs;
import org.openqa.selenium.By;

public class Frontofficepom {
	//Front office Login
	static By UsernameFO = By.xpath("//input[@name='username']");
	static By PasswordFO = By.xpath("//input[@name='password']");
	static By SubmitFO = By.xpath("//a[@id='PanLinkSubmit']");
	//Front Office Logout
	static By Fo_Home_Button = By.xpath("//span[@id='bannermenu']/a/span");
	static By Newproposal_Button = By.xpath("//span[@id='bannermenu']/a[2]/span");
	static By Servicing_Button = By.xpath("//span[@id='bannermenu']/a[3]/span");
	static By Fo_Logout_Button = By.xpath("//div[@class='content']/div/a[3]");
	//New Customer
	static By Surname = By.xpath("//input[@name='surname']");
	static By Forename = By.xpath("//input[@name='forename']");
	static By Postcode = By.xpath("//input[@name='postcode']");
	static By Customer_search = By.xpath("//*[@id='PanLinkSubmit']");
	static By Com_Continue = By.xpath("//div[@class='submitButtons']/a");
	static By Exisitng_customer = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td/a");
	static By LO_Close = By.xpath("//div[@class='submitButtons']/a[6]");
	//Pre_Qualification
	static By Loan_Purpose = By.xpath("//*[@id='loanPurposeID']");
	static By Loan_Amount = By.xpath("//input[@id='loanAmount']");
	static By Source_ID = By.xpath("//*[@id='sourceCodeID']");
	static By DOB = By.xpath("//input[@id='dateOfBirth']");
	static By Netincome = By.xpath("//input[@id='netMonthlyIncome']");
	static By Currentdebit_manage = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/input[2]");
	static By Direct_debits = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div/table/tbody/tr[3]/td[2]/input");
	static By HomeownerButton = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[4]/input");
	static By HomeownerNoButton = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[4]/input[2]");
	static By UnEmployedButton = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[3]/td/input");
	static By EmployedButton = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td/input");
	static By SelfEmployedButton = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td/input");
	static By SelfEmployedYesButton = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input");
	static By JointButton = By.xpath("//div[@id='main']/form/div[2]/div[3]/div/table/tbody/tr/td/input[2]");
	static By Decision_check = By.xpath("//*[@id='Form']/div[2]/div[1]/div/div/span[1]");
	//Name and Address
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
	//Personal details
	static By Residential_Status = By.xpath("//*[@id='residentialStatus']");
	static By Tenancy = By.xpath("//*[@id='personalDetailsForm']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input[2]");
	static By Rent_payment = By.xpath("//input[@id='rentPayment']");
	static By Rent_payment1 = By.xpath("//*[@id='ValidationGroupDropList_0']");
	static By Rent_payment2 = By.xpath("//*[@id='ValidationGroupDropList']");
	static By Arrear_Balance = By.xpath("//input[@name='textfield333']");
	static By Landlord_name = By.xpath("//input[@id='landlordName']");
	static By House_Value = By.xpath("//input[@id='houseValue']");
	static By Boardpayment = By.xpath("//input[@id='jointHomeownerPayment']");
	static By Nameofmortgage = By.xpath("//input[@id='mortgageLender']");
	static By mortgageblnz = By.xpath("//input[@id='mortgageBalance']");
	static By Mortgagepay = By.xpath("//input[@id='monthlyPayment']");
	static By Hometelephone = By.xpath("//input[@id='homeTelephone']");
	static By Mobile_No = By.xpath("//input[@id='mobileNumber']");
	static By shared_ownership = By.xpath("//div[@id='main']/form/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/input");
	static By Allowcontacthome = By.xpath("//*[@id='allowContactHome']");
	static By Allowcontactwork = By.xpath("//*[@id='allowContactWork']");
	static By Allowcontactmble = By.xpath("//*[@id='allowContactMobile']");
	static By Preferredpaydate = By.xpath("//*[@id='PropertySelection_1']");
	static By Emailaddress = By.xpath("//input[@id='emailAddress']");
	//Employment details
	static By Companyname = By.xpath("//input[@id='companyName']");
	static By CompanySearch = By.xpath("//*[@id='companySearch']");
	static By CompanySearch1 = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td/a");
	static By CompanySearch2 = By.xpath("//table[@class='resultTable']/tbody/tr[4]/td/a");
	static By Empposition = By.xpath("//*[@id='position']");
	static By Empstartdate = By.xpath("//input[@id='employmentStart']");
	static By EmpstartVal = By.xpath("//*[@id='validationDisplay']");
	static By Empvalclose = By.xpath("//div[@id='main']/div[2]/span/a");
	static By FormerJobs = By.xpath("//*[@id='formerJobs']");
	//Affordability Matrix
	static By Mainsalary = By.xpath("//input[@name='TextField_5']");
	static By Mainsalarymonth = By.xpath("//*[@name='ValidationGroupDropList_5']");
	//Bank Account
	static By sortcode1 = By.xpath("//input[@id='sortCode1']");
	static By sortcode2 = By.xpath("//input[@id='sortCode2']");
	static By sortcode3 = By.xpath("//input[@id='sortCode3']");
	static By sortcodesearch = By.xpath("//*[@id='search']");
	static By sortcodeselect = By.xpath("//div[@class='results']/table/tbody/tr[2]/td/a");
	static By Accountnumber = By.xpath("//input[@id='accountNumber']");
	static By Accountname = By.xpath("//input[@id='accountName']");
	static By TimeatAddressYrs = By.xpath("//input[@id='yearsAtBankField']");
	static By TimeatAddressmnth = By.xpath("//*[@id='PropertySelection']");
	//Summary product
	static By SummProduct = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr/td[2]");
	static By SummLoanAmount = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]");
	static By SummLoanInstalment = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]");
	static By SummAmountoffeepayment = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]");
	static By SummRemainingIncome = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[7]/td[2]");
	static By SummTotalRepayable = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr/td[4]");
	static By Summnooffeerepayments = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[3]/td[4]");
	static By SummNoofloanrepayments = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td[4]");
	static By Summpaymentdate = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[4]/td[4]");
	static By SummReqLoanAmount = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[4]");
	static By SummDisposalIncome = By.xpath("//div[@id='main']/form/div[2]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[7]/td[4]");
	//Loan option
	static By Loanoption = By.xpath("//*[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBLoanOptions&sp=S100071']");
	static By Newoption = By.xpath("//div[@class='submitButtons']/a[3]");
	//New option
	static By Product = By.xpath("//*[@id='productID']");
	static By cashtocustomer = By.xpath("//input[@id='cashToCustomer']");
	static By Rate = By.xpath("//*[@id='rateMarginHeaderIDList']");
	static By Term = By.xpath("//input[@id='term']");
	static By Recalculate = By.xpath("//*[@id='PanLinkSubmit_4']");
	static By Totaldocumentfee = By.xpath("//*[@id='TextField']");
	static By Noofdocumentfeerepayment = By.xpath("//div[@id='main']/form/div[2]/div/div[3]/table/tbody/tr[2]/td[4]");
	static By documentfeerepay = By.xpath("//div[@id='main']/form/div[2]/div/div[3]/table/tbody/tr[3]/td[4]");
	static By Noofloanrepayments = By.xpath("//div[@id='main']/form/div[2]/div/div[3]/table/tbody/tr[4]/td[4]");
	static By Loanrepaymentamount = By.xpath("//div[@id='main']/form/div[2]/div/div[3]/table/tbody/tr[5]/td[4]");
	static By Firstduedate = By.xpath("//div[@id='main']/form/div[2]/div/div[3]/table/tbody/tr[10]/td[4]");
	static By Firstduedate1 = By.xpath("//input[@id='firstDueDateField']");
	static By New_optionsave = By.xpath("//span[@id='saveButtonDisplay']/a");
	static By New_optionClose = By.xpath("//a[@class='actionButton']");
	static By Loanoption_Close = By.xpath("//div[@class='submitButtons']/a[6]");
	static By Personaldetails_pagebutton= By.xpath("//a[@id='PanLinkSubmit_1']");
	static By Summary_pagebutton= By.xpath("//a[@id='PanLinkSubmit_6']");
	static By contrasel_Button = By.xpath("//td[@id='exludedChange']/input");
	//Insurance cover
	static By Insurance_cover = By.xpath("//*[@id='PanLinkSubmit_5']");
	static By Main1 = By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[2]/td[2]/input[2]");
	static By Main2 = By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[4]/td[2]/input[2]");
	static By Main3 = By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[6]/td[2]/input[2]");
	static By Joint1 = By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[2]/td[3]/input[2]");
	static By Joint2 = By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[4]/td[3]/input[2]");
	static By Joint3 = By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[6]/td[3]/input[2]");
	static By Insurancetpe = By.xpath("//table[@class='entryTable']/tbody/tr/td/input[8]");
	static By Insurancetpesingle1 = By.xpath("//table[@class='entryTable']/tbody/tr/td/input");
	static By Insurancetpesingle = By.xpath("//table[@class='entryTable']/tbody/tr/td/input[4]");
	static By EDLTermlife = By.xpath("//*[@id='TextField_1']");
	static By Calculatepremium = By.xpath("//*[@id='PanLinkSubmit_0']");
	static By Totalpremium = By.xpath("//div[@id='main']/form/div[2]/div/div[2]/table/tbody/tr[6]/td[3]");
	static By Totalpremium1 = By.xpath("//div[@id='main']/form/div[2]/div/div[2]/table/tbody/tr[5]/td[3]");
	static By Insurancesave = By.xpath("//*[@id='PanLinkSubmit_2']");
	//Loan option validation
	static By LOProduct = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td");
	static By LOC2C = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[3]");
	static By Ancillaryins = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[4]");
	static By Consolamount = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[5]");
	static By Totalamount = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[6]");
	static By LoanRepayWithoutIns = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[7]");
	static By AveragecreditorIns = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[8]");
	static By CombinedRepayment = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[9]");
	static By DocFeeRepayment = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[10]");
	static By Repaymentsaving = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[11]");
	static By LOTerm = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[13]");
	static By LONoofDocFeeRepay = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[14]");
	static By LOFirstduedate = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[15]");
	static By LOAPR = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[16]");
	static By CreditorInsurance = By.xpath("//table[@class='resultTable']/tbody/tr[2]/td[17]");
	static By LOProduct1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td");
	static By LOC2C1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[3]");
	static By Ancillaryins1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[4]");
	static By Consolamount1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[5]");
	static By Totalamount1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[6]");
	static By LoanRepayWithoutIns1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[7]");
	static By AveragecreditorIns1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[8]");
	static By CombinedRepayment1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[9]");
	static By DocFeeRepayment1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[10]");
	static By Repaymentsaving1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[11]");
	static By LOTerm1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[13]");
	static By LONoofDocFeeRepay1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[14]");
	static By LOFirstduedate1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[15]");
	static By LOAPR1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[16]");
	static By CreditorInsurance1 = By.xpath("//table[@class='resultTable']/tbody/tr[3]/td[17]");
	static By Takeup = By.xpath("//a[@href='/edlBranch/app?component=%24PanDirectLink_0&page=NewBusiness%2FNBLoanOptions&service=direct&session=T&state:NewBusiness/NBLoanOptions=ZH4sIAAAAAAAAAFvzloG1XIiBgYGZgYE7ubSoKDWvJCAxPbW4iEEwK7EsUS8nMS9dzzOvJDU9tUjo0YIl3xvbLZgYGD0ZWMsSc0pTK4oYBBDq%2FEpzk1KL2tZMleWe8qCbiYGhogBoNCPIAn6Y4fnFmSWZ%2BXnFhQx1DGBQzs%2FAwINktRFcihEAznnhCp4AAAA%3D']");
	//Queue Proposal
	static By Queue_proposal = By.xpath("//*[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBQueueProposal&sp=S100072']");
	static By Work_queue = By.xpath("//*[@id='plan']");
	static By Retain_queue = By.xpath("//*[@id='retainPlan']");
	static By queue = By.xpath("//*[@id='PanLinkSubmit_0']");
	//Front Office Agreement Search
	static By AgrNo_Fetch = By.xpath("//div[@id='main']/div/span[3]/span");
	static By AgrNo_Fetch1 = By.xpath("//div[@class='scriptText']");
	static By FO_AgreementNumber = By.xpath("//input[@id='agreementNumber']");
	static By FO_SubmitAgreement = By.xpath("//a[@id='PanLinkSubmit_0']");
	static By statuscheck = By.xpath("//*[@id='main']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[2]");
	static By FO_AgreementLink = By.xpath("//a[@class='linkWithBullet']");
	//Front office servicing
		//Course details action
	
		static By FO_Clickcoursedetailslink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[2]/a");
		static By FO_Getidentifier=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[1]");
		static By FO_Getreference=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]");
		static By FO_Getagrnumber=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
		static By FO_GetStartdate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]");
		static By FO_GetEnddate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[6]");
		static By FO_GetCost=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[7]");
		static By FO_detailstable=By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/table/tbody/tr/td");
		static By FO_CoursedetailsClosebutton=By.linkText("Close");
		
		//Front office servicing
		//Change of Due date
		static By FO_Paymentdatelink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/a");
		static By FO_Duedatetype=By.xpath("//select[@id='dueDateId']");
		static By FO_Newnextpaymentdate=By.xpath("//input[@id='newNextPaymentDate']");
		static By FO_Paymentdatesave=By.xpath("//a[@id='PanLinkSubmit']");
		static By FO_Errormsg=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[2]/td");
		static By FO_Errormsgback=By.linkText("Back");
		
		//Front office servicing
		//View schedules action 
		static By FO_Viewscheduleslink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/a");
		static By FO_Viewschedulefirstrow=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[1]");
		static By FO_Viewschedulesecondrow=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[1]");
		static By FO_Viewschedulethirdrow=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[4]/td[1]");
		static By FO_Viewschedulestype=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[1]");
		static By FO_Viewschedulesnoofpay=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]");
		static By FO_Viewschedulesterms=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[3]");
		static By FO_Viewschedulesstatus=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
		static By FO_Viewschedulesstartdate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]");
		static By FO_Viewschedulesenddate=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[6]");
		static By FO_ViewschedulesDuedate=By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]");
		static By FO_Viewschedulesinsamnt=By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[2]");
		static By FO_closebutton=By.linkText("Close");
		
		//Front office servicing
		//withdrawal notification
		static By FO_Withdrawalnotificlink=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[9]/td[2]/a");
		static By FO_Withdrawalnotificdate=By.name("withdrawalNotificationDate");
		static By FO_Withdrawalnotificsave=By.linkText("Save");
		static By FO_Withdrawalnotificblock=By.xpath("//*[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[14]/td[4]");
		static By FO_Withdrawalnotificproporate=By.xpath("//*[@id='PanForm']/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/table/tbody/tr[15]/td[4]");
		
		//Front office servicing
		//Agreement history		
		static By FO_Agreementmorelink=By.linkText("More...");
		static By FO_Commontypeevent=By.xpath("//*[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
		static By FO_Withdraweve1=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[4]");
		static By FO_Withdraweve1value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[5]");
		static By FO_Withdraweve2=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[4]");
		static By FO_Withdraweve2value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[5]");
		static By FO_Withdrweve1=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[20]/td[4]");
		static By FO_Withdrweve1value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[20]/td[5]");
		static By FO_Withdrweve2=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[19]/td[4]");
		static By FO_Withdrweve2value=By.xpath("//div[@id='main']/div[2]/div[1]/div[1]/table/tbody/tr[19]/td[5]");

	//Approve loan
	static By Approve_loan = By.xpath("//a[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBAcceptProposal&sp=S100061']");
	//Payout and Activate              ///         edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBAcceptProposal&sp=S100061
	static By payoutButton = By.xpath("//a[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBPayoutAndActivate&sp=S100067']");
	static By Payment_method = By.xpath("//*[@id='paymentMethod']");
	static By Chequeno = By.xpath("//input[@id='TextField']");
	//Servicing Loan amount
	static By Ser_Loanamount = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[3]/td[2]");
	static By Ser_Currentblnz = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]");
	static By Ser_Term = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]");
	static By Ser_Currentarrears = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[7]/td[2]");
	static By Ser_Loanstatus = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[4]");
	static By Ser_Creditorinstype = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td[4]");
	static By Ser_paymenttype = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[5]/td[4]");
	static By Ser_startdate = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[4]");
	static By Ser_duedate = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[8]/td[4]");
	static By Ser_maturitydate = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[10]/td[4]");
	//FO_View Schedules
	static By View_Schedules = By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td/a");
	static By sch_Duedate1 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[2]/td");
	static By sch_payamount1 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[2]/td[2]");
	static By sch_Duedate2 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[3]/td");
	static By sch_payamount2 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[3]/td[2]");
	static By sch_Next = By.xpath("//div[@id='main']/div[2]/div/div[2]/div/a[3]");
	static By sch_Duedate3 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[7]/td");
	static By sch_Duedate4 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[13]/td");
	static By sch_payamount3 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[7]/td[2]");
	static By sch_payamount4 = By.xpath("//div[@id='main']/div[2]/div/div[2]/table/tbody/tr[13]/td[2]");
	//FO View Transaction
	static By FO_Transactions=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/a");
	static By Trans_Effdate1=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[2]/td[2]");
	static By Trans_Effdate2=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[3]/td[2]");
	static By Trans_Effdate3=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[4]/td[2]");
	static By Trans_type1=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[2]/td[3]");
	static By Trans_type2=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[3]/td[3]");
	static By Trans_type3=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[4]/td[3]");
	static By Trans_type4=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[5]/td[3]");
	static By Trans_type5=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[6]/td[3]");
	static By Trans_type6=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[7]/td[3]");
	static By Trans_type7=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[8]/td[3]");
	static By Trans_type8=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[9]/td[3]");
	static By Trans_type9=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[10]/td[3]");
	static By Trans_Creditval1=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[3]/td[7]");
	static By Trans_Creditval2=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[5]/td[7]");
	static By Trans_Creditval3=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[9]/td[7]");
	static By TransVoid_Creditval=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[4]/td[7]");
	static By TransVoid_Creditval1=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[10]/td[7]");
	static By Comment1=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[2]/td[4]");
	static By Trans_Comment1=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[3]/td[4]");
	static By Comment3=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[4]/td[4]");
	static By Trans_Comment2=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[5]/td[4]");
	static By Comment5=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[6]/td[4]");
	static By Comment6=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[7]/td[4]");
	static By Comment7=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[8]/td[4]");
	static By Trans_Debitval=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[2]/td[6]");
	static By Trans_Debitval2=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[3]/td[6]");
	static By Trans_Debitval3=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[4]/td[6]");
	static By Trans_Debitval4=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[5]/td[6]");
	static By Trans_Debitval5=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[6]/td[6]");
	static By Trans_Debitval6=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[7]/td[6]");
	static By Trans_Debitval7=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[8]/td[6]");
	static By Trans_Debitval8=By.xpath("//div[@id='main']/div[2]/div/div/table/tbody/tr[9]/td[6]");
	static By FO_TransClose=By.xpath("//div[@class='submitButtons']/a");
	//Add Agreement
	static By FO_AddAgreement=By.xpath("//div[@id='main']/form/div[2]/div/div[2]/div/div[2]/span[2]/a");
	static By Nameoflender=By.xpath("//input[@id='lender']");
	static By Account_type=By.xpath("//input[@id='accountType']");
	static By org_name_amount=By.xpath("//input[@id='originalLoanAmount']");
	static By Balance=By.xpath("//input[@id='balance']");
	static By Repayment=By.xpath("//input[@id='repayment']");
	static By Term1=By.xpath("//input[@id='term']");
	static By Startdate=By.xpath("//input[@id='startDate']");
	//FO Payment date
	static By FO_paymentdate=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/a");
	static By paymentdatechgtype=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr/td[2]");
	static By paymentfallendue=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[2]/td[2]");
	static By maxforwarddate=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[3]/td[2]");
	static By maxbackwarddate=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[4]/td[2]");
	static By Nextpaymentdue=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr/td[4]");
	static By paymentdateterm=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[2]/td[4]");
	static By Timespaymentdate=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[3]/td[4]");
	static By Dayspaymentdate=By.xpath("//div[@id='main']/form/div[2]/div/div/table/tbody/tr[4]/td[4]");
	static By Newnextpaymentdate = By.xpath("//input[@id='newNextPaymentDate']");
	static By Paydatecalculate = By.xpath("//*[@id='PanLinkSubmit']");
	static By Maxerror=By.xpath("//div[@class='resultsSmall']/table/tbody/tr[2]/td");
	static By Errorback=By.xpath("//div[@class='footerRowOdd']/a[2]");
	//Reject Proposal
	static By RejectProposal=By.xpath("//*[@href='/edlBranch/app?component=%24PanDirectLink_18&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=SNewBusiness%2FNBRejectProposal&sp=S100063']");
	//Diary Forward
	static By Diary_Forward=By.xpath("//div[@class='submitButtons']/a[3]");
	//Cancellation1111
	static By cancellation_Button=By.xpath("//div[@id='main']/form/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/a");
	//Special Print Handling
	static By Additionaldetails = By.xpath("//div[@id='main']/form/div[2]/div/div/a[2]");
	static By SpecialPrintHandling = By.xpath("//select[@id='ValidationGroupDropList']");
	static By SpecialFunction1 = By.xpath("//div[@class='footerRowEven']/a");
	static By SpecialFunction2 = By.xpath("//div[@id='main']/form/div[2]/div/div/a");
	static By SpecialFunction3 = By.xpath("//div[@id='main']/form/div[2]/div/div/a[2]");

}
