package Provident;

import java.util.Arrays;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.*;

public class Provident extends Driver {

	public static Recordset Prov_recordset1, Prov_recordset2;
	public static Connection connection;
	public static Fillo fillo;
	public static String strQuery, str, getref, bindingvalue;
	public static List<String> KeywordList = Arrays.asList();
	public static int i, flag;
	public static boolean Testchange;

	public static void main(String args[]) throws Exception {

		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		Configuration.updatePropertyFile("Project", "Startexecuted", "True");

		Driver.Project_ToRun("Provident");

	}

	public static void ProvidentInitiated(String getKeyword) throws NullPointerException, Exception

	{
		String methodname = null;
		try {
			Prov_recordset1 = Driver.testCasetoExecute();
			System.out.println("******************No.of Testcases to be Executing :"+Prov_recordset1.getCount()+"**********************");

			while (Prov_recordset1.next()) {
				System.out.println("Test sceanrio:"   +Prov_recordset1.getField("Testcase"));
				Configuration.updatePropertyFile("Project", "Execution_continues", "True");
				Utilities.reportinitiated(Prov_recordset1);
				KeywordList = Driver.methodstoExecute(Prov_recordset1);
				System.out.println(KeywordList.size());
				System.out.println(KeywordList);
				bindingvalue = Prov_recordset1.getField("DATABINDING");
				

				for (i = 0; i <= KeywordList.size() - 1; i++) {
					Configuration.getProperty();
					
					if (Configuration.Lastvalue.equalsIgnoreCase("True")) {
						refreshSheet1(bindingvalue,Prov_recordset1);
						switch (KeywordList.get(i)) {
						
						case "agrGenerator":
							provident_Api.agrGenerator(Prov_recordset1);
							break;
							
						case "get_personID":
							provident_Api.get_personID();
							break;
						
							
						case "applicationValue":
							
							provident_Api.applicationValue(Prov_recordset1);
							refreshSheet1(bindingvalue,Prov_recordset1);
							
							break;
							
						case "applicationBankValue":
							provident_Api.applicationBankValue(Prov_recordset1);
							//provident_Api.applicationCardValue(Prov_recordset1);
							break;
							
						case "applicationCardValue":
							provident_Api.applicationCardValue(Prov_recordset1);
							break;
							
						case "applicationESignatureValue":
							provident_Api.applicationESignatureValue(Prov_recordset1);
							break;
							
						case "updateAgreementValue":
							//refreshSheet1(bindingvalue,Prov_recordset1);
							provident_Api.updateAgreementValue(Prov_recordset1);
							break;
							
						case "Batchrun":
							Backoffice.Batchrun(Prov_recordset1);
							break;
							
						case "InitiateChromeDriver":
							Common_Property.IntiateBrowser();
							break;
						case "Launch_API_Url":
							ProvidentAPI.Launch_API_Url();
							break;
						case "APILogin":
							ProvidentAPI.APILogin();
							break;

						case "BO_Login":
							Common_Property.BO_Login();
							break;

						case "Get_XML_Source_Url":
							ProvidentAPI.Get_XML_Source_Url();
							break;

						case "Application_Known":
							ProvidentAPI.Application_Known();
							break;

						case "Application":
							ProvidentAPI.Application(Prov_recordset1);
							Driver.refreshSheet1(bindingvalue,Prov_recordset1);
							break;

						case "Launch_ApplicationBank":
							ProvidentAPI.Launch_ApplicationBank();
							break;

						case "Launch_ApplicationCard":
							ProvidentAPI.Launch_ApplicationCard();
							break;

						case "Launch_Esignature":
							ProvidentAPI.Launch_Esignature();
							break;

						case "Launch_updatestatus":
							ProvidentAPI.Launch_updatestatus();
							break;

						case "Launch_updatestatus_Batch":
							ProvidentAPI.Launch_updatestatus_Batch();
							break;

						case "Bank_Status":
							ProvidentAPI.Bank_Status();
							break;

						case "AppCard_Status":
							ProvidentAPI.AppCard_Status();
							break;

						case "E_Signature_Status":
							ProvidentAPI.E_Signature_Status();
							break;

						case "UpdateAgreement_Status":
							ProvidentAPI.UpdateAgreement_Status();
							break;

						case "BO_Status_check":
							ProvidentAPI.BO_Status_check();
							break;

						case "Launch_Backoffice_Url":
							Common_Property.Launch_Backoffice_Url();
							break;

						case "Launch_FrontOffice_URL":
							Common_Property.Launch_FrontOffice_URL();
							break;

						case "FO_Login":
							Common_Property.FO_Login();
							break;

						case "Paymentdate_FO":
							Frontoffice.Paymentdate_FO();
							break;

						case "Paymentdate_BO":
							Backoffice.Paymentdate_BO();
							break;

						case "documentverifcation_BO":
							Backoffice.documentverifcation_BO();
							break;

						case "letter_FO":
							Frontoffice.letter_FO();
							break;

						case "DocumentVerification":
							Backoffice.BO_DocumentVerification();
							break;

						case "letter_MODN":
							Frontoffice.letter_MODN();
							break;

						case "letterMONA_FO":
							Frontoffice.letterMONA_FO();
							break;

						case "Temporary_Arrangement":
							Backoffice.Temporary_Arrangement();
							break;

						case "BO_Address":
							Backoffice.BO_Address();
							break;

						case "BO_DocumentVerification_WelcomePack":
							Backoffice.BO_DocumentVerification_WelcomePack();
							break;

						case "FO_NewAtAddress":
							Frontoffice.FO_NewAtAddress();
							break;

						case "FO_BankDetails":
							Frontoffice.FO_BankDetails();
							break;

						case "FO_PersonalDetail":
							Frontoffice.FO_PersonalDetail();
							break;

						case "BO_Settlement_Quote":
							Backoffice.BO_Settlement_Quote();
							break;

						case "BO_cashposting":
							Backoffice.BO_cashposting();
							break;

						case "BO_StopCategory":
							Backoffice.BO_StopCategory();
							break;

						case "FO_PaymentMethod":
							Frontoffice.FO_PaymentMethod();
							break;

						case "FO_withdrawnotification":
							Frontoffice.FO_withdrawnotification();
							break;

						case "BO_Reshedule":
							Backoffice.BO_Reshedule();
							break;

						case "BO_Refund":
							Backoffice.BO_Refund();
							break;

						case "CPA_Creation":
							Frontoffice.CPA_Creation();
							break;

						case "BO_GetFinalDate":
							Backoffice.BO_GetFinalDate();
							break;

						case "BO_CheckWriteoff":
							Backoffice.BO_CheckWriteoff();
							break;

						case "FO_temporary_arrangement":
							Frontoffice.FO_temporary_arrangement();
							break;

						case "FO_POSTPAYMENT":
							Frontoffice.FO_POSTPAYMENT();
							break;
							
						case "Fo_refund":
							Frontoffice.Fo_refund();
							break;
							
							

						case "BO_DateMatch":
							Backoffice.BO_DateMatch();
							break;

						case "FO_highamount_temparg":
							Frontoffice.FO_highamount_temparg();
							break;

						case "FO_Oneoff_Payment":
							Frontoffice.FO_Oneoff_Payment();
							break;

						case "FO_PAYMENT":
							Frontoffice.FO_PAYMENT();
							break;
							
							
						case "Check_autochange":
							Backoffice.Check_autochange();
							break;
							
						case "BO_Early_settlement":
							Backoffice.BO_Early_settlement();
							break;
							
						case "Reverse_Esettle":
							Backoffice.Reverse_Esettle();
							break;
							

						}

					} else {
						break;
					}
				}

			}

		}

		catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

	}

}
