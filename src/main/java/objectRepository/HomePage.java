package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility
{
	//rule2 initailization
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//rule3 create a constructor
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//rule4 utilization
	
	public WebElement getContactLnk()
	{
		return contactLnk;
	}

	public WebElement getProductsLnk()
	{
		return productsLnk;
	}

	public WebElement getAdministratorImg() 
	{
		return administratorImg;
	}

	public WebElement getSignoutLnk()
	{
		return signoutLnk;
	}
	
	//business library
	/**
	 * this method will click on contact and logout of app
	 */
	
	public void clickOnContactsLink()
	{
		contactLnk.click();
	}
	public void logoutOfApp(WebDriver driver) 
	{
		mouseHoverAction (driver,administratorImg);
		signoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
