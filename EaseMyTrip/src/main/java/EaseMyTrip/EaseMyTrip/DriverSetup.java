package EaseMyTrip.EaseMyTrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {
	
	private static WebDriver driver;
	
	/********* Invoke Chrome Driver **********/
	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", BaseUI.prop.getProperty("chromeDriver"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	/********* Invoke FireFox Driver **********/
	public static WebDriver getFireFoxeDriver() {
		System.setProperty("webdriver.gecko.driver", BaseUI.prop.getProperty("firefoxDriver"));
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	

}
