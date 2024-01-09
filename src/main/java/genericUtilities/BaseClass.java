package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * this class consists of all basic configuration annotations of testNG
 * @author LENOVO.T470s
 *
 */
public class BaseClass {
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public JavaUtility jUtil= new JavaUtility();
	public SeleniumUtility sUtil= new SeleniumUtility();
	public  WebDriver driver;
	
	public static WebDriver sdriver;//For listeners
	
	
	@BeforeSuite(groups={"smokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("=============database connection successful=============");
	}
	@BeforeClass (alwaysRun = true)
	public void bcConfig() throws IOException
	{
		String URL = pUtil.ReadDataFrompPropertyFile("url");
		driver= new ChromeDriver();
		sdriver=driver;// for listeners
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		System.out.println("BROWSER LAUNCHED");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws Throwable
	{
		String USERNAME = pUtil.ReadDataFrompPropertyFile("username");
		String PASSWORD = pUtil.ReadDataFrompPropertyFile("password");
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		System.out.println("LOGIN SUCCESSFUL");
		
		
		
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		HomePage hp= new HomePage(driver);

	hp.logoutOfApp(driver);
	System.out.println("==========LOGPUT SUCCESSFUL=========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("===========DATABASE connection closed==============");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
