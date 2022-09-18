package flipkart.TestScript;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.objectReposit.HomePage;

public class AddToCart extends BaseClass {
	@Test
	public void flipKartAssignment() {
		HomePage homePage=new HomePage(driver);
		homePage.addToCart(excelUtility);
	}


}
