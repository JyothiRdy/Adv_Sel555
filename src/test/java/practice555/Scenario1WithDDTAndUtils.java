package practice555;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndUtils
{

			public static void main(String[] args) throws Throwable 
			{
				PropertyFileUtility pUtil =new PropertyFileUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				SeleniumUtility sUtil= new SeleniumUtility();
				JavaUtility jUtil= new JavaUtility();
				
				
				
		/* read COMMON DATA from PROPERTY file*/	
				String URL = pUtil.ReadDataFrompPropertyFile("url");
				String USERNAME = pUtil.ReadDataFrompPropertyFile("username");
				String PASSWORD = pUtil.ReadDataFrompPropertyFile("password");
				
		/* read TEST DATA from EXCEL file*/
				String LASTNAME = eUtil.ReadDataFromExcel("Contacts", 1, 2);
				
				
			//step1: launch the base browser 
			
			WebDriver driver= new ChromeDriver();
			sUtil.maximizeWindow(driver);
			sUtil.addImplicitlyWait(driver);
			
			
			//step2: load the application 
			
				driver.get(URL);
			
			//step3:login to application
				LoginPage lp= new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
//				lp.getUsernameEdt().sendKeys(USERNAME);
//				lp.getPasswordEdt().sendKeys(PASSWORD);
//				lp.getLoginBtn().click();
//				
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
//			
			
			//step4: click on contacts link

			driver.findElement(By.linkText("Contacts")).click();
			
			//step5: click on create contact lookup image 
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			//step6:create new contact
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
			
			//step7: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//step8: validate
			String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  		
		  	if(contactHeader.contains (LASTNAME))
		  		{
		  			System.out.println(contactHeader);
		  			System.out.println("pass");
		  		}
		  	else
		  		{
		  			System.out.println("fail");
		  		}
			

			//step9:  logout of app
		  	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  	
		  	sUtil.mouseHoverAction(driver, element);
		  	
		  	Thread.sleep(1000);
		  	driver.findElement(By.linkText("Sign Out")).click();
		  	
		  	//Step 10: close the browser
		  	driver.quit();
			
			}	
	}


