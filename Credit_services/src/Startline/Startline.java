package Startline;

import java.util.Arrays;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.codoid.products.fillo.Update;

import Common_Funtions.Common_Property;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import Common_Funtions.*;

public class Startline {

	public static Recordset Startline_recordset1;
	public static Connection connection;
	public static Fillo fillo;
	public static String strQuery, str, getref, bindingvalue;
	public static List<String> KeywordList = Arrays.asList();
	public static int i, flag;
	public static boolean Testchange;

	public static void main(String args[]) throws Exception {

		Driver.Project_ToRun("Startline");

	}

	public static void StartlineInitiated(String getKeyword) throws NullPointerException, Exception

	{
		String methodname = null;
		try {
			Startline_recordset1 = Driver.testCasetoExecute();
			
				while (Startline_recordset1.next()) {
				Utilities.reportinitiated(Startline_recordset1);
				KeywordList = Driver.methodstoExecute(Startline_recordset1);
				bindingvalue = Startline_recordset1.getField("DATABINDING");

				for (i = 0; i <= KeywordList.size() - 1; i++) {

					switch (KeywordList.get(i)) {

					case "AgreementcreationV2":
						Driver.strUrl = Driver.recordset.getField("API1_url");
						Driver.xmlData = Driver.recordset.getField("CreateXMlV2");
						//SMF_RestAssured.APIHandler(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"),
								//"CreateAgreement");
						SMF_RestAssured.APIHandler(Startline_recordset1,"CreateAgreement");
						break;

					case "Agr_UpdateV2":
						String TestCaseName = Driver.recordset1.getField("Testcase");
						Driver.strUrl = Driver.recordset.getField("API3_url");
						Driver.xmlData = Driver.recordset.getField("UpdateXMLV2");

						if (TestCaseName.contains("SMF TieredPricing")) {

							Driver.xmlData = Driver.xmlData.replace("<Rate></Rate>", "<Rate>Uproposalrate</Rate>");
							Driver.xmlData = Driver.xmlData.replace("<RateType></RateType>"," <RateType>Uratetype</RateType>");
							System.out.println(Driver.xmlData);

						}
						SMF_RestAssured.APIHandler(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"),"UpdateAgreement");
						break;

					case "Agr_checkdecision":
						Driver.strUrl = Driver.recordset.getField("API4_url");
						Driver.xmlData = Driver.recordset.getField("CheckDecisionXML");
						SMF_RestAssured.APIHandler(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"),"CheckDecision");
						break;

					case "AgreementcreationV1":
						Driver.strUrl = Driver.recordset.getField("API_url");
						Driver.xmlData = Driver.recordset.getField("CreateXML");
						SMF_RestAssured.APIHandler(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"),"CreateAgreement");
						break;

					case "Agr_UpdateV1":
						Driver.strUrl = Driver.recordset.getField("API2_url");
						Driver.xmlData = Driver.recordset.getField("UpdateXML");
						SMF_RestAssured.APIHandler(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"),"UpdateAgreement");
						break;

					case "InitiateChromeDriver":
						Common_Property.IntiateBrowser();
						break;

					case "Launch_Backoffice_Url":
						Common_Property.Launch_Backoffice_Url();
						
						break;

					case "Launch_smf_Url":
						Common_Property.Launch_smf_Url();
						break;

					case "Launch_FrontOffice_URL":
						Common_Property.Launch_FrontOffice_URL();
						break;

					// Startrline LOGINS

					case "Startline_Login":
						Common_Property.Startline_Login();
						break;
					case "FO_Login":
						Common_Property.FO_Login();
						break;
					case "BO_Login":
						Common_Property.BO_Login();
						break;

					case "Quit":
						Common_Property.driver.quit();
						break;

					case "PersonSearch":
						Driver.refreshSheet1(bindingvalue,Startline.Startline_recordset1);
						MotorFrondEnd.PersonSearch();
						break;

					case "Terms":
						MotorFrondEnd.Terms();
						break;

					case "Termscontinue":
						MotorFrondEnd.Termscontinue();
						break;

					case "Personaldetails":
						MotorFrondEnd.Personaldetails();
						break;

					case "Affordabilitydetails":
						MotorFrondEnd
								.Affordabilitydetails(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"));
						break;

					case "Employmentdetails":
						MotorFrondEnd.Employmentdetails();
						break;

					case "Guarantorsdetails":
						MotorFrondEnd.Guarantorsdetails();
						break;

					case "Securitydetails":
						MotorFrondEnd.Securitydetails();
						break;

					case "Financials":
						MotorFrondEnd.Financials();
						break;

					case "CallvalBureaudatas":
						MotorFrondEnd.CallvalBureaudatas();
						break;

					case "TP_CallvalBureaudatas":
						MotorFrondEnd.TP_CallvalBureaudatas();
						break;

					case "Securitydetailsvalidation":
						MotorFrondEnd.Securitydetailsvalidation();
						break;
						
					case "PDIAgrReferred":
						MotorFrondEnd.PDIAgrReferred();
						break;


					case "PDI_Score_Validate":
						MotorFrondEnd.PDI_Score_Validate(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"));
						break;

					case "GetEsignURL":
						Driver.refreshSheet1(bindingvalue,Startline.Startline_recordset1);
						MotorFrondEnd.GetEsignURL();
						break;

					case "Esignflow":
						MotorFrondEnd.Esignflow();
						break;

					case "Redoesignflow":
						MotorFrondEnd.Redoesignflow();
						break;

					case "Fileuploadesignflow":
						MotorFrondEnd.Fileuploadesignflow();
						break;

					case "Reverttoesign":
						MotorFrondEnd.Reverttoesign();
						break;

					case "Esignsessiontimeout":
						MotorFrondEnd.Esignsessiontimeout();
						break;

					case "Prevetmanualdecline":
						MotorFrondEnd.Prevetmanualdecline();
						break;

					case "Esigncancel":
						MotorFrondEnd.Esigncancel();
						break;

					case "FLAutoRejection":
						MotorFrondEnd.FLAutoRejection();
						break;

					case "Esignsaveexit":
						MotorFrondEnd.Esignsaveexit();
						break;
					case "Esigsecurityfail":
						MotorFrondEnd.Esigsecurityfail();
						break;

					case "Esigdrivefail":
						MotorFrondEnd.Esigdrivefail();
						break;

					case "Esignpassevents":
						MotorFrondEnd.Esignpassevents();
						break;

					case "TemproraryEsigneventpassgeneration":
						MotorFrondEnd.TemproraryEsigneventpassgeneration();
						break;

					case "IOCSURL":
						Driver.refreshSheet1(bindingvalue,Startline.Startline_recordset1);
						MotorFrondEnd.IOCSURL();
						break;

					case "PutIOCSURL":
						MotorFrondEnd.PutIOCSURL();
						break;

					case "Managedocerror":
						MotorFrondEnd.Managedocerror();
						break;

					case "Agr_checkdeccomaprision":
						MotorFrondEnd.Agr_checkdeccomaprision();
						break;

					case "SMF_Notieredpricingrates":
						MotorFrondEnd.SMF_Notieredpricingrates();
						break;

					case "Agreementrigrredo":
						MotorFrondEnd.Agreementrigrredo();
						break;

					case "Agr_afteresign_redo":
						MotorFrondEnd.Agr_afteresign_redo();
						break;

					case "BO_TieredPricing_Batchrun":
						MotorFrondEnd.BO_TieredPricing_Batchrun(
								Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"));
						break;

					case "Tieredpricingparameter":
						Driver.refreshSheet1(bindingvalue,Startline.Startline_recordset1);
						TieredPricing.Tieredpricingparameter();
						break;

					case "SMF_TP_WithandWithoutST":
						MotorFrondEnd.SMF_TP_WithandWithoutST();
						break;

					case "SMF_TP_WST_FRticked":
						MotorFrondEnd.SMF_TP_WST_FRticked();
						break;

					case "SMF_TP_WOST_FRUnticked":
						MotorFrondEnd.SMF_TP_WOST_FRUnticked();
						break;

					case "SMF_TP_WST_UpdateFRticked":
						MotorFrondEnd.SMF_TP_WST_UpdateFRticked();
						break;

					case "SMF_TP_Finishline":
						MotorFrondEnd.SMF_TP_Finishline();
						break;

					case "SMF_TieredpricingUpdate":
						MotorFrondEnd.SMF_TieredpricingUpdate();
						break;

					case "Financial_Continue":
						MotorFrondEnd.Financial_Continue();
						break;

					case "WithGuarantors":
						MotorFrondEnd.WithGuarantors(Startline_recordset1.where("DATABINDING='" + bindingvalue + "'"));
						break;

					case "Finishlinebrand":
						MotorFrondEnd.Finishlinebrand();
						break;

					case "Addresshistory":
						MotorFrondEnd.Addresshistory();
						break;

					case "PDIAgr_Login":
						MotorFrondEnd.PDIAgr_Login();
						break;

					case "DocsReceived":
						MotorFrondEnd.DocsReceived();
						break;

					case "FirstcheckValidated":
						MotorFrondEnd.FirstcheckValidated();
						break;

					case "ConUNconfirmedSpecialterms":
						MotorFrondEnd.ConUNconfirmedSpecialterms();
						break;

					case "AwaitingDocsApproved":
						MotorFrondEnd.AwaitingDocsApproved();
						break;

					case "Payoutgolive":
						MotorFrondEnd.Payoutgolive();
						break;

					case "Conditionaldocsrecieved":
						MotorFrondEnd.Conditionaldocsrecieved();
						break;

					case "Update_comparison":
						MotorFrondEnd.Update_comparison();
						break;

					case "Update_compareV1":
						MotorFrondEnd.Update_compareV1();
						break;

					case "SQLrefjdbc":
						MotorFrondEnd.SQLrefjdbc();
						break;

					case "Agreementsearch":
						Driver.refreshSheet1(bindingvalue,Startline.Startline_recordset1);
						MotorFrondEnd.Agreementsearch();
						break;

					case "Newagrsearch":
						MotorFrondEnd.Newagrsearch();
						break;

					case "Callmanualapproved":
						MotorFrondEnd.Callmanualapproved();
						break;

					case "Callcondionalapproved":
						MotorFrondEnd.Callcondionalapproved();
						break;

					case "Manualrejection":
						MotorFrondEnd.Manualrejection();
						break;

					case "Declinedecisionresaon":
						Driver.refreshSheet1(bindingvalue,Startline.Startline_recordset1);
						MotorFrondEnd.Declinedecisionresaon();
						break;

					case "AutoRejectedPrevet":
						MotorFrondEnd.AutoRejectedPrevet();
						break;

					case "AutoRejectedPostBureau":
						MotorFrondEnd.AutoRejectedPostBureau();
						break;


					case "DL_license_validation":
						MotorFrondEnd.DL_license_validation();
						break;

					case "Returntointroducer":
						MotorFrondEnd.Returntointroducer();
						break;

					case "BO_Status_check":
						MotorFrondEnd.BO_Status_check();
						break;

					case "BO_RejStatus_check":
						MotorFrondEnd.BO_RejStatus_check();
						break;

					case "BO_Balloon_verification":
						MotorFrondEnd.BO_Balloon_verification();
						break;

					case "BoCallvalidateresponse":
						MotorFrondEnd.BoCallvalidateresponse();
						break;

					case "Updatereferredevents":
						MotorFrondEnd.Updatereferredevents();
						break;

					case "Redo_Referredevents":
						MotorFrondEnd.Redo_Referredevents();
						break;

					case "ReferredEvents":
						MotorFrondEnd.ReferredEvents();
						break;

					case "SMF_logout":
						Common_Property.SMF_logout();
						break;

					case "PreRequisite_SMFTP_WST":
						MotorFrondEnd.PreRequisite_SMFTP_WST();
						break;

					case "Prequisite_SMFTP_WOST":
						MotorFrondEnd.Prequisite_SMFTP_WOST();
						break;

					case " SMF_TP_WST_RemoveFRticked":
						MotorFrondEnd.SMF_TP_WST_RemoveFRticked();
						break;

					}

					methodname = Driver.KeywordList.get(i).toString();
				}

			}

		}

		catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}

	}

}
