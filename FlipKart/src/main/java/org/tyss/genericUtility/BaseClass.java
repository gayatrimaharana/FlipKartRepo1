package org.tyss.genericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends InstanceClass {

	 
	@BeforeClass(alwaysRun = true)
	public void classSetup() {
		
		webDriverUtility=new WebDriverUtility();
		excelUtility=new ExcelUtility();
		fileUtility=new FileUtility();
		javaUtility=new JavaUtility();

		fileUtility.initializePropertyFile(IConstants.FLIPKARTPROPERTYFILEPATH);
		excelUtility.initializeExcelFile(IConstants.FLIPKARTEXCELFILEPATH);
		browsers = fileUtility.getDataFromPropertyFile("browser");
		url = fileUtility.getDataFromPropertyFile("URL");
		WebDriverManager.chromedriver().setup();
		webDriverUtility.setUpDriver(browsers);
	//	webDriverUtility.maximizeBrowser();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		webDriverUtility.openApplication(url);


	}
	@BeforeMethod(alwaysRun  =true)
	public void methodSetup()
	{

	}

	@AfterMethod(alwaysRun  =true)
	public void methodTearDown()
	{
		//logout action

	}

	@AfterClass(alwaysRun = true)
	public void classTearDown()
	{
		excelUtility.closeWorkbook();
		webDriverUtility.closeBrowser();
	}

}
