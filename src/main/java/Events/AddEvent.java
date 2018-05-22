package Events;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BaseMethods;
import Framework.DateTimeMethods;
import Framework.PageObjectSetup;
import Framework.Wait;
import Inspection.CreateNewInspectionForm;

public class AddEvent extends PageObjectSetup<AddEvent> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	Wait Wait;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	
	// Declaring all the page objects
	protected By Expertise = By.xpath("//span[text()='Select ExE Expertise']/../..//div[@class='PickerWidget---picker_value']");
	protected By SelectEX = By.xpath("//p[text()='Family carers of people with dementia (FCD)']");
	protected By Notes = By.xpath("//label[contains(text(),'Notes')]//../..//textarea[1]");
	// Declaring all the page objects right
	protected By Task1 = By.xpath("//label[contains(text(),'Task 1')]//../..//input[1]");
	protected By Task2 = By.xpath("//label[contains(text(),'Task 2')]//../..//input[1]");
	protected By Task3 = By.xpath("//label[contains(text(),'Task 3')]//../..//input[1]");


	@SuppressWarnings("static-access")
	public AddEvent(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		this.Wait = new Wait(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_AddEvent()throws IOException, SQLException, ClassNotFoundException, InterruptedException {


		Buttons.ClickButton("Create New Events");
		SendNoTab("people", Expertise);
		Click(SelectEX);
		Send("Notes Information for Inspection Event", Notes);
		Send("", Task1);
		Send("Event Task 2 Description", Task2);
		Send("Event Task 3 Description", Task3);
		Buttons.ClickButton("Submit");
		Wait.LongWait();
	}
}
