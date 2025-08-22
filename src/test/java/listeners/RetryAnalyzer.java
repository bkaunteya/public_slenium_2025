package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retrycount = 0;
	private static final int maxretrycounter = 2; 
	
	@Override
	public boolean retry(ITestResult result) {
		if(retrycount < maxretrycounter) {
			retrycount++;
			System.out.println("Retrying test :" + result.getName() + " Attempts " + (retrycount+1) );
			return true;
		}
		return false;
	}
	
//    public boolean retry(ITestResult iTestResult) {
//        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
//            if (retrycount < maxretrycounter) {                            //Check if maxtry count is reached
//            	retrycount++;                                     //Increase the maxTry count by 1
//                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
//                return true;                                 //Tells TestNG to re-run the test
//            } else {
//                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
//            }
//        } else {
//            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
//        }
//        return false;
//    }
	

}
