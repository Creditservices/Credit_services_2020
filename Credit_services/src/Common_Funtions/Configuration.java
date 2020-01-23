package Common_Funtions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	public static String Browser,Lastkey,Lastvalue,LastMethod;
	public static String Project;
	public static String Datapath;
	public static String Driverpath;
	public static String Macropath;
	public static String ProvAPI;
	public static String screenheight, screenwidth,backuppath,reportpath,OracleDatabase,Excelfileuploadpath,PDFfileuploadpath;
	public static String Configpath = System.getProperty("user.dir");
	public static FileInputStream C;
	public static Properties prop = new Properties();;
	public static FileOutputStream os;
	public static int i=1;
	
	
	
	
	public static void getProperty() throws Exception {
		
		try {
			//prop = new Properties();
			C = new FileInputStream(Configpath + "/Config.properties");
			prop.load(C);
			Browser = prop.getProperty("Browser");
			Project = prop.getProperty("Project");
			Datapath = prop.getProperty("Datapath");                 //D:\Repository\Credit_services\DriverData
			Driverpath = prop.getProperty("Driverpath");             //D:\Repository\Credit_services\DriverData\ProjectToRun.xlsx
			Macropath = prop.getProperty("MacroPath");
			ProvAPI = prop.getProperty("Prov_Api_url");
			screenheight = prop.getProperty("screenheight");
			screenwidth = prop.getProperty("screenwidth");
			backuppath=prop.getProperty("filebackuppath");
			reportpath=prop.getProperty("reportpath");
			Lastkey=prop.getProperty("LastKey");
			Lastvalue=prop.getProperty("LastValue");
			LastMethod=prop.getProperty("LastMethodExecuted");
			OracleDatabase=prop.getProperty("OracleDatabase");
			Excelfileuploadpath=prop.getProperty("Excelfileuploadpath");
			PDFfileuploadpath=prop.getProperty("PDFfileuploadpath");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void updatePropertyFile(String keys,String MethodName,String values) {
      try{
        C = new FileInputStream(Configpath + "/Config.properties");
        prop.load(C);
        //prop.put("LastKey",keys);
        prop.put("LastValue", values);
        //prop.put("LastMethodExecuted", MethodName);
        C.close();
        os = new FileOutputStream(Configpath + "/Config.properties");
        prop.store(os, "Dynamic Property File");
      }
      
      catch(Exception e){
    	  System.out.println(e);
      }
      // i=i+1;

 }

}
