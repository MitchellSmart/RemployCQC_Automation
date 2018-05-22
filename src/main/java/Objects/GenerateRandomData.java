package Objects;

import Framework.RandomEmployeeGeneration;
import Framework.RandomInspectionGeneration;
import Framework.RandomInspectorGeneration;
import Framework.RandomLocationGeneration;

public class GenerateRandomData {
	
	public static String[] GenerateRandomEmployeeData()
	{

		String[] uniqueDetails = new String[3];
		uniqueDetails = RandomEmployeeGeneration.getUniqueEmpl();
		return uniqueDetails;
	}
	
	public static String[] GenerateRandomLocationData()
	{
		String[] uniqueDetails = new String[4];
		uniqueDetails = RandomLocationGeneration.getUniqueLocation();
		return uniqueDetails;
	}
	
	public static String[] GenerateRandomInspectorData()
	{
		String[] uniqueDetails = new String[2];
		uniqueDetails = RandomInspectorGeneration.getUniqueInspector();
		return uniqueDetails;
	}
	
	public static String[] GenerateRandomInspectionData()
	{
		String[] uniqueDetails = new String[2];
		uniqueDetails = RandomInspectionGeneration.getUniqueInspection();
		return uniqueDetails;
	}
	

}



