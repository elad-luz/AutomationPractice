package tempSite.testcases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import tempSite.pageobjects.Common;
import tempSite.pageobjects.LoginPage;
import tempSite.pageobjects.ProductsInventoryPage;
import tempSite.utilities.ConfPropertiesUtil;

public class S08_MenuTests  extends BaseTest{ // TestPlan Section 08 Test-Cases:

	@Test (priority = 0, description= "Smoke-Test = Menu (Common Component) is Accessible & Contains the expected UI-elements")
	public void tc00_Menu_ElementsExist() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass")); // Success LI credentials properties
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.isProductsInventoryPageTitle(); // validation for redirection to the Products-Inventory page, is indicative for a Successful login
		Common cm = new Common(driver);
		assertTrue(cm.isProperClosedMenuUI(), "Closed Menu UI don't displayed all expected elements properly !");
		cm.openMenu();
		assertTrue(cm.isProperOpenedMenuUI(), "Opened Menu UI don't displayed all expected elements properly !");
	}
	
	@Test (priority = 1, description= "Functional-Test = Close Menu")
	public void tc01_Menu_Close() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh(); // to refresh the page & get it default state!
		Common cm = new Common(driver);
		cm.openMenu();
		assertTrue(cm.isProperOpenedMenuUI(), "Opened Menu UI don't displayed all expected elements properly !");
		cm.closeMenu();
		assertTrue(cm.isProperClosedMenuUI(), "Closed Menu UI don't displayed all expected elements properly !");
	}
	
	@Test (priority = 2, description= "Functional-Test = Menu-link About")
	public void tc02_Menu_About() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh();
		Common cm = new Common(driver);
		cm.openMenu();
		cm.clickOnMenuLnk("about");
		// Assert.assertEquals(driver.getCurrentUrl(), "expected URL"); // using a direct method!
		// System.out.println("redirection to ABOUT = " + cm.getCurrentUrl());
		cm.assertCurrentUrl("saucelabs.com"); // using BasePage asserting method + part of URL -> validating opened proper destination !
		cm.navigateBack(); // also making use of a wrapping method from the BasePage! (backing so we can proceed with testing this page)
		// System.out.println("navigate back = " + cm.getCurrentUrl());
		cm.assertCurrentUrl("saucedemo.com/inventory.html"); // validating returned to proper page (continue on to next test from here)!
	}
	
	@Test (priority = 3, description= "Functional-Test = Menu-link All-Items")
	public void tc03_Menu_Inventory() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh();
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.clickProductItemFromInventory("Sauce Labs Backpack"); // go to product info page
		pp.assertCurrentUrl("saucedemo.com/inventory-item.html"); // verify you are on product items' info page
		Common cm = new Common(driver);
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("items"); // getting back to products inventory (list) page from Menu
		cm.assertCurrentUrl("saucedemo.com/inventory.html"); // verify you are back at products inventory (list) page
	}

	@Test (priority = 4, description= "Functional-Test = Menu-link Reset App, Clears Carts Items")
	public void tc04_Menu_ResetAppClearsCart() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh();
		Common cm = new Common(driver);
		assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 0), "Indication of Cart Items nor as expected = 0 !");
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.addToCart("Sauce Labs Backpack"); // adding product to cart - cart should indicate 1 product added
		assertTrue(cm.isProperFullCartUI(), "Full Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 1), "Indication of Cart Items nor as expected = 1 !");
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("reset"); // clearing Cart from all added Items
		assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 0), "Indication of Cart Items nor as expected = 0 !");
		// pp.sleep(500); TODO - Delete !
		// Re-check that the 'menu' & 'cart' functions, work properly from another page as well:
		pp.addToCart("Sauce Labs Onesie"); // add a different product to cart
		cm.openCart(); // click on icon to open the cart-page
		cm.assertCurrentUrl("saucedemo.com/cart.html"); // verify you are at the cart page
		assertTrue(cm.isProperFullCartUI(), "Full Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 1), "Indication of Cart Items nor as expected = 1 !");
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("reset"); // clearing Cart from all added Items
		assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 0), "Indication of Cart Items nor as expected = 0 !");
	}
	
	@Test (priority = 5, description= "Functional-Test = Menu-link Logout")
	public void tc05_Menu_Logout() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh();
		Common cm = new Common(driver);
		cm.openMenu();
		cm.clickOnMenuLnk("logout"); // getting back to products inventory (list) page from Menu
		lp.assertCurrentUrl("saucedemo.com"); // verify you are back at login page
		assertTrue(lp.isProperUI(), "UI don't displayed all expected elements properly !"); // isProperUI() checks that your Logged-out!
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
// see for more references: /SeleniumCourse/src/a_selenium/basics/O_SeleniumGroupingElements.java
 * * * * * * * *
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
