package Events;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.PageObjectSetup;
import Framework.Wait;

public class GetEventId extends PageObjectSetup<GetEventId> {
	Wait Wait;

	// Declaring all the page objects
	protected By EventId = By.xpath("//h1[contains(text(),'Event (s) successfully created:')]");

	@SuppressWarnings("static-access")
	public GetEventId(WebDriver driver) {
		super(driver);
		this.Wait = new Wait(driver);

		// TODO Auto-generated constructor stub
	}

	public String Run_GetEventId()throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		
		String Eventid = driver.findElement(EventId).getText();
		String EventIdOnly = Eventid.substring(32);
		return EventIdOnly;
	}
}
