package gspann;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Autimation1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Jars File\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.id("email_create")).sendKeys("sanjeet.panda@gspann.com");
		
		//click on title
		driver.findElement(By.xpath("//span/i[@class='icon-user left']")).click();
		
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		//first name
		driver.findElement(By.id("customer_firstname")).sendKeys("Sanjeet");
		//last name
		driver.findElement(By.id("customer_lastname")).sendKeys("Panda");
		//password
		driver.findElement(By.id("passwd")).sendKeys("password");
		//selecting the date
		WebElement days=driver.findElement(By.id("days"));
		days.click();
		Select s1=new Select(days);
		s1.selectByIndex(12);
		//Select month
		WebElement monts=driver.findElement(By.id("months"));
		monts.click();
		Select s2=new Select(monts);
		s2.selectByValue("3");
		//select years
		WebElement years=driver.findElement(By.id("years"));
		years.click();
		Select s3=new Select(years);
		s3.selectByValue("2018");
		
		//Select the 1st check box
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		
		//select 2nd checkbox
		driver.findElement(By.id("optin")).click();
		
		//Entering data in to Address field
		driver.findElement(By.id("customer_firstname")).clear();
		driver.findElement(By.id("customer_firstname")).sendKeys("Sanjeet");
		driver.findElement(By.id("customer_lastname")).clear();
		driver.findElement(By.id("customer_lastname")).sendKeys("Panda");
		driver.findElement(By.id("company")).sendKeys("INDIA");
		driver.findElement(By.id("address1")).sendKeys("Kishangarh");
		driver.findElement(By.id("city")).sendKeys("New Delhi");
		
		WebElement state=driver.findElement(By.id("id_state"));
		state.click();
		Select s4=new Select(state);
		s4.selectByValue("5");
		driver.findElement(By.id("postcode")).sendKeys("110070");
		
		WebElement country=driver.findElement(By.id("id_country"));
		country.click();
		Select s5=new Select(country);
		s5.selectByValue("21");
		
		
		
		
		
		
		
	
		//driver.findElement(By.id("email")).sendKeys("sanjeet.panda@gspann.com");
//		driver.close();
		
	}

}
