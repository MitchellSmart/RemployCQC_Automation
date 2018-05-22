package Objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.Buttons;
import Framework.PageObjectSetup;
import Framework.Wait;


public class CancelReferral extends PageObjectSetup<BaseMethods>{
	
    public CancelReferral(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}
    
	WebDriverWait wait = new WebDriverWait(driver, 60);
	Wait waitClass;
	Buttons Buttons;
	BaseMethods BaseMethods;

	public void CancelReferralFromReferralDashboard (String buttonName) throws InterruptedException {
		
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	waitClass.LongWait();
    	driver.findElement(By.xpath(BaseMethods.GenerateXpath("AdditionalDashboard", "Related Actions"))).click();
    	
    	waitClass.LongWait();
    	driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", "Withdraw or Cancel Referral"))).click();
    	//BaseMethods.clickElement(driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", "Withdraw or Cancel Referral"))));
    	driver.findElement(By.xpath(BaseMethods.GenerateComplexXpath("Dropdown", "select the appropriate", 2))).click();
    	waitClass.LongWait();
    	Buttons.ClickButton(buttonName);;
    	waitClass.ShortWait();
    	Buttons.ClickButton("Yes");
    	waitClass.waitForPageLoaded(By.xpath(BaseMethods.GenerateXpath("Button", "Finish")));
    	Buttons.ClickButton("Finish");;
    	waitClass.ShortWait();
    	waitClass.waitForPageLoaded(By.xpath(BaseMethods.GenerateXpath("AdditionalDashboard", "Summary")));
    	driver.navigate().refresh();
    	waitClass.LongWait();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("AdditionalDashboard", "Summary"))));
    	System.out.println("Referral cancelled");
    	waitClass.LongWait();
    }

}
