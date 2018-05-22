package scenarios.Genericc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Actions.OpenEmployeeQuestionnaire;
import Framework.BaseMethods;
import Framework.LoginFunctions;
import Framework.TestSetup;
import Framework.Wait;
import Objects.EmployeeSelectTaskandDOB;
import Objects.GetTaskFromReferralDashboard;
import Validations.EntityValidations;
import prePlacement.Questionnaire.QST_Consent;
import prePlacement.Questionnaire.QST_Declaration;
import prePlacement.Questionnaire.GeneralHealthQuestionnaire.QST_GeneralHealthQST;
import scenarios.CreateReferral;
import testNGClasses.MyCustomListener;
import testRailSupport.UseAsTestRailId;

@Listeners(MyCustomListener.class)
public class GF_002_PP_AS_Pass_YOPmail extends TestSetup {
	// Declare driver, SoftAssert to be used in scenario
	protected SoftAssert sofas = new SoftAssert();
	CreateReferral CreateReferral;
	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;
	EntityValidations ReferralValidation;
	GetTaskFromReferralDashboard GetTaskFromReferralDashboard;
	EmployeeSelectTaskandDOB EmployeeSelectTaskandDOB;
	QST_Consent QST_Consent;
	QST_GeneralHealthQST QST_GeneralHealthQST;
	QST_Declaration QST_Declaration;
	OpenEmployeeQuestionnaire OpenEmployeeQuestionnaire;
	Wait Wait;

	@Test
	@UseAsTestRailId(testRailId = 35661, testRailTestRun = "Regression")
	public void Run_PP017_PP_AS_Pass_YOPmail()
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {

		CreateReferral = new CreateReferral(driver);
		LoginFunctions = new LoginFunctions(driver);
		BaseMethods = new BaseMethods(driver);
		GetTaskFromReferralDashboard = new GetTaskFromReferralDashboard(driver);
		EmployeeSelectTaskandDOB = new EmployeeSelectTaskandDOB(driver);
		QST_Consent = new QST_Consent(driver);
		QST_GeneralHealthQST = new QST_GeneralHealthQST(driver);
		ReferralValidation = new EntityValidations(driver);
		QST_Declaration = new QST_Declaration(driver);
		OpenEmployeeQuestionnaire = new OpenEmployeeQuestionnaire(driver);
		Wait = new Wait(driver);
		Wait WaitClass = new Wait(driver);

		String Service = "General _ PP";
		String ServiceLine = "Pre-Placement";
		String NeedEPP = "No";

		Properties prop = BaseMethods.GetPropertiesFIleData();

		LoginFunctions.loginAppian(prop.getProperty("OktaUrl"), prop.getProperty("OktaManagerUser"),
				prop.getProperty("OktaManagerPass"), prop.getProperty("OktaManagerPin"));

		String referralid = CreateReferral.CompleteReferralForms(ServiceLine, Service, NeedEPP);

		String EmpDOB = Objects.EmployeeDetails.EmployeeDOB;
		String EmpEmail = Objects.EmployeeDetails.CID + "@yopmail.com";
		System.out.println("Employee DOB is - " + EmpDOB);
		System.out.println("Employee Email is - " + EmpEmail);
		LoginFunctions.AppianLogout();

		ReferralValidation.GoToReferralDashboard(referralid, "Admin");
		ReferralValidation.AssertReferralData(ServiceLine, sofas);

		LoginFunctions.AppianLogout();

		OpenEmployeeQuestionnaire.GetEmplLoginURL(EmpDOB, EmpEmail);
		EmployeeSelectTaskandDOB.Run_EmployeeSelectTaskandDOB(EmpDOB);
		
		QST_Consent.CompleteConsent();
		QST_GeneralHealthQST.CompleteGHQ("Pass");
		QST_Declaration.CompleteEmpDeclaration();
		LoginFunctions.EmployeeAppianLogout();
		
		ReferralValidation.GoToReferralDashboard(referralid, "");
		
		ReferralValidation.CheckAssessmentData(ServiceLine, "PassGHQ", sofas);
	
		ReferralValidation.IsReportAvailable(referralid, Service, sofas);
		
		driver.findElement(By.xpath(BaseMethods.GenerateXpath("AdditionalDashboard", "Summary"))).click();
		
		ReferralValidation.AssertReferralInterventionStatus("Scrutiny", "PP Auto Scrutiny", "Closed", sofas);

		System.out.println("Scenario completed");

		sofas.assertAll();

	}

}
