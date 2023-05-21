package tempSite.testcases; // Reference to e_selenium.demo.T ... (and prior phase: d_ ->  before adding  'Data Driven Testing' ) !!!
/**		Important NOTE: TODO - Delete & Remove this note !!!
		This BaseTest Class implements 2 new issues:
		1. Maven- WebDriverManager -> to reduce the need for downloading the Browser Driver
		2. ChromeOptions to fix a problem that happen with Latest Chrome Version...
 		------------------------------------------------------------------------------------------------------------------------------*/

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions; // No longer needed - TODO - Delete & Clean all !!!
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import tempSite.utilities.ConfPropertiesUtil;
import tempSite.utilities.ReportAttachmentsUtil;

public class BaseTest { // NOTE that You don't need Main method for running TestNG cases -> BUT you will need to  RUN them as TestNG !!!
	// this class wraps the common code for each Test (generally used), to be used by all test-classes that extends it (inherit from it)
	
	WebDriver driver; // declare the driver out-side of classes (global) so it will relate to all Tests (init during first case only) !!
	
////Fix Chrome issue - TODO -> Revert & Delete  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
////ChromeOptions options; // see section below !!! No longer relevant after fix...

	
	// if you want to use varied browsers in your tests - you can pass them on, as @Parameters -> see "Notes" bellow...
	// @Parameters annotation states which parameter testng.xml passes for RUN:
	@Parameters({"browser"}) // take a dynamic param from testNG.xml (via RUN by MVN) - needs: import org.testng.annotations.Parameters;
	// @Parameters({"baseUrl"}) // Value Taken from param in: testng.xml and, is used in allure report for environment variable display!
	// NO NEED for the above baseUrl because we also have it in properties file !!!  <-----------------------------------| TODO DELETE !
	@BeforeClass // will occur at the beginning of class (not before-each test) -> Note we changed driver.get to use DDT |
	@Step("Start Test Run: Choose Browser, Maximize & Browse to the log-in page") // Allure annotation to describe step taken by method!
	public void setUp(@Optional("Chrome") String browser, ITestContext testContext) {
	// in method above - browser = @parameter of RUN if no param passed, use chrome as default !!! 
	// NOTE that, there should be exact correlation of all 3: Params in TestNG file, @Parameters stated & the Arguments (within Method)!
		System.out.println("--- START ---"); // TODO -> REMOVE not needed redundant prints !!!
		
/**		All lines below are parts of process convention to new MVN + Chrome etc -- TODO -- Clean it & keep only the End!
		================================================================================================================
		*/
////	NOTE: When using WebDriverManager you don't need to Download the Browser --> SO, this property setting below is redundant !!!!!!
		// System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe"); // properties for chrome-driver !
////	driver = new ChromeDriver(); // WebDriver driver was declared above, here we init the driver
		/** IF you Failed on Response code 500 Message: session not created: This version of ChromeDriver only supports Chrome version :
			The Browser (updated) No Longer Supported --> Do as described: /SeleniumProject/project-info/_info1_General-Auto-Code.txt */
////	driver.manage().window().maximize(); // set to be working in 'full screen'! NOT WORKING in Latest Chrome - TODO revert upon Fix!
		// driver.get("https://www.saucedemo.com"); // this way to browse, is used when not having 'config.properties' > | 
		/**	we want to always start by browsing to a url (the line below, was the orig -> before using config.properties):
			driver.get("https://www.saucedemo.com"); // the step can be set aside,   entered input during test (if wanted)
			changed: getting the URL String value, using dedicated Util (fetching it from a configuration Properties file)
			Utils u = new Utils(); // creating the object of Utils class - this was needed before turning Utils to static!
			reading the url value from properties file & setting it into the relevant place in code: u.readProperty("url")
			driver.get(u.readProperty("url")); // thats how we use it after create instance  (before turn class to static)
			below is the usage after turning Util to static = need no instance create -&- method can be accessed directly!
		*/
		// Below is how we are doing it Using WebDriverManager !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
///////	WebDriverManager.chromedriver().setup(); /////// the 3 lines bellow are needed & where inserted to the Browser switch condition!
///////	driver = new ChromeDriver(); // was un-commented (ChromeOptions is no longer need, for temp Chrome issue - Fixed after Update) !
///////	driver.manage().window().maximize(); // set to be working in 'full screen'! --> also un-commented, after Chrome issue Fixed... !
		// See in Log, Driver now Resides in:  Exporting webdriver.chrome.driver as C:\Users\USER\.cache\selenium\chromedriver\win32\...
		// driver = WebDriverManager.chromedriver().create(); // can replace in some cases both above  -&-  driver = new ChromeDriver();
////	Below, adding ChromeOptions, come to fix a problem with latest Chrome - TODO --> Switch back if possible !!! ------------------|
		// this actually come to replace:  driver = new ChromeDriver();   -&-   driver.manage().window().maximize();
/* Added code-block for using Chrome Options:
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
*/// TODO --> Remove after Switch back when ChromeOptions is no longer need !!! -------------------------------------------------------|
		
		/* switch case code below, comes to support multi-browsers selection-during-run-options
		   getting a Parameter (passed by TestNG) to determine which Browser you wish to Run on
		   accordingly the relevant browser's driver is declared & initiated !!!
		 */
		switch (browser){ // again, the browser = @parameter of RUN passed into method as a variable
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		/** case "explorer":
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions capabilities = new InternetExplorerOptions();
            capabilities.ignoreZoomSettings();
            driver = new InternetExplorerDriver(capabilities);
            break; */
		default: throw new IllegalArgumentException("no such browser " + browser);
		}
		driver.manage().window().maximize(); // set to be working in 'full screen' to open browser at max size
		// browse to web-page = driver.get(url);
		// driver = WebDriverManager.chromedriver().create(); // done above as: .setup()
		testContext.setAttribute("WebDriver", this.driver);  //  This Context is needed for taking Print-Screens <-------------- NEW !!!
		String baseUrl = ConfPropertiesUtil.readProperty("url");
		driver.get(baseUrl); // could also be taken from TestNG param - this step could be removed  -and-  set this input at test level!
		// driver.navigate().refresh(); // TODO - see if must <-----
		// ALLURE Report related - add browserType & baseUrl (can add more- taken dynamically) to Allure report - Overview ENVIRONMENT !
		allureEnvironmentWriter(ImmutableMap.<String, String>builder() //
                        .put("Browser", browser)
                        .put("URL", baseUrl)
                        .build());
	}
	
