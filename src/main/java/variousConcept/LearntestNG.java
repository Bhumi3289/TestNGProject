package variousConcept;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearntestNG {
	
	WebDriver driver;
	String browser = null;
	String url = null; 
	
	@BeforeClass
	public void readConfig() {
		
		// for properties file
		Properties prop = new Properties();
		
		try {
			
			// to read properties file
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			
			browser = prop.getProperty("browser");
			url =prop.getProperty("url");
		}
		catch(Exception e) {
			
			e.getStackTrace();
			
		}
		
	}

	@BeforeMethod
	public void init() {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
				
			}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test(priority=1)
	public void learnTestNG() throws InterruptedException {
		
		By USERNAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By LOGINBUTTON = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER = By.xpath("//h2[contains(text(),' Dashboard ')]");
		By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(),'Customers')]");
		By ADD_CUSTOMER_MENU_FIELD = By.xpath("//a[contains(text(),'Add Customer')]");
		By CONTACT_HEADER = By.xpath("//h2[contains(text(),' Contacts ')]");
		By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
		By COMPANY_FIELD = By.xpath("//select[@id='cid']");
		By EMAIL_FIELD =By.xpath("//input[@id='email']");
		By PHONE_FIELD =By.xpath("//input[@id='phone']");
		By ADDRESS_FIELD = By.xpath("//input[@id='address']");
		By CITY_FIELD = By.xpath("//input[@id='city']");
		By STATE_FIELD = By.xpath("//input[@id='state']");
		By ZIP_FIELD = By.xpath("//input[@id='zip']");
		By COUNTRY_FIELD = By.xpath("//select[@id='country']");
		By TAG_FIELD = By.xpath("//select[@id='tags']");
		By CURRENCY_FIELD = By.xpath("//select[@id='currency']");
		By GROUP_FIELD = By.xpath("//select[@id='group']");
		
		
		String USERNAME = "demo@techfios.com";
		String PASSWRD = "abc123";
		String FULLNAME = "abcdefg";
		String COMPANYVALUE = "Techfios";
		String EMAILVALUE = "abc@gmail.com";
		String PHONENUMBER = "4809763322";
		String ADDRESS = "10558 abc circle";
		String CITY = "Manassas";
		String STATE = "Virginia";
		String ZIPCODE = "20109";
		String COUNTRY = "Afghanistan";
		String TAGNAME = "My tags";
		String CURRENCY_VALUE = "USD";
		String GROUP_VALUE = "April2020";

		driver.findElement(USERNAME_FIELD).sendKeys(USERNAME);		
		driver.findElement(PASSWORD_FIELD).sendKeys(PASSWRD);		
		driver.findElement(LOGINBUTTON).click();
		
		Thread.sleep(3000);
		
		
		Assert.assertEquals("Dashboard", driver.findElement(DASHBOARD_HEADER).getText(), "wrong page!");
		
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		
		Assert.assertEquals("Contacts", driver.findElement(CONTACT_HEADER).getText(), "Wrong page!");
	
		driver.findElement(FULL_NAME_FIELD).sendKeys(FULLNAME);
		
		selectDropDown(driver.findElement(COMPANY_FIELD), COMPANYVALUE);
		
//		Select sel = new Select(driver.findElement(COMPANY_FIELD));
//		sel.selectByVisibleText(COMPANYVALUE);
		
		driver.findElement(EMAIL_FIELD).sendKeys(EMAILVALUE);
		driver.findElement(PHONE_FIELD).sendKeys(PHONENUMBER);
		driver.findElement(ADDRESS_FIELD).sendKeys(ADDRESS);
		driver.findElement(CITY_FIELD).sendKeys(CITY);
		driver.findElement(STATE_FIELD).sendKeys(STATE);
		driver.findElement(ZIP_FIELD).sendKeys(ZIPCODE);
		
		selectDropDown(driver.findElement(COUNTRY_FIELD), COUNTRY);
		
//		Select sel1 = new Select(driver.findElement(COUNTRY_FIELD));
//		sel1.selectByVisibleText(COUNTRY);
		
		driver.findElement(TAG_FIELD).sendKeys(TAGNAME);
		
		driver.findElement(CURRENCY_FIELD).sendKeys(CURRENCY_VALUE);
		
		selectDropDown(driver.findElement(GROUP_FIELD), GROUP_VALUE);
		
//		Select sel2 = new Select(driver.findElement(GROUP_FIELD));
//		sel2.selectByVisibleText(GROUP_VALUE);

		Thread.sleep(5000);
		
	}
	
// Creating custom Method for all drop down menu
	
		public void selectDropDown(WebElement dropdown, String VisibleText) {
			Select sel = new Select(dropdown);
			sel.selectByVisibleText(VisibleText);
			
		}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//		
//	}
	
}
