package EaseMyTrip.EaseMyTrip;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EaseMyTripTest extends BaseUI{
	


	public EaseMyTripTest() throws IOException {
		super();
		
	}

	private WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		driver = invokeBrowser();
		openUrl("WebsiteUrl");
	}
	
	@Test
	public void verifyPageTitle() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title,prop.getProperty("pageTitle"));
	}
	
	@Test
	public void fromTextBox() throws InterruptedException, IOException {
		HomePage homePage = new HomePage();
		String text= homePage.getFromDetails();
		Thread.sleep(1000);
		Assert.assertEquals(text,"Chennai");
	}
	
	
	@Test
	public void toTextBox() throws InterruptedException, IOException {
		HomePage homePage = new HomePage();
		String text= homePage.getToDetails();
		Thread.sleep(1000);
		Assert.assertEquals(text,"Mumbai");
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
	
}
