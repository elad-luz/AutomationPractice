package saucedemo.resources; // And makes Use of package: /SeleniumProject/src/saucedemo/utilities.
/** to use an external file for dynamic value setting of code variables, there are several options:
	you can use a configuration.properties -or- an excel file (each requires a Util to fetch data).
===================================================================================================

1.	using a 'configuration.properties':
	add under separated "data" package your 'configuration.properties' file
	the file must end with type '.properties' and contain key= value pares:
	# comments
	key= value

	NOTE:
	to read from file to code, you need a util added in a separated package
	the utility is another java class that looks like:
	--------------------------------------------------
	
add under separated "data" package your 'configuration.properties' file
the file must end with type '.properties' and contain key= value pares:
# comments
key= value

The implementation of this type of read from conf is seen in both:
- BaseTest -> driver.get(Utils.readProperty("url"));
- T01_LoginFailures_TestNGDDT (LoginFailedUsingConfProperties)

NOTE:
to read from file to code, you need a util added in a separated package
the utility is another java class that looks like:
--------------------------------------------------

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfPropertiesUtil { // can be used (as BasePage) in many Projects !

	// 	the following method is a tool to read a property value (from the config.prop file)...
	// 	the 'static' states you don't need to create an object - can actually use it directly:
	// 	example of usage from anywhere in the src -->  Utils.readProperty("url");  -->  or as:
	// 	used in BaseTest -->  driver.get(Utils.readProperty("url"));  <-----------------------

	public static String readProperty(String key) { // method get String called key = property
		// we want to read the .properties file & get the value, correlative to that key given
		String value=""; // declare & init a String variable for getting the given key's value

		// path defines where the file resides: in this case, a relative path under my project
		// NOTE: 'InputStream' works with a File -> so it needs to be wrapped with Try/Catch !
		try (InputStream input = new FileInputStream("./src/saucedemo/resources/configuration.properties")) {
			// declare & initialize a Properties object (to host the properties file in memory)
			Properties prop = new Properties();

			// load the properties file to memory (into above created ^ prop object)
			prop.load(input);

			// reading the properties from file (get value of a key):
			// get the property value (also print out) of given key - and, set it to variable!
			value = prop.getProperty(key);
			// System.out.println(prop.getProperty(key));

		} catch (Exception e) {
		}
		return value; // method returns the value of the key from related .properties file ...
	}
}	
--> EXAMPLES can be found under https://mkyong.com/java/java-properties-file-examples/
	you can also add a method that write the property value...
	
===================================================================================================

2.	using an 'EXCEL' file [you need to prepare the excel-file, and give a name of test to each tab:
	save in separated "data" package, 'testName.xlsx' file (edited from excel -> first row = Title)
	the file must able to be opened in excel and contain columns with data (not first row -> Title)
	NOTE:
	to read from this file by code into memory, you need a util added in a separated package Utils!
	following method is a 'tool' to read a property value from a given excel file - to work with it
	you NEED importing some jars to your project (poi is a lib that helps use all Microsoft tools):
	download from -> https://poi.apache.org/download.html -> Binaries.zip of latest stable release!
	extract the relevant under -> C:\automation\libs --> under main folder ...libs\poi-bin-5.x.x ->
	needed jars, also in nested folders -> ALL should be imported to project! rightClick Project ->
	Properties > Java Build Path > Classpath > Add External Jars (from dirs+ select+ Open) > Apply!
	Now you could import relevant classes to your class, to be able to use them in relevant methods
	the utility is another java class...
	------------------------------------
	To use this Data, we replicate the known method & just change it a bit to fit our excel:

	@DataProvider
	public Object[][] getDataFromExcel(){
		String excelPath = System.getProperty("user.dir") + "/src/saucedemo/resources/inputTestData.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "loginTest");
		return table;
	}
	
	
//	TOOL FROM GAL:
	==============
	package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	// Read the Excel data and convert to a Matrix
	// @param - file path, sheet name
	public static Object[][] getTableArray(String filePath, String sheetName){
		Object[][]tabArray = null;

		try{
			FileInputStream ExcelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

			int ci=1,cj=0;
			int totalRows = ExcelWSheet.getPhysicalNumberOfRows();
			int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
			tabArray = new Object[totalRows-1][totalCols];
			for (int i=0; ci<totalRows;ci++){
				int j=0;
				for (cj=0; cj<totalCols; cj++){
					Object data = getCellData(ci, cj);
					tabArray[i][j] = data;
					j++;
				}
				i++;
			}
		} catch (FileNotFoundException ex){
			System.out.println("Exception! Excel file could not be found!");
		} catch (IOException ex){
			System.out.println("Exception! IO error occured while trying to load excel file!");
		} catch (Exception e) {
			System.out.println("Exception! Error occured while trying to load excel file!");
		}
		return tabArray;
	}

	
	// Read the test data from the Excel cell
	// @param - Row number and Column number:
	private static Object getCellData(int RowNum, int ColNum) throws Exception {
		try {
			String CellData = "";
			double numericCellData;
			long intCellData;
			double doubleCellData;
			Boolean booleanCellData= false;

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if (Cell.getCellTypeEnum() == CellType.STRING)
				CellData = Cell.getStringCellValue();
			else if (Cell.getCellTypeEnum() == CellType.NUMERIC){
				numericCellData = Cell.getNumericCellValue();
				intCellData = (long)numericCellData;
				doubleCellData = (double)numericCellData;
				if (doubleCellData % 1 == 0)
					CellData = String.valueOf(intCellData);
				else
					CellData = String.valueOf(doubleCellData);
			}
			else if (Cell.getCellTypeEnum() == CellType.BOOLEAN){
				booleanCellData = Cell.getBooleanCellValue();
				CellData = String.valueOf(booleanCellData);
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
}
	
	
*/
