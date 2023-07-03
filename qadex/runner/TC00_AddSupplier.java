package qadex.runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.baseclass.BaseClass;
import qadex.pages.AddSupplier;
import qadex.pages.HomePage;
import qadex.pages.LogOut;
import qadex.pages.LoginPage;

public class TC00_AddSupplier extends BaseClass{
	
	@BeforeTest
	public void Data() {
		testcase="Add Supplier";
		testDescription="To Verify Add supplier for valid data";
		authorName="Qadex";
		testType="smoke";
		testName = "valid Add Aupplier";
		dataSheetName = "TC003_AddSupplier";
		
	}
	
	@Test(dataProvider="setData")
	public void runAddSupplier(String memid,String userid,String password,String msg,String compName,String contName,String phone,String email) throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.enterMemberId(memid).enterUserId(userid).enterPassword(password).clickLoginButton(msg);
		hp.clickSupplierInformation().clickAddNewSupplier();
		AddSupplier sp= new AddSupplier(driver);
		sp.enterCompanyName(compName).enterContactNmame(contName).enterTelephoneNo(phone).enterEmailId(email).onClickSave();
		
		hp.clickSelfAudit().clickRequestSelfAudit().onclickSelectSupplier().runRequestSelfAudit().onclickRequest();
		hp.clickSupplierSpecification().clickRequestSpecification().clickSlectSupplierSpecification().runRequestSpecification()
		.runSelectProduct().onclickRequestForSpecification();
		
		Thread.sleep(5000);
		LogOut lo= new LogOut(driver);
		lo.runLogOut();
	}
	

}
