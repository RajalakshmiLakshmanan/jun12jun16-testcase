package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qadex.baseclass.BaseClass;

public class LogOut extends BaseClass{
	public LogOut(RemoteWebDriver driver) {
		this.driver = driver;
		
	}
	
	
	public LogOut runLogOut() throws IOException {
		driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown-toggle')])[5]")).click();
		try {
			driver.findElement(By.xpath("//a[text()=' Logout']")).click();
			reportStep("Logged out successfully","pass");
			
		} catch (Exception e) {
			reportStep("Not Logged out","fail");
			e.printStackTrace();
		}
		return this;
	}
	
    
}
