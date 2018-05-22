package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buttons extends PageObjectSetup<Buttons> {

	BaseMethods BaseMethods;
	Wait WaitClass;
	WebDriverWait wait = new WebDriverWait(driver, 90);
	BrowserFunctions BrowserFunctions;

	
	
	public Buttons(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.WaitClass = new Wait(driver);
		this.BrowserFunctions = new BrowserFunctions(driver);
		
		// TODO Auto-generated constructor stub
	}

	public void ClickButton(String BtnLabel) throws InterruptedException {
		By btn= By.xpath(BaseMethods.GenerateXpath("Button", BtnLabel));
		int count = 0;		
		while (count < 60) 
		  	{ 
			  try { 
					//javaexecutor and click function did not work here (was sometimers missing the yes button
				  	wait.until(ExpectedConditions.visibilityOfElementLocated(btn));
					wait.until(ExpectedConditions.elementToBeClickable(btn)); 
				    driver.findElement(btn).click();
				    WaitClass.ShortWait();
					break;
							  
			  } 
			  catch (StaleElementReferenceException e)
			  { 	
				  System.out.println("Caught Button Referecne Exception "+count);
				  WaitClass.LongWait(); 
			  }
		  
			  catch (org.openqa.selenium.TimeoutException e) 
			  {
				  System.out.println("Caught Button Timenout Referecne Exception "+count);
				  WaitClass.LongWait(); 
		  		} 
			  catch (org.openqa.selenium.WebDriverException e) 
			  {
				  System.out.println("Caught Button Timenout Referecne Exception "+count);
				  WaitClass.LongWait(); 
		  		} 			  
			  count ++;
		  } //end while
	}


	public void ClickExactBtn(String BtnLabel) throws InterruptedException {
	 
		//Click(Btn);this function does not always work for buttons (especially pop ups)
		WaitClass.ShortWait();
		//String BtnXpath = "//button[(text()= '" + BtnLabel + "')]";
		//By Btn = By.xpath(BtnXpath);
		By Btn= By.xpath(BaseMethods.GenerateXpath("ExactButton", BtnLabel));
		
		int count = 0;
		while (count < 60) 
		  	{ 
			  try { 
				  	wait.until(ExpectedConditions.visibilityOfElementLocated(Btn));
					wait.until(ExpectedConditions
							  .elementToBeClickable(Btn)); 
							
				    driver.findElement(Btn).click();
				  	WaitClass.ShortWait();
				  	count =60;
				  	break;
							  
			  } 
			  catch (StaleElementReferenceException e)
			  { 
				  WaitClass.LongWait(); 
				  System.out.println("Caught Exact Button Stale Element Exception "+count);
			  }
		  
			  catch (org.openqa.selenium.TimeoutException e) 
			  {
				  System.out.println("Caught Exact Button Timenout Referecne Exception "+count);
				  WaitClass.LongWait();
		  	  } 
			  catch (org.openqa.selenium.WebDriverException e) 
			  {
				  System.out.println("Caught Exact Button WebDriver Exception "+count);
				  WaitClass.LongWait();
			  } 
			  
			  count ++;
		  	}
		

		
	}

}

