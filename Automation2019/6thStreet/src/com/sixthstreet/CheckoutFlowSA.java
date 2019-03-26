package com.sixthstreet;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutFlowSA {
	static String  mainurl="https://en-sa.6thstreet.com/";
	static  WebDriver driver;
	

	public static void main(String[] args) throws Exception {
		//womenNewInTabforSA();
		//menNewInTabforSA();
		kidsNewInTabforSA();
		
	}
	
	public static void womenNewInTabforSA() throws Exception {
		try {
			openingBrowser();
			verifyURL();		   
			selectProduct();			
			//verifyAddToBagtPresent();
			clickOnAddToBagButton();			   
			clickOnCheckoutButton();
			clickonContinueAsGuestButton();
			shippingAddress();
			verifyPaymentPage();
			/*MailerUtil mail = new MailerUtil();
			mail.sendMail();*/
			closeWindow();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());			
			FirstClass.takeSnapShot(driver, ".//ScreenShots//catchCheckoutFlowSA.png");
			driver.quit();
		}
		
		
	}
	
	public static void menNewInTabforSA() throws Exception {
		try {
			openingBrowser();
			verifyURL();			   
			selectProductForMenNewInTab();			
			clickOnAddToBagButton();			   
			clickOnCheckoutButton();
			clickonContinueAsGuestButton();
			shippingAddress();
			verifyPaymentPage();
			/*MailerUtil mail = new MailerUtil();
			mail.sendMail();*/
			closeWindow();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());			
			FirstClass.takeSnapShot(driver, ".//ScreenShots//catchCheckoutFlowSA.png");
			driver.quit();
		}
		
		
		
	}
	
	public static void kidsNewInTabforSA() throws Exception {
		try {
			openingBrowser();
			verifyURL();			   
			selectProductForKidNewInTab();			
			clickOnAddToBagButton();			   
			clickOnCheckoutButton();
			clickonContinueAsGuestButton();
			shippingAddress();
			verifyPaymentPage();
			/*MailerUtil mail = new MailerUtil();
			mail.sendMail();*/
			closeWindow();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());			
			FirstClass.takeSnapShot(driver, ".//ScreenShots//catchCheckoutFlowSA.png");
			driver.quit();
		}
		
		
		
	}
	
	public static void openingBrowser() {
		
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System. setProperty("webdriver.chrome.driver", ".//drivers//chromedriver2.exe");
		driver=new ChromeDriver(ops);
		driver.get(mainurl);
		
	}


	public static void verifyURL() throws Exception {

		// Verify the URL
	
		boolean liveURLstatus =driver.getCurrentUrl().contains(mainurl);
		driver.manage().window().maximize();		
		
		if(liveURLstatus)
		{
			System.out.println("URL matched with the desire URL");	
			FirstClass.takeSnapShot(driver, ".//ScreenShots//VerifyURL.png");
		} else{
			System.out.println("URL do not matched with the desire URL");	
			FirstClass.takeSnapShot(driver, ".//ScreenShots//urlnotloaded.png");
		}
	}
	public static void selectProductForMenNewInTab() throws Exception {
		WebElement men=driver.findElement(By.xpath("//a[@title=\"Men's Store\"]"));
		men.click();
		Thread.sleep(1000);
		WebElement new_In=driver.findElement(By.linkText("NEW IN"));
		Actions action = new Actions(driver);
        action.moveToElement(new_In).click().build().perform();
        Thread.sleep(1000);
		WebElement product=driver.findElement(By.xpath("//div[@id='instant-search-results-container']//div[2]//li//div[1]//a[1]"));
		action.moveToElement(product).click().build().perform();	
		
	}
	
	public static void selectProductForKidNewInTab() throws Exception {
		WebElement men=driver.findElement(By.xpath("//a[@title='Kids Store']"));
		men.click();
		Thread.sleep(1000);
		WebElement new_In=driver.findElement(By.linkText("NEW IN"));
		Actions action = new Actions(driver);
        action.moveToElement(new_In).click().build().perform();
        Thread.sleep(1000);
		WebElement product=driver.findElement(By.xpath("//div[@id='instant-search-results-container']//div[2]//li//div[1]//a[1]"));
		action.moveToElement(product).click().build().perform();	
		
	}
	
	public static void selectProduct() throws Exception {
		WebElement women=driver.findElement(By.xpath("//a[@title=\"Women's Store\"]"));
		women.click();
	
	
		WebElement new_In=driver.findElement(By.linkText("NEW IN"));
		Actions action = new Actions(driver);
        action.moveToElement(new_In).click().build().perform();
		
		WebElement product=driver.findElement(By.xpath("//div[@class='ais-hits']//div[1]//li[1]//div[1]//a[1]//img[2]"));
		action.moveToElement(product).click().build().perform();	
		
		
	}
	
	public static void clickOnAddToBagButton() throws Exception {
		if(driver.findElement(By.xpath("//select[@name='super_attribute[139]']")).isDisplayed()){
			Select sizeValue=new Select((driver.findElement(By.xpath("//select[@name='super_attribute[139]']"))));
			List<WebElement> Sizeofdropdown = sizeValue.getOptions();
			int iListSize = Sizeofdropdown.size();
			for(int i =0; i < iListSize ; i++){
				
				String sValue = sizeValue.getOptions().get(i).getText();
				sizeValue.selectByIndex(i);
				
			}
			
			
		}else {
		WebElement color=driver.findElement(By.xpath("//div[@class='swatch-option']"));
		Actions action = new Actions(driver);
		action.moveToElement(color).click().build().perform();
		}
		WebElement addToBag=driver.findElement(By.xpath("//span[contains(text(),'ADD TO BAG')]"));
		Actions action = new Actions(driver);
		action.moveToElement(addToBag).click().build().perform();
		System.out.println("Clicked on Add To Bag");
		
		
	}
	
	public static void clickOnCheckoutButton() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to Checkout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to Checkout')]")).click();
		
	}
	
	public static void clickonContinueAsGuestButton() throws Exception {
		WebElement email_address=driver.findElement(By.xpath("//input[@name='username']"));
		email_address.sendKeys("sanjeetpanda2014@yahoo.com");
		
		WebElement clickOnContinueAsGuestButton=driver.findElement(By.xpath("//span[contains(text(),'Continue as guest')]"));
		clickOnContinueAsGuestButton.click();
		Thread.sleep(3000);
	}
	
	public static void shippingAddress() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
		Thread.sleep(1000);
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.clear();
		firstName.sendKeys("test");
		Thread.sleep(1000);
		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.clear();
		lastName.sendKeys("automation");
		Thread.sleep(1000);
		WebElement address=driver.findElement(By.xpath("//input[@name='street[0]']"));
		address.sendKeys("Street 120 United state 36 B");
		Thread.sleep(1000);
		WebElement city=driver.findElement(By.xpath("//select[@name='city']"));
		city.click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//select[@name='city']")).isDisplayed()){
			Select cityValue=new Select(driver.findElement(By.xpath("//select[@name='city']")));
			List<WebElement> Sizeofdropdown = cityValue.getOptions();
			int iListSize = Sizeofdropdown.size();
			for(int i =0; i < iListSize ; i++){
				
				String sValue = cityValue.getOptions().get(i).getText();
				cityValue.selectByIndex(i);	
			}				
		}
		//cityname.selectByValue("Abqaiq");
		
		WebElement  area=driver.findElement(By.xpath("//select[@name='postcode']"));
		area.click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//select[@name='postcode']")).isDisplayed()){
			Select postCodeValue=new Select(driver.findElement(By.xpath("//select[@name='postcode']")));
			List<WebElement> sizeofdropdown = postCodeValue.getOptions();
			int iListSizes = sizeofdropdown.size();
			for(int i =0; i < iListSizes ; i++){
				String sValue = postCodeValue.getOptions().get(i).getText();
				postCodeValue.selectByIndex(i);
				
			}
				
		}	
		
		Thread.sleep(1000);
		WebElement carrier=driver.findElement(By.xpath("//select[@name='cn_carriercode']"));
		carrier.click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//select[@name='cn_carriercode']")).isDisplayed()){
			Select carrierValue=new Select(driver.findElement(By.xpath("//select[@name='cn_carriercode']")));
			List<WebElement> sizeofdropdown = carrierValue.getOptions();
			int iListSizes = sizeofdropdown.size();
			for(int i =0; i < iListSizes ; i++){
				String sValue = carrierValue.getOptions().get(i).getText();
				carrierValue.selectByIndex(i);
				
			}
				
		}	