	/* Take Screenshot of Failure-state - will run after each Method (test-case) --> NEEDS importing some jars to project:
	   this method will run after a test-case, and it will take a screen shot at the last moment of any test that failed !
	   for better implementation, do Highlight of elements you use for validation ( see BasePage -> highlightElement )
	   some need import from TestNGת But working with 'FileUtils' needs import of 'Commons IO' dir in-to your project.
	   take binaries zip from https://commons.apache.org/proper/commons-io/download_io.cgi (extract to C:\automation\libs)
	   rightClick Project > Properties > Java Build Path > Classpath > Add External Jars (from dir+ select+ Open) > Apply!
	   
	   NOTE:
	   There is another way to take a screenshot upon Test-Failure -and- attach it to Allure Report - see in: _info6_Allure.txt & Utils!
	 */
	@AfterMethod
	@Step("IF Test Runner gets a Failed Test - Failure URL would be attached to Allure & Failure Screenshot will be Collected & Stored")
	/**	I've recently added another different capability of taking screenshots upon Failure (detected by listener) & Attaching to Allure
		This new Util, makes the @AfterMethod redundant (but I kept it as capability show-off)...  TODO  <---------------|  DELETE !  */
	public void failedTest(ITestResult result) { // This method will get the TestNG object holding tests results
	  //check if the test failed, and do (several things) |--> NOTE - also see:  saucedemo.utilities.ListenersUtil -> onTestFailure(...)
		if (result.getStatus() == ITestResult.FAILURE ){
			// use the Util to attach the current URL during failure to the Allure report:
			ReportAttachmentsUtil.attachURL(driver.getCurrentUrl()); // driver.getCurrentUrl() = The Current Failure URL
			// take a Screenshot into memory & save it to a defined location (relative path) -> NOTE  dealt also via: onTestFailure(...)
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./test-screenshots/" + result.getName() + ".png")); // changed after Maven
				// result.getName() method will give you current test case name
				//./test-screenshots/ states that under current directory path (.dot represents current dir), create folder ScreenShots!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // NOTE: if the Test Fail -> to PS you need to refresh the Project !!!

	@AfterClass // will occur after class (not after-each test)
	@Step("After all Tests in class Ended - Test Runner Closes the browser")
	public void tearDown() { // after finish all tests - close the resource!
		driver.quit();
		// System.out.println("\n--- END ---"); // TODO -> REMOVE not needed redundant prints !!!
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~

//	From another Project made by student:
	@BeforeClass
	public void setup(ITestContext testContext) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		testContext.setAttribute("WebDriver", this.driver);
		driver.get(ReadDataFile.readDataFile("url"));

	}
	=============================================================
	public class BaseTest { // another example

	WebDriver driver;

	@Parameters({ "debug" }) // if run parameter is debug - will open local browser, else will run docker
	@BeforeClass(description = "initializing driver and navigating to tested site url")
	public void setup(ITestContext testContext, boolean debug) throws MalformedURLException {
		// in case debug is set to true - perform a regular selenium automation
		if (debug) {
			createDriver(Configuration.readProperty("browserType"));
		} else { // otherwise, perform automation with remote driver in a docker
			createRemoteDriver(Configuration.readProperty("browserType"));
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		testContext.setAttribute("WebDriver", this.driver);
		driver.get(Configuration.readProperty("TestedSiteUrl"));
	}

	@AfterClass(description = "closing driver")
	public void tearDown() {
		driver.quit();
	}

	// method that handles driver type according to the required browser string
	private void createDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:// open Chrome browser by default in case no string matched
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}

	// method that handles remote driver type according to the required browser
	// string
	private void createRemoteDriver(String browser) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (browser) {
		case "chrome":
			capabilities.setBrowserName("chrome");
			capabilities.setVersion("85.0");
			break;
		case "firefox":
			capabilities.setBrowserName("firefox");
			capabilities.setVersion("79.0");
			break;
		default: // open use Chrome by default in case no string matched
			capabilities.setBrowserName("chrome");
			capabilities.setVersion("85.0");
			break;
		}
		capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
		capabilities.setCapability("videoName", this.getClass().getName() + "_"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")));
		capabilities.setCapability("screenResolution", "1280x1024x24");
		driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
	}
	=============================================================

https://www.swtestacademy.com/page-object-model-java/ -> Example:
-----------------------------------------------------------------
package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseTest {
    public WebDriver driver;
    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
    }
    @AfterClass
    public void teardown () {
        driver.quit();
    }
}
=================================================================

Order of action we would do to INSTALL:
To work with it, you need to download & install (selection: https://testng.org/testng-eclipse-update-site) ->
Following step by step -> installing TestNG in Eclipse: https://www.guru99.com/install-testng-in-eclipse.html
	1) Open Eclipse Help > Eclipse Marketplace...  ->  https://marketplace.eclipse.org/content/testng-eclipse
	2) Search - Find "TestNG" >
	3) TestNG for Eclipse ----> Install (relevant components) + Accept the license agreement...
	4) Wait for installation... Ignore security warning if occurs = Install anyway!
	5) Needs RESTART of eclipse!
