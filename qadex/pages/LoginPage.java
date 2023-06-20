package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import qadex.baseclass.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(ChromeDriver driver) {
		
		this.driver =driver;
		
		
	}
	
	public LoginPage enterMemberId(String memId) throws IOException {
		try {
			if(memId !=null) {
				driver.findElement(By.id("membership")).sendKeys(memId);
				reportStep("memberid enterd successfully","pass");
			}
			
			
		} catch (Exception e) {
			reportStep("memberid enterd wrongly","fail");
			e.printStackTrace();
		}
		return this;
	}

	public LoginPage enterUserId(String userId) throws IOException {
		
		try {
			if(userId != null) {
			driver.findElement(By.id("firstuserid")).sendKeys(userId);
			reportStep("userid enterd successfully","pass");
			}
			
		} catch (Exception e) {
			reportStep("userid enterd wrongly","fail");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public LoginPage enterPassword(String Password) throws IOException {
		try {
			if(Password!=null) {
			driver.findElement(By.id("password")).sendKeys(Password);
			reportStep("password enterd successfully","pass");
			}
		} catch (Exception e) {
			reportStep("password enterd wrongly","fail");
			e.printStackTrace();
		}
		
		return this;
		
		
	}
	public LoginPage verifyLoginPage(String errormsg) throws IOException {
		try 
        {
        	String text = driver.findElement(By.xpath("//div[@id='notice_flash']//b[1]")).getText();
        	System.out.println(text);
        	if(text.contains(errormsg)) {
        		reportStep("expected result matches the actual text","pass");
        	}else{
        		reportStep("expected result doesn't matches actual text","fail");
        	}
        }catch(WebDriverException e) {
        		System.out.println("unexpected result came while verifying text");
        		
        	}
		
		return this;
		
	}
	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElement(By.name("commit")).click();
			reportStep("login successful","pass");
		} catch (Exception e) {
			reportStep("login failure","fail");
			e.printStackTrace();
		}
		return new HomePage(driver);
		
	}
	
	
}
