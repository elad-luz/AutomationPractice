package tempSite.testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import tempSite.pageobjects.LoginPage;
import tempSite.pageobjects.ProductsInventoryPage;
import tempSite.utilities.ConfPropertiesUtil;
import tempSite.utilities.ExcelTabsUtil;
import tempSite.utilities.ReportAttachmentsUtil;

@Owner("Class owner: Elad Luz") // relevant to All Tests in Class

public class S01_LoginTests  extends BaseTest{ // S1 stands for: 'Section 1' in TestPlan -> Note: tc01 should Fail 1 case intentionally!

// Test-Cases from Section 1 in the Test-Plan (file's located at: /SeleniumProject/project-info/test-planning.txt)
	/** Regarding Annotations (of both TestNG & Allure:                TODO -> Delete !!!
		@Owner("the owner") -> Relevant to All Tests in Class  -or-  per Test Specific...
		@Test(description = "D name") -> Mapped to Allure report TestCase Headline (name)
		@Description("D texts") -> Mapped to Allure report TestCase Description (textual)
		@Severity(SeverityLevel.LEVEL) -> Allure defines four levels of severity of failures!
		@Epic("Shopping Cart") -> Allure integration with Jira 1
		@Feature("Add To Cart") -> Allure integration with Jira 2
		@Story("As a User when I add item to Cart than cancel the item should be deleted") -> Allure integration with Jira 3
		@Link(name = "automation.co.il", url = "http://automation.co.il/") -> Allure Report link to ANY...
		// both bellow @ (Tms & Issues) take the link pattern from properties in:  /src/test/resources/saucedemo/allure.properties ...
		@TmsLinks({@TmsLink("550")}) // @TmsLinks({@TmsLink("550"),@TmsLink("800")}) -> Allure Report link to TestCase (e.g. JIRA #id)
		@Issues({@Issue("50")}) // @Issues({@Issue("50"),@Issue("58")}) -> Allure Report link to Issue-Bug (e.g. JIRA #id)
		// https://selenium.teachable.com/courses/562412/lectures/10321550 -> Environment Variables inserted to Allure Report...
		@Parameters({"baseUrl"}) // Value Taken from param : testng.xml  and, is used in allure report for environment variable display!
		Can add stuff (e.g. to BaseTest) & print as Env. info in Allure
		// import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
		// import com.google.common.collect.ImmutableMap;
		allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("URL", baseUrl).build()); // insert baseUrl to Allure report!
	 */
	
	@Owner("Test owner: Elad Luz") // relevant to a Specific Test in Class -&- overrides the "Class owner: Elad Luz"  (set previously) !
	@Test (priority= 0, description= "Login GUI Elements Exist") // the description of TestNG is condensed -&- bellow Allure is longer !
	@Description("Smoke-Test = Checking that Login-page is Accessible - and Contains all the expected UI-elements") // @Allure Reports !
	@Severity(SeverityLevel.CRITICAL) // @Allure Reports
	@Epic("Login Page") // @Allure Jira integration
	@Feature("GUI display") // @Allure Jira integration
	@Story("Upon opening Login Page, the Graphic User Interface Elements should be displayed as designed") // @Allure Jira integration !
	
	public void tc00_LoginElementsExist() throws InterruptedException { // tc00 stands for TestCase with id (00 stands for precondition)
		LoginPage lp = new LoginPage(driver);
		// using assertTrue + isMethod (not an Assert as a stand-alone method from the page)
		// the message of Assert would be inserted as attachment to Allure Report (using relevant Util):
		// ReportsUtil.attachText("Add here the text you want"); // needs import Util (in Project), for add text attachments to Allure !
		// Note: the text can be anything from a comment to Exception -&- come to replace any out-print you wish to present in the log !
		// assertTrue(lp.isProperUI(), ReportsUtil.attachText("UI don't displayed all expected elements properly !"));
		// below is showing the assertFailureMessage, which would be gathered & printed in Logs & Report - but not as attachment... see:
		assertTrue(lp.isProperUI(), "UI don't displayed all expected elements properly !"); // isProperUI() - checks all elements exist!
		lp.assertAcceptedUsernamesText();
		lp.assertPasswordForUsersText();
		/**	TODO -> TBD ! --------------------------------------------------------------------------------------------------------------
			Thread.sleep(1000);
			p.login("username :) ", "password :( ");
			WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
			System.out.println("user field value: " + lp.getAttribute(usernameField, "value")); // Same-Same !!!
			System.out.println("user field value: " + usernameField.getAttribute("value"));
			System.out.println("user field value: " + lp.getAttribute(driver.findElement(By.cssSelector("#user-name")), "value"));
			System.out.println("user field value: " + lp.getAttribute(driver.findElement(By.cssSelector("#user-name")), "value"));
		*///----------------------------------------------------------------------------------------------------------------------------
	}
	
