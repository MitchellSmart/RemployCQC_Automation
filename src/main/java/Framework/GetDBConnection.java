package Framework;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

public class GetDBConnection extends PageObjectSetup<GetDBConnection>{
	BaseMethods BaseMethods;
	public GetDBConnection(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}

	public Connection getDBCOnnection() throws ClassNotFoundException, FileNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection(BaseMethods.GetPropertiesFIleData().getProperty("UATDBURL"), BaseMethods.GetPropertiesFIleData().getProperty("DBUsername"), BaseMethods.GetPropertiesFIleData().getProperty("DBPassword"));
		//System.out.println("Connection to Database established Successfully");
		
		return conn;	
	}
	
}
