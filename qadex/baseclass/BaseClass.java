package qadex.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseClass {
	public RemoteWebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test,node;
	public String testcase,testDescription,testType,authorName,testName;
	public String dataSheetName;
	@BeforeSuite
	public void startReporter()
	{
		
			ExtentHtmlReporter reporter  =new ExtentHtmlReporter("./Report/result1.html");
			reporter.setAppendExisting(true);
			report = new ExtentReports();
			report.attachReporter(reporter);
		
	}
	
	@AfterSuite
	public void endReporter() {
			try {
			report.flush();
			}
			catch (Exception exc) {
				System.out.println("Caught Exception AfterSuite");
				exc.printStackTrace();
			}
		
	}
	@BeforeClass
	public void testcaseDetails() {
		test = report.createTest(testName, testDescription);
		test.assignAuthor(authorName);
		test.assignCategory(testType);
		node = test.createNode(testName);
		
	}
	public void reportStep(String des,String status) throws IOException {
		if(status.equalsIgnoreCase("pass")||status.equals(null)) {
			node.pass(des, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")|| status.equals(null)){
				
		    node.fail(des,MediaEntityBuilder.createScreenCaptureFromPath(".././sanp/img"+takeSnap()+".png").build());
			throw new RuntimeException("please look into report for failure details");	
		}
		
	}
	public int takeSnap() throws IOException {
		int random = (int)(Math.random()*999999);
        File src = driver.getScreenshotAs(OutputType.FILE);
        File des = new File("./snap/img"+random+".png");
        FileUtils.copyFile(src, des);
		return random;
	}
	@Parameters({"browser","url"})
	@BeforeMethod
	public void runPrecondition(String browser,String url) {
		ChromeOptions option = new ChromeOptions();
		EdgeOptions op = new EdgeOptions();
		op.addArguments("remote-allow-origins=*");
		option.addArguments("remote-allow-origins=*");
		if(browser.equalsIgnoreCase("chrome")) {
		
		     driver =new ChromeDriver(option);
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(op);
				
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		
	}
	@AfterMethod
	public void runPostCondition() {
		try {
		driver.close();
		}
		catch (Exception exc) {
			System.out.println("Caught Exception");
			exc.printStackTrace();
		}
		
	}
	@DataProvider
	public Object[][] setData() throws IOException {
			return DataExcel.readData(dataSheetName);
		
	}
	


}
