package qadex;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseClass {
	public ChromeDriver driver;
	public static ExtentReports report;
	public static ExtentTest test,node;
	public String testcase,testDescription,testType,authorName,testName;
	public String dataSheetName;
	@BeforeSuite
	public void startReporter()
	{
		try {
			ExtentHtmlReporter reporter  =new ExtentHtmlReporter("./Report/result1.html");
			reporter.setAppendExisting(true);
			report = new ExtentReports();
			report.attachReporter(reporter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterSuite
	public void endReporter() {
		try {
			report.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		if(status.equalsIgnoreCase("pass")) {
			node.pass(des, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")){
				
		    node.fail(des,MediaEntityBuilder.createScreenCaptureFromPath(".././sanp/img"+takeSnap()+".png").build());
			throw new RuntimeException("please look into report for failure details");	
		}
		
	}
//	public void reportStep(String dec, String status,boolean bSnap ) throws IOException {
//    	com.aventstack.extentreports.MediaEntityModelProvider img = null;
//		if(bSnap && !status.equalsIgnoreCase("INFO")){
//
//			long snapNumber = 100000L;
//			snapNumber = takeSnap();
//			try {
//				img = MediaEntityBuilder.createScreenCaptureFromPath
//						(".././snap/img"+snapNumber+".jpg").build();
//			} catch (IOException e) {
//				
//			}
//		}
//    	if(status.equalsIgnoreCase("pass")) {
//    		node.pass(dec, img);
//    	} else if(status.equalsIgnoreCase("fail")) {
//    		node.fail(dec, img); 
//    	}
//    }
//    
//    public void reportStep(String desc, String status) throws IOException {
//		reportStep(desc, status, true);
//	}
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
