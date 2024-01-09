package objectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
		public class CreateNewContactPage 
		{
			
		//initialize
		
		@FindBy(name="lastname")
		private WebElement lastNmeEdt;
		
		@FindBy(name="leadsource")
		private WebElement leadsourceDD;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		// create constructor to initialize
		
		public CreateNewContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		

		public WebElement getLastNme() {
			return lastNmeEdt;
		}

		public WebElement getLeadsourceDD(String lEADSOURCE) {
			return leadsourceDD;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		/**
		 * this method clicks on cntct link and enters last name amd saves
		 * @param driver
		 */
		//business library 
		
	
		public void getLastEdt(String LASTNAME)
		{
			lastNmeEdt.sendKeys(LASTNAME);
			saveBtn.click();
		}
		
		public void leadSource(String WebElement)
		{
			leadsourceDD.click();
		}
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

