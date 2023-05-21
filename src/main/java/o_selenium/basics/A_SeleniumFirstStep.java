package o_selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; // for chrome browser
// import org.openqa.selenium.edge.EdgeDriver; // for edge browser

public class A_SeleniumFirstStep {
	// prior to using it you need to download & install the WebDriver properly --> https://www.selenium.dev/downloads/
		/**	Selenium via Chrome, works with ChromeDriver only supports Chrome version xx
		https://stackoverflow.com/questions/71350251/selenium-this-version-of-chromedriver-only-supports-chrome-version-xx
		verify your Google Chrome version (help > about) & download + install relevant driver in path ( C:\automation\drivers)
			use: https://chromedriver.chromium.org/downloads
			OR:  https://www.selenium.dev/downloads/
		*/

	public static void main(String[] args) {
		// setProperty should point to that path of the chrome-driver => There is an explanation on How To Install it!
		// Set the driver path
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe"); // for chrome browser
		//	System.setProperty("webdriver.edge.driver", "C:\\automation\\drivers\\msedgedriver.exe"); // for edge browser
		/** WebDriver is an "interface" ("acts like some-times" relationship) -
			a list of methods ONLY Names & signatures, which must & will be implement as needed by any related element
			INTERFACE creates a common denominator between objects which are not siblings.
			In our case ChromeDriver is the element that we initiate => which implement all behavior needed !
			we could have used msedgedriver (which had to provide the full interface implementation for edge)
		Constructing the WebDriver object using ChromeDriver implementation: */
		// Start the Session  ->  Note: if you are using Edge, change below to:  WebDriver driver = new EdgeDriver();
		WebDriver driver = new ChromeDriver(); // WebDriver is an interface, ChromeDriver is the Implementation.
		driver.manage().window().maximize(); // using the manage window maximize method (working in full screen)
		driver.get("https://www.automation.co.il"); // browsing to given URL
		
		System.out.println("driver: " + driver); // print driver info

		String url = driver.getCurrentUrl(); // Requesting the driver to retrieve the URL I'm at as a String
		if (url.contains("automation")) { // can be worked on...
			System.out.println(url + ", contains 'automation'");
		}
		String title = driver.getTitle(); // Requesting the driver to retrieve the Title of the page I'm at
		System.out.println("title: " + title);
		// String pageSource = driver.getPageSource(); // Requesting driver to retrieve the HTML (of the page I am at)
		
		driver.get("https://www.google.com"); // browsing to a new URL
		System.out.println(driver.getCurrentUrl()); // get Current Url of google
		driver.navigate().back();  // click 'back' button to return to previous URL
		System.out.println(driver.getCurrentUrl()); // get Current Url of automation
		driver.navigate().forward();  // click 'next' button and go again to next page
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();  // refresh the Current page
		
		// close the browser
		driver.quit(); // another option is: driver.close();
		
		System.out.println("-- end --");
	}
}
