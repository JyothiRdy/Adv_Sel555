package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//declaration
	
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	//initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utlization
	public WebElement getContactHeader() 
	{
		return contactHeader;
	}
	
	//business library
	public String  captureHeaderText()
	{
		return contactHeader.getText();
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
