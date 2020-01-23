package Common_Funtions;

import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.runner.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;


public class Utilities extends Driver
{
		public static String res_directory=System.getProperty("user.dir");
		public static String test_step,PFC,FFC,scrpath;
		public static ExtentHtmlReporter HtmlReporter;	
		public static ExtentReports extent;
	    public static ExtentTest test;
	    public static ExtentTest teststep;
	
    
    public static String timestamp(String str)
    {
    	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
   	    Date date = new Date();
   	    str= dateFormat.format(date).toString();
    	return str;
    	
    }
   
    	
    public static String Capture_Screenshot(String TestName) throws IOException, InterruptedException, FilloException
	{	
    	
    	try
    	{
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    	 Date date = new Date();
    	 String str= dateFormat.format(date).toString();
    	
		 File screenshot = ((TakesScreenshot)Common_Property.driver).getScreenshotAs(OutputType.FILE);
		 String folder=System.getProperty("user.dir");
		 
		 scrpath=folder+"/src/"+WhichClient+"/Screnshots/"+TestName+""+timestamp(str)+".png";
		 File dest=new File(folder+"/src/"+WhichClient+"/Screnshots/"+TestName+""+timestamp(str)+".png");
		
		
		 FileUtils.copyFile(screenshot, dest);
		
    	}
    	catch(Exception e)
        {
        	System.out.println(e);
        }
		 /*if(test_step.equalsIgnoreCase("Pass"))
		 {
			 
			 PFC="D:/New_Frame/Pancredit/HTMLreports/Pass ";
			 File Passdir = new File(PFC);
			 Passdir.mkdirs();
			 
			 String passpath="D:/New_Frame/Pancredit/HTMLreports/Pass/"+getcurrentdateandtime(TestName)+".png";
			 FileUtils.copyFile(screenshot, new File(passpath));
			 return passpath;
		 }
		 else
		 {
		     FFC="D:/New_Frame/Pancredit/HTMLreports/Fail ";
			 File Passdir = new File(FFC);
			 Passdir.mkdirs();
			 String failpath="D:/New_Frame/Pancredit/HTMLreports/Fail/"+getcurrentdateandtime(TestName)+".png";
			 FileUtils.copyFile(screenshot, new File(failpath));
			 return failpath;
		 }
		 */
	
    	 return scrpath; 
	
	}
	
