package Events;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Actions.ClickTask;
import Framework.BaseMethods;
import Framework.DateTimeMethods;
import Framework.PageObjectSetup;
import Framework.Wait;

public class SelectSupplierForEvent extends PageObjectSetup<SelectSupplierForEvent> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	Wait Wait;
	ClickTask ClickTask;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	
	// Declaring all the page objects
	protected By Supplier = By.xpath("//span[text()='List Of Available Suppliers']//../..//div[@class = 'DropdownWidget---dropdown_value']");
	protected By SupplierRemploy = By.xpath("//li/div[text()='Remploy']");


	@SuppressWarnings("static-access")
	public SelectSupplierForEvent(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		ClickTask = new ClickTask(driver);
		this.Wait = new Wait(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_SelectSupplierForEvent(String EventID)throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		//ClickTask.Run_ClickTask("Inspection - Select a Supplier (Id: " + EventID +")");
		Buttons.ClickButton("Accept");
		Click(Supplier);
		waitClass.ShortWait();
		Click(SupplierRemploy);
		Buttons.ClickButton("Submit");
	}
}
