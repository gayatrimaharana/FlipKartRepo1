package org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods for csv file and property file
 * @author User
 *
 */

public final class FileUtility {
	
	private Properties properties;
	/**
	 * This method is used to initialize the property file
	 * @param filePath
	 */
	public void initializePropertyFile(String filePath)
	{
		FileInputStream fis=null;
		try {
			 fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to get the data from property file
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key)
	{
		return properties.getProperty(key).trim();
	}
	

}
