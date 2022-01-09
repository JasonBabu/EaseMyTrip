package EaseMyTrip.EaseMyTrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseUI {
	
	
	public HomePage() throws IOException {
		super();
		
	}

	public static WebDriver driver;
	
	By from_Locator = getLocatorKey("from_id");
	By to_Locator = getLocatorKey("to_id");
	By from_date =  getLocatorKey("fromDate_id");
	By to_Date =  getLocatorKey("toDate_id");
	By no_Passangers ;  
	By class_Locator ;
	
	HashMap<String, ArrayList<String>> data = new HashMap<>();
	ArrayList<String> rowData = new ArrayList<String>();
	
	public String getFromDetails() throws IOException {
		String i="1";
		String text;
		
		clickOn(from_Locator);
		
		//Reading Data from Excel
	    data=FileIO.readExcelData("Sheet1");

	    rowData = data.get(i);
	    text = rowData.get(0);
	    sendKeys(text,from_Locator);
		
	    return text;
	}
	
	
	public String getToDetails() throws IOException {
		String i="1";
		String text;
		
		clickOn(to_Locator);
		
		//Reading Data from Excel
		
	    data=FileIO.readExcelData("Sheet1");

	    ArrayList<String> rowData= data.get(i);
	    text = rowData.get(1);
	    sendKeys(text,to_Locator);
		
	    return text;
	}
	
	
	
	

}
