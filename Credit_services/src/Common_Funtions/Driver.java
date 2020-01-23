package Common_Funtions;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.exec.ExecuteException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import OpenUniversity.*;
import java.lang.reflect.*;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;

public class Driver {
	public static String CurrClient, WhichClient, Testcase, getkeyword, str, getdata, strQuery, Agreement_Name, getref,
			TestCase, record1, put_ag_no, batchhead, TableName,MethodName,Methodid,get_ag_no,xmlData,strUrl;;
	public static int getTDvalue = 0;
	public static ArrayList<String> Project1 = new ArrayList<String>();
	public static ArrayList<String> selectQuerydata = new ArrayList<String>();
	public static ArrayList<String> updateQuerydata = new ArrayList<String>();
	public static ArrayList<String> insertQuerydata = new ArrayList<String>();
	public static Connection connection;
	public static Recordset recordset, recordset1, recordset2;
	public static List<String> KeywordList = Arrays.asList();
	public static List<String> BatchList = Arrays.asList();
	public static boolean Testresult, sheetflag;
	public static Fillo fillo;
	public static ArrayList<String> FieldNames = new ArrayList<String>();
	public static ArrayList<String> FieldValues = new ArrayList<String>();
	public static ArrayList<String> attributes = new ArrayList<String>();
	public static HashMap<String, String> FieldstoUpdate = new HashMap<>();
	public static HashMap<String, String> WhereCondition = new HashMap<>();
	public static HashMap<String, String> FieldstoSelect = new HashMap<>();
	public static HashMap<String, String> FieldstoInsert = new HashMap<>();
	
