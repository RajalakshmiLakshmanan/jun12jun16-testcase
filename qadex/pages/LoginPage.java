package qadex.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import qadex.baseclass.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(RemoteWebDriver driver) {
		
		this.driver =driver;
		
		
	}
	
	public LoginPage enterMemberId(String memId) throws IOException {
		try {
			if(memId !=null) {
				driver.findElement(By.id("membership")).sendKeys(memId);
				reportStep("memberid enterd successfully","pass");
			}else {
				
				reportStep("memberid not enterd ","pass");
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
			}else {
				reportStep("userid not entered","pass");
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
			}else {
				reportStep("password not entered ","pass");
			}
		} catch (Exception e) {
			reportStep("password enterd wrongly","fail");
			e.printStackTrace();
		}
		
		return this;
		
		
	}
	public HomePage onClickSignin() {
		
		driver.findElement(By.name("commit")).click();
		return new HomePage(driver);
		
	}
	public HomePage verifyLoginPage(String errormsg) throws IOException {
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
		
		return new HomePage(driver);
		
	}
	public LoginPage clickLoginButton(String msg) throws IOException {
		try {
			driver.findElement(By.name("commit")).click();
			String actualTitle = driver.getTitle();
			String expTitle  = "Food Safety & Brand";
			if(msg.equalsIgnoreCase("valid")) {
				
				if(actualTitle.contains(expTitle)) { 
					//Assert.assertTrue(true,"pass");
					reportStep("login successful","pass");
					Thread.sleep(5000);
					//LogOut lo = new LogOut(driver);
					//lo.runLogOut();
					
					
				}else {
					reportStep("login failure","fail");
			        // Assert.assertTrue(false, "fail");   
				}
				}else if(msg.equalsIgnoreCase("invalid")) {
					  if(actualTitle.contains(expTitle)) {
						  reportStep("login successful","fail");  
					//Assert.assertTrue(false, "pass");
				}else {
					reportStep("Login failure-please check login details","pass");
					
					//Assert.assertTrue(true,"fail");
				}
				
				
			}
			
			
		}catch (Exception e) {
			reportStep("login failure","fail");
			e.printStackTrace();
		}
		return this;
		
	}
	
	
}
