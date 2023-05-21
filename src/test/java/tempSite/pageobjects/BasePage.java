package tempSite.pageobjects; // SUPER for any pages

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

// TODO -> check why the long fillText method below don't work properly !!!
public abstract class BasePage { // all page classes will inherit from this super !
/**	class to wrap basic common capabilities of the driver (generally in use), to be used by all page-classes extends & inherit this one.
	note that if added any abstract method (without implementation), to be propagated down to child, then this must also be an abstract!
	this class is super-parent to all child pages, and because it is abstract, it can't be created as stand alone object by itself   ...
	MORE studies:
	https://www.swtestacademy.com/page-object-model-java
	https://devqa.io/page-object-framework-java-webdriver
	https://www.toolsqa.com/selenium-webdriver/page-object-model
	https://www.browserstack.com/guide/page-object-model-in-selenium
	https://www.seleniumeasy.com/selenium-tutorials/simple-page-object-model-framework-example
	https://www.seleniumeasy.com/selenium-tutorials/page-factory-pattern-in-selenium-webdriver
	https://www.javadoc.io/doc/com.seleniumtests/seleniumtestsframework/latest/com/seleniumtests/webelements/BasePage.html  <-------  */
	
	/**	~~~~~~~~~~
		variables:
		=========*/
	//	TODO -> Choose:  private = can only be accessed in its own class  -vs-  protected = can only be accessed within its own package.
	//	protected (or private) variables - all needed properties of this object:
	protected WebDriver driver; // declare WebDriver variable (called: 'driver')
	//	it would always be needed & will be initiated, by following constructor, via inhabitance, at each Test class level.
	//	the 'driver' every Page should have (if extend this BasePage super-class), needed to drive the browser natively, for automation!
	protected WebDriverWait wait; // declare the WebDriverWait variable (called: 'wait'), to be initiated by constructor on all Pages...
	protected Actions actions; // to enable mouse actions like: Hover (mouse-over WebElement)  ->  Needs import ...interactions.Actions;
	protected JavascriptExecutor js; // to enable using JavaScript  ->  Needs import...
	
	/** ~~~~~~~~~~~~
		constructor:
		===========*/
	//	constructor - initializes properties (every instant of each page, will use this - and each test would be compliant to init this)
	//	WebDriver object, needed to create this 'BasePage' object, will be initialized- only in each of the Grand-Child-Page-Test class.
	public BasePage(WebDriver driver) { // the WebDriver is the only thing that this constructor will get from upper classes using it...
		this.driver = driver;  // initiated as: 'driver'
		PageFactory.initElements(driver, this); // Needs: import org.openqa.selenium.support.PageFactory;
		/*	PageFactory.initElements(this.driver, this); // PageFactory will be used to initialize elements of all child Page classes !!
			PF assist with elements' initialization in each child-page-class having @Findby (instead of: driver.findElements.byWhatever)
			1.	because of PageFactory, we won't need to use ‘FindElement’ or ‘FindElements’ (the method 'initElements' is used instead,
				and, it is being done with the defined driver (on the current page you work on)
			2.	@ annotations can be used to supply descriptive names of target objects to improve code readability & code reuse-ability
				e.g. using in page class @FindBy, @FindBys, @FindAll annotations -->
				any change in element locator is done once and thus affects all instances of that element found on any page annotations,
				its a form of meta-data (provide data about program that's not part of the program itself), which have a number of uses.
				Example of usage in Page:
				@FindBy(css="#id") // Needs: import org.openqa.selenium.support.FindBy;
				private WebElement theID;
			3.	testNG annotations tells the compiler what to run & when: @Test, @BeforeTest, @AfterTest, @BeforeClass, @AfterClass ---|
				and also, extra info in ()  -—> like @Test (Priority = 0) etc. */
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // the wait is actually automatically initiated here as new object
		//	this wait will be implemented in the methods bellow --> so,it'll wait max of 5 seconds, until condition for element is met !
		//	sometimes written as: wait = new WebDriverWait(driver,5); -> but, this shortened version don't work for me for some reason ?
		//	EVERY page using this will already have this wait element initialized, so you don't need to do it on each page individually!
		this.actions = new Actions(driver); // Needed for Actions variable, to enable mouse actions
		this.js = (JavascriptExecutor)driver; // Possible to Add option of working with Javascript (see more about, in 'click' method) !
	}
	/**	~~~~~~~~~~~~~~~~~
		NOTE - not needed
		~~~~~~~~~~~~~~~~~
		getters & setters methods for wrapping the class this.variables private encapsulation + info toString() - are NOT needed here !!
		// print info - is also NOT needed here !!
		public void printInfo() {
			System.out.println(toString()); // print the toString as is // System.out.println("copy toString return String value");
		//
		also note that, these 2 selenium operations (along with driver initiation), are the only which will be implemented in the Tests!
		->	driver.close();			=>  closes current active browser window --> Not needed here !
				public void closeWindow() {
					driver.close();
				}
		->	driver.quit();			=>  closes the driver process with all related windows tabs => This is must to END every script ! */
	
