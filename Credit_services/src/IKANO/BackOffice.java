package IKANO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.mysql.jdbc.ResultSet;

import Common_Funtions.Agreement_Store;
import Common_Funtions.Common_Property;
import Common_Funtions.Configuration;
import Common_Funtions.Driver;
import Common_Funtions.Utilities;
public class BackOffice extends Driver {
	public static void Batchrun(Recordset record) throws InterruptedException, IOException, FilloException {
        System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
        String MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
        String Methodid = Long.toString(Thread.currentThread().getId());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
        Date sdate = new Date();
        String datetimestart = dateFormat.format(sdate);
        String batchnames = Driver.getData("Batchname");
        BatchList = Driver.Batchwordsheetvalue(batchnames);

        for (int c_batch = 0; c_batch <= BatchList.size() - 1; c_batch++) {
            try {
            	System.out.println(System.currentTimeMillis());
                Common_Property.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Common_Property.driver.manage().window().setSize(new Dimension(height, width));
                // NAVIGATION
                Thread.sleep(2250);
                String sysdate = Common_Property.driver
                        .findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div"))
                        .getText();
                Driver.get_sysdate(sysdate, record);
                Thread.sleep(2250);
                Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
                Thread.sleep(1050);
                Common_Property.driver.findElement(By.xpath("//div[1][text()='Batches']")).click();
                Thread.sleep(1250);
                Common_Property.driver.findElement(By.xpath("//div[text()='Display Job Queues']")).click();
                Thread.sleep(2050);
                Common_Property.driver.findElement(By.xpath("//div[text()='Submit...']")).click();
                Thread.sleep(1500); // html/body/div[7]/div[2]/div/div/div/div/div/div[2]/div[2]
                Common_Property.driver
                        .findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[2]/div[2]")).click();
                Thread.sleep(2500);                  
                 Common_Property.driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div[2]/input"))
                        .sendKeys(BatchList.get(c_batch));
                Thread.sleep(2500);
                Common_Property.driver.findElement(By.xpath("//div[text()='OK']")).click();
                Thread.sleep(500);                              //html/body/div[8]/div[3]/div[1]
                Common_Property.driver
                        .findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[4]/div[1]/div[2]"))
                        .click();              //html/body/div[8]/div[2]/div/div/div/div/div/div[4]/div[1]/div[2]
                Thread.sleep(1500);
                Common_Property.driver.findElement(By.xpath("//div[text()='Daily']")).click();
                Thread.sleep(500);
                Thread.sleep(150);
                Common_Property.driver.findElement(By.xpath("//div[text()='Now']")).click();
                Thread.sleep(500);
                String Start = Common_Property.driver
                        .findElement(By.xpath("//div[text()='Now']/ancestor::div[2]/div[1]/input"))
                        .getAttribute("value");
                System.out.println(Start);//html/body/div[8]/div[2]/div/div/div/div/div/div[6]/div[1]/input
                String stdate = Start.substring(0, 11);
                if (BatchList.get(c_batch).contains("Overnight")) {
    				Common_Property.driver
    						.findElement(By.xpath("//div[text()='End date:']/ancestor::div[2]/div[12]/input"))
    						.sendKeys(Driver.add_days(sysdate,record));//html/body/div[8]/div[2]/div/div/div/div/div/div[12]/input
    				Thread.sleep(200);
    				Thread.sleep(200);
                    Common_Property.driver.findElement(By.xpath("//div[text()='Save']")).click();
                    Thread.sleep(500);
                    String days =record.getField("No.of.days");
                    System.out.println(days);
                    int nxt = Integer.parseInt(days);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(sdf1.parse(stdate));
                    Date date = new Date();

                        for (int i = 1; i <= nxt; i++) {
                            c1.add(Calendar.DAY_OF_MONTH, 1);
                            date = c1.getTime();
                            String date1 = sdf1.format(date);
                            System.out.println(sdf1.format(date));
                            String Query2 = "select to_char(pp_pan_process_date.gf_date_without_time() ,'dd-MON-YYYY') as Sys_Date from dual";
                            Common_Property.SQLquery(Query2,Configuration.IK_DB);
                            
                            while (true) {
                                Common_Property.rs.refreshRow();
                                String currentdate = Common_Property.rs1.getString("Sys_Date");
                                if (date1.equalsIgnoreCase(currentdate)) {
                                    System.out.println("System date has changed to " + currentdate);
                                    break;
                                }
                                
                            }
                        }
    				}
    				
    				else{
    					Common_Property.driver
    					.findElement(By.xpath("//div[text()='End date:']/ancestor::div[2]/div[12]/input"))
    					.sendKeys(sysdate);
    			Thread.sleep(200);
                Common_Property.driver.findElement(By.xpath("//div[text()='Save']")).click();
                Thread.sleep(500);
    				}

                String Query2 = "select * from (select * from BATCH_JOBS job "
                            + "join BATCH_GROUPS_AND_PROCESSES bpr on bpr.bpr_serial = job.JOB_BATCH_ABSTRACT_PROCESS "
                            + " where to_char(JOB_START_DATE_TIME,'DD-MON-YYYY') = to_date('" + sysdate
                            + "','DD-MON-YYYY') " + "and upper(bpr_name) = upper('" + BatchList.get(c_batch) + "') order by Job_serial desc)where rownum = 1";
                    
                    Common_Property.SQLquery(Query2,Configuration.IK_DB);
                    Thread.sleep(20000);
                    System.out.println(Common_Property.rs.getString("JOB_STATUS"));
                    

                if(BatchList.get(c_batch).equalsIgnoreCase("Load TESTCO Payment Request File")){
                String Agr_num = "'" + recordset1.getField("Agreement_Number") + "'";
    			String filename = recordset1.getField("ESM_filename");
    			String Query3 = "select * from PAN.SUPPLIER_PAYMENT_REQUESTS where SPQ_AGREEMENT_NUMBER=" + Agr_num + " order by SPQ_SERIAL desc";
    			Common_Property.SQLquery(Query3,Configuration.IK_DB);
    			

    			Thread.sleep(20000);
    			System.out.println(Common_Property.rs.getString("SPQ_FILE_NAME"));
    			System.out.println(Tesco_retailer.AltFilename+".csv");
    			
    			if(Common_Property.rs.getString("SPQ_FILE_NAME").equals(Tesco_retailer.AltFilename+".csv")) {
    				System.out.println("File has moved to supplier table successfully");
            	  //  Common_Property.rs1.refreshRow();
                    
                }
          }
                else if(BatchList.get(c_batch).equalsIgnoreCase("Load TESTCO Payment Request File")){
//                  Common_Property.SqlConnection();
                    String Agr_num = "'" + recordset1.getField("Agreement_Number") + "'";
        			String filename = recordset1.getField("ESM_filename");
        			String Query3 = "select * from PAN.SUPPLIER_PAYMENT_REQUESTS where SPQ_AGREEMENT_NUMBER=" + Agr_num + " order by SPQ_SERIAL desc";
        			Common_Property.SQLquery(Query3,Configuration.IK_DB);
        			
                    Thread.sleep(20000);
        			System.out.println(Common_Property.rs.getString("SPQ_FILE_NAME"));
        			System.out.println(Tesco_retailer.AltFilename+".csv");
        			
        			if(Common_Property.rs.getString("SPQ_FILE_NAME").equals(Tesco_retailer.AltFilename+".csv")) {
        				System.out.println("File has moved to supplier table successfully");
                	  //Common_Property.rs1.refreshRow();
                        
                    }
        			
        			String Query5 ="select AGR_AGREEMENT_NUMBER, agr_status_1,agr_status_2 from agreements where AGR_AGREEMENT_NUMBER ="+ "'" + Driver.getData("Agreement_Number") + "'" + " ";
        			Common_Property.SQLquery(Query3,Configuration.IK_DB);
        			if(Common_Property.rs.getString("AGR_AGREEMENT_NUMBER").equalsIgnoreCase(Driver.getData("Agreement_Number"))&&Common_Property.rs.getString("AGR_STATUS_1").contains(Driver.getData("PrimaryStatus")))
        			{
        				System.out.println("Agreement number activated" );
        				Utilities.ExtentPassReportforSQL("Agreement number activated successfully","Status: "+Common_Property.rs.getString("AGR_STATUS_1"));
        			}
        			else
        			{
        				System.out.println("Agreement number not in Active status" );
        				Utilities.ExtentFailReportforSQL("Agreement number not activated","AGR_STATUS_1  "+Common_Property.rs.getString("AGR_STATUS_1") +" AGR_STATUS_2:"+Common_Property.rs.getString("AGR_STATUS_2"));
        			}
              }
                
                Common_Property.driver.findElement(By.xpath("//div[text()='Close']")).click();
                
               
            }
            catch (Exception e) {
                System.out.println("The exception was " + e);
                System.out.println("Abnormal Termination due to " + e);
                String Exce = e.toString();
                String report = "Exception " + Exce.substring(0, 87);
                String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
                Utilities.ExtentFailReport(methodname, e);
                Configuration.updatePropertyFile(Methodid,MethodName,"False");
                
            }
        }
    }
	
	
	public static void BO_Status_check() throws IOException, InterruptedException // AXC-REGR-190

