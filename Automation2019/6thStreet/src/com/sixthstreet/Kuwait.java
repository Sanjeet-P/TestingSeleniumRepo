package com.sixthstreet;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Kuwait {
	static String  mainurl="https://en-kw.6thstreet.com/";
	static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{
		try {
//			verifyMainURL();
//			kwVerifyPricingOnWomenNewInTab();
			kwVerifyPricingOnWomenSaleTab();

		} catch (Exception e) {
			System.out.println(e.getMessage());			
			FirstClass.takeSnapShot(driver, ".//ScreenShots//kw.catch.png");
			driver.quit();
		}	


	}

	public static void kwVerifyPricingOnWomenNewInTab()  throws Exception {
		launchBrowser();
		int newin_productpagevalue;
		int productdetailspagevalue;
		String brandname=null;
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("NEW IN")).click();
		explicteWait(2);
		//		System.out.println(driver.findElement(By.xpath("//*[@class='price' and @xpath='1']")).getText());
		//		driver.findElement(By.xpath("//*[@xpath='1']")).click();
		//		explicteWait(2);

		System.out.println("On NEW IN page First Product Name is : "+(brandname=driver.findElement(By.xpath("//*[@class='brand_name']")).getText()));
		System.out.println("On NEW IN page First Product Price value is : "+driver.findElement(By.xpath("//*[@class='price']")).getText());
		newin_productpagevalue=Integer.parseInt(driver.findElement(By.xpath("//*[@class='price']")).getText().split("\\s+")[1].split("\\.")[0]);
		//		System.out.println(newin_productpagevalue);
		explicteWait(2);
		driver.findElement(By.xpath("//*[@class='product_image arw-hover-actions arw-hover-image']")).click();
		explicteWait(2);
		productdetailspagevalue=Integer.parseInt(driver.findElement(By.xpath("//*[@class='price']")).getText().split("\\s+")[1].split("\\.")[0]);
		if (newin_productpagevalue==productdetailspagevalue) 
		{
			System.out.println("Method : kwVerifyPricingOnWomenNewInTab Both page product value is matched,\nProduct brand name is : "+brandname+"\nNew In product page value is : "+newin_productpagevalue+
					"\nProduct Details page value is : "+productdetailspagevalue);
			takeSnapShot(driver, ".//ScreenShots//kw.NewInProductPriceMatched.png");
		} else {
			System.out.println("Method : kwVerifyPricingOnWomenNewInTab Both page product value is miss matched,\nProduct brand name is : "+brandname+"\nNew In product page value is : "+newin_productpagevalue+
					"\nProduct Details page value is : "+productdetailspagevalue);
			takeSnapShot(driver, ".//ScreenShots//kw.NewInProductPriceMissMatched.png");
		}
		browserQuit();
	}
	
	public static void kwVerifyPricingOnWomenSaleTab()  throws Exception {

		launchBrowser();
		int newin_productpagevalue;
		int productdetailspagevalue;
		String brandname=null;
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("SALE")).click();
		explicteWait(2);
		System.out.println("On NEW IN page First Product Name is : "+(brandname=driver.findElement(By.xpath("//*[@class='brand_name']")).getText()));
		System.out.println("On NEW IN page First Product Price value is : "+driver.findElement(By.xpath("//*[@class='price']")).getText());
		newin_productpagevalue=Integer.parseInt(driver.findElement(By.xpath("//*[@class='price']")).getText().split("\\s+")[1].split("\\.")[0]);
		//		System.out.println(newin_productpagevalue);
		explicteWait(2);
		driver.findElement(By.xpath("//*[@class='product_image arw-hover-actions arw-hover-image']")).click();
		explicteWait(2);
		productdetailspagevalue=Integer.parseInt(driver.findElement(By.xpath("//*[@class='price']")).getText().split("\\s+")[1].split("\\.")[0]);
		if (newin_productpagevalue==productdetailspagevalue) 
		{
			System.out.println("Method : kwVerifyPricingOnWomenSaleTab Both page product value is matched,\nProduct brand name is : "+brandname+"\nNew In product page value is : "+newin_productpagevalue+
					"\nProduct Details page value is : "+productdetailspagevalue);
			takeSnapShot(driver, ".//ScreenShots//kw.SaleProductPriceMatched.png");
		} else {
			System.out.println("Method : kwVerifyPricingOnWomenSaleTab Both page product value is miss matched,\nProduct brand name is : "+brandname+"\nNew In product page value is : "+newin_productpagevalue+
					"\nProduct Details page value is : "+productdetailspagevalue);
			takeSnapShot(driver, ".//ScreenShots//kw.SaleProductPriceMissMatched.png");
		}
		browserQuit();	
		
	}

	public static void launchBrowser() throws Exception {
		ChromeOptions options = new ChromeOptions();
		//		options.addArguments("--disable-notifications");		
		System. setProperty("webdriver.chrome.driver", ".//drivers//chromedriver2.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(mainurl);
		explicteWait(3);
		System.out.println("Successfully opened the website https://en-kw.6thstreet.com/");
		Robot robot = new Robot();  // Robot class throws AWT Exception	
		//		explicteWait(2); // Thread.sleep throws InterruptedException	
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);	
		explicteWait(1);
	}

	public static void verifyMainURL() throws Exception
	{
		launchBrowser();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		explicteWait(3);
		boolean liveURLstatus =driver.getCurrentUrl().contains(mainurl);

		//		driver.switchTo().defaultContent();
		if(liveURLstatus)
		{
			System.out.println("URL matched with the desire URL");	
			FirstClass.takeSnapShot(driver, ".//ScreenShots//kw.VerifyURL.png");
		} else{
			System.out.println("URL do not matched with the desire URL");	
			FirstClass.takeSnapShot(driver, ".//ScreenShots//kw.urlnotloaded.png");
		}
		// Close the driver
		browserQuit();

	}

	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	public static void explicteWait(int a) throws InterruptedException{
		Thread.sleep(a*1000);
	}
	public static void browserQuit() {
		driver.quit();

	}
}
