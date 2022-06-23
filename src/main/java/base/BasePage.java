package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FacebookPage;
import utilities.LoggerHelper;

public class BasePage {

	public static WebDriver driver;
	public static ChromeOptions options; 
	public FacebookPage facebookpage;

	public static Properties prop;
	static FileInputStream IN;
	static PropertiesConfiguration config;
	protected static String fbConfigFilePath = ".//facebookConfig.properties";
	protected static String whConfigFilePath = ".//wallethubConfig.properties";
	protected static Logger logger = LoggerHelper.getLogger(BasePage.class);

	public static String readPropertiesFile(String filePath, String key) throws IOException {
		IN = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(IN);
		return prop.getProperty(key);
	}


	public static String generateRandomString(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
			= (int)(AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}

	public static void launchApp(String filePath) throws IOException {
		String browserType = readPropertiesFile(filePath, "browser");

		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", readPropertiesFile(filePath, "chromepath"));
		
		driver = new ChromeDriver(options);

		logger.info("browser type :" + browserType);
		logger.info("********** LOUNCHING BROWSER **********");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String navigateToURL(String filePath) throws IOException {
		logger.info("********** OPENING URL **********");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		driver.get(readPropertiesFile(filePath, "URL"));
		return driver.getTitle();
	}

	public static void click(WebDriver driver, WebElement element) {
		try {
			element.click();
		} catch (StaleElementReferenceException e) {
			element.click();
		}
	}

	public static boolean isDisplayed(WebDriver driver, WebElement element) {
		try {
			waitForElement(driver, element, 15 );
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void type(WebElement element, String text) {
		waitForElement(driver, element, 15 );
		element.clear();
		element.sendKeys(text);
	}

	public static void clickUsingJavaSCript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
