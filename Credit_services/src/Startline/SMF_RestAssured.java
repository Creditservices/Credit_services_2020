package Startline;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
	import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.text.WordUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;

import Common_Funtions.*;
import Startline.MotorFrondEnd;
import io.restassured.response.ValidatableResponse;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;



	public class SMF_RestAssured extends Driver
	{	
		  
		   public static String XMLpath=Configuration.Driverpath;       //+Driver.Projects+".xlsx";
		   public static List<String> Agreement;
		   public static List<String> getUrl;
		   public static String Agreement_Number,AgreementNumber;
		   public static HashMap<String, String> Tag_value = new HashMap<String, String>();
		   public static boolean flag;
		   public static String Student_Url,agrNum,AgrCurrentdecision;
		   
		   
		  
		

	
		public static void APIHandler(Recordset Rec,String PDIAction) throws Exception{
			
			 	String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
				String responseData="", agrNum="";
				Recordset SL_recordSet = null;
				 
				
				switch (PDIAction.trim()) 
				{
				
					case "CreateAgreement":
						SL_recordSet =Rec;
						//SL_recordSet.next();
						//   String bindingvalue = SL_recordSet.getField("DATABINDING");
						break;
					case "UpdateAgreement":
						FieldstoSelect.put("*", "");
						WhereCondition.put("Run", "'Yes'");
						TableName = "Sheet1"; 
						String SelectCommand = Driver.select();
						Rec = connection.executeQuery(SelectCommand);
						//Rec.where(Startline.bindingvalue);
						//Rec.next();
						SL_recordSet = Rec;
						SL_recordSet.next();
						break;
						
						
					case "CheckDecision":
						FieldstoSelect.put("*", "");
						WhereCondition.put("Run", "'Yes'");
						WhereCondition.put("DATABINDING", "'"+Startline.bindingvalue+"'");
						TableName = "Sheet1"; 
						String SelectCommand1 = Driver.select();
						Rec = connection.executeQuery(SelectCommand1);
						Rec.next();
						SL_recordSet = Rec;
						break;
						
					
				}	
				
				//***replace variables with values in parameterised XML
					for (int j = 0; j < SL_recordSet.getFieldNames().size(); j++) 
					{
						
						String variable = WordUtils.capitalize(SL_recordSet.getField(j).name().toLowerCase());
						if (xmlData.contains(variable)) 
						{
						
							String value =SL_recordSet.getField(j).value();
							xmlData =  xmlData.replace(variable, value);
			       	 	}
					}
					responseData = execute("text/xml", xmlData, strUrl);
					
				// validation on the API response data
				switch (PDIAction) 
				{
													
					case "CreateAgreement":  
					{
					      XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.CreateProposalResponseParameter.AgreementList.Agreement");
						  agrNum = xml.getString("AgreementNumber");
						  if (!agrNum.equalsIgnoreCase("")) 
						  {
							 Agreement_Store.Store_Data(Driver.WhichClient, agrNum, " " , Rec);
							 Utilities.ExtentPassReport("Agreement created successfully. Agreement_number:   "+agrNum);	
						   }
						  
						  else if(Startline.bindingvalue.contains("PAGR9_TC009"))
							{
							  XmlPath xml1 = new XmlPath(responseData).setRoot("Envelope.Body.CreateProposalResponseParameter.AgreementList.Agreement.ExceptionList.Exception");
							   if(xml1.getString("Description").contains("3 years of address history not supplied for person"))
							   {
								   Utilities.ExtentPassReport(methodname +":"+ xml1.getString("Description"));
								   System.out.println(xml1.getString("Description"));
							   }
							}
						  else
						   {
							  XmlPath xml1 = new XmlPath(responseData).setRoot("Envelope.Body.CreateProposalResponseParameter.AgreementList.Agreement.ExceptionList.Exception");
							  String errordescription = xml1.getString("Description");
							  Utilities.ExtentFailReport1(methodname, errordescription);
						   }
						  break;
					}
					case "UpdateAgreement":
					{
						XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.UpdateProposalResponseParameter");
						//Get the value by giving the node name
						String UdpateStatus = xml.getString("CompletedSuccessfully");
						
						if(UdpateStatus.contains("true"))
						{
							 Utilities.ExtentPassReport(methodname +":"+ xml.getString("CompletedSuccessfully"));
							System.out.println("Update successful and the status is "+UdpateStatus);
						}
						else
						{
							String UpdateerrorDesc = xml.getString("ErrorDescription");
							Utilities.ExtentFailReport1(methodname, UpdateerrorDesc);
							System.out.println("Error in Update and the errordescription is  "+UpdateerrorDesc);
						
						}
						break;
					}
					
					case "CheckDecision":
					{
						XmlPath xml = new XmlPath(responseData).setRoot("Envelope.Body.CheckDecisionResponseParameter.AgreementStatusList.AgreementStatus");
						//Get the value by giving the node name
						 AgrCurrentdecision = xml.getString("Decision");
						if(AgrCurrentdecision.contains(MotorFrondEnd.Status))        //Checking the PDI status and Motor front end status are same     
						{
							Utilities.ExtentPassReport("Agreement decision check successful Agreement_decision is    "+AgrCurrentdecision);
						}
						else
						{					
							Utilities.ExtentFailReport1(methodname, "Error in Agreement Checkdecision    "+AgrCurrentdecision);
						
						}
						break;
					}
				 }
		}	
		public static String execute(String strContentType, String xml_data, String str_url)
		{
				ValidatableResponse response = RestAssured.given()
					.contentType(strContentType)
			        .body(xml_data)
			        .when()
			        .post(str_url)
			        .then();
			
			return response.extract().body().asString();
		}
		
		
		
	
		
}
