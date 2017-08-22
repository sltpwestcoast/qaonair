package SLTP.project.Utilities; 

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	private final Logger log = LogManager.getLogger(extentReport.class.getName());
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	 
	public void startreport()
	{
	   htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/first.html");
	   extent = new ExtentReports();
	   extent.attachReporter(htmlreporter);
	   extent.setSystemInfo("OS ", "Windows");
	   extent.setSystemInfo("Application ", "QAonAir");
	   extent.setSystemInfo("Environment ", "AFT");
	   
	   
	   htmlreporter.config().setDocumentTitle("Report for QAonAir testing");
	   htmlreporter.config().setReportName("QAonAir");
	   htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	   htmlreporter.config().setTheme(Theme.DARK);
	    log.info("Extent Report information loaded");
	}
	
	public void initreport(String testname)
	{
	   test=extent.createTest(testname);
	   log.info("Extent Report is initialized for "+testname);
	}
	
	public void putLog(ITestResult result, String screenpath)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" test case failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			try {
				if (screenpath !=null)
				{
				test.fail("Snapshot below" +test.addScreenCaptureFromPath(screenpath));
				log.error("Test case is failed and Screenshot is available");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		if (result.getStatus()==ITestResult.SUCCESS)
		{
		    test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" test case passed", ExtentColor.GREEN));
		    try {
				if (screenpath !=null)
				{
				test.pass("Snapshot below" +test.addScreenCaptureFromPath(screenpath));
				log.debug("Test case is passed and Screenshot is available");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			log.error("Test case is skipped");
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" test case skipped", ExtentColor.YELLOW));
		}
	}
	
	public void printreport()
	{
		extent.flush();
		log.info("ExtentReport is generated");
	}

}
