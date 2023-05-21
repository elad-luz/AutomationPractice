package tempSite.pageobjects; // Entrance page

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; // NOW, we can remove the: 'import org.openqa.selenium.By;' (if its not in use any more)  !!!
import org.testng.Assert;

import io.qameta.allure.Step;
import tempSite.utilities.ConfPropertiesUtil;
import tempSite.utilities.ReportAttachmentsUtil;

public class LoginPage extends BasePage { // commented code from after adding 'extends BasePage' -and- before adding the PageFactory ...
// note that this class don't extend Common, because the Common is relevant only after you are already logged in (e.g. Swag-Labs logo) !
	
/** ~~~~~~~~~~~~
	PageFactory:
	============ 
				Bottoms > Up, to Use PageFactory replaces: driver.findElement(By.cssSelector("#user-name")) > with: userField variable !
				- below is the added WebElements located (see the impact of usage in tTesting methods below):
				- do ctrl+space within the () will show all options: xpath= \ id=  etc. Need: import org.openqa.selenium.support.FindBy;
				  @FindBy(css="#user-name") // locate the element, just above
				  private WebElement usernameField; // to declare and init it
				- using BasePage 'fillText()' method = .clear() + .sendKeys(text) - after adding PageFactory element-Find !
				  fillText(usernameField, username); // usernameField is the above located element
				=v= pre PageFactory (but after adding BasePage method -> fillText is a combined .clear() + .sendKeys(text)...):
				- using SAME BasePage 'fillText(...)', BUT (before adding PageFactory, but After using BasePage) --> BasePage-Method is:
				  method gets 2 params: WebElement='el' (must be input field) & string='text', and fill the given text into the element.
				  public void fillText(WebElement el, String text) { // Quick -> el  must be located input --> doing: clear + sendKeys !
					clear(el); // clear(el)						<- [ unlike : 'el.clear' below v ]
					sendKeys(el, text); }
				- method in ThePage class (see element is located within usage of method):
				  fillText(driver.findElement(By.cssSelector("#user-name")), user); // here, we still use the 'located-element' itself !
				=v= pre BasePage - needed both separated actions (not as sequence-method):
				- SAME1 (before BasePage), 'clear' user field value (to be sure empty),  done directly on the 'located-element' itself !
				  driver.findElement(By.cssSelector("#user-name")).clear(); // el.clear()
				- SAME2 (before BasePage), 'sendKeys' insert user (from method input) into field, done on the 'located-element' itself !
				  driver.findElement(By.cssSelector("#user-name")).sendKeys(user); // el.sendKeys()
		----------------------
		variables => elements:
		======================
		page class template variables => here you declare all needed page elements as variables --
		note that you can use naming extensions: Btn=Button, Fld=Text-field, Lnk=Link, Err=Error, Chk=CheckBox etc.
		using PageFactory, we can initiate -&- locate ALL constant objects (not dynamically changing) even before they appear on page  :
		they will be located only when asked for...
		the @ annotation refers to the element directly below it (elements could be located in page. and saved into variables)
		the '@FindBy(...)' comes to replace 'driver.findElement(By...)' -> within the '()', click "control+space" to get all by options-
		you can use to locate element (and they resemble = like: id, css, xpath etc.)
		NOTE: if a dynamic element appears on page -and- must be located on-spot (in its' current form),
		the driver must be used in the form as defined in BasePage), instead of as defined in this class local constructor !
	*/
	// below is the added WebElements located (see the impact of usage in the Testing methods below) -> for WebElement, use NAME given :
	// NOTE that pares (2 lines) must come together for working each WebElement -> the @FindBy annotation & the declaration + naming !!!
	@FindBy(css=".login_logo") // Upper Logo [note: its not the same locator as that of the Logo in all other pages, which is in Common]
	private WebElement liLogoSwagLabs;
	@FindBy(css="#user-name") // ctrl+space in () show all options: xpath= \ id=  etc. Needs: import org.openqa.selenium.support.FindBy;
	private WebElement usernameField; // so now, 'usernameField' come to replace:  driver.findElement(By.cssSelector("#user-name"))  !!!
	@FindBy(css="#password") // by id
	private WebElement passwordField;
	@FindBy(css=".submit-button.btn_action") // by class
	private WebElement loginBtn;
	@FindBy(css=".login_wrapper")
	private WebElement loginWrapper;
	@FindBy(css=".error-message-container")
	private WebElement errorContainer;
	@FindBy(css="[data-test='error']") // by attribute="value"
	private WebElement errorMessage; // use to get the text out of element and check the "message" fits the test, expected result input!
	@FindBy(css=".error-button") // CloseErrorButton 'x' (would act as a demo for Stand-alone Element-Screenshot attachment to Report) !
	private WebElement errorCloseButton;
	@FindBy(css="#login_credentials > h4") // by "hierarchy" (nested location)
	private WebElement acceptedUsernames; // Headline of 'accepted usernames' list (also check later-on the correctness of list itself).
	@FindBy(css=".login_password > h4") // by "hierarchy" (nested location)
	private WebElement passwordForUsers; // Headline of 'accepted usernames' list (also check later-on the correctness of list itself).
	
