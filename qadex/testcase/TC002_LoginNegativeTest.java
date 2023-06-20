package qadex.testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;


public class TC002_LoginNegativeTest extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="login page";
		testDescription="Login negative test";
		authorName="Qadex";
		testType="smoke";
		testName = "loginPagetest";
		
		
	}
	//String memid,String userid,String password,String msg
	//(dataProvider="setData")

	@Test
	public void runLoginNegativetest() throws InterruptedException, IOException {
		
		
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
        try 
        {
        	String text = driver.findElement(By.xpath("//div[@id='notice_flash']//b[1]")).getText();
        	System.out.println(text);
        	if(text.contains("Please enter the Membership Id")) {
        		reportStep("expected result matches the actual text","pass");
        		
        	}else if(text.contains("Please enter the User Id")) {
        		
        		reportStep("expected result matches the actual text","pass");
        		
        	}else if(text.contains("Please enter the password")) {
        		
        		reportStep("expected result matches the actual text","pass");
        	}
        	else{
        		reportStep("expected result doesn't matches actual text","fail");
        	}
        }catch(WebDriverException e) {
        		System.out.println("unexpected result came while verifying text");
        		
        	}
             
     
	}
}
        
        
        
		//String text = driver.findElement(By.xpath("//b[text()='Incorrect Membership Id']")).getText();
	
				//System.out.println(text);
		
		//String text = driver.findElement(By.xpath("//b[text()='Please enter the password ']")).getText();
		//String text = driver.findElement(By.xpath("//b[text()='Please enter the User Id ']")).getText();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='Please enter the Membership Id ']")));
		//String text = driver.findElement(By.xpath("//b[text()='Please enter the Membership Id ']")).getText();
		//Thread.sleep(2000);
		
		
		
		
		
	
	
	
	


