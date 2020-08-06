package SampleTest.SampleTest;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import SampleTest.SampleTest.MyLogoTest;

import util.ExcelUtil;
import util.LogInPageObject;

public class MyLogoTest {
	
	Method[] methods = MyLogoTest.class.getMethods();
	
	WebDriver driver;

	@DataProvider(name = "readDataFromExcel")
	public Object[][] dataFromExcel(Method method) {
		Object[][] fetchDataFromExcel = null;

		try {

			String filePath = System.getProperty("user.dir") + "\\resources\\TestData.xlsx";
			System.out.println(filePath);
			fetchDataFromExcel = ExcelUtil.fetchDataFromExcel(filePath, "Login", method.getName());

		} catch (Exception dataFromExcel) {

			dataFromExcel.printStackTrace();

		}

		return fetchDataFromExcel;

	}
	
	@DataProvider(name = "singleTestCaseMultipleTimes")
	public Object[][] singleTestCaseMultipleTimes(Method method) {
		Object[][] fetchDataFromExcel = null;

		try {

			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
			System.out.println(filePath);
			fetchDataFromExcel = ExcelUtil.singleTestCaseMultipleTimes(filePath, "Login", method.getName());

		} catch (Exception dataFromExcel) {

			dataFromExcel.printStackTrace();

		}

		return fetchDataFromExcel;

	}
	
	@BeforeMethod(groups= {"single", "Multiple"})
	public void invokeBrowser() {
		
		driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "\\libs\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	
	//@Test(dataProvider="singleTestCaseMultipleTimes", groups= {"Multiple"})
	public void newMemberRegistration(Map<String, String> data) {
		
		try {
			
			LogInPageObject obj = new LogInPageObject(driver);
			String username = data.get("Username");			
			String firstName = data.get("FirstName");
			String lastName = data.get("LastName");
			Thread.sleep(3000);
			String password = data.get("Password");
			
			String company = data.get("Company");
			String address = data.get("Address");
			String addressLine2 = data.get("AddressLine2");
			String city = data.get("City");
			
			String postalCode = data.get("ZipPostalCode");
			
			String homePhone = data.get("HomePhone");
			String mobilePhone = data.get("MobilePhone");
			
			obj.register(username, firstName, lastName, password, company, address, addressLine2, city, postalCode, homePhone, 
					mobilePhone);
			
			
			Thread.sleep(3000);
			
		}catch(Exception logIn) {
			
			logIn.printStackTrace();
			
		}
		
	}
	
	
	@Test(dataProvider="readDataFromExcel", groups= {"single"}) 
	public void signIn(Map<String, String> data) {
		
		try {
			
			String username = data.get("Username");
			String password = data.get("Password");
			
			LogInPageObject obj = new LogInPageObject(driver);
			obj.alreadyRegisteredUserLogIn(username, password);
			
		}catch(Exception signIn) {
			
			signIn.printStackTrace();
			
		}
		
	}
	@Test(groups= {"single"})
	public void printedDress() {
		
		try {
			
			LogInPageObject obj = new LogInPageObject(driver);
			obj.Dresses();			
			
			
			
		}catch(Exception printedDress) {
			
			printedDress.printStackTrace();
			
		}
		
	}

	//@AfterMethod(groups= {"single", "Multiple"})
	public void afterTest() {
		
		driver.close();
		
	}
	
}