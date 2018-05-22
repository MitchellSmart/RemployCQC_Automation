package Validations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Actions.ClickNavTab;
import Framework.AssertFun;
import Framework.BaseMethods;
import Framework.BrowserFunctions;
import Framework.LoginFunctions;
import Framework.PageObjectSetup;
import Framework.Wait;
import Objects.EmployeeDetails;


public class EntityValidations extends PageObjectSetup<EntityValidations> {

	WebDriverWait wait = new WebDriverWait(driver, 40);
	LoginFunctions LoginFunctions;
	ClickNavTab TempoTopNav;
	Wait Wait;
	AssertFun AssertFun;
	BaseMethods BaseMethods;
	BrowserFunctions BrowserFunctions;


	public EntityValidations(WebDriver driver) {
		super(driver);
		this.LoginFunctions = new LoginFunctions(driver);
		this.TempoTopNav = new ClickNavTab(driver);
		this.Wait = new Wait(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.AssertFun = new AssertFun(driver);
		this.BrowserFunctions = new BrowserFunctions(driver);

	}


	public void AssertReferralInterventionStatus(String InterventionType, String InterventionName, String Status,
			SoftAssert sofas) throws FileNotFoundException, InterruptedException {
		Wait.LongWait();
		driver.navigate().refresh();
		Wait.waitForPageLoaded(null);

		By Intervention_Status = By.xpath("((//tr[contains(.,'" + InterventionName + "')])//td[7]//p)[1]");
		By Scrutiny_Status = By.xpath("((//tr[contains(.,'" + InterventionName + "')])//td[3])//div");

		if ("Assessment".equalsIgnoreCase(InterventionType)) {
			String InterventionStatusXpath = "((//tr[contains(.,'" + InterventionName + "')])//td[7]//p)[1]";

			if ("Closed".equalsIgnoreCase(Status)) {

				String DashboardInterventionStatus = GetText(Intervention_Status);
				String ClosedInterventionStatus = BaseMethods.GetPropertiesFIleData()
						.getProperty("ClosedInterventionStatus");

				AssertFun.SoftAssertString(DashboardInterventionStatus, ClosedInterventionStatus, sofas);

				System.out.println("Intervention - " + InterventionName + " status is " + DashboardInterventionStatus);
			}

			else if ("Only closed".equalsIgnoreCase(Status)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InterventionStatusXpath)));
				String DashboardInterventionStatus = GetText(Intervention_Status);
				String ClosedInterventionStatus = BaseMethods.GetPropertiesFIleData()
						.getProperty("OnlyClosedInterventionStatus");

				AssertFun.SoftAssertString(DashboardInterventionStatus, ClosedInterventionStatus, sofas);

				System.out.println("Intervention - " + InterventionName + " status is " + DashboardInterventionStatus);
			}

