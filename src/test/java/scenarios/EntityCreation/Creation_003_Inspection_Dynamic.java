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
import Inspection.CreateNewInspectionForm;
import Objects.GenerateRandomData;
import Validations.InspectionValidation_Static;
import testNGClasses.MyCustomListener;
import testRailSupport.UseAsTestRailId;

@Listeners(MyCustomListener.class)
public class Creation_003_Inspection_Dynamic extends TestSetup {

	// Declare global variables including classes that will be used in this
	// execution
	protected SoftAssert sofas = new SoftAssert();
	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;
	ClickNavTab ClickNavTab ;
	Wait Wait;
	ClickAction ClickAction;
	CreateNewInspectionForm CreateNewInspectionForm;
	ClickViewLink ClickViewLink;
	InspectionValidation_Static InspectionValidation_Static;
	
	@Test
	@UseAsTestRailId(testRailId = 42950, testRailTestRun = "Regression")
	public void Run_Creation_003_Inspection() throws Exception {

		LoginFunctions = new LoginFunctions(driver);
		BaseMethods = new BaseMethods(driver);
		ClickNavTab = new ClickNavTab(driver);
		ClickAction = new ClickAction(driver);
		CreateNewInspectionForm = new CreateNewInspectionForm(driver);
		ClickViewLink = new ClickViewLink(driver);
		InspectionValidation_Static = new InspectionValidation_Static(driver);

		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminPassword"));
		
		ClickNavTab.GoToAppianTabs("Actions");
		ClickAction.Run_ClickAction("Create New Inspection");
		
		String InspectionID = "";
		String[] NewData = GenerateRandomData.GenerateRandomInspectionData();
		Objects.InspectionDetails.INSnumberV = NewData[0];
		Objects.InspectionDetails.CCGnameV = NewData[1];
		
		CreateNewInspectionForm.Run_CreateNewInspectionForm();
		ClickViewLink.Run_ClickViewLink("Inspection Record");
		
		InspectionValidation_Static.Run_InspectionValidation_Static(InspectionID, sofas);
		LoginFunctions.AppianLogout();
		System.out.println("Scenario completed");
		sofas.assertAll();
	}
}
