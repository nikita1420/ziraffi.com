package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReadExcel 
{
	public static FileInputStream fis;
	public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;

WebDriver driver;




public ReadExcel(WebDriver driver1) 
{
	driver=driver1;
	PageFactory.initElements(driver1, this);
	
	
}

public   int getRowCount(int sheetindex) throws IOException
{

File src=new File("C:\\Nikita\\workspace\\E-Commerce\\Reports\\test data.xlsx");
fis = new FileInputStream(src);
	wb= new XSSFWorkbook(fis);
	int rowcount=wb.getSheetAt(sheetindex).getLastRowNum();
	rowcount=rowcount+1;
	wb.close();
	fis.close();
	return rowcount;
	 
}

	
	



public   int getCellCount(int sheetindex, int rownum) throws IOException
{

File src=new File("C:\\Nikita\\workspace\\E-Commerce\\Reports\\test data.xlsx");
fis = new FileInputStream(src);
	wb= new XSSFWorkbook(fis);

	int cellcount=wb.getSheetAt(sheetindex).getRow(rownum).getLastCellNum();
		return cellcount;


}
public String getData(int sheetIndex,int row,int column) throws IOException
{
	File src=new File("C:\\Nikita\\workspace\\E-Commerce\\Reports\\test data.xlsx");

		fis = new FileInputStream(src);
	wb= new XSSFWorkbook(fis);
	ws=wb.getSheetAt(sheetIndex);

	String data =ws.getRow(row).getCell(column).getStringCellValue();
	return data;
	}
public String getData(String Sheetname,int row,int column) throws IOException
{
	File src=new File("C:\\Nikita\\workspace\\E-Commerce\\Reports\\test data.xlsx");
	fis = new FileInputStream(src);
		wb= new XSSFWorkbook(fis);
	String data =wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
	return data;
	}
}



