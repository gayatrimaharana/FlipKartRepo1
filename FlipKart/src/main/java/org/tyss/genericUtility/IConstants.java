package org.tyss.genericUtility;
/**
 * This interface contains all the constant variables for the application
 * @author User
 *
 */
public interface IConstants {
	//these VTIGERPROPERTYFILEPATH paths are static and final so written in caps 
	String ABSOLUTPATHPROJECT=System.getProperty("user.dir");
	public String FLIPKARTPROPERTYFILEPATH=ABSOLUTPATHPROJECT+"/src/test/resources/CommonData.properties";
	public String FLIPKARTEXCELFILEPATH=ABSOLUTPATHPROJECT+"/src/test/resources/FlipKartTestData.xlsx";
	

}
