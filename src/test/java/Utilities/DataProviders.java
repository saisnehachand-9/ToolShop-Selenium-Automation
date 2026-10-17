package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\test-data\\loginDataForToolProject.xlsx"; // taking xl file from testData
		ExcelUtilityFile excel=new ExcelUtilityFile(path);
		
		int totalRows=excel.getRowCount("Sheet1");
				int totalCells= excel.getCellCount("Sheet1", 1);
				System.out.println("Rows = "+totalRows);
				System.out.println("Cells = "+totalCells);
		String logindata[][]=new String[totalRows][totalCells];
		
		for(int i=1;i<=totalRows;i++) // 3
		{
			for(int j=0;j<totalCells;j++)
			{
				logindata[i-1][j]=excel.getCellData("Sheet1",i, j);
				//System.out.println(logindata[i-1][j]);
			}
		}
		return logindata;
		
		
	}

}
