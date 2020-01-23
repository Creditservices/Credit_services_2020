package OpenUniversity;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;

public class Pom_Openuniversity 

{
   
	//Front office Login
	static By UsernameFO = By.name("username");
	static By PasswordFO = By.name("password");
	static By SubmitFO = By.xpath("//a[@id='PanLinkSubmit']");
	
	//Front Office Agreement Search
	static By FO_AgreementNumber = By.name("agreementNumber");
	static By FO_SubmitAgreement = By.xpath("//a[@id='PanLinkSubmit_0']");
	static By FO_Agreementstatus =By.xpath("//div[@id='main']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[2]");
	static By FO_AgreementLink =By.xpath("//a[@class='linkWithBullet']");
	
	//Front office approve Action
	static By FO_Approvebutton =By.xpath("//a[@href='/panCoreSaas/app?component=%24PanDirectLink_65&page=NewBusiness%2FNBSummary&service=direct&session=T&sp=S100061']");
	static By FO_Clickapprovebutton =By.linkText("Approve");
	static By FO_Agrapprovestatus =By.xpath("//*[@id='PanForm']/div[2]/div/span[1]/span");
	
	//Front Office Logout
	static By Fo_Logout_Button = By.xpath("//a[@id='PanDirectLink_434']");
	
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

	
	//Open university
	//Studental portal login
	static By OU_Studentportal_continuebutton=By.linkText("Continue");
	static By OU_Studentportal_Password=By.name("password");
	static By OU_Studentportal_Confirmpaswd=By.name("password2");
	static By OU_Studentportal_submitlogin=By.name("login");
	
	//Student portal actions
	//Personal details page
	static By OU_Studentporatl_continueapplicationbutton=By.name("continueApplication");
	
	//Address details page
	static By OU_Studentporatl_UKaddresslink=By.linkText("Enter UK Address");
	static By OU_Studentportal_Propertynumber=By.name("propertyNumber");
	static By OU_Studentportal_Postcode=By.name("postcode");
	static By OU_Studentportal_Searchbutton=By.name("search");
	static By OU_Studentportal_Addressnotfounlink=By.linkText("Address not found");
	static By OU_Studentportal_Addresspostcode=By.name("addressDetails.postcode");
	static By OU_Studentportal_Addressflatnum=By.name("addressDetails.flat");
	static By OU_Studentportal_Addresspropertynum=By.name("addressDetails.propertyNumber");
	static By OU_Studentportal_Addressstreetname=By.name("addressDetails.streetName");
	static By OU_Studentportal_Addressdistrict=By.name("addressDetails.district");
	static By OU_Studentportal_Addresspostaltown=By.name("addressDetails.postalTown");
	static By OU_Studentportal_Addressflatcounty=By.name("addressDetails.county");
	static By OU_Studentportal_Addressday=By.name("day");
	static By OU_Studentportal_Addressmonth=By.name("month");
	static By OU_Studentportal_AddressYear=By.name("year");
	static By OU_Studentportal_Continuebutton=By.name("continue");
	static By OU_Studentportal_Continuelink=By.linkText("Continue");
	
