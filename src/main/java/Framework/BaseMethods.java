package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods extends PageObjectSetup<BaseMethods> {

	WebDriverWait wait = new WebDriverWait(driver, 40);

	public BaseMethods(WebDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
	}

	// Read the Properties file from a fixed location
	public Properties ReadPropertiesFile() throws FileNotFoundException {
		String prop = "src/main/resources/Config.properties";
		
		Properties props = new Properties();
		
		FileInputStream fis = new FileInputStream(new File(prop));
		
		try {
			props.load(fis);
		}

		catch (IOException e) {
			System.out.println("Something went wrong!");
		}

		return props;

	}

	// Use the instance of ReadProperties file and return a properties type object
	// which can be used
	// as a string like prop.getProperty("KEY_NAME")
	public Properties GetPropertiesFIleData() throws FileNotFoundException {
		Properties Prop = ReadPropertiesFile();
		return Prop;
	}

	// Generic Method which will generate the xpaths by giving Field Type and Label
	// as its input.
	// It will be used for Appian's generic ocmponenents which will not require any
	// index.
	// Those outputs which has [1] in it means if there are multiple elements with
	// the same label then
	// it will always pick the 1st one.
	public String GenerateXpath(String FieldType, String FieldLabel) {
		// For Appian's button component
		if (FieldType.equalsIgnoreCase("Button")) {
			String BtnXpath = "//button[contains(text(), '" + FieldLabel + "')]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BtnXpath)));
			return BtnXpath;
		}
		else if (FieldType.equalsIgnoreCase("ExactButton")) {
			String BtnXpath = "//button[(text()= '" + FieldLabel + "')]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BtnXpath)));
			return BtnXpath;
		}
		// For Appian's link component having a label
		else if (FieldType.equalsIgnoreCase("Link")) {
			String LinkXpath = "(//a[contains(text(), '" + FieldLabel + "')])[1]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LinkXpath)));
			return LinkXpath;
		}

		// For Appian's Textfield component having a label associated with it
		else if (FieldType.equalsIgnoreCase("TextField")) {
			String TextFieldXpath = "(//label[contains(text(),'" + FieldLabel + "')]/../..//input)[1]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TextFieldXpath)));
			return TextFieldXpath;
		}
		// For Appian's Paragraph component having a label associated with it
		else if (FieldType.equalsIgnoreCase("Paragraph")) {
			String ParagraphXpath = "//label[contains(text() ,'" + FieldLabel + "')]/../..//textarea";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ParagraphXpath)));
			return ParagraphXpath;
		}
		// For Appian's Additional Dashboard/Facet component having a label associated
		// with it
		else if (FieldType.equalsIgnoreCase("AdditionalDashboard")) {
			String ADxpath = "//span[text() = '" + FieldLabel + "']";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADxpath)));
			return ADxpath;
		}
		// For Appian's Strong/Bold component having a label associated with it
		else if (FieldType.equalsIgnoreCase("Strong")) {
			String StrongXpath = "//strong[contains(text(), '" + FieldLabel + "')]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StrongXpath)));
			return StrongXpath;
		}
		// For Appian's Rea Only label component
		else if (FieldType.equalsIgnoreCase("ReadOnlyLabel")) {
			String StrongXpath = "(//span[contains(text(), '" + FieldLabel + "')]//../..//p)[1]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StrongXpath)));
			return StrongXpath;
		}
		// For Appian's Section expand component like collapsing/maximizing the section
		// in right side of section
		else if (FieldType.equalsIgnoreCase("SectionExpand")) {
			String ExpandXpath = "//h3[contains(text(), '" + FieldLabel + "')]/../..//a[@title='Expand']";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExpandXpath)));
			return ExpandXpath;
		}
		// For Appian's Selection grid component by passing its fiest column content as
		// input
		else if (FieldType.equalsIgnoreCase("SelectionGrid")) {
			String SelectedXpath = "(//tr[td//text()[contains(., '" + FieldLabel + "')]]//td[1]//input)";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectedXpath)));
			return SelectedXpath;
		}
		// For Appian's paragraph field in a grid component having a label associated
		// with it
		else if (FieldType.equalsIgnoreCase("TableTextArea")) {
			String SelectedXpath = "(//td[contains(.,'" + FieldLabel + "')])/../..//textarea";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectedXpath)));
			return SelectedXpath;
		}
		// used to select a Case Management referral ID on Return Referral(s) back to
		// Case Manager screen
		else if (FieldType.equalsIgnoreCase("SelectReferralForCM")) {
			String SelectedXpath = "(//td[contains(.,'" + FieldLabel + "')])/../..//input";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectedXpath)));
			return SelectedXpath;
		}
		// Used for checking a checkbox in a grid by passing in first column content
		// like Select service line/service
		else if (FieldType.equalsIgnoreCase("SelectServiceorServiceline")) {
			String ServiceOrServiceLineXpath = "//tr[td//text()='" + FieldLabel + "']//td[1]//input";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ServiceOrServiceLineXpath)));
			return ServiceOrServiceLineXpath;
		}
		// For Appian's Checkbox field in a grid component having a label associated
		// with it
		else if (FieldType.equalsIgnoreCase("CheckBox")) {
			String Checkboxxpath = "//label[contains(text(),'" + FieldLabel + "')]/..//input";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Checkboxxpath)));
			return Checkboxxpath;
		}
		// For practitioner comment field while reviewing the questionnaire by passing
		// in the first column content as input
		else if (FieldType.equalsIgnoreCase("PractitionerComment")) {
			String PractComments = "(//tr[contains(.,'" + FieldLabel + "')]//td[3])//input";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PractComments)));
			return PractComments;
		}
		// For imms confirm date xpath by passing in Procedure's name on Imms confirm
		// next actions task
		else if (FieldType.equalsIgnoreCase("ImmsConfirmDueDate")) {
			String ImmsDueDateField = "//strong[contains(text(), '" + FieldLabel + "')]/../..//em";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ImmsDueDateField)));
			return ImmsDueDateField;
		}
		// For Appian's button field by passing in the exact label of the button and not
		// the partial match

		// For Appian's h2 field i.e. getting form title
		else if (FieldType.equalsIgnoreCase("h2")) {
			String headingXpath = "//h2[text()='" + FieldLabel + "']";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(headingXpath)));
			return headingXpath;
		}

		return "Invalid input for getting the xpaths. Please check GenerateXpath method definition";
	}

	// Generating the Xpaths for complex webelements such as Radio buttons and
	// checkboxes having indexes as well
	public String GenerateComplexXpath(String FieldType, String FieldLabel, int index) {

		// For Appian's Radio button or checkbox component having a label associated
		// with it and providing the index
		// Like Yes is at 1 and No is 2 then index for Yes will be 1 and 2 for No
		if (FieldType.equalsIgnoreCase("Radiobtn") || FieldType.equalsIgnoreCase("CheckBox")) {
			String EleXpath = "(//label[contains(text(),'" + FieldLabel + "')]/../..//input)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EleXpath)));
			return EleXpath;
		}
		// For any input field in a grid then by passing the column header name and
		// position as index in input
		// used only for entering the Batch numbers in Imms general assessment
		else if (FieldType.equalsIgnoreCase("TableInput")) {
			String EleXpath = "(//tr[td//text()[contains(., '" + FieldLabel + "')]]//td[" + index + "]//input)";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EleXpath)));
			return EleXpath;
		}
		// For Appian's Radio button or checkbox component having a label associated
		// with it and providing the index
		// Like Yes is at 1 and No is 2 then index for Yes will be 1 and 2 for No. This
		// was created on the basis of
		// Appian's complex DOM structure.
		else if (FieldType.equalsIgnoreCase("RadioGrid")) {
			String EleXpath = "(//label[text()='" + FieldLabel + "']/..//input)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EleXpath)));
			return EleXpath;
		}

		else if (FieldType.equalsIgnoreCase("ReadOnly")) {
			String LinkXpath = "(//span[text()='" + FieldLabel + "']/../..//p)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LinkXpath)));
			return LinkXpath;
		}

		// For Appian's Radio button or checkbox component having a label in span
		// associated with it and providing the index
		// Like Yes is at 1 and No is 2 then index for Yes will be 1 and 2 for No
		else if (FieldType.equalsIgnoreCase("SpanRadiobtn") || FieldType.equalsIgnoreCase("SpanCheckBox")) {
			String EleXpath = "(//span[contains(text(),'" + FieldLabel + "')]/../..//input)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EleXpath)));
			return EleXpath;
		}
		// For Appian's dropdown field by entering the drop down label as input and
		// index
		// on which the value is available in dropdown.
		else if (FieldType.equalsIgnoreCase("DropDown")) {
			String DpDownXpath = "//span[contains(text(),'" + FieldLabel + "')]/../..//option[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DpDownXpath)));
			return DpDownXpath;
		}
		// If there are multiple links with same labels then passing in the index on
		// which script will click
		else if (FieldType.equalsIgnoreCase("DuplicateLink")) {
			String LinkXpath = "(//a[contains(text(),'" + FieldLabel + "')])[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LinkXpath)));
			return LinkXpath;
		}
		// Pass in the direct option value of dropdown. Usually index will be 1 here
		else if ("HardCodeDropDown".equalsIgnoreCase(FieldType) || "ExactLink".equalsIgnoreCase(FieldType)) {
			String Checkboxxpath = "(//option[text()='" + FieldLabel + "'])[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Checkboxxpath)));
			return Checkboxxpath;
		}
		// Clicking on a div element which has some label then that label will be passed
		// in as input and
		// if there are multiple divs with same label then pass in the index for the
		// same.
		else if (FieldType.equalsIgnoreCase("div")) {
			String divXpath = "(//div[contains(text(), '" + FieldLabel + "')])[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(divXpath)));
			return divXpath;
		}
		// If there are multiple Appian's paragraph field having same labels then pass
		// in the label of paragraph
		// and index which needs to be populated
		else if (FieldType.equalsIgnoreCase("Textarea")) {
			String textAreaXpath = "(//label[contains(text(), '" + FieldLabel + "')]/../..//textarea)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textAreaXpath)));
			return textAreaXpath;
		}

		return "Invalid input for getting the xpaths. Please check GenerateComplexXpath method definition";
	}

	// Xpath for Practitioner Assessments web elements
	public String AssessmentXpath(String FieldType, String FieldLabel, int index) {

		// For generic questionnaire framework to populate the paragraph field by
		// passing in the first
		// column content as input and index on which the element is located
		if (FieldType.equalsIgnoreCase("TextArea")) {
			String TextAreaXpath = "((//td[contains(.,'" + FieldLabel + "')])/../..//textarea)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TextAreaXpath)));
			return TextAreaXpath;
		}
		// For generic questionnaire framework to populate the radio button field by
		// passing in the first
		// column content as input and index on which the element is located
		else if (FieldType.equalsIgnoreCase("RadioBtn")) {
			String RadioBtnXpath = "((//td[contains(.,'" + FieldLabel + "')])/../..//input)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RadioBtnXpath)));
			return RadioBtnXpath;
		}
		// For generic questionnaire framework to populate the drop down field by
		// passing in the first
		// column content as input and index on which the option in dropdown is located
		else if (FieldType.equalsIgnoreCase("DropDown")) {
			String DpDownXpath = "((//td[contains(.,'" + FieldLabel + "')])/../..//option)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DpDownXpath)));
			return DpDownXpath;

		}

		return "Invalid input for getting the xpaths. Please check AssessmentXpath method definition";
	}

	// Used to find the xpath of FFT Tests links which is shown at the bottom of the
	// screen.
	// Pass in the name of the test you want to click upon
	public String GetTestLinkXpath(String Label) {
		String TestLinkXpath = "//h3[contains(text(),'Following test')]/../..//a[text()='" + Label + "']";
		return TestLinkXpath;
	}

	// Reading the assessment data on the referral dashboard after clicking on view
	// assessment data link
	public String GetAssessmentDataonDashboard(String FieldLabel) {
		String AssessmentXpath = "(//label[text()='" + FieldLabel + "']/../..//div)[4]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AssessmentXpath)));
		return AssessmentXpath;
	}

	public String getAssessmentScreenXpaths(String FieldType, String FieldLabel, int index) {

		if (FieldType.equalsIgnoreCase("RadioBtn")) {
			String AssessmentRadioBtnXpath = "(//tr[contains(.,'" + FieldLabel + "')][1]//td[2]//input)[" + index + "]";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AssessmentRadioBtnXpath)));
			return AssessmentRadioBtnXpath;
		}
		return "Invalid input for getting the xpaths. Please check getAssessmentScreenXpaths method definition.";
	}

	// Method to upload document without Grid Label. Just pass in the index at which
	// the upload field grid is available
	public String UploadDocWithoutGridLabel(int trIndex) throws InterruptedException {
		String UploadXpath = "(//tr)[" + trIndex + "]/td[1]//input[3]";
		return UploadXpath;
	}

}