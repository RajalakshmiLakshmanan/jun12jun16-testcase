package qadex.runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.baseclass.BaseClass;
import qadex.pages.LoginPage;

public class TC004_AddSupplierNegative extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="AddSupplier Negative Test";
		testDescription=" To verify AddSupplier by invalid testdata";
		authorName="Qadex";
		testType="smoke";
		testName = "Negative TestCase AddSupplier";
		dataSheetName = "supplierNegativedata";
		
	}
	@Test(dataProvider="setData")
	public void runAddSupplierNegative(String memid,String userid,String password,String compName,String contName,String phone,String email,String msg) throws IOException {
	LoginPage lp = new LoginPage(driver);
	lp.enterMemberId(memid).enterUserId(userid).enterPassword(password).onClickSignin()
	.clickSupplierInformation().clickAddNewSupplier().enterCompanyName(compName).enterContactNmame(contName).enterTelephoneNo(phone)
	.enterEmailId(email).verifyAddSupplier(msg);
		
		
	}
	
	

}
