package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qadex.baseclass.BaseClass;

public class SelectProduct extends BaseClass {
	public SelectProduct(RemoteWebDriver driver) {
		this.driver  =driver;
		
		
	}
	
	public SelectProduct runSelectProduct() {
		WebElement element2 = driver.findElement(By.xpath("//label[@for='chechname_63']"));
		driver.executeScript("arguments[0].click();", element2);
		return this;
		
	}
	
	public SelectProduct onclickRequestForSpecification() throws IOException {
		
		
		try {
			driver.findElement(By.xpath("//input[@value='Request']")).click();
			reportStep("Request Specification sent successfully","pass");
			
		} catch (Exception e) {
			reportStep("Request Specification not sent failure","fail");
			e.printStackTrace();
		}
		
		return this;
	}
		
	}
	


