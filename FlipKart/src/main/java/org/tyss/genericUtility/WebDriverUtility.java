package org.tyss.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility extends InstanceClass {
	
	private Actions act;
	public WebDriver setUpDriver(String browser)
	{
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("The browser is not working");
			break;
		}
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to wait the page by using implicit wait
	 * @param longTimeout
	 */
	public void implicitWait(Long longTimeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	public void explicityWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public void openApplication(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to initialize the action class
	 */
	public void initializeActions()
	{
	 act = new Actions(driver);
	}
	/**
	 * This method is used to handle mouse hover on element
	 * @param element
	 */
	public void mouseHoverOnElement(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used to handle <select> tag dropdown by using visible text
	 * @param dropDownElement
	 * @param visibleText
	 */
	public void handleSelectDropDown(WebElement dropDownElement,String visibleText)
	{
		Select select = new Select(dropDownElement);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This method is used to handle <select> tag dropdown by using value attribute
	 * of the <option> tag
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropDown(String value,WebElement dropDownElement)
	{
		Select select = new Select(dropDownElement);
		select.selectByValue(value);
	}
	/**
	 * This method is used to handle <select> tag dropdown by using index attribute
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropDown(WebElement dropDownElement,int indexNumber)
	{
		Select select = new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}
	/**
	 * This method is used to right click action on current mouse location
	 */
	public void rightClickAction()
	{
		act.contextClick().perform();
	}
	/**
	 * This method is used to right click on particular element
	 * @param element
	 */
	public void rightClickAction(WebElement element)
	{
		act.contextClick(element).perform();
	}
	//method overloading
	/**
	 * This method is used to switch frame based on webelement index
	 * @param index
	 */
	public void switchFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch frame based on webelement address
	 * @param element
	 */
	public void switchFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch frame based on name or id attribute
	 * @param nameOrId
	 */
	public void switchFrame(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method id used to switch back from frame to parent frame 
	 */
	public void switchFrame()
	{
		driver.switchTo().parentFrame();
	}
	
	public void takeScreenshotPage(Object currentClass,JavaUtility javaUtility)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./errorshots/"+getClass().getClass().getSimpleName()+javaUtility.getCurrentDate("dd_MM__yyyy_HH_mm_sss")+".png"); 

		try {
			FileUtils.copyFile(src,dst);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to get particular Element ScreeShot
	 * @param Element
	 * @param currentClass
	 * @param javaUtility
	 */
	public void takeScreenshotElement(WebElement Element,Object currentClass,JavaUtility javaUtility)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./elementScreenShot/"+getClass().getClass().getSimpleName()+javaUtility.getCurrentDate("dd_MM__yyyy_HH_mm_sss")+".png"); 

		try {
			FileUtils.copyFile(src,dst);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * This method is used to close the particular browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	/**
	 * This method is used to close the particular tab
	 */
	public void closeTab()
	{
		driver.close();
	}

}
