package qadex.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;


public class TC007_InvalidRequestSelfAudit extends BaseClass {
	@BeforeTest
	public void Data() {
		testcase="Negative Request SelfAudit";
		testDescription="To verify Request not sent for invalid data";
		authorName="Qadex";
		testType="sanity";
		testName = "Negative Request SelfAudit";
		
		
	}
	@Test
	public void runInvalidRequestSelfaudit() throws IOException {
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		driver.findElement(By.xpath("//span[text()='Self Audits']")).click();
		driver.findElement(By.xpath("//span[text()='Request Self Audits']")).click();
		
		
		WebElement element = driver.findElement(By.xpath("//label[@for='chechname5']"));
		driver.executeScript("arguments[0].click();",element);
		
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		
		//driver.findElement(By.xpath("//div[@class='vscomp-toggle-button']")).click();
		//driver.findElement(By.xpath("(//span[contains(text(),'test')])[3]")).click();
		
		driver.findElement(By.xpath("//input[@value='Request']")).click();
		String text;
		try {
			text = driver.findElement(By.xpath("//div[@class='jBox-content']")).getText();
			if(text.contains("Select the Document")) {
				reportStep("expected result matches the actual text","pass");
				
			}
		} catch (Exception e) {
			reportStep("expected result doesn't matches actual text","fail");
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

}
