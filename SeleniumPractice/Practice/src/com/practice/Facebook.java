package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	static WebDriver driver;
	static String baseurl="https://www.facebook.com/";
	static String exepath=".//drivers//chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",exepath);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseurl);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("sex")).click();
		System.out.println("Men is selected");
		driver.quit();

	}

}
