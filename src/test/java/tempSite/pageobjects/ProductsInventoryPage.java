package tempSite.pageobjects; // Inventory (list) page

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsInventoryPage extends Common { // 'Common' (acts as middle-tier in Hierarchy), replaced 'BasePage' as page super !!
// because its chained to BasePage (because its super Common extends BasePage) - you can directly reach Common & Base methods from here!
// note we use common for 'Cart' component (just because we make use of the 'itemsNumber', to get feedback on adding a product to cart !
// also - bare in mind, that this page (also onwards) is relevant only after successful login !!

/** ~~~~~~~~~~~~
	PageFactory:
	============
	*/
	@FindBy(css=".title")
	private WebElement pgTitle;
	
	/**	Inventory section:
	   ~~~~~~~~~~~~~~~~~~*/
	/* Below: work on Inventory as List of objects to choose from (its an example, used in-case each Link can't be uniquely identified)!
	   Working with Lists of located WebElrments:  -->  Example of how to use this is shown in ./src/saucedemo/pageobjects/Common.java !
	   below is the added WebElements located (see the impact of usage in tTesting methods below) --> note: the first we find is a LIST:
	   @FindBy(css=".inventory_item_name") // locator should be the 'Parent' object containing all 'Child' objects included in the List!
	   private List<WebElement> pList; // this will define the list of products on screen, one or several found, using the same locator!
	   NOTE (according to Gal, I'm not sure a 100%): when using elements' LIST (using loops etc.) it's better to use it within the code!
	   So he say it is better not to locate the list this way (don't use PageFactory for lists), but with-in the code itself (see below)
	   --------------------------------------------------------------------------------------------------------------------------------|
	   Any way, I will add it as example and see for my-self if its OK or not to use this FindBy + List or is it better to use in code !
	   Get All Items on inventory Page as a List of WebElement having a subset of elements within them (at lower level)...
	   As doing:  List<WebElement> inventoryList = driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
	*/
	@FindBy(css = ".inventory_list") // Object containing (wrapping) All Inventory Items (not the items themselves, not any items' data)
	private WebElement inventory; // This Inventory is the Wrapper of All Items (see their list below)...
	@FindBy(css = ".inventory_list .inventory_item") // Parent object containing all Inventory Items (6 items, each have same structure)
	private List<WebElement> inventoryList; // Locate Inventory as a whole -> each Item function (e.g. GetText, Add) I would do in code!
	
	/**	Sorting section:
	   ~~~~~~~~~~~~~~~~*/
	@FindBy(css=".select_container") // the upper most of all Sort Objects (wrapping all Sort objects)
	private WebElement sortOptionsIcon; // Open Sort 'Selection-Options' dropdown
	@FindBy(css=".active_option")
	private WebElement activeSortOption; // Active Sort-Option (shown as the one selected)
	@FindBy(css=".product_sort_container") // Parent container 'SELECT' object, to all options' tags = the selections of Sorting types...
	private WebElement objectSelect; // the 'select' object with all 'options' underneath it... to be used directly (not as List, below)!
	@FindBy(css = ".product_sort_container option") // finds all options' tags selections & will be dealt as a LIST of elements ? MAYBE ?
	private List<WebElement> sortOptionsList; // Locate Sort as a whole -> each option  clicked (e.g. click & select) I would do in code!
	// TODO - decide on SELECT as List if needed !!!
	
/** ~~~~~~~~~~~~
	constructor:
	============
	*/
	// constructor - initialize the properties using super (of BasePage = parent)
	public ProductsInventoryPage(WebDriver driver) {
		super(driver);
	}

/**	------------------------------------------------------------------------------------------------------------------------------------
	|--->    methods wrapping the basic UI functionalities - to be used in TestCases, needing those operational-scripting steps    <---|
 	====================================================================================================================================
 	*/
	/**	Inventory section:
		~~~~~~~~~~~~~~~~~*/
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ TODO - Delete this comment! ////////////////////////////////////////////////////////////
	   This part was moved to the Common class!
	// implement open cart (to see items added)
	public void openCart() {
		// driver.findElement(By.cssSelector(".shopping_cart_link")).click(); // clicking [before BasePage]
		// click(driver.findElement(By.cssSelector(".shopping_cart_link"))); // same as above [before PageFactory]
		click(cartBtn); // click to open cart - this is the way to use it [after adding the element to PageFactory ^ see above]
		// but using the wrapped method from BasePage -> This action will take me to YourCartPage
	} // NOTE, this method is not being implemented in this class, but it could be reached to, from here (because this extends Common) !
	*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// implement find & click on a Product from Inventory list - below showing usage of List directly in code without using PageFactory!
	public void clickProductItemFromInventory(String name) {  // choose & click one item from list (needing an input = name of product)!
		List<WebElement> pList = driver.findElements(By.cssSelector(".inventory_item_name")); // list of products before PageFactory !!!
		/* 	List<WebElement> pList = driver.findElements(By.cssSelector(".inventory_item_name")); // list of products before PageFactory
			after add in PageFactory: 'private List<WebElement> pList;' - we can remove the above ^ deceleration, to prevent duplication
			BUT some times, according to Gal, when working with elements LIST (and using loops on it) - it's better to use it in code */
		for (WebElement el : pList) { // going over each inventory-Product item-Name from within the list of 6 collected = shown on page
			// if (el.getText().equalsIgnoreCase(name)) { // pin the desired product -> later, getText could also be wrapped in BasePage
			if (getText(el).equalsIgnoreCase(name)) { // pining the desired product -> after getText already added (wrapped) in BasePage
				// el.click(); // clicking -> will take me to SelectedProductPage [this way was relevant before even adding BasePage...]
				click(el); // same as above click ^  but using the wrapped method from BasePage !!!
				break; // to end, because after click the list will no longer be visible
			}
		}
	} // for implementation using PageFactory, see 'common' class --> TODO - Delete all comments above & below!
	
	/** working with list (advanced level) -> selecting an element, by its sub-region, within a list of regions, from-within a web-page.
	 	AS STATED above (in PageFactory) when using elements' LIST (using loops etc.) it is recommended to use it within the code, LIKE:
	 */
	// implement add to cart (from this ProductsPage, instead of from the SelectedProductPage) Note: there are 6 & you need one of them:
	public void addToCart(String name) {
		// the region in page for any product, with several sub-places
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item")); // will list all 6 inventory items -> products !
		// I have 6 products, so would have 6 elements regions, each with its own title needed to be found
		for (WebElement el : list) {
			// we look within the element for sub element title, to be spotted - note that, you're not using 'driver.', but rather 'el.'
			WebElement elTitle = el.findElement(By.cssSelector(".inventory_item_name")); // used el.= you're within related HTML region!
			// check to spot needed product (by title)
			if (getText(elTitle).equalsIgnoreCase(name)) {
				// defining 'Add' button WebElement (by locator), of that particular Product region (of HTML), we want to actually Add !
				WebElement addButton = el.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
				click(addButton);
				break; // to quit as soon as Add selection click is done...
			}
		}
		
	}
	// TODO - remove this Print =======================================================================================================|
	// implement print-data -> Fetch Inventory List Items Name & Price (to assist determine "Sort State" Before & After) + PRINT (-TBD-)
	public void printAllItemsNameAndPrice() { // making use of: inventoryList (from PageFactory)
		// Get All Items on inventory Page as a List of WebElements (having a subset of several elements within each (at lower level)...
		// List<WebElement> inventoryList = driver.findElements(By.cssSelector(".inventory_list .inventory_item")); // Pre- PageFactory!
		// Using 'for' loop (instead of 'for-each') -> I will go over list of elements & for every one, I will get Relevant Sub Data !!!
		// Get for All List Items, only: Name & Price  -> Needing to find the sub-elements of a specific WebElement & get their Data !!!
		// Use to see the Inventory List Items Orig State (Before any Sort) &  After Sorting done...
		for (int i = 0; i < inventoryList.size(); i++) {
			// System.out.println(inventoryList.get(i).getText()); // Print All The Data of All Inventory List Items
			String elName = inventoryList.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
			String elPrice = inventoryList.get(i).findElement(By.cssSelector(".inventory_item_price")).getText();
			System.out.println("el-Name: " + elName + ", el-Price: " + elPrice); // price format = '$29.99'
		}	/* Example same as above using 'For Each' syntax...:
			for (WebElement el : inventoryList) { // Traverse Orig inventoryList WebElements list (traverse meaning: go over all parts)!
				String elName = el.findElement(By.cssSelector(".inventory_item_name")).getText();
				String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText();
				System.out.println("el-Name: " + elName + ", el-Price: " + elPrice);
			}	*/
	} // END of PRINT !!! =============================================================================================================|
	
	/** Inventory - Items' Names:
		~~~~~~~~~~~~~~~~~~~~~~~~*/
	// implement method getting only the string names of all items as is without sorting (will be used later on for SORT assertions) ...	
	public List<String> getInventoryListNames() { // making use of: inventoryList (from PageFactory)
		// For Assertion, add a List to hold all number values of prices --> will be derived from the ITEMs inventoryList as following :
		List<String> inventoryListNames = new ArrayList<>(); // New List (of orig state, before sort)
		// extract items name-string from orig List -and- insert to the above ^ inventoryListNames
		for (WebElement el : inventoryList) { // Traverse the Orig inventoryList WebElements list (traverse meaning: go over all parts)!
			String elName = el.findElement(By.cssSelector(".inventory_item_name")).getText(); // name is a sub-element of any ITEM !!!
			// System.out.println("el-Name: " + elName);
			inventoryListNames.add(elName); // add each found name to the List of inventoryListNames (to be used later on)
		}
		return inventoryListNames;
	}
	// use the above List & sort ascending / descending - to compare with the 2 sort by price cases ascending & descending:
	public List<String> getSortedInventoryListNamesTrueAscFalseDece(boolean AD) { // AD stands for Ascending \ Descending !
		List<String> itemsSortedByNameAD = new ArrayList<>();
		itemsSortedByNameAD = getInventoryListNames();
		if (AD) { // AD = True (Asc)
			Collections.sort(itemsSortedByNameAD); // Sorting orig state List - in Ascending order (A to Z)
			return itemsSortedByNameAD;
		} else { // AD = False (Desc)
			Collections.sort(itemsSortedByNameAD, Collections.reverseOrder()); // Descending order (Z to A)
			return itemsSortedByNameAD;
		}
	}
	/** Inventory - Items' Prices:
		~~~~~~~~~~~~~~~~~~~~~~~~~*/
	// implement method getting the string prices of all items - and CONVERTING to Numbers (will be used later on for SORT assertions) !
	public List<Double> getInventoryListPrices() { // making use of: inventoryList (from PageFactory)
		// For Assertion, add a List to hold all number values of prices --> will be derived from the ITEMs inventoryList as following :
		List<Double> inventoryListPrices = new ArrayList<>(); // New List (of orig state, before sort)
		// extract items price string from orig List & convert to number and insert to above ^ inventoryListPrices
		for (WebElement el : inventoryList) { // Traverse the Orig inventoryList WebElements list (traverse meaning: go over all parts)!
			String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText(); // price is a sub-element of an ITEM !!!
			// System.out.println("el-Price: " + elPrice); // Print String as is: $15.99
			String onlyPrice = elPrice.replace("$", ""); // replace & REMOVE the $ sign from string, to keep only text of number chars !
			Double priceNmber = Double.parseDouble(onlyPrice); // PARSE & convert the String (textual-chars) to Double (number) type ...
			// System.out.println(priceNmber); // ->  output = 15.99
			inventoryListPrices.add(priceNmber); // add each found price to the List of byPriceNumber (to be used later on)
		}
		return inventoryListPrices;
	}
	// use the above List & sort ascending / descending - to compare with the 2 sort by price cases ascending & descending:
	public List<Double> getSortedInventoryListPricesTrueAscFalseDece(boolean AD) { // AD stands for Ascending \ Descending!
		List<Double> itemsSortedByPriceAD = new ArrayList<>();
		itemsSortedByPriceAD = getInventoryListPrices();
		if (AD) { // AD = True (Asc)
			Collections.sort(itemsSortedByPriceAD); // Sorting orig state List - in Ascending order (low to high)
			return itemsSortedByPriceAD;
		} else { // AD = False (Desc)
			Collections.sort(itemsSortedByPriceAD, Collections.reverseOrder()); // Descending order (high to low)
			return itemsSortedByPriceAD;
		}
	}	
/**	===============================================================
	Above method was actually combined from those 2 methods below !   TODO - Remove !!!
	---------------------------------------------------------------
	// implement 2 methods to compare the 'sorting by price' (for assertion) Ascending & Descending order:
	// use orig List & sort ascending - to compare with case: 'Price (low to high)'...
	public List<Double> inventoryListPricesAscending() { // making use of: getInventoryListPricesAsNumbers (above ^)
		List<Double> byPriceAscending = new ArrayList<>(); // New List (of orig state, before sort)
		byPriceAscending = getInventoryListPricesAsNumbers();
		Collections.sort(byPriceAscending); // Sorting List (of orig state) & keep it in Ascending order (low to high) !
		// for (Double price : byPriceAscending) { // Traverse the byPrice elements
		//		System.out.println("price only (ascending): " + price); }   // Redundant ! TODO - Remove !
		return byPriceAscending; // returning the sorted List (to print it or use in Assert)
	}
	// use orig List & sort descending - to compare with case: 'Price (high to low)'...
	public List<Double> inventoryListPricesDescending() { // making use of: getInventoryListPricesAsNumbers (above ^)
		List<Double> byPriceDescending = new ArrayList<>(); // New List (of orig state, before sort)
		byPriceDescending = getInventoryListPricesAsNumbers();
		Collections.sort(byPriceDescending, Collections.reverseOrder()); // Sorting List & keep it in Descending (high to low) !
		// for (Double price : byPriceDescending) { // Traverse the byPrice elements
		//		System.out.println("price only (descending): " + price); }   // Redundant ! TODO - Remove !
		return byPriceDescending; // returning the sorted List (to print it or use in Assert)
	} //-------------------------------------------------------------------------------------
*/
	/** Sorting section:
	~~~~~~~~~~~~~~~~~~~*/
	// implement open Sort DropDown container - lick on Sort icon (for sorting selection options)
	public void clickSortOptions() {
		click(sortOptionsIcon); // click the sort-button to open the various options (second click closes)
		// driver.findElement(By.cssSelector(".select_container")).click();
	}
	
	// implement get info function, and retrieve the 'Active Sort Option' (to assist verify & validating you see the proper Active-Sort)
	public String getActiveSortOption() { // to be used in assertEquals - compare: actual.toLowerCase() -&- expected.toLowerCase()
		if (isDisplayed(activeSortOption)) {
			// System.out.println("Active Sorting is: " + activeSortOption.getText());
			return activeSortOption.getText(); // currently active: any given is only relevant, till becomes obsolete - upon any change!
		}
		return "No Active Sort Option was Displayed!";
	}
/* TODO - REMOVE!!!
		//Print all sort options options <- the options located as tags under select element (.product_sort_container)
			Perform these steps to operate a drop-down selection menu build like:
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
	// TODO ----------------------------------------------------------------------------------------------------------------------------
	// implement get info function, and retrieve All Sort Options
	public String getSortOptions() {
		return "!";
	}
	// TODO ----------------------------------------------------------------------------------------------------------------------------
	// implement dynamic click function, to select the given one out of all the sorting-options (input from TestCase) - By VisibleText !
	public void selectSortOptionVisibleText(String sortBy) { // method use input to find relevant in list (could also be by Attribute) !
		for (WebElement el : sortOptionsList) { // go over all links list
			if (getText(el).toLowerCase().contains((sortBy).toLowerCase())) { // find the relevant, looking for the part of VisibleText!
				System.out.println("el Text & Value: " + getText(el) + " | " + el.getAttribute("value"));
				// moveTo(el); // mouse-over
				click(el); // click it...
			}
		}
	}	

	public Select getSelect() {
		return select(objectSelect);
	}
	
/*
// Change Sort to: 'Price (low to high)' <- the options located as list of elements (.product_sort_container > option) - USEING:
		// selectSortOptions.selectByIndex(2); // Index: 2 (3ed one)
		// selectSortOptions.selectByValue("lohi"); // Value: "lohi"
		selectSortOptions.selectByVisibleText("Price (low to high)"); // Text: "Price (low to high)"
		Thread.sleep(1000);

 * 
	public void selectSortOption(String sortBy) { // method uses input to find relevant Lnk in list
		for (WebElement el : sortOptionsList) { // go over all links list
			if (getText(el).toLowerCase().contains((sortBy).toLowerCase())) { // find the relevant one, looking for the part of text
			// if (el.getAttribute("value").contains("sortBy")) {
				sleep(500);
				click(el); // click it...
				break;
			}
			else {
				System.out.println("NOT Found !!! elTxt: " + getText(el) + " | " + el.getAttribute("value"));
				}
		}
	}	
*/
	
	
	
	
	
/**	------------------------------------------------------------------------------------------------------------------------------------
	|--->    methods for validations - retrieve various info, to use in TestCases, needing it for comparison to expected result    <---|
	====================================================================================================================================
	*/
	// implement boolean function, to validate the ProductsInventoryPage has all needed elements displayed properly (in a Default State)
	// note: I'm using IF with AND binary operator, so only if all operands are true, the result is true (otherwise the result is false)
	public boolean isProperProductsInventoryPageUI() {
		if (isLogoDisplayed() && // SwagLabs Logo - it is taken from common!
			isMenuOpenBtnDisplayed() && // Menu btn, also taken from common!
			isCartBtnDisplayed() && // Shopping cart (empty) -> from common!
			isProductsInventoryPageTitle() && // (see below method) Checks that this page Title has proper expected text ("PRODUCTS")...
			// isSortContainerDisplayed() // (add Sort container visible  -&-  the default selection is: "NAME (A to Z)")...
			// TODO -> Finish method... ================================================================================================
			isProperItemsListDisplayed() // (see method below) check the inventory items displayed properly
			) {
			return true;
		} else {
			return false;
		}
	}
	
	// --- TODO Add Sort Method ...
	
	// implement boolean function, to validate the ProductsInventoryPage has all needed elements displayed properly (in a Default State)
	// note: I'm using IF with OR binary operator, so if at least one operands is true, the result is true!  (otherwise result is false)
	//  I'm using OR because I'm checking that: NO Negative-Condition are to be found !!!
	public boolean isProperItemsListDisplayed() { // checks the inventory items exist with all sun elements
		if (isDisplayed(inventory)) { // checks the inventory wrapping-object of all items exist  (not the items objects themselves) !!! 
			for (WebElement el : inventoryList) { // name, text, price, Add btn (non was added, no Remove btn should be visible), pic...
				String elName = el.findElement(By.cssSelector(".inventory_item_name")).getText();
				String elDesc = el.findElement(By.cssSelector(".inventory_item_desc")).getText();
				String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText();
				String elAddRemoveBtn = el.findElement(By.cssSelector(".btn_inventory")).getText();
				String elImageSrc = el.findElement(By.cssSelector("img.inventory_item_img")).getAttribute("src");
				// System.out.println("el: \n"+ elName +"\n"+ elDesc +"\n"+ elPrice +"\n"+ elAddBtn +"\n"+ elImageSrc +"\n");
				// note I'm using IF with OR conditions -> so if one Negative-Condition found to be 'True', the if would return: false !
				if (	elName.isEmpty() ||
						elDesc.isEmpty() ||
						elPrice.isEmpty() ||
						elAddRemoveBtn.isEmpty() ||
						elAddRemoveBtn.equalsIgnoreCase("Remove") || // using "Add to cart", return: false, because it would be found !!
						elImageSrc.isEmpty()) {
					return false; // if its returned, isProperProductsInventoryPageUI method will also return false and Fail TestAssert!
				}
			}
			return true; // true is returned ONLY when no Negative-Condition was found -and- All Items exist with All sections per Each!
		}
		return false;
	}
	
	//  implement boolean function, to validate the Sort Component is displayed properly...
	public boolean isSortContainerDisplayed() {
		if (isDisplayed(sortOptionsIcon) &&
			getActiveSortOption().toLowerCase().contains("name (a to z)") // Name (A to Z)
			) {
			return true;
		} else {
			return false;
		}
	}

	// implement a function to validate Current Active Sort Option Selected (by text, not by actual sort)
	public void assertCurrentActiveSort(String expected) { // input needed = expected text
		assertElementText(activeSortOption, expected); // make use of the BasePage function 'assertElementText'
	} // USE in test like this: pp.assertCurrentActiveSort("Name (A to Z)")
	
	// implement a validation that by default, before any change made - the 'Active Sort Selected' is the First Option of List !
	public void assertDefaultSortIsFirstOption() { // NOTE: this method don't use Page Factory !!! <----------------------------
		// to work on Options we need to have the Element + Select Object initialized
		WebElement sortOptions = driver.findElement(By.cssSelector(".product_sort_container")); // Options selection have other locator!
		Select selectSortOptions = new Select(sortOptions); // the Object manages the operations possibilities on: options selections !!
		// System.out.println("First Sort Option is: " + selectSortOptions.getOptions().get(0).getText()); // first option = 0 !!
		String sortFirstOption = selectSortOptions.getFirstSelectedOption().getText(); // thats a capability of 'Select' Object...
		// System.out.println("First Sort Option is: " + sortFirstOption);
		// make Assertion for comparison with active set above ^...
		Assert.assertEquals(getActiveSortOption().toLowerCase(), sortFirstOption.toLowerCase()); // remove 2ed 2Low & you'll get failure
	}


	
	// implement a function to validate All Sort Option are as Expected
	public void assertProperSortOptions() { //
	ArrayList<String> listExpected = new ArrayList<>(Arrays.asList( "Name (A to Z)", 
																	"Name (Z to A)", 
																	"Price (low to high)", 
																	"Price (high to low)"));
	ArrayList<String> listActual = new ArrayList<>(Arrays.asList("c", "b", "a"));		
	Collections.sort(listExpected);
	Collections.sort(listActual);
	System.out.println(listExpected.equals(listActual)); // true -> after sorting both, they match !!!
	
	
///////////////////////////////////////////////////////////////////// sortOptionsList
//	ANOTHER Way to work is by converting one type of list to another:
//  List<WebElement> sortOptionsList (.product_sort_container)
//	-----------------------------------------------------------------
//		// List to hold the value we will return to the caller.
//	    List<String> currentOptions = new ArrayList<>();

	
//	    // Pull out the options as web elements
//	    List<WebElement> options = selectDD.findElements(By.tagName("option"));
//	    // Traverse the web elements to extract the text. Text gets added to the 'currentOptions' List
//	    for (WebElement option : options) {
//	        currentOptions.add(option.getText());
//	    }
//		// Loop over List of options & Print the Option text (from String List - instead of from Element List)
//	    for (String text : currentOptions) {
//			System.out.println(text);
//		}
		
	}



	
	
	
	
	
	
	
	
	
// ====================================================================================================================================|
// old --------------------------------------------------------------------------------------------------------------------------------|
	// implement get info function, to validate page is ProductsPage -> to verify that you got-to the proper expected Destination page !
	// this can validate a successful login -or- browsing back-to (from another page)...
	/* The below method uses input -BUT- the same could be done without input (see below)
	public boolean isProductsPage(String expectedTitle) { // needs users' input  (the test will input to this method the expected title)
		sleep(1000); // need to find better mechanism then sleep - to actually wait till loin is done !!!
		// String pageTitle = getText(driver.findElement(By.cssSelector(".title"))); // get a title for comparison  [before PageFactory]
		String pageTitle = getText(pgTitle); // get current headline title of the page (by class) for comparison use [after PageFactory]
		if (pageTitle.equalsIgnoreCase(expectedTitle)) { // result of this comparison will determine if Test-Assertion Passed of Failed!
			return true; // title = "PRODUCTS"
		} else {
			return false;
		}
	} */
	// validating the expected page by title compare to expected (can also be done on get URL see below):
	public boolean isProductsInventoryPageTitle() { // no need users' input (this method will have the expected & compare)
		if (isDisplayed(pgTitle) && getText(pgTitle).equalsIgnoreCase("PRODUCTS")) { // check element is displayed & match expected
			return true; // proper page !
		} else {
			return false;
		}
	}
	
	// validating (same as above) the expected page, BUT - by checking if get URL, contains expected string (must be relevant & unique):
	public boolean isProductsInventoryPageByURL() { // no need users' input (this method will have the expected & compare)
		if (getCurrentUrl().toLowerCase().contains("inventory.")) { // checks page URL
			return true; // proper page !
		} else {
			return false;
		}
	}
	/** NOTE: above way, directly use Assert upon need, for a specific page to compare to -> it is not dynamic & flexible as should:
	I have added a wrapping method in BasePage, that do something alike (validate Current URL as Expected) -> USE in Test like this: 
 	pp.assertCurrentUrl("expected"); // expected = full URL or any Partial sub-String of it, as input during method implementation !
 	// Could also be done as bellow:
	// implement a function to validate Current Page Url is as Expected -> The capability was Added in BasePage & use a general way!
	public void assertCurrentPageUrl() { // Checks Login page URL = as Expected!
		String Expected = "https://www.saucedemo.com"; // Logged in page
		Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), Expected.toLowerCase()); // Assert NOT using intermediate method !
	}
	*/
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   This part was moved to the Common class!
	// validate - get num of items in cart (note: this will not work for no items in cart) 
	public int getNumCartItems() {
		// String sNum = getText(driver.findElement(By.cssSelector(".shopping_cart_badge"))); // get elements' text [before PageFactory]
		String sNum = getText(itemsNumber); // same as above [after PageFactory] 
		int num=Integer.parseInt(sNum); // converts string to int
		return num;
	} */
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
	USE: from BasePage
    public void assertElementText (WebElement el, String expectedText) -> OR:
	// implement a function to validate...   TODO ...!
	public void assertDo() { // Checks... as Expected!
		Assert.assertEquals("Actual", "Expected");
	}
====================================
//	check UI elements Exists of Not:
	public boolean isProperUI() {
		if (isDisplayed(xxx) || //	OR	using IF with OR binary operator, so if at least ONE operands is true, the result is true!
							   //	Sometimes using OR because checking that: NO Negative-Condition are to be found !!!
			isDisplayed(yyy) && //	And	using IF with AND binary operator, so only if ALL operands are true, the result is true!!!
			isAbsent(zzz)) {   //	Absent opposed to Displayed !!!
			return true;
		} else {
			return false;
		}
	}
==============================================================================================
see for more references: /SeleniumCourse/src/a_selenium/basics/O_SeleniumGroupingElements.java
// PART B - Working on INVENTORY:
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
		// Example also of using 'For Each'...
//		System.out.println("Inventory List Items - Orig State, Before Sort - ONLY Name & Price:");
//		for (WebElement el : inventoryList) {
//			String elName = el.findElement(By.cssSelector(".inventory_item_name")).getText();
//			String elPrice = el.findElement(By.cssSelector(".inventory_item_price")).getText();
//			System.out.println("el-Name: " + elName + ", el-Price: " + elPrice);
//			}
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
//-----------------------------
// PART C - Working on SORTING:
// 14.	
->		// Print Currently Active Sort -> Active don't have same locator as Options - should be located separately & -used dynamically !
->		WebElement SortActiveOption = driver.findElement(By.cssSelector(".active_option")); // currently active select = unique locator!
		String activeSortOption = SortActiveOption.getText(); // currently active (soon as given vale, it becomes obsolete upon change)!
		System.out.println("Active Sorting is: " + activeSortOption); // better use as seen bellow (on next step) ...
// 15.	
->		// Click Sort icon to Open Selection container
->		driver.findElement(By.cssSelector(".select_container")).click();
// 16.	
//		//Print all sort options options <- the options located as tags under select element (.product_sort_container)
//			Perform these steps to operate a drop-down selection menu build like:
//			<select id="id" name="nm" class="cl">
//				<option value=A"> A </option>
//				<option value=B"> B </option>
//			</select>
//		WebElement el = driver.findElement(By.cssSelector("#id")); // or any other kind locator
//		Select selectX = new Select(el); // instead of element you could have enter the locator
//		-	selectX.selectByIndex(1);  -->  will select the 2ed possibility (starting with 0) !
//		-	also: selectX.selectByValue("A");  |  selectX.selectByVisibleText("A");
//		de-selecting is possible in multi-selection
//		-	selectX.deselectByVisibleText(" A ")  |  selectX.deselectAll()
//		more-selection-possibilities (and there are more)...
//		-	selectX.getOptions() [returns element not text]
// 		-	also: selectX.getFirstSelectedOption()  |  selectX.getAllSelectedOptions()

->		// to work on Options we need to have the Element + Select Object initialized
->		WebElement sortOptions = driver.findElement(By.cssSelector(".product_sort_container")); // Options selection have other locator!
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
		
	    //	ANOTHER Way to work is by converting one type of list to another:
//	    	-----------------------------------------------------------------
//		// List to hold the value we will return to the caller.
//	    List<String> currentOptions = new ArrayList<>();
//		// Find the 'Selection Drop Down' on the page.
//	    WebElement selectDD = driver.findElement(By.cssSelector(".product_sort_container"));
//	    // Pull out the options as web elements
//	    List<WebElement> options = selectDD.findElements(By.tagName("option"));
//	    // Traverse the web elements to extract the text. Text gets added to the 'currentOptions' List
//	    for (WebElement option : options) {
//	        currentOptions.add(option.getText());
//	    }
//		// Loop over List of options & Print the Option text (from String List - instead of from Element List)
//	    for (String text : currentOptions) {
//			System.out.println(text);
//		}

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
--------------------------------------------

==============
More examples:
--------------
	TasksPage tp = new TasksPage(driver);
	tp.addSimpleTask("elad task #1");
	// tp.addSimpleTask("elad task #2"); // if you want to add another
	/* if you want to use loop for several:
	for (int i = 0; i < 3; i++) {
		tp.addSimpleTask("elad task #"+i);
	} 

	public void chooseList(String name) {
		// click(driver.findElement(By.cssSelector("[title='"+ name +"']>span")));
		// or going over tabs to locate the proper one:
		List<WebElement> list = driver.findElements(By.cssSelector("li>a>span"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}
*/
