package qadex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import qadex.baseclass.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(ChromeDriver driver) {
		
		this.driver =driver;
		
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
	

}
