package jun12jun16;
//1) Go to  https://www.nykaa.com/
//2) Mouseover on Brands and Search L'Oreal Paris
//3) Click L'Oreal Paris
//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
//5) Click sort By and select customer top rated
//6) Click Category and click Hair->Click haircare->Shampoo
//7) Click->Concern->Color Protection
//8)check whether the Filter is applied with Shampoo
//9) Click on L'Oreal Paris Colour Protect Shampoo
//10) GO to the new window and select size as 175ml
//11) Print the MRP of the product
//12) Click on ADD to BAG
//13) Go to Shopping Bag 
//14) Print the Grand Total amount
//15) Click Proceed
//16) Click on Continue as Guest
//17) Check if this grand total is the same in step 14
//18) Close all windows

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nyka {

	public static void main(String[] args) {

              ChromeOptions option = new ChromeOptions();
              option.addArguments("--remote-allow-origins=*");
              option.addArguments("--disable-notifications");
              ChromeDriver driver = new ChromeDriver(option);
              driver.get("https://www.nykaa.com/");
              driver.manage().window().maximize();
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
              
              WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
              WebElement paris = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));
              Actions ab  =new Actions(driver);
              ab.moveToElement(brands).click(paris).perform();
              System.out.println(driver.getTitle());
              
              driver.findElement(By.xpath("//button[@class='top css-1aucgde']")).click();
              driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
              driver.findElement(By.xpath("//span[text()='Category']")).click();
              
 
 
 
 
 
	}

}
