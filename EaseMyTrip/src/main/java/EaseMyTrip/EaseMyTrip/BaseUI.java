package EaseMyTrip.EaseMyTrip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseUI {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String browser_choice;
	
	
	public BaseUI() throws IOException {
		prop=FileIO.initProperties();
	}
	


	/***********To choose the Browser************/
	public static WebDriver invokeBrowser() {
		
		browser_choice = prop.getProperty("browserName");
		
	     if(browser_choice.equalsIgnoreCase("chrome")) {
	    	driver = DriverSetup.getChromeDriver();
	     }
	     else if(browser_choice.equalsIgnoreCase("firefox")) {
	    	 driver = DriverSetup.getFireFoxeDriver();
	     }    
	     else {
	    	 System.out.println("Enter a valid broswer name");
	     }
		
	     return driver;
	}
	
	/***********To Open the Url************/
	public static void openUrl(String websiteUrlKey) {
			driver.get(prop.getProperty(websiteUrlKey));
	}
	
	
	/***********To Perform Click Actions************/
	public static void clickOn(By locator) {
		driver.findElement(locator).click();

	}
	
	
	
	/***********To Send Keys to the Browser************/
	
	public static void sendKeys(String text,By locator) {
		
		driver.findElement(locator).sendKeys(text);
		
	}
	
	

	/***********To Find the "BY" value************/
	public static By getLocatorKey(String LocatorPropName) {
		System.out.println("prop name " +LocatorPropName);
		if (LocatorPropName.endsWith("_id")) {
			return By.id(prop.getProperty(LocatorPropName));
		}
		if (LocatorPropName.endsWith("_name")) {
			return (By.name(prop.getProperty(LocatorPropName)));
		}
		if (LocatorPropName.endsWith("_className")) {
			return (By.className(prop.getProperty(LocatorPropName)));
		}
		if (LocatorPropName.endsWith("_xpath")) {
			return (By.xpath(prop.getProperty(LocatorPropName)));
		}
		if (LocatorPropName.endsWith("_css")) {
			return (By.cssSelector(prop.getProperty(LocatorPropName)));
		}
		if (LocatorPropName.endsWith("_linkText")) {
			return (By.linkText(prop.getProperty(LocatorPropName)));
		}
		if (LocatorPropName.endsWith("_partialLinkText")) {
			return (By.partialLinkText(prop.getProperty(LocatorPropName)));
		}
		if (LocatorPropName.endsWith("_tagName")) {
			return (By.tagName(prop.getProperty(LocatorPropName)));
		}

		return null;
	}
	

}
