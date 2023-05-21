package o_selenium.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class O_SeleniumGroupingElements { // See Also: /SeleniumCourse/src/c_selenium/POM/Ex2PFPO/TasksPage.java !!  <-  More Examples !
// For reference, look also in other classes: J_SeleniumActionsExercise3 + G_SeleniumElementsToListOf + I_SeleniumSelectOptionElements !
/** How to work in Selenium with Lists of Elements?
		L1 = Menu (on left side)
		L2 = Items (center page)
		L3 = Sorting (Top Right)
	Performed scenarios' steps :
	----------------------------
		--  A
		00. Test must run on Chrome in full-size!
		01. Browse to "https://www.saucedemo.com"
		02. Do a Successful Login + validate ...inventory Page
		03. Click Menu icon to Open
		04. Click on 'ABOUT' <- clicking directly on a specifically found element 'ABOUT' within the opened Menu
		05. Clicking Browser 'back' button & going to previous URL = Return to inventory-page (note that Menu is already open)
		06. Click the 2ed option located in Menu list of elements (.bm-item-list > a) = 'ABOUT'  <----  L1  --|
		07. Browse back
		08. Click on the option located in Menu list of elements (.bm-item-list > a) that has Text = 'ABOUT' !!!
		09. Browse back
		10. Click to Close menu  -&-  Print "END of part A"...
		--  B
		11. Get All Items on inventory Page as a List of elements (.inventory_list .inventory_item)  <----  L2  --|
		12. Print for All Items in list only: Name & Price of each element (also, see example of how to Print All Data of All Items) ...
		13. Add an ARRAY to collect all prices for compare..., do the Assertion later on  -&-  Print "END of part B"...
		--  C
		14. Print Currently Active Selection Type (before change)
		15. Click Sort icon to Open Selection container
		16.	Print all sort options options <- the options located as list of elements (.product_sort_container > option)  <----  L3  --|
		17.	Compare Active selection to First Option  -&-  Print "END of part C"...
		--  D
		18. Change Sort to: 'Price (low to high)' - try all kind of: index, value text
		19. Validate Currently Active Selection Type is correlative to the change made 
		20. Validate sort was made ... that the items inventory order changed accordingly
		21. Re-Print Items list with both Name & Price (to see Sorting effect)  -&-  Print "END of part D"...
		22. TearDown the Test!
 	*/
	public static void main(String[] args) throws InterruptedException {
// 0.
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
// 1.
		driver.get("https://www.saucedemo.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000);
// 2.
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		String Expected = "https://www.saucedemo.com/inventory.html"; // (.toLowerCase() not needed for I use lower anyway)
		Assert.assertEquals(driver.getCurrentUrl(), Expected); // Logged in succeeded -> redirected inside App in-to inventory Page ....
		Thread.sleep(1000);
		
		// PART A - Working on MENU
// 3.
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click(); // opens the Menu List
		Thread.sleep(1000);
// 4.
		driver.findElement(By.cssSelector("#about_sidebar_link")).click(); // clicking directly on specifically found element
		Thread.sleep(1000);
// 5.
		driver.navigate().back();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), Expected); // validate we're back in inventory Page (note the Menu is already open).
// 6.
		// Gather all menu-list-selections under one element (there are several under same locator, so you must use a list)
		List<WebElement> menuList = driver.findElements(By.cssSelector(".bm-item-list > a"));
		// using the # location of Element within above List (which star with 0) -> So, 1 is the 2ed element in Menu list = ABOUT !
		menuList.get(1).click();
		Thread.sleep(1000);
// 7.
		driver.navigate().back();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), Expected);
// 8.
		// using the List declared above for looping over all elements, to find the needed one!
		for (WebElement el : menuList) { 
			if (el.getText().equalsIgnoreCase("ABOUT")) { // looking for that with Text = ABOUT
				System.out.println("step 8 -> found: " + el.getText()); // Redundant Print TBD!
				el.click(); // Clicking on that element...
				break; // don't forget to break the loop after click (otherwise, you'll get 'StaleElementReferenceException') !!!
			}
		}
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");  // validate we are in the New Page URL
// 09.
		driver.navigate().back();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), Expected);
// 10.
		driver.findElement(By.cssSelector("#react-burger-cross-btn")).click(); // closes the Menu List
		System.out.println("END of part A");
		Thread.sleep(1000);
//-------------------------

		// PART B - Working on INVENTORY
// 11.
		// Get All Items on inventory Page as a List of WebElement having a subset of elements within them (at lower level)...
		List<WebElement> inventoryList = driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
