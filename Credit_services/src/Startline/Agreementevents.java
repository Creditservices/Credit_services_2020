package Startline;

import java.io.IOException;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Common_Funtions.*;
import Common_Funtions.Utilities;
import Startline.MotorFrondEnd;


import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.codoid.products.exception.FilloException;

public class Agreementevents {
	
	
	public static String AgrSerial;
	public static String QueryAgreementnumber;
	 static String halfwayvalue;
	//Events2:Secondary value events
	//Events1:Primary value events
	public static String EventsCheck(String Events1, String Events2, String Activity1,String AgrSrl)
	{
		String Query3= null;
		
		
		if (!Events2.isEmpty() && Events2 != null)
		{
			Query3= "Select A.ACT_DESCRIPTION,A.ACT_EVENT_VALUE_TITLE,B.EVE_VALUE,B.EVE_VALUE1 from Activities A, Events B Where (A.Act_serial = B.Eve_activity) and B.eve_agreement = "+AgrSrl+" and A.Act_Description = " + Activity1 +"  and B.EVE_VALUE1= "+Events2+ "";
		}
		else
		{
			if(!Events1.isEmpty() && Events1 != null && !Activity1.contains("Quality+ and PCP Exceptions")&&!Activity1.contains("Dummy")&& !Activity1.isEmpty()&& Activity1 != null)
			{
				Query3= "Select A.ACT_DESCRIPTION,A.ACT_EVENT_VALUE_TITLE,B.EVE_VALUE,B.EVE_VALUE1 from Activities A, Events B Where (A.Act_serial = B.Eve_activity) and B.eve_agreement = "+AgrSrl+" and A.Act_Description =" + Activity1 +"  and B.EVE_VALUE= "+Events1+ "";
			}
		
			else
			{ 
				if(!Events1.isEmpty() && Activity1.contains("Quality+ and PCP Exceptions"))
				{
					Query3 = "select Count(*) as CNT from notes where not_foreign_serial in (select eve_serial from events where  eve_agreement = "+AgrSrl+" and events.EVE_VALUE = "+Events1+")" ;
				}
				
			else
				{
				if (Events1.isEmpty() && Events2.isEmpty() && !Activity1.isEmpty() && Activity1!=null && !Activity1.contains("Dummy")&& !Activity1.contains("Specialterms"))
				{
					Query3= "Select A.ACT_DESCRIPTION,A.ACT_EVENT_VALUE_TITLE,B.EVE_VALUE,B.EVE_VALUE1 from Activities A, Events B Where (A.Act_serial = B.Eve_activity) and B.eve_agreement = "+AgrSrl+" and A.Act_Description = " + Activity1 +"";
				}
			else
				if(Events1.isEmpty() && Events2.isEmpty() && !Activity1.isEmpty()&& Activity1.contains("Dummy")&& !Activity1.contains("Specialterms"))
				{
					Query3 = "select count(*) as CNT from notes where not_foreign_serial in (select eve_serial from events where  eve_agreement = "+AgrSrl+") ";
				}
				
				else
					if(Events1.isEmpty() && Events2.isEmpty() && !Activity1.isEmpty()&& Activity1.contains("Specialterms"))
					{
						Query3 = "select * from exceptions where exp_pancredit_table ='18' and exp_pancredit_table_serial = "+AgrSrl+" and EXP_REASONS  like 'Tiered Pricing Tier Name:%' ";
					}
				
			else
				if(!Events1.isEmpty() && Activity1.contains("Dummy"))
				{
					Query3 = "select * from notes where not_foreign_serial in (select eve_serial from events where  eve_agreement ="+AgrSrl+" and events.EVE_VALUE = "+Events1+")" ;
				}
					
			}
			}
		}
	  return Query3;
	}
    
