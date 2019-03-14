package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	static WebDriver driver;
	static String baseurl="https://www.google.com/";
	static String exepath=".//drivers//chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",exepath);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseurl);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 WebElement we=driver.findElement(By.xpath("//input[@title='Search']"));
		 we.sendKeys("WebTableExamples");
		 driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
		 WebElement we1=driver.findElement(By.xpath("//h3[contains(text(),'HTML Tables - W3Schools')]"));
		 System.out.println(we1.getText());
		 we1.click();
		 driver.quit();
	}

}
