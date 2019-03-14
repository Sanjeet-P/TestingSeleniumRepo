package gspann;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multipletestbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Jars File\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String[] values= {"one","two","three","four","five"}
		
		List<WebElement> inputbox=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Number of inputbox="+inputbox.size());
		
		for(int i=0;i<values.length;i++) {
			
		}
		
		
	}

}
