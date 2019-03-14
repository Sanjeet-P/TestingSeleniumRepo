package com.practice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Hdfcbank {
	static WebDriver driver;
	static String baseurl="https://www.hdfcbank.com/";
	static String exepath=".//drivers//chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",exepath);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseurl);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement we1=driver.findElement(By.xpath("//a[@class='mainlink'][contains(text(),'Products')]"));
		 
		 Actions act=new Actions(driver);
		 act.moveToElement(we1).perform();
		 System.out.println("Mouse over to Product tab");
		 
		 WebElement we2=driver.findElement(By.xpath("//a[@class='mainlink'][contains(text(),'Loans')]"));
		 Actions Loan=new Actions(driver);
		 Loan.moveToElement(we2).perform();
		 System.out.print(" Mouse over is Loan");
		 
		 WebElement we3=driver.findElement(By.xpath("//a[@href='/personal/products/loans/home-loan']"));
		 Actions homeloan=new Actions(driver);
		 homeloan.moveToElement(we3).perform();
		 System.out.print("Mouse over to Homeloan");
		 
		 System.out.println("The web page is" +we3.getText() );
		 we3.click();
		 System.out.println("home loan page is opened");
		 System.out.println("Test case Pass");
		 driver.quit();
		 
	}

}
