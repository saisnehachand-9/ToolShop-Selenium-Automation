package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityFile {

	
	FileInputStream fi;
	 FileOutputStream fo;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	String ExcelPath;
	
	public ExcelUtilityFile(String path)
	{
		ExcelPath=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fi=new FileInputStream(ExcelPath);
		workbook=new XSSFWorkbook(fi);
		this.sheet=workbook.getSheet(sheetName);
		//getLastRowNum(): gives the last row index and 1st row starts from 0
		 int rowcount=sheet.getLastRowNum();
		 workbook.close();
			fi.close();
			 
		 
		 return rowcount;
	}
	
	public int getCellCount(String sheetName,int rowwNo) throws IOException
	{
		
		fi=new FileInputStream(ExcelPath);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		//getLastCellNum() : gives the lastCell index+1 and 1st col strts from 0
		int cellcount=sheet.getRow(rowwNo).getLastCellNum();  
		
		workbook.close();
		fi.close();
		 
		 return cellcount;
		
	}
	
	public String getCellData(String sheetName,int rowNo,int cellNo) throws IOException
	{
		
		fi=new FileInputStream(ExcelPath);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rowNo);
		cell=row.getCell(cellNo);
		
		String data;
		DataFormatter formatter=new DataFormatter();
		
		try
		{
			data=formatter.formatCellValue(cell);
			
		}
		catch(Exception e )
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
	}
	
}
