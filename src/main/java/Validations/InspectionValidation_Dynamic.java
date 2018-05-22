package Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Framework.AssertFun;
import Framework.PageObjectSetup;
import Objects.InspectionDetails;
import Objects.InspectorDetails;
import Objects.LocationDetails;

public class InspectionValidation_Dynamic extends PageObjectSetup<InspectorValidation> {


	WebDriverWait wait = new WebDriverWait(driver, 40);
	AssertFun AssertFun;

	protected By INSNo = By.xpath("//span[contains(text(), 'INS No')]//../..//p");
	protected By CCGName = By.xpath("//span[contains(text(), 'CCG Name')]//../..//p");
	protected By InspectorName = By.xpath("//span[contains(text(), 'Inspector Name')]//../..//p");
	protected By LocationCRMId = By.xpath("//span[contains(text(), 'Location CRM ID')]//../..//p");
	protected By Id = By.xpath("//*[@class = 'TitleText---page_header']");
	
	public InspectionValidation_Dynamic(WebDriver driver) {
		super(driver);
		this.AssertFun = new AssertFun(driver);
	}
	
	public void Run_InspectionValidation(SoftAssert sofas) {
		
		// Location validation
		String INSBUmber = driver.findElement(INSNo).getText();
		String CCGNamee = driver.findElement(CCGName).getText();
		String LocationCRMID = driver.findElement(LocationCRMId).getText();
		String Inspectorname = driver.findElement(InspectorName).getText();
		String ID = driver.findElement(Id).getText();
		
		AssertFun.SoftAssertString(INSBUmber, InspectionDetails.INSnumberV, sofas);
		AssertFun.SoftAssertString(CCGNamee, InspectionDetails.CCGnameV, sofas);
		
		// Inspector Name
		// Dynamic AssertFun.SoftAssertString(Inspectorname, InspectorDetails.InspFnameV + " " + InspectorDetails.InspLnameV , sofas);
		
		// Location
		// Dynamic AssertFun.SoftAssertString(LocationCRMID, LocationDetails.LocationCRMIDV, sofas);
		
		System.out.println("Inspection INS Number = " + INSBUmber);
		System.out.println("Inspection CCG Name = " + CCGNamee);
		System.out.println("Inspector Name = " + Inspectorname);
		System.out.println("Location CRM ID = " + LocationCRMID);
		System.out.println("Location ID = " + ID);
		System.out.println("Inspection Data validated successfully");
		
	}
	
	
	
	
	
	
}
