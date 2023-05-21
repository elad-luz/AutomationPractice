package o_selenium.basics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class M_SeleniumOnWindows {
/*	working with Windows: https://www.guru99.com/alert-popup-handling-selenium.html -> TODO: Add capabilities to handle Frames!
	documentation also: https://www.selenium.dev/documentation/webdriver/interactions/windows/
	WebDriver does not make the distinction between windows and tabs.
	If your site opens a new tab or window (depends on your browser), Selenium will let you work with it using a window handle.
	Each window has a unique identifier < ID > which remains persistent in a single session.
	You can get the window handle of the current window by using  -->  driver.getWindowHandle();  <--
	How to handle window in Selenium?
		a. <a href="https://www.xyz.com" target="_blank">xyz</a> -> click on tag with target="_blank" (open new).
		b. Set the system property to Chromedriver and specify its path.
		c. Instantiate the webdriver to the new chromedriver.
		d. Get the URL of the web page and maximize the page.
		e. Get the window handle of the parent window -> to jump between windows you need to keep the id in memory as variable!
		   String main = driver.getWindowHandle(); // current main window handle ID
		f. Get the window handles of all the windows  -> and create a list set of all current windows 
		   Set<String> allCurrentWindows = driver.getWindowHandles(); // needs: import java.util.Set;
		   for (String window : allCurrentWindows) { // going over all windows in list ->
				driver.switchTo().window(window); // switching to the one possible (can add condition)...
		   }
		g. to work in new window you'll need to switch - if you'll skip, you'll get NoSuchElementException: Unable to locate...
		h. work in window (same way) - locate elements etc.
		i. switch back to main window if you need...
	when selenium driver reach a page than opens new tab \ window, to work within that window, requires a switch to it,  and  -
	afterwards, if need to return to first, you need to switch back to the orig (need id), otherwise it can't locate elements !
	example of working with several tabs:
        driver.get("https://demoqa.com/browser-windows");
        // Open new window by clicking the button
         driver.findElement(By.id("windowButton")).click();
         // Click on the new window element and read the text displayed on the window
         WebElement text = driver.findElement(By.id("sampleHeading"));
         // Fetching the text using method and printing it     
         System.out.println("Element found using text: " + text.getText());
	NOTE -> there are new-tabs & windows !
	*/
/** Performed steps:
	0. open url = https://automation.co.il/tutorials/html/selenium-difference-between-close-and-quit.html
	1. click on button (to open new) within main window...
	2. within Window2 (needing a switch) - if you'll skip switch you'll get NoSuchElementException...
	4. do search...
	5. switch back to first... & re-open a new window (3ed)
 	*/ // Example:
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		// as usual... start with:
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/html/selenium-difference-between-close-and-quit.html");
		System.out.println("Test on: " + driver.getCurrentUrl());
		
		// in main page -> click on "Click to open google in a new window" button
		WebElement gBtn = driver.findElement(By.cssSelector("#linkgoogle")); // locate button & click (can be done at once)
		gBtn.click(); // click will open a new tab with google page !
		System.out.println("Clicked to open google in a new window");
		
		// keep main window id (for further usage)
		String mainWin = driver.getWindowHandle();
		
		// switchTo new Window - Needs properly getting the proper window handle, of the one we want to switch to...
		// for that we will get all current windows (into a list) and take the one which is not main (found before)!
		Set<String> listWindows = driver.getWindowHandles(); // create a list set of all current windows = 2 (needs import...)
		for (String window : listWindows) { // going over all windows ->
			driver.switchTo().window(window); // switching to the one possible (can add condition)
		}
		System.out.println("window context switched");
		
		// work within new Window -> Search in google for a Term
		String sTerm = "qanon";
		driver.findElement(By.cssSelector("[name='q']")).sendKeys(sTerm); // locate search field & enter a search term
		driver.findElement(By.cssSelector("[name='q']")).submit(); // submit search
		String resultStats = driver.findElement(By.cssSelector("#appbar #result-stats")).getText();
		
		System.out.println("Searched Google found: " + resultStats);
		// Optional...
		driver.close(); // this will close the current window i'm working at Google...
		
		// switch back - move to main window page (as kept previously)
		driver.switchTo().window(mainWin);
		System.out.println("context switched back to main window");
		
		// in main page -> click on "Click to open google in a new window" button (declared found & init before)
		gBtn.click();
		System.out.println("Clicked google again");
		
		// re-switch to google window using prev mechanism... (need to get handles but not re-declare Set<String>!
		listWindows = driver.getWindowHandles(); // create a list set of all current windows = 2 (needs import...)
		for (String window : listWindows) { // going over all windows ->
			driver.switchTo().window(window); // switching to the one possible (can add condition)
		}
		System.out.println("window context switched");
		// validate
		String pageTitle = driver.getTitle();
		System.out.println("context page is on: " + pageTitle);
		
		driver.quit(); // close both tabs
		System.out.println("-- end --");
	}
}
