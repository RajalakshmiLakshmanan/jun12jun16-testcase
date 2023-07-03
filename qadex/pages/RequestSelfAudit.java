package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qadex.baseclass.BaseClass;

public class RequestSelfAudit extends BaseClass{
	public RequestSelfAudit(RemoteWebDriver driver) {
		this.driver= driver;
		
	}
	
	public RequestSelfAudit runRequestSelfAudit() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("check 1");
		WebElement element = driver.findElement(By.xpath("//div[@class='vscomp-toggle-button']"));
		driver.executeScript("arguments[0].click();",element);
		System.out.println("check2");
		driver.findElement(By.xpath("(//span[contains(text(),'test')])[3]")).click();
		return this;
		
	}
	public RequestSelfAudit onclickRequest() throws IOException {
		try {
			driver.findElement(By.xpath("//input[@value='Request']")).click();
			reportStep("selfAudit Request sent successfully","pass");
			
		} catch (Exception e) {
			reportStep("selfAudit Request not sent failure","fail");
			e.printStackTrace();
		}
		
		return this;
	}
	

}
