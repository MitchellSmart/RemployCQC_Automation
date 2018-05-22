package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.PageObjectSetup;

public class Check_Data_Persist extends PageObjectSetup<Check_Data_Persist>{

	public Check_Data_Persist(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//Generic method to check if the script has filled in data for all the fields
	public void Check_Data_Entered(By[] Locators)
	{
		int i=0;
		for (i=0;i<Locators.length;i++)
		{
			
			
		}
		
	}
	
	
}
