package qadex.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;

public class TC001_LoginPage extends BaseClass {
	@BeforeTest
	public void Data() {
		testcase="login page";
		testDescription="using extentreport we see the output";
		authorName="Qadex";
		testType="smoke";
		testName = "loginPagetest";
		dataSheetName = "login";
		
	}

	
	
	@Test(dataProvider="setData")
	public void runLoginPage(String memId,String userId,String password) throws IOException {
	
		try {
			driver.findElement(By.id("membership")).sendKeys(memId);
			reportStep("memberid enterd successfully","pass");
		} catch (Exception e) {
			reportStep("memberid enterd wrongly","fail");
			e.printStackTrace();
		}
		try {
			driver.findElement(By.id("firstuserid")).sendKeys(userId);
			reportStep("userid enterd successfully","pass");
			
		} catch (Exception e) {
			reportStep("userid enterd wrongly","fail");
			e.printStackTrace();
		}
		try {
			driver.findElement(By.id("password")).sendKeys(password);
			reportStep("password enterd successfully","pass");
		} catch (Exception e) {
			reportStep("password enterd wrongly","fail");
			e.printStackTrace();
		}
		try {
			driver.findElement(By.name("commit")).click();
			reportStep("login successful","pass");
		} catch (Exception e) {
			reportStep("login failure","fail");
			e.printStackTrace();
		}
		
		
	}
	
	

}