	/* NOTE: the @FindBy annotation is used to declare and initialize web element variables, using the desired web locators in Selenium.
	Hence, you can find the web elements using popular locators like ID, Name, Link Text, Class Name, etc. --> Learn more here:
	https://www.lambdatest.com/blog/page-factory-in-selenium/#:~:text=@FindBy annotation in Page Factory,Text, Class Name, etc.
	*/
/** ~~~~~~~~~~~~
	constructor:
	============
	*/
	// constructor - initialize the properties using super (of BasePage = parent) -> This is GENERAL for all pages (to all have driver)!
	public LoginPage(WebDriver driver) {
		super(driver); // initialize the driver
	}
		// PageFactory.initElements(driver, this); // using driver on this page - BUT because it is used in each, we put it in BasePage!
		/** notes:
		1. this.element = driver.findElement(By.cssSelector("#...")); => this kind of locating W.E is not needed when using PageFactory,
		   it is done above using the PageFactory-@FindBy annotation in-front of the declared element variable
		2. now, initialize (using PageFactory) all elements (declared previously), you must use PageFactory object method initElements :
		   PageFactory.initElements(driver, this); -->
		   BUT, because it is used here in all pages, we can inherit from the BasePage constructor
		   PrevElement = driver.findElement(By.cssSelector("#Prev"));   // is removed...

/**	------------------------------------------------------------------------------------------------------------------------------------
	|--->    methods wrapping the basic UI functionalities - to be used in TestCases, needing those operational-scripting steps    <---|
 	====================================================================================================================================
 	*/
	// implement login function -> NOTE: the functional classes should have no variables' values (which would be supplied by TestCases)!
	@Step("Login-attempt with Credentials in Text-fields: User & Pass -and- Click to Commit them") // Allure annotation describing step!
	// if add in Step text User='{0}' & Pass='{1}' -> it would present Both the first & second Method Arguments being used in the Title!
	public void login(String username, String password) { // needed username + password input (the test will go to set this method vars)
		// fillText(driver.findElement(By.cssSelector("#user-name")), user); // using BasePage fillText BUT before adding PageFactory !!
		// after adding PageFactory we can replace:  'driver.findElement(By.cssSelector("#user-name"))'  -> with:  'userField' variable.
		fillText(usernameField, username); // BasePage 'fillText' = .clear() + .sendKeys(text) - after adding PageFactory element-Find !
		// fillText(driver.findElement(By.cssSelector("#password")), password); // before adding PageFactory
		fillText(passwordField, password);
		// click(driver.findElement(By.cssSelector(".submit-button.btn_action"))); // before adding PageFactory
		sleep(500); // not sure its the best, but I need it ->  TODO  --> Try to fix for several TestCases of Failed Login ...
		click(loginBtn);
		// above click ^ will Log me IN -> then, after success login (needing login validation) I can go to any Page in system	
	}
	// implement the above login function so its input uses 'properties' credentials of Successful Login !
	public void loginUsingValidCredentials() { // no input is needed - the method only implements the above, using proper credentials from properties.
		login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass"));
	}

	// implement a click on login function -> NOTE: this only clicks (without filling in any user & pass in fields)...
	public void clickLogin() {
		click(loginBtn);
	}
	
	// implement a click on Error Button function -> NOTE: it needs to be visible (only after failed login)
	public void clickErrorButton() {
		if (isDisplayed(errorCloseButton)) {
		click(errorCloseButton);			
		}
	}
	
