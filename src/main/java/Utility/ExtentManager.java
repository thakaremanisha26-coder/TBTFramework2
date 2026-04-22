package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	
	public static ExtentReports getReport() {

		String path = System.getProperty("user.dir") + "/Reports/ExtentReport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		return extent;
	}
}
