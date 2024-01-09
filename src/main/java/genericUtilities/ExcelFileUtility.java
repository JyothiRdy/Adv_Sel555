package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists ofreusable methods related to excel file
 * @author LENOVO.T470s
 *
 */
public class ExcelFileUtility {

/**
 * 
 * @param sheetName
 * @param rwNo
 * @param clNo
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String ReadDataFromExcel(String sheetName,int rwNo,int clNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData555.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		   String value = wb.getSheet(sheetName).getRow(rwNo).getCell(clNo).getStringCellValue();
		return value;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
