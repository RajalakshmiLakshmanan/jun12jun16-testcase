package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qadex.baseclass.BaseClass;

public class SelectSupplier extends BaseClass{
	public SelectSupplier(RemoteWebDriver driver) {
		this.driver = driver;
		
	}
	
	
	public RequestSelfAudit onclickSelectSupplier() throws IOException {
		WebElement element = driver.findElement(By.xpath("//label[@for='chechname5']"));
		driver.executeScript("arguments[0].click();",element);
        try {
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			String expUrl = "https://naf.qadex.com/selfaudits/request_self_audits";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			if(actualUrl.contains(expUrl)) {
			  reportStep("supplier selected successfully for Request SelfAudit","pass");
				
			}
		} catch (Exception e) {
			reportStep(" supplier not selected","fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return new RequestSelfAudit(driver);
	}
	
	public RequestSpecification clickSlectSupplierSpecification() throws IOException {
		WebElement element = driver.findElement(By.xpath("//label[@for='chechname5']"));
		driver.executeScript("arguments[0].click();",element);
        try {
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			String expUrl = "https://naf.qadex.com/supplier_specifications/request_spec_for_selected_supplier";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			if(actualUrl.contains(expUrl)) {
			  reportStep("supplier selected successfully for Request Specification","pass");
				
			}
		} catch (Exception e) {
			reportStep(" supplier not selected","fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return new RequestSpecification(driver);
	}
		
		
	}