	/**	================================================================================================================================
		|--->    methods to encapsulate the basic selenium commands  -  wrapping browser operation functionalities of WebDriver    <---|
	 	================================================================================================================================
		implementation wrapping of 'selenium functional capabilities', to allow adding those methods more power (for our automation) !!!
	  	upon defining all methods which encapsulate the selenium commands for the driver, note that  'el'  stands for any WebElement  --
	  	and 'el' actually come to replaces: driver.findElement(By.cssSelector("") -or- any other selector needed to locate that element!
	  	NOTE that: to use this in pages class, you first call the method & then five it the element, instead of using selenium methods :
	  	if you need to do click in a page method, you use it like this: click(driver.findElement(By.cssSelector(".btn"))); -- instead of
	  	not using the regular selenium straight-forward way, like that: driver.findElement(By.cssSelector(".btn")).click; [capiche ?] */

	//	TODO figure out if its needed: // upon various drivers in use !
	/*	public WebDriver getDriver() {
		return driver;
	}	*/

	/** ------------------------------
		Find WebElement... operations:
 		=============================*/
	//	locate a WebElement By given locator --> performs: driver.findElement(locator)    [e.g. locator = 'By.cssSelector("#username")']
	public WebElement find(By locator) { // the method gets a parameter of type 'By' (element locator) and returns the found WebElement!
		return driver.findElement(locator);
	}
	//	NOTE -> TODO --> Add to methods bellow the 'waitForElementVisibility(el);' method upon need...
	
	/** -------------------------
		Functional... operations:
 		========================*/
	//	click something on screen  ->  also, highlight the element thats being clicked (for demo usage, if needed - if not, comment out)
	@Step("Click functionality on a WebElement") // can add {el} - Allure annotation describes what step is being performed by method !!
	public void click(WebElement el) { // the method gets parameter of type 'WebElement' (formally represented as: el) and click on it !
		waitForElementVisibility(el); // general wait till element is visible (before try to click on)...  ->  Method used stated below!
		waitForElementClickability(el); // general wait till element is clickable (before try to click on) ->  Method used stated below!
		/* Highlight WebElement worked on using JavascriptExecutor:
		   we can add more actions, like 'highlight' of the selected area before clicking on it (for video capture of test run) --- etc.
		   use below code to give a web element style with border -> element is the WebElement that get the style (that can be changed):
		   JavascriptExecutor js=(JavascriptExecutor)driver; // to declare & initialize a Javascript object...
		   // NOTE: because above line is a duplication of code per method, it could be passed above (see constructor)
		   // js.executeScript("arguments[0].setAttribute('style', 'border: 1px solid blue;');", WebElement); // wrap el with blue line!
		   // sleep(500); // needed for a slight pause to see it happens -->
		   // NOTE: because above 2 lined are duplication of code per method, it could be passed to a specific method (see highlight) */
		// js.executeScript("arguments[0].setAttribute('style', 'background-color:yellow; border:1px solid red;');", el); // WebElement!
		highlightElement(el, "black"); // we can decide click is colored with green (and later on when used in sendKeys it will be blue)
		sleep(500); // added sleep so it looks as if an operation was made on the element (to slow the test-steps a bit) !!!
		// TODO -> Make sure to mark-out the highlight & related sleep if not working in a DEMO mode !!
		el.click();
	}
	// Highlight any WebElement (private method) --> call this method with your element (el) and any color (like: red, blue, green etc.)
	// a private method to use only here, you can't call it from outside of this BasePage class !!!
	// TODO -> Make sure to mark-out the highlight & related sleep if not working in a DEMO mode !!
	/** Simple method that only Highlight WebElement (note: the 1px border stays highlighted throughout the entire test-case method)
	private void highlightElement(WebElement el, String borderColor) { // method gets WebElement (as: el) & color, to Highlight it !
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("arguments[0].setAttribute('style', 'border: 1px solid " + borderColor + ";');", el); // Highlight WebElement !
		}
	 // NOTE: You can add the highlight in each method with WebElement you wish to: click, sendKeys, getText (for Assertions) etc...
	*/
	// Complex Highlight method that is switching Back to orig stile (after the Highlight with 1px colored border):
	private void highlightElement(WebElement el, String borderColor) { // method gets WebElement (el) & color, to Highlight it!
		waitForElementVisibility(el); // general wait till element is visible (before try to highlight it)...  ->  Method stated below !
		// this part keeps the old style (to change it back after the Highlight)
		String originalStyle = el.getAttribute("style"); // ORIG
		String newStyle = "border: 2px solid " + borderColor + ";" + originalStyle; // Highlight - can also add a Colored background ...
		// String newStyle = "background-color:LightYellow; border: 1px solid " + borderColor + ";" + originalStyle; // with background!
		// NOTE: the above background-color is a constant -- but could easily also be passed with method (like borderColor)...
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Change the style to Highlight (new)
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", el);
		// Change the style back to ORIG after 500 milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},500);", el);
		} // TODO -> Make sure to mark-out the highlight & related sleep if not working in a DEMO mode !!  <---------------------------|
	
