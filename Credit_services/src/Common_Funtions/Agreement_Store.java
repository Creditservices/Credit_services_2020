/* *********************************************************************************************************************************
 * Project:Core Framework
 * Program Name : Agreement_StoreDate
 * Program Description : Part of Framework which fetch agreement number and related fields from the test data sheet.
 * Written by : Sheik Umar Ali L
 * Written Date: 26/02/2019
 * Last Update on : 27/02/2019
 * Last Updated block : 2702/2019- At line 40 -- OU implementation 
 * 
 ***************************************************************************************************************************************/
package Common_Funtions;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Agreement_Store extends Driver {

	public String AgreementNo,Misc;
	public static int flag, i = 1;
	public static String Str_Put_ag_no_databinding, StrUpdateQuery, StrInsertQuery, LocalAgrInit = "", record1;
	public static ArrayList<String> Insertarr = new ArrayList<String>();
	public static ArrayList<String> Updatearr = new ArrayList<String>();
	public static ArrayList<String> UpdateFields = new ArrayList<String>();
	// public static Connection connection;
	public static Recordset SheetRecordSet;

	@SuppressWarnings("unused")
	public static void Store_Data(String StrWhichProject, String AgreementNo, String Varied, Recordset Record2)
			throws Exception {
		try {
//			if(StrWhichProject.equalsIgnoreCase("Startline")||StrWhichProject.equalsIgnoreCase("Ikano")){
//			Record2.next();
//			}
			Record2.next();
			System.out.println(Record2.getField("DATABINDING"));
			Str_Put_ag_no_databinding = Record2.getField("put_ag_no");
			String StrAgrQuery;
			TableName="Sheet2";
            FieldstoSelect.put("*", "");
			
			//StrAgrQuery = Common_Property.SelectQuery("Sheet2",selectQuerydata,"Store_Data");
			SheetRecordSet = connection.executeQuery(select());
			System.out.println(SheetRecordSet.getCount());

			while (SheetRecordSet.next()) {

				if (SheetRecordSet.getField("put_ag_no").equalsIgnoreCase(Str_Put_ag_no_databinding)) {
					flag = 1;
					break;
				}
			}

			if (flag == 1) {

				LocalAgrInit = "'" + Str_Put_ag_no_databinding + "'";
				FieldstoUpdate.put("Agreement_Number","'"+AgreementNo+"'");
				FieldstoUpdate.put("Misc", "'"+Varied+"'");
				WhereCondition.put("put_ag_no",LocalAgrInit);
				TableName = "Sheet2";
				//StrUpdateQuery = Common_Property.StrUpdateQuery("Sheet2", UpdateFields, Updatearr);
				StrUpdateQuery=Driver.Update(); 
				FieldstoUpdate.clear();
				WhereCondition.clear();
				
				TableName = "Sheet1";
				
				FieldstoUpdate.put("Agreement_Number","'"+AgreementNo+"'");
				FieldstoUpdate.put("Misc", "'"+Varied+"'");
				WhereCondition.put("put_ag_no",LocalAgrInit);
				Driver.Update(); 
				flag = 0;

			} else {
				LocalAgrInit = "'" + Str_Put_ag_no_databinding + "'";
				
				/*Insertarr.add(0, LocalAgrInit);
				Insertarr.add(1, AgreementNo);
				Insertarr.add(2, Varied);
				-----------------------
				UpdateFields.add(0,"put_ag_no");
				UpdateFields.add(1,"Agreement_Number");
				UpdateFields.add(2, "Misc");*/
				TableName = "Sheet2";
				FieldstoInsert.put("put_ag_no", LocalAgrInit);
				FieldstoInsert.put("Agreement_Number", "'"+AgreementNo+"'");
				FieldstoInsert.put("Misc", "'"+Varied+"'");
				insert();
                TableName = "Sheet1";
				
				FieldstoUpdate.put("Agreement_Number","'"+AgreementNo+"'");
				FieldstoUpdate.put("Misc", "'"+Varied+"'");
				WhereCondition.put("put_ag_no",LocalAgrInit);
				Driver.Update(); 
				
				//StrInsertQuery = Common_Property.InsertQuery("Sheet2", UpdateFields,Insertarr);
				/*if (StringUtils.isBlank(Varied)) {
					i = 0;
					StrInsertQuery = Common_Property.InsertQuery("Sheet2", Insertarr);
					i = 1;
				} else {
					StrInsertQuery = Common_Property.InsertQuery("Sheet2", Insertarr);
				}*/
				//connection.executeUpdate(insert());

			}

			
			/*if (StringUtils.isBlank(Varied)) {
				Agreement_Mapping.Mapping(StrWhichProject, null, Record2);
			} else {
				Agreement_Mapping.Mapping(StrWhichProject, Varied, Record2);
			}*/
		}

		catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
