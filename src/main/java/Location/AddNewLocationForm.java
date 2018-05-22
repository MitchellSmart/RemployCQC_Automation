package Location;

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
import Objects.LocationDetails;

public class AddNewLocationForm extends PageObjectSetup<AddNewLocationForm> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	// Declaring all the page objects
	protected By DeptCRMID = By.xpath("//label[contains(text(),'Dept CRM Id')]//../..//input[1]");
	protected By LocationCRMID = By.xpath("//label[contains(text(),'Location CRM ID')]//../..//input[1]");
	protected By Region = By.xpath("//span[text()='Region']/../..//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']");
	protected By RegionSelect = By.xpath("//li/div[text()='London']");
	protected By DeptCRMName = By.xpath("//label[contains(text(),'Dept CRM Name')]//../..//input[1]");
	protected By LocationName = By.xpath("//label[contains(text(),'Location Name')]//../..//input[1]");
	//note protected By Gender = By.xpath("//span[contains(text(),'Gender')]/../..//option[2]");
	protected By Add_1 = By.xpath("//label[text()='Address Line 1']//../..//input[1]");
	protected By TownCity = By.xpath("//label[text()='Town/City']//../..//input[1]");
	protected By Post_Code = By.xpath("//label[text()='Postcode']//../..//input[1]");
	protected By Country = By.xpath("//label[text()='Country']//../..//input[1]");


	@SuppressWarnings("static-access")
	public AddNewLocationForm(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_AddNewLocationForm()throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		// ammend to be locaiton details
		Send(LocationDetails.DeptCRMIDV, DeptCRMID);
		Send(LocationDetails.LocationCRMIDV, LocationCRMID);
		Click(Region);
		waitClass.ShortWait();
		Click(RegionSelect);
		waitClass.ShortWait();
		Send(LocationDetails.DeptCRMNameV, DeptCRMName);
		Send(LocationDetails.LocationNameV, LocationName);
		//Adress
		Send("Address 1", Add_1);
		Send("Im a town No im a City", TownCity);
		Send("SE1 " + RandomStringUtils.randomNumeric(1) + RandomStringUtils.randomAlphabetic(2), Post_Code);
		Send("England", Country);

		Buttons.ClickButton("Submit");
	}
}
