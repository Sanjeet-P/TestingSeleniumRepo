package TestNG;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login {
	private static final String email = null;
	private static final String password = null;
	public  WebDriver driver=new ChromeDriver();
  
  @BeforeTest
  public void beforeTest() {
	  WebDriver driver=new ChromeDriver();
	  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	  driver.manage().window().maximize();
	  driver.get("file:///C:/Users/sanjeet.panda/AppData/Local/Microsoft/Windows/INetCache/Content.Outlook/9ZKTI6ZQ/login_page.html");
	  
  }
  
  @Parameter(email,password)
  @Test
  public void login(String email,String password) {
	  driver.findElement(By.xpath("//input[@name='email']"));
	  driver.findElement(By.xpath("//input[@name='pwd']"));
      driver.findElement(By.xpath("//input[@type='button']")).click();
      System.out.println("Now you are in secondary password page");
      String expected="Login";
	  String actual=driver.getTitle();
	  Assert.assertEquals(expected, actual);
	  System.out.println("Test case is passed");
      
	  
  }
  
  
  @Parameter(email1,password1)
  @Test
  public void invalid(String email,String password1) {
	  driver.findElement((By.xpath("//input[@name='email']")));
	  driver.findElement(By.xpath("//input[@name='pwd']"));
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	  String expected_password1="eW5PEXgz";
	  String actual_password1="";
	  Assert.assertNotEquals(expected_password1, actual_password1);
	  System.out.println("Invaild e-mail or [assword");
	  
	  }
  
 
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
