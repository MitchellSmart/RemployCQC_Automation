package Security;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.PageObjectSetup;

public class Webelement_Operations extends PageObjectSetup<Webelement_Operations> {

	public Webelement_Operations(WebDriver driver) {
		super(driver);
	}

	public boolean IsElementPresent(By Locator) throws InterruptedException {

		WebDriverWait WaitFor = new WebDriverWait(driver, 5);
		int attempts = 0;
		while (attempts < 5) {
			try {
				WaitFor.until(ExpectedConditions.presenceOfElementLocated(Locator));
				WaitFor.until(ExpectedConditions.visibilityOfElementLocated(Locator));
				return true;
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException occured");
				return false;
			} catch (TimeoutException e) {
				System.out.println("TimeoutException occured");
				return false;
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException occured");
				Thread.sleep(1500);
				driver.navigate().refresh();
			} 
			attempts++;
		}
		return false;

	}

}
