package Startline;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Common_Funtions.*;

public class TieredPricing extends Driver {
	
	public static int flag=0;
	public static String Introducer,Upperlimit,Lowerlimit,Brandname1,Brandname2,AgrSerial,str,QProductserial,FProductserial,APRflag;
	
	
	public static void main(String[] args) throws Exception 
	{
		TP_Securedtasks("NST"); //NOn or without secured task 
		//Tieredpricingparameter();
		
	}
	public static String AGR_create_rate,TIP_Effective_rate,TIP_THIRD_PARTY_NAME,TIP_PRODUCT_NAME,TIP_TIER_NAME,TIP_LOWER_LIMIT,TIP_UPPER_LIMIT,TIP_DEFAULT_RATE,TIP_MIN_RATE,TIP_MAX_RATE,TIP_PRODUCT_NAME1;
	public static String DealerTPstatus;
	public static int STavailable;
	public static String TieredpricingSQL(String Introducer, String Lowerlimit,String Upperlimit, String Brandname1,String Brandname2,String Agrserial)
	{
		String Query= null;
		if (!Brandname1.isEmpty()&&Brandname1!=null)
		{
			
			
			Query = "SELECT  to_char(r.tip_effective_date,'DD-MON-YYYY HH24:MI:SS'),"
					+ "to_char(a.agr_create_date,'DD-MON-YYYY HH24:MI:SS'),r.* FROM tiered_pricing_rates r,agreements a,V_PAN_DEALER_GROUP v "
					+"WHERE r. TIP_PRODUCT_NAME="+Brandname1+" "
					+"AND r.tip_third_party= v.DEALER_GROUP_SERIAL "
					+"AND to_date(r.TIP_EFFECTIVE_DATE,'DD-MON-YYYY HH24:MI:SS')<=to_date(a.agr_create_date,'DD-MON-YYYY HH24:MI:SS') "
					+"AND r.tip_lower_limit<="+Lowerlimit+" "
					+"AND r.tip_upper_limit>="+Upperlimit+" "
					+"AND a.agr_serial="+Agrserial+" "
					+"AND v.AGR_SERIAL ="+Agrserial+" "
					+"AND r.TIP_THIRD_PARTY_NAME="+Introducer+" "
					+"ORDER BY r.tip_effective_date DESC";
			
		}
		
		if(!Brandname2.isEmpty()&&Brandname2!=null)
		{
			
			Query = "SELECT  to_char(r.tip_effective_date,'DD-MON-YYYY HH24:MI:SS'),to_char(a.agr_create_date,'DD-MON-YYYY HH24:MI:SS') ,r.* FROM tiered_pricing_rates r,agreements a,V_PAN_DEALER_GROUP v "
					+"WHERE r. TIP_PRODUCT_NAME="+Brandname2+" "
					+"AND r.tip_third_party= v.DEALER_GROUP_SERIAL "
					+"AND to_date(r.TIP_EFFECTIVE_DATE,'DD-MON-YYYY HH24:MI:SS')<=to_date(a.agr_create_date,'DD-MON-YYYY HH24:MI:SS') "
					+"AND r.tip_lower_limit<="+Lowerlimit+" "
					+"AND r.tip_upper_limit>="+Upperlimit+" "
					+"AND a.agr_serial="+Agrserial+" "
					+"AND v.AGR_SERIAL ="+Agrserial+" "
					+"AND r.TIP_THIRD_PARTY_NAME="+Introducer+" "
					+"ORDER BY r.tip_effective_date DESC";
		}
		
		if(Brandname1.isEmpty()&&Brandname2.isEmpty()&&!Agrserial.isEmpty()&&Agrserial!=null)
		{
			Query = "Select * from V_PAN_TIERED_PRICING where AGR_SERIAL ="+Agrserial+"";
		}
		
	
		return Query;
		
		}
	
