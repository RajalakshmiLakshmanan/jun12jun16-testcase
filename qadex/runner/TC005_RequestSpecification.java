package qadex.runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.baseclass.BaseClass;
import qadex.pages.HomePage;
import qadex.pages.LogOut;
import qadex.pages.LoginPage;

public class TC005_RequestSpecification extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="Request SPecifation";
		testDescription="To check Request Specification funtion";
		authorName="Qadex";
		testType="sanity";
		testName = "Request Specification";
		dataSheetName = "login";
		
	}
	
	@Test(dataProvider="setData")
	public void runLoginPage(String memid,String userid,String password,String msg) throws IOException, InterruptedException {
		   LoginPage lp = new LoginPage(driver);
		   lp.enterMemberId(memid).enterUserId(userid).enterPassword(password).clickLoginButton(msg);
		   HomePage hp = new HomePage(driver);
		   hp.clickSupplierSpecification().clickRequestSpecification().clickSlectSupplierSpecification().runRequestSpecification()
		   .runSelectProduct().onclickRequestForSpecification();
		   
		   Thread.sleep(5000);
		   LogOut lg = new LogOut(driver);
		   lg.runLogOut();
		   
		  
	}

}
