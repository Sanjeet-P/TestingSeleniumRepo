package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	 
	public WebDriver driver;
	
    String baseUrl="https://www.google.com/";
   
  @Test
  public void testNoParameter() {
	  
	  String author="guru99";
	  String searchKey="USA";
	  
	  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	   
	   WebElement searchText=driver.findElement(By.xpath("//input[@title='Search']"));
	   //Search the text in google
	   searchText.sendKeys(searchKey);
	  
	   System.out.println("Welcome->"+author+"Your search key is ->" +searchKey);
	   
	   /*WebElement googleSearchButton=driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']"));
	   googleSearchButton.click();*/
	   
	   driver.quit();
	  
	   	
	   
  }
}
