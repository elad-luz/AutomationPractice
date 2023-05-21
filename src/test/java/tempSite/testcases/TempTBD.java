package tempSite.testcases;

import org.testng.annotations.Test;

import tempSite.pageobjects.LoginPage;
import tempSite.pageobjects.ProductsInventoryPage;

public class TempTBD  extends BaseTest{
	
	@Test (priority = 0, description= "TEMP-Test: verify working code")
	public void tc00_LoginElementsExist() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.loginUsingValidCredentials();
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.assertCurrentUrl("saucedemo.com/inventory.html");
		pp.sleep(2000);
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
// =====================================================================================================================================
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~

	@Test (priority = 0, description= "Smoke-Test: verify login page is accessible & contains the expected main UI elements")
	public void tc00_LoginElementsExist() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass"));
		// assertTrue(lp.isProperUI(), "not all elements displayed");
		lp.sleep(500);
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.getItemsData();
		
	}
* * * * *
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
		//pp.sleep(1500); // TODO - Delete !
		pp.addToCart("Sauce Labs Onesie"); // again, adding product to cart - cart should indicate 1 product added
		cm.openCart(); // click on icon to open the cart-page
		cm.assertCurrentUrl("saucedemo.com/cart.html"); // verify you are at the cart page
		// check the menu-functionality works properly from another page:
		assertTrue(cm.isProperFullCartUI(), "Full Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 1), "Indication of Cart Items nor as expected = 1 !");
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("reset"); // clearing Cart from all added Items
		assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 0), "Indication of Cart Items nor as expected = 0 !");
	}
	
	@Test (priority = 1, description= "Functional-Test = Close Menu")
	public void tc01_Menu_Close() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		// System.out.println("1");
		lp.navigateRefresh(); // to refresh page & make sure No Error from Prev Case is Displayed!
		// lp.sleep(500);
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.addToCart("Sauce Labs Bike Light"); // adding product to cart
	}
	
	@Test (priority = 4, description= "Functional-Test = Menu-link Reset App, Clears Carts Items")
	public void tc04_Menu_ResetAppClearsCart() throws InterruptedException { // note: we are already logged in from prev case...
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh();
		Common cm = new Common(driver);
		cm.sleep(2000);
		//assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue(cm.isProperFullCartUI(), "Full Cart UI don't displayed all expected elements properly !");
		ProductsInventoryPage pp = new ProductsInventoryPage(driver);
		pp.addToCart("Sauce Labs Backpack"); // adding product to cart
		pp.sleep(2000);
		assertTrue(cm.isProperFullCartUI(), "Full Cart UI don't displayed all expected elements properly !");
		System.out.println("getNumCartItems: " + cm.getNumCartItems());
		assertTrue((cm.getNumCartItems() == 2), "Indication of Cart Items nor as expected = 1 !");
		cm.openMenu(); // opening menu from the new context page
		cm.clickOnMenuLnk("reset"); // clearing Cart from all added Items
		cm.sleep(2000);
		assertTrue(cm.isProperEmptyCartUI(), "Empty Cart UI don't displayed all expected elements properly !");
		assertTrue((cm.getNumCartItems() == 0), "Indication of Cart Items nor as expected = 0 !");
	}
----------------------------------------------------------------------------------------------------------------------------------------

