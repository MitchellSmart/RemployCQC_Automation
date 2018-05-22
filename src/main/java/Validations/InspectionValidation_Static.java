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

public class InspectionValidation_Static extends PageObjectSetup<InspectorValidation> {


	WebDriverWait wait = new WebDriverWait(driver, 40);
	AssertFun AssertFun;

	protected By INSNo = By.xpath("//span[contains(text(), 'INS No')]//../..//p");
	protected By CCGName = By.xpath("//span[contains(text(), 'CCG Name')]//../..//p");
	protected By InspectorName = By.xpath("//span[contains(text(), 'Inspector Name')]//../..//p");
	protected By LocationCRMId = By.xpath("//span[contains(text(), 'Location CRM Id')]//../..//p");
	protected By Id = By.xpath("//h1[contains(text(),'')]");
	
	public InspectionValidation_Static(WebDriver driver) {
		super(driver);
		this.AssertFun = new AssertFun(driver);
	}
	
	public String Run_InspectionValidation_Static(String InspectionID, SoftAssert sofas) {
		
		// Location validation
		String INSBUmber = driver.findElement(INSNo).getText();
		String CCGNamee = driver.findElement(CCGName).getText();
		String LocationCRMID = driver.findElement(LocationCRMId).getText();
		String Inspectorname = driver.findElement(InspectorName).getText();
		InspectionID = driver.findElement(Id).getText();
		
		AssertFun.SoftAssertString(INSBUmber, InspectionDetails.INSnumberV, sofas);
		AssertFun.SoftAssertString(CCGNamee, InspectionDetails.CCGnameV, sofas);
		
		// Inspector Name
		AssertFun.SoftAssertString(Inspectorname, "AUTOMATION_inspector AUTOMATION_inspector" , sofas);
		
		// Location
		AssertFun.SoftAssertString(LocationCRMID, "AUTOMATION_123",  sofas);
		
		System.out.println("Inspection INS Number = " + INSBUmber);
		System.out.println("Inspection CCG Name = " + CCGNamee);
		System.out.println("Inspector Name = " + Inspectorname);
		System.out.println("Location CRM ID = " + LocationCRMID);
		System.out.println("Inspection ID = " + InspectionID);
		System.out.println("Inspection Data validated successfully");
		return InspectionID;
		
	}
}
