package gspann;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\Jars File\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://toolsqa.com/");
	}

}
