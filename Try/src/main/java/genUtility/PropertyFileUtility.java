package genUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic methodsrelated to property file
 * @author vidya
 *
 */
public class PropertyFileUtility 
{ 
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/CommonData/hrmCommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	
		
		
		
	}

}
