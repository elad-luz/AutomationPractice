package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D_SeleniumGetElementInfo {
/** Note:
	To get the text from with-in a text field you need to use: .getAttribute("value") ->
	Getting the value of attribute called "value", which holds the text in field [like this we can get each value of each attribute]
	-> 	getText() vs getAttribute() vs getCssValue() --> https://www.lambdatest.com/blog/selenium-getattribute/
	*/
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// insert Text to textBoxFields (not to lastname to create an error)...
		driver.findElement(By.cssSelector("#firstname")).sendKeys("First"); // if missing #firstname-error | missing: 
		driver.findElement(By.cssSelector("#lastname")).sendKeys(""); // if missing #lastname-error | missing: Last
		driver.findElement(By.cssSelector("#email")).sendKeys("FL@com"); // if missing #email-error | missing: 
		Thread.sleep(1000); // ----
		// click next while fields are empty...
		driver.findElement(By.cssSelector(".btn.btn-next")).click(); // if a field is missing we get relevant UI error
		Thread.sleep(1000); // ----
		// find ERROR message for email-field missing & get the text & print it...  -->  NOTE:
		// if another field missing it will give an exception (because element will not exist)
		try {
			driver.findElement(By.cssSelector("#email-error"));
			System.out.println("missing email-error text: " + driver.findElement(By.cssSelector("#email-error")).getText());
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		 	System.out.println("email-error don't exist (in this part the lastname was missing)...");
		}
		Thread.sleep(1000); // ----	
		// check email field value, clear the text from email field (so it will be missing), and click next to see the relevant error
		System.out.println("email field text (before clear): " + driver.findElement(By.cssSelector("#email")).getAttribute("value"));
		driver.findElement(By.cssSelector("#email")).clear();
		System.out.println("email field text (after clear): " + driver.findElement(By.cssSelector("#email")).getAttribute("value"));
		driver.findElement(By.cssSelector(".btn.btn-next")).click(); // if a field is missing we get relevant UI error
		Thread.sleep(1000); // ----
		try {
			driver.findElement(By.cssSelector("#email-error"));
			System.out.println("missing email-error text: " + driver.findElement(By.cssSelector("#email-error")).getText());
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		 	System.out.println("email-error don't exist (in this part the lastname was missing)...");
		}
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
/*	
IF you want to check  a Text Field is Empty or not:
		driver.get("https://www.saucedemo.com");
		// Before Filling input
		WebElement userField = driver.findElement(By.cssSelector("#user-name"));
		if (userField.getAttribute("value").isEmpty()) {
			System.out.println("user: NULL!"); // Print if text field is empty
		}
		else {
		    System.out.println("user: " + userField.getAttribute("value")); // Print if text field has an input value
		}
		// OUTPUT: user: NULL!
		
		// Filling inputs
		userField.sendKeys("standard_user");
		if (userField.getAttribute("value").isEmpty()) {
			System.out.println("user: NULL!"); // Print if text field is empty
		}
		else {
		    System.out.println("user: " + userField.getAttribute("value")); // Print if text field has an input value
		}
		// OUTPUT: user: standard_user
*/
