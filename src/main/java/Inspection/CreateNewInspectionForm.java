package Inspection;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.DateTimeMethods;
import Framework.PageObjectSetup;
import Framework.Wait;
import Objects.InspectionDetails;

public class CreateNewInspectionForm extends PageObjectSetup<CreateNewInspectionForm> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	Wait Wait;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	
	// Declaring all the page objects left
	protected By IsAnnounced = By.xpath("//input[@value='Yes']//..");
	protected By Sectors = By.xpath("//span[text()='Sectors']/../..//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']");
	protected By SectorsSelect = By.xpath("//li/div[text()='PMS']");
	protected By Services = By.xpath("//span[text()='Services']/../..//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']");
	protected By ServicesSelect = By.xpath("//li/div[text()='NHS General Practice']");
	protected By AdditionalDetail = By.xpath("//label[contains(text(),'Please Provide any Additional Detail Relevant to Your Request')]//../..//textarea[1]");
	// Declaring all the page objects right
	protected By INSnumber = By.xpath("//label[contains(text(),'INS Number')]//../..//input[1]");
	protected By CCGname = By.xpath("//label[contains(text(),'CCG Name')]//../..//input[1]");
	protected By Organisation = By.xpath("//label[contains(text(),'Organisation')]//../..//input[1]");
	protected By InspectionT = By.xpath("//span[text()='Inspection Type']/../..//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']");
	protected By InspectionTSelect = By.xpath("//li/div[text()='Planned comprehensive']");
	protected By ActivityT = By.xpath("//span[text()='Type of Activity']/../..//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']");
	protected By ActivityTSelect = By.xpath("//li/div[text()='Advisory group']");
	protected By LocationA = By.xpath("//label[contains(text(),'Location Accessibility')]//../..//textarea[1]");
	protected By SearchLocation = By.xpath("//label[contains(text(),'Search by Location CRM Id')]//../..//input[1]");
	protected By SelectLocation = By.xpath("//tr[td//text()[contains(., 'AUTOMATION_123')]]//td[1]");
	protected By SearchInspector = By.xpath("//label[contains(text(),'Search by First Name')]//../..//input[1]");
	protected By SelectInspector = By.xpath("//tr[td//text()[contains(., 'AUTOMATION_inspector')]]//td[1]");
	
	

	@SuppressWarnings("static-access")
	public CreateNewInspectionForm(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		this.Wait = new Wait(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_CreateNewInspectionForm()throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		// Inspection Details left
		DateTimeMethods.populateDate("Inspection Start Date", DateTimeMethods.FutureDate(1));
		DateTimeMethods.populateDate("Inspection End Date", DateTimeMethods.FutureDate(3));
		DateTimeMethods.populateBookingDateTimeDate("Inspection Date Sent", DateTimeMethods.FutureDate(0),"12:00");
		Click(IsAnnounced);
		Click(Sectors);
		Click(SectorsSelect);
		Click(Services);
		Click(ServicesSelect);
		Send("Additional Detail for Automation_Organisation", AdditionalDetail);
		
		// Inspection Details right
		Send(InspectionDetails.INSnumberV, INSnumber);
		Send(InspectionDetails.CCGnameV, CCGname);
		Send("Automation_Organisation", Organisation);
		Click(InspectionT);
		Click(InspectionTSelect);
		Click(ActivityT);
		Click(ActivityTSelect);
		Send("Location Accessibility for Automation_Organisation", LocationA);
		
		//Selecting location and Inspector
		Send("AUTOMATION_123", SearchLocation);
		Wait.ShortWait();
		Click(SelectLocation);		
		Send("AUTOMATION_inspector",SearchInspector);
		Wait.ShortWait();
		Click(SelectInspector);
		Buttons.ClickButton("Create Inspection");
	}
}
