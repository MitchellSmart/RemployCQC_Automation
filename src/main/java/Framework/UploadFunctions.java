package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFunctions extends PageObjectSetup<UploadFunctions> {
	WebDriverWait wait = new WebDriverWait(driver, 40);
	Wait waitClass;
	Buttons Buttons;
	BaseMethods BaseMethods;

	public UploadFunctions(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}

	// Method to Upload the Document by passing in the label of the grid as
	// UploadGridLabel and path of
	// the file to be uploaded as UploadFilepath variable
	public void UploadDoc(String UploadXpath, String Uploadfilepath) throws InterruptedException {
		waitClass.LongWait();
		driver.findElement(By
				.xpath(UploadXpath))
				.sendKeys(Uploadfilepath);
		waitClass.WaitForTime(5000);
	}

	// Method to upload document without Grid Label. Just pass in the index at which
	// the upload field grid is available
	public static String UploadDocWithoutGridLabel(int trIndex) throws InterruptedException {

		String UploadXpath = "(//tr)[" + trIndex + "]/td[1]//input[3]";
		return UploadXpath;
	}

}
