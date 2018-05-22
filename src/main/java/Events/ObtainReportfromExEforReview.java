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
import Framework.UploadFunctions;
import Framework.Wait;

public class ObtainReportfromExEforReview extends PageObjectSetup<ObtainReportfromExEforReview> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	Wait Wait;
	ClickTask ClickTask;
	UploadFunctions UploadFunctions;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	
	// Declaring all the page objects
	protected By Comments = By.xpath("//label[contains(text(),'Comments')]//../..//textarea[1]");


	@SuppressWarnings("static-access")
	public ObtainReportfromExEforReview(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		ClickTask = new ClickTask(driver);
		this.Wait = new Wait(driver);
		UploadFunctions = new UploadFunctions(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_ObtainReportfromExEforReview()throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String ExEReportPath = BaseMethods.GetPropertiesFIleData().getProperty("ExEReportPath");
		
		Buttons.ClickButton("Accept");
		//Upload file
		UploadFunctions.UploadDoc("(//input[@class='FileUploadWidget---ui-inaccessible'])[1]", ExEReportPath);			
		Send("Comments for ExE Review Report", Comments);
		Buttons.ClickButton("Submit");
	}
}

