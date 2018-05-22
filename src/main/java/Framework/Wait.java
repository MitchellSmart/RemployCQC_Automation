package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends PageObjectSetup<Wait> {

	WebDriverWait wait = new WebDriverWait(driver, 40);
	protected By RefreshTL  = By.xpath("//button[contains(text(), 'Refresh Task List')]");
	
	

	public Wait(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

	// method for to wait until page loaded
	public void waitForPageLoaded(By by) throws InterruptedException {
		ShortWait();
		if (by != null) {
			boolean result = false;
			int attempts = 0;
			while (attempts < 10) {
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(by));
					result = true;
					break;
				} catch (org.openqa.selenium.WebDriverException e) {

				}
				attempts++;
				ShortWait();
				System.out.println("Wait for page load by:" + attempts);
				ShortWait();
			}
		}
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// This loop will rotate for 100 times to check If page Is ready after every 1
			// second.
			// You can replace your if you wants to Increase or decrease wait time.
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}

				catch (org.openqa.selenium.WebDriverException e) {

				}
				// To check page ready state.

				if (js.executeScript("return document.readyState").toString().equals("complete")) {
					break;
				}
				System.out.println("Wait for ready state:" + i);
			}
		} finally {
		}
		ShortWait();
	}

	public void ShortWait() throws InterruptedException {
		Thread.sleep(2500);
	}

	// Method which will wait explicitly for entered amount of time in miliseconds
	public void WaitForTime(int Time) throws InterruptedException {
		Thread.sleep(Time);
	}

	// Method to wait for the task to appear in Tasks tab
	public boolean WaitForTaskPresent(String TaskName) {
		BaseMethods BaseMethods = new BaseMethods(driver);

		try {
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", TaskName))));

			return true;
		} catch (TimeoutException e) {

			return false;
		}
	}

	// Method which will wait explicitly for 5 seconds
	public void LongWait() throws InterruptedException {

		Thread.sleep(6000);

	}

	// Method to wait for the task to appear in Tasks tab. it will wait for 10
	// seconds and then again click on Tasks tab and will look for the task to show
	// up
	public void ClickTask(String TaskName, WebDriver driver) throws InterruptedException {
		
		By taskLink = By.xpath("//a[contains(text(),'" + TaskName + "')]");
		int i = 0;
		while (i < 100) {
			if (WaitForTaskPresent(TaskName)) {
				String taskLinkk = driver.findElement(taskLink).getAttribute("href");
				driver.navigate().to(taskLinkk);
				break;
			} else {
				WaitForTime(1000);
				Click(RefreshTL);
				System.out.println("Refreshed the page");
			}
			i++;
		}
	}

}
