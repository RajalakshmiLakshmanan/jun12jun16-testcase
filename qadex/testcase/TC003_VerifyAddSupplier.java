package qadex.testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;

public class TC003_VerifyAddSupplier extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="Add Supplier";
		testDescription="using extentreport we see the output";
		authorName="Qadex";
		testType="sanity";
		testName = "negativetestsupplier";
		
		
	}
	//String compName,String contactName,String phoneNo,String email,String msg

	@Test
	public void runVerifyAddSupplier() throws IOException, InterruptedException {
		
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		driver.findElement(By.xpath("//span[text()='Supplier Information']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Supplier']")).click();
		driver.findElement(By.id("user_compname")).sendKeys("ratan");
		driver.findElement(By.id("user_contname")).sendKeys("contactName");
		
		driver.findElement(By.id("adduser_phone")).sendKeys("");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='1st Contact Email']")));
		
		driver.findElement(By.xpath("//input[@placeholder='1st Contact Email']")).sendKeys("Testing@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
	
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[@class='jBox-content']")).getText();
		
		System.out.println(text);
		try 
        {
        	
        	if(text.contains("Please enter the Company Name")) {
        		
        		reportStep("expected result matches the actual text","pass");
        		
        	}else if(text.contains("Please enter the telephone number")) {
        		
        	       reportStep("expected result matches the actual text","pass");
        	
        	}else if(text.contains("Please enter the First Contact Email")) {
        		
        		reportStep("expected result matches the actual text","pass");
        	}
        	
        	else {
        		reportStep("expected result doesn't matches actual text","fail");
        	}
        }catch(WebDriverException e) {
        		System.out.println("unexpected result came while verifying text");
        		
        	}
        
		
		
		
	}
	
	
	

}
