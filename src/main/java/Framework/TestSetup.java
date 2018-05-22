package Framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import testRailAPI.APIClient;
import testRailAPI.APIException;
import testRailSupport.TestRailSetUp;

public class TestSetup {
	
protected WebDriver driver;


	@BeforeClass
	protected void SuiteSetup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	
	@AfterClass
	protected void SuiteTearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(1000);
	}
	
	@BeforeSuite
	protected void InitiateTestRailSetUp(ITestContext ctx) throws InterruptedException, MalformedURLException, IOException, APIException {
		TestRailSetUp TestRailSetUp = new TestRailSetUp();		 
		String suiteName = ctx.getCurrentXmlTest().getName();
		if(testRailSupport.TestRailSetUp.createNewRun){
		    APIClient client = new APIClient("https://pshealth.testrail.net/");
		    client.setUser("olga.suzuki@pshealth.co.uk");
		    client.setPassword("nDZ9EbR/8LBakF87VKQe-ulZs5ty71jwGnZv4XnB4");
			//create run on the go
		    Map data = new HashMap();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			data.put("suite_id", 4);
			data.put("name", suiteName + " - "+dateFormat.format(date));
			data.put("description","");
			data.put("include_all", new Boolean(false));
			JSONObject r = (JSONObject) client.sendPost("add_run/4", data);
			TestRailSetUp.RunID= r.get("id").toString();
		}
	}
	 @AfterSuite
		protected void Close() throws InterruptedException, MalformedURLException, IOException, APIException {
			if(testRailSupport.TestRailSetUp.createNewRun ){
				//System.out.print("a");
			    APIClient client = new APIClient("https://pshealth.testrail.net/");
			    client.setUser("olga.suzuki@pshealth.co.uk");
			    client.setPassword("nDZ9EbR/8LBakF87VKQe-ulZs5ty71jwGnZv4XnB4");		   
				JSONObject r = (JSONObject) client.sendPost("close_run/"+TestRailSetUp.RunID, "");
			
		}	
	}
	
}
