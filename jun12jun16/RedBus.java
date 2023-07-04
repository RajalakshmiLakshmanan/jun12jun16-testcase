package jun12jun16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*Testcase:1
==========
01) Launch Firefox / Chrome and add  implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
02) Load https://www.redbus.in/
03) Type ""Chennai"" in the FROM text box
04) Click the first option from the pop up box
05) Type ""Bangalore"" in the TO text box
06) Click the first option from the pop up box
07) Select tomorrow's date in the Date field
08) Click Search Buses
09) Print the number of buses shown as results (104 Buses found) (use .getText())
10) Choose SLEEPER in the left menu 
11) Print the name of the second resulting bus (use .getText())
12) Get the Title of the page(use .getTitle())
*/

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
	  ChromeOptions option= new ChromeOptions();
	  option.addArguments("remote-allow-origins=*");
	  option.addArguments("--disable-notifications");
	  ChromeDriver driver= new ChromeDriver(option);
	  driver.get("https://www.redbus.in/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      
	  //
	  WebElement element3 = driver.findElement(By.xpath("//label[text()='From']"));
	  driver.executeScript("arguments[0].click();", element3);
	  //element.clear();
	  //WebElement element = driver.findElement(By.xpath("//div[@class='sc-gzVnrw bSzhQs']"));
	  WebElement element = driver.findElement(By.xpath("//input[@id='src']"));
	  element.sendKeys("Chennai");
 // WebElement from = driver.findElement(By.xpath("(//div[@class='sc-gZMcBi grvhsy'])[1]"));
  //from.click();
//	  Actions ac= new Actions(driver);
//	  ac.moveToElement(from).click().perform();
	  WebElement element2 = driver.findElement(By.xpath("//input[@id='dest']")); 
	  
	  element2.sendKeys("bangalore");
	 
	  driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();
	  
	  driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 fgdqFw']")).click();
	  
	  Thread.sleep(2000);
	 // driver.findElement(By.xpath("//button[text()='SEARCH BUSES']")).click();
	  WebElement element4 = driver.findElement(By.xpath("//button[text()='SEARCH BUSES']"));
	  Actions ac= new Actions(driver);
	  ac.doubleClick(element4).perform();
	  //driver.executeScript("arguments[0].click();", element4);
	  System.out.println("clicked");
	  
	  String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
	  System.out.println(text);
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
	  String text2 = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
	  System.out.println(text2);
	  System.out.println(driver.getTitle());
	  driver.close();
	  
	}

}
