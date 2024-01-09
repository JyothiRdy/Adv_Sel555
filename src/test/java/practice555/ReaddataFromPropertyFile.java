package practice555;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReaddataFromPropertyFile
{

	public static void main(String[] args) throws Throwable 
	{
		//step1:open the document in java readable format
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2:create object of properties class from java.util pacakage
		
		Properties p= new Properties();
		
		//step3:load the file input stream input properties class
		p.load(fis);
		
		
		//step4 :provide the key and read the value
		String value = p.getProperty("username");
		System.out.println(value);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
