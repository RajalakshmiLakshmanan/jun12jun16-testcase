package qadex.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.baseclass.BaseClass;
import qadex.pages.LoginPage;

public class TC002_LoginNegative extends BaseClass{
	
	@BeforeTest
	public void Data() {
		testcase="login page";
		testDescription="Login negative test";
		authorName="Qadex";
		testType="smoke";
		testName = "loginPagetest";
		dataSheetName = "logindata";
		
	}
	@Test(dataProvider="setData")
	public void runLoginNegative(String memid,String userid,String password,String status,String msg ) throws IOException, InterruptedException {

		System.out.println("Enter here "+memid+" "+userid+" "+password+" " +status+" "+msg);
	
		LoginPage lp =new LoginPage(driver);
		lp.enterMemberId(memid).enterUserId(userid).enterPassword(password)
		.clickLoginButton(status).verifyLoginPage(msg);
		
		
	}

}
