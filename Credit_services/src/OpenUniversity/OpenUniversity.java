package OpenUniversity;

import java.util.Arrays;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import IKANO.Login_Pages;
import Common_Funtions.Driver;

public class OpenUniversity extends Driver {

	public static Recordset OU_recordset1;
	public static Connection connection;
	public static Fillo fillo;
	public static String strQuery, str, getref;
	public static List<String> KeywordList = Arrays.asList();
	public static int i;
	public static boolean Testchange;
	public static String bindingvalue;
	public static boolean flag;

	public static void main(String args[]) throws Exception {

		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		Configuration.updatePropertyFile("Project", "Startexecuted", "True");
		
		Driver.Project_ToRun("OpenUniversity");

	}

	public static void OpenUniversityInitiated(String getKeyword) throws NullPointerException, Exception

	{
		//boolean TobeClosed = Common_Property.Spreadsheet_check();
		//if (TobeClosed)
		//{
		String methodname = null;
		try {
			OU_recordset1 = Driver.testCasetoExecute();

			while (OU_recordset1.next()) {
				Configuration.updatePropertyFile("Project", "Execution_continues", "True");
				flag=true;
				Utilities.reportinitiated(OU_recordset1);
				KeywordList = Driver.methodstoExecute(OU_recordset1);
				bindingvalue = OU_recordset1.getField("DATABINDING");

				for (i = 0; i <= KeywordList.size() - 1; i++) {
					Configuration.getProperty();
					if (Configuration.Lastvalue.equalsIgnoreCase("True")) {
						switch (KeywordList.get(i)) {

						case "InitiateChromeDriver":

							Common_Property.IntiateBrowser();
							break;

						case "OU_api1":
							OU_api.OU_api1();
							break;
						
						case "OU_api2":
							OU_api.OU_api2();
							break;
							
						case "OU_api3":
							OU_api.OU_api3();
							break;
							
						case "OU_createStudent":
							OU_api.OU_createStudent();
							break;
							
						case "ouStudentPortalLogin":
							refreshSheet1(bindingvalue,OU_recordset1);
							OU_api.ouStudentPortalLogin(Driver.recordset1, Driver.recordset1.getField("Misc"));
							break;

						case "ouStudentPortal":
							OU_api.ouStudentPortal(Driver.recordset1);
							break;

						case "ouStaffLogin":

							OU_api.ouStaffLogin();
							break;

						case "ouStaffPortal":

							Driver.refreshSheet1(bindingvalue,OU_recordset1);
							OU_api.ouStaffPortal(OU_recordset1, OU_recordset1.getField("Pinum"));
							break;

						case "OU_Frontoffice_Approve":

							OU_frontoffice.OU_Frontoffice_Approve();
							break;

						case "OU_Frontoffice_Servicing":

							OU_frontoffice.OU_Frontoffice_Servicing();
							break;

						case "FO_Login":

							OU_frontoffice.FO_Login();
							break;

						}
					} 
					else {
						flag = false;
					}

					if (!flag) {
						break;

					}
				}

			}

		}

		catch (Exception e) {
			Utilities.ExtentFailReport(methodname, e);
		}
		}
	//}

}