	//@SuppressWarnings("resource")
	public static void TP_Securedtasks(String ST) throws Exception
	{
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Common_Property.SQLcon=DriverManager.getConnection("jdbc:oracle:thin:@linux03:1524:SMFSYS", "forte", "forte");
		Common_Property.st = Common_Property.SQLcon.createStatement();
		String Query=null;
		 STavailable = 0;
		int getcount = 0;
		
		
		if(ST.contains("WST"))     //With Secured task
		{
									
			Query = "select  count(*) as Cnt, rst_serial from user_roles, roles, role_secured_tasks, secured_tasks"
					+ " where uro_oracle_user = 'CHENNAI' and"
					+ " uro_role = rol_serial and rol_serial = rst_role and rst_secured_task = sta_serial"
					+ " and sta_serial = 283 group by rst_serial" ;
			Common_Property.st = Common_Property.SQLcon.createStatement();
			Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
			Common_Property.rs = Common_Property.Pst.executeQuery();
			int rstcount;
			if (!Common_Property.rs.next())
			{
				getcount = 0;
			}
			else
			{
				getcount = Common_Property.rs.getInt("Cnt");
			  
			}  
			
		      if (getcount >= 1)
		      {
		    			
					String rstserial = Common_Property.rs.getString("rst_serial");
					rstcount=Integer.parseInt(rstserial);
					STavailable = 1;
					System.out.println(rstcount);
			
				}
	
			 else
				{
					Query = "select max(rst_serial) as maxserial from role_secured_tasks";
					Common_Property.st = Common_Property.SQLcon.createStatement();
					Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
					Common_Property.rs1 = Common_Property.Pst.executeQuery();
					Common_Property.rs1.next();
					String  rolesecuredtaskcount=Common_Property.rs1.getString("MAXSERIAL");
					rstcount= Integer.parseInt(rolesecuredtaskcount)+1;
					Query = "insert into role_secured_tasks(RST_SERIAL,RST_role,rst_secured_task) values(?,?,?)";
					Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
					Common_Property.Pst.setInt(1,rstcount);
					Common_Property.Pst.setInt(2,2);
					Common_Property.Pst.setInt(3,283);
					int i = Common_Property.Pst.executeUpdate();
					STavailable = 1;
					System.out.println(i + "records inserted.");
			   
				}
				
			}
			
		

		else 
		{
			if(ST.contains("NST"))      //Non or without Secured task
	
			{
				STavailable = 0;
				Query = "select  count(*) as Cnt, rst_serial from user_roles, roles, role_secured_tasks, secured_tasks"
					+ " where uro_oracle_user = 'CHENNAI' and"
					+ " uro_role = rol_serial and rol_serial = rst_role and rst_secured_task = sta_serial"
					+ " and sta_serial = 283 group by rst_serial" ;
			
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
				Common_Property.rs = Common_Property.Pst.executeQuery();
			
				int rstcount;
				while (Common_Property.rs.next())
				{
					getcount = Common_Property.rs.getInt("Cnt");
					if (getcount >= 1)
					{
						String rstserial = Common_Property.rs.getString("rst_serial");
						rstcount=Integer.parseInt(rstserial);
						Query = "delete from role_secured_tasks where rst_serial = ? ";
						Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
						Common_Property.Pst.setInt(1, rstcount);
						Common_Property.Pst.executeUpdate();
						System.out.println( "records deleted.");
					}
				}
			} 
		}
	}
	
	public static void Tieredpricingparameter() throws Exception

