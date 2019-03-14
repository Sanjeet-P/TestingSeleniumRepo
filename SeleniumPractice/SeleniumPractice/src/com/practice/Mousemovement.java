package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousemovement {
	
	static WebDriver driver;
	static String  baseURL="https://www.hdfc.com/";
	static String expectedurl="./drivers/chromedriver.exe";
	static String expectedurls="./drivers/geckodriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",expectedurl);
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.id("navbarDropdown")).click();
		Actions act1=new Actions(driver);
		WebElement we=driver.findElement(By.linkText("For Home Loans"));
		act1.moveToElement(we).perform();
		System.out.println("Test case one Pass");
		
		
		WebElement customerlogin=driver.findElement(By.linkText("Customer Login"));
		Actions act2=new Actions(driver);
		act2.moveToElement(customerlogin).perform();
		System.out.println("Test case two pass");
		driver.quit();
		
		
	}

}
