package scenarios.CombinedWorkflows;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Actions.ClickAction;
import Actions.ClickNavTab;
import Actions.ClickRecord;
import Actions.ClickViewLink;
import Events.AddEvent;
import Events.ChaseInspectorForApproval;
import Events.ConfirmEventAttendance;
import Events.ConfirmExEAvailability;
import Events.ConfirmInspectorApprovalofExE;
import Events.ConfirmSWAvailability;
import Events.ConfirmationOfReportSentCQC;
import Events.ContactExEOutcomeofReport;
import Events.EventAttendanceProcess;
import Events.ExEFeedbackforEvent;
import Events.ExEPerformanceFeedback;
import Events.GetEventId;
import Events.InspectorFeedbackforEvent;
import Events.IssueCommunicationtoExE;
import Events.MatchExEtoEvent;
import Events.MatchSWtoEvent;
import Events.ObtainReportfromExEforReview;
import Events.ReviewReportTask;
import Events.SelectEventFromInspection;
import Events.SelectSupplierForEvent;
import Events.SendDetailsToInspector;
import Events.UploadPenP;
import Framework.BaseMethods;
import Framework.LoginFunctions;
import Framework.TestSetup;
import Framework.Wait;
import Inspection.CreateNewInspectionForm;
import Objects.GenerateRandomData;
import Validations.FindSWRequirment;
import Validations.InspectionValidation_Static;
import testNGClasses.MyCustomListener;
import testRailSupport.UseAsTestRailId;

@Listeners(MyCustomListener.class)
public class Creation_001_InspectionWithMatchedEvents extends TestSetup {

	// Declare global variables including classes that will be used in this
	// execution
	protected SoftAssert sofas = new SoftAssert();
	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;
	ClickRecord ClickRecord;
	ClickNavTab ClickNavTab;
	AddEvent AddEvent;
	ClickViewLink ClickViewLink;
	GetEventId GetEventId;
	ClickAction ClickAction;
	SelectEventFromInspection SelectEventFromInspection;
	CreateNewInspectionForm CreateNewInspectionForm;
	InspectionValidation_Static InspectionValidation_Static;
	Wait Wait;
	SelectSupplierForEvent SelectSupplierForEvent;
	MatchExEtoEvent MatchExEtoEvent;
	ConfirmExEAvailability ConfirmExEAvailability;
	UploadPenP UploadPenP;
	SendDetailsToInspector SendDetailsToInspector;
	ChaseInspectorForApproval ChaseInspectorForApproval;
	ConfirmInspectorApprovalofExE ConfirmInspectorApprovalofExE;
	FindSWRequirment FindSWRequirment;
	MatchSWtoEvent MatchSWtoEvent;
	ConfirmSWAvailability ConfirmSWAvailability;
	IssueCommunicationtoExE IssueCommunicationtoExE;
	ConfirmEventAttendance ConfirmEventAttendance;
	EventAttendanceProcess EventAttendanceProcess;
	ObtainReportfromExEforReview ObtainReportfromExEforReview;
	ReviewReportTask ReviewReportTask;
	ContactExEOutcomeofReport ContactExEOutcomeofReport;
	ConfirmationOfReportSentCQC ConfirmationOfReportSentCQC;
	InspectorFeedbackforEvent InspectorFeedbackforEvent;
	ExEFeedbackforEvent ExEFeedbackforEvent;
	ExEPerformanceFeedback ExEPerformanceFeedback;

