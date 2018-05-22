package Framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunctions extends PageObjectSetup<LoginFunctions> {
	 
	WebDriverWait wait = new WebDriverWait(driver, 40);
	
	public LoginFunctions(WebDriver driver) {
		super(driver);
	}

	//Generic method to login into Appian
	public void loginAppian (String url, String username, String password) throws IOException, InterruptedException 
	{
		BaseMethods BaseMethods=new BaseMethods(driver);;
		//Wait WaitClass = new Wait(driver);
		
			driver.navigate().to(url);
		
			//driver.manage().window().maximize();
			driver.findElement(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("AppianUserName"))).sendKeys(username);
			driver.findElement(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("AppianPassword"))).sendKeys(password);
			driver.findElement(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("LoginBtn"))).click();
			
			System.out.println("Logged in as - " +username);
	}


	//Generic Method to Logout from Appian
	public  void AppianLogout() throws InterruptedException, IOException 
	{
		Wait WaitClass = new Wait(driver);
		BaseMethods BaseMethods=new BaseMethods(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WaitClass.waitForPageLoaded(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("ProfileImage")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("ProfileImage"))));
		driver.findElement(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("ProfileImage"))).click();
		WaitClass.LongWait();
		driver.findElement(By.xpath(BaseMethods.ReadPropertiesFile().getProperty("SignOutLink"))).click();
		System.out.println("Logged out");
		WaitClass.waitForPageLoaded(null);
		//WaitClass.WaitForTime(31000); Not needed for Remploy
		
	}
}
