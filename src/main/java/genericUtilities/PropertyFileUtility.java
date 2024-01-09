package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of reusable methods related to property file.
 * @author LENOVO.T470s
 * (Jo this is called class description. mandatory it should have class description with author name)
 *
 */
public class PropertyFileUtility
{
/**
 * this method will reaad the data from property file
 * @param key
 * @return
 * @throws IOException
 */
	public String ReadDataFrompPropertyFile(String key) throws IOException 
	{
	FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	
	
	
	
	
}
