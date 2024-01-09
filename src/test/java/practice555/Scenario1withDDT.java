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

public class Scenario1withDDT 
{

			public static void main(String[] args) throws Throwable 
			{
		/* read COMMON DATA from PROPERTY file*/	
				
				FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties p= new Properties();
				p.load(fisp);
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
							
				
		/* read TEST DATA from EXCEL file*/
				
				FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData555.xlsx");
				Workbook wb = WorkbookFactory.create(fise);
				String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
				
				
			//step1: launch the base browser 
			
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//step2: load the application 
			
				driver.get(URL);
			
			//step3:login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			
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
		  	
		  	Actions act = new Actions (driver);
		  	act.moveToElement(element).perform();
		  	
		  	Thread.sleep(1000);
		  	driver.findElement(By.linkText("Sign Out")).click();
		  	
		  	//Step 10: close the browser
		  	driver.quit();
			
			}	
	}


