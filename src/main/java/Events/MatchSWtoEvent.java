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

public class MatchSWtoEvent extends PageObjectSetup<MatchSWtoEvent> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	Wait Wait;
	ClickTask ClickTask;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	
	// Declaring all the page objects
	protected By FirstSW = By.xpath("//tr[td//text()[contains(., 'Select row 1')]]//td[1]");


	@SuppressWarnings("static-access")
	public MatchSWtoEvent(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		ClickTask = new ClickTask(driver);
		this.Wait = new Wait(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_MatchSWtoEvent()throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		Buttons.ClickButton("Accept");
		Buttons.ClickButton("Reset Filters");
		Buttons.ClickButton("Search");
		waitClass.ShortWait();
		Click(FirstSW);
		Buttons.ClickButton("Confirm for Event");
		waitClass.ShortWait();
		Buttons.ClickButton("Skip");
	}
}
