package Events;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import Framework.PageObjectSetup;

public class ChaseInspectorForApproval extends PageObjectSetup<ChaseInspectorForApproval> {
	Framework.Buttons Buttons;
	

	
	// Declaring all the page objects

	@SuppressWarnings("static-access")
	public ChaseInspectorForApproval(WebDriver driver) {
		super(driver);
		this.Buttons = new Framework.Buttons(driver);

		// TODO Auto-generated constructor stub
	}

	public void Run_ChaseInspectorForApproval()throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		
		Buttons.ClickButton("Accept");
		Buttons.ClickButton("Confirm Chase");
	}
}

