package Events;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.Wait;
import Framework.PageObjectSetup;
import Inspection.CreateNewInspectionForm;

public class SelectEventFromInspection extends PageObjectSetup<SelectEventFromInspection> {

	BaseMethods BaseMethods;
	Wait Wait;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	protected By PageNext = By.xpath("(//i[@class='GridFooter---paging_control GridFooter---fa-angle-right-svg'])[1]");

	public SelectEventFromInspection(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.Wait = new Wait(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_SelectEventFromInspection(String EventID)
			throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		
		
		int i =0;
		while(i <4) {
			if(driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).isDisplayed()) {
				String EmpLoginURL = driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).getAttribute("href");
				driver.navigate().to(EmpLoginURL);
				Thread.sleep(1000);
				break;

			}else 
			{
				Click(PageNext);
				Wait.ShortWait();
			}i++;
		}
		
		

/*
		try {
			driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).isDisplayed();

			// Is on first page ? yes click it
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", EventID))));
			driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).click();
			Thread.sleep(1000);
		} catch (Exception e1) {
			// Next Page
			Click(PageNext);
			Wait.ShortWait();
			try {
				driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).isDisplayed();

				// Is on first page ? yes click it
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", EventID))));
				String EmpLoginURL = driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).getAttribute("href");
				driver.navigate().to(EmpLoginURL);
				Thread.sleep(1000);
			} catch (Exception e2) {
				// Next Page
				Click(PageNext);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", EventID))));
				driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", EventID))).click();
				Thread.sleep(1000);
			}
		} */
	}
}