	{

		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname = (Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		 Methodid = Long.toString(Thread.currentThread().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart = dateFormat.format(sdate);

		try {

			Common_Property.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(250);
			Common_Property.driver.findElement(By.xpath("//div[text()='Open']")).click();
			Thread.sleep(700);
			Common_Property.driver.findElement(By.xpath("//html/body/div[4]/div/div[1]")).click();
			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//html/body/div[6]/div/div[2]"))
					.click();

			// MAINTAIN CUSTOMER AGREEMENT

			Common_Property.driver
					.findElement(By
							.xpath("//html/body/div[7]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/input"))
					.sendKeys(Driver.getData("Agreement_Number"));
			Thread.sleep(700);
			Common_Property.driver
					.findElement(By
							.xpath("//html/body/div[7]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div"))
					.click();
			Thread.sleep(2700);
			Common_Property.driver
					.findElement(By
							.xpath("//html/body/div[7]/div[2]/div/div/div[1]/div/div/div[3]/div[2]"))
					.click();
			Thread.sleep(1700);
			String ver = Common_Property.driver
					.findElement(By
							.xpath("//html/body/div[8]/div[4]/div/div/div[2]/div[1]/div/div/div[9]/div/div/div[3]/div/div[2]/input"))
					.getAttribute("value");
			Thread.sleep(1750);
			System.out.println(ver);

			if (ver.equalsIgnoreCase(Driver.getData("BO_status"))) {

				// Utilities.Capture_Screenshot();
				String Desc = "Successfully  " + Driver.getData("Documentname") + " Passed";
				Utilities.ExtentPassReport(methodname);

			} else {

				// Utilities.Capture_Screenshot();
				String Desc = "For The customer agreement  " + Driver.getData("Documentname") + " has not as Expected";
				Utilities.ExtentFailReport1(methodname, Desc);

			}

			Common_Property.driver.findElement(By.xpath("//html/body/div[8]/div[1]/div[1]/div[4]/div")).click();
			Thread.sleep(1750);
//			Common_Property.driver.findElement(By.xpath("//div[@name='MaintainAgreementDetailsWindow.File.Close']"))
//					.click();
//			Thread.sleep(1750);
			Common_Property.driver.findElement(By.xpath("//html/body/div[7]/div[3]/div[1]/div"))
					.click();
			Thread.sleep(1750);   

		} catch (Exception e) {

			System.out.println("The exception was " + e);
			System.out.println("Abnormal Termination due to " + e);
			String Exce = e.toString();
			String report = "Exception " + Exce.substring(0, 87);
			// Utilities.Capture_Screenshot();
			String Desc = "Test Run of" + methodname + "was not completed Sucessfully";
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
		}

	}

}