	// implement a print screenshot of the 'Close Error' button WebElement -> NOTE: it needs to be captured only after failed login!
	// implementation demo on: tc01_LoginFailures -&- tc02_LoginFailureCloseError_MsgRemoved()  method -> in: S01_LoginTests class !
	public void printErrorButton() {
		if (isDisplayed(errorCloseButton)) {
			ReportAttachmentsUtil.attachElementScreenshot(errorCloseButton);
		}
	}
	
/**	------------------------------------------------------------------------------------------------------------------------------------
	|--->    methods for validations - retrieve various info, to use in TestCases, needing it for comparison to expected result    <---|
	====================================================================================================================================

	Add implementations & compare it to expected result (then use while performing assertion in TestCase itself)
	BUT note that, for implement a get info function, to validate a successful login, you must do it from Product Page, you arrived to !
	*/
	// implement get info function, to validate page is login - to verify you actually see the expected Destination page, getting to it!
	public boolean isLoginPage() { // no need users' input (this method will have the expected & compare)
		// sleep(500); // need to find better mechanism then sleep - to actually wait till loin is done !
		if (isDisplayed(loginWrapper)) { // checks if element is displayed (using wait)
			return true; // proper page !
		} else {
			return false;
		}
	}

	// implement boolean function, to validate login page has all elements displayed! & test fields are empty!
	// note: I'm using IF with AND binary operator, so only if all operands are true, the result is true (otherwise the result is false)
	@Step("GUI Test: Checking the Web-Page contain ALL the expected UI-elements") // Allure annotation to describe step taken by method!
	public boolean isProperUI() {
		if (isDisplayed(liLogoSwagLabs) &&
			isDisplayed(usernameField) &&  isTextFieldEmpty(usernameField) &&
			isDisplayed(passwordField) &&  isTextFieldEmpty(passwordField) &&
			isDisplayed(errorContainer)&&  // an Empty place for Errors to be shown
			isAbsent(errorMessage) && isAbsent(errorCloseButton) && // error would exist only after failed login...
			// isAbsent(loginBtn) && // Test to see if works & causes proper Failure  <-----------------------------|  TODO - Delete !!!
			isDisplayed(loginBtn) &&
			isDisplayed(acceptedUsernames) &&
			isDisplayed(passwordForUsers)) {
			return true;
		} else {
			return false;
		}
	}
	
	// implement boolean function, to validate login page Error Field show Message & x Btn.
	public boolean isErrorDisplayed() {
		if (isDisplayed(errorMessage) && isDisplayed(errorCloseButton)) {
			return true;
		} else {
			return false;
		}
	}

	// implement get info function, to validate errorMessage given - to verify you actually see the proper error for a Failure TestCase!
	@Step("Geting the displayed Error Message from page")
	public String getErrorMsg() { // This can be used in assertEquals to compare this: actual.toLowerCase() with: expected.toLowerCase()
		if (isErrorDisplayed()) {
			if (getText(errorMessage).isEmpty()) {
				return "Error Displayed Without a Message";
			}
			return getText(errorMessage); // getting the Text of the ERROR
		}
		return "No Error was Displayed!";
	}
	
	// implement a boolean function, to validate errorMessage given -&- verify you actually see the proper error for that Failure Case !
	// NOTE that if we want, we can make many methods - one for each failure case, and then we can use it without the input of expected!
	public boolean isProperError(String expectedError) { // need user input (test will do the input to this method with expected error)!
		sleep(1000); // need to find better mechanism then sleep - to actually wait till loin is done !!!   <---   TODO Remove sleep !!!
		// String error = getText(driver.findElement(By.cssSelector("[data-test='error']"))); // get Error for use  [before PageFactory]
		// String error = getText(errorMessage); // get current text of the ERROR for Comparison use  [after PageFactory] changed below!
		String error = getErrorMsg(); // same, but using above ^ Method)
		if (error.equalsIgnoreCase(expectedError)) { // result of this comparison will determine if Test-Assertion Passed of Failed!
			return true; // proper error -> 
		} else {
			return false;
		}
	}
	
	// implement a boolean function, to validate Case-Specific errorMessage given for "Missing Username"
	public boolean isMissingUsernameError() { // no need users' input (this method will have the expected & compare)
		sleep(1000); // need to find better mechanism then sleep - to actually wait till loin is done !!!
		String actualError = getErrorMsg(); // get current text of ERROR (using above ^ Method) for Comparison use  [after PageFactory]!
		String expectedError = "Epic sadface: Username is required";
		if ((actualError.toLowerCase()).equalsIgnoreCase(expectedError)) { // result of this comparison determines if Passed of Failed !
			return true; // proper error -> 
		} else {
			return false;
		}
	}

