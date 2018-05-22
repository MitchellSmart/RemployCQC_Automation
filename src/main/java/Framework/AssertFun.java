package Framework;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AssertFun extends PageObjectSetup<AssertFun>{

	//SoftAssert sofas ;
	
	public AssertFun(WebDriver driver) {
		super(driver);
		//this.sofas = new SoftAssert();
		// TODO Auto-generated constructor stub
	}

	// TestNG soft Assertion. The script will not be fault if soft assert failed. It will take two strings as 
	//inputs. One would be the expected and other will be the actual for assertion purpose.
	public void SoftAssertStringContains(String actual, String ExpectedText, SoftAssert sofas) 
	{
		sofas.assertTrue(actual.contains(ExpectedText));
	}

	// TestNG soft Assertion. The script will not be fault if soft assert failed. It will take two strings as 
	//inputs. One would be the expected and other will be the actual for assertion purpose.
	public void SoftAssertString(String actual, String expected, SoftAssert sofas)
	{
		sofas.assertEquals(actual, expected);
	}

}
