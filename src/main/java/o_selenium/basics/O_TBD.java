package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O_TBD {
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
