package Framework;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateTimeMethods extends PageObjectSetup<DateTimeMethods> {
	Wait waitClass;
	Buttons Buttons;
	BaseMethods BaseMethods;
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public DateTimeMethods(WebDriver driver) {
		super(driver);
		this.waitClass = new Wait(driver);
		this.Buttons = new Buttons(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}

	// Generic Method to generate the Date by giving Date field label and Date as
	// input
	public void populateDate(String dateFieldName, String date) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String DateXpath = "(//label[text()='" + dateFieldName + "']/../..//input)[1]";

		String dateFieldId = driver.findElement(By.xpath(DateXpath)).getAttribute("id");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateXpath)));

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').focus()");
		}
		driver.findElement(By.id(dateFieldId)).sendKeys(date);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').blur()");
		}

	}
	
	public void populateDateWithDateXpathIndex(String dateFieldName, String date,int index) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String DateXpath = "(//label[text()='" + dateFieldName + "']/../..//input)["+index+"]";

		String dateFieldId = driver.findElement(By.xpath(DateXpath)).getAttribute("id");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateXpath)));

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').focus()");
		}
		driver.findElement(By.id(dateFieldId)).sendKeys(date);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').blur()");
		}

	}

	public void populateDateLongLabel(String dateFieldName, String date) {
		String DateXpath = "(//label[contains(text(), '" + dateFieldName + "')]/../..//input)[1]";

		String dateFieldId = driver.findElement(By.xpath(DateXpath)).getAttribute("id");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateXpath)));

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').focus()");
		}
		driver.findElement(By.id(dateFieldId)).sendKeys(date);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').blur()");
		}

	}

	// Method to populate Date Field
	public void populateBookingDateTimeDate(String dateFieldName, String date, String time)
			throws InterruptedException {

		String DateXpath = "(//span[text()='" + dateFieldName + "']/../..//input)[1]";
		String TimeXpath = "(//span[text()='" + dateFieldName + "']/../..//input)[2]";

		String dateFieldId = driver.findElement(By.xpath(DateXpath)).getAttribute("id");

		String timeFieldId = driver.findElement(By.xpath(TimeXpath)).getAttribute("id");

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').focus()");
		}
		driver.findElement(By.id(dateFieldId)).sendKeys(date);
		Thread.sleep(2000);
		driver.findElement(By.id(dateFieldId)).sendKeys(Keys.TAB);

		Thread.sleep(4000);

		driver.findElement(By.id(timeFieldId)).sendKeys(time);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').blur()");
		}
	}

	// Generic Method to generate the Date by giving Date field label and Date as
	// input
	public void ImmsHistoryDateFill(String DiseaseLabel, String date) {
		String DateXpath = "(//tr[contains(.,'" + DiseaseLabel + "')])//td[3]//input[1]";

		String dateFieldId = driver.findElement(By.xpath(DateXpath)).getAttribute("id");

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').focus()");
		}
		driver.findElement(By.id(dateFieldId)).sendKeys(date);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').blur()");
		}

	}

	public String FutureDate(Integer numberOfDays) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, numberOfDays); // number of days to add
		String date = (formattedDate.format(c.getTime()));
		return date;
	}
	
	public String AddNumberOfMonthsToDate(Integer numberOfMonths) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();	
		c.add(Calendar.MONTH, numberOfMonths); // number of months to add
		String date = (formattedDate.format(c.getTime()));
		return date;
	}
	
	public String AddNumberOfYearsToDate(Integer numberOfYears) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();	
		c.add(Calendar.YEAR, numberOfYears); // number of months to add
		String date = (formattedDate.format(c.getTime()));
		return date;
	}

	
	
	public String YearForHAVS(int months) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		//test19 = -3
		c.add(Calendar.MONTH, months); // number of months to add
		String date = (formattedDate.format(c.getTime()));
		return date;
	}
	public String MonthForForHAVS(int months) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("MMM");
		Calendar c = Calendar.getInstance();	
		c.add(Calendar.MONTH, months); // number of months to add
		String date = (formattedDate.format(c.getTime()));
	
		return date;
	}

	
	//calculation of LAST dates for HAVS scenarios
	public String HAVSDates(String Test) {
		String date = null;
    	if(Test.equalsIgnoreCase("today<NextTier3<(today+3month)")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.MONTH,+2); //add 2 months to today
     		c.add(Calendar.YEAR,-3); //take 3 years from 
     		date = (formattedDate.format(c.getTime()));
    	}
    	if(Test.equalsIgnoreCase("today<NextTier3<(today)")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.MONTH,-1); //take one month from today
     		c.add(Calendar.YEAR,-3); //take 3 years from 
     		date = (formattedDate.format(c.getTime()));
    	}
    	if(Test.equalsIgnoreCase("today+6months<NextTier3<PT2D")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.MONTH,4); //add 4 months to todays date - methods signatrue should say today+3months
     		c.add(Calendar.YEAR,-3); //take 3 years from 
     		date = (formattedDate.format(c.getTime()));
    	}
    	
    	//below 2 functions are used for havs scenario 20
    	if(Test.equalsIgnoreCase("today+2days-2years")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.DATE,2);
     		c.add(Calendar.YEAR,-2); //take 2 years from 
     		date = (formattedDate.format(c.getTime()));
    	}
    	if(Test.equalsIgnoreCase("NextTier3DateForTest20")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.DATE,2);
     		c.add(Calendar.YEAR,-2); //take 2 years from 
     		c.add(Calendar.YEAR,3); //add 3 years 
     		date = (formattedDate.format(c.getTime()));
    	}
       	if(Test.equalsIgnoreCase("NextHAVSAfterPT2D")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.DATE,6);//add some days
     		c.add(Calendar.YEAR,-1); //take 2 years from 
     		date = (formattedDate.format(c.getTime()));
    	}
    	//last havse date for scenario 15
       	if(Test.equalsIgnoreCase("LastHAVSForTest15")) {
    		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
     		Calendar c = Calendar.getInstance();	
     		c.add(Calendar.MONTH,13);//add some days
     		c.add(Calendar.YEAR,-3); //take 2 years from 
     		date = (formattedDate.format(c.getTime()));
    	}
    	//below functions are used for havs scenario 21a
    	
    	
    	
		return date;
	}

	public String FutureDateISOFormat(Integer numberOfDays) {
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, numberOfDays); // number of days to add
		String date = (dateFormat.format(c.getTime()));
		return date;

	}

	public static String GenerateBirthDate() {

		GregorianCalendar gc = new GregorianCalendar();

		int year = RandomLocationGeneration.randBetween(1950, 1999);

		gc.set(Calendar.YEAR, year);

		int dayOfYear = RandomLocationGeneration.randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

		String DOB = gc.get(Calendar.DAY_OF_MONTH) + "/" + (gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.YEAR);

		return DOB;
	}

	public String NextWorkingDate(String nextDateString) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date nextDate = df.parse(nextDateString);

		for (int i = 1; i <= 6; i++) {

			if (isWorkingDay(nextDate)) {

				break;
			} else {

				Calendar c = Calendar.getInstance();
				c.setTime(nextDate);
				c.add(Calendar.DATE, 1);
				nextDateString = (df.format(c.getTime()));
				nextDate = df.parse(nextDateString);
			}

		}

		return nextDateString;

	}

	public boolean isWorkingDay(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		if ((dayOfWeek == 7) || (dayOfWeek == 1)) {
			return false;
		}

		return true;
	}

	public void populateBatchExpiryDate(String date, WebDriver driver) throws FileNotFoundException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ExpiryDateField = driver
				.findElement(By.xpath(BaseMethods.GetPropertiesFIleData().getProperty("BatchExpiryDate")));
		wait.until(ExpectedConditions.visibilityOf(ExpiryDateField));
		String dateFieldId = ExpiryDateField.getAttribute("id");

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').focus()");
		}
		driver.findElement(By.id(dateFieldId)).sendKeys(date);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + dateFieldId + "').blur()");
		}

	}

	
	
}
