package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Setup.Base;


public class Utilities {
	
	public static void captureScreenshot(int testId, WebDriver driver) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");  
	    Date date = new Date();  
	    String b= formatter.format(date);
    
    	TakesScreenshot take=(TakesScreenshot)driver;
    	
    	File source= take.getScreenshotAs(OutputType.FILE);
    	
    	File dest= new File("F:\\Prasad\\Screenshot\\Screenshot "+testId+" "+b+".jpeg");
    	
    	FileHandler.copy(source, dest);

	}
	
	public static String getDataFromExcelSheet(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		
        String path= "C:\\Users\\Dell\\Desktop\\Priority and Severity.xlsx";
        String value;
		FileInputStream file=new FileInputStream(path);
		try 
		{
	    value= WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(Exception e)
		{
		double v= WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		value= String.valueOf(v);
		}
	    return value;

//		Workbook book=WorkbookFactory.create(file);
//		
//		Sheet sheet = book.getSheet("Sheet2");
//	    
//		for(int i=0;i<=5;i++)
//		{
//			Row row= sheet.getRow(i);
//			for(int j=0;j<=5;j++)
//			{
//			Cell cell= row.getCell(j);
//		    String value= cell.getStringCellValue();
//		    System.out.print(value+", ");
//			}
//			System.out.println();
//		}
	}

}
