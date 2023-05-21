package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_SeleniumElementsByID {
/** How to Work on Elements in Page - Using By.id
	A Page-Element is an HTML tag that exist in memory (dom), which can be located (in varied ways*) and operated in varied ways.
	Page-Element is considered by Selenium as WebElament Object !
	The options to operate it are:
	- Info in element: get the text (getText) & more...
	- Button: click on (click)
		> click() method is used to click on the button in the webpage.
		> submit() method can be used to click on the button present in the form and Type attribute should be "submit".
		-> after all fields were filled -> e.g. driver.findElement(By.id("pass")).sendKeys("123456");
	  	see 2 ways to proceed: .click() on relevant button | .submit() on last field (e.g. do enter):
    		- driver.findElement(By.name("login")).click();
			- driver.findElement(By.id("pass")).submit();
	- Text-Box: add text (sendKeys) & remove text (clear)
	- More operations possible...
	Locate Element in DOM:
	- locate it on Page > right-click on it in chrome browser + select "inspect"
	- in DevTool you see that element & can find its unique attribute to pin it specifically...
	
	
	*/
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
		System.out.println(driver.getCurrentUrl());
		// tell the program to stop for a while (in milliseconds) -> Note: sleep requires a "throws"...
		Thread.sleep(1000); // ----
		// find textBox element by tagID (for first & last name + email) -> insert Text to textBoxFields...
		driver.findElement(By.id("firstname")).sendKeys("First");
		driver.findElement(By.id("lastname")).sendKeys("Last");
		driver.findElement(By.id("email")).sendKeys("eMail@automation.co.il");
		Thread.sleep(1000); // ----
		// find NEXT button element by ID, and click on it -> next...
		driver.findElement(By.id("next")).click();
		// find BEGINNER button and click on it -> selected... -and- INTERMEDIATE -and- NEXT (having same id as before) again ...
		driver.findElement(By.id("Beginner")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.id("Intermediate")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.id("next")).click();
		// find textBox element by ID (for address) -> clear existing text (if needed) & insert text...
		driver.findElement(By.id("streetname")).clear();
		driver.findElement(By.id("streetname")).sendKeys("Street");
		driver.findElement(By.id("streetnumber")).sendKeys("0");
		driver.findElement(By.id("city")).sendKeys("City");
		// find FINISH button and click on it -> Fin...
		driver.findElement(By.id("finish")).click(); // can use: submit()...
		Thread.sleep(1000); // another sleep to see before close all went well...
		
		/**	PAUSE running time:
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
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
