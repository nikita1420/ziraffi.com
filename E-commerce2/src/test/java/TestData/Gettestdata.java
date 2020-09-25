package TestData;

import java.util.ArrayList;



import Utilities.ReadExcel2;

public class Gettestdata
{
	 	static ReadExcel2 excel;
	public static  ArrayList<Object[]> getdatafromExcel()

	{
		ArrayList<Object[]> mydata= new ArrayList<Object[]>();
		try {
		 excel=new ReadExcel2("C:\\Users\\mayan\\git\\ziraffi.com\\E-commerce2\\src\\test\\java\\TestData\\test data.xlsx");
		 } 
		catch(Exception e)
		{
			
		}
		
		for (
				int rownum  = 2; rownum < excel.getRowCount("testdata1"); rownum++) 
		{ 
			String user =excel.getCellData("testdata1", "User Name",rownum );
		String pass=excel.getCellData("testdata1", "Password", rownum);
		String type=excel.getCellData("testdata1", "Type", rownum);
		
			mydata.add(new Object[]	{user,pass,type});
			
		}
		
		return mydata;


	}
	

}
