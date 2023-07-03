package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qadex.baseclass.BaseClass;

public class AddSupplier extends BaseClass {
	
	public AddSupplier(RemoteWebDriver driver) {
		this.driver = driver;	
		
	}
	
	public AddSupplier enterCompanyName(String Cname) {
		driver.findElement(By.id("user_compname")).sendKeys(Cname);
		return this;
	}
	public AddSupplier enterContactNmame(String Contname) {
		driver.findElement(By.id("user_contname")).sendKeys(Contname);
        return this;
	}
	
	public AddSupplier enterTelephoneNo(String phno) {
		
		driver.findElement(By.id("adduser_phone")).sendKeys(phno);
	     return this;
	}
		
		
	public AddSupplier enterEmailId(String mailId) {
		driver.findElement(By.xpath("//input[@placeholder='1st Contact Email']")).sendKeys(mailId);
		return this;
		
	}
	
	
	public AddSupplier onClickSave() throws IOException {
		try {
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			reportStep("supplier created successfully","pass");
		} catch (Exception e) {
			reportStep("supplier not added","fail");
			e.printStackTrace();
			
		}
		
		return this;
		
	}
	public AddSupplier verifyAddSupplier(String errorMsg) throws IOException {
		      driver.findElement(By.xpath("//input[@value='Save']")).click();
              String text = driver.findElement(By.xpath("//div[@class='jBox-content']")).getText();
		
		       System.out.println(text);
		try 
        {
        	
        	if(text.contains(errorMsg)) {
        		
        		reportStep("expected result matches the actual text","pass");
        	}else {
        		reportStep("expected result doesn't matches actual text","fail");
        	}
        }catch(WebDriverException e) {
        		System.out.println("unexpected result came while verifying text");
        		
        	}
		return this;
		
	}
		
		
	}

	
	