			else if ("Withdrawn".equalsIgnoreCase(Status)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InterventionStatusXpath)));
				String DashboardInterventionStatus = driver.findElement(By.xpath(InterventionStatusXpath)).getText();
				String WithdrawnInterventionStatus = BaseMethods.GetPropertiesFIleData()
						.getProperty("WithdrawnInterventionStatus");

				AssertFun.SoftAssertString(DashboardInterventionStatus, WithdrawnInterventionStatus, sofas);

				System.out.println("Intervention - " + InterventionName + " status is " + DashboardInterventionStatus);
			}
		}

		else if ("Scrutiny".equalsIgnoreCase(InterventionType)) {
			String ScrutinyXpath = "((//tr[contains(.,'" + InterventionName + "')])//td[3])//div";

			if ("Closed".equalsIgnoreCase(Status)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ScrutinyXpath)));
				String DashboardInterventionStatus = GetText(Scrutiny_Status);
				String ClosedInterventionStatus = BaseMethods.GetPropertiesFIleData()
						.getProperty("ClosedScrutinyStatus");

				AssertFun.SoftAssertString(DashboardInterventionStatus, ClosedInterventionStatus, sofas);

				System.out.println("Scrutiny - " + InterventionName + " status is " + DashboardInterventionStatus);
			}

			if ("AwaitingScrutiny".equalsIgnoreCase(Status)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ScrutinyXpath)));
				String DashboardInterventionStatus = GetText(Scrutiny_Status);
				String InProgressInterventionStatus = BaseMethods.GetPropertiesFIleData()
						.getProperty("AwaitingScrutinyStatus");

				AssertFun.SoftAssertString(DashboardInterventionStatus, InProgressInterventionStatus, sofas);

				System.out.println("Scrutiny - " + InterventionName + " status is " + DashboardInterventionStatus);
			}
		}
	}

	public void AssertReferralStatus(String RefParameter, SoftAssert sofas) throws InterruptedException {

		driver.navigate().refresh();
		Wait.LongWait();

		if ("InProgress".equalsIgnoreCase(RefParameter)) {
			Wait.LongWait();

			String InProgressStepXpath = "//div[contains(text(), 'Current Step: ')]";
			String InProgressXpath = driver.findElement(By.xpath(InProgressStepXpath)).getAttribute("innerText");

			String InprogressStatus = InProgressXpath.replace("Current Step: ", "");

			AssertFun.SoftAssertString(InprogressStatus, "In progress", sofas);

			System.out.println("Current Status is - " + InprogressStatus + "Expected status - " + "In progress");
		}

		else if ("Pending Approval".equalsIgnoreCase(RefParameter)) {
			Wait.LongWait();

			String PendingApprovalStepXpath = "//div[contains(text(), 'Current Step: ')]";
			String PendingApprovalXpath = driver.findElement(By.xpath(PendingApprovalStepXpath))
					.getAttribute("innerText");

			String PendingApprovalStatus = PendingApprovalXpath.replace("Current Step: ", "");

			AssertFun.SoftAssertString(PendingApprovalStatus, "Pending Approval", sofas);

			System.out.println("Current Status is - " + PendingApprovalStatus);
		}

		else if ("Active Monitoring".equalsIgnoreCase(RefParameter)) {
			Wait.LongWait();

			String ActMonStepXpath = "//div[contains(text(), 'Current Step: ')]";
			String ActMonXpath = driver.findElement(By.xpath(ActMonStepXpath)).getAttribute("innerText");

			String ActMonStatus = ActMonXpath.replace("Current Step: ", "");

			AssertFun.SoftAssertString(ActMonStatus, "Active Monitoring", sofas);

			System.out.println("Current Status is - " + ActMonStatus);
		}

		else if ("Closed".equalsIgnoreCase(RefParameter)) {

			// Wait.LongWait();
			// commenting out for now due to know issue with referral not being closed after
			// scrutiny

			String CompletedStepXpath = "//div[contains(text(), 'Completed Step: ')]";
			String ActualStepXpath = "//div[contains(text(), 'Current Step: ')]";

			int CompletedStatusCount = driver.findElements(By.xpath(CompletedStepXpath)).size();

			String CompletedReferralStatus = driver.findElement(By.xpath("(//li/div[2])[" + CompletedStatusCount + "]"))
					.getAttribute("innerText").replace("Completed Step: ", "");

			if (!CompletedReferralStatus.contains("Closed")) {
				String ActualStatusXpath = driver.findElement(By.xpath(ActualStepXpath)).getAttribute("innerText");

				String ActualStatus = ActualStatusXpath.replace("Current Step: ", "");

				System.out.println("Referral Status is - " + ActualStatus);

				AssertFun.SoftAssertString(ActualStatus, "Closed - all interventions complete", sofas);
			} else {
				System.out.println("Referral Status is - " + CompletedReferralStatus);
				AssertFun.SoftAssertString(CompletedReferralStatus, "Closed - all interventions complete", sofas);
			}
		}

		else if ("Withdrawn".equalsIgnoreCase(RefParameter)) {

			String CompletedStepXpath = "//div[contains(text(), 'Completed Step: ')]";
			String ActualStepXpath = "//div[contains(text(), 'Current Step: ')]";

			WaitForPresenceOf(By.xpath(CompletedStepXpath), 20);

			int CompletedStatusCount = driver.findElements(By.xpath(CompletedStepXpath)).size();

			String CompletedReferralStatus = driver.findElement(By.xpath("(//li/div[2])[" + CompletedStatusCount + "]"))
					.getAttribute("innerText").replace("Completed Step: ", "");

			if (!CompletedReferralStatus.contains("Withdrawn")) {
				String ActualStatusXpath = driver.findElement(By.xpath(ActualStepXpath)).getAttribute("innerText");

				String ActualStatus = ActualStatusXpath.replace("Current Step: ", "");

				System.out.println("Referral Status is - " + ActualStatus);

				AssertFun.SoftAssertString(ActualStatus, "Withdrawn - time out", sofas);
			} else {
				System.out.println("Referral Status is - " + CompletedReferralStatus);
				AssertFun.SoftAssertString(CompletedReferralStatus, "Withdrawn", sofas);
			}
		}
	}


	public void AssertInterventionStatus(String InterventionType, SoftAssert sofas)
			throws InterruptedException, FileNotFoundException {
		Wait.waitForPageLoaded(null);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("AdditionalDashboard", "Summary"))));
		BrowserFunctions.clickElement(
				driver.findElement(By.xpath(BaseMethods.GenerateXpath("AdditionalDashboard", "Summary"))));

		// BaseMethods.jse.executeScript("scroll(0, -2000);");

		// For Closed intervention status
		if ("Scrutiny".equalsIgnoreCase(InterventionType)) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", "Scrutiny Id"))));
			driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", "Scrutiny Id"))).click();
			Wait.WaitForTime(6000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(BaseMethods.GetPropertiesFIleData().getProperty("ScrutinyStatusXpath"))));
			String DashboardInterventionStatus = driver
					.findElement(By.xpath(BaseMethods.GetPropertiesFIleData().getProperty("ScrutinyStatusXpath")))
					.getText();
			String ClosedInterventionStatus = BaseMethods.GetPropertiesFIleData().getProperty("ClosedScrutinyStatus");

			AssertFun.SoftAssertString(DashboardInterventionStatus, ClosedInterventionStatus, sofas);

			System.out.println("Interventions status: expected: " + ClosedInterventionStatus + " Actual"
					+ DashboardInterventionStatus);

		}

		else if ("AwaitingScrutiny".equalsIgnoreCase(InterventionType)) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(BaseMethods.GenerateXpath("Link", "Scrutiny Id"))));
			driver.findElement(By.xpath(BaseMethods.GenerateXpath("Link", "Scrutiny Id"))).click();
			Wait.WaitForTime(6000);

			String DashboardInterventionStatus = driver
					.findElement(By.xpath(BaseMethods.GetPropertiesFIleData().getProperty("ScrutinyStatusXpath")))
					.getText();
			String InProgressScrutinyStatus = BaseMethods.GetPropertiesFIleData().getProperty("AwaitingScrutinyStatus");

			AssertFun.SoftAssertString(DashboardInterventionStatus, InProgressScrutinyStatus, sofas);

			System.out.println("Interventions status: expected: " + InProgressScrutinyStatus + " Actual"
					+ DashboardInterventionStatus);

		}

		else if ("PendingBooking".equalsIgnoreCase(InterventionType)) {
			// Assert FTF intervention status in pending appointment booking
			String DashboardInterventionStatus = driver
					.findElement(By.xpath(BaseMethods.GetPropertiesFIleData().getProperty("InterventionStatusXpath")))
					.getText();

			String PendingBookingInterventionStatus = BaseMethods.GetPropertiesFIleData()
					.getProperty("PendingBookingInerventionStatus");

			AssertFun.SoftAssertString(DashboardInterventionStatus, PendingBookingInterventionStatus, sofas);

			System.out.println("Interventions status: expected: " + PendingBookingInterventionStatus + " Actual"
					+ DashboardInterventionStatus);
		}

		else {
			String DashboardInterventionStatus = driver
					.findElement(By.xpath(BaseMethods.GetPropertiesFIleData().getProperty("InterventionStatusXpath")))
					.getText();
			String ClosedInterventionStatus = BaseMethods.GetPropertiesFIleData()
					.getProperty("ClosedInterventionStatus");

			AssertFun.SoftAssertString(DashboardInterventionStatus, ClosedInterventionStatus, sofas);
			System.out.println("Interventions status: expected: " + ClosedInterventionStatus + " Actual"
					+ DashboardInterventionStatus);

		}

	}


	// Method to get the employee's Details. Pre requisite is that the user must be
	// on referral dashboard
	public String GetLocationId() {

		String LocationId = driver.findElement(By.xpath("//*[contains(@class, 'TitleText---page_header')]/text()[1]")).getText();
		System.out.println(LocationId);
		return LocationId;
	}
}
