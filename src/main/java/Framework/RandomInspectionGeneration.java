package Framework;

import org.apache.commons.lang.RandomStringUtils;

public class RandomInspectionGeneration {

	    public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }

		public static String[] getUniqueInspection(){
			// returns random Location details
			
			    String INSnumberV = "INS_"+RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			    String CCGnameV = "CCG_"+RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			   
		        String[] result = new String[2]; 	    
			    result[0] = INSnumberV;
			    result[1] = CCGnameV;
				return result;
		}		    
}
