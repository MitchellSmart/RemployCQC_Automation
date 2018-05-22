package Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.AssertFun;
import Framework.PageObjectSetup;
import Framework.Wait;


public class FindSWRequirment extends PageObjectSetup<InspectorValidation> {


	WebDriverWait wait = new WebDriverWait(driver, 40);
	AssertFun AssertFun;
	Wait Wait;
	

	protected By SupportWorkerTable = By.xpath("//*[contains(text(), 'EXE Support Worker')]");
	protected By ExELink = By.xpath("(//a[contains(text(), '')])[33]");
	
	public FindSWRequirment(WebDriver driver) {
		super(driver);
		this.Wait = new Wait(driver);
		this.AssertFun = new AssertFun(driver);
	}
	
	public boolean Run_FindSWRequirment(String InspectionID, boolean SWRequirement) throws InterruptedException {
		
		By InspectionLink = By.xpath("//a[contains(text(), '" + InspectionID + "')]");
		String NavLinkk = driver.findElement(InspectionLink).getAttribute("href");
		driver.navigate().to(NavLinkk);
		Wait.LongWait();
		
		String NavLink = driver.findElement(ExELink).getAttribute("href");
		driver.navigate().to(NavLink);
		Wait.LongWait();
		
		try{
			driver.findElement(SupportWorkerTable).isDisplayed();
			//return true;
			SWRequirement = true;
			System.out.println("ExE has Support Worker Requirement");
		}catch (Exception e1) {
			//return false;
			SWRequirement = false;
			System.out.println("ExE Does Not have Support Worker Requirement");
		}
		return SWRequirement;
	}
}

