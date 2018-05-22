package scenarios.EntityCreation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Actions.ClickAction;
import Actions.ClickNavTab;
import Actions.ClickViewLink;
import Framework.BaseMethods;
import Framework.LoginFunctions;
import Framework.TestSetup;
import Framework.Wait;
import Location.AddNewLocationForm;
import Objects.GenerateRandomData;
import Validations.LocationValidation;
import testNGClasses.MyCustomListener;
import testRailSupport.UseAsTestRailId;

@Listeners(MyCustomListener.class)
public class Creation_001_Location extends TestSetup {

	// Declare global variables including classes that will be used in this
	// execution
	protected SoftAssert sofas = new SoftAssert();
	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;
	ClickNavTab ClickNavTab ;
	Wait Wait;
	ClickAction ClickAction;
	AddNewLocationForm AddNewLocationForm;
	ClickViewLink ClickViewLink;
	LocationValidation LocationValidation;
	
	@Test
	@UseAsTestRailId(testRailId = 41903, testRailTestRun = "Regression")
	public void Run_Creation_001_Location() throws Exception {

		LoginFunctions = new LoginFunctions(driver);
		BaseMethods = new BaseMethods(driver);
		ClickNavTab = new ClickNavTab(driver);
		ClickAction = new ClickAction(driver);
		AddNewLocationForm = new AddNewLocationForm(driver);
		ClickViewLink = new ClickViewLink(driver);
		LocationValidation = new LocationValidation(driver);

		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminPassword"));
		
		ClickNavTab.GoToAppianTabs("Actions");
		ClickAction.Run_ClickAction("Add New Location");
		
		String[] NewData = GenerateRandomData.GenerateRandomLocationData();
		Objects.LocationDetails.DeptCRMIDV = NewData[0];
		Objects.LocationDetails.LocationCRMIDV = NewData[1];
		Objects.LocationDetails.DeptCRMNameV = NewData[2];
		Objects.LocationDetails.LocationNameV = NewData[3];
		
		AddNewLocationForm.Run_AddNewLocationForm();
		ClickViewLink.Run_ClickViewLink("Location");
		LocationValidation.Run_LocationValidation(sofas);
		LoginFunctions.AppianLogout();
		System.out.println("Scenario completed");
		sofas.assertAll();
	}
}
