package EaseMyTrip.EaseMyTrip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileIO {
	
	private static Properties prop;
	private static FileInputStream read_file;
	private static XSSFWorkbook workbook;
	private static XSSFSheet worksheet;
	private static Row row;
	
	/************** Get properties file****************/
	public static Properties initProperties() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\macri\\eclipse-workspace\\EaseMyTrip\\src\\test\\resources\\objectRepository\\Configuration.properties");
		prop.load(file);
		return prop;
	}
	
	
	
	/************** Get Test Data from excel sheet based on Test Name ****************/
	public static HashMap<String, ArrayList<String>> readExcelData(String testName) throws IOException {
		
		//Creating hashmap to store data
		HashMap<String, ArrayList<String>> data = new HashMap<>();
		
		//Reading the excel sheet
		read_file = new FileInputStream(prop.getProperty("testData_path"));						
		workbook = new XSSFWorkbook(read_file);
		worksheet = workbook.getSheet(testName);
		
		// Iterating over all cells in the sheet
		Iterator<Row> rowIterator;
		ArrayList<String> rowData = new ArrayList<>();
		rowIterator = worksheet.iterator();
		int rowNum = 1;//"1": {..}
		if (rowIterator.hasNext())
			row = rowIterator.next();
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator(); 
			if (row.getCell(0) == null) {
				break;
			}
			
			//Writing cell data to hashmap based on cell data type
			rowData = new ArrayList<>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				CellType type = cell.getCellType();
				if(type.equals(CellType.STRING))
					rowData.add(cell.getStringCellValue());
				else if(type.equals(CellType.NUMERIC))
					rowData.add(""+(int)cell.getNumericCellValue());
			}
			data.put("" + (rowNum), rowData);
			rowNum++;
		}
		
		//Closing FileInputStream and XSSFWorkbook
		workbook.close();
		read_file.close();
		return data;
	}

}