	//	NOTE: 'Overloading' is having 2 methods with the same name - But, with minor differences (for example in input variables etc.) :
	//	do as above, and also have same name, BUT it is NOT the same because it gets a locator of element (instead of the WebElement)...
		public void click(By locator) { // the method gets a parameter of type 'By' [e.g. 'By.cssSelector("#username")'] - and click it.
		// note: the name could have been click (instead of clickBL) and although there is already one with same name its OK - Not Same!
		find(locator).click();
	}
	//	submit (mimic clicking 'enter' to submit a form)
	public void submit(WebElement el) { // the method gets a WebElement='el' -and- do a submit (like clicking 'enter' upon filling form)
		// highlightElement(el, "green"); // we can decide so use same green (as above click), also for submit if we want to...
		// sleep(500);
		// TODO -> Make sure to mark-out the highlight & related sleep if not working in a DEMO mode !!
		el.submit();
	}
	//	sendKeys - using: 'find(by)' method (stated above) with a locator [e.g. 'By.cssSelector("#username")'] to locate the WebElement!
	//	the method gets 2 parameters: a locator (must be of input text-box) & string='text', and fill the text into the located element.
	public void typeIn(String inputText, By locator) { // - can also be implemented as: public void typeIn(WebElement el, String text) {
		find(locator).sendKeys(inputText); // - and can also be implemented as: el.sendKeys(inputText); // when inputText = "GivenText"!
	}
	//	sendKeys - using: 'el' not 'locator'
	//	the method gets 2 parameters: an element (of input text-box) & string='text', and fill the text into the element.
	public void sendKeys(WebElement el, String inputText) {
		waitForElementVisibility(el); // general wait till element is visible (before try to click on)...  -> !
		// highlightElement(el, "blue"); // we can decide sendKeys is colored with blue (note: the sleep comes only after input action)!
		el.sendKeys(inputText);
		// sleep(500); // sleep is a bit larger than the style switch (so it looks as operation was made on the element !!!
		// TODO -> Make sure to mark-out the highlight & related sleep if not working in a DEMO mode !!
	}
	//	clear text from field (empty any current text) --> NOTE that, unlike the previous one, this method uses WebElement, not locator!
	public void clear(WebElement el) {  // the method gets a parameter: WebElement='el' -and- clear its current content (if possible)...
		el.clear();
	}
	//	fill Text in relevant Field (work only on type: 'input'), the longer version implements a combined function of clear + sendKeys:
	//	method gets 2 parameters: WebElement='el' (must be an input text-box) & string='text', and fill the given text into the element.
	//	USING THE SHORT version !!!
	public void fillTextQuick(WebElement el, String text) { // Quick = Shorter version (el must be located as input, cleared and filled)
		clear(el);
		sendKeys(el, text);
	}
	/**	TODO: need to understand why sometimes the long version don't work for TestNG  -  while the pre-existing text is not cleared !!!
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/// The Longer version has more complexity, like:
	public void fillText(WebElement el, String text) {
	//	validate before fill-in 'text' to 'text-field' element (type 'input'), it's visible, highlighted -and- empty of previous text...
		waitForElementVisibility(el); // general wait till element is visible (before try to fill text to it)
		highlightElement(el, "blue"); // as sendKeys, we decide to color field with blue (note: sleep comes after all actions ended)  !!
		if (el.getTagName().contains("input")) { // if the element is of type: input
			if (el.isDisplayed()) { // and, if the element exists on page  ---> we will check if it has previous test inserted already !
				// if (el.getText().isEmpty()) // NOTE: getText - found to be irrelevant, so I've replaced it with Attribute of 'value'!
				if (isTextFieldEmpty(el)) // and, if it is empty - see method 'isTextFieldEmpty' bellow, using: 'getAttribute' function!
				{
					el.sendKeys(text); // fill the 'text' input, into the input text-box field element
				}
				else { // if text-box element is not empty (and need to be made empty)
					el.clear(); // clear existing input beforehand! if you'll not clear, new input will be concatenated to previous text
					el.sendKeys(text); // and afterwards, fill in the 'text' input field
				}
			}
		}
		else { // if by any chance, the given element is NOT a type 'input' - print the issue & do nothing
			System.out.println("can't fill text to element: " + el + " because it is NOT of type: input");
		}
		sleep(500); // added sleep so it looks as if an operation was made on the element (to slow the test-steps a bit) !!!
		// TODO -> Make sure to mark-out the highlight & related sleep if not working in a DEMO mode !!
	}
	/** COMMENT about the ^ above fillText method:
	but, the same could also be a bit less complex -> for example, this shorter version:
	public void fillText(WebElement el, String text) { // (el must be located as input only)
		el.clear(); // can use also 'clear' as a local method (see statement above): clear(el) 
		el.sendKeys(text); }  // can use also 'sendKeys' as a local method (see statement above): sendKeys(el, text); 
		
		// before creating BasePage, LoginPage had ->
		driver.findElement(By.cssSelector("#user-name")).clear(); // user field clear any previous value (to be sure its empty)
		driver.findElement(By.cssSelector("#user-name")).sendKeys(user); // insert user (from method input) into field
		// after creating BasePage, LoginPage now have ->
		fillText(driver.findElement(By.cssSelector("#user-name")), user); // uses fillText: combined .clear() + .sendKeys(text)
	*/
	// returns a Select object -> TODO - check what does ??
	public Select select(WebElement el) { // el = selection
		Select select = new Select(el);
		// 
		return select;
	}	
	//	select by value (mimic clicking on an option form a select dropdown)
	public void selectByValue(WebElement el, String value) { // method gets WebElement='el' -&- do Submit (click 'enter' upon fill form)
		Select s = new Select(el);
		s.selectByValue(value);
	}
	// TODO -> add more Selects below -> By index \ test...

	

