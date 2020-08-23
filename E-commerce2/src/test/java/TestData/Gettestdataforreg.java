  package TestData;

import java.util.ArrayList;



import Utilities.ReadExcel2;

public class Gettestdataforreg
{
	 	static ReadExcel2 excel;

	public static  ArrayList<Object[]> getdatafromExcel()

	{
		ArrayList<Object[]> mydata= new ArrayList<Object[]>();
		try {
		 excel=new ReadExcel2("C:\\Nikita\\workspace\\E-Commerce\\src\\test\\java\\TestData\\test data.xlsx");
		 } 
		catch(Exception e)
		{
			
		}
		
		for (
				int rownum  = 2; rownum < excel.getRowCount("testdata2"); rownum++) 
		{ 
			String user =excel.getCellData("testdata2", "email",rownum );
			String pass =excel.getCellData("testdata2", "password",rownum );
			String repass =excel.getCellData("testdata2", "repassword",rownum );
			String fname =excel.getCellData("testdata2", "firstname",rownum );
			String lname =excel.getCellData("testdata2", "lastname",rownum );
			String state =excel.getCellData("testdata2", "state",rownum );
			String zip =excel.getCellData("testdata2", "zipcode",rownum );
			String type =excel.getCellData("testdata2", "type",rownum );
		
		
			mydata.add(new Object[]	{user,pass,repass,fname,lname,state,zip,type});
			
		}
		
		return mydata;


	}
}