	public static void Agr_events_check( ArrayList<String> activitys,ArrayList<String> Primaryvalue,ArrayList<String> Secondaryvalue,String Status,String CurPlan) throws IOException, InterruptedException //AXC-REGR-190
, FilloException
	{	
		//Varaibale description:
		/*REF,CVAR --->Status: REF- Referred, Plan :CVAR - Call validate Auto refer
		 *MREF,CVAR --->Status: MREF- Motor front end Referred, Plan :CVAR - Call validate Auto refer
		 *UPDRV,CVAR --->Status: UPDRV-Update referred version, Plan :CVAR -  Call validate Auto refer
		 *SQLREF,CVAR ---->Status :SQL Referred  -call validate auto referred
		 *Decision,Cnt----> Decision reason ,Count
		 *AC,AWE  ----->  Status - Accpeted, plan:AWE- Accepted Awaiting Esign
		 *EP,EDR  ----->  Status - Esignature pass events, plan:EDR -Esign docs received
		 *ER,CMA ------->  Status - ER:ESign Revert to wet sign, plan:CMA=Call validate manual approved
		 *SF,EF ------->  Status - SF-Security Fail, plan:EF - Esign Failure
		 *DL,EF ------->  Status - DL-Driving License Fail, plan:EF - Esign Failure
		 *EC,EF ------->  Status -EC:ESign Cancel, plan:EF - Esign Failure
		 *CA,CVCA ------->  Status -CA:Conditionally Accepted, plan:CVCA-Call validate conditional approved
		 *AWP,EDR ------->  Status -AWP:Awaiting payout, Plan :EDR-Esign Docs Received
		 *AC,CVMA ------->  Status -Accepted, Plan :Call validate manual approved
		 *RTI,CVAR  --->Status: RTI- Retrun to introducer, Plan :CVAR - Call validate Auto refer
		 *RD,CVMD  --->Status: RD- RejecteD, Plan :CVMD - Call validate Manual decline
		 *RD,FLPreVet  --->Status: RD- RejecteD, Plan :FLPreVet - Finishline Pre vet auto decline
		 *RD,PreVetManual  --->Status: RD- RejecteD, Plan :FLPreVet -Pre vet manual decline
		 *RD,PreVet  --->Status: RD- RejecteD, Plan :PreVet -  Pre vet auto decline
		 *RD,PostAD --->Status: RD- RejecteD, Plan :PostAD -  Post bureau declines
		 *TP,DR ------>Case : Tiered Pricing event:DR- DefaultRate
		 * Exception,details  ----->Status: Exception  plan :details
		*/
		
	
		System.out.println("Method Now Running: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		String methodname =(Thread.currentThread().getStackTrace()[1].getMethodName());
		Thread.sleep(950);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date sdate = new Date();
		String datetimestart=dateFormat.format(sdate);
		
		
	try
	{
			Configuration.getProperty();
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println(Configuration.OracleDatabase);
			//Configuration.OracleDatabase = Configuration.OracleDatabase.replace(""", "");
			Common_Property.SQLcon=DriverManager.getConnection(Configuration.OracleDatabase, "forte", "forte");
			Common_Property.st = Common_Property.SQLcon.createStatement();
			
			 QueryAgreementnumber = "'" + Driver.getData("Agreement_Number") +  "'" ;
			System.out.println(QueryAgreementnumber);
			String Query1 = "select AGR_SERIAL from agreements Where AGR_AGREEMENT_NUMBER="+QueryAgreementnumber+" ";
			Common_Property.Pst = Common_Property.SQLcon.prepareStatement(Query1);
			Common_Property.rs = Common_Property.st.executeQuery(Query1);
			
			Common_Property.rs.next();
			System.out.println(Common_Property.rs.getRow());	 
			 AgrSerial =  "'" + Common_Property.rs.getString("AGR_SERIAL")+ "'";
			System.out.println(AgrSerial);
			boolean ValidateEvent = false;
		
				//E-Signature Status Changed
			  String Events = null,Query = null,Activity=null;
			  int flag = 0,AAA1 = 1,ESCV=0,AAA=0,AAA2=2,AWPAA=0,ASC=0,AAC=4,PAY=4,prim=2,MRef=0,update=1,Primary=3,PMvalue=5;
			 
			  for (int i=0;i <= activitys.size() -1; i++)
			  { 
				 
				  switch (activitys.get(i))
				  {
					case "E-Signature Status Changed": // eve - value1 - secondary
					{
					
						if ((Status == "SF" && CurPlan == "EF")||(Status == "EC" && CurPlan == "EF"))
						{	
						 Events ="'"+Secondaryvalue.get(0)+"'";
						 Activity="'"+activitys.get(i)+"'";
						 Query = EventsCheck("",Events,Activity,AgrSerial);
						 flag = 2;
						 break;
						}
						else
							if ((Status == "DL" && CurPlan == "EF")|| (Status == "ER" && CurPlan == "CMA")|| (Status == "EP" && CurPlan == "EDR"))
							{
								 Events ="'"+Secondaryvalue.get(ESCV)+"'";
								 Activity="'"+activitys.get(i)+"'";
								 Query = EventsCheck("",Events,Activity,AgrSerial);
								 flag = 2;
								 ESCV++;
								 break;
							}
						 
					}
					case "Additional Attribute Removed":
					case "Tiered Pricing Exceptions"://eve value -Primary
					{
						if ((Status == "SF" && CurPlan == "EF") || (Status == "DL" && CurPlan == "EF")|| 
							(Status == "EC" && CurPlan == "EF")|| (Status == "ER" && CurPlan == "CMA")||
							(Status == "TP" && CurPlan == "DR"))
						{
							Events ="'"+Primaryvalue.get(0)+"'";
							Activity="'"+activitys.get(i)+"'";
							Query = EventsCheck(Events,"",Activity,AgrSerial);
							flag = 1;
							break;
						}
						
					}
				 
					case "Additional Attribute Added":
				
					{
						if ((Status == "SF" && CurPlan == "EF") || (Status == "EC" && CurPlan == "EF")) //SF - Security Fail ,DL - Driving License Fail && EF - E-sign Failure
							{		
							Activity="'"+activitys.get(i)+"'";
							Events ="'"+Secondaryvalue.get(AAA)+"'";
							Query = EventsCheck("",Events,Activity,AgrSerial);
							flag = 2;
							AAA++;
							break;
							}
						else 
							if(Status == "DL" && CurPlan == "EF")
							{
							Activity="'"+activitys.get(i)+"'";
							Events ="'"+Secondaryvalue.get(AAA1)+"'";
							Query = EventsCheck("",Events,Activity,AgrSerial);
							flag = 2;
							AAA1++;
							break;
							}
						else 
							if(Status == "ER" && CurPlan == "CMA")
							{
							Activity="'"+activitys.get(i)+"'";
							Events ="'"+Secondaryvalue.get(AAA2)+"'";
							Query = EventsCheck("",Events,Activity,AgrSerial);
							flag = 2;
							AAA2++;
							break;
							}
						else 
							if(Status == "EP" && CurPlan == "EDR")
							{
									Activity="'"+activitys.get(i)+"'";
						  			Events ="'"+Primaryvalue.get(0)+"'";
						  			Query = EventsCheck(Events,"",Activity,AgrSerial);
									flag = 1;
									break;
							}
						
						else 
							if((Status == "AWP" && CurPlan == "EDR")|| (Status == "REF" && CurPlan == "CVAR") || (Status == "MREF" && CurPlan == "CVAR") )
							{
								Activity="'"+activitys.get(i)+"'";
					  			Events ="'"+Primaryvalue.get(AWPAA)+"'";
					  			Query = EventsCheck(Events,"",Activity,AgrSerial);
								flag = 1;
								AWPAA++;
								break;
							}
						
							else 
								if((Status == "TP" && CurPlan == "DR"))
								{
									Activity="'"+activitys.get(i)+"'";
						  			Events ="'"+Primaryvalue.get(1)+"'";
						  			Query = EventsCheck(Events,"",Activity,AgrSerial);
									flag = 2;
									break;
								}
						//newly amended by susmi
								else 
									if((Status == "UPDRV" && CurPlan == "CVAR"))
									{
										Activity="'"+activitys.get(i)+"'";
							  			Events ="'"+Primaryvalue.get(0)+"'";
							  			Query = EventsCheck(Events,"",Activity,AgrSerial);
										flag = 2;
										break;
									}
						
								
					}
					
					case "IOCS Esign Failure Email": 
					case "Modelled Using Tiered APR":
					case "Tiered Pricing Rate Set":
						//event title
					{
						if ((Status == "SF" && CurPlan == "EF") || (Status == "DL" && CurPlan == "EF") ||
							(Status == "EC" && CurPlan == "EF") || (Status == "ER" && CurPlan == "CMA")|| 
							(Status == "TP" && CurPlan == "DR"))
						{
						Activity="'"+activitys.get(i)+"'";
						Query = EventsCheck("","",Activity,AgrSerial);
						flag = 3;
						break;
						}
					}
				  
					case "Additional Attribute Changed": // eve - value1 - secondary
					{
						if (Status == "DL" && CurPlan == "EF")
						{
						 Events ="'"+Secondaryvalue.get(3)+"'";
						 Activity="'"+activitys.get(i)+"'";
						 Query = EventsCheck("",Events,Activity,AgrSerial);
						 flag = 2;
						 break;
						}
						else 
						if ((Status == "ER" && CurPlan == "CMA") || (Status == "EP" && CurPlan == "EDR"))
						{
						 Events ="'"+Secondaryvalue.get(AAC)+"'";
						 Activity="'"+activitys.get(i)+"'";
						 Query = EventsCheck("",Events,Activity,AgrSerial);
						 flag = 2;
						 AAC++;
						 break;
						}
						else 
							if (Status == "TP" && CurPlan == "DR")
							{
								Activity="'"+activitys.get(i)+"'";
					  			Events ="'"+Primaryvalue.get(1)+"'";
					  			Query = EventsCheck(Events,"",Activity,AgrSerial);
								flag = 2;
								break;
							}
						
						else 
							if(Status == "UPDRV" && CurPlan == "CVAR")
						{
							Activity="'"+activitys.get(i)+"'";
				  			Events ="'"+Primaryvalue.get(update)+"'";
				  			Query = EventsCheck(Events,"",Activity,AgrSerial);
							flag = 1;
							break;
						}
						
						else 
							if(Status == "MREF" && CurPlan == "CVAR")
						{
								
							Activity="'"+activitys.get(i)+"'";
				  			Events ="'"+Primaryvalue.get(2)+"'";
				  			Query = EventsCheck(Events,"",Activity,AgrSerial);
							flag = 5;
							break;
								
						}
						
						else 
							if(Status == "REF" && CurPlan == "CVAR")
						{
									
							Activity="'"+activitys.get(i)+"'";
				  			Events ="'"+Primaryvalue.get(MRef)+"'";
				  			Query = EventsCheck(Events,"",Activity,AgrSerial);
							flag = 5;
							MRef++;
							break;
									
						}

						
					}
					
					
					
					case "Additional Attribute Add":
					{
						
						if(Status == "MREF" && CurPlan == "CVAR")
						{
								Activity="'"+activitys.get(i)+"ed'";
					  			Events ="'"+Primaryvalue.get(PMvalue)+"'";
					  			Query = EventsCheck(Events,"",Activity,AgrSerial);
								flag = 2;
								PMvalue++;
								break;
						}
					}
					case "Additional Attribut":
					{
						
						if(Status == "MREF" && CurPlan == "CVAR")
						{
								Activity="'"+activitys.get(i)+"e Added'";
					  			Events ="'"+Primaryvalue.get(7)+"'";
					  			Query = EventsCheck(Events,"",Activity,AgrSerial);
								flag = 4;
								break;
						}
					}
					
					case "Additional":
					{
						
						if(Status == "MREF" && CurPlan == "CVAR")
						{
								Activity="'"+activitys.get(i)+" Attribute Added'";
					  			Events ="'"+Primaryvalue.get(8)+"'";
					  			Query = EventsCheck(Events,"",Activity,AgrSerial);
								flag = 6;
								break;
						}
					}
					
					
					
					case "Automatically Approved":
					case "CV Override Decision Made":
					case "Conditionally Approved":
					case "Approved Pack Requested":
					
					
					{
						
						if ((Status == "ER" && CurPlan == "CMA") || (Status == "AC" && CurPlan == "AWE") || (Status == "AC" && CurPlan == "CVMA")|| (Status == "CA" && CurPlan == "CVCA"))
						{
						Activity="'"+activitys.get(i)+"'";
						Query = EventsCheck("","",Activity,AgrSerial);
						flag = 3;
						break;
						}
						
					}
					
					case "Document sent to Dealflo":
					case "IOCS Initiate Success":
					case "IOCS Dealer URL Set":
					case "Document Emailed":
					{
						if ((Status == "ER" && CurPlan == "CMA") || (Status == "AC" && CurPlan == "AWE"))
						{
						Activity="'"+activitys.get(i)+"'";
						Query = EventsCheck("","",Activity,AgrSerial);
						flag = 3;
						break;
						}
					}
					
					case  "Finishline Available Set":
					case  "Product Evaluated":
					case  "Decisioning Started":
					case  "Call Report Search Completed":
					case  "Trace Score Set":
					case  "OI Score Set":
					case  "Gauge Score Set":
					case  "Pre Vet Ruleset Evaluated":
					case  "Post Bureau Ruleset Evaluated":
					case  "CallValidate Ruleset Evaluated":  
					case  "E-sig required set":
						
					{
						if(Status == "SQLREF" && CurPlan == "CVAR")
						{
						Activity="'"+activitys.get(i)+"'";
						Query = EventsCheck("","",Activity,AgrSerial);
						flag = 3;
						break;
						}
					
					}
				
					
					case "Quality+ and PCP Exceptions":
					{
						if(Status == "SQLREF" && CurPlan == "CVAR")
						{
						
						Events = "'"+Primaryvalue.get(0)+"'";	
						Activity="'"+activitys.get(i)+"'";
						Query = EventsCheck(Events,"",Activity,AgrSerial);
						flag = 4;
						break;
						}
					}
					
				
					
					case "Agreement Status Changed": // eve - value - primary
				  	{
				  		
				  		if ((Status == "RTI" && CurPlan == "CVAR") || (Status == "CA" && CurPlan == "CVCA"))
				  		{
				  		
			  			Events ="'"+Primaryvalue.get(0)+"'";
				  		Activity="'"+activitys.get(i)+"'";
				  		Query = EventsCheck(Events,"",Activity,AgrSerial);
				  		flag = 1;
				  		 break;
				  		}
				  		else if(Status == "AWP" && CurPlan == "EDR")
				  		{
				  			 Events ="'"+Secondaryvalue.get(ASC)+"'";
					  		 Activity="'"+activitys.get(i)+"'";
					  		 Query = EventsCheck("",Events,Activity,AgrSerial);
					  		 flag = 2;
					  		 ASC++;
					  		 break;
				  		}
				  	}
					
				  	case "Manually Rejected":
				  	case "Reject Letter Requested":
					case "Automatically Rejected":
				  	case "Call Report Search Required":
				  	case "Pre Vet Decision Made":
					case "Post Bureau Decision Made"://event title
				  	{
				  		
				  	if((Status == "RD" && CurPlan == "CVMD") || (Status == "RD" && CurPlan == "PreVet") || (Status == "RD" && CurPlan == "PostAD")|| (Status == "RD" && CurPlan == "FLPreVet") || (Status == "RD" && CurPlan == "PreVetManual")|| (Status == "SQLREF" && CurPlan == "CVAR"))
				  		{
				  		Activity="'"+activitys.get(i)+"'";
				  		Query = EventsCheck("","",Activity,AgrSerial);
				  		flag = 3;
				  		break;
				  		}
				  		
				  	}
				  	
						
				  		
				  	case "Automatically Referred":
				  	case "Call Validate Decision Made": //event title
					case "IOCS Dealer URL Cleared":
					case "Update Proposal":
					case "Cancel IOCSInitiateTransaction":
					{
				  		if ((Status == "REF" && CurPlan == "CVAR")||(Status == "UPDRV" && CurPlan == "CVAR")|| 
				  			(Status == "MREF" && CurPlan == "CVAR") || (Status == "TP" && CurPlan == "DR")||
				  			(Status == "PCPB" && CurPlan == "CVAR"))
				  		{
				  		
				  		Activity="'"+activitys.get(i)+"'";
				  		Query = EventsCheck("","",Activity,AgrSerial);
				  		flag = 3;
				  		break;
				  		}
				  	}
				  	
				  
				 
				  	case "Additional Attribute":
				  		
				  	{
				  		if(Status == "REF" && CurPlan == "CVAR")
				  		{
				  		
				  		Activity="'"+activitys.get(i)+" Added'";
				  		Events="'"+Primaryvalue.get(prim)+"'";
				  		Query = EventsCheck(Events,"",Activity,AgrSerial);
				  		flag = 2;
				  		prim++;
				  		break;
					  	}
				  	}
				  	
				  	case "Bank Details Amended":
				  	case "Agreement Activated": 
				  	case "Dealer Refer letter requested":
				  		
				  	{
				  		if((Status == "UPDRV" && CurPlan == "CVAR")|| (Status == "MREF" && CurPlan == "CVAR") || (Status == "AWP" && CurPlan == "EDR") || (Status == "RTI" && CurPlan == "CVAR"))
				  		{
				  		
				  		Activity="'"+activitys.get(i)+"'";
				  		Query = EventsCheck("","",Activity,AgrSerial);
				  		flag = 3;
				  		break;
					  	}
				  	}
				  	
					case "Excess Mileage Charge changed":        
				  
					{
						if(Status == "MREF" && CurPlan == "CVAR") 
				  		{
				  		
				  		Activity="'"+activitys.get(i)+"'";
				  		Events="'"+Primaryvalue.get(Primary)+"'";
				  		Query = EventsCheck(Events,"",Activity,AgrSerial);
				  		Primary++;
				  		flag = 7;
				  		break;
					  	}
					}
				  	
					case "Dummy" :
					case "Specialterms" :
				  	{
				  		
				  		if(Status == "Decision" && CurPlan == "Cnt")
				  		{
				  		Activity="'"+activitys.get(i)+"'";
				  		Query = EventsCheck("","",Activity,AgrSerial);
				  		flag = 4;
				  		break;
				  		}

				  		else if(Status == "Exception" && CurPlan == "Details")
				  		{
				  		Activity="'"+activitys.get(i)+"'";
				  		Events="'"+Primaryvalue.get(0)+"'";
				  		Query = EventsCheck(Events,"",Activity,AgrSerial);
				  		flag = 4;
				  		break;
				  		}
				  		else if(Status == "ST" && CurPlan == "Details")
				  		{
					  	Activity="'"+activitys.get(i)+"'";
					  	Query = EventsCheck("","",Activity,AgrSerial);
					  	flag =5;
					  	break;
					  	}
				  	}
				
				  	
				  	
				  	
				}
			 
					
					Common_Property.rs3 = Common_Property.st.executeQuery(Query);	
					//System.out.println(Query);
					//System.out.println(Common_Property.rs3);
					Common_Property.rs3.next();
					
					switch (flag)
					{
						case 1:
						{
							if ((Status == "SF" || Status == "DL" || Status == "EC" || Status == "ER" || Status == "EP" || Status == "TP")&& 
								(CurPlan == "EF" || CurPlan =="CMA" || CurPlan =="EDR" || CurPlan =="CVAR"  || CurPlan == "DR"))
							
							{
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Secondryeventvalue="'"+Common_Property.rs3.getString("EVE_VALUE1")+"'";
								Events="'"+Primaryvalue.get(0)+"'";
								if (Primaryeventvlue.contains(Events))
								{
									ValidateEvent = true;
									Events="'"+Primaryvalue.get(0)+"' :" +Secondryeventvalue;
								}
								flag = 0;
								break;
							}
							
							else
								if ((Status == "RTI" && CurPlan == "CVAR") || (Status == "CA" && CurPlan == "CVCA"))
								
									{
									String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
									String Secondryeventvalue="'"+Common_Property.rs3.getString("EVE_VALUE1")+"'";
									Events="'"+Primaryvalue.get(0)+"'";
									if (Primaryeventvlue.contains(Events)&& Secondryeventvalue.contains(Secondaryvalue.get(0)))
									{
										ValidateEvent = true;
										Events="New value:'"+Primaryvalue.get(0)+"',Old value:"+Secondryeventvalue;
									}
									flag = 0;
									break;
									}
							//newly amended code
								else
									if ((Status == "UPDRV"  && CurPlan == "CVAR") )
									
										{
										String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
										String Secondryeventvalue="'"+Common_Property.rs3.getString("EVE_VALUE1")+"'";
										Events="'"+Primaryvalue.get(update)+"'";
										if (Primaryeventvlue.contains(Events))
										{
											ValidateEvent = true;
											Events="Primary value:'"+Primaryvalue.get(update)+"',Secondary value:"+Secondryeventvalue;
										}
										flag = 0;
										update++;
										break;
										}
							
								else
									if((Status == "AWP" && CurPlan == "EDR"))
							  		{
										String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
										String Secondryeventvalue="'"+Common_Property.rs3.getString("EVE_VALUE1")+"'";
										if ((Primaryeventvlue.contains(Events))&& (Secondryeventvalue.contains("'"+Secondaryvalue.get(PAY)+"'")))
											{
											ValidateEvent = true;
											Events=Events+":" +Secondryeventvalue;
											
											}
										
										PAY++;
										flag = 0;
										break;
							  		
									}
							
									else
										if(Status == "MREF" && CurPlan == "CVAR")
								  		{
											String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
											String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
											if (Primaryeventvlue.contains(Events))
												{
												ValidateEvent = true;
												Events="'"+Primaryeventvlue+"' -" +Secondryeventvalue;
												 halfwayvalue=Secondryeventvalue;
												System.out.println(halfwayvalue);
												}
											flag = 0;
											break;
										}
								

									else
										if(Status == "REF" && CurPlan == "CVAR")
								  		{
											String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
																					 
											 String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
											 Float Secvalue=Float.parseFloat(Secondryeventvalue);
											 Float VTexposre=Float.parseFloat(MotorFrondEnd.VTexposure);
											 Float Halfwayval=Float.parseFloat(MotorFrondEnd.Halfway);
											 
											 if (Primaryeventvlue.contains(Events)&&(Secvalue.equals(Halfwayval))&&(Halfwayval > 0.0))
											 {
												 
												 
												 ValidateEvent = true;
												 Events=Primaryeventvlue+":"+Secondryeventvalue;
											 }
									
											 if (Primaryeventvlue.contains(Events)&&(Secvalue.equals(VTexposre)))
											 {
												 ValidateEvent = true;
												 Events=Primaryeventvlue+":"+Secondryeventvalue;
											 }
											
											
											flag =0;
											break;
								  		
										}
							
							
								
							}
						case 2:	
						{
							if ((Status == "SF" && CurPlan == "EF") || (Status == "DL" && CurPlan == "EF") || 
								(Status == "EC" && CurPlan == "EF") || (Status == "ER" && CurPlan == "CMA") || 
								(Status == "EP" && CurPlan == "EDR")|| (Status == "AWP" && CurPlan == "EDR"))
								
								
				
							{
								 
								String Secondryeventvalue="'"+Common_Property.rs3.getString("EVE_VALUE1")+"'";
								 if (Secondryeventvalue.contains(Events))
								 {
								 ValidateEvent = true;
								 }
								 flag = 0;
								 break;
								
								
								
							}
							
							else if((Status == "REF" && CurPlan == "CVAR") || (Status == "UPDRV" && CurPlan == "CVAR")||
									(Status == "MREF" && CurPlan == "CVAR") || (Status == "TP" && CurPlan == "DR"))
							
							{

								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
								 String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								 if(Primaryeventvlue.contains(Events)&&(Secondryeventvalue.contains(Secondaryvalue.get(0))))
								 {
								 ValidateEvent = true;
								 Events="Primaryvalue:"+Primaryeventvlue+",Secondary value:"+Secondryeventvalue;
								 }
								 flag = 0;
								 break;
							}
							
							
							
							}
						case 3:
						{
						if ((Status == "SF" && CurPlan == "EF") || (Status == "DL" && CurPlan == "EF") || (Status == "EC" && CurPlan == "EF") || 
								(Status == "ER" && CurPlan == "CMA") || (Status == "EP" && CurPlan == "EDR") ||
								(Status == "AC" && CurPlan == "AWE") || (Status == "AC" && CurPlan == "CVMA") || 
								(Status == "AWP" && CurPlan == "EDR")|| (Status == "RD" && CurPlan == "CVMD")|| 
								(Status == "RD" && CurPlan == "PostAD")|| (Status == "REF" && CurPlan == "CVAR") || 
								(Status == "RD" && CurPlan == "PreVet")|| (Status == "RD" && CurPlan == "FLPreVet")||
								(Status == "CA" && CurPlan == "CVCA")|| (Status == "RD" && CurPlan == "PreVetManual") ||
								(Status == "RTI" && CurPlan == "CVAR") || (Status == "MREF" && CurPlan == "CVAR")|| 
								(Status == "TP" && CurPlan == "DR") ||(Status == "PCPB" && CurPlan == "CVAR"))
								
								{
									String Activityname="'"+Common_Property.rs3.getString("ACT_DESCRIPTION")+"'";
									Events="'"+activitys.get(i)+"'";
									if (Activityname.contains(Events))
									{
										ValidateEvent = true;
									}
									flag = 0;
									break;
								}
							
							
							else if(Status == "UPDRV" && CurPlan == "CVAR")
							{
								String Activityname="'"+Common_Property.rs3.getString("ACT_DESCRIPTION")+"'";
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								
								Events="'"+activitys.get(i)+"'";
								if (Activityname.contains(Events))
								{
									ValidateEvent = true;
									Events="'"+activitys.get(i)+"' : Primaryvalue "+Primaryeventvlue+" Secondary value: "+Secondryeventvalue;
								}
								flag = 0;
								break;
						  		
							}
							
							else if(Status == "SQLREF" && CurPlan == "CVAR")
							{
								
								String Activityname=Common_Property.rs3.getString("ACT_DESCRIPTION");
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Activitytitle="'"+Common_Property.rs3.getString("ACT_EVENT_VALUE_TITLE")+"'";
								Events=activitys.get(i);
								if (Activityname.contains(Events))
								{
									
									ValidateEvent = true;
									Events=Activitytitle+ ":"+Primaryeventvlue+":"+Secondryeventvalue;
									
								}
								flag = 0;
								break;
							}
							
							}
						case 4:
						{
							 
							if(Status == "SQLREF" && CurPlan == "CVAR")
							{
							
								Events = "'"+Common_Property.rs3.getString("CNT")+"'";
								ValidateEvent = true;
								 Events=activitys.get(i)+"Event Notes count for" + activitys.get(i)+ Primaryvalue.get(0) + ":" + Events;
								
								
							}
							else if(Status == "Decision" && CurPlan == "Cnt")
							{
							
								Events = "'"+Common_Property.rs3.getString("CNT")+"'";
								ValidateEvent = true;
								Events="Decision Reason Count of "+QueryAgreementnumber+"is greater than one"+Events;
							}
							
							
							
							else if((Status == "Exception" && CurPlan == "Details"))
							{
								
								Events = "'"+Common_Property.rs3.getString("NOT_TEXT")+"'";
								ValidateEvent = true;
								 Events="User:"+Common_Property.rs3.getString("NOT_ORACLE_USER")+"  Note text:"+Events;
							}
							
						
							else if((Status == "MREF" && CurPlan == "CVAR")&& (Driver.getData("Brnd").contains("Quality+")||Driver.getData("Brnd").contains("Finishline")))
							{
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
								if(Primaryeventvlue.contains(Events)&&Secondryeventvalue.contains(Secondaryvalue.get(0)))
								{
									ValidateEvent = true;
									Events="Primaryvalue:"+Primaryeventvlue+",Secondary value:"+Secondryeventvalue;
									
								}
								 
								 
							}
							
							else if((Status == "MREF" && CurPlan == "CVAR")&& Driver.getData("Brnd").contains("PCP"))
							{
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
								if(Primaryeventvlue.contains(Events)&&Secondryeventvalue.contains(Secondaryvalue.get(1)))
								{
									ValidateEvent = true;
									Events="Primaryvalue:"+Primaryeventvlue+",Secondary value:"+Secondryeventvalue;
									
								}
								 
								 
							}
							
							flag = 0;
							break;
						}
						
						case 5:
						{
							if(Status == "MREF" && CurPlan == "CVAR")
							{
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
							
								Secondryeventvalue=Secondryeventvalue.substring((Secondryeventvalue.indexOf( ':', 10 ) +1), Secondryeventvalue.length());
							 
								Float Secvalue=Float.parseFloat(Secondryeventvalue);
								Float Halfwayval=Float.parseFloat(MotorFrondEnd.Halfway);
								
								 
								  if (Primaryeventvlue.contains(Events)&&(Secvalue.equals(Halfwayval))&&(Halfwayval > 0.0))
								  {
									 
									 Events="Newly changed"+Primaryeventvlue+":"+Secondryeventvalue;
									 Utilities.passresult(methodname ,activitys.get(i) +" " +Events + "Generated" ,Events,datetimestart);
									 String Secondryeventvalue1=Common_Property.rs3.getString("EVE_VALUE1");
									 Secondryeventvalue1=Secondryeventvalue1.substring((Secondryeventvalue1.indexOf( ':', 9 ) +1),(Secondryeventvalue1.indexOf( ',', 9 )));
									 Float Secvalue1=Float.parseFloat(Secondryeventvalue1);
									 Float Halfwayval1=Float.parseFloat(halfwayvalue);
									 Events ="'"+Primaryvalue.get(2)+"'";
								     if (Primaryeventvlue.contains(Events)&&(Secvalue1.equals(Halfwayval1))&&(Halfwayval1 > 0.0))
								     {
										 ValidateEvent = true;
										 Events="Old Value calculated after the financial page" +Primaryeventvlue+" : "+ Secondryeventvalue1;
								     }
								  }
							}
							
							else if(Status == "REF" && CurPlan == "CVAR")  
							{
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
							
								Secondryeventvalue=Secondryeventvalue.substring((Secondryeventvalue.indexOf( ':', 10 ) +1), Secondryeventvalue.length());
							 
								
								Float Secvalue1=Float.parseFloat(Secondryeventvalue);
								Float Vtexposurenew=Float.parseFloat(MotorFrondEnd.VTexposure);
								Float Halfwayvalnew=Float.parseFloat(MotorFrondEnd.Halfway);
								

								if (Primaryeventvlue.contains(Events)&&(Secvalue1.equals(Vtexposurenew))&&(Vtexposurenew >=0.0))
								  {
									
									 Events ="'"+Primaryvalue.get(0)+"'";
									
								     if (Primaryeventvlue.contains(Events)&&(Secvalue1.equals(Vtexposurenew))&&(Vtexposurenew>=0.0))
								     {
										 ValidateEvent = true;
										 
										 Events="After redo"+Primaryeventvlue+":"+Secondryeventvalue;
										 
								     }
								  }
								
								 if (Primaryeventvlue.contains(Events)&&(Secvalue1.equals(Halfwayvalnew))&&(Halfwayvalnew > 0.0))
								  {
									 
									
									 Events ="'"+Primaryvalue.get(1)+"'";
								     if (Primaryeventvlue.contains(Events)&&(Secvalue1.equals(Halfwayvalnew))&&(Halfwayvalnew>=0.0))
								     {
										 ValidateEvent = true;
										 Events="After redo"+Primaryeventvlue+":"+Secondryeventvalue;
								     }
								  }
							}
							
							else if(Status == "ST" && CurPlan == "Details")
							{
								String Primaryeventvlue=Common_Property.rs3.getString("EXP_REASONS");
								 String TPname=Primaryeventvlue.substring(Primaryeventvlue.indexOf( ':', 0 )+1, Primaryeventvlue.length()).trim();
								 if(TPname.contains(Driver.getData("TIP_TIER_NAME"))||TPname.contains(Driver.getData("FTP_TIER_NAME")))  //TieredPricing.TIP_TIER_NAME
								{
									 ValidateEvent = true;
									 Events="Tiered pricing name:"+TPname;
								}
								 
							}
							
							flag =0;
							break;
						}
						
					
						case 6:
						{
							if(Status == "MREF" && CurPlan == "CVAR")
							{
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Secondryeventvalue=Common_Property.rs3.getString("EVE_VALUE1");
								if(Primaryeventvlue.contains(Events)&&Secondryeventvalue.contains(Secondaryvalue.get(1)))
								{
									ValidateEvent = true;
									Events="Primaryvalue:"+Primaryeventvlue+",Secondary value:"+Secondryeventvalue;
									
								}
							}
							
							flag =0;
							break;
						}
						
						
						case 7:
						{
							if(Status == "MREF" && CurPlan == "CVAR")
							{
								
								String Activityname="'"+Common_Property.rs3.getString("ACT_DESCRIPTION")+"'";
								String Primaryeventvlue="'"+Common_Property.rs3.getString("EVE_VALUE")+"'";
								String Activitytitle="'"+Common_Property.rs3.getString("ACT_EVENT_VALUE_TITLE")+"'";
								Activity="'"+activitys.get(i)+"'";
								if (Activityname.contains(Activity)&&Primaryeventvlue.contains(Events))
								{
									ValidateEvent = true;
									Events="'"+activitys.get(i)+"' : Title" + Activitytitle +  " ,Primary value  "+Primaryeventvlue;
								}
								
								
								flag = 0;
								break;
							}
							
						}
						
				}
			  
					
					if (ValidateEvent == true)
					{
						Utilities.passresult(methodname ,activitys.get(i) +"Generated" ,Events,datetimestart);
						System.out.println(methodname   +"-"+    Events);
						ValidateEvent = false;
					}
					else
					{
						Utilities.failresult(methodname ,activitys.get(i) +"Not Generated" ,Events,datetimestart);
						
					}	
				}
		
			
			
	}
		catch (Exception e)  
		{

		
		System.out.println("The exception was "+e);
		System.out.println("Abnormal Termination due to "+e);
		String Desc="Test Run of"+methodname+"was not completed Sucessfully";
		Utilities.failresult(methodname,Desc,null,datetimestart);
		Utilities.ExtentFailReport1(methodname, Desc);

		}

}

			

	}