	/* TODO - REMOVE !!!
	// selectSortOptions.selectByIndex(2); // Index: 2 (3ed one)
	// selectSortOptions.selectByValue("lohi"); // Value: "lohi"
	// selectSortOptions.selectByVisibleText("Price (low to high)"); // Text: "Price (low to high)"

	 * 
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
	/** -----------------
		is... operations: isDisplayed() / isEnabled() / isSelected() methods of Selenium
	 	================*/
	//	isDisplayed checks if element is on screen - combined with validation (try-catch) --> see several possible ways to do it, below:
	/**	this way, uses WebElement input, but having no validation and returning non (so its not so good -and- must not be used):
		public void isDisplayed(WebElement el) { // the method gets WebElement & perform isDisplayed upon it (checking if its on screen)
		el.isDisplayed();    // this actually don't help at all, because it only checking, but is not returning any answer to make use |
	 */
	// this is the preferred way (using WebElement as input)
	public boolean isDisplayed(WebElement el) { // method gets WebElement & let know if it is currently displayed (returns boolean: T\F)
		try {
			return el.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException exception) {
			return false;
		}
	}
	//	do as above, and also have same name, BUT it is NOT the same because it gets a locator of element (instead of the WebElement)...
	//	uses the 'find(by)' method (stated above -> first) with a locator [e.g. 'By.cssSelector("#username")'] to locate the WebElement!
	public boolean isDisplayed(By locator) { // method gets el-locator & let know if el is currently Enabled on page (returns b T\F)
		try {
			return find(locator).isDisplayed();
		// upon Element is not found (exception) -> return false...
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException exception) {
			return false;
		}
	}
	// this is a way to check Element is Absent = NOT Displayed (using WebElement as input) - Opposite to isDisplaye(el)...
	public boolean isAbsent(WebElement el) { // method gets WebElement & let know if it is NOT displayed (returns boolean: T\F)
		try {
			if (el.isDisplayed()) { // upon Element Displayed (thus meaning, it is NOT Absent from Page) -> return false...
				return false;
			} 
		} catch(Exception e) { // upon Element Not found exception (meaning, element IS Absent from Page) -> return true...
			return true;
		}
		return true; // neither conditions met, return true!
	}
/** === old code TODO -> Clean !
		try {
			el.isDisplayed();
			return false;
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			return true;
		} catch (org.openqa.selenium.StaleElementReferenceException exception) {
			return true;
		} catch (Exception e) {
			return true;
		}
=====*/
	//	isEnabled (as above) combined with validation
	public boolean isEnabled(WebElement el) { // method gets WebElement & let know if it is currently Enabled, on page (returns boolean)
		try {
			return el.isEnabled();
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			return false;
		}
	}
	//	isSelected (as above - will work only for elements of type which can be selected - can add: if (el.getTagName().contains("????")
	public boolean isSelected(WebElement el) { // method gets WebElement and let know if it is currently Selected (returns boolean: T/F)
		// add if -> check its the proper tag (often used on radio buttons, checkboxes or options in a menu
		try {
			return el.isSelected(); // determines if element is selected? (if the specified element is selected, the value returned = T)
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			return false;
		}
	}
	// implement boolean function, to validate elements' text-field is empty! This is used in get... -> NOTE: the attribute must exist!!
	public boolean isTextFieldEmpty(WebElement el) { // NOTE: element must be of type 'input' & we will get the value 'value' attribute!
		// using getAttribute with: WebElement & "attributeName" to retrieve the given attribute value (our case attributeName = value)!
		// String FieldValue = getAttribute(el,"value"); // return text (string) of this input 'value' attribute --> getAttribute below!
		// if (FieldValue == "") { // can use This or as below in one-line & isEmpty -> Same-Same !!!
		if (getAttribute(el,"value").isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	/*	NOTE: isClickable  is actually NOT Supported !  ->  it is a state that wait (below) checks  ->  But it might be wrapped somehow:
	//	A General way to Wait for Click-ability of element before clicking it:
		WebElement xxx = driver.findElement(By.cssSelector("#x"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(xxx));
		xxx.click();
	// A General way to check Click-ability -> Check if(xxx.isDisplayed() && xxx.isEnabled())  -->  Not sure it is worth it !!!
	*/
	/** -----------------
		get... operations:
	 	=================*/
	//	getText - implement wrapping of that function
	public String getText(WebElement el) { // the method gets element='el' -and- retrieve its' Text
		waitForElementVisibility(el); // wait till element is visible on screen!
		highlightElement(el, "pink");  // if you want a color differentiator ...
		return el.getText(); // get the Text of element
	}
	//	getTagName
	public String getTagName(WebElement el) { // the method gets element='el' -and- retrieve its' Tag Type Name (e.g. "input")
		return el.getTagName();
	}
	//	getAttribute - method gets 2 params: WebElement='el' & string='attribute', and retrieves given attributes value, of that element
	//	e.g. el.getAttribute("id"); will return the 'id' of the element as string -> IMPORTANT NOTE: the attribute must exist, unless...
	public String getAttribute(WebElement el, String attribute) {
		return el.getAttribute(attribute); // retrieves attributes' value
	}
	// implement a function, to get the text-field entered text (if any) ! -> NOTE: the attribute must exist!!
	public String getTextFieldValue(WebElement el) { // element must be of type 'input' & we will get the value attribute
		if (el.isDisplayed() && el.getTagName().contains("input")) { // if the element exists on page -and- is of tag type: input
			if (isTextFieldEmpty(el)) {
				return "" ;
			} else {
				return getAttribute(el,"value"); // attributeName="value" to retrieve the given text-value of this value Attribute!
			}
		}
		else { // if by any chance, the given element is NOT a type 'input' - print the issue & do nothing
			return "can't fetch relevant data from element: ";
		}
	}
	//	getCurrentUrl  (a browser related capability not needing inputs)
	public String getCurrentUrl() { // the method retrieve the page URL
		return driver.getCurrentUrl();
	}
	//	verify if page url 'is as expected' (a 2ed layer over the above adding strength to code)...
	public boolean doesUrlInclude(String str) {
		if (getCurrentUrl().toLowerCase().contains(str)) {
			return true;
		} else {
			return false;
		}
	}
	//	return page source (as above)
	public String getPageSource() { // the method retrieve the page Source
		return driver.getPageSource();
	}	
	//	return page title (as above)
	public String getPageTitle() { // the method retrieve the page Title
		return driver.getTitle(); // or using: String title = driver.getTitle(); return title;
	}
	//	verify if page title 'is as expected' (a 2ed layer over the above adding strength to code)...
	public boolean verifyPageTitle(String expectedPageTitle) {
		return getPageTitle().equalsIgnoreCase(expectedPageTitle);
		// we can add 'IF' and check that upon NOT match exactly (regardless of case-sensitivity) may be use .contains - for partial of!
	}
	/** ----------------------------------------------------------------------------------------------------------
		browser navigate... -and also- operate within alert (pop-ups) -&- frames ... methods on driver operations:
	 	=========================================================================================================*/
	//	browsing to a given URL page (or use the below: navigate to url - which do the same)
		public void visit(String url) { // the method gets String="url" -and- open it on the browser
		driver.get(url); // driver.get(url) -> does not maintain the browser history and cookies, and don't wait till page fully loaded.
	}
	/** NOTE: driver.navigate.to(url) is used to go to particular web page.
		maintain browser history + cookies, doesn't wait till page fully loaded, have navigation between pages (back, forward & refresh)
	 */
	//	navigate to url -> this is similar to: driver.get(url); ( url="http://www.google.com" ) -> see stated above & doing the same !!!
	public void navigateTo(String url) { // the method gets String="url", and do browser navigation to the url
		driver.navigate().to(url);
	}
	//	navigate back (to prev-page)
	public void navigateBack() { // the method do browser navigation back to the previous page
		driver.navigate().back();
	}	
	//	navigate forward
	public void navigateForward() { // the method do browser navigation forward to the following page
		driver.navigate().forward();
	}	
	//	navigate refresh (page)
	public void navigateRefresh() { // the method do browser refresh on current page
		driver.navigate().refresh();
	}	
	//	navigate handle (single)
	public void navigateToHandle() { // the method do...
		driver.getWindowHandle();
	}
	//get main Window Handle...
	public String mainWindow() {
		return driver.getWindowHandle();
	}
	//	navigate handles (plural)
	public void navigateToHandles() { // the method do...
		driver.getWindowHandles();
	}
	//	get a Set of all Window Handles...
	public Set<String> handleWindows() {
		return driver.getWindowHandles();
	}
/*	TODO -> Sort & Add !!!
	----------------------
	 	public void switchToWindow(String windowName) {
			driver.switchTo().window(windowName);
		}
		public void switchToFrame(WebElement el) { // el = frame
			driver.switchTo().frame(el);
		}
		public void switchBackFromFrame() { // back to the main HTML page (the default one)
			driver.switchTo().defaultContent();
		}	
	 */
/*	working with Alert pop-ups https://www.guru99.com/alert-popup-handling-selenium.html -> TODO: capabilities to handle Alerts & Frames
	to learn on alert-types -> https://www.w3schools.com/js/js_popup.asp
	- window.alert()	- Alert-text only + OK button
	- window.confirm()	- Alert-text + Cancel & OK buttons
	- window.prompt()	- Alert-text + Input-field + Cancel & OK buttons
	
	public void handleAlertDo(String text) {   // need several methods to deal with actions needed !!!
	driver.switchTo().alert().getText();  // if needed for verification
	driver.switchTo().alert().dismiss(); // to click on Cancel
	driver.switchTo().alert().accept(); // to click on OK
	driver.switchTo().alert().sendKeys(text); // if any input is needed
	}
*/
	//	do alert accept - click on OK
	public void alertOK() {
		waitForAlert(); // this wait for alert to be present is stated below...
		driver.switchTo().alert().accept();
	}
	//	do...	
	public void alertCancel() {
		driver.switchTo().alert().dismiss();
	}
	//	do...	
	public void alertFillTextSubmitOK(String text) { // here we can use 'Overloading', and thus call this method alertOK (same as above)
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	/** -------------------------------------
		wait... capabilities implementations: 
 		====================================*/
	//	implement a generic sleep, BUT DO NOT USSE !!!  ->  Better to use Wait-Till-Element !
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// TODO - Add implicit wait -> driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) or as below:
    //	OR a General Wait (like sleep) -> to be used if needed...: wait(timeoutMillis);

	/**	implement a generic Wait-Till-Element  ->  See More Below !
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		public void doWaitTillSomething(---) {
		// TODO -> should have a logic to wait
		}
		NOTE that, regarding: 'is element' validation methods: presence/ visible/ clickable (done with-in many methods of Page classes)-
		best practice is to implement following 'explicit' wait methods, on relevant elements, with-in each relevant Page method - thus,
		it will be used seamlessly during test runs & failures minimized !!!
	 */
    //	A General Wait Till a WebElement (el) is Visible (seen on page) -> to be used in following methods / asserts...
    public void waitForElementVisibility (WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
    }
    //	Wait till Visible (wrapper method using the By) to be used in following methods as well...
    public void waitVisibility (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //	Wait till Visible (wrapper method using the List) to be used in following methods as well... (gal recommended not to use)!
	public void waitForListBeSeen(List<WebElement> list) {
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
	//	A General Wait Till a WebElement (el) is NOT Visible (not seen on page)
	public void waitForInvisibility(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}
	//	A General Wait Till a WebElement (el) is BOTH Visible & Clickable = To Be Clickable !
	public void waitForElementClickability(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
    //	Click Method
    public void clickVisible (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    //	Write Text
    public void inputToVisible (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }
    //	Read Text
    public String readFromVisible (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
	/*	till Clickable...
		wait until condition for element to be clickable is met (max 5 seconds, as stated above - in constructor)
		defined expectation by checking that an element is visible and enabled, so that you can click it */
	public WebElement waitTillElementClickable(String css) { // method gets string=css (element Locator) & return el when condition met!
		// WebElement condition is implementing - explicit wait till element located - is clickable.
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
		// WebElement el = (new WebDriverWait(driver,5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(<el.Loc>)));
		return el;
	}
	/*	till Visible...
	 	wait until condition for visibility of element located is met (max 5 seconds, as stated above - in constructor)
		defined expectation by checking that an element is present on the DOM of a page and is visible on screen */
	public WebElement waitTillElementVisible(String css) { // method gets string=css (element Locator) & return el when condition met  !
		// WebElement condition is implementing - explicit wait till element located - is visible.
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
		// WebElement el = (new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(<el.Loc>)));
		return el;
	}
	/*	till Present...
		wait until condition for presence [enabled \disabled] of element located is met (max 5 seconds, as stated above, in constructor)
		defined expectation by checking that an element is present on page DOM (use this condition for checking for: Hidden Elements) */
	public WebElement waitTillElementPresent(String css) { // method gets string=css (element Locator) & return el when condition met!
		// WebElement condition is implementing - explicit wait till element located - is present.
		WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
		// WebElement el = (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(<el.Loc>))); -
		return el;
	}
	// wait for alert to be present
	public void waitForAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/** ---------------------------------------------
		implementation of mouse actions, scroll etc.:
 		============================================*/
	/*
		//	move mouse to a given element... (this is hoe to use if the Actions were not already initiated in construction)...
			public void moveToElement(WebElement el) {
				Actions actions = new Actions(driver);
				actions.moveToElement(el).perform();
			}
	 */
	//	implement HOVER (mouse-over WebElement) to enable seeing stuff which is visible only upon hovering over element:
	public void moveTo(WebElement el) {
		waitForElementVisibility(el); // this method is stated above...
		actions.moveToElement(el).build().perform();
		highlightElement(el, "Tomato");
	}
	/*	TODO -> Add MORE: actions.contextClick(target) = RightClick (etc.)
		working with mouse: https://www.tabnine.com/code/java/methods/org.openqa.selenium.interactions.Actions/moveToElement  [- TODO -]
		https://www.guru99.com/keyboard-mouse-events-files-webdriver.html    [ TODO need to add more mouse operations according to need]
		https://www.tabnine.com/code/java/classes/org.openqa.selenium.interactions.Actions
		add acts: perform, build, click, doubleClick, clickAndHold, release, dragAndDrop, dragAndDropBy, keyDown, keyUp, moveByOffset...
	
		//	drag and drop elements --> For Example !
			public void dragAndDrop(WebElement el, WebElement dropZone) {
				Actions actions = new Actions(driver);
				actions.dragAndDrop(el, dropZone).perform();
			}
	*/
	//implement Drag & Drop element to element
	public void dragAndDrop(WebElement el, WebElement dropZone) {
		waitForElementVisibility(el);
		waitForElementVisibility(dropZone);
		actions.dragAndDrop(el, dropZone).perform();
	}
	//	implement Scroll to element...
	public void scrollTo(WebElement el) { // scroll to element
		actions.moveToElement(el);
		/*	TODO Remove old...
		  	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();", element);
		 */
	}
	//	implement Scroll down by number of px...
	public void scrollDown(int num) { // Scroll down on page by number of pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,num)");
		// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + X + ")"); // TODO Remove old...
	}

/* Slider ACTION: TODO -> Add !!!
	public void moveSlider(WebElement element, int x, int y) {
        WebElement Slider = element;
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(Slider, x, y).build();
        action.perform();
	}
*/
	
	/** ------------------------------------
		implementation of more capabilities:
		===================================*/
	// implement Assert + Highlight -> a boolean function validating a 'given' expected text is proper as actual text of the WebElement!
	/** public void assertElementText (By elementBy, String expectedText) {
    	waitVisibility(elementBy);
    	// String foundText = readFromVisible(elementBy);
		// Assert.assertEquals(foundText, expectedText);
		Assert.assertEquals(readText(elementBy), expectedText);
    }*/
    public void assertElementText (WebElement el, String expectedText) { // input: a WebElement -and- the expectedText it should have !!
		waitForElementVisibility(el); // use wait method (above)
		highlightElement(el, "red"); // use highlightElement method (above), and while asserting Element, its highlighted color is red !
    	String foundElementText = getText(el); // get the actual current text of the tested & highlight WebElement (for the comparison)!
		Assert.assertEquals(foundElementText.toLowerCase(), expectedText.toLowerCase()); // Asserting found ElementText Equal Expected !
    } // result of this General Assertion comparison done while Testing (usage from Page) will determine if Test-Case Passed or Failed !

    /** NEW: implement Assert to check proper URL -> validating that the current Browser URL correlates to 'given' expected text of URL!
   		Making use of the above boolean 'doesUrlInclude' method (can be change to equal exact URL if wanted). TODO -> Remove Redundant !
   		// verify if page url 'is as expected' (see above ^)...
		public boolean doesUrlInclude(String subStr) { // input: partial sub-String of expected URL
			if (getCurrentUrl().toLowerCase().contains(subStr)) { // checks current-page URL contain expected...
				// System.out.println("subStr exist in url");
				return true;
			} else {
				// System.out.println("subStr don't exist in url");
				return false;
			}
		}	
     */
	// implement a validation function to check the condition that Current Page Url is as Expected = contains a given sub-String of URL!
	@Step("Asserting Current Url is as Expected")
	public void assertCurrentUrl(String expected) { // input: expected sub-String of URL & check if page URL contains it (can use full)!
		sleep(500);; // general sleep of 1/2 sec.
		// String actualURL = getCurrentUrl().toLowerCase();
		// Assert.assertEquals(actualURL, expected.toLowerCase()); // change any string to lower case! -> Thats if you check full URL !!
		assertTrue(doesUrlInclude(expected), "URL does Not include expected sub-String");
	}

	//	TODO -> Add MORE Assert implementations...
	/** extra:
		x
	*/
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~

https://www.swtestacademy.com/page-object-model-java/ -> Example:
-----------------------------------------------------------------
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }
    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }
    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }
}
=================================================================

// Using VAR: var can be used in a local variable declaration instead of the variable's type- Once created, this type cannot be changed.
        var x = 100; // int
        var y = 1.90; // double
        var z = 'a'; // char
        var p = "Elad"; // string
        var q = false; // boolean
_______________
PAUSE run time:
Some times, it takes elements time to be fully loaded in DOM (sometimes they're hidden -or- not displayed on screen):
Later on we will see how to deal with it...
1. Sleep causes current thread to suspend execution for a specified period (it's not-recommended for being wasteful)!
Thread.sleep(1000); // needs wrapping of thrown exceptions
2. general implicitlyWait()
This is used to specify amount of time driver should wait, while search for element if it is not immediately present.
When searching for a particular single element, the driver should pause page loading till the element has been found!
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
3. Specific Wait for a condition to be compliment on a specific element
Rather than waiting for specified time duration (called Implicit Wait), This wait is performed on certain condition -
An explicit wait (for a maximum time) can be performed till a 'certain condition' (e.g. till Element visible) is met!
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Needed declaring the Object!
wait.until(ExpectedConditions.elementToBeClickable(By.id("userName"))); // There are several options...



*/