//		Select carrer_name=new Select(carrier);
//		carrer_name.selectByValue("57");
		Thread.sleep(1000);
		WebElement contractNo=driver.findElement(By.xpath("//input[@name='contact']"));
		contractNo.sendKeys("4532167");
		Thread.sleep(1000);
		WebElement proceedToPayment=driver.findElement(By.xpath("//form[@class='form methods-shipping']//button[@type='submit']"));
		proceedToPayment.click();		
		Thread.sleep(5000);

	}
	
	public static void verifyPaymentPage() {
		try {			
			if(driver.findElement(By.xpath("//div[@class='step-title active'][contains(text(),'3. Payment')]")).isDisplayed())
			{
				System.out.println("Successfully Verifed Saudi Arabia Checkout flow For New In Tab");
				FirstClass.takeSnapShot(driver, ".//ScreenShots//SuccessfullyVerifiedCheckoutFlowSa.png");
				
			}else{
				System.out.println("Error Coming while verifed Saudi Arabia Checkout flow For New In Tab");
				FirstClass.takeSnapShot(driver, ".//ScreenShots//ErrorComingInCheckoutFlowSa.png");
			}			
		}
		catch(Exception e){
			e.getMessage();			
		}
	}
		public static void closeWindow() {
		
		driver.quit();
	}
}

