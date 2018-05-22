package scenarios.Genericc;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Framework.BaseMethods;
import Framework.LoginFunctions;
import Framework.TestSetup;
import testNGClasses.MyCustomListener;
import testRailSupport.UseAsTestRailId;

@Listeners(MyCustomListener.class)
public class GF_001_Login_Logout extends TestSetup {

	// Declare global variables including classes that will be used in this
	// execution
	protected SoftAssert sofas = new SoftAssert();
	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;

	@Test
	@UseAsTestRailId(testRailId = 40856, testRailTestRun = "Regression")
	public void Run_GF_001_Login_Logout() throws Exception {

		LoginFunctions = new LoginFunctions(driver);
		BaseMethods = new BaseMethods(driver);
		
		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminPassword"));

		LoginFunctions.AppianLogout();
		
		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("LifeLineAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("LifeLineAdminPassword"));
		
		LoginFunctions.AppianLogout();
		
		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("KatemercerAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("KatemercerAdminPassword"));
		
		LoginFunctions.AppianLogout();
		
		System.out.println("Scenario completed");
		sofas.assertAll();

	}
}
