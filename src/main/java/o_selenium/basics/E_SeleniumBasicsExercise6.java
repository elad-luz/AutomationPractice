package o_selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_SeleniumBasicsExercise6 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform following test steps:
		1. Navigate to  https://www.selenium.dev
		2. Check if the title of this site is equal to “selenium web site” or contains “SeleniumHQ Browser Automation” (use getTitle()) and print yes/no
		3. Navigate to  https://www.google.com 
		4. Check if the title of this site is equal to “Google” or contains “google” (use getTitle()) and print yes/no.
		5. Navigate back.
		6. Check again if the title of this site is equal to “selenium web site” or contains “SeleniumHQ Browser Automation” (use getTitle()) and print yes/no
	 	*/ // Test Steps:
		driver.get("https://www.selenium.dev");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// Actual title is 'Selenium' => you can play with strings 1 & 2 to check if works
		String p1t = driver.getTitle(); // pt1 = page 1 title => to be compared if equal -or- contains...
		System.out.println("page 1 title: " + p1t);
		String cs1 = "selenium"; // compared string 1 (equals - as is -> without Ignore Case)
		String cs2 = "SELENIUM";  // compared string 2 (contains - to lower)
		if (p1t.equals(cs1) || p1t.toLowerCase().contains(cs2.toLowerCase())) {
			System.out.println("yes Title condition fits properly");
		} else {
			System.out.println("No! Title condition do not match!");
		}
		// cont.
		driver.get("https://www.google.com");
		System.out.println("Browsed to: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// Actual title is 'Google' => you can play with strings 3 & 4 to check if works
		String p2t = driver.getTitle(); // pt1 = page 1 title => to be compared if equal -or- contains...
		System.out.println("page 2 title: " + p2t);
		String cs3 = "!google"; // compared string 3 (equalsIgnoreCase - as using 'to lower')
		String cs4 = "!google";  // compared string 4 (contains - using 'to lower')
		if (p2t.equalsIgnoreCase(cs3) || p2t.toLowerCase().contains(cs4.toLowerCase())) {
			System.out.println("yes Title condition fits properly");
		} else {
			System.out.println("No! Title condition do not match!"); // '!google' not fit (using 'google' in either fits)
		}
		// cont. using method bellow // !Selenium - Not Fit | Selenium - Fit
		driver.navigate().back();
		Thread.sleep(1000); // ----
		System.out.println("Backed to: " + driver.getCurrentUrl());
		System.out.println("Title is : " + driver.getTitle());
		if (isTitleCompareFit(driver, "Selenium", "Selenium")) { 
			System.out.println("--> Compare Fits");
		} else {
			System.out.println("--> Compare Don't Fit");
		}
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
	// using a method for title compare -> you can insert the title, or find it from within method -->
	// note that the driver is local, thus not recognized out of main, so it also needed to be put-in:
	public static boolean isTitleCompareFit(WebDriver driver, String equalText, String containsText) {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(equalText) || title.contains(containsText)) {
			return true;
		} else {
			return false;
		}
	}
}