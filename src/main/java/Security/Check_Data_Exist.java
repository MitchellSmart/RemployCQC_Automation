package Security;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Actions.ClickNavTab;
import Framework.BaseMethods;
import Framework.Buttons;
import Framework.LoginFunctions;
import Framework.PageObjectSetup;

public class Check_Data_Exist extends PageObjectSetup<Check_Data_Exist> {

	LoginFunctions LoginFunctions;
	BaseMethods BaseMethods;
	ClickNavTab TempoTopNav;
	Webelement_Operations Webelement_Operations;
	Buttons Buttons;

	protected By NoData = By.xpath("//div[contains(text(),'No ')]");
	protected By ReportLink = By.xpath("//a[contains(text(),'Full Report')]");
	protected By NoReferralSearch = By.xpath(
			"//div[contains(text(),'The referral id you entered is invalid or you do not have access to this referral')]");

	public Check_Data_Exist(WebDriver driver) {
		super(driver);
		Webelement_Operations = new Webelement_Operations(driver);
		BaseMethods = new BaseMethods(driver);
		TempoTopNav = new ClickNavTab(driver);
		Buttons = new Buttons(driver);
		// TODO Auto-generated constructor stub
	}

	// To check if the referral exists in the Record view
	public void Check_Referral_Exist(String ServiceLineName, SoftAssert sofas)
			throws InterruptedException, FileNotFoundException {
		By SL_Link = By.xpath("//a[contains(text(),'" + ServiceLineName + "')]");
		Click(SL_Link);
		System.out.println("Clicked " + ServiceLineName + " Record");

		if (Webelement_Operations.IsElementPresent(NoData)) {
			String NoDataText = GetText(NoData);
			System.out.println("Data is - " + NoDataText);
		}

		else {
			System.out.println("Referrals are Available");
			sofas.assertEquals("Expected - No Referrals", "Referrals available");
		}

	}

	// To check if the report exists on the documents additional dashboard for the
	// manager
	public void Check_Report_Exist(String ExpectedReport_Yes_No, SoftAssert sofas) throws InterruptedException {
		if ("No".equalsIgnoreCase(ExpectedReport_Yes_No)) {
			if (Webelement_Operations.IsElementPresent(NoData)) {
				String NoDataText = GetText(NoData);
				System.out.println("Status is - " + NoDataText);
			}
			
			else {
				System.out.println("Reports are Available");
				sofas.assertEquals("Reports are available", "No Reports shown");
			}
		} else {
			if (!Webelement_Operations.IsElementPresent(NoData)) {
				String NoDataText = GetText(ReportLink);
				System.out.println("Report is available - " + NoDataText);
			}

			else {
				System.out.println("No Report Avaiable");
				sofas.assertEquals("Reports not available", "Reports must be shown");
			}
		}
	}

	// To Check if the referral is searched using Search All Referrals. Add No as Searched_NotSearched if you want the test to be passed if no referral is available
	public void Check_Referral_Searched(String ReferralID, SoftAssert sofas, String Searched_NotSearched)
			throws InterruptedException, ClassNotFoundException, IOException, SQLException {
		String SearchReferralLinkName = "All Referrals Search";
		By RefIDPlaceholderXpath = By.xpath("(//label[contains(text(),'Referral Id')]/../..//input)[3]");

		By Search_Referral_link = By.xpath("(//a[contains(text(), '" + SearchReferralLinkName + "')])[1]");

		TempoTopNav.GoToAppianTabs("Actions");

		Click(Search_Referral_link);

		Send(ReferralID, RefIDPlaceholderXpath);

		Buttons.ClickButton("Search");
		
		if("No".equalsIgnoreCase(Searched_NotSearched))
		{
			if (Webelement_Operations.IsElementPresent(NoReferralSearch)) {
				System.out.println("Searched Referral not available. \nThe grid text is - " + GetText(NoReferralSearch));
			} else {
				System.out.println("Referrals are Available");
				sofas.assertEquals("No Referral", "Referral is available");
			}
		}
		
		else
		{
			if (!Webelement_Operations.IsElementPresent(NoReferralSearch)) {
				System.out.println("Searched Referral is Available");
				//System.out.println("Searched Referral not available. \nThe grid text is - " + GetText(NoReferralSearch));
			} else {
				System.out.println("The grid text is - " + GetText(NoReferralSearch));
				sofas.assertEquals("No Referral", "Referral is available");
			}
			
		}
	}
	
	// To check if the record type exist
	public void Check_Link_Exist(String LinkLabel, SoftAssert sofas) throws InterruptedException {
		By Record = By.xpath("//a[text()='" + LinkLabel + "']");
		
		if (!Webelement_Operations.IsElementPresent(Record)) {
			System.out.println(LinkLabel + " Link not available");
		} else {
			System.out.println(LinkLabel + " Link Available");
			sofas.assertEquals(LinkLabel + " Link shown", "No " + LinkLabel + " Link shown");
		}
	}
}
