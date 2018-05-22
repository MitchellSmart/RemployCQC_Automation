package testNGClasses;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testRailSupport.Functions;
import testRailSupport.PostResultsToTestRail;
import testRailSupport.UseAsTestRailId;

public class MyCustomListener implements ITestListener
{
    Integer outcome = 0;
    Integer testRunID = 0;
    String Comment="";
	String TestID=null;
	String TestRunID=null;
	
    //Test Rail statuses
    Integer Passed = 1;
    Integer Failed= 5;
    Integer Blocked= 2;
    
    // WebDriver driver=null;
	//String filePath = "C:\\DMAutomation\\";
    
	public void onTestStart(ITestResult result)
	{
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("TestingDocs>> onTestStart ::" +  result.getMethod().getMethodName());
		
		
	}
	

	public void onTestSuccess(ITestResult result) {
		
	
		IClass obj = result.getTestClass();
		Class newobj = obj.getRealClass();
		Method testMethod = null;
		try 
		{
			testMethod = newobj.getMethod(result.getName());
		}
		catch (NoSuchMethodException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SecurityException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testMethod.isAnnotationPresent(testRailSupport.UseAsTestRailId.class))
		{
			UseAsTestRailId useAsTestName = testMethod.getAnnotation(testRailSupport.UseAsTestRailId.class);
			
			TestID = Integer.toString(useAsTestName.testRailId());
			TestRunID = useAsTestName.testRailTestRun();
		}
		
        /*post results to test rail
		try {
			PostResultsToTestRail.POSTResults(Passed,TestRunID, TestID,  "Referral: "+ genericOHA.ReferralID.ScenarioReferralID );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}
	
	public void onTestFailure(ITestResult result)
	{
		
    
		
		IClass obj = result.getTestClass();
		Class newobj = obj.getRealClass();
		
		Method testMethod = null;
		try {
			testMethod = newobj.getMethod(result.getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testMethod.isAnnotationPresent(UseAsTestRailId.class))
		{
		UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
		// Get the TestCase ID for TestRail
		TestID = Integer.toString(useAsTestName.testRailId());
		TestRunID = useAsTestName.testRailTestRun();
		//System.out.println("Test Rail ID = " + TestID);
		}
		
        //get error comment
        try {
			Comment = Functions.getStackTraceAsString(result.getThrowable());
			if(Comment.contains("waiting for visibility of element")){
				Failed = Blocked;
			}
			if(Comment.contains("chrome not reachable")){
				Failed = Blocked;
			}
			if(Comment.contains("Unable to locate element")){
				Failed = Blocked;
			}
			if(Comment.contains("java.lang.AssertionError: The following asserts failed:")){
				Failed = 5;
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        /* post results to test rail
		try {
			PostResultsToTestRail.POSTResults(Failed,TestRunID, TestID, "Referral: "+ genericOHA.ReferralID.ScenarioReferralID +" --- " +Comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName);*/
    	
		}

	
	public void onTestSkipped(ITestResult result)
	{

		IClass obj = result.getTestClass();
		Class newobj = obj.getRealClass();
		Method testMethod = null;
		try {
			testMethod = newobj.getMethod(result.getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testMethod.isAnnotationPresent(UseAsTestRailId.class))
		{
			
		UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
		// Get the TestCase ID and Run ID for TestRail
		TestID = Integer.toString(useAsTestName.testRailId());
		TestRunID = useAsTestName.testRailTestRun();

		}
		
        //get error comment
        try {
			Comment = Functions.getStackTraceAsString(result.getThrowable());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        /* post results to test rail
		try {
			PostResultsToTestRail.POSTResults(Blocked,TestRunID, TestID, "Referral: "+ genericOHA.ReferralID.ScenarioReferralID +" --- " +Comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}




	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}




	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	/*   public void takeScreenShot(String methodName) {
	    	driver = BaseMethods.driver;
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try {
					FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }*/

}