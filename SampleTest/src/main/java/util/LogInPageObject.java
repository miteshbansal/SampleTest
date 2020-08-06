package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import util.LogInPageObject;

public class LogInPageObject {
	
	WebDriver driver;
	
	public static final String signInXpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a";
	public static final String emailXpath = "//*[@id='email_create']";
	public static final String createAnAcccountbtnXpath = "//*[@id='SubmitCreate']/span";
	public static final String titleXpath = "//*[@id='id_gender1']";
	public static final String firstNameXpath = "//*[@id='customer_firstname']";
	public static final String lastNameXpath = "//*[@id='customer_lastname']";
	public static final String registerPageEmailXpath = "//*[@id='email']";
	public static final String passwordXpath = "//*[@id='passwd']";
	public static final String days = "days";
	public static final String months = "months";
	public static final String years = "years";
	
	public static final String companyXpath = "//*[@id='company']";
	public static final String address1Xpath = "//*[@id='address1']";
	public static final String address2Xpath = "//*[@id='address2']";
	public static final String cityXpath = "//*[@id='city']";
	public static final String state = "id_state";
	public static final String postalCodeXpath = "//*[@id='postcode']";
	public static final String country = "id_country";
	public static final String homePhone = "//*[@id='phone']";
	public static final String mobile = "//*[@id='phone_mobile']";
	public static final String assign = "//*[@id='alias']";
	public static final String btnregister = "//*[@id='submitAccount']/span";
	
	//Already Registered
	
	public static final String btnSignInXpath = "//*[@id='SubmitLogin']/span";
	
	//Dresses
	
	public static final String lnkDresses = "//*[@id='block_top_menu']/ul/li[2]/a";
	public static final String eveDresses = "//*[@id='subcategories']/ul/li[2]/div[1]/a/img";
	public static final String printedDressesHover = "//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img";
	
	public LogInPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void register(String username, String firstName, String lastname, String password, String company, String address, String addressLine2, String city, 
			 String postalCode, String homePhone, String mobilePhone) {
		
try {
			
			driver.findElement(By.xpath(signInXpath)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(emailXpath)).sendKeys(username );
			driver.findElement(By.xpath(LogInPageObject.createAnAcccountbtnXpath)).click();
			driver.findElement(By.xpath(LogInPageObject.titleXpath)).click();
			driver.findElement(By.xpath(LogInPageObject.firstNameXpath)).sendKeys(firstName);
			driver.findElement(By.xpath(LogInPageObject.lastNameXpath)).sendKeys(lastname);
			//driver.findElement(By.xpath(LogInPageObject.registerPageEmailXpath)).sendKeys(data.get("Email"));
			Thread.sleep(3000);
			driver.findElement(By.xpath(LogInPageObject.passwordXpath)).sendKeys(password);
			Select days = new Select(driver.findElement(By.name(LogInPageObject.days)));
			days.selectByValue("28");
			
			//driver.findElement(By.id(LogInPageObject.months)).click();
			
			Select months = new Select(driver.findElement(By.id(LogInPageObject.months)));
			months.selectByIndex(5);
			
			Select years = new Select(driver.findElement(By.name(LogInPageObject.years)));			
			years.selectByValue("1971");
			
			driver.findElement(By.xpath(LogInPageObject.companyXpath)).sendKeys(company);
			driver.findElement(By.xpath(LogInPageObject.address1Xpath)).sendKeys(address);
			driver.findElement(By.xpath(LogInPageObject.address2Xpath)).sendKeys(addressLine2);
			driver.findElement(By.xpath(LogInPageObject.cityXpath)).sendKeys(city);
			
			Select state = new Select(driver.findElement(By.name(LogInPageObject.state)));
			state.selectByIndex(5);
			
			driver.findElement(By.xpath(LogInPageObject.postalCodeXpath)).sendKeys(postalCode);
			
			/*
			 * Select country = new
			 * Select(driver.findElement(By.name(LogInPageObject.country)));
			 * country(data.get("Country"));
			 */
			
			driver.findElement(By.xpath(LogInPageObject.homePhone)).sendKeys(homePhone);
			driver.findElement(By.xpath(LogInPageObject.mobile)).sendKeys(mobilePhone);
			//driver.findElement(By.xpath(LogInPageObject.assign)).sendKeys(data.get("AssignAnAddress"));
			driver.findElement(By.xpath(LogInPageObject.btnregister)).click();
			
			
			Thread.sleep(10000);
			
		}catch(Exception logIn) {
			
			logIn.printStackTrace();
			
		}
		
	}
	
	public void alreadyRegisteredUserLogIn(String username, String password) {
		
		try {
			
			driver.findElement(By.xpath(signInXpath)).click();
			driver.findElement(By.xpath(registerPageEmailXpath)).sendKeys(username);
			driver.findElement(By.xpath(passwordXpath)).sendKeys(username);
			driver.findElement(By.xpath(btnSignInXpath)).click();
			
			
		}catch(Exception alreadyRegisteredUserLogIn) {
			
			
			
		}
		
	}
	
	public void Dresses() {
			
			try {
				
			driver.findElement(By.xpath(lnkDresses)).click();
			driver.findElement(By.xpath(eveDresses)).click();
			WebElement element = driver.findElement(By.xpath(printedDressesHover));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			
			Actions actions = new Actions(driver);
			
			actions.moveToElement(element).perform();
			Thread.sleep(6000);
			
			element.click();
			
			
			}catch(Exception Dresses) {
				
				Dresses.printStackTrace();
				
			}
			
		}
	
}
