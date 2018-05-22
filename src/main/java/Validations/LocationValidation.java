package Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Framework.AssertFun;
import Framework.PageObjectSetup;
import Objects.LocationDetails;

public class LocationValidation extends PageObjectSetup<LocationValidation> {


	WebDriverWait wait = new WebDriverWait(driver, 40);
	AssertFun AssertFun;


	protected By DeptCRMId = By.xpath("//span[contains(text(), 'Dept CRM Id')]//../..//p");
	protected By LocationCRMId = By.xpath("//span[contains(text(), 'Location CRM ID')]//../..//p");
	protected By DeptCRMName = By.xpath("//span[contains(text(), 'Dept CRM Name')]//../..//p");
	protected By LocationName = By.xpath("//span[contains(text(), 'Location Name')]//../..//p");
	protected By Id = By.xpath("(//*[@class = 'TitleText---page_header'])[1]");
	
	
	public LocationValidation(WebDriver driver) {
		super(driver);
		this.AssertFun = new AssertFun(driver);
	}
	
	public void Run_LocationValidation(SoftAssert sofas) {
		
		// Location validation
		String DeptCRMID = driver.findElement(DeptCRMId).getText();
		String LocationCRMID = driver.findElement(LocationCRMId).getText();
		String DeptCRMname = driver.findElement(DeptCRMName).getText();
		String Locationname = driver.findElement(LocationName).getText();
		String ID = driver.findElement(Id).getText();

		
		AssertFun.SoftAssertString(DeptCRMID, LocationDetails.DeptCRMIDV, sofas);
		AssertFun.SoftAssertString(LocationCRMID, LocationDetails.LocationCRMIDV, sofas);
		AssertFun.SoftAssertString(DeptCRMname, LocationDetails.DeptCRMNameV, sofas);
		AssertFun.SoftAssertString(Locationname, LocationDetails.LocationNameV, sofas);
		
		System.out.println("Dept CRM ID = " + DeptCRMID);
		System.out.println("Location CRM ID = " + LocationCRMID);
		System.out.println("Dept CRM Name = " + DeptCRMname);
		System.out.println("Location Name = " + Locationname);
		System.out.println("Location ID = " + ID);
		
		System.out.println("Location Data validated successfully");
	}
	
	
	
	
	
	
}