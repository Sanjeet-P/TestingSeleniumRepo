package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JobServe {
	static WebDriver driver;
	static String baseurl="https://www.jobserve.com/in/en/Job-Search/";
	static String exepath=".//drivers//chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",exepath);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseurl);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[@href='/in/en/JobSearch.aspx']")).click();
		 WebElement we1=driver.findElement(By.xpath("//span[@class='ui-dropdownchecklist-selector ui-state-default ui-state-active']"));
         we1.click();
		 Select s1=new Select(we1);
         s1.selectByVisibleText("Select All Industries");
         driver.quit();
	}

}
