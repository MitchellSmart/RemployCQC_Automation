package Framework;

import org.apache.commons.lang.RandomStringUtils;

public class RandomLocationGeneration {

	    public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }

		public static String[] getUniqueLocation(){
			// returns random Location details
			
			    String DeptCRMIDV = "DeptCRM"+RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			    String LocationCRMIDV = "LocationCRM"+RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			    String DeptCRMNameV = "DeptCRMName"+RandomStringUtils.randomAlphanumeric(2).toUpperCase();
			    String LocationNameV = "LocatioName"+RandomStringUtils.randomAlphanumeric(2).toUpperCase();
			   
		        String[] result = new String[4]; 	    
			    result[0] = DeptCRMIDV;
			    result[1] = LocationCRMIDV;
			    result[2] = DeptCRMNameV;
			    result[3] = LocationNameV;
				return result;
		}		    

}
