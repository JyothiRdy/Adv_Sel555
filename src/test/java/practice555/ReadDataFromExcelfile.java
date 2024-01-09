package practice555;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelfile
{

	public static void main(String[] args) throws Throwable
	
	
	{
		
		//Step1: open the document in java readable format
			
			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData555.xlsx");
		
		//step2: create workbook
			
			Workbook wb = WorkbookFactory.create(fis);
		
		 //step3: navigate to required sheet
			
			Sheet sh = wb.getSheet("contacts");		
		
		//step4: navigate to required row
			
			Row rw = sh.getRow(1);
		
		//step5: navigate to required  cell
			
			Cell cl = rw.getCell(2);
		
		
		//step6: capture the data inside cell
		
			String value = cl.getStringCellValue();
			System.out.println(value);
		
		//step7: close the workbook
		
			wb.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
