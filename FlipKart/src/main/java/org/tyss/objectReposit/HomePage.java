package org.tyss.objectReposit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.IConstants;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath="//button[@class='_2KpZ6l _2doB4z']") private WebElement crossBtn;
	@FindBy (name = "q") private WebElement searchTxtbox;
	@FindBy (xpath = "//div[@data-id=\"ROHG9BFDGBWGXVX5\"]/div//a[contains(@title,'pampa BLUEDART')]") private WebElement firstProduct;
	@FindBy (xpath="//button[text()='ADD TO CART']") private WebElement addToCartBtn;
	@FindBy (xpath = "//a[contains(text(),'pampa BLUEDART')]") private WebElement productName;
	
	public void addToCart(ExcelUtility excelUtility)
	{
		
		crossBtn.click();
		excelUtility.initializeExcelFile(IConstants.FLIPKARTEXCELFILEPATH);
		searchTxtbox.sendKeys(excelUtility.getDataFromExcel(0, 0, "Sheet1"));
		String actualProductName = firstProduct.getAttribute("title");
		firstProduct.click();
		addToCartBtn.click();
		String expectedProductName = productName.getText();
		Assert.assertEquals(expectedProductName,actualProductName );
	}

}
