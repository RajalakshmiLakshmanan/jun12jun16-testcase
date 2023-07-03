package qadex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qadex.baseclass.BaseClass;

public class RequestSpecification extends BaseClass {
	
	public RequestSpecification(RemoteWebDriver driver) {
		this.driver  = driver;
		
	}
	
	public SelectProduct runRequestSpecification() {
        driver.findElement(By.xpath("//div[@class='vscomp-toggle-button']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'test')]")).click();
		driver.findElement(By.xpath("//input[@value='Select Products']")).click();
		
		return new SelectProduct(driver);
		
		
	}
	
	

}
