package baseClass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseClass {

	protected WebDriver driver;
	protected ConfigReader config;
	protected static String employeeId;
	protected Logger logger = LogManager.getLogger(this.getClass());

	
	public WebDriver getDriver() {
	    return driver;
	}
	
	
	@BeforeMethod
	public void setup() {
		config = new ConfigReader();

		initializeBrowser();

		launchApplication();
	}

	protected void initializeBrowser() {

		String browser = config.getBrowser();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Invalid Browser Name:" + browser);
		}
	}

	protected void launchApplication() {
		driver.manage().window().maximize();

		driver.get(config.getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