	// using BasePage method: assertElementText(WebElement, String) -> validates WebElement found Text equals to a given Expected Text !
	// implement a function to validate given Text of WebElement - do nothing beside asserting specific Element's Text is as Expected !!
	@Step("Checking the Usernames Title text")
	public void assertAcceptedUsernamesText() {
		assertElementText(acceptedUsernames, "Accepted usernames are:"); // Element acceptedUsernames Title == 'Accepted usernames are:'
	}
	
	// implement a function as above to validate given Text of WebElement - asserting specific Element's Text as Expected !!
	@Step("Checking the Password Title text")
	public void assertPasswordForUsersText() {
		assertElementText(passwordForUsers, "Password for all users:"); // Same for Password as of User...
	}
	
	// implement a function to validate Current Page Url is as Expected !!  TODO - Add this capability in BasePage & use a general way !
	public void assertCurrentPageUrl() { // Checks Login page URL = as Expected!
		String Expected = "https://www.saucedemo.com"; // Logged in page
		Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), Expected.toLowerCase()); // Assert NOT using an intermediate method !!
	}
	/** NOTE: ^ the above way, is directly using the Assert upon need (with a specific url to compare, not dynamic & flexible = below) !
		I've also added a wrapping method in BasePage, that do something alike (validate Current Url is as Expected) -> USE it in Test : 
	 	lp.assertCurrentUrl("expected"); // expected = full URL or any Partial sub-String of it, as input during method implementation !
	*/
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~

Below you can see changes made that assist your understanding & also more options of working (some examples, for later implementations)!

