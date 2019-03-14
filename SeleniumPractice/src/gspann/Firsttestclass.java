package gspann;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Firsttestclass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Jars File\\Selenium\\chromedriver_win32\\chromedriver.exe");
          WebDriver driver=new ChromeDriver();
          driver.get("http://store.demoqa.com/");
          driver.manage().window().maximize();
         /* driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          driver.findElement(By.className("account_icon")).click();
          driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
          driver.findElement(By.id("user_login")).sendKeys("Sanjeet");
          driver.findElement(By.id("user_email")).sendKeys("sanjeet.panda@gspann.com");
          driver.findElement(By.id("wp-submit")).click();
          driver.findElement(By.id("log")).sendKeys("Sanjeet");
          driver.findElement(By.id("pwd")).sendKeys("Password");
          driver.findElement(By.id("login")).click();*/
          WebElement productCategory=driver.findElement(By.xpath("//a[contains(text(),'Product Category')]"));
         Actions action=new Actions(driver);
         action.moveToElement(productCategory).build().perform();
         driver.findElement(By.linkText("iPads")).click();;
         driver.findElement(By.xpath("//a[contains(text(),'Grid')]")).click();
          
          driver.close();
	}

}