	@Test
	@UseAsTestRailId(testRailId = 40856, testRailTestRun = "Regression")
	public void Run_Creation_001_InspectionWithMatchedEvents() throws Exception {

		LoginFunctions = new LoginFunctions(driver);
		BaseMethods = new BaseMethods(driver);
		ClickRecord = new ClickRecord(driver);
		ClickNavTab = new ClickNavTab(driver);
		AddEvent = new AddEvent(driver);
		ClickAction = new ClickAction(driver);
		ClickViewLink = new ClickViewLink(driver);
		GetEventId = new GetEventId(driver);
		CreateNewInspectionForm = new CreateNewInspectionForm(driver);
		SelectEventFromInspection = new SelectEventFromInspection(driver);
		InspectionValidation_Static = new InspectionValidation_Static(driver);
		SelectSupplierForEvent = new SelectSupplierForEvent(driver);
		Wait = new Wait(driver);
		MatchExEtoEvent = new MatchExEtoEvent(driver);
		ConfirmExEAvailability = new ConfirmExEAvailability(driver);
		UploadPenP = new UploadPenP(driver);
		SendDetailsToInspector = new SendDetailsToInspector(driver);
		ChaseInspectorForApproval = new ChaseInspectorForApproval(driver);
		ConfirmInspectorApprovalofExE = new ConfirmInspectorApprovalofExE(driver);
		FindSWRequirment = new FindSWRequirment(driver);
		MatchSWtoEvent = new MatchSWtoEvent(driver);
		ConfirmSWAvailability = new ConfirmSWAvailability(driver);
		IssueCommunicationtoExE = new IssueCommunicationtoExE(driver);
		ConfirmEventAttendance = new ConfirmEventAttendance(driver);
		EventAttendanceProcess = new EventAttendanceProcess(driver);
		ObtainReportfromExEforReview = new ObtainReportfromExEforReview(driver);
		ReviewReportTask = new ReviewReportTask(driver);
		ContactExEOutcomeofReport = new ContactExEOutcomeofReport(driver);
		ConfirmationOfReportSentCQC = new ConfirmationOfReportSentCQC(driver);
		InspectorFeedbackforEvent = new InspectorFeedbackforEvent(driver);
		ExEFeedbackforEvent = new ExEFeedbackforEvent(driver);
		ExEPerformanceFeedback = new ExEPerformanceFeedback(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		LoginFunctions.loginAppian(BaseMethods.GetPropertiesFIleData().getProperty("URL"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminUsername"),
				BaseMethods.GetPropertiesFIleData().getProperty("RemployAdminPassword"));


		ClickNavTab.GoToAppianTabs("Actions");
		ClickAction.Run_ClickAction("Create New Inspection");
		
		boolean SWRequirement = false;
		String InspectionID = "";
		String[] NewData = GenerateRandomData.GenerateRandomInspectionData();
		Objects.InspectionDetails.INSnumberV = NewData[0];
		Objects.InspectionDetails.CCGnameV = NewData[1];
	
		//Create Inspection
		CreateNewInspectionForm.Run_CreateNewInspectionForm();
		ClickViewLink.Run_ClickViewLink("Inspection Record");
		InspectionID = InspectionValidation_Static.Run_InspectionValidation_Static(InspectionID, sofas);
		
		//Add Event
		AddEvent.Run_AddEvent();
		String EventID = GetEventId.Run_GetEventId();
		ClickViewLink.Run_ClickViewLink("Inspection Record");
		SelectEventFromInspection.Run_SelectEventFromInspection(EventID);
		
		//Select Supplier
		Wait.ClickTask("Inspection - Select a Supplier (Id: " + EventID + ")", driver);
		SelectSupplierForEvent.Run_SelectSupplierForEvent(EventID);
		ClickViewLink.Run_ClickViewLink("Event Record");
		
		//ExE Matching
		Wait.ClickTask("Inspection - EXE Matching Process (Id: " + EventID + ")", driver);
		MatchExEtoEvent.Run_MatchExEtoEvent();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);;
	
		// complete exe availability tasks
		Wait.ClickTask("Inspection - Confirm EXE Availability (Id: " + EventID + ")", driver);
		ConfirmExEAvailability.Run_ConfirmExEAvailability();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
		
		//Assert Inspection ID - ExE ID and ExE support worker requirement
		SWRequirement = FindSWRequirment.Run_FindSWRequirment(InspectionID, SWRequirement);
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
		
		//complete pen portrait upload tasks/
		Wait.ClickTask("Inspection - Chase EXE for Updated Pen Portrait and COI Form (Id: " + EventID + ")", driver);
		UploadPenP.Run_UploadPenP();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
	
		//complete confirmation workflow 
		// Send ExE details to inspector
		Wait.ClickTask("Inspection - Send ExE Details to Inspector (Id: 1763)", driver);
		SendDetailsToInspector.Run_SendDetailsToInspector();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
		
		// Get approval from inspector
		Wait.ClickTask("Inspection - Chase Inspector for ExE Approval (Id:", driver);
		ChaseInspectorForApproval.Run_ChaseInspectorForApproval();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
		
		//Confirm approval from inspector
		Wait.ClickTask("Inspection - Confirm Inspector Approval of ExE (Id: " + EventID + ")", driver);
		ConfirmInspectorApprovalofExE.Run_ConfirmInspectorApprovalofExE();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
		
		if(SWRequirement == true) {
			Wait.ClickTask("Inspection - Support Worker Matching Process (Id: " + EventID + ")", driver);
			MatchSWtoEvent.Run_MatchSWtoEvent();
			ClickNavTab.GoToAppianTabs("Records");
			ClickRecord.Run_ClickRecord("Events");
			ClickAction.Run_ClickAction(EventID);
		
			// complete exe matching tasks
			Wait.ClickTask("Inspection - Confirm Support Worker Availability (Id: " + EventID + ")", driver);
			ConfirmSWAvailability.Run_ConfirmSWAvailability();
			ClickNavTab.GoToAppianTabs("Records");
			ClickRecord.Run_ClickRecord("Events");
			ClickAction.Run_ClickAction(EventID);		
			}
		
		//complete communication issue task
		Wait.ClickTask("nspection - Issue Communication to EXE Regarding Approval for Event (Id: ", driver);
		IssueCommunicationtoExE.Run_IssueCommunicationtoExE();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);;
		
		//confirm event attendance
		Wait.ClickTask("Inspection - Confirm Event Attendance (Id: " + EventID + ")", driver);
		ConfirmEventAttendance.Run_ConfirmEventAttendance();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);;
		
