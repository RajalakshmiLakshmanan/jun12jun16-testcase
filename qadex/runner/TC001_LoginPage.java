package qadex.runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.baseclass.BaseClass;
import qadex.pages.LogOut;
import qadex.pages.LoginPage;

public class TC001_LoginPage extends BaseClass{
	
	@BeforeTest
	public void Data() {
		testcase="login page";
		testDescription="To verify login functionality";
		authorName="Qadex";
		testType="smoke";
		testName = "loginPagetest";
		dataSheetName = "logintestdata";
		
	}
	@Test(dataProvider="setData")
	public void runLoginPage(String memid,String userid,String password,String msg) throws IOException, InterruptedException {
		   LoginPage lp = new LoginPage(driver);
		   lp.enterMemberId(memid).enterUserId(userid).enterPassword(password).clickLoginButton(msg);
		   
		   
		  
	}

}
