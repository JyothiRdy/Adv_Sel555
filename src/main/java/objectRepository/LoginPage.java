package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

	//Rule2: identification/declaration
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	

	//Rule3:create a constructor to Initialize
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Rule4:Utilization
	
	public WebElement getUsernameEdt() 
	{
		return usernameEdt;
	}


	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}


	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	//Business library -Generic Method -operate on elements in current 	POMclass only
	
	public void LoginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