	public static void Project_ToRun(String Project) throws NullPointerException, Exception {
		System.out.println("Method Now Running: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		MethodName = (Thread.currentThread().getStackTrace()[1].getMethodName());
		Methodid = Long.toString(Thread.currentThread().getId());
		
		try {
			Configuration.getProperty();
			Utilities.fileBackup(Configuration.Datapath, "ProjectToRun");
			Utilities.fileBackup(Configuration.Datapath, Project);
			Utilities.reportBackup(Configuration.reportpath, Project);
			//Configuration.updatePropertyFile(Methodid,MethodName,"True");
			fillo = new Fillo();
			WhichClient = Project;
			CurrClient = "'" + Project + "'";
			connection = fillo.getConnection(Configuration.Driverpath);
			selectQuerydata.add(0, CurrClient);
			TableName="Sheet1";
			FieldstoSelect.put("*", "");
			WhereCondition.put("Run", "'Yes'");
			recordset = connection.executeQuery(select());

			while (recordset.next()) {
///*****************************************Call Project Initiated Method***************************************///
				String hClassName = recordset.getField("Package") + "." + recordset.getField("Projects");
				String ProjInit = recordset.getField("Key_Function");
				Class<?> hClass = Class.forName(hClassName);
				Object test = hClass.newInstance();
				Method setNameMethod = test.getClass().getMethod(ProjInit, String.class);
				setNameMethod.invoke(test, "MethodInitiated");
				

			}
		} catch (NullPointerException e) {
			System.out.println("Please check the driversheet,No records found");
			Configuration.updatePropertyFile(Methodid,MethodName,"False");
			
		}

		catch (Exception e) {
			System.out.println(e);
			if (e.getMessage().contains("No records found")) {
				System.out.println("Please check the driversheet,No records found");
				Configuration.updatePropertyFile(Methodid,MethodName,"False");
			}
		}

		recordset.close();
		Driver.connection.close();
		driverClose();

	}

	public static String getData(String TestData) throws FilloException {
		String GetValue = null;
		try {
			if (sheetflag == true) {
				GetValue = recordset.getField(TestData);
				sheetflag = false;
			} else {

				GetValue = recordset1.getField(TestData);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return GetValue;
	}

	public static void refreshSheet1(String databinding,Recordset record2) throws FilloException {
		try {
			recordset1=record2;
			strQuery = Common_Property.SelectQuery("Sheet1", selectQuerydata, "updateKeywordSheet");
			recordset1 = connection.executeQuery(strQuery).where("DATABINDING='" + databinding + "'");
			recordset1.next();
			//System.out.println(recordset1.getField("DATABINDING"));
			
			
		}
		
		catch (Exception e) {
			System.out.println(e);
		}

	}

	public static Recordset testCasetoExecute() throws FilloException {
		try {
			
			connection = fillo.getConnection(Configuration.Datapath + WhichClient + ".xlsx");
			
			strQuery = Common_Property.SelectQuery("Sheet1", selectQuerydata, "ChooseKeywordSheet");
			recordset1 = connection.executeQuery(strQuery);
			if (recordset1.getCount() == 0) {
				System.out.println("Please check the sheet1 of the Project_sheet,None of the testcase have selected to execute");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return recordset1;
	}
	
	

	public static List<String> methodstoExecute(Recordset record1) throws FilloException {
		try {
			
			str = record1.getField("Keyword");
			getref = record1.getField("put_ag_no");
			KeywordList = Arrays.asList(str.split(","));
			
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return KeywordList;
	}
	

	public static void get_sysdate(String Sysdate, Recordset record) throws FilloException {
		try {
			fillo = new Fillo();
			connection = fillo.getConnection(Configuration.Datapath + WhichClient + ".xlsx");
			System.out.println(record.getField("DATABINDING"));
			String sysQuery = "Update Sheet1 Set Sys_date=" + "'" + Sysdate + "'" + " where DATABINDING =" + "'"
					+ record.getField("DATABINDING") + "'";
			connection.executeUpdate(sysQuery);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String add_days(String Sysdate,Recordset record) throws FilloException {
		String date1 = null;
		try {
			String days = record.getField("No.of.days");
			int add = Integer.parseInt(days);
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c1 = Calendar.getInstance();
			c1.setTime(sdf1.parse(Sysdate));
			Date date = new Date();
			c1.add(Calendar.DAY_OF_MONTH, add);
			date = c1.getTime();
			date1 = sdf1.format(date);
			System.out.println(sdf1.format(date));

		} catch (Exception e) {
			System.out.println(e);
		}
		return date1;

	}

	public static List<String> Batchwordsheetvalue(String Batchname) throws FilloException {

		try {
			// batchhead =recordset1.getField("Batchname");
			// getref=recordset1.getField("put_ag_no");
			BatchList = Arrays.asList(Batchname.split(","));

		} catch (Exception e) {
			System.out.println(e);
		}
		return BatchList;
	}

	public static String Update() throws FilloException

	{

		String UpdateSetQuery = "", WhereCriteria = "", UpdateCommand = " ";

		int cntFieldstoUpdate = FieldstoUpdate.size(), CounterUpdateLoop = 1, cntWhereCondition = WhereCondition.size();

		for (@SuppressWarnings("rawtypes")
		Map.Entry SetMap : FieldstoUpdate.entrySet()) {

			UpdateSetQuery = UpdateSetQuery + SetMap.getKey() + "=" + SetMap.getValue();
			if (CounterUpdateLoop < cntFieldstoUpdate) {
				UpdateSetQuery = UpdateSetQuery + ",";
				CounterUpdateLoop++;
			}
		}
		// System.out.println(UpdateQuery);
		CounterUpdateLoop = 1;
		for (@SuppressWarnings("rawtypes")
		Map.Entry wheremap : WhereCondition.entrySet()) {
			WhereCriteria = WhereCriteria + wheremap.getKey() + "=" + wheremap.getValue();
			if (CounterUpdateLoop < cntWhereCondition) {
				WhereCriteria = WhereCriteria + " and ";
				CounterUpdateLoop++;
			}

		}
		// System.out.println(WhereCriteria);
		UpdateCommand = "Update" + " " + TableName + " " + "Set" + " " + UpdateSetQuery + " " + "Where" + " "
				+ WhereCriteria;
		System.out.println(UpdateCommand);
		connection.executeUpdate(UpdateCommand);
		FieldstoUpdate.clear();
		WhereCondition.clear();
		return UpdateCommand;

	}

	public static String insert() throws Exception {
		String InsertQuery = "", ValuestoInsert = " ", InsertCommand = " ";
        int cntFieldstoInsert = FieldstoInsert.size(), CounterInsertLoop = 1;

		for (@SuppressWarnings("rawtypes")
		Map.Entry InsertMap : FieldstoInsert.entrySet()) {

			InsertQuery = InsertQuery + InsertMap.getKey();
			ValuestoInsert = ValuestoInsert + InsertMap.getValue();

			if (CounterInsertLoop < cntFieldstoInsert) {
				InsertQuery = InsertQuery + ",";
				ValuestoInsert = ValuestoInsert + ",";
				CounterInsertLoop++;
			}
		}

		InsertCommand = "Insert into" + " " + TableName + " " + "(" + InsertQuery + ")" + " " + "Values" + " " + "("
				+ ValuestoInsert + ")";
		
		System.out.println(InsertCommand);
		connection.executeUpdate(InsertCommand);
		FieldstoInsert.clear();
		return InsertCommand;

	}

	public static String select() throws Exception {
		
		
		

		

		String SelectStrQuery = " ",  SelectCommand = " ", WhereCriteria = " ";
		int cntFieldstoSelect = FieldstoSelect.size(), CounterSelectLoop = 1, cntWhereCondition = WhereCondition.size();

		if (cntFieldstoSelect > 0) {

			for (Entry<String, String> SelectMap : FieldstoSelect.entrySet()) {

				SelectStrQuery = SelectStrQuery + SelectMap.getKey();

				if (CounterSelectLoop < cntFieldstoSelect) {
					SelectStrQuery = SelectStrQuery + ",";
					CounterSelectLoop++;
				}
			}
		}

		CounterSelectLoop = 1;

		for (Entry<String, String> wheremap : WhereCondition.entrySet()) {
			WhereCriteria = WhereCriteria + wheremap.getKey() + "=" + wheremap.getValue();
			if (CounterSelectLoop < cntWhereCondition) {
				WhereCriteria = WhereCriteria + " and ";
				CounterSelectLoop++;
			}

		}

		if (cntWhereCondition == 0) {
			SelectCommand = "Select" + " " + SelectStrQuery + " " + "from" + " " + TableName;
		} else {
			SelectCommand = "Select" + " " + SelectStrQuery + " " + "from" + " " + TableName + " " + "Where" + " "
					+ WhereCriteria;
		}
		connection.executeQuery(SelectCommand);
		FieldstoSelect.clear();
		WhereCondition.clear();
		return SelectCommand;
		
	}
	
	public static void driverClose(){
		if (Common_Property.driver == null) {
            System.out.println("Execution Completed");
        } else {
            Common_Property.driver.close();
            System.out.println("Execution Completed");
        }
		
	}

}
