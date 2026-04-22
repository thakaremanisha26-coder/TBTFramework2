package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utitility.ExtentManager;

public class Testbase {
	public Properties prop;
	 public WebDriver driver;
		
/*	 @BeforeClass
	  public void setup() {
			
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://hseclide.clideanalyser.in/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}*/
		

	 @BeforeClass
	  public void setup() throws IOException {
		 FileReader file = new FileReader(".//src//main//resources//config.properties");
		 	prop = new Properties();
			prop.load(file);
			
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	 
	 public String takeScreenshot(String testName) throws IOException {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/Reports/" + testName + ".png";
			FileUtils.copyFile(src, new File(path));
			return path;
		}
	 
	

	 	public static ExtentReports extent;
	 	public static ExtentTest test;

	 	@BeforeSuite
	 	public void setupReport() {
	 		extent = ExtentManager.getReport();
	 	}

	 	@BeforeMethod
	 	public void startTest(Method method) {
	 		test = extent.createTest(method.getName());
	 	}

	 	@AfterMethod
	 	public void getResult(ITestResult result) throws IOException {

	 		if (result.getStatus() == ITestResult.FAILURE) {
	 			String path = takeScreenshot(result.getName());

	 			test.addScreenCaptureFromPath(path);
	 			test.fail(result.getThrowable());
	 		}
	 		else if (result.getStatus() == ITestResult.SUCCESS) {
	 			test.pass("Test Passed");
	 		}
	 	}

	 	@AfterSuite
	 	public void tearDown() {
	 		extent.flush();
	 	
	 	}
	 	
}
