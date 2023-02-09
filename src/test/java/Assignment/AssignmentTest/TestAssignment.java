package Assignment.AssignmentTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAssignment {

	@Test
	public void testAss() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://trello.com/en/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("user")).sendKeys("vgjadhav23@gmail.com");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("password")).sendKeys("Devansh@22");
		driver.findElement(By.id("login-submit")).click();
		
		driver.findElement(By.xpath("(//div[1])[@class='board-tile-details is-badged'][1]")).click();
		Thread.sleep(3000);
		Actions a=new Actions(driver);
		WebElement card1=driver.findElement(By.xpath("(//div[contains(@class,'list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable')])[1]"));
		
		a.dragAndDropBy(card1, 150, 0).build().perform();
		Point point = card1.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
		
		
		driver.close();
	}

}