	{
		
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		 Date sdate = new Date();
		 String datetimestart=dateFormat.format(sdate);	
		 

	 try 
	    {	
		 /*
		 	if(smf.Batchstatus.contains("No"))
		 	{
		 	*/ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Common_Property.SQLcon=DriverManager.getConnection("jdbc:oracle:thin:@linux03:1524:SMFSYS", "forte", "forte");
			Common_Property.st = Common_Property.SQLcon.createStatement();
			String Agreementno = "'" + Driver.getData("Agreement_Number") +  "'" ;
			System.out.println(Agreementno);
			String Query1 = "select AGR_SERIAL from agreements Where AGR_AGREEMENT_NUMBER="+Agreementno+" ";
			Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query1);
			Common_Property.rs = Common_Property.st.executeQuery(Query1);
			Common_Property.rs.next();
				 
			String AgrSerial =  "'" + Common_Property.rs.getString("AGR_SERIAL")+ "'";
			System.out.println(AgrSerial);
			
			String Query=null;
			
		      Introducer="'" + Driver.getData("Introducercode") + "'" ;  //TIP_THIRD_PARTY_NAME
			  Lowerlimit="'" + Driver.getData("TIP_LOWER_LIMIT") + "'" ; //Lower limit
			  Upperlimit="'" + Driver.getData("TIP_UPPER_LIMIT") + "'" ;//Upper limit
			  Brandname1="'"+Driver.getData("TIP_PRODUCT_NAME")+"'";//Product name
			  Brandname2="'"+Driver.getData("TIP_PRODUCT_NAME1")+"'"; //product name
			  //newly amended
			  QProductserial="'"+Driver.getData("TIP_PRODUCT")+"'"; //product serial quality 
			  FProductserial="'"+Driver.getData("FTP_TIP_PRODUCT")+"'"; //product serial finishline
			//  APRflag=Testdata.getTD("APRflag");
			 str=Driver.getData("QF");
			if(str.equalsIgnoreCase("Yes"))
			{
					if(Brandname1.contains("Quality+")&& flag==0)
					{
					Query=TieredpricingSQL(Introducer, Lowerlimit, Upperlimit, Brandname1, "",AgrSerial);
					flag=1;
					} 
					else
					{
						 if(Brandname2.contains("Finishline"))
						{
							Query=TieredpricingSQL(Introducer, Lowerlimit, Upperlimit,"",Brandname2,AgrSerial);
						}
						
					}
			}
			else
			{
				if(Brandname1.contains("Quality+"))
				{
				Query=TieredpricingSQL(Introducer, Lowerlimit, Upperlimit, Brandname1, "",AgrSerial);
				
				} 
			
			}
				Common_Property.st = Common_Property.SQLcon.createStatement();
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
				Common_Property.rs = Common_Property.st.executeQuery(Query);
				Common_Property.rs.next();
			
				MotorFrondEnd.TPflag=1;
				TIP_THIRD_PARTY_NAME=Common_Property.rs.getString(11);
				TIP_Effective_rate=Common_Property.rs.getString(2);
				AGR_create_rate=Common_Property.rs.getString(1);
				TIP_PRODUCT_NAME=Common_Property.rs.getString(9);
				TIP_TIER_NAME=Common_Property.rs.getString(13);
				TIP_LOWER_LIMIT=Common_Property.rs.getString(5);
				TIP_UPPER_LIMIT=Common_Property.rs.getString(14);
				TIP_DEFAULT_RATE=Common_Property.rs.getString(3);
				TIP_MIN_RATE=Common_Property.rs.getString(7);
				TIP_MAX_RATE=Common_Property.rs.getString(6);
				
				
				Driver.FieldstoUpdate.put("TIP_THIRD_PARTY_NAME", "'"+TIP_THIRD_PARTY_NAME+"'");
				Driver.FieldstoUpdate.put("TIP_Effective_rate","'"+TIP_Effective_rate+"'");                                                                         //Testdata.PutstoreTD(TIP_Effective_rate, "AGR_create_rate");
				Driver.FieldstoUpdate.put("AGR_create_rate","'"+AGR_create_rate+"'");
				Driver.FieldstoUpdate.put("TIP_PRODUCT_NAME","'"+TIP_PRODUCT_NAME+"'");
				Driver.FieldstoUpdate.put("TIP_TIER_NAME","'"+TIP_TIER_NAME+"'");
				Driver.FieldstoUpdate.put("TIP_LOWER_LIMIT","'"+TIP_LOWER_LIMIT+"'");
				Driver.FieldstoUpdate.put("TIP_UPPER_LIMIT","'"+TIP_UPPER_LIMIT+"'");
				Driver.FieldstoUpdate.put( "TIP_DEFAULT_RATE","'"+TIP_DEFAULT_RATE+"'");
				Driver.FieldstoUpdate.put( "TIP_MIN_RATE","'"+TIP_MIN_RATE+"'");
				Driver.FieldstoUpdate.put("TIP_MAX_RATE","'"+TIP_MAX_RATE+"'");
				
				Driver.WhereCondition.put("Agreement_number",Agreementno);
				Driver.WhereCondition.put("put_ag_no", "'"+Driver.recordset1.getField("put_ag_no")+"'");
				
				Driver.TableName="Sheet2";
				
				Driver.Update();
			
				Query=TieredpricingSQL("", "", "","","",AgrSerial);
				Common_Property.st = Common_Property.SQLcon.createStatement();
				Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query);
				Common_Property.rs = Common_Property.st.executeQuery(Query);
				Common_Property.rs.next();
				
				if(Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED").contains(Driver.getData("Dealergroup")))
				{
					DealerTPstatus=Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED");
					Utilities.passresult("Tiered pricing", "Dealer used tiered pricing enabled", DealerTPstatus, datetimestart);
				}
				else if(Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED").contains(Driver.getData("Dealergroup")))
				{
					
				    DealerTPstatus=Common_Property.rs.getString("VTIP_DEALER_GROUP_ENABLED");
				    Utilities.passresult("Tiered pricing", "Dealer used is not tiered pricing enabled", DealerTPstatus, datetimestart);
				}
			
		 /*}
		 	else
	  		{
				
			Main_Keyword.state=false;
			Utilities.Capture_Screenshot();
			Utilities.failresult("Tieredpricing paramter", "Batch error status is not displayed as NO",smf.Batchstatus, datetimestart);
	  		}*/
	    
	    }
	 catch (Exception ex) 
		{
		    System.err.print("Exception: "+ex);
		    System.err.println(ex.getMessage());
		}

	    }
	
	


}



