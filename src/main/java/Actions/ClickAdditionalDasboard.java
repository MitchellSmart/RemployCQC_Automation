package Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.PageObjectSetup;

public class ClickAdditionalDasboard extends PageObjectSetup<ClickAdditionalDasboard> {

	public ClickAdditionalDasboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickAdditionalDashboardLink(String ADName)
			throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException, SQLException {

		By Ad = By.xpath("//span[text() = '"+ADName+"']");
	
		WaitForClickability(Ad, 20);
		find(Ad).click();
		
	}
}
