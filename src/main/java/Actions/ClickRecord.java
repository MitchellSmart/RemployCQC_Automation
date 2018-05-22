package Actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.PageObjectSetup;


public class ClickRecord extends PageObjectSetup<ClickAction> {

	BaseMethods BaseMethods;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	public ClickRecord(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void Run_ClickRecord(String RecordName) throws IOException, SQLException, ClassNotFoundException, InterruptedException {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", RecordName))));
		driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", RecordName))).click();
		Thread.sleep(3000);

	}
}
