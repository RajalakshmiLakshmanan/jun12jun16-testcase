package qadex.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;

public class TC006_RequestSelfAudit extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="Request Self Audit";
		testDescription="To verify self audit sent successfully";
		authorName="Qadex";
		testType="sanity";
		testName = "Request self Audit";
		
		
	}

	@Test
	public void runRequestSelfAudit() throws IOException {
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		driver.findElement(By.xpath("//span[text()='Self Audits']")).click();
		driver.findElement(By.xpath("//span[text()='Request Self Audits']")).click();
		
		//Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='chechname5']")));
		
		WebElement element = driver.findElement(By.xpath("//label[@for='chechname5']"));
		driver.executeScript("arguments[0].click();",element);
		//driver.executeScript("arguments[0].click();", individual);
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
		
		
		//div[@class='jBox-content']
		
		
	}

}
