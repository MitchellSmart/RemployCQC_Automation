package Actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.PageObjectSetup;


public class ClickAction extends PageObjectSetup<ClickAction> {

	BaseMethods BaseMethods;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	public ClickAction(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void Run_ClickAction(String ActionName) throws IOException, SQLException, ClassNotFoundException, InterruptedException {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", ActionName))));
		driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", ActionName))).click();
		Thread.sleep(3000);

	}
}