	@Owner("Elad Luz") // opposed to previous "Test owner: Elad Luz"
	@Test (priority= 1, dataProvider= "getExcelData", description= "Login Failure cases - Error messages")
	@Description("Failed-Logins = Cases of Authentication with Invalid & Missing Credentials -- Validating the displayed Error message")
	@Severity(SeverityLevel.NORMAL)
	@Epic("Login Page")
	@Feature("Authentication mechanism")
	@Story("When User Login, the Authentication mechanism expect register User with Pass. If not suplied, Error is displayed as design")
	@TmsLinks({@TmsLink("550")}) // Exemplary link to Test
	@Issues({@Issue("50")}) // Exemplary link to Bug
	
	/* This case tests several Failed Login options - using String data inputs of: user, password & error (from excel file dataProvider)
	   Missing Username & Password fields, Missing Username field, Missing Password field, Invalid User,  and an Error Mismatch Failure!
	   Last case is designed to Fail on having wrong message, thus capturing test.png print-screen to: /SeleniumProject/screen-shots/ */
	public void tc01_LoginFailures(String user, String pass, String expected) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh(); // to refresh between each iteration
		lp.login(user, pass); // fill-in Username & Password (here, taken from excel DS, to match each test-case)  -&- click LoginBtn...
		lp.printErrorButton(); // EXTRA -> stand-alone print screenshot of the 'Close Error' (x) button (regardless of Test-Failure)...!
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase()); // Local assertion (not using method from the lp page class)!
	}	
	@DataProvider // defining the Data source used in the above method -> This is relevant to the: tempSite/utilities/ExcelTabsUtil.java
	public Object[][] getExcelData(){ // method will fetch the excel data into a 2D array table object that would act as a Data Provider
		String excelPath = System.getProperty("user.dir") + "/src/test/resources/tempSite/inputTestData.xlsx"; // location after Maven!!
		// System.out.println(excelPath);
		Object[][] table = ExcelTabsUtil.getTableArray(excelPath, "loginFailure"); // loginFailure = relevant excel tab
		return table;
	}
	
	@Test (priority= 2, description= "Close Login Error button")
	@Description("Functional-Test = Upon Failed Login Message, Click Close Error x button, will Remove the Message")
	@Severity(SeverityLevel.MINOR)
	@Epic("Login Page")
	@Feature("GUI Functionality")
	@Story("When User Login Failed & Error is displayed - tThere should be a close button (x), that closes the displayed message")
	/* This test uses credentials inputs (user & pass) from a file:  Project.../src/test/resources/saucedemo/configuration.properties */                                                            
	public void tc02_LoginFailureCloseError_MsgRemoved() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh(); // to refresh page & make sure No Error from Prev Case is Displayed!
		assertFalse(lp.isErrorDisplayed()); // Error + Close Btn -> Not Displayed
		lp.clickLogin();
		assertTrue(lp.isErrorDisplayed()); // Error + Close Btn -> Displayed
		lp.printErrorButton(); // stand-alone print screenshot of the 'Close Error' button...
		lp.clickErrorButton(); // Click to close....
		assertFalse(lp.isErrorDisplayed()); // Error was removed!
	}

	@Test (priority= 3, description= "Successful Login of User - Lands in Products Page")
	@Description("Success-Login = Authentication with Valid Credentials, of a Registered User with Proper Password, Logs the User into")
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Login Page")
	@Feature("Authentication mechanism")
	@Story("When User Login with proper credentials - Authentication shouls succeed, and user is redirected to Products-Inventory page")
	/* This test uses credentials inputs (user & pass) from a file:  Project.../src/test/resources/saucedemo/configuration.properties */
	public void tc03_LoginSuccess() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.navigateRefresh(); // to refresh between each iteration
		// using valid login credentials User | Pass: standard_user & secret_sauce  (relevant value taken from configuration.properties)
		lp.login(ConfPropertiesUtil.readProperty("user"), ConfPropertiesUtil.readProperty("pass"));
		// NOTE: below there are 2 ways to validate you are in the correct URL (page) - TODO - Delete one of them...
		lp.assertCurrentUrl("saucedemo.com/inventory.html"); // to used the dynamic method (from BasePage via lp.) for URL validation...
		ProductsInventoryPage pp = new ProductsInventoryPage(driver); // initiate this page, to use its own method for URL validation...
		pp.isProductsInventoryPageTitle(); // redirection to Products-Inventory page, indicates proper login (case specific page method)
		// Example of Using Util for text attachments to Allure Report:
		ReportAttachmentsUtil.attachText("User Log-in properly"); // needs import Util (in Project) for add text attachments to Allure !
		// Note that this text can be anything from a comment to Exception... -AND because in this case its redundant TODO - Delete it !
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
*/
