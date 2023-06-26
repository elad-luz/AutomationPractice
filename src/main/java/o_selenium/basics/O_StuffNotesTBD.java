package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O_StuffNotesTBD {
// For reference, look also in other classes: J_SeleniumActionsExercise3 + G_SeleniumElementsToListOf + I_SeleniumSelectOptionElements !
/** Try to work with Sort of Items by Price

 	*/
	public static void main(String[] args) throws InterruptedException {
// 0.
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		Thread.sleep(1000);
// 1.
		WebElement userField = driver.findElement(By.cssSelector("#user-name"));
		WebElement passField = driver.findElement(By.cssSelector("#password"));
		if (userField.getAttribute("value").isEmpty()) {
			System.out.println("user: NULL!"); // Print if text field is empty
		}
		else {
		    System.out.println("user: " + userField.getAttribute("value")); // Print if text field has an input value
		} // OUTPUT: user: NULL!
		// Fill IN inputs
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		if (userField.getAttribute("value").isEmpty()) {
			System.out.println("user: NULL!"); // Print if text field is empty
		}
		else {
		    System.out.println("user: " + userField.getAttribute("value")); // Print if text field has an input value
		} // OUTPUT: user: standard_user
		// driver.findElement(By.cssSelector("#login-button")).click();
	

		// TearDown the Test
		Thread.sleep(100);
		driver.quit();
		System.out.println("-- end --");
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/** Notes:
----------
Access value attribute of the <input> web element -- Following is an examples:
// 1.
WebElement inputBox = driver.findElement(By.id("inputBoxId"));
String textInsideInputBox = inputBox.getAttribute("value");

// Check whether input field is blank
if(textInsideInputBox.isEmpty())
{
   System.out.println("Input field is empty");
}
// 2.
if (ele.getAttribute("value").isEmpty()) {
    //Do something if the text field is empty
}
else {
    //Store the value
    String store=ele.getAttribute("value");
}
// 3.
var element = driver.findElement(webdriver.By.id("your elements id"));
//store text
var text = element.getText();
//store value
var value = element.getAttribute("value");
//after that you can do anything you want with these variables.
*/

/*	TODO ->
››	Delete Notes - Stuff from Project  ‹‹ 
------------------------------------------------------------------------------
 Below: more stuff I intend to incorporate in this infra as soon as possible…
==============================================================================

~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
