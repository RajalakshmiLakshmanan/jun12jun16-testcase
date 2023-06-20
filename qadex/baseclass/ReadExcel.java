package qadex.baseclass;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static Object[][] readData(String sheetName) throws IOException{
		
		XSSFWorkbook book = new XSSFWorkbook("./Data/"+sheetName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		int rowNum = sheet.getLastRowNum();
		int cellNum = row.getLastCellNum();
		//String[][] data = new String[rowNum][cellNum];
		Object[][] data = new Object[rowNum][cellNum];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				XSSFCell valObj = sheet.getRow(i).getCell(j);
				String alldata = null;
				if(valObj != null) {
					alldata = valObj.getStringCellValue();
				}
				//sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = alldata;
			
				
			}
		}
		book.close();
		return data;
	}
	

}
