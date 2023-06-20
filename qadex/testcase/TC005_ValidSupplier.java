package qadex.testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;

public class TC005_ValidSupplier extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="Add Supplier";
		testDescription="To verify supplier data created successfully";
		authorName="Qadex";
		testType="sanity";
		testName = "AddSuppliertest";
		dataSheetName="addsupplier";
		
	}
	
	
	
	@Test(dataProvider="setData")
	public void runvalidsupplier(String compName,String contactName,String phoneNo,String email) throws InterruptedException, IOException {
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		//driver.findElement(By.xpath("//a[text()='Go To New User Experience']")).click();
		driver.findElement(By.xpath("//span[text()='Supplier Information']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Supplier']")).click();
		if(compName !=null) {
		driver.findElement(By.id("user_compname")).sendKeys(compName);
		}
		driver.findElement(By.id("user_contname")).sendKeys(contactName);
		if (phoneNo != null) {
			driver.findElement(By.id("adduser_phone")).sendKeys(phoneNo);
		}
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='1st Contact Email']")));
	
		if( email !=null) {
			
		driver.findElement(By.xpath("//input[@placeholder='1st Contact Email']")).sendKeys(email);
		
		}
		
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			reportStep("supplier created successfully","pass");
		} catch (Exception e) {
			reportStep("supplier not added","fail");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
