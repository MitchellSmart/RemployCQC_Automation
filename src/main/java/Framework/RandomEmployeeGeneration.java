package Framework;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class RandomEmployeeGeneration {

	    public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }
	   


		public static String[] getUniqueEmpl(){
			// returns unique identifier, first name and last name
				Random rnd = new Random();
			    String firstname = RandomStringUtils.randomAlphanumeric(2).toUpperCase()+"King";
			    String lastname = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
		        String identifier = "";
		        String ran ="";
		        
		        String[] result = new String[3]; 

		        identifier = Character.toString(firstname.charAt(0)); // First char
			    if (lastname.length() > 5)
			    	identifier += lastname.substring(0, 5);
			    else
			    	identifier += lastname;
			    ran = Integer.toString(rnd.nextInt(9999999));

			    identifier += ran;
			    firstname += ran;
			    lastname += ran;
			    
			    result[0] = identifier;
			    result[1] =firstname;
			    result[2] =lastname;
			    result[3] =lastname;
				return result;
		}		    

}
