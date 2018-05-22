package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

public class FileOperations extends PageObjectSetup<FileOperations> {
	BaseMethods BaseMethods;

	protected FileOperations(WebDriver driver) {
		super(driver);
		this.BaseMethods = new BaseMethods(driver);
		// TODO Auto-generated constructor stub
	}

	// Deletes everything from a folder if folder exists otherwise it will create a
	// new folder
	public void DeleteFilesFromFolder() throws IOException {
		File folder = new File(BaseMethods.ReadPropertiesFile().getProperty("FolderPath"));

		if (!folder.exists()) {
			new File(BaseMethods.ReadPropertiesFile().getProperty("FolderPath")).mkdir();
		} else {

			File[] listoffiles = folder.listFiles();

			for (int i = 0; i < listoffiles.length; i++) {
				File pes = listoffiles[i];

				pes.delete();
			}

		}
	}

	// Read and Parse the file by giving the specifed file as input
	public static String ReadandParsePDF(String filepath) throws IOException {

		FileInputStream is = new FileInputStream(new File(filepath));

		PDDocument pdDoc = PDDocument.load(is);
		PDFTextStripper pdfStripper = new PDFTextStripper();

		String Text = pdfStripper.getText(pdDoc);

		System.out.println(Text);

		String lines[] = Text.split("\\r?\\n");

		for (String line : lines) {
			System.out.println(line);
			return line;
		}

		return "File Read Successfully";

	}

}
