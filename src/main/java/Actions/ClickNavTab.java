package Actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.PageObjectSetup;

public class ClickNavTab extends PageObjectSetup<ClickNavTab> {

	BaseMethods BaseMethods;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	public ClickNavTab(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
	}

	// Methods to navigate through the menu
	public void GoToAppianTabs(String TabName)
			throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		
		By Link = By.xpath("(//a[contains(text(), '"+TabName+"')])[1]");
		
		Click(Link);
		/*
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", TabName))));
		driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", TabName))).click();*/

	}

}
