package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_SeleniumBasicsExercise2 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// click forgot password
		driver.findElement(By.cssSelector("#forgot_password_link")).click();
		Thread.sleep(1000); // ----
		// get page title
		String t = driver.getTitle(); // or driver.getTitle().toLowerCase(); if you like it better
		if (t.toLowerCase().contains("forgot your password")) { // or t.contains if got only lower ^ compare as lower only -> Actual title: Forgot Your Password | Salesforce
			System.out.println("proper page: " + t);
			// insert Text to
			driver.findElement(By.cssSelector("#un")).sendKeys("user.name@salesforce.com");
			driver.findElement(By.cssSelector("#continue")).click();
		}
		Thread.sleep(1000); // ----
		// find  message & print - start with headline (<h1 id="header" class="mb12">)
		String msg = driver.findElement(By.cssSelector("#header.mb12")).getText();
		System.out.println("message headline is: " + msg);
		// inner text:
		try {
			WebElement div = driver.findElement(By.cssSelector("div.message"));
			System.out.println("message div text: \n" + div.getText());
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		 	System.out.println("message don't exist");
		}
		Thread.sleep(1000); // ----
		// if you only want the 2ed <p> in <div> above ^ use: "div > p:nth-child(2)"
		System.out.println("2ed p only: " + driver.findElement(By.cssSelector("div > p:nth-child(2)")).getText());
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
