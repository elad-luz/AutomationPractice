package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class J_SeleniumActionsExercise1 {
/** Performed steps:
	0. Must run this on Chrome in, 100% !
	1. Open "https://login.salesforce.com"
	2. Fill in the User + Password + Remember me (check)
	3. Click on ‘Login’ button
	4. Get the error message and print it.
	5. Click the ‘Forgot your password’ link
	6. Insert your name
	7. Click on ‘Continue’ button
	8. Get the error message and print it
 	*/
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#username")).sendKeys("user.name@salesforce.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("pass!1");
		driver.findElement(By.cssSelector("#rememberUn")).click();
		driver.findElement(By.cssSelector("#Login")).click();
		String error = driver.findElement(By.cssSelector("#error")).getText();
		System.out.println("login error:\n" + error);
		driver.findElement(By.cssSelector("#forgot_password_link")).click();
		driver.findElement(By.cssSelector("#un")).sendKeys("user.name@salesforce.com");
		driver.findElement(By.cssSelector("#continue")).click();
		String message = driver.findElement(By.cssSelector(".message")).getText();
		System.out.println("reset password message:\n" + message);
		driver.quit();
		System.out.println("-- end --");
	}
}
