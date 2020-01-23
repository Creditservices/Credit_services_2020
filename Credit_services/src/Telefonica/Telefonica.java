package Telefonica;

import java.util.Arrays;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.Common_Property;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import Common_Funtions.*;

public class Telefonica extends Driver{
			
	public static Recordset Tuk_recordset1;
	public static Connection connection;
	public static Fillo fillo;
	public static String strQuery,str,getref;
	public static List<String> KeywordList = Arrays.asList();
	public static int i;
	public static boolean flag;
	//***********Start Execute the project************//
	public static void main(String args[])throws Exception {
		Configuration.updatePropertyFile("Project", "Startexecuted", "True");
		Driver.Project_ToRun("Telefonica");
	}
	
	
	//**********************Telefonica_project_initiated present inside Keywordlist*****************//
	public static void TelefonicaInitiated(String getKeyword) throws NullPointerException, Exception {
			 
		String methodname=null;
		try {
		 
			Tuk_recordset1 =Driver.testCasetoExecute();
			while(Tuk_recordset1.next()) {      ///BOF Recorset error
				
				Configuration.updatePropertyFile("Project", "Startexecuted", "True");
				flag= true;
				System.out.println("******************************************************************************************************");
				System.out.println("Execution started for Test case: "+Tuk_recordset1.getField("Testcase"));
				Utilities.reportinitiated(Tuk_recordset1);
				KeywordList = Driver.methodstoExecute(Tuk_recordset1);
				String bindingvalue=Tuk_recordset1.getField("DATABINDING");
							
				
				for(i=0;i<= KeywordList.size()-1;i++) {
					Configuration.getProperty();
					if (Configuration.Lastvalue.equalsIgnoreCase("True"))  {
						switch(KeywordList.get(i)) {
						
							case "InitiateChromeDriver":
								Common_Property.IntiateBrowser();
								break;
							case "Application_Known":
								API_Test.applicationKnown(Tuk_recordset1);
								refreshSheet1(bindingvalue,Tuk_recordset1);
								break;
							case "BO_Login":
								Backoffice.BO_Login(recordset);
								break;
							case "BO_Attributes1":
								Backoffice.BO_Attributes(recordset1,recordset1.getField("BO_AwaitGoods"),recordset1.getField("BO_DelayGoods"));
								break;
							case "BO_Attributes2":
								Backoffice.BO_Attributes(recordset1,recordset1.getField("BO_AwaitGoods1"),recordset1.getField("BO_DelayGoods"));
								break;
							case "BO_Status":
								Backoffice.BO_Status_check(recordset1, recordset1.getField("BO_AgrStatus"));
								break;
							case "BO_StatusAfterEsign":
								Backoffice.BO_Status_check(recordset1, recordset1.getField("BO_AgrStatus1"));
								break;
							case "BO_Nopayment_check":
								Backoffice.BO_Nopayment_check(recordset1);
								break;
							case "Application_Esignature":
								API_Test.applicationEsignature(recordset1);
								break;
							case "BO_Firstduedate_check":
								Backoffice.BO_Firstduedate_check(recordset1);
								break;
							case "BO_Installmentamt_check":
								Backoffice.BO_Installmentamt_check(recordset1);
								break;
							case "Application_Attribute":
								API_Test.applicationAttribute(recordset1);
								break;
							case "BO_Securities_check1":
								Backoffice.BO_Securities_check(recordset1, false); 
								//***false is to omit equipment schedule verification
								break;
							case "BO_Securities_check2":
								Backoffice.BO_Securities_check(recordset1, true);
								//***false is to include equipment schedule verification
								break;				 
						}
					}else {
						flag = false;
					}

					if (!flag) {
						break;
					}
				
						
					
				    System.out.println("Method Executed: "+Driver.KeywordList.get(i).toString());
				}    
			}
		}catch(Exception e){
			Utilities.ExtentFailReport(methodname,e);	  
		}
				
	}
	
}