	public static void Create_res_Folder() 
	 {
		String res_Folder=null;
		 try
		 {
			 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
			 Date date = new Date();
			 res_Folder = res_directory+"/"+WhichClient+"/Result "+dateFormat.format(date)+"/";
			 File dir1 = new File(res_Folder);
			 dir1.mkdirs();
						
		} 
		 catch (Exception e1) 
		 {
			System.out.println("The Exception Occured in the Main Result Folder Creation"+e1);
		 }
		
	 }

	
	public static void log_file(Exception e1,String TestName){
		 
		    
		    Logger logger = Logger.getLogger("MyLog"); 
		    logger.info(TestName); 
		    FileHandler fh = null;  

		    try {  

		        // This block configure the logger with handler and formatter  
		    	 fh = new FileHandler(res_directory+"/src/"+WhichClient+"/Log_files/"+WhichClient+TestName+".txt",false);  
			        logger.addHandler(fh);
			        SimpleFormatter formatter = new SimpleFormatter();  
			        fh.setFormatter(formatter); 

		        // the following statement is used to log any messages  
		        logger.info(e1.toString()); 
		        fh.close();
                

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		    finally{
		    	fh.close();
		    	
		    }

		   

		}
	
	public static void reportinitiated(Recordset Record1) throws IOException, FilloException
	
	{

	try
	{	
	if(extent==null)
	{
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 Date date = new Date();
		 String folder=System.getProperty("user.dir");
		 HtmlReporter = new ExtentHtmlReporter(folder+"/src/"+WhichClient+"/HTMLreports/"+WhichClient+".html");
		 HtmlReporter.setAppendExisting(false);
		 extent = new ExtentReports();
	}
	
		extent.attachReporter(HtmlReporter);
		test = extent.createTest(Record1.getField("DataBinding"),Record1.getField("Testcase"));
	    }
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}
	
	public static void ExtentPassReport(String TestName) throws IOException, InterruptedException, FilloException
	{
	try
	{ 		//Changed for startline
			TestName = TestName.replace("'", ""); //Changed for startline
			TestName = TestName.replace(":","-");  //Changed for startline 
		test_step="Pass";
		    test.log(Status.INFO, TestName);
		    //test.log(Status.PASS, TestName+" Executed Successfully");
	    if(Common_Property.driver==null)
	    {
	    	test.pass(TestName +" has executed successfully ");
	    	
	    }
	    else
	    {
			test.pass(TestName +" has executed successfully ", MediaEntityBuilder.createScreenCaptureFromPath(Capture_Screenshot(TestName)).build());
			
		    
	    }
			extent.flush();
		}
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	

	}

	public static void ExtentFailReport(String TestName,Exception e1) throws IOException, FilloException, InterruptedException
	{
		
    try
    {
    		//Changed for startline
			TestName = TestName.replace("'", "");    //Changed for startline
			TestName = TestName.replace(":","-");   //Changed for startline
    		test_step="Fail";
			test.log(Status.INFO, TestName+ " Initiated");
		if(Common_Property.driver==null)
	    {
	    	test.fail(TestName +" has failed ");
	    	test.log(Status.FAIL, e1.toString());
	    	log_file(e1,TestName);
	    	
	    }
		else
		{
		    
			//test.log(Status.FAIL, TestName+" execution has Failed");
			test.fail(TestName +" has failed find the below Screenshot ",MediaEntityBuilder.createScreenCaptureFromPath(Capture_Screenshot(TestName)).build());
			test.log(Status.FAIL, e1.toString());
			log_file(e1,TestName);
			//test.log(Status.ERROR, "StackTrace Result: " + Thread.currentThread().getStackTrace());
		
		
			
		}
			extent.flush();
     }
    catch(Exception e)
    {
    		System.out.println(e);
    		
    		
    }
	
	}
	
	public static void ExtentFailReport1(String TestName,String e1) throws IOException, FilloException, InterruptedException
	{
		
    try
    {
			test_step="Fail";
			test.log(Status.INFO, TestName+ " Initiated");
		if(Common_Property.driver==null)
	    {
	    	test.fail(TestName +" has failed ");
	    	test.log(Status.FAIL, e1);
	    	
	    }
		else
		{
		    
			//test.log(Status.FAIL, TestName+" execution has Failed");
			test.fail(TestName +" has failed find the below Screenshot ",MediaEntityBuilder.createScreenCaptureFromPath(Capture_Screenshot(TestName)).build());
			test.log(Status.FAIL, e1);
			//test.log(Status.ERROR, "StackTrace Result: " + Thread.currentThread().getStackTrace());
		
		
			
		}
			extent.flush();
     }
    catch(Exception e){
    	System.out.println(e);
    }
}
	public static void fileBackup(String Path, String filename){
	File source = new File(Path+"/"+filename+".xlsx");
	File dest = new File(Configuration.backuppath+"/"+filename+".xlsx");
	try {
	   // FileUtils.copyDirectory(source, dest);
		FileUtils.copyFile(source,dest);
	} catch (IOException e) {
	    e.printStackTrace();
	}
}
	
	public static void reportBackup(String Path, String filename){
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 Date date = new Date();
		File source = new File(Path+"/"+filename+"/"+"HTMLreports/"+filename+".html");
		File dest = new File(Configuration.backuppath+"/"+filename+"/"+filename+dateFormat.format(date)+".html");
		try {
		   // FileUtils.copyDirectory(source, dest);
			FileUtils.copyFile(source,dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static String method_status(){
		 String status=null;
		try{
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 status="MethodName.equalsIgnoreCase(Configuration.LastMethod) && Methodid.equalsIgnoreCase(Configuration.Lastkey)"
				 
			+"&& Configuration.Lastvalue";
		
		 
		} 
		catch (Exception e) {
		    e.printStackTrace();
		}
		return status;
		
	}
	//Only for Startline Project
		public static void passresult(String methodname,String Desc,String ActualResult,String datetimestart) 
		{
			try{

				 
				 String res ="Pass";
				 ExtentPassReport(methodname + ", " + Desc + ",  " + ActualResult + ", " + datetimestart);
		
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		//Only for Startline Project
		public static void failresult(String methodname,String Desc,String ActualResult,String datetimestart) 
		{
			try{		   
					
					String res ="Fail";
					ExtentFailReport(methodname + ", " + Desc + ", " + ActualResult + ", " + datetimestart,null);
				
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
	
	
	
}
