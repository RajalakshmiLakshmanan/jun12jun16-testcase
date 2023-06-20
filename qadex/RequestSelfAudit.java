package qadex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RequestSelfAudit extends BaseClass {
	@Test
	public void runRequestSelfAudit() throws InterruptedException {
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
		
		driver.findElement(By.xpath("//input[@value='Request']")).click();
		
		
	}



}
