package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobuttondemo {

	public static WebDriver driver;
	 static  String   baseURL="https://www.seleniumeasy.com/test/charts-mouse-hover-demo.html";
	public static void main(String[] args) {
		String exepath=".\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exepath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='tree-branch']//a[@href='#'][contains(text(),'Input Forms')]")).click();
		driver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//a[contains(text(),'Radio Buttons Demo')]")).click();
		WebElement maleRadioButton=driver.findElement(By.xpath("//input[@value='Male']"));
		boolean radioBtnIsDisplayed=maleRadioButton.isDisplayed();
		System.out.println("Male radio button is displayed = " +radioBtnIsDisplayed);
		
		boolean radioBtnIsEnabled=maleRadioButton.isEnabled();
		System.out.println("Male radio button is enable = " +radioBtnIsEnabled);
		
		
		boolean radioBtnIsSelected=maleRadioButton.isSelected();
		System.out.println("Male radio button is selected = " +radioBtnIsSelected);
		
		maleRadioButton.click();
		
		WebElement femaleRadioButton=driver.findElement(By.xpath("//input[@value='Female']"));
		boolean femaleRadioBtnIsDisplayed=maleRadioButton.isDisplayed();
		System.out.println("Female radio button is displayed = " +femaleRadioBtnIsDisplayed);
		
		boolean femaleRadioBtnIsEnabled=maleRadioButton.isEnabled();
		System.out.println("female radio button is enabled = " +femaleRadioBtnIsEnabled);
		
		
		boolean femaleRadioBtnIsSelected=maleRadioButton.isSelected();
		System.out.println("Female radio button is selected = "+femaleRadioBtnIsSelected);
		
		femaleRadioButton.click();
		
		driver.findElement(By.id("buttoncheck")).click();
		
		driver.quit();
		

	}

}
