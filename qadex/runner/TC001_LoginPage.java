package qadex.runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.baseclass.BaseClass;
import qadex.pages.LoginPage;

public class TC001_LoginPage extends BaseClass{
	
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
	public void runLoginPage(String memid,String userid,String password) throws IOException {
		   LoginPage lp = new LoginPage(driver);
		   lp.enterMemberId(memid).enterUserId(userid).enterPassword(password).clickLoginButton();
		
	}

}
