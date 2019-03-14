package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Draganddrop {

	static WebDriver driver;
	static String baseurl="http://demo.guru99.com/test/drag_drop.html";
	static String exepath=".//drivers//chromedriver.exe";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",exepath);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseurl);
		 WebElement bank=driver.findElement(By.linkText("BANK"));
		 WebElement account=driver.findElement(By.id("bank"));
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Actions drag=new Actions(driver);
		 drag.dragAndDrop(bank, account).perform();
		 System.out.println("Drag and drop is complete");
		 
		 WebElement amount=driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
		 WebElement amount1=driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
		 Actions move=new Actions(driver);
		 move.dragAndDrop(amount,amount1).perform();
		 
		 WebDriverWait wait=new WebDriverWait(driver,50);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[1]//table[1]//tbody[1]//tr[1]//td[2]//div[1]//h3[1]")));
		 
		 driver.quit();

	}

}
