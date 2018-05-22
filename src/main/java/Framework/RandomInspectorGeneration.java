package Framework;

import org.apache.commons.lang.RandomStringUtils;

public class RandomInspectorGeneration {

	    public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }

		public static String[] getUniqueInspector(){
			// returns random Location details
			
			    String InspFnameV = "Inspector"+RandomStringUtils.randomAlphanumeric(3).toUpperCase();
			    String InspLnameV = "Gadget"+RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			   
		        String[] result = new String[2]; 	    
			    result[0] = InspFnameV;
			    result[1] = InspLnameV;
				return result;
		}		    
}
