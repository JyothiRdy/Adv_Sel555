package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consists of reuable methods related to selenium tool
 * @author LENOVO.T470s
 *
 */
public class SeleniumUtility {

	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver )
	{
		driver.manage().window().minimize();
	}
	
	public void fullScreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * this method will wait 10sec for all the webelements to load
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will wait utill element is visible
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * this method will wait until element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitTillElementIsClickable( WebDriver driver, WebElement element) 
	{
		WebDriverWait wait= new WebDriverWait( driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * this method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel= new Select (element);
				sel.selectByIndex(index);
	}
	
	
	/** 
	 * this method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown( WebElement element, String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	
	/**
	 * this method will handle dropdown by text 
	 * this is method overloading - same method name,arguments and order of arguments are different.
	 * runtime polymorphism
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * this method will perform mouse hovering action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/** 
	 * this method will perform mousehover on a webelement on a web element and double click
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver,WebElement element  )
	{
		Actions act= new Actions(driver);
				act.doubleClick(element).perform();
	}
	
	
	/**this method will perform context click action on a web element
	 * 
	 * @param driver
	 */
	public void contextClickAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**this method will perform darg and drop on a web element
	 * 
	 * @param driver
	 * @param srcelement
	 * @param Trgelement
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcele, WebElement Trgele)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcele, Trgele).perform();
	}
	
	/**
	 * this method will perform scrolldown action by 500 units
	 * @param driver
	 */
	public void scrollDownActions(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	
	/**
	 * this method will scroll up for 500 units vertically
	 * @param driver
	 */
	public void scrollUpActions(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}
	
	/**
	 * this method 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method gives alert popup to cancel
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will capture the text in alert popup and return it to caller
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	/**
	 * this method will handle frame with frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * this method will handle frame with name or id
	 * @param driver
	 * @param frameNameOrId
	 */
	public void handleFrame(WebDriver driver,String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * this method will handle frame on frame element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * this wmethos will take screenshot and save in a folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);//temparary location
		File dst=new File(".\\Screenshots\\"+screenshotName+".png");//
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();
		//attachong this ss to extent reports
	}
	
	/**
	 * this method will switch the control to required window based on title
	 * @param driver
	 * @param expPartialTitle
	 */
	public void handleWindows(WebDriver driver, String expPartialTitle)
	{
		//capture all window ids
		Set<String> allWinIds = driver.getWindowHandles();
	
		//navigate through each window
		for(String WinId:allWinIds)
		{
		
			//switch to each window id and capture the title
			String actTitle = driver.switchTo().window(WinId).getTitle();
		
			//compare the window titles
			if(actTitle.contains(expPartialTitle))
			{
				break;
			}
		
		
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


