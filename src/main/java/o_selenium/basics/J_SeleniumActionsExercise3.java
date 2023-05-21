package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class J_SeleniumActionsExercise3 {
/** Performed steps:
	0. Must run this on Chrome in, 100% !
	1. Open "https://www.saucedemo.com"
	2. Do Login
	3. Add to cart 2 products
	4. Press the cart button
	5. Click on ‘CHECKOUT’ button
	6. Fill your information and Click ‘CONTINUE’ button
	7. Click on ‘FINISH’ button
	8. Get the message and print it (Thank you message)
 	*/
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector("#login-button")).click();
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector("#checkout")).click();
		driver.findElement(By.cssSelector("#first-name")).sendKeys("standard");
		driver.findElement(By.cssSelector("#last-name")).sendKeys("user");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("123456");
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector("#continue")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector("#finish")).click();
		System.out.println(driver.findElement(By.cssSelector("#checkout_complete_container > h2")).getText());
		driver.quit();
		System.out.println("-- end --");
	}
}
