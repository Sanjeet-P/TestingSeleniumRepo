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

public class CheckoutFlowUAEKidsNewintab  {
	static String  mainurl="https://en-ae.6thstreet.com/";
	static  WebDriver driver;


	public static void main(String[] args) throws Exception {
		uaeKidsNewInTab();
	}

	public static void uaeKidsNewInTab() throws Exception {
		try {
			openingBrowser();
			verifyURL();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			   
			selectProduct();			
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
			FirstClass.takeSnapShot(driver, ".//ScreenShots//catchCheckoutFlowUAEKidsNewINTab.png");
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

	public static void selectProduct() throws Exception {
		WebElement women=driver.findElement(By.xpath("//a[@title=\"Kids Store\"]"));
		women.click();
		WebElement new_In=driver.findElement(By.linkText("NEW IN"));
		Actions action = new Actions(driver);
		action.moveToElement(new_In).click().build().perform();
		WebElement product=driver.findElement(By.xpath("//div[@class='col-md-12']//div[2]//li[1]//div[1]//a[1]//img[1]"));
		action.moveToElement(product).click().build().perform();	


	}


	public static void clickOnAddToBagButton() throws Exception {

		WebElement size=driver.findElement(By.xpath("//select[@name='super_attribute[139]']"));
		size.click();

		Select sizeValue=new Select(size);
		List<WebElement> Sizeofdropdown = sizeValue.getOptions();
		int iListSize = Sizeofdropdown.size();

		// Setting up the loop to print all the options
		for(int i =0; i < iListSize ; i++){
			// Storing the value of the option 
			String sValue = sizeValue.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal to '5Y' then select it 
			if(sValue.equals("5Y")){
				sizeValue.selectByIndex(i);
				break;
			}
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
		email_address.sendKeys("testing@test.com");

		WebElement clickOnContinueAsGuestButton=driver.findElement(By.xpath("//span[contains(text(),'Continue as guest')]"));
		clickOnContinueAsGuestButton.click();
		Thread.sleep(3000);
	}

	public static void shippingAddress() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));

		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.clear();
		firstName.sendKeys("test");

		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.clear();
		lastName.sendKeys("automation");

		WebElement address=driver.findElement(By.xpath("//input[@name='street[0]']"));
		address.sendKeys("Street 120 United state 36 B");
		Thread.sleep(1000);
		WebElement city=driver.findElement(By.xpath("//select[@name='city']"));
		city.click();
		Select cityname=new Select(city);
		cityname.selectByValue("Abu Dhabi");
		Thread.sleep(1000);
		WebElement  area=driver.findElement(By.xpath("//select[@name='postcode']"));
		area.click();
		Select areaname=new Select(area);
		areaname.selectByValue("Abu Dhabi Beach");
		Thread.sleep(1000);
		WebElement carrier=driver.findElement(By.xpath("//select[@name='cn_carriercode']"));
		carrier.click();
		Select carrer_name=new Select(carrier);
		carrer_name.selectByValue("55");
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
				System.out.println("Successfully Verifed UAE Checkout flow For Kids New In Tab");
				FirstClass.takeSnapShot(driver, ".//ScreenShots//SuccessfullyVerifiedCheckoutFlowUAEKidsNewIntab.png");

			}else{
				System.out.println("Error Coming while verifed UAE Checkout flow For Women New In Tab");
				FirstClass.takeSnapShot(driver, ".//ScreenShots//ErrorComingInCheckoutFlowUAEKidsNewIntab.png");
			}			
		}
		catch(Exception e){
			e.getMessage();			
		}
	}
	public static void closeWindow() {
		// Close the driver
		driver.quit();
	}

}









