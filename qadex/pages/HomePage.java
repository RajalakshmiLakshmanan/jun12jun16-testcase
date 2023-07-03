package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import qadex.baseclass.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(RemoteWebDriver driver) {
		
		this.driver =driver;
		
	}
	public HomePage verifyHomePage(String msg) throws IOException, InterruptedException {
		String actualTitle = driver.getTitle();
		if(msg.equalsIgnoreCase("valid")) {
			
			if(actualTitle.contains("dashboard")) { 
				Thread.sleep(3000);
				LogOut lo = new LogOut(driver);
				lo.runLogOut();
				Assert.assertTrue(true,"pass");
				
			}else {
				
		         Assert.assertTrue(false, "fail");   
			}
			}else if(msg.equalsIgnoreCase("invalid")) {
				  if(actualTitle.contains("dashbaord")) {
				
				Assert.assertTrue(false, "pass");
			}else {
				
				Assert.assertTrue(true,"fail");
			}
			
			
		}
		
		return this;
	}
	
	public  HomePage clickSupplierInformation() {
		driver.findElement(By.xpath("//span[text()='Supplier Information']")).click();
		
		return this;
		
	}
	
	public  AddSupplier clickAddNewSupplier() {
		driver.findElement(By.xpath("//span[text()='Add New Supplier']")).click();
		
		return new AddSupplier(driver);
	}
	
	public HomePage clickSelfAudit() {
		
		driver.findElement(By.xpath("//span[text()='Self Audits']")).click();
		return this;
		
	}
	public SelectSupplier clickRequestSelfAudit() {
		
		driver.findElement(By.xpath("//span[text()='Request Self Audits']")).click();
		return new SelectSupplier(driver);
		
	}
	public HomePage clickSupplierSpecification() {
		
		driver.findElement(By.xpath("//span[text()='Supplier Specifications']")).click();
		return this;
	}
	public SelectSupplier clickRequestSpecification() {
		
		driver.findElement(By.xpath("//span[text()='Request Specifications']")).click();
		return new SelectSupplier(driver);
	}

}
