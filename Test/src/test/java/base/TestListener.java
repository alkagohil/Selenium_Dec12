package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends TestBase implements ITestListener {

static ExtentReports e;
ExtentTest t;
ScreenShotUtitlity s;
	
	public void onFinish(ITestContext context) {
		System.out.println("Test case has completed...");
		e.flush();
	}

	
	public void onStart(ITestContext context) {
		s=new ScreenShotUtitlity();
		System.out.println("Test case has started...");
		if(e==null)
		{
		e=new ExtentReports("test-output//MyReport.html");
		e.addSystemInfo("Browser", "Chrome");
		e.addSystemInfo("Release","Release 5");
		}
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}


	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" has failed...");
		String path=s.captureScreenshot(getDriver());
		s.captureScreenshotFile(getDriver());
		t.log(LogStatus.FAIL, result.getMethod().getMethodName()+" has failed..."+t.addScreenCapture(path));
		e.endTest(t);
	}

	
	public void onTestSkipped(ITestResult result) {
	
		System.out.println(result.getMethod().getMethodName()+" has skipped...");
		t.log(LogStatus.SKIP, result.getMethod().getMethodName()+" has skipped...");
		e.endTest(t);
	}

	public void onTestStart(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+" has started...");
	t=e.startTest(result.getMethod().getMethodName()+" has started...");
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" has passed...");
	t.log(LogStatus.PASS, result.getMethod().getMethodName()+" has passed...");
	e.endTest(t);
	}

}
