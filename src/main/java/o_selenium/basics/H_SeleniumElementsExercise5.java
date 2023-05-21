package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_SeleniumElementsExercise5 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform these steps:
		1. Open site - "https://www.amazon.com" >
		2. Find & Add in the search area "tent" >
		3. Find & Click on Search submit button >
		4. Print the list of the tents in the 3 first pages
		   - to do it you should press the next button with a loop
		   - in addition you should use Thread.sleep (to wait for the results) 
	 	*/// Test Steps below (add sleep if needed):
		driver.get("https://www.amazon.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("tent");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click(); // or use: submit();
		Thread.sleep(2000); // ----
		for (int i = 0; i < 3; i++) { // going over 3 pages -> each iteration starts with inserting all results to list
			System.out.println("page " + (i+1) + ")");
			List<WebElement> resList = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
			for (WebElement el : resList) {
				System.out.println("-> " + el.getText());
			} 
			// after finish - click on next...
			System.out.println("------- end of page " + (i+1) + " ->");
			driver.findElement(By.cssSelector("a.s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")).click();
			Thread.sleep(2000); // ----
		}
		Thread.sleep(2000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
	// method out of main to be used for ...
}