// 12.
		// Using 'for' loop (instead of 'for-each') -> I will go over list of elements & for every one, I will get Relevant Sub Data !!!
		// Print for All Items list only: Name & Price -> Needing to find the sub-elements of a specific WebElement & get their Data !!!
		System.out.println("Inventory List Items - Orig State, Before Sort:");
		for (int i = 0; i < inventoryList.size(); i++) {
			// System.out.println(inventoryList.get(i).getText()); // Print All Data of All Inventory List Items
			String elName = inventoryList.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
			String elPrice = inventoryList.get(i).findElement(By.cssSelector(".inventory_item_price")).getText();
			System.out.println("el-Name: " + elName + ", el-Price: " + elPrice); // price format = '$29.99'
		}
		/* Example also of using 'For Each'...
		System.out.println("Inventory List Items - Orig State, Before Sort - ONLY Name & Price:");
		for (WebElement el : inventoryList) {
			String elName = el.findElement(By.cssSelector(".inventory_item_name")).getText();
			String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText();
			System.out.println("el-Name: " + elName + ", el-Price: " + elPrice);
			} */
// 13.	
		// For Assertion, add a List to hold all number values of prices --> will be derived from the ITEMs inventoryList as following :
		List<Double> byPriceNumber = new ArrayList<>(); // New List (of orig state, before sort)
		// Traverse the Orig inventoryList WebElements list (traverse meaning: go over all parts), and extract price number to above ^ !
		for (WebElement el : inventoryList) {
			String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText(); // price is a sub-element of an ITEM !!!
			// System.out.println("el-Price: " + elPrice); // Print String as is: $15.99
	        String onlyPrice = elPrice.replace("$", ""); // replace & REMOVE the $ sign from string, to keep only text of number chars !
	        Double priceNmber = Double.parseDouble(onlyPrice); // PARSE & convert the String (textual-chars) to Double (number) type ...
	        // System.out.println(priceNmber); // ->  output = 15.99
			byPriceNumber.add(priceNmber); // add each found price to the List of byPriceNumber to be sorted for Asserting
		}
		// Sorting the NEW List in Ascending \ Descending order (& Printing after Sort) -and- Asserting proper order
		Collections.sort(byPriceNumber); // Ascending (low to high) --> NOW this List is of orig state before sort, but locally sorted !
		// Collections.sort(byPriceNumber, Collections.reverseOrder()); // Descending (high to low)
		for (Double price : byPriceNumber) { // Traverse the byPrice elements
			System.out.println("price only (before sort, but array sorted): " + price); // Redundant !
		}
		System.out.println("END of part B");
		Thread.sleep(1000);
//-------------------------

		// PART C - Working on SORTING
// 14.	
		// Print Currently Active Sort -> Active don't have same locator as Options - should be located separately & -used dynamically !
		WebElement SortActiveOption = driver.findElement(By.cssSelector(".active_option")); // currently active select = unique locator!
		String activeSortOption = SortActiveOption.getText(); // currently active (soon as given vale, it becomes obsolete upon change)!
		System.out.println("Active Sorting is: " + activeSortOption); // better use as seen bellow (on next step) ...
// 15.	
		// Click Sort icon to Open Selection container
		driver.findElement(By.cssSelector(".select_container")).click();
// 16.	
		//Print all sort options options <- the options located as tags under select element (.product_sort_container)
		/** Perform these steps to operate a drop-down selection menu build like:
			<select id="id" name="nm" class="cl">
				<option value=A"> A </option>
				<option value=B"> B </option>
			</select>
		WebElement el = driver.findElement(By.cssSelector("#id")); // or any other kind locator
		Select selectX = new Select(el); // instead of element you could have enter the locator
		-	selectX.selectByIndex(1);  -->  will select the 2ed possibility (starting with 0) !
		-	also: selectX.selectByValue("A");  |  selectX.selectByVisibleText("A");
		de-selecting is possible in multi-selection
		-	selectX.deselectByVisibleText(" A ")  |  selectX.deselectAll()
		more-selection-possibilities (and there are more)...
		-	selectX.getOptions() [returns element not text]
 		-	also: selectX.getFirstSelectedOption()  |  selectX.getAllSelectedOptions()
	*/
		// to work on Options we need to have the Element + Select Object initialized
		WebElement sortOptions = driver.findElement(By.cssSelector(".product_sort_container")); // Options selection have other locator!
		Select selectSortOptions = new Select(sortOptions); // the Object manages the operations possibilities on: options selections !!
		// work on options
		System.out.println("\n-- Print of all SORTING Options :    \n - " + 
				selectSortOptions.getOptions().get(0).getText() + "\n - " + 
				selectSortOptions.getOptions().get(1).getText() + "\n - " + 
				selectSortOptions.getOptions().get(2).getText() + "\n - " + 
				selectSortOptions.getOptions().get(3).getText());
