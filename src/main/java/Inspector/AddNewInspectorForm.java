package Inspector;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.DateTimeMethods;
import Framework.PageObjectSetup;
import Framework.Wait;
import Objects.InspectorDetails;

public class AddNewInspectorForm extends PageObjectSetup<AddNewInspectorForm> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	// Declaring all the page objects
	protected By InspFname = By.xpath("//label[contains(text(),'First Name')]//../..//input[1]");
	protected By InspLname = By.xpath("//label[contains(text(),'Last Name')]//../..//input[1]");
	
	//Inspector details
	protected By HomePhone = By.xpath("//label[contains(text(),'Home Phone')]//../..//input[1]");
	protected By Mobile = By.xpath("//label[contains(text(),'Mobile')]//../..//input[1]");
	protected By PersonalEmail = By.xpath("//label[contains(text(),'Personal Email')]//../..//input[1]");
	//note protected By Gender = By.xpath("//span[contains(text(),'Gender')]/../..//option[2]");
	protected By Add_1 = By.xpath("//label[text()='Address Line 1']//../..//input[1]");
	protected By Town = By.xpath("//label[text()='Town']//../..//input[1]");
	protected By City = By.xpath("//label[text()='City']//../..//input[1]");
	protected By Post_Code = By.xpath("//label[text()='Postcode']//../..//input[1]");
	protected By Country = By.xpath("//label[text()='Country']//../..//input[1]");


	@SuppressWarnings("static-access")
	public AddNewInspectorForm(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_AddNewInspectorForm()throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		// ammend to be locaiton details
		Send(InspectorDetails.InspFnameV, InspFname);
		DateTimeMethods.populateDate("Date Of Birth", InspectorDetails.InspectorDOB);
		Send(InspectorDetails.InspLnameV, InspLname);
		
		//Inspector contact details
		Send("12345678910", HomePhone);
		Send("10987654321", Mobile);
		Send(InspectorDetails.InspLnameV + "@yopmail.com", PersonalEmail);
		
		//Adress
		Send("Address 1", Add_1);
		Send("Im a town", Town);
		Send("Im a City", City);
		Send("SE1 " + RandomStringUtils.randomNumeric(1) + RandomStringUtils.randomAlphabetic(2), Post_Code);
		Send("England", Country);

		Buttons.ClickButton("Submit");
	}
}
