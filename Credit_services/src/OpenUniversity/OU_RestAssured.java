package OpenUniversity;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.text.WordUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.codoid.products.exception.FilloException;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
import io.restassured.response.ValidatableResponse;
import io.restassured.RestAssured;



public class OU_RestAssured extends Driver {
	   public static String XMLpath=Configuration.Datapath+CurrClient+".xlsx";
	   public static List<String> Agreement;
	   public static List<String> getUrl;
	   public static String Agreement_Number;
	   public static HashMap<String, String> Tag_value = new HashMap<String, String>();
	   public static String Student_Url;
	   public static boolean flag;
	   public static String XML;
	
	public static void CreateAgreement() throws Exception
	{
		
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
				
		    XML= Driver.recordset2.getField("XMLData");
		
		for (int i=0; i<=21; i++)	
      	{
    	  	
    	  	 String CurrFieldname = WordUtils.capitalize(Driver.recordset2.getField(i).name().toLowerCase());
        	 String CurrFieldValue =Driver.recordset2.getField(i).value();
        	 XML =  XML.replace(WordUtils.capitalize(CurrFieldname), CurrFieldValue); 
        	
      	}
		ValidatableResponse response=RestAssured.given()
        .contentType("text/xml")
        .body(XML)
        .when()
        .post("https://outest.pancredit.com/ousba-web-services/CreateProposal")
        .then().assertThat()
        .statusCode(200);
	    String agreement=response.extract().body().asString();
	    
	    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource src = new InputSource();
	    src.setCharacterStream(new StringReader(agreement));
	    Document doc = builder.parse(src);
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName("SOAP:Body"); 
	    int t=nList.getLength();

			    for (int temp = 0; temp < t; temp++) 
			    {
			    	Node nNode = nList.item(temp);
			    	System.out.println("\nCurrent Element :" + nNode.getNodeName());
				    	if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				    	{
				    		Element eElement = (Element) nNode;
				    		Tag_value.put("tns:AgreementNumber", eElement.getElementsByTagName("tns:AgreementNumber").item(0).getTextContent());
				    		Tag_value.put("tns:LoanApplicationURL", eElement.getElementsByTagName("tns:LoanApplicationURL").item(0).getTextContent());
				    		System.out.println(Tag_value.get("tns:AgreementNumber"));
				    		System.out.println(Tag_value.get("tns:LoanApplicationURL"));
				    		
				    	}
			    }
			    if(Tag_value.get("tns:LoanApplicationURL")!=null)
			    {
			   
				    flag=true;
				    Agreement_Number=Tag_value.get("tns:AgreementNumber").toString();
					Utilities.ExtentPassReport(methodname);
	                Agreement_Store.Store_Data(WhichClient,Agreement_Number,Student_Url,Driver.recordset2);
			    }
			    else
			    {
			    	flag=false;
			    }
	    
		}
		catch(Exception e)
		{
			if(flag==false)
				Utilities.ExtentFailReport(methodname,e);	
	    	    System.out.println("Please Change the datas in Sheet1 ");
		        System.out.println(e);	
		
		}
		
		
}
	

}
