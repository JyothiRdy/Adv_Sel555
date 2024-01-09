package practice555;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Readfrompropertyfile 
{

	public static void main(String[] args) throws Throwable 
	{
		
		//Step1: open the document into java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step2: create an object of property file from java util package
		
		Properties p= new Properties();
		
		
		//Step3: load the fis file into property class
		p.load(fis);
		
		// Step4: provide the key and read the value
		String value = p.getProperty("username");
		String pw = p.getProperty("password");
		String url = p.getProperty("url");
		System.out.println(value);
		System.out.println(pw);
		System.out.println(url);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
