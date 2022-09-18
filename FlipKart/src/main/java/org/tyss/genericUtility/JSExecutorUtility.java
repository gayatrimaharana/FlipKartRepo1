package org.tyss.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains all the js reusable/actions
 * @param driver
 */
public class JSExecutorUtility {
	private JavascriptExecutor js;
	
	
	public void initializeJSExecutor(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * Navigate app by js executor
	 * @param url
	 */
	public void navigateApp(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	
	public void enterData(WebElement element, String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", null);
	}
	

}
