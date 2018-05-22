package Framework;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PageObjectSetup<T> {

	protected WebDriver driver;
	//protected WebDriverWait wait;
	int attempts = 0;
	ExpectedCondition<Boolean> bool=null;
	FluentWait<WebDriver> wait ;

	// Instantiate WebDriver and Wait
	protected PageObjectSetup(WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(30, TimeUnit.SECONDS)
		        .pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class);
	}

	// Used to Enter data in a field
	@SuppressWarnings("unlikely-arg-type")
	protected void Send(String Data, By Element) throws InterruptedException {
		WaitForVisibilityOf(Element, 60);
		while (attempts < 30) 
		{
			try
			{
				find(Element).sendKeys(Data);
				Thread.sleep(500);
				//find(Element).sendKeys(Keys.TAB);
				//Thread.sleep(500);
				bool = ExpectedConditions.textToBePresentInElementValue(Element, Data);
				
				if (bool.equals(false)) {
					Thread.sleep(1500);
				} else {
					break;
				}
			}
			catch (StaleElementReferenceException e) {
				Thread.sleep(500);
			} catch (WebDriverException e) {
				Thread.sleep(500);
			} catch (NullPointerException e) {
				Thread.sleep(500);
			}
			attempts++;
		}

	}
	
	// Used to Enter data in a field
	@SuppressWarnings("unlikely-arg-type")
	protected void SendNoTab(String Data, By Element) throws InterruptedException {
		WaitForVisibilityOf(Element, 60);
		while (attempts < 30) 
		{
			try
			{
				find(Element).sendKeys(Data);
				Thread.sleep(500);
				bool = ExpectedConditions.textToBePresentInElementValue(Element, Data);
				
				if (bool.equals(false)) {
					Thread.sleep(1500);
				} else {
					break;
				}
			}
			catch (StaleElementReferenceException e) {
				Thread.sleep(500);
			} catch (WebDriverException e) {
				Thread.sleep(500);
			} catch (NullPointerException e) {
				Thread.sleep(500);
			}
			attempts++;
		}

	}

	// Used to get the Webelement by passing in any by element
	protected WebElement find(final By Locator) throws InterruptedException {
		WaitForPresenceOf(Locator, 20);
		
		WebElement ele = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) {
				return driver.findElement(Locator);
			}
		});
		
		return ele ;
	}

	// Method to get the text of a webelement
	protected String GetText(By Locator) throws InterruptedException {
		WaitForVisibilityOf(Locator, 30);
		return find(Locator).getText();
	}

	// Used to click on any element
	protected void Click(By Element) throws InterruptedException {
		WaitForClickability(Element, 90);
		find(Element).click();

	}

	// Get the attribute of a webelement
	protected String getAttribute(By Locator, String Attrib_Name) throws InterruptedException {
		WaitForVisibilityOf(Locator, 50);
		return find(Locator).getAttribute(Attrib_Name);
	}

	// Used to wait for the presence of the elements
	protected void WaitForPresenceOf(By Locator, Integer... TimeInSeconds) throws InterruptedException {
		while (attempts < 20) {
			try {
				WaitFor(ExpectedConditions.presenceOfElementLocated(Locator),
						(TimeInSeconds.length > 0 ? TimeInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(1000);
			} catch (WebDriverException e) {
				Thread.sleep(1000);
			} catch (NullPointerException e) {
				Thread.sleep(1000);
			}
			attempts++;
		}

	}

	// Used to wait for the visibility of the elements
	protected void WaitForVisibilityOf(By Locator, Integer... TimeInSeconds) throws InterruptedException {
		while (attempts < 20) {
			try {
				WaitFor(ExpectedConditions.visibilityOfElementLocated(Locator),
						(TimeInSeconds.length > 0 ? TimeInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(1000);
			} catch (WebDriverException e) {
				Thread.sleep(1000);
			} catch (NullPointerException e) {
				Thread.sleep(1000);
			}
			attempts++;
		}

	}

	// Used to wait for the Clickability of the element
	protected void WaitForClickability(By Locator, Integer... TimeInSeconds) throws InterruptedException {
		while (attempts < 20) {
			try {
				WaitFor(ExpectedConditions.elementToBeClickable(Locator),
						(TimeInSeconds.length > 0 ? TimeInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(1000);
			} catch (WebDriverException e) {
				Thread.sleep(1000);
			} catch (NullPointerException e) {
				Thread.sleep(1000);
			}
			attempts++;
		}

	}

	// Used to waitFor a webelement
	private void WaitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {

		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 40;
		wait.until(condition);
	}

}