Then: Restart, verify if TestNG for Eclipse was indeed successfully installed  (Click Window > Show View > Other).
Also: Window > Preferences > TestNG...

More -> https://www.guru99.com/all-about-testng-and-selenium.html

ABOUT:
	Now, instead of running tests from main, you can run them from TestNG using @Test
	Add @Test above the method you want to test (remove the main) public void tc_01_Login(){
	and you will be asked to add Library of TestNG to Project + also to do: import org.testng.annotations.Test;
	When Running - choose "Run as TestNG" !
NOTE:		
	@Test Must be at least one in a class and can get more attributes:
	@Test (Priority = 0)  if needed, use Priority to set Running Order, otherwise Default Priority is by methodName in alphabetic order!
	@Test (enabled=false) will disabling a test
	@Test (dependsOnMethods={“login"}) -> for dependency of a Test on the execution of another...
	More: @Before \ @After --> @BeforeSuite \ @AfterSuite | Test | Groups | Class | Method (each case states what to do & when to do) !!
ASSERTING: Assert is done & used within Test Classes (and if needed condition, it must be well stated as a Page Method)
	Test Component can use the Assert method capabilities -> 
	Assertions in TestNG are a way to verify that the expected result and the actual result matched or not.
	If we could decide the outcome on different small methods using assertions in our test case -->
	We can determine whether our test failed or passed overall.  --->  See below the two main Asserting types (there some more though) :
		~ assertEquals:
		  Assert.assertEquals(actual, expected); // check if 2 vars match, by comparing the actual & expected (for string, int & other).
		  This validation is used for comparing expected and actual values in the selenium.
  		  The assertion passes with no exception whenever the expected and actual values are same.
  		  But, if actual and expected values are not same - assert fails with exception & test is marked as failed!
  		  What is assertTrue in TestNG?
		~ assertTrue:
		  Assert.assertTrue(condition); // checks if something ended properly (mainly boolean method stated in the relevant Page class)!
		  This method asserts if the condition is true or not. If not, then the exception error is thrown.
  		  Assert.assertTrue(condition, message) : Similar to the previous method with an addition of message,
  		  which is shown on the console when the assertion fails along with the exception.
		~ assertThat:
		  the only assertion in JUnit 4, that has a reverse order of the parameters compared to other asserts.
  		  In this case, the assertion has an optional failure message, the actual value, and a Matcher object.
  	NOTE: IF any Assert Fail a Test, you can see the 'cause of failure' in the TestNG tab (if for example the Strings don't Match etc.)!
  	NOTE: For Hard vs. Soft Assertions in test automation -> See bellow!
_________________________
Hard vs. Soft Assertions:
One of the rules of good test automation is to write small fast atomic tests.
In other words, small tests, that execute only one test case. And usually, one test case should have only one verification.
However, the exception is when we make a few verifications without additional test steps in between verifications -and-
The verifications should'nt & do NOT depend on each other (assertions could be executed in any order  1,2,3 -or- 3,2,1)
But you want to do them all (even if one fails) - In order to execute all three verifications without failing test during -
We can use soft assertions instead of hard assertions.

For HowTo, See -> https://practicetestautomation.com/hard-and-soft-assertions/

Example:
driver.get("https://practicetestautomation.com/practice-test-login/"); // browse to web page
// functional operations
driver.findElement(By.id("username")).sendKeys("student");
driver.findElement(By.name("password")).sendKeys("Password123");
driver.findElement(By.cssSelector("button#submit").click();

// 3 consecutive (non-dependent) soft asserts:
SoftAssert softAssert = new SoftAssert(); // declare & initiate the assert

String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
String actualUrl = driver.getCurrentUrl();
softAssert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected"); // compare URL

WebElement successMessage = driver.findElement(By.tagName("strong"));
String expectedMessage = "Congratulations. You successfully logged in!";
String actualMessage = successMessage.getText(); // compare MSG
softAssert.assertTrue(actualMessage.contains(expectedMessage), "Actual: "+ actualMessage +" don't contain Expected: "+ expectedMessage);

WebElement logOutButton = driver.findElement(By.linkText("Log out"));
softAssert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible"); // check viability

softAssert.assertAll(); // ask to actually assert them
_________________
Using Properties:
for using an external file, for dynamic value setting of code variables
add under separated "data" package your 'configuration.properties' file
the file must end with type '.properties' and contain key= value pares:

to read from file to code, you need a util added in a separated package
the utility is another java class that fetch the value of a given key !
--> See in relevant packages...

*/
