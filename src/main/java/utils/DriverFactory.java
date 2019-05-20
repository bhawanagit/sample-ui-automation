package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SearchByImage_Page;
import pageObjects.SearchByUrl_Page;

public class DriverFactory {
	public static WebDriver driver;
	public static SearchByImage_Page SearchByImagePage;
	public static SearchByUrl_Page SearchByUrlPage;

	public WebDriver getDriver() {
		try {
			// Read Config
			Properties p = new Properties();
			System.out.println("I am here");
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//properties//config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");
			System.out.println(browserName);
			String env = p.getProperty("environment");
			System.out.println(env);
			if(env.equals("Grid")) {
				ConfigureRemoteDriver(browserName,env);
			}
			else
			{
				ConfigureLocalDriver(browserName,env);
			}



		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			SearchByImagePage = PageFactory.initElements(driver,SearchByImage_Page.class);
			SearchByUrlPage = PageFactory.initElements(driver,SearchByUrl_Page.class);
		}
		return driver;
	}
	private void ConfigureLocalDriver(String browserName, String env)
	{
		System.out.println("I am not here");
		ChromeOptions options =new ChromeOptions();
		if(env.equals("Headless")) {
			options.addArguments("headless");
		}
		switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
		}
	}
	private void ConfigureRemoteDriver(String browserName, String env)
	{
		ChromeOptions options =new ChromeOptions();
		if(env.equals("Headless")) {
			options.addArguments("headless");
		}
		switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new RemoteWebDriver(capabilities);
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					driver = new RemoteWebDriver(DesiredCapabilities.chrome());
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new RemoteWebDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
		}
	}
}