	//Financial page
	static By OU_Studentportal_Checkbox=By.name("consentToSearch");
	static By OU_Studentportal_Empoccupancy=By.name("person.occupancyID");
	static By OU_Studentportal_Empstatus=By.name("person.employmentStatusID");
	static By OU_Studentportal_Emppaymethod=By.name("agreement.paymentMethodID");
	//Income
	static By OU_Studentportal_Annualincome=By.name("annualIncome");
	static By OU_Studentportal_Monthlyincome=By.name("monthlyIncome");
	static By OU_Studentportal_Dividend=By.name("dividendsReceived");
	static By OU_Studentportal_Benefit=By.name("benefitsReceived");
	static By OU_Studentportal_Rent=By.name("rentReceived");
	static By OU_Studentportal_Maintenance=By.name("maintenanceReceived");
	static By OU_Studentportal_Totalincome=By.name("totalMonthlyIncome");
	//Expenditure
	static By OU_Studentportal_Creditcard=By.name("creditCards");
	static By OU_Studentportal_Loans=By.name("loans");
	static By OU_Studentportal_Counciltax=By.name("councilTax");
	static By OU_Studentportal_Utilities=By.name("utilities");
	static By OU_Studentportal_Mortgage=By.name("mortgage");
	static By OU_Studentportal_Noofdependants=By.name("numberOfDependants");
	static By OU_Studentportal_Noofadults=By.name("numberOfAdults");
	static By OU_Studentportal_Savebutton=By.name("save");
	//Employment details
	static By OU_Studentportal_Employeename=By.name("employment.employerName");
	static By OU_Studentportal_Employeetelephone=By.name("employment.telephone");
	static By OU_Studentportal_Employeepropertynumber=By.name("address.propertyNumber");
	static By OU_Studentportal_Employeestreetname=By.name("address.streetName");
	static By OU_Studentportal_Employeedistrict=By.name("address.district");
	static By OU_Studentportal_Employeeposttown=By.name("address.postalTown");
	static By OU_Studentportal_Employeepostcode=By.name("address.postcode");
	static By OU_Studentportal_Employeecounty=By.name("address.county");
	static By OU_Studentportal_Employeecountry=By.name("address.countryID");
	static By OU_Studentportal_Employeeyear=By.name("yearsWith");
	static By OU_Studentportal_Employeemonth=By.name("monthsWith");
	static By OU_Studentportal_Employeeoccupation=By.name("employment.occupation");
	static By OU_Studentportal_Employeepositionid=By.name("employment.positionID");
	static By OU_Studentportal_Employeesectorid=By.name("employment.sectorID");
	static By OU_Studentportal_Employeesave=By.name("save");
	
	//Direct Debit
	
	static By OU_Studentportal_Banksortcode=By.name("bankAccount.sortCode");
	static By OU_Studentportal_Search=By.name("search");
	static By OU_Studentportal_Banknamelink=By.linkText("BARCLAYS BANK PLC");
	static By OU_Studentportal_Bankaccountname=By.name("bankAccount.accountName");
	static By OU_Studentportal_Bankaccountnumber=By.name("bankAccount.accountNumber");
	static By OU_Studentportal_Onesignature=By.name("oneSignature");
	static By OU_Studentportal_Directdebitsave=By.name("save");
	static By OU_Studentportal_Directdebitcontinue=By.linkText("Continue");
	static By OU_Studentportal_DDconitue=By.linkText("Continue");
	static By OU_Studentportal_DDContinuewithapplink=By.linkText("Continue with application");
	static By OU_Studentportal_OuStudentstatus=By.xpath("//*[@id='ou-content']/h1");
	static By OU_Studentportal_finishbutton=By.linkText("Finish");
	
	//OU staff portal login
	
	static By OUStaffcontinuelink =By.linkText("Continue");
	static By UsernameOUstaff =By.name("username");
	static By PasswordOUstaff =By.name("password");
	static By SubmitOUlogin=By.name("login");
	
	//OU Staff Portal
	//
	static By OUStaff_Pinumber =By.name("piNumber");
	static By OUStaff_Seacrhbutton=By.name("search");
	static By OUStaff_PIdetails=By.xpath("//*[@id='ou-content']/table/tbody/tr/td[1]/a");
	static By OUStaff_Agrstatus=By.xpath("//*[@id='ou-content']/table/tbody/tr/td[5]");
	static By OUStaff_Agreementlink=By.xpath("//*[@id='ou-content']/table/tbody/tr/td[1]/a");
	static By OUStaff_Continueapplicationbutton=By.name("continueApplication");
	static By OUStaff_Checkbox =By.name("consented");
	static By OUStaff_Save=By.name("save");
	static By OUStaff_logout=By.linkText("Log out");
	
	
	//Back Office login
	//Back Office Login
	static By UsernameBO = By.xpath("//input[@type='text']");
	static By PasswordBO = By.xpath("//input[@type='password']");
	static By LoginbuttonBO=By.xpath("/html/body/div[2]/div[2]/div/div[3]/div");
	
}
