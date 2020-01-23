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

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class Agreement_Mapping extends Driver

{
public static ArrayList<String> Updatesheet1 = new ArrayList<String>( );
	
public static void Mapping(String whichProject,String Varied,Recordset Record2) throws FilloException
{
		try
		{
		
		Fillo fillo=new Fillo();
		Driver.connection=fillo.getConnection(Configuration.Datapath+whichProject+".xlsx");
		String strquery=Common_Property.SelectQuery("Sheet2",selectQuerydata,"Mapping");
		Recordset recordset=Driver.connection.executeQuery(strquery);
		
		 while(recordset.next())
		    {
		  
		    String update=recordset.getField("put_ag_no");
		    String str = Record2.getField("put_ag_no");
		    String Misc=Record2.getField("Misc");
		    if(update.equalsIgnoreCase(str))
		    {
			String Str_refno=recordset.getField("put_ag_no");
			Str_refno="'"+Str_refno+"'";
			String Str_Agr=recordset.getField("Agreement_Number");
			Str_Agr="'"+Str_Agr+"'";
			String Str_Misc=recordset.getField("Misc");
			Varied="'"+Str_Misc+"'";
			TableName = "Sheet1";
//			FieldNames.add(0, "put_ag_no");
//			FieldNames.add(1, "Agreement_Number");
//			FieldNames.add(2, "Misc");
//			FieldValues.add(0,Str_refno);
//			FieldValues.add(1,Str_Agr );
//			FieldValues.add(2, Varied);
			
			FieldstoUpdate.put("Agreement_Number",Str_Agr);
			FieldstoUpdate.put("Misc", Varied);
					
			WhereCondition.put("put_ag_no",Str_refno);
			
			//Common_Property.StrUpdateQuery("Sheet1", FieldNames, FieldValues);
			//String strupdate=Common_Property.StrUpdateQuery("Sheet1",FieldNames,FieldValues);
			String strupdate=Update();
			connection.executeUpdate(strupdate);
			str=update;
		    }
		    }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    }
		
	
}