dataProvider -> https://www.toolsqa.com/testng/testng-dataproviders/
to use data driven testing we first need to define a method that will return the data stored as a 2D (dimensional) object (like a table)
to that method we'll need to add the annotation TestNG @DataProvider (so it would be recognized as such).
for using Data Driven input we must add to @Test annotation the pointer parameter dataProvider="methodName" + an optional description...
note: data provider can be in a class of its own (not only as a method - but then you need to state it properly !
the data-store object (table) cells would now need to be mapped properly within the Test method input & within test code itself - NOTE :
There must be an exact match between the defined value stored per row & the input of method. if not, you'll get: MethodMatcherException!
_______________
public class DP
{
    @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
	 return new Object[][] {{"First-Value"}, {"Second-Value"}};
     }
    @Test (dataProvider = "data-provider")
    public void myTest (String Value) {
        System.out.println("Passed Parameter Is : " + Value);
    }
}
		=======================================================
		2D array see: https://www.educba.com/2d-arrays-in-java/
		// declaring and initializing 2D array
		int arr[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 4, 4, 5 } };
		// printing 2D array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	// The fist case show both types of Assertions (assertTrue & assertEquals):						  TODO - Add asserts to other cases!
	@Test // annotation of TestNG marks a Test-Case: Login Failed Missing Username (01) -> tA stands for TestCase #A so it'll run first!
	public void tA_LoginFailedMissingUsername() throws InterruptedException { // RUN Order is by ABC, so if all start with T, tA starts!
		System.out.println("START Test-Case: Login Failed on Missing Username"); // TODO -> REMOVE not needed redundant prints !!!
		LoginPage lp = new LoginPage(driver); // declare & init the LoginPage !
//		Adding Test Assertion (should come to replace the above ^ printout - See below 2 main Asserting types (there some more though) :
//		Assert.assertTrue(condition); // to check if something ended properly (mainly boolean method stated in the relevant Page class)!
//		Assert.assertEquals(actual, expected); // to check if 2 variables match by compare actual to expected (a String, int -or other).

		// using assertTrue: for that we need to make the check on a boolean Page-Method -> To check i'm on the proper Page !!!
		Assert.assertTrue(lp.isLoginPage()); // as stated in LoginPage Method - if True it means you are in the proper Page !!!
		
		// Note: BECAUSE we work on the same page, we want to make sure that the page-state is being refreshed before each case starts !
		lp.navigateRefresh(); // this is a BasePage method that refresh this page (to make sure we start fresh, without dangling stuff)!
		// functional operation step needed (for this test) within that page initialized -> do login using inputs:
		lp.login("", "secret_sauce"); // Missing User | proper Pass !!!
		// validate if login failed -> check if you are still on login page (an add asserts on !
		System.out.println("Login Failed on Missing Username: "+ lp.isProperError(
				"Epic sadface: Username is required")); // TODO  -->  change it to 'Assertion'  !!!

		// using assertEquals: for that we need to compare on the Test-Method
		String expected = "Epic sadface: Username is required"; // This is what I expect the ERROR to be (in assert I'll drop to lower)!
		String actual = lp.getErrorMsg(); // this is using a get method from page (in the validation section) to fetch the actual ERROR!
		Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase()); // here we compare the 2 to see if they match => TEST PASSED!
		
		// using assertTrue: for that we need to make the comparison on a Page-Method [works only if Case-Specific Method exist in Page]
		Assert.assertTrue(lp.isMissingUsernameError()); // as stated in LoginPage Method: if True, it means you got the proper ErrorMsg!
		
		System.out.println("END Test-Case: Login Failed on Missing Username (01)\n"); // TODO ->  REMOVE not needed redundant prints !!!
	}
	
	// NOTE: the Running-order is RANDOM and for all to Succeed, this last one should RUN the last !!! ---------------------------------
	@Test // annotation of TestNG marks a Test-Case: Login Succeeded (05)
	public void tE_LoginSucceeded() throws InterruptedException {
		System.out.println("START Test-Case: Login Succeeded"); // TODO -> REMOVE not needed redundant prints !!!
		LoginPage lp = new LoginPage(driver); // declare & init the LoginPage !
		//  validate you are in LoginPage
		System.out.println("Login page displayed: "+ lp.isLoginPage()); // TODO  ->  change it to Assertion !!!
		// Note: BECAUSE we work on the same page, we want to make sure that the page-state is being refreshed before each case starts !
		lp.navigateRefresh(); // this is a BasePage method that refresh this page (to make sure we start fresh, without dangling stuff).
		// functional operation step needed (for this test) within that page initialized -> do login using inputs:
		lp.login("standard_user", "secret_sauce"); // proper User | Pass !!!
		// validate if login succeeded -> if you arrived to the proper destination of success --> to the ProductsPage !
		ProductsPage pp = new ProductsPage(driver); // for this we'll need to declare & init the ProductsPage as well !
		System.out.println("Login Succeeded: "+ pp.isProductsPage()); // TODO  ->  change it to Assertion !!!
		System.out.println("END Test-Case: Login Succeeded (05)\n"); // TODO -> REMOVE not needed redundant prints !!!
*/
/** This class inherit functions from BaseTest which are relevant to all TestCases Performed:
	I'll run Login Scenario (E2E) with several data-sets, under TestsCase:
- browse to url + login using a data-set + validation...
see more notes bellow !
--------------------- */
/*	NOTE:
	in order to use DDT (data Driven Testing) you should   import org.testng.annotations.DataProvider;
	1. create method to read from with @DataProvider annotation - in this example its called getData()
	2. add dataProvider = "getData" parameter to the @Test
	3. and if needed - a Util to assist with fetching the data (from excel file / configuration.properties)
*/
//	--------------------------------------------------------------------------------------------------------------------------------
/*	Example 0. Using Direct Data - NOT 'Data Driven' is being used:
	This case test a Failed Login option (on missing user) - data is in the method itself, thus a singular case (not a data driven):
*/
/**
@Test
public void LoginFailedMissingUser() throws InterruptedException {
	System.out.println("START Test-Case -- NOT Data Driven"); // TODO ->  REMOVE not needed redundant print !!!
	LoginPage lp = new LoginPage(driver); // initiate the login page object
	// Note: BECAUSE we work on the same page, we want to make sure that the page-state is being refreshed before each case starts !
	lp.navigateRefresh(); // this is a BasePage method that refresh this page (to make sure we start fresh, without dangling stuff)!
	
	// functional operation step needed (for this test) within that page initialized -> do login using inputs:
	lp.login("", "secret_sauce"); // call the login methods from the login page & use: Missing User + Pass -> the login should fail!
	// using 'assertEquals' to check that we got the proper failure message
	// expected (to compare with actual) -> the expected error message as result of this failed login
	String expected = "Epic sadface: Username is required"; // This is what I expect the ERROR to be (in assert I'll drop to lower)!
	// actual -> the error message we got after performing the failed login
	String actual = lp.getErrorMsg(); // this is using a get method from page (in the validation section) to fetch the actual ERROR!
	// asserting by compare
	Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase()); // here we compare the 2 to see if they match => TEST PASSED!
	// end test
	Thread.sleep(1000);
	System.out.println("END Test-Case \n"); // TODO ->  REMOVE not needed redundant print !!!
}
*/	
//	--------------------------------------------------------------------------------------------------------------------------------
/*	Example 1. dataProvider = Method with data
 	Using 'Data Driven' taken from another Method (bellow):
	This case tests several Failed Login options - data comes from another method (bellow), thus a multiple test-case (data driven):
	DATA DRIVEN (adding to test the pointer dataProvider="methodName" + optional also description):
*/
/**
@Test (dataProvider= "getData", description= "use incorrect login input from a data source") // ctrl+space in brackets show options!
// This case test several Failed Login options (uses dataProvider annotation param, holding inputs of String user, password, error):
// public void LoginFailed(String user, String password) throws InterruptedException { // input from dataProvider: only user & pass!
// the approach can be that dataProvider hold only user & pass, but then you have a static error that don't match all cases,  SO ...
public void LoginFailedIDPM(String user, String pass, String expected) throws InterruptedException { // input dataProvider = method!
	System.out.println("START Test-Case -- Data Driven from Method"); // several login failed test cases...	-> 1st Fails on extra'!'
	// I entered extra '!' to fail the test for getting screen-shot of failure (to fix, change in data-provider)
	LoginPage lp = new LoginPage(driver);
	lp.navigateRefresh();
	
	// functional -> do login using inputs from method:
	// instead of putting in the user & pass - we make use of the variables we get from the @DataProvider getData method (below) ...
	lp.login(user, pass); // the login should fail according to the provided data input (for getting error of wrong user \ pass)
	// bellow the static case specific error  -> this was now moved into the 2d Array dataProvider object as expected ERROR string !
	// String expected = "Epic sadface: Username and password do not match any user in this service"; // without 'error' in object !
	String actual = lp.getErrorMsg();
	Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase()); // expected is part of input = able to support more errors !!
	Thread.sleep(1000);
	System.out.println("END Test-Case \n");
}
*/
/*	This is the example of a method that returns a 2 dimensional object (like a table) -
	using the @DataProvider the above method would get the parameters for each iteration FROM METHOD
 */
//	@DataProvider // in case defined (name = "data-provider") use it instead of methodName
/** NOTE: without expected string, we need to hard-code it in test (as part of method) & there can be one only (or a complicated if)
public Object[][] getData(){ // 2 bracket set is a 2 dimensional object like a table... containing in each row User, Pass
	Object[][] myData = {
			{"standard", "secret"},
			{"elad", "#a1b2c3"},
			{"user", "pass"},
			{"yonk", "#"},
	};
	return myData;
}
*/ // so we add it as seen bellow -> above testMethod LoginFailedIDPM uses this input dataProvider method!:
/**
@DataProvider
public Object[][] getData(){ // 2 bracket set is a 2 dimensional object like a table... containing in each row: User, Pass & error !
	Object[][] myData = {
			{"dataMethod", "secret", "Epic sadface: Username and password do not match any user in this service!"}, // > fail on '!'
			{"elad", "#a1b2c3", "Epic sadface: Username and password do not match any user in this service"},
			{"user", "pass", "Epic sadface: Username and password do not match any user in this service"},
			{"yonk", "#", "Epic sadface: Username and password do not match any user in this service"},
			//{"yonk", "", "Epic sadface: Username && password"}, // thats a wrong error, and it will fail the case (proper below) !
			{"yonk", "", "Epic sadface: Password is required"},  // this error is the proper one (the above ^ can be commented out)!
	};
	return myData;
}
*/
/*	--------------------------------------------------------------------------------------------------------------------------------
Example 2. dataProvider = Excel with data
Using same type 'Data Driven' but taken from excel file (needing the excel file and an intermediate Util to do the data-fetch):
This case tests several Failed Login options - data comes from excel , thus a multiple data driven test-case:
 */
/**
@Test (dataProvider= "getDataFromExcel", description= "use incorrect login input from a data source") // change to fit dataProvider!
// This case test several Failed Login options (uses dataProvider annotation param, holding inputs of String user, password, error):
// public void LoginFailed(String user, String password) throws InterruptedException { // input from dataProvider: only user & pass!
// the approach can be that dataProvider hold only user & pass, but then you have a static error that don't match all cases,  SO ...
public void LoginFailedIDPE(String user, String pass, String expected) throws InterruptedException { // input dataProvider = excel !
	System.out.println("START Test-Case -- Data Driven from Excel"); // several login failed test cases...  -> 1st Fails on extra'!'
	// I entered extra '!' to fail the test for getting screen-shot of failure (to fix, change in data-provider)
	LoginPage lp = new LoginPage(driver);
	lp.navigateRefresh();
	// functional -> do login using inputs from excel file:
	// instead of putting in the user & pass - we make use of the variables we get from the @DataProvider getData method (below) ...
	lp.login(user, pass); // the login should fail according to the provided data input (for getting error of wrong user \ pass)
	// bellow the static case specific error  -> this was now moved into the 2d Array dataProvider object as expected ERROR string !
	// String expected = "Epic sadface: Username and password do not match any user in this service"; // without 'error' in object !
	String actual = lp.getErrorMsg();
	Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase()); // expected is part of input = able to support more errors !!
	Thread.sleep(1000);
	System.out.println("END Test-Case \n");
}
*/
/*	This is the example of a method that returns a 2 dimensional object (like a table) -
	using the @DataProvider the above method would get the parameters for each iteration FROM EXCEL
 */
/**
@DataProvider // in case defined (name = "data-provider") use it instead of methodName...
public Object[][] getDataFromExcel(){
	String excelPath = System.getProperty("user.dir") + "/src/saucedemo/resources/inputTestData.xlsx"; // excel data file path
	System.out.println(excelPath);
	Object[][] table = ExcelTabsUtil.getTableArray(excelPath, "loginTest"); // the ExcelTabsUtil needs importing  |  loginTest = tab
	return table;
}
*/
/*	--------------------------------------------------------------------------------------------------------------------------------
	Example 3. Using 'Data Driven' from a configuration.properties file (needing an intermediate Util for the data-fetch):
	NOTE that if you want to use this kind of input at test level, use it like this:  driver.get(Utils.readProperty("url"));
	This case tests several Failed Login options - data comes from configuration.properties , thus a multiple data driven test-case:
*/
/**
@Test // Using ConfPropertiesUtil to get data from a configuration.properties file.
public void LoginFailedIDPCP() throws InterruptedException { // input dataProvider = configuration.properties file !
	System.out.println("START Test-Case -- Data Driven from configuration.properties"); // the data is one login failed test case...
	LoginPage lp = new LoginPage(driver); // initiate the login page object
	// Note: BECAUSE we work on the same page, we want to make sure that the page-state is being refreshed before each case starts !
	lp.navigateRefresh(); // this is a BasePage method that refresh this page (to make sure we start fresh, without dangling stuff)!
	
	// functional -> do login using inputs from properties file (example for one run - if need several iterations, its not the way !
	String user = ConfPropertiesUtil.readProperty("user"); // use as a String variable = 'user' (to get the value of user property).
	// System.out.println(user); // the user = xxx
	lp.login(user, ConfPropertiesUtil.readProperty("pass")); // call login method & use: user + pass (from configuration.properties)
	String expected = "Epic sadface: Username and password do not match any user in this service"; // This is expected the ERROR !!!
	String actual = lp.getErrorMsg(); // this is using a get method from page (in the validation section) to fetch the actual ERROR!
	Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase()); // here we compare the 2 to see if they match => TEST PASSED!
	// NOTE: if you'll delete the value of property: pass=   -->   you'll get Error in Test (because of mismatching message) bellow:
	// expected=epic sadface: username and password do not match any user in this service | found=epic sadface: password is required
	Thread.sleep(1000);
	System.out.println("END Test-Case \n"); // TODO ->  REMOVE not needed redundant print !!!
}
*/
/*	--------------------------------------------------------------------------------------------------------------------------------
	Example 4. Working on group of elements as array
*//**
@Test (priority = 0, description= "Smoke-Test: verify login page is accessible & contains the expected main UI elements")
	public void tc00_LoginElementsExist() throws InterruptedException {
		LoginPage lp = new LoginPage(driver); // initiate the page, to use its methods
		// lp.sleep(500); // you get to sleep which is in BasePage, also via this page
		lp.loginUsingValidCredentials(); // using login method which make use of valid credentials input (from configuration.properties)
		// perform a successful login with valid credentials as a stand-alone method, comes to replace the line below (which needs input
		// lp.login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass")); // before using above ^ method !!
		// After Successful Login we are being Redirected to Products-Inventory page -> validate the redirection for a Successful login!
		ProductsInventoryPage pp = new ProductsInventoryPage(driver); // initiate the page
		// NOTE: below there are way we can use for validating we are in the correct Page:
		pp.assertCurrentUrl("saucedemo.com/inventory.html"); // using the dynamic method (from BasePage via pp.) for any URL validation.
		
		System.out.println("\n-1-----------------------------------------------------------------------------------------------------");
		// is proper UI ? -> TODO --> Finish method in page !!!
		System.out.println(pp.isProperProductsInventoryPageUI()); // TBD !!
		assertTrue(pp.isProperProductsInventoryPageUI(), "not all elements displayed");
		
		System.out.println("\n-2-----------------------------------------------------------------------------------------------------");
		// Pre Sort -> Inventory List Items (Name & Price) - Orig State (before sort)
		pp.printAllItemsNameAndPrice(); // TBD (method will be removed of changed - to be used in Asserts) !
		// Orig preSort -> Inventory List Names + Prices - Orig State (before sort)
		System.out.println("Names orig:\n"  + pp.getInventoryListNames());
		System.out.println("Prices orig:\n" + pp.getInventoryListPrices());
		
		System.out.println("\n-3-----------------------------------------------------------------------------------------------------");
		// Orig is Sorted -> by Name \ Prices Ascending (A > Z \ low > high)
		System.out.println("Nams Asc:\n"  + pp.getSortedInventoryListNamesTrueAscFalseDece(true));
		System.out.println("Prices Asc:\n"  + pp.getSortedInventoryListPricesTrueAscFalseDece(true));
		
		System.out.println("\n-4-----------------------------------------------------------------------------------------------------");
		// Orig is Sorted -> by Name \ Prices Descending (Z > A \ high > low)
		System.out.println("Prices Desc:\n" + pp.getSortedInventoryListNamesTrueAscFalseDece(false));
		System.out.println("Prices Desc:\n" + pp.getSortedInventoryListPricesTrueAscFalseDece(false));
		
		System.out.println("\n-5-----------------------------------------------------------------------------------------------------");
		System.out.println("Active Sort Option:\n" + pp.getActiveSortOption());
		pp.assertCurrentActiveSort("Name (A to Z)");
		System.out.println("\n-6-----------------------------------------------------------------------------------------------------");
		pp.clickSortOptions(); // open
		pp.sleep(1500);
		pp.clickSortOptions(); // close
		System.out.println("\n-7-----------------------------------------------------------------------------------------------------");
		pp.assertDefaultSortIsFirstOption();
		System.out.println("\n-8-----------------------------------------------------------------------------------------------------");
		System.out.println(pp.getSelect());

		System.out.println("\n-9-----------------------------------------------------------------------------------------------------");
		pp.clickSortOptions(); // re-open
		//pp.selectSortOptionVisibleText("z to a");
		pp.sleep(1500);
		//
		
		//
		pp.sleep(2000);
	}
}

*/

	
	