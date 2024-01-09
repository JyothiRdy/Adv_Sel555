package contactTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContactWithLeadSourceTest extends BaseClass{
@Test(groups="BatchExecutionSuite")

	public void  CreateContactWithMandatoryFieldsL() throws IOException, InterruptedException
	{
/* read TEST DATA from EXCEL file*/
		String LASTNAME = eUtil.ReadDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.ReadDataFromExcel("Contacts", 4, 3);

	//step4: click on contacts link

	HomePage hp=new HomePage(driver);
			hp.clickOnContactsLink();
			
	
	//step5: click on create contact lookup image 
	ContactPage cp= new ContactPage(driver);
			cp.contactLookUpImg();
	
	//step6:create new contact
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.getLastEdt(LASTNAME);
	cncp.getLeadsourceDD(LEADSOURCE);
	System.out.println(LEADSOURCE);
	
	Thread.sleep(2000);
	
	//step8: validate
	ContactInfoPage cip= new ContactInfoPage(driver);
			String contactHeader = cip.captureHeaderText();
  	
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	System.out.println(contactHeader);

	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
