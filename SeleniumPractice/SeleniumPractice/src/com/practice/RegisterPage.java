package com.practice;


//package com.selenium;

import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
 
	public static void main(String[] args) throws InterruptedException {
		String gender_male="male";
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		Thread.sleep(500);
		//System.out.println("The URL of the Page is = " +driver.getCurrentUrl());
		System.out.println("The title of the Page is = " +driver.getTitle());
		WebElement registerButton=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		registerButton.click();
		System.out.println("The current url of the Register page = :" +driver.getCurrentUrl());
		System.out.println("The title of the page ;"+driver.getTitle());
		
		WebElement fullName_first_name=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		fullName_first_name.sendKeys("Sanjeet");
		WebElement fullName_last_name=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		fullName_last_name.sendKeys("Panda");
		WebElement address_text=driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']"));
		address_text.sendKeys("Kishangarh, Vasant kunj, New Delhi-110070");
		WebElement email_address=driver.findElement(By.xpath("//input[@type='email']"));
		email_address.sendKeys("sanjeet.panda@gspann.com");
		WebElement phone=driver.findElement(By.xpath("//input[@type='tel']"));
		phone.sendKeys("+91-9873423180");
		if(gender_male=="male") {
		WebElement gender_male_button=driver.findElement(By.xpath("//input[@value='Male']"));
		gender_male_button.click();
		
		System.out.println("Male button is clicked");
		}
		else
		{
			WebElement gender_female_button=driver.findElement(By.xpath("//input[@value='FeMale']"));
			gender_female_button.click();
			System.out.println("Female button is clicked");
		}
		
		WebElement hobbies_cricket=(driver.findElement(By.xpath("//input[@value='Cricket']")));
		hobbies_cricket.click();
		System.out.println("Cricket radio button is clicked");
		
		WebElement language=driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']"));
		Thread.sleep(500);
		if(language.isEnabled()) {
			language.click();
			//WebElement english=driver.findElement(By.xpath("//li[@class='ng-scope ui-elemfocus']"));
			Select eng=new Select(driver.findElement(By.xpath("//li[@class='ng-scope ui-elemfocus']")));
			eng.selectByValue("English");
			//english.click();
		System.out.println("Language is English");
		Thread.sleep(500);
		WebElement confirm_password=driver.findElement(By.id("secondpassword"));
		confirm_password.click();
		}
		Thread.sleep(500);
		WebElement skills=driver.findElement(By.id("Skills"));
		skills.click();
		Select skills_select=new Select(skills);
		skills_select.selectByValue("SQL");
		System.out.println("SQL is selected");
		/*WebElement confirm_password=driver.findElement(By.id("secondpassword"));
		confirm_password.click();*/
		
		/*List<WebElement> countries=driver.findElements(By.id("countries"));
		System.out.println(countries.size());
		for(int i=0;i<countries.size();i++) {
			System.out.println(countries.get(i).getText());
		}
		*/
		WebElement countries=driver.findElement(By.id("countries"));
		Select skills_countries=new Select(countries);
		skills_countries.selectByValue("India");
		
		
		//Date Of Birth the Drop down
		WebElement selectCountry=driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']"));
		Select countrySelection=new Select(selectCountry);
		countrySelection.selectByValue("India");
			
		
		
		Select year=new Select(driver.findElement(By.xpath("//select[@placeholder='Year']")));
        year.selectByValue("1916");
		
        
        Select month=new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
        month.selectByValue("January");
        
        Select day=new Select(driver.findElement(By.id("daybox")));
        day.selectByValue("23");
        
        WebElement password=driver.findElement(By.id("firstpassword"));
        password.sendKeys("INDIA@#$12");
        
        WebElement confirmPassword=driver.findElement(By.id("secondpassword"));
        confirmPassword.sendKeys("INDIA@#$12");
        
        WebElement submit=driver.findElement(By.id("submitbtn"));
        submit.click();
		
		
		driver.quit();
		
		
		
		
	}	

	}



