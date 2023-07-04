package jun12jun16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Learngetvalue {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement webElement = driver.findElement(By.xpath("//span[text()='Save']"));
		String color = webElement.getCssValue("color");
		System.out.println(color);
		WebElement element = driver.findElement(By.xpath("//span[text()='Submit']"));
		Point location = element.getLocation();
		
		System.out.println(location);
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
		Dimension size = element1.getSize();
		System.out.println(size);
		
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Success']"));
		String precolor = element2.getCssValue("color");
		System.out.println(precolor);
		
		Actions mv = new Actions(driver);
		
	   mv.moveToElement(element2).perform();
	   String changedcolor = element2.getCssValue("color");
	   System.out.println(changedcolor);
	   System.out.println(Color.fromString(changedcolor).asHex());
	   
		
	}

}
