package com.practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jqwidget {
	static WebDriver driver;
	static String baseurl="https://www.google.com/";
	static String exepath=".//drivers//chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",exepath);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseurl);
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("drag and drop jqwidget");
		 driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
		 driver.findElement(By.xpath("//h3[contains(text(),'jQuery DragDrop, DragDrop plug-in, Drag and Drop .')]")).click();
		 
		 WebElement we=driver.findElement(By.xpath("//div[@role='gridcell']"));
		 driver.switchTo().frame(we);
		WebElement we1= driver.findElement(By.xpath("span[contains(text(),'No data to display')])"));
		System.out.println("frame name= " +we1.getText());

	}

}
