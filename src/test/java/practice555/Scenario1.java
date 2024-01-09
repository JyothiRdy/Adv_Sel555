package practice555;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1
{
	public static void main(String[] args) throws Throwable {
		
	
//step1: launch the base browser 
	
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//step2: load the application 
	
	driver.get("http://localhost:8888");
	
	//step3:login to application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	
	//step4: click on contacts link

	driver.findElement(By.linkText("Contacts")).click();
	
	//step5: click on create contact lookup image 
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	//step6:create new contact
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("leo");
	
	//step7: save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//step8: validate
	String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  		
  	if(contactHeader.contains ("leo"))
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