IF you don't use a BasePage:
----------------------------
public class NoBasePage { // not extending BasePage - got the driver init & the constructor is not super
	WebDriver driver; // property of object -> always need a driver !
	public NoBasePage(WebDriver driver) { // constructor - initialize the properties
		this.driver = driver;}
	// implement click on Button (without a base page - click not wrapped)
	public void clickBtn() {
		driver.findElement(By.cssSelector("#btn")).click();}

Prev changes from before to after adding BasePage:
--------------------------------------------------
	public class LoginPage { // this was the first draft before creating BasePage
	// fields (private) - all the properties of object
	WebDriver driver; // we would always need a driver -> NOTE that every page will got to have a driver to use for all its methods (like driver.findElement) ...
	// note that there is always the need to have a driver > BUT not to init it (the initialization of driver would be done upon using it via the TestCase class)
	// so you can put it in BasePage as a method to be inherited
	// the above WebDriver driver; was commented out after adding base page!
	// and the below constructor was rebuild
	// constructor - initialize the properties (the page will get the driver from the constructed use of it - made vie each Test-Class)!
	public LoginPage(WebDriver driver) { // after the adding of BasePage = parent it will change (see below)... --> EVERY PAGE NEEDS A CONSTRUCTOR FOR DRIVER !!!
		this.driver = driver;
	}
// constructor - initialize the properties using super (of BasePage = parent)
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// implement login function
	public void login(String user, String password) { // needed user + password input (the test will input to this method)
		// note that there is a duplication of sequence - you always clear before sendKeys -> so you can put it in BasePage as a method
		// before creating BasePage -> driver.findElement(By.cssSelector("#user-name")).clear(); // user field clear any previous value (to be sure its empty)
		// before creating BasePage -> driver.findElement(By.cssSelector("#user-name")).sendKeys(user); // insert user (from method input) into field
		fillText(driver.findElement(By.cssSelector("#user-name")), user); // after adding BasePage method -> fillText is a combined .clear() + .sendKeys(text)...
		// before creating BasePage -> driver.findElement(By.cssSelector("#password")).clear(); // password field clear any previous value (to be sure its empty)
		// before creating BasePage -> driver.findElement(By.cssSelector("#password")).sendKeys(password); // insert password (from method input) into field
		fillText(driver.findElement(By.cssSelector("#password")), password); // after adding BasePage method ...
		// driver.findElement(By.cssSelector(".submit-button.btn_action")).click(); // note that we wrapped that function it BasePage as a more powerful method !
		click(driver.findElement(By.cssSelector(".submit-button.btn_action"))); // same as above click ^ but using the wrapped method from BasePage !!!
		// above click ^ will Log me IN -> then, after success login (needing login validation) I can go to any Page in system	
	}
}
if you need to initialize a field in constructor (also array):
--------------------------------------------------------------
// fields
private boolean booleanName;
private int intName;
private ObjectClass instanceArrayName[]; // just declare the array of objects... ->
// --> cont. -> IF I use this without predefined input (see comment below) I must define & initiate the stations array via MAIN upon creation of CAR!
// constructor - initialize the properties - not all features are needed to be given (some can be predefined) ---
public ClassName() { // in our case the constructor con't require array input, because it is pre-set in advance !
	this.booleanName = false; // predefined as false
	this.intName = 0; // predefined as 0
	// this.instanceArrayName = instanceArrayName; // if you won't use the pre-set init of array value, you'll have to use this & do it from MAIM !!!
	// using the following way, you can initialize via constructor the pre-set the already declared array (above), so each radio will have it upon creation
	this.instanceArrayName = new ObjectClass[?]; // initialization array with predefined values
	instanceArrayName[0] = new ObjectClass(inputs);
}
// IF you need to, use the @Override annotation !!!

Converting string to integer method:
------------------------------------
	public int getNumFromString() { // IF there is a: (#) -> brackets with String indication of total amount...
		String s = getText(totalString); // before PageFactory:  String s= getText(driver.findElement(By.cssSelector("#total")));
		int num  = Integer.parseInt(s); // using Integer. method for converting the string into integer.
		return num;
	}

More Examples of varied methods:
--------------------------------
	public void fillForm(String xxx, String yyy, String zzz) { // Needs: import org.openqa.selenium.support.ui.Select;
		Select s = new Select(driver.findElement(By.cssSelector("[attribute='value']"))); // this object declaration needed when working on select DropDown list.
		s.selectByValue(xxx); // select the option with value of 'xxx' (as given in method input)
		fillText(driver.findElement(By.cssSelector("#id")), yyy); // fill the string "yyy" (given in method) to the input text field (by id)
		fillText(driver.findElement(By.cssSelector(".class")), zzz); // fill the string "zzz" (given in method) to the input text field (by class)
		click(driver.findElement(By.cssSelector("#id [attribute='value'].class > button]"))); // click on element (by a combined locator)
		// sleep(1000);
	}
	// USE like: lp.fillForm("select A", "11", "Task");

Example of working with List & related MOUSE Action (hover) & Alert:
--------------------------------------------------------------------
	public void deleteTask(String taskName) {
		// 	NOTE that the list could be located using @FindBy if we want - Gal say better to use it with-in code
		 	@FindBy(css = "#tasks>li") <-- Locate...
			private List<WebElement> tasksList;
		 	//
		List<WebElement> taskList = driver.findElements(By.cssSelector("#tasks>li"));
		for (int i = 0; i < taskList.size(); i++) {
			if (getText(taskList.get(i)).equalsIgnoreCase(taskName)) { // this will locate the element in list
				// mouse hover
				moveTo(taskList.get(i)); // this will move the mouse over to element (found just above^)
				sleep(2000);
				// now you want to click on the open-menu Btn that appears only on mouse-over  (to click on...)
				// click on menu (there are several of them under same locator, so you must use a list as well)
				List<WebElement> menuList = driver.findElements(By.cssSelector(".taskBtn")); // menu Btn List !
				click(menuList.get(i)); // using same 'i' found for Element, to locate in list the relevant ^ .
				sleep(2000);
				// click on delete
				click(menuDelete);
				// alert pop-up after delete -> needs click OK!
				alertAccept();
				break;
			}
		}
	}

Example of working with List of Elements invisible till selected:
-----------------------------------------------------------------
	@FindBy(css = "btnRename")
	private WebElement menuRenameBtn; // within menu opened, we can locate the rename option...
	@FindBy(css = ".list-action")
	private List<WebElement> listOfMenuBtns; // Locating the List of Menu for 2ed method
	
