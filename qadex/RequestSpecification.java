package qadex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RequestSpecification extends BaseClass {
	@Test
	public void runRequestSpecification() {
		driver.findElement(By.xpath("//span[text()='Supplier Specifications']")).click();
		
		driver.findElement(By.xpath("//span[text()='Request Specifications']")).click();
		
		WebElement element = driver.findElement(By.xpath("//label[@for='chechname5']"));
		driver.executeScript("arguments[0].click();",element); 
		
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		driver.findElement(By.xpath("//div[@class='vscomp-toggle-button']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'test')]")).click();
		driver.findElement(By.xpath("//input[@value='Select Products']")).click();
		
		WebElement element2 = driver.findElement(By.xpath("//label[@for='chechname_63']"));
		driver.executeScript("arguments[0].click();", element2);
		
		driver.findElement(By.xpath("//input[@value='Request']")).click();
		
		
		
		
	}

}