		//Event Attendance process
		Wait.ClickTask("Inspection - Event Attendance Process (Id: " + EventID + ")", driver);
		EventAttendanceProcess.Run_EventAttendanceProcess();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
	
		//Obtain Report from ExE for review
		Wait.ClickTask("Inspection - Obtain Report from EXE for Review (Id: " + EventID + ")", driver);
		ObtainReportfromExEforReview.Run_ObtainReportfromExEforReview();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
				
		//Review Report task
		Wait.ClickTask("Inspection - Review Report Task (Id: " + EventID + ")", driver);
		ReviewReportTask.Run_ReviewReportTask();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
				
		//Communication for outcome of report
		Wait.ClickTask("Inspection - Contact EXE Regarding Outcome of Report Review (Id: ", driver);
		ContactExEOutcomeofReport.Run_ContactExEOutcomeofReport();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
				
		//Confirmation for report sent to CQC
		Wait.ClickTask("Inspection - Confirm EXE has sent Report to CQC (Id: "+ EventID + ")", driver);
		ConfirmationOfReportSentCQC.Run_ConfirmationOfReportSentCQC();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
				
		
		//Capture feedback from inspector and ExE
		Wait.ClickTask("Inspection - Capture Event Feedback by Inspector (Id: ", driver);
		InspectorFeedbackforEvent.Run_InspectorFeedbackforEvent();
		Wait.ClickTask("Inspection - Capture Event Feedback by ExE (Id: ", driver);
		ExEFeedbackforEvent.Run_ExEFeedbackforEvent();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
				
		//Complete Inspection Performance feedback
		Wait.ClickTask("Inspection - Performance Feedback Form", driver);
		ExEPerformanceFeedback.Run_ExEPerformanceFeedback();
		ClickNavTab.GoToAppianTabs("Records");
		ClickRecord.Run_ClickRecord("Events");
		ClickAction.Run_ClickAction(EventID);
				
		//ASSERT THAT IT IS CLOSED
		
		
		LoginFunctions.AppianLogout();
		System.out.println("Scenario completed");
		sofas.assertAll();

	}
}
