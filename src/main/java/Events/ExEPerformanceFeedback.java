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

public class ExEPerformanceFeedback extends PageObjectSetup<ExEPerformanceFeedback> {
	Wait waitClass;
	Framework.Buttons Buttons;
	BaseMethods BaseMethods;
	static DateTimeMethods DateTimeMethods;
	Wait Wait;
	ClickTask ClickTask;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	
	// Declaring all the page objects
	protected By Comments = By.xpath("//label[contains(text(),'Comments')]//../..//textarea[1]");
	protected By Notes = By.xpath("//label[contains(text(),'Notes')]//../..//textarea[1]");
	protected By FurtherAction = By.xpath("//label[text() = 'No']//..");
	protected By Question1 = By.xpath("(//label[text() = 'Outstanding'])[1]");
	protected By Question1Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[1]");
	protected By Question2 = By.xpath("(//label[text() = 'Good']//..)[4]");
	protected By Question2Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[2]");
	protected By Question3 = By.xpath("(//label[text() = 'Satisfactory']//..)[6]");
	protected By Question3Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[3]");
	protected By Question4 = By.xpath("(//label[text() = 'Requires Improvement']//..)[8]");
	protected By Question4Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[4]");
	protected By Question5 = By.xpath("(//label[text() = 'Outstanding']//..)[10]");
	protected By Question5Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[5]");
	protected By Question6 = By.xpath("(//label[text() = 'Good']//..)[12]");
	protected By Question6Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[6]");
	protected By Question7 = By.xpath("(//label[text() = 'Satisfactory']//..)[14]");
	protected By Question7Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[7]");
	protected By Question8 = By.xpath("(//label[text() = 'Requires Improvement']//..)[16]");
	protected By Question8Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[8]");
	protected By Question9 = By.xpath("(//label[text() = 'Outstanding']//..)[18]");
	protected By Question9Explanation = By.xpath("(//label[contains(text(),'Please explain')]//../..//input[1])[9]");
	protected By Question10 = By.xpath("(//label[text() = 'Good']//..)[20]");
	


	@SuppressWarnings("static-access")
	public ExEPerformanceFeedback(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Framework.Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.DateTimeMethods = new DateTimeMethods(driver);
		this.ClickTask = new ClickTask(driver);
		this.Wait = new Wait(driver);
		// TODO Auto-generated constructor stub
	}

	public void Run_ExEPerformanceFeedback()throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		/*Buttons.ClickButton("Accept");
		Send("Comments for ExE Performance", Comments);
		Send("Notes for ExE Performance", Notes);
		Wait.ShortWait();
		Click(FurtherAction);
		System.out.println("yep");
		Wait.ShortWait();
		Buttons.ClickButton("Next");
		*/
		
		Click(Question1);
		Send("Fab", Question1Explanation);
		Wait.ShortWait();
		Click(Question2);
		Send("Kinda Fab", Question2Explanation);
		Wait.ShortWait();
		Click(Question3);
		Send("Not so Fab", Question3Explanation);
		Wait.ShortWait();
		Click(Question4);
		Send("No Fab", Question4Explanation);
		Wait.ShortWait();
		Click(Question5);
		Send("Fab", Question5Explanation);
		Wait.ShortWait();
		Click(Question6);
		Send("Kinda Fab", Question6Explanation);
		Wait.ShortWait();
		Click(Question7);
		Send("Not so Fab", Question7Explanation);
		Wait.ShortWait();
		Click(Question8);
		Send("No Fab", Question8Explanation);
		Wait.ShortWait();
		Click(Question9);
		Send("Fab", Question9Explanation);
		Wait.ShortWait();
		Click(Question10);
		Buttons.ClickButton("Submit");
		
	}
}
