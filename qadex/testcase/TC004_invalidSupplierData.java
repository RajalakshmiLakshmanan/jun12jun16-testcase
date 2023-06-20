package qadex.testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qadex.BaseClass;

public class TC004_invalidSupplierData extends BaseClass{
	@BeforeTest
	public void Data() {
		testcase="Add Supplier";
		testDescription="using extentreport we see the output";
		authorName="Qadex";
		testType="sanity";
		testName = "AddSupplierNegativetest";
		dataSheetName="supplierNegativedata";
		
	}
	@Test(dataProvider="setData")
	public void runVerifySupplierData(String compName,String contactName,String phoneNo,String email,String msg) throws InterruptedException, IOException {
		System.out.println("Entering here " + compName + " " + contactName + " " + phoneNo );
		driver.findElement(By.id("membership")).sendKeys("QM54439");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		//driver.findElement(By.xpath("//a[text()='Go To New User Experience']")).click();
		driver.findElement(By.xpath("//span[text()='Supplier Information']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Supplier']")).click();
		if(compName !=null) {
		driver.findElement(By.id("user_compname")).sendKeys(compName);
		}
		driver.findElement(By.id("user_contname")).sendKeys(contactName);
		if (phoneNo != null) {
			driver.findElement(By.id("adduser_phone")).sendKeys(phoneNo);
		}
		System.out.println("Set all the values");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='1st Contact Email']")));
		System.out.println("Waiting 1");
		if( email !=null) {
			
		driver.findElement(By.xpath("//input[@placeholder='1st Contact Email']")).sendKeys(email);
		
		}
		System.out.println("Waiting 2");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		System.out.println("Waiting 3");
		Thread.sleep(3000);
		
		String text = driver.findElement(By.xpath("//div[@class='jBox-content']")).getText();
		
		System.out.println(text);
		try 
        {
        	System.out.println("check 1");
        	if(text.contains(msg)) {
        		
        		reportStep("expected result matches the actual text","pass");
        	}else {
        		reportStep("expected result doesn't matches actual text","fail");
        	}
        }catch(WebDriverException e) {
        		System.out.println("unexpected result came while verifying text");
        		
        	}
		
		
	}
	
}
