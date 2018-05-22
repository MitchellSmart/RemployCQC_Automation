package Actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Framework.BaseMethods;
import Framework.PageObjectSetup;
import Framework.Wait;

public class ClickViewLink extends PageObjectSetup<ClickViewLink> {

	BaseMethods BaseMethods;
	Wait Wait;

	public ClickViewLink(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		this.Wait = new Wait(driver);
	}

	// Methods to select the entity to view
	public void Run_ClickViewLink(String entityToView)
			throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		
		By Link = By.xpath("//a[contains(text(), 'View "+entityToView+"')]");
		Click(Link);
		Wait.ShortWait();
	}
}