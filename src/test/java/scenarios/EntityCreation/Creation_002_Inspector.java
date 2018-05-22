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
import Inspector.AddNewInspectorForm;
import Objects.GenerateRandomData;
import Validations.InspectorValidation;
import testNGClasses.MyCustomListener;
import testRailSupport.UseAsTestRailId;

@Listeners(MyCustomListener.class)
public class Creation_002_Inspector extends TestSetup {

	// Declare global variables including classes that will be used in this
	// execution
	protected SoftAssert sofas = new SoftAssert();
	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;
	ClickNavTab ClickNavTab ;
	Wait Wait;
	ClickAction ClickAction;
	AddNewInspectorForm AddNewInspectorForm;
	ClickViewLink ClickViewLink;
	InspectorValidation InspectorValidation;
	
	@Test
	@UseAsTestRailId(testRailId = 41904, testRailTestRun = "Regression")
	public void Run_Creation_002_Inspector() throws Exception {

		LoginFunctions = new LoginFunctions(driver);
		BaseMethods = new BaseMethods(driver);
		ClickNavTab = new ClickNavTab(driver);
		ClickAction = new ClickAction(driver);
		AddNewInspectorForm = new AddNewInspectorForm(driver);
		ClickViewLink = new ClickViewLink(driver);
		InspectorValidation = new InspectorValidation(driver);

		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminPassword"));
		
		ClickNavTab.GoToAppianTabs("Actions");
		ClickAction.Run_ClickAction("Add New Inspector");
		
		String[] NewData = GenerateRandomData.GenerateRandomInspectorData();
		Objects.InspectorDetails.InspFnameV = NewData[0];
		Objects.InspectorDetails.InspLnameV = NewData[1];

		AddNewInspectorForm.Run_AddNewInspectorForm();
		ClickViewLink.Run_ClickViewLink("Inspectors");
		InspectorValidation.Run_InspectorValidation(sofas);
		LoginFunctions.AppianLogout();
		System.out.println("Scenario completed");
		sofas.assertAll();
	}
}
