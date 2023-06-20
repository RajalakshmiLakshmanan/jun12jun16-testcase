package qadex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddSupplier extends BaseClass{
	@Test(dataProvider="setData")
	public void runAddSupplier(String compName,String ContactName,String phno,String email) {
		driver.findElement(By.xpath("//span[text()='Supplier Information']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Supplier']")).click();
		driver.findElement(By.id("user_compname")).sendKeys(compName);
		driver.findElement(By.id("user_contname")).sendKeys(ContactName);
		
		driver.findElement(By.id("adduser_phone")).sendKeys(phno);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='1st Contact Email']")));
		
		
		driver.findElement(By.xpath("//input[@placeholder='1st Contact Email']")).sendKeys(email,Keys.ENTER);
		
		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='btn btn-primary']")));
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		
		
	
	}
	

}
