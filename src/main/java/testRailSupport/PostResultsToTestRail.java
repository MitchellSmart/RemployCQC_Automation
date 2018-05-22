package testRailSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import testRailAPI.APIClient;
 
public class PostResultsToTestRail 

{
	public static void POSTResults(Integer Result, String TestRunID, String TestCaseID,String comment ) throws Exception
	{
		
		if(TestRailSetUp.postResults ){		
			
				//set API clinet
	    		APIClient client = new APIClient("https://pshealth.testrail.net/");
	    		client.setUser("olga.suzuki@pshealth.co.uk");
	    		client.setPassword("nDZ9EbR/8LBakF87VKQe-ulZs5ty71jwGnZv4XnB4");
	      		
	   		
	    		if(TestRailSetUp.createNewRun) {
		    			//get run id;
		    			Map data1 = new HashMap();
		    			TestRunID = TestRailSetUp.RunID;
		    			//add test case to test run
		    			List cases = new ArrayList();
		    			List json = new ArrayList();
		    			
		    			//get existing cases from the run
		    			JSONArray responce =  (JSONArray) client.sendGet("get_tests/"+TestRunID);
	
		    			//System.out.println(responce);
		    			//if there are tests already included get them and update cases array
		    			if(responce!=null && !responce.isEmpty()) {
		    				for(int i=0;i<responce.size();i++){
		    				JSONObject caa = (JSONObject) responce.get(i);
		    				//System.out.println(caa.get("case_id"));
		    				cases.add(new Integer(caa.get("case_id").toString()));
		    				}
		    			}	
	    			
		    			//add current test to test run
		    			cases.add(new Integer(TestCaseID));	    			    			
		    			data1.put("case_ids", cases);
		    			//update test rail
		    			JSONObject r = (JSONObject) client.sendPost("update_run/"+TestRunID, data1);
	    			
	    		}
	    		else {
	    		    //manuall set run ID - you can use testrunid from test case set up of just hard set it
		    		if(TestRunID.equalsIgnoreCase("Regression")){
		    			
		    			//TestRunID = "13628";
		   
		    		}
	    		}
	    		
	    		
	    		//Declare Map for test case update
	    		Map data = new HashMap();
       				
		    	data.put("status_id", Result);
		    	data.put("comment",comment);
		        
		    	
		    	//post results
		    	JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+TestRunID+"/"+TestCaseID+"/", data);
		    	System.out.println("Results updated in TestRail");
	  
	    		
	        }
		
			
	        else 
	        {
	        	System.out.println("Results not updated in testRail");
	        }

	}
}