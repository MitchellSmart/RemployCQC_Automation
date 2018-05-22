package Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import Framework.AssertFun;
import Framework.PageObjectSetup;
import Objects.InspectorDetails;

public class InspectorValidation extends PageObjectSetup<InspectorValidation> {


	WebDriverWait wait = new WebDriverWait(driver, 40);
	AssertFun AssertFun;


	protected By InspectorName = By.xpath("//span[contains(text(), 'Inspector Name')]//../..//p");
	protected By Id = By.xpath("//*[@class = 'TitleText---page_header']");
	
	public InspectorValidation(WebDriver driver) {
		super(driver);
		this.AssertFun = new AssertFun(driver);
	}
	
	public void Run_InspectorValidation(SoftAssert sofas) {
		
		// Location validation
		String Inspectorname = driver.findElement(InspectorName).getText();
		String ID = driver.findElement(Id).getText();
		
		AssertFun.SoftAssertString(Inspectorname, InspectorDetails.InspFnameV + " " + InspectorDetails.InspLnameV , sofas);
		System.out.println("Inspector Name = " + Inspectorname);
		System.out.println("Location ID = " + ID);
		System.out.println("Inspector Data validated successfully");
	}
	
	
	
	
	
	
}