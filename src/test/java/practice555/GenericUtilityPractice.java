package practice555;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class GenericUtilityPractice 
{
public static void main(String[] args) throws IOException 
{
	PropertyFileUtility pUtil= new PropertyFileUtility();
	
	String value = pUtil.ReadDataFrompPropertyFile("url");
	String value1 = pUtil.ReadDataFrompPropertyFile("username");
	System.out.println(value);
	System.out.println(value1);
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	
	String Data = eUtil.ReadDataFromExcel("Contacts", 1, 2);
	System.out.println(Data);
	
	//JavaUtility jUtil= new JavaUtility();
	//System.out.println(jUtil.getSystemDate());
	
	SeleniumUtility sUtil= new SeleniumUtility();
	//sUtil.maximizeWindow("ChromeDriver");
	sUtil.addImplicitlyWait(null);
	
	
	
}
	
	
	
	
	
	
	
}
