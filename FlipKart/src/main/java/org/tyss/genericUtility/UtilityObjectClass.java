package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityObjectClass {
	
	//Single Ton Design Pattern
		//create static global variable/class variable and make it as private
		private static UtilityObjectClass classVar;
		//make constructor as private
		private UtilityObjectClass() {
		}
		//static getter method for create object
		public static UtilityObjectClass getInstance() {
			if(classVar==null) {
				classVar=new UtilityObjectClass();
			}
			return classVar;
		}


		private WebDriver driver;
		private FileUtility propertyFileUtility;
		private JavaUtility javaUtility;
		private WebDriverWait wait;
		private ExcelUtility excelUtility;
		private WebDriverUtility webDriverUtility;
		



		public FileUtility getFileUtility() {
			return propertyFileUtility;
		}
		public void setFileUtility(FileUtility fileUtility) {
			this.propertyFileUtility = propertyFileUtility;
		}
		public JavaUtility getJavaUtility() {
			return javaUtility;
		}
		public void setJavaUtility(JavaUtility javaUtility) {
			this.javaUtility = javaUtility;
		}
		public WebDriverWait getWait() {
			return wait;
		}
		public void setWait(WebDriverWait wait) {
			this.wait = wait;
		}
		public ExcelUtility getExcelUtility() {
			return excelUtility;
		}
		public void setExcelUtility(ExcelUtility excelUtility) {
			this.excelUtility = excelUtility;
		}
		public WebDriverUtility getWebDriverUtility() {
			return webDriverUtility;
		}
		public void setWebDriverUtility(WebDriverUtility webDriverUtility) {
			this.webDriverUtility = webDriverUtility;
		}
		
		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}


}
