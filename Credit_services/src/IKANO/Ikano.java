package IKANO;
import java.util.Arrays;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.*;


public class Ikano extends Driver
{
	
	public static Recordset Ikano_recordset1, Ikano_recordset2;
	public static Connection connection;
	public static Fillo fillo;
	public static String strQuery,str,getref;
	public static List<String> KeywordList = Arrays.asList();
	public static int i;
	public static boolean flag;
	public static boolean Testchange;
	//***********Start Execute the project************//
	public static void main(String args[])throws Exception
	{
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		Configuration.updatePropertyFile("Project", "Startexecuted", "True");
		Driver.Project_ToRun("Ikano");
		
	}
	
	
	//**********************Ikano_project_initiated present inside Keywordlist*****************//
     public static void IkanoInitiated(String getKeyword) throws NullPointerException, Exception
		
		{
    	 String methodname=null;
			try
			{
				Ikano_recordset1 =Driver.testCasetoExecute();
				
					
					while(Ikano_recordset1.next())
					{
						Configuration.updatePropertyFile("Project", "Execution_continues", "True");
						flag=true;
						Utilities.reportinitiated(Ikano_recordset1);
						KeywordList = Driver.methodstoExecute(Ikano_recordset1);
						String bindingvalue=Ikano_recordset1.getField("DATABINDING");
						
							boolean flag = true;
						    for(i=0;i<= KeywordList.size()-1;i++)
						    {
						    	Configuration.getProperty();
						    	
								if (Configuration.Lastvalue.equalsIgnoreCase("True")){
									refreshSheet1(bindingvalue,Ikano_recordset1);
						    		 switch(KeywordList.get(i))
									    {
								   
					                        
											case "InitiateChromeDriver":
												Common_Property.IntiateBrowser();
												break;
											case "Tesco_Login":
												Login_Pages.Tesco_Login();
												break;
												
											case "Start_App":
												Tesco_retailer.Start_App();
												break;	
											case "Loan_Page":
												Tesco_retailer.Loan_Page();
												break;
											
											case "Personal_Page":
												Tesco_retailer.Personal_Page();
												break;
												
											case "Address_Page":
												Tesco_retailer.Address_Page(Ikano_recordset1.where("DATABINDING='"+bindingvalue+"'"));
												break;
												
											case "Employee_Page":
												Tesco_retailer.Employee_Page();
												break;
											case "Financial_Page":
												Tesco_retailer.Financial_Page();
												break;
											case "Marketing_Page":
												Tesco_retailer.Marketing_Page();
												break;
												
											case "Frontoffice_Login" :
												if(Tesco_retailer.flag==true){
												Login_Pages.Frontoffice_Login();
												break;
												}
												
												
											case "Accept_step":
												Driver.refreshSheet1(bindingvalue,Ikano_recordset1);
											    Front_Office.Accept_step();
												break;
												
											case "Esign_Agreement":
											    Tesco_retailer.Esign_Agreement();
												break;
												
											case "Search_Agreement":
											    Tesco_retailer.Search_Agreement();
												break;
												
											case "Vision_Login":
												Login_Pages.Vision_Login();
												break;
												
											case "Start_App_Vision":
												Tesco_retailer.Start_App();
												break;
												
											case "Loan_page_Vision":
												Tesco_retailer.Loan_page_Vision();
												break;
												
												
											case "Personal_Page_Vision":
												Tesco_retailer.Personal_Page_Vision();
												break;
												
											case "Check_status_code":
												Tesco_retailer.Check_status_code();
												break;
												
											case "BO_Login":
												Login_Pages.BO_Login();
												break;
												
											case "check_agreement_status":
												Tesco_retailer.check_agreement_status();
												break;
												
											case "Batchrun":
												BackOffice.Batchrun(Ikano_recordset1);
												break;
												
											case "d2c_api":
												
												D2C_api_test.d2c_api();
												break;
												
											case "frontofficeApprove" :
												Driver.refreshSheet1(bindingvalue,Ikano_recordset1);
												D2C_api_test.frontofficeApprove(Driver.recordset1.getField("Agreement_Number"));
												
											case "BO_Status_check":
												BackOffice.BO_Status_check();
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
			
      catch(Exception e)
			{
	    	  Utilities.ExtentFailReport(methodname,e);	  
			}
			
			 }

}
