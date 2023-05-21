package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_SeleniumBasicsExercise5 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** On  https://login.salesforce.com  - perform 5 test steps:
		1. Add user to the user name text box >
		2. Add password to the password text box >
		3. Checked the ‘remember me’ check box >
		4. Check if the checkbox is checked, if yes Click the ‘Login’ button ->
		5. You will get an error message --> Print it.
	 	*/
		driver.get("https://login.salesforce.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// Test Steps
		driver.findElement(By.cssSelector("#username")).sendKeys("Username");
		driver.findElement(By.cssSelector("#password")).sendKeys("Password");
		WebElement check = driver.findElement(By.cssSelector("#rememberUn"));
		check.click();
		if (check.isSelected()) {
			System.out.println("checkbox already pre-selected!");
			driver.findElement(By.cssSelector("#Login")).click();
		}
		WebElement error = driver.findElement(By.cssSelector("#error"));
		System.out.println("error message: " + error.getText());
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}