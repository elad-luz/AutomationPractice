package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class J_SeleniumActionsExercise2 {
/** Performed steps:
	0. Must run this on Chrome in, 100% !
	1. Open "http://www.wix.com/jobs/locations/tel-aviv"  
	2. Get list of all job links
	3. Search & Print only jobs that have ‘Engineer’ in it
 	*/
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.wix.com/jobs/locations/tel-aviv");
		Thread.sleep(2000); // ----
		System.out.println("Test on: " + driver.getCurrentUrl());
		List<WebElement> jobs = driver.findElements(By.cssSelector("li.hover > a"));
		for (WebElement el : jobs) {
			if (el.getText().toLowerCase().contains("engineer")) {
				System.out.println("- " + el.getText());
			}
		}
		Thread.sleep(2000); // ----
		driver.quit();
		System.out.println("-- end --");
	}
}
