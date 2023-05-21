package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_SeleniumElementsExercise4 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform these steps:
		1. Open this site "https://whatismyipaddress.com" >
		2. Extract the IP address from the UI
		3. Go to site "http://ripe.net"
		4. Type in the extracted IP address and perform search on the RIPE DB
		5. Print the whole block of the second result
	 	*/// Test Steps below (add sleep if needed):
		driver.get("https://whatismyipaddress.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(3000); // ----
		String ip = driver.findElement(By.cssSelector("#ipv4 > a")).getText();
		Thread.sleep(1000); // ----
		driver.get("http://ripe.net");
		Thread.sleep(3000); // ----
		driver.findElement(By.cssSelector("#searchtext")).sendKeys(ip);
		driver.findElement(By.cssSelector("#whois-search .fa-search")).click();
		Thread.sleep(3000); // ----
		String data = driver.findElement(By.cssSelector("#resultsSection div:nth-child(3) .showripemanaged")).getText();
		System.out.println(data);
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
	// method out of main to be used for ...
}
