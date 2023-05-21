package tempSite.testcases;

import org.testng.annotations.Test;

import tempSite.pageobjects.LoginPage;
import tempSite.pageobjects.ProductsInventoryPage;

public class S02_ProductsInventoryTests  extends BaseTest{ // TestPlan Section 02 Test-Cases:

	@Test (priority = 0, description= "Smoke-Test = Products-Inventory page is Accessible & Contains the expected UI-elements")
	public void tc00_ProductsInventory_ElementsExist() throws InterruptedException {
		LoginPage lp = new LoginPage(driver); // initiate the page, to use its methods
		// lp.sleep(500); // you get to sleep which is in BasePage, also via this page
		lp.loginUsingValidCredentials(); // using login method which make use of valid credentials input (from configuration.properties)
		// perform a successful login with valid credentials as a stand-alone method, comes to replace the line below (which needs input
		// lp.login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass")); // before using above ^ method !!
		// After Successful Login we are being Redirected to Products-Inventory page -> validate the redirection for a Successful login!
		ProductsInventoryPage pp = new ProductsInventoryPage(driver); // initiate the page
		// NOTE: below there are way we can use for validating we are in the correct Page:
		pp.assertCurrentUrl("saucedemo.com/inventory.html"); // using the dynamic method (from BasePage via pp.) for any URL validation.
		pp.isProperProductsInventoryPageUI();
		
		
		// TBD !!!
		// Common cm = new Common(driver);
		// assertTrue(cm.isProperClosedMenuUI(), "Closed Menu UI don't displayed all expected elements properly !");
	}

	/**
	2.	Validate Page opened and Display the following UI Elements:
		- Sort container visible & the default selection is: "NAME (A to Z)"
		- Inventory List of 6 Products (not the list content or sorting order!), each item has: 
			~ pic
			~ name
			~ text
			~ price
			~ Add btn (& because non was added yet, no Remove btn should be visible)

------------------------------------------
	@Test (priority = 1, description= "Functional-Test = XYZ")
	public void tc01_XYZ() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh(); // to refresh the page & get it default state!
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.clickProductItemFromInventory("Sauce Labs Backpack"); // go to product info page
		pp.assertCurrentUrl("saucedemo.com/inventory-item.html"); // verify you are on product items' info page
		Common cm = new Common(driver);
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("items"); // getting back to products inventory (list) page from Menu
		cm.assertCurrentUrl("saucedemo.com/inventory.html"); // verify you are back at products inventory (list) page
		assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 0), "Indication of Cart Items nor as expected = 0 !");
		pp.addToCart("Sauce Labs Backpack"); // adding product to cart - cart should indicate 1 product added
		assertTrue(cm.isProperFullCartUI(), "Full Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 1), "Indication of Cart Items nor as expected = 1 !");
		cm.openCart(); // click on icon to open the cart-page
		cm.assertCurrentUrl("saucedemo.com/cart.html"); // verify you are at the cart page
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("reset"); // clearing Cart from all added Items
	}
*///-----------------------------------------------------------------------------------------------------------------------------------|

}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~

cm.sleep(1500);
cm.clickOnMenuLnk("About"); // open ABOUT dynamically
cm.navigateBack();
cm.clickAboutMenuLnk(); // open ABOUT directly
cm.navigateBack();
// lp.sleep(2500);
// lp.login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass")); // already logged in from prev 
// System.out.println("3");
_________
---------
		Assert.assertEquals(driver.getCurrentUrl(), Expected); // validate we're back in inventory Page (note the Menu is already open).
// 6. Click the 2ed option located in Menu list of elements (.bm-item-list > a) = 'ABOUT'  <----  L1  --|
		// Gather all menu-list-selections under one element (there are several under same locator, so you must use a list)
		List<WebElement> menuList = driver.findElements(By.cssSelector(".bm-item-list > a"));
		// using the # location of Element within above List (which star with 0) -> So, 1 is the 2ed element in Menu list = ABOUT !
		menuList.get(1).click();
		Thread.sleep(1000);

		Assert.assertEquals(driver.getCurrentUrl(), Expected);
// 8. Click on the option located in Menu list of elements (.bm-item-list > a) that has Text = 'ABOUT' !!!
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

*/
