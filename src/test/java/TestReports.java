import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReports {

	

	public static void main(String[] args) {

		String dateformat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		ExtentReports extent = new ExtentReports();
//		Html report
		String filepath = System.getProperty("user.dir")+"//Reports//"+dateformat+"_SFDCreport.html";
		
		ExtentHtmlReporter report = new ExtentHtmlReporter(filepath);
		
		extent.attachReporter(report);
		
//		From here we are creating test reports.. (Each testcase)
		
		ExtentTest test = extent.createTest("Login_TC01");
		test.info("Entered username");
		test.info("Entered password");
		
		test.log(Status.PASS, "Login_TC01 Passed");
		
		
		ExtentTest test2 = extent.createTest("Login_TC02");
		
		test2.info("Entered username");
		test2.log(Status.INFO, "Entered username");
		test2.info("Entered password");
		
		test2.log(Status.FAIL, "Login_TC02 Failed");
		System.out.println("Testcase complete");
		
//		This should be given at the end i.e after all TC are executed
		extent.flush();
		
		
	}

}
