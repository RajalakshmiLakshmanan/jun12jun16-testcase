package qadex.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;

public class TC008_EndToEndFunction extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="Funtional testing";
		testDescription="To verify self audit sent successfully";
		authorName="Qadex";
		testType="End-End testing";
		testName = "Functional testing";
		
		
	}
	
	@Test
	public void runEndToEndFunction() throws InterruptedException, IOException {
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		try {
			driver.findElement(By.name("commit")).click();
			reportStep("login successful","pass");
		} catch (Exception e) {
			reportStep("login failure","fail");
			e.printStackTrace();
		}
		
		
		driver.findElement(By.xpath("//span[text()='Supplier Information']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Supplier']")).click();
		driver.findElement(By.id("user_compname")).sendKeys("ratan");
		driver.findElement(By.id("user_contname")).sendKeys("contactName");
		driver.findElement(By.id("adduser_phone")).sendKeys("78903476");
		driver.findElement(By.xpath("//input[@placeholder='1st Contact Email']")).sendKeys("Testing@gmail.com");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			reportStep("supplier created successfully","pass");
		} catch (Exception e) {
			reportStep("supplier not added","fail");
			e.printStackTrace();
			
		}
		
		driver.findElement(By.xpath("//span[text()='Self Audits']")).click();
		driver.findElement(By.xpath("//span[text()='Request Self Audits']")).click();
		WebElement element = driver.findElement(By.xpath("//label[@for='chechname5']"));
		driver.executeScript("arguments[0].click();",element);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
		
		driver.findElement(By.xpath("//div[@class='vscomp-toggle-button']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'test')])[3]")).click();
		
		try {
			driver.findElement(By.xpath("//input[@value='Request']")).click();
			reportStep("selfAudit Request sent successfully","pass");
			
		} catch (Exception e) {
			reportStep("selfAudit Request not sent failure","fail");
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown-toggle')])[5]")).click();
		try {
			driver.findElement(By.xpath("//a[text()=' Logout']")).click();
			reportStep("Logged out successfully","pass");
			
		} catch (Exception e) {
			reportStep("Not Logged out","fail");
			e.printStackTrace();
		}
		
		
		
	}
	

}
