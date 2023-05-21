package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_SeleniumBasicsExercise1 { /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://prd.canvusapps.com/signup");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// insert Text to textBoxFields... -> change increment numbers so to Create New...  14
		driver.findElement(By.cssSelector("#user_name")).sendKeys("First14 Last"); // change #
		driver.findElement(By.cssSelector("#user_email")).sendKeys("f14.l@m.com"); // change #
		driver.findElement(By.cssSelector("#user_password")).sendKeys("pass0!");
		driver.findElement(By.cssSelector("#user_password_confirmation")).sendKeys("pass0!");
		driver.findElement(By.cssSelector("#company_name")).sendKeys("com14.com"); // change #
		Thread.sleep(1000); // ----
		// click Sign up...
		driver.findElement(By.cssSelector(".submit.btn.btn-primary")).click();
		Thread.sleep(3000); // ----
		// find success message & print -> message is in 2 elements:
		// h2 (no attributes) & p (class=lead) > within a div (id=signup)
		try {
			WebElement h2 = driver.findElement(By.cssSelector("div #signup > h2"));
			System.out.println("message h2 text: " + h2.getText());
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		 	System.out.println("h2 message don't exist");
		}
		Thread.sleep(1000); // ----
		try {
			WebElement p = driver.findElement(By.cssSelector("div #signup > p.lead"));
			System.out.println("message p text: " + p.getText());
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		 	System.out.println("p message don't exist");
		}
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