	// renaming Object (you need to locate the it first from a list of objects):
	 // list of 'open menu' objects - locating the list to click on listMenuOpenBtn as it is 'per item', would be done in code
	public void renameObject(String name, String newName) { // name is for object you want to change newN is what to change to
	WebElement openMeneBtn = driver.findElement(By.cssSelector("[title='"+ name +"']>.action")); // locate dynamically by name
		click(openMeneBtn); // clicking to open it
		click(menuRenameBtn); // clicking option rename
		alertOK(newName); // add New Name + click OK...
	}		
	// 2ed method do the same but in a slightly different approach - not locate the element by name BUT to locate it's display
	// renaming a list like above BUT in another way: using listOfMenuBtns & click on the displayed one...
	public void renameList(String newName) { // only one input to what to change to (we locate it by if it is displayed)
		for (WebElement el : listOfMenuBtns) { // go over all list
			if (el.isDisplayed()) { // find the displayed one
				click(el); // click it...
				break;
			}
		}
		click(listMenuRenameBtn); // clicking option rename
		alertOK(newName); // add New Name + click OK...
	}
Example of working with wait till condition to be on and off (like a 'loader' icon):
------------------------------------------------------------------------------------
	wait.until(ExpectedConditions.visibilityOf(loader)); // user = By.id("loadIcon")
	wait.until(ExpectedConditions.invisibilityOf(loader)); // loader disappeared ...
	
	
	//  validations - methods for all validations on page actions:
		==========================================================
		note that, regarding 'is element presence/visible/clickable' validation methods -- it is best to implement explicit wait (defined in parent method in _BasePage)
		note that, regarding 'is returned text/message correct' validation methods -- it is best to get the actual string here bellow -and- do the compare to a given string, on the _Test Assert (because the strings can look different on various locale - and we want robustness)
		again, the validations themselves (compare retrieved message to the proper given text) should be done On TESTs (for better flexibility), not here (not in this _Page class) !!!
			use the method as follow:
			first, validate the message element is displayed (to get its text) - using explicit wait method (before verify)
			after, get the text of message -and- validate against proper text (given string), as an indication of correct re-action (following the action)		
		note: if a dynamic element appears on page -and- must be located on-spot (in its' current form), the driver must be used in the form of '_driver' (as defined in _BasePage), instead of 'driver' (as defined in this class local constructor)
		note: to validate proper login succeeded, you must use a method in the page you logged in to

	// NOTE: following validation use a short way, without first initializing a variable='css' (of the element), to be used as the locator within the waiting method !
	// validate the myForms header link element is displayed (to verify reaching this myForms page) - using explicit wait method (before verify)
	public boolean isMyFormshDisplaied() {   // this method will verify that the myForms (link) element is visible, using explicit wait method (before verify) -and- decide if it retrieves TRUE=pass or FALSE=failed
		waitTillElementVisible("#ePlyHeader_dashboardLink");   // wait until condition for visibility of the myForms element (located by css) is met (max 5 seconds, as stated in constructor of _BasePage), and then do:
		if (isDisplayed(myForms)) {   // if it is displayed => true...
			return true; }
		else {   // if it is not displayed => false...
			return false; }
	}
	
	// NOTE: following validation use a slightly longer way, of first initializing a variable='css' (of the element), then using this variable as the locator within the waiting method !
	// validate the logout link element is displayed (to verify reaching this myForms page, the page you reach after successful login -and- to verify that the login procedure succeeded, we look for the logout element) - using explicit wait method (before verify)
	// note that, this method will NOT validate the actual user is logged in, only that the login succeeded
	public boolean isLoggedIn() {   //  this method will wait & check that the logout element is displayed (indicating the login succeeded) -and- decide if it retrieves TRUE=pass or FALSE=failed
		String css = "#ePlyHeader_LogoutLink";   // using a variable 'css' for the locator of 'logout' element (to be used within the following wait method)
		waitTillElementVisible(css);   // wait until condition for visibility of element located (by this css) is met (max 5 seconds, as stated in constructor of _BasePage)
		if (isDisplayed(logout)) {   // if the logout element is displayed, it means you are logged-in... => return: true
			return true; }
		else {   // if it is not displayed => return: false...
			return false; }	
	}

	// NOTE: following validation do Not use any wait (for element) method !		
	// validate the number of rows in table (to verify proper amount of results, after using the filter)
	public int getTableRowsNumber() {   // this method will return the rows in table
		int rows = 0;
		List<WebElement> list = _driver.findElements(By.cssSelector(".rgMasterTable>"));   // create a list of web elements as selected  [note: the driver must be used in the form of '_driver' (as defined in _BasePage)]
		rows = list.size();   // checking the size of list will indicate the number of rows in table after the filter
		return rows;   // the rows returned here, will be compared to a given 'proper' number during test (as a validation)
	}
	
	// Group of varied elements:
	public void isExistingElements() {
		List<WebElement> listOfElements = new ArrayList<WebElement>(); // declare & initiate a collection of web-elements
		listOfElements.add(usernameField);
		listOfElements.add(passwordField);
		for (WebElement el : listOfElements) {
			if (isDisplayed(el)) { // if element is displayed
				System.out.println(el + " exists");
			}
		}
	}

*/