// 17.	
		// Validation Current Active Selection Equals to the First Option -> Select Object works only on 'select' HTML tag with options!
		String sortFirstOption = selectSortOptions.getFirstSelectedOption().getText(); // capability of Select Object
		System.out.println("First Sort Option is: " + sortFirstOption);
		// make Assertion for comparison with active set above ^...
		Assert.assertEquals(activeSortOption.toLowerCase(), sortFirstOption.toLowerCase());
		System.out.println("Passed Assertion for comparison with Active");
		
	    /** ANOTHER Way to work is by converting one type of list to another:
	    	-----------------------------------------------------------------
		// List to hold the value we will return to the caller.
	    List<String> currentOptions = new ArrayList<>();
		// Find the 'Selection Drop Down' on the page.
	    WebElement selectDD = driver.findElement(By.cssSelector(".product_sort_container"));
	    // Pull out the options as web elements
	    List<WebElement> options = selectDD.findElements(By.tagName("option"));
	    // Traverse the web elements to extract the text. Text gets added to the 'currentOptions' List
	    for (WebElement option : options) {
	        currentOptions.add(option.getText());
	    }
		// Loop over List of options & Print the Option text (from String List - instead of from Element List)
	    for (String text : currentOptions) {
			System.out.println(text);
		}
	    */
		System.out.println("END of part C");
		Thread.sleep(1000);
//-------------------------

		// PART D - Working on SORT Assertion
// 18.	
		// Change Sort to: 'Price (low to high)' <- the options located as list of elements (.product_sort_container > option) - USEING:
		// selectSortOptions.selectByIndex(2); // Index: 2 (3ed one)
		// selectSortOptions.selectByValue("lohi"); // Value: "lohi"
		selectSortOptions.selectByVisibleText("Price (low to high)"); // Text: "Price (low to high)"
		Thread.sleep(1000);
// 19. 
		// Validate Currently Active Selection Type is correlative to the change made		
		System.out.println("NEW Active Sort: " + driver.findElement(By.cssSelector(".active_option")).getText()); // currently active !!
		// Note: System.out.println("Active Sorting is: " + activeSortOption); will show the text already given to it earlier in flow !!
		String newActiveSort = driver.findElement(By.cssSelector(".active_option")).getText();
		String expectedActive = "PRICE (LOW TO HIGH)";
		Assert.assertEquals(newActiveSort.toLowerCase(), expectedActive.toLowerCase());
		System.out.println("Passed Assertion for second comparison with NEW Active");
		Thread.sleep(1000);
// 20.	
		// Add ARRAY to collect all prices for compare -&- Validate the sort was made, and items inventory order changed accordingly ...
		inventoryList = driver.findElements(By.cssSelector(".inventory_list .inventory_item")); // to set list again (and not use prev)!
		// NOTE: the above list was already declared above and was initialized with value before sorting so we need to do it once again!
		// For Assert, add another List to hold all number values of prices (will be derived from the ITEMs inventoryList as following):
		List<Double> byPriceNumberAfterSort = new ArrayList<>(); // New List
		// Traverse the Orig inventoryList WebElements list (traverse meaning: go over all parts), and extract price number to above ^ !
		for (WebElement el : inventoryList) {
			String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText(); // price is a sub-element of an ITEM !!!
			// System.out.println("el-Price: " + elPrice); // Print String as is: $15.99
	        String onlyPrice = elPrice.replace("$", ""); // replace & REMOVE the $ sign from string, to keep only text of number chars !
	        Double priceNmber = Double.parseDouble(onlyPrice); // PARSE & convert the String (textual-chars) to Double (number) type ...
	        // System.out.println(priceNmber); // ->  output = 15.99
	        byPriceNumberAfterSort.add(priceNmber); // add each found price to List of byPriceNumberAfterSort, to be sorted for Assert !
		}
		// PRINT the NEW List
		for (Double price : byPriceNumberAfterSort) { // Traverse the byPrice elements
			System.out.println("price only After Sorting: " + price); // Redundant !
		}
		// Assert Sort - validate 2 Lists
		Assert.assertEquals(byPriceNumberAfterSort, byPriceNumber); // Check If Lists Equal (after sort = before sort, but sorted #13)!

		boolean ascendingOrder = true; // given proper ascending order
		for (int i = 1; i < byPriceNumberAfterSort.size(); i++) { // starting with 2ed limb & check till last one in list
			if (byPriceNumberAfterSort.get(i-1) > byPriceNumberAfterSort.get(i)) { // check if its smaller then prev limb
				ascendingOrder = false; // if one meats condition then list is not in ascending order --> change to false
			}
		}
		Assert.assertTrue(ascendingOrder, "proper ascending order");
		System.out.println("- Price -> After Sorting Price Ascending - Order  as expected -> " + ascendingOrder); // Redundant !
		Thread.sleep(1000);
// 21.   
		// Re-Print Items list with both Name & Price (to see Sorting effect)
		System.out.println("Inventory List Items - After Sort:");
		for (int i = 0; i < inventoryList.size(); i++) {
			String elName = inventoryList.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
			String elPrice = inventoryList.get(i).findElement(By.cssSelector(".inventory_item_price")).getText();
			System.out.println("el-Name: " + elName + ", el-Price: " + elPrice);
		}
		//
		System.out.println("END of part D");
// 22. 
		// TearDown the Test
		Thread.sleep(1000);
		driver.quit();
		System.out.println("-- end --");
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
/**
 */
