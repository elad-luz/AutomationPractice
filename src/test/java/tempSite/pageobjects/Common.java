package tempSite.pageobjects; // MENUE page-section, ...
// see for more references: /SeleniumCourse/src/a_selenium/basics/O_SeleniumGroupingElements.java

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common extends BasePage { // class extending BasePage, acts as a middle-tier in Hierarchy, for any other Page extending it! 
/**	we can add a divided Hierarchy, and implement another 'Common' abstract-layer, which extends BasePage & acts as super to PageClass !
	there can be some several Commons each for Certain-Common-Elements & Page should extend a Common only if fits (otherwise, BasePage)!
	so this class will wrap the basic common capabilities of Pages (like MENUE, generally in use in most), to be used by relevant Pages.
	only page-classes that have it should extend & inherit this -> NOTE: LoginPage don't have a menu so it will keep extending BasePage!
	note that if added any abstract method (without implementation), to be propagated down to child, then this must also be an abstract!
	this class is super-parent to relevant child pages & because it is abstract, it can't be created as a stand alone object by itself !
	as Rule of Thumb, I'll consider 'Common' to be relevant, only after a successful login to App, when the Crossover Components exists!
	*/
/** ~~~~~~~~~~~~
	PageFactory
	============
	*/
	// below is the added WebElements located (see the impact of usage in tTesting methods below):
	// ctrl+space in By() will show all options: xpath= \ id=  etc.  -->  Also, this needs: import
	// examples  -->  https://www.lambdatest.com/blog/locators-in-selenium-webdriver-with-examples
	
	/**	MENU Component:
	   ~~~~~~~~~~~~~~~*/
	@FindBy(css=".app_logo") // Upper Logo [note: its not the same locator as that of the Logo in LoginPage, prior to user logging-in]
	private WebElement appLogoSwagLabs;
	@FindBy(css="#react-burger-menu-btn")  // open menu
	private WebElement menuOpenBtn;
	@FindBy(css="#react-burger-cross-btn")  // close menu
	private WebElement menuCloseBtn;
	@FindBy(css = "#inventory_sidebar_link")  // menu to: All -> TODO: find why (linkText = "All Items") did not work !
	private WebElement menuAllLnk;
	@FindBy(css = "#about_sidebar_link")  // menu to: About
	private WebElement menuAboutLnk;
	@FindBy(css = "#logout_sidebar_link")  // menu to: Logout
	private WebElement menuLogoutLnk;
	@FindBy(css = "#reset_sidebar_link")  // menu to: Reset (clears cart from added items)
	private WebElement menuResetLnk;
	// below: working on Menu as a list of objects to choose from (its an example, used in-case each Link can't be uniquely identified)!
	@FindBy(css = ".bm-item-list > a") // Parent object containing all Menu Links buttons
	private List<WebElement> listOfMenuLnks; // Locate Menu as a whole -> each button clicked on (e.g menuAllBtn) would be done in code.
	
	/**	CART Icon Component: (only icon leading to page (not the cart-page itself). this icon is visible in many pages, so it is common!
	   ~~~~~~~~~~~~~~~~~~~~*/
	@FindBy(css="#shopping_cart_container")  // shopping cart
	private WebElement cartBtn;
	@FindBy(css=".shopping_cart_badge")  // cart number of items
	private WebElement itemsNumber;
	
/** ~~~~~~~~~~~~
	constructor:
	============
	*/
	// constructor - initialize the properties using super (of BasePage = parent) -> This is GENERAL for all pages (to all have driver)!
	public Common(WebDriver driver) { // constructor passing the driver it would get from Page classes (children) to BasePage using it !
		super(driver);
	}
	
/**	------------------------------------------------------------------------------------------------------------------------------------
	|--->    methods wrapping the basic UI functionalities - to be used in TestCases, needing those operational-scripting steps    <---|
 	====================================================================================================================================
 	*/
	/**	MENU Component:
	   ~~~~~~~~~~~~~~~*/
	// this is only a debugging method which checks the Element Display State on Page & print it... TODO - Delete it !!!
	public void printElDisplayState() {
		System.out.println("menuOpenBtn displayed: " + isDisplayed(menuOpenBtn) +  " | absent: " + isAbsent(menuOpenBtn));
		System.out.println("menuCloseBtn displayed: " + isDisplayed(menuCloseBtn) +  " | absent: " + isAbsent(menuCloseBtn));
		System.out.println("menuAllLnk displayed: " + isDisplayed(menuAllLnk) +  " | absent: " + isAbsent(menuAllLnk));
		System.out.println("menuAboutLnk displayed: " + isDisplayed(menuAboutLnk) +  " | absent: " + isAbsent(menuAboutLnk));
		System.out.println("menuLogoutLnk displayed: " + isDisplayed(menuLogoutLnk) +  " | absent: " + isAbsent(menuLogoutLnk));
		System.out.println("menuResetLnk displayed: " + isDisplayed(menuResetLnk) +  " | absent: " + isAbsent(menuResetLnk));
	}
	// implement open menu - top left (for its possibilities)
	public void openMenu() {
		click(menuOpenBtn); // click the Menu-button to open the Menu (note that the 'click' method, checks el availability beforehand!)
	}
	// implement close menu
	public void closeMenu() {
		click(menuCloseBtn); // click the X Menu-button to close Menu
	}
	// implement clicking on an a specific menu link, while using the Link-Element (found above)!	
	public void clickAboutMenuLnk() { // Menu must be in 'open' state, otherwise you'll get "el not exist" exception !
		
		click(menuAboutLnk); // click the Menu-button to open the Menu
	}
	
	// implement a dynamic click on any given menu link, Upon using Link-Text input from TestCase
	public void clickOnMenuLnk(String LnkTxt) { // method uses input to find relevant Lnk in list
		waitForElementVisibility(menuCloseBtn); // start looking for link, only after menu opens!
		for (WebElement el : listOfMenuLnks) { // go over all links list
			if (el.getText().toLowerCase().contains((LnkTxt).toLowerCase())) { // find the relevant one = looking for that text in link!
				click(el); // click it...
				break;
			}
			// else {System.out.println("Link NOT Found !!! elTxt: " + getText(el));} // TODO - Remove !
		}
	}
	/**	CART Component:
	   ~~~~~~~~~~~~~~~*/
	// implement open cart - top right (to see items added -> for number of items in cart, see below) [was moved here from ProductsPage]
	public void openCart() {
		// driver.findElement(By.cssSelector(".shopping_cart_link")).click(); // clicking [before BasePage]
		// click(driver.findElement(By.cssSelector(".shopping_cart_link"))); // same as above [before PageFactory]
		click(cartBtn); // click to open cart - this is the way to use it [after adding the element to PageFactory ^ see above]
		// but using the wrapped method from BasePage -> This action will take me to YourCartPage
	}
	
/**	------------------------------------------------------------------------------------------------------------------------------------
	|--->    methods for validations - retrieve various info, to use in TestCases, needing it for comparison to expected result    <---|
	====================================================================================================================================

	Add implementations & compare it to expected result (then use while performing assertion in TestCase itself)
	BUT note that, for implement a get info function, to validate a successful login, you must do it from Product Page, you arrived to !
	*/
	/**	LOGO Component:
	   ~~~~~~~~~~~~~~~*/
	//  implement boolean function, to validate the Logo Component is displayed properly...
	public boolean isLogoDisplayed() {
		if (isDisplayed(appLogoSwagLabs)) {
			return true;
		} else {
			return false;
		}
	}
	/**	MENU Component:
	   ~~~~~~~~~~~~~~~*/
	//  implement boolean function, to validate the Open-Menu Button is displayed properly... NOT Indicating Menu State is: Close!
	public boolean isMenuOpenBtnDisplayed() {
		if (isDisplayed(menuOpenBtn)) {
			return true;
		} else {
			return false;
		}
	}
	//  implement boolean function, to validate the Close-Menu Button is displayed properly... Indicates the Menu State is: Open!!
	public boolean isMenuCloseBtnDisplayed() {
		if (isDisplayed(menuCloseBtn)) {
			return true;
		} else {
			return false;
		}
	}
	// implement boolean function, to validate the Menu Component has all needed elements displayed properly (for State of: Closed Menu)
	// note: I'm using IF with AND binary operator, so only if all operands are true, the result is true (otherwise the result is false)
	public boolean isProperClosedMenuUI() {
		sleep(500); // implement a quick sleep before validation starts and let the menu elements time to be loaded...
		if (isMenuOpenBtnDisplayed() && // see above method checking that Open-Menu Button is displayed!
			// isDisplayed(menuOpenBtn) && // before added above implementation - TODO - Delete !!!
			isAbsent(menuCloseBtn) &&
			isAbsent(menuAllLnk) &&
			isAbsent(menuAboutLnk) &&
			isAbsent(menuLogoutLnk) &&
			isAbsent(menuResetLnk)) {
			return true;
		} else {
			return false;
		}
	}
	
	// implement boolean function, to validate the Menu Component has all needed elements displayed properly (for State of: Opened Menu)
	// note: I'm using IF with AND binary operator, so only if all operands are true, the result is true (otherwise the result is false)
	public boolean isProperOpenedMenuUI() { // Checking also proper Links Titles: "ALL ITEMS", "ABOUT", "LOGOUT" -&- "RESET APP STATE" !
		sleep(500); // implement a quick sleep before validation starts and let the menu elements time to be loaded...
		if (isMenuCloseBtnDisplayed() && // see above method checking that Close-Menu Button is displayed!
			// isDisplayed(menuCloseBtn) && // before added above implementation - TODO - Delete !!!
			// note that the 'Open' button is NOT Absent!  it's still there, but is covered by & below the menu, So I'm not checking it!
			isDisplayed(menuAllLnk) &&  getText(menuAllLnk).toLowerCase().contains("all items") &&
			isDisplayed(menuAboutLnk) &&  getText(menuAboutLnk).toLowerCase().contains("about") &&
			isDisplayed(menuLogoutLnk) &&  getText(menuLogoutLnk).toLowerCase().contains("logout") &&
			isDisplayed(menuResetLnk) &&  getText(menuResetLnk).toLowerCase().contains("reset app state")) {
			return true;
		} else {
			return false;
		}
	}
	/**	CART Component:
	   ~~~~~~~~~~~~~~~*/
	//  implement boolean function, to validate the Cart Button is displayed properly... Without Indication of Full or Empty !
	public boolean isCartBtnDisplayed() {
		if (isDisplayed(cartBtn)) {
			return true;
		} else {
			return false;
		}
	}
	// implement boolean function, to validate the Cart Component has all needed elements displayed properly (for State of: Empty Cart)
	public boolean isProperEmptyCartUI() { // Checking both: Icon + Items Amount Indication is Empty
		sleep(500); // implement a quick sleep before validation starts and let the menu elements time to be loaded...
		if (isCartBtnDisplayed() && // see above method checking that Cart Button is displayed!
			// isDisplayed(cartBtn) && // before added above implementation - TODO - Delete !!!
			// note that the Cart Should-Be Empty by Default to begin with, unless items were added to it !!!
			isAbsent(itemsNumber)) { // this is indicative that NO items been added !!!
			return true;
		} else {
			return false;
		}
	}
	
	// implement boolean function, to validate the Cart Component has all needed elements displayed properly (for State of: Full Cart)
	public boolean isProperFullCartUI() { // Checking both: Icon + Items Amount Indication is Shown (there were items added to cart)
		sleep(500); // implement a quick sleep before validation starts and let the menu elements time to be loaded...
		if (isCartBtnDisplayed() && // see above method checking that Cart Button is displayed!
			// isDisplayed(cartBtn) && // before added above implementation - TODO - Delete !!!
			// note that the Cart Should-Be Empty by Default to begin with, unless items were added to it !!!
			isDisplayed(itemsNumber)) { // this element being visible, is the indication of items been added!
			return true;
		} else {
			return false;
		}
	}
	
/*	TODO - Added IF so Need to Delete below !
	// validate - get num of items in cart (note: this will not work for no items in cart) [was moved here from ProductsPage]
	public int getNumCartItems() {
		// String sNum = getText(driver.findElement(By.cssSelector(".shopping_cart_badge"))); // get elements' text [before PageFactory]
		String sNum = getText(itemsNumber); // same as above [after PageFactory] 
		int num=Integer.parseInt(sNum); // converts string to int
		return num;
	}*/
	// validate - get num of items in cart (note: this will not work for no items in cart) [was moved here from ProductsPage]
	public int getNumCartItems() {
		if (isProperFullCartUI()) { // itemsNumber indication isDisplayed !!!
			// String sNum = getText(driver.findElement(By.cssSelector(".shopping_cart_badge"))); // get el text [before PageFactory]
			String sNum = getText(itemsNumber); // same as above [after PageFactory] 
			int num=Integer.parseInt(sNum); // converts string to int
			return num;
		} else {
			return 0; // note that itemsNumber indication is Not displayed on UI at all !!!
		}
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
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
*/
