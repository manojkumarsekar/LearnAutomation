package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider {
	
	XSSFWorkbook wb;

	public Exceldataprovider() 
	{
		
	File src=new File("./testdata/data.xlsx");

	try {
		FileInputStream fis = new FileInputStream(src);

		wb=new XSSFWorkbook(fis);
	} catch (Exception e) {
	
		e.printStackTrace();
	}

	}
	public String getdata(String sheetname, int row, int column)
	{
	String data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	return data;
	}

	public String getdata(int sheetIndex, int row, int column)
	{
	String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	return data;
	}


}
