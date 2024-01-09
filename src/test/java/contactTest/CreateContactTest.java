package contactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
	public class CreateContactTest extends BaseClass
	{
		

		@Test(groups="SmokeSuite")
				
			public void  CreateContactWithMandatoryFieldsC() throws IOException
				{
			/* read TEST DATA from EXCEL file*/
					String LASTNAME = eUtil.ReadDataFromExcel("Contacts", 1, 2);
					
		
				//step4: click on contacts link

				HomePage hp=new HomePage(driver);
						hp.clickOnContactsLink();
						
				
				//step5: click on create contact lookup image 
				ContactPage cp= new ContactPage(driver);
						cp.contactLookUpImg();
				
				//step6:create new contact
				CreateNewContactPage cncp=new CreateNewContactPage(driver);
				cncp.getLastEdt(LASTNAME);
				
				//Assert.fail();
				//step8: validate
				ContactInfoPage cip= new ContactInfoPage(driver);
						String contactHeader = cip.captureHeaderText();
			  	
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);

				
				}	
		}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

