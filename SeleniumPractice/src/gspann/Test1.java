package gspann;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
	static public WebDriver driver;
	static String baseUrl = "https://www.jobserve.com/in/en/Job-Search/";

	public static void main(String[] args) {
		
		driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement searchTab=driver.findElement(By.xpath("//a[@href='/in/en/JobSearch.aspx']"));
        searchTab.click();
        driver.quit();
        
        
        
        
		

	}

}
