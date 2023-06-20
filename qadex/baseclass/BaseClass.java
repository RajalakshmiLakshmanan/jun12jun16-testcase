package qadex.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import qadex.ReadExcel;

public class BaseClass {
	public ChromeDriver driver;
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
		
			report.flush();
		
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
	@BeforeMethod
	public void runPrecondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("remote-allow-origins=*");
		 driver =new ChromeDriver(option);
		
		driver.get("https://naf.qadex.com/user/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		
	}
	@AfterMethod
	public void runPostCondition() {
		driver.close();
		
	}
	@DataProvider
	public Object[][] setData() throws IOException {
			return ReadExcel.readData(dataSheetName);
		
	}
	


}
