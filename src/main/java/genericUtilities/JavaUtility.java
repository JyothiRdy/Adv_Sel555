package genericUtilities;

import java.util.Date;

/**
 * this class consitis of reusable methods related to java
 * @author LENOVO.T470s
 *
 */
public class JavaUtility {

	public String[] getSystemDate()
	{
	Date d =new Date();
	 String[] dte = d.toString().split(" ");
	 return dte;
	}	
	
	
	
	
	
	
	
	
	
}

