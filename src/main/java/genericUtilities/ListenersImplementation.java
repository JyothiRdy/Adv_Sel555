package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation of
 * @author LENOVO.T470s
 *
 */
public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		
		System.out.println(MethodName+"----------test Execution started---------");
		test= report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		System.out.println("---------test pass-------");
		test.log(Status.PASS, MethodName+"---------test pass------");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		
		System.out.println(MethodName+"-----test fail-----------");
		System.out.println(result.getThrowable());
		test.log(Status.FAIL, MethodName+"-----------test Fail----------");
		test.log(Status.INFO,result.getThrowable());
		
		//CAPTURE SCREENSHOT
		SeleniumUtility s= new SeleniumUtility();
		JavaUtility j= new JavaUtility();
		
		String screenshotName=MethodName+ "-"+j.getSystemDate();
		try 
		{
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		System.out.println("----test skipped-------");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		System.out.println("suite execution started");
		ExtentSparkReporter htmlrep= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlrep.config().setDocumentTitle("Execution Report");
		htmlrep.config().setReportName("Vtiger Report");
		htmlrep.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("base platform", "windows");
		report.setSystemInfo("base browser", "chrome");
		report.setSystemInfo("base env", "test env");
		report.setSystemInfo("reporter name", "Jyothi");
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution finished");
		report.flush();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
