package Framework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

public class Copy_Reports extends PageObjectSetup<Copy_Reports>{
	BaseMethods BaseMethods;
	 protected Copy_Reports(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}

	public static void copyFolder(File sourceFolder, File destinationFolder) throws IOException
	  {
		   //If sourceFolder is file; then copy the file directly to new location
	        if (sourceFolder.isDirectory())
	        {
	            //Verify if destinationFolder is already present; If not then create it
	            if (!destinationFolder.exists())
	            {
	                destinationFolder.mkdir();
	                System.out.println("Directory created :: " + destinationFolder);
	            }
	             
	            //Get all files from source directory
	            String files[] = sourceFolder.list();
	             
	            //Iterate over all files and copy them to destinationFolder one by one
	            for (String file : files)
	            {
	                File srcFile = new File(sourceFolder, file);
	                File destFile = new File(destinationFolder, file);
	                 
	                //Recursive function call
	                copyFolder(srcFile, destFile);
	            }
	        }
	        else
	        {
	            //Copy the file content from one place to another
	            Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("File copied :: " + destinationFolder);
	        }
	    }
		
	 public void Call_CopyFolder() throws IOException
	 {
	 	String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss", Locale.UK).format(new Date());
	 
	 	File srcfile = new File (BaseMethods.GetPropertiesFIleData().getProperty("ReportsSourcePath")); 	
		File Destfile = new File (BaseMethods.GetPropertiesFIleData().getProperty("ReportsDestinationPath"));
	
		if (!Destfile.exists())
        {
			Destfile.mkdir();
            System.out.println("Directory created :: " + Destfile);
        }
		
		File Latestfile = new File (BaseMethods.GetPropertiesFIleData().getProperty("ReportsDestinationPath")+timeStamp);
		
		Latestfile.mkdir();
		
		System.out.println(Destfile +" Created successfully");
		
		Copy_Reports.copyFolder(srcfile, Latestfile);
	 
	 }
	
}
