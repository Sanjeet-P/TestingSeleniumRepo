package com.sixthstreet;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstClass {
	static String  mainurl="https://en-kw.6thstreet.com/";

	public static void main(String[] args) throws Exception {		
		System. setProperty("webdriver.chrome.driver", ".//drivers//chromedriver2.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(mainurl);
		System.out.println("Successfully opened the website https://en-kw.6thstreet.com/");
		// Verify the URL
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		boolean liveURLstatus =driver.getCurrentUrl().contains(mainurl);
		driver.manage().window().maximize();		
//		driver.switchTo().defaultContent();
		if(liveURLstatus)
		{
			System.out.println("URL matched with the desire URL");	
			FirstClass.takeSnapShot(driver, ".//ScreenShots//VerifyURL.png");
		} else{
			System.out.println("URL do not matched with the desire URL");	
			FirstClass.takeSnapShot(driver, ".//ScreenShots//urlnotloaded.png");
		}
		// Close the driver
		driver.quit();
	}

	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
