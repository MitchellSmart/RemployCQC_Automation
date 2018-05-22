package Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFunctions extends PageObjectSetup<BrowserFunctions> {

	WebDriverWait wait = new WebDriverWait(driver, 40);
	// StringBuilder sb = new StringBuilder();

	public BrowserFunctions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Functionality to scroll at bottom of the page
	public void scrollDown() {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}

	}

	// Javascript method to perform click. It will take the webelement as input
	public void clickElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
		
		String value = element.getAttribute("value");

		if (element.toString().contains("input")){
			while (value==null ||value.equalsIgnoreCase("")) {
				jse.executeScript("arguments[0].click();", element);
				value = element.getAttribute("value");
				System.out.println("Value");
				}
		}
			
		
	}

	/*
	 * @AfterMethod(alwaysRun = true) public void AfterTest() throws
	 * InterruptedException, IOException {
	 * 
	 * if(CheckLogout()) { System.out.println("User is already logged out"); }
	 * 
	 * else { BaseMethods.AppianLogout(); }
	 * 
	 * System.out.println("Scenario completed");
	 * 
	 * //BaseMethods.sofas.assertAll(); }
	 * 
	 * 
	 * public boolean CheckLogout() throws InterruptedException, IOException { try {
	 * BaseMethods.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
	 * BaseMethods.GetPropertiesFIleData().getProperty("AppianUserName")))); return
	 * true; } catch(TimeoutException e) {
	 * System.out.println("User was not logged out so logging out in AfterTest");
	 * return false; }
	 * 
	 * 
	 * }
	 * 
	 * 
	 */

}