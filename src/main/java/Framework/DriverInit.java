package Framework;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverInit { 
	
	private WebDriver driver;

	public WebDriver GetDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C://Jars/chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		
		chromePrefs.put("profile.default_content_settings.popups", 0);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--incognito");
		
		DesiredCapabilities Cap = DesiredCapabilities.chrome();
		Cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		Cap.setCapability(ChromeOptions.CAPABILITY, options);
		Cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	
		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(Cap);
		
		
		return driver;
	
	}
}