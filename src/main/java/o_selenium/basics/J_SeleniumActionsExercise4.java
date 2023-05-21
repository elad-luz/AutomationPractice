package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class J_SeleniumActionsExercise4 {
/** Performed steps:
	0. Must run this on Chrome in, 100% !
	1. Open "https://www.skyscanner.co.il"
	2. Fill the 'From' field with LHR  + choose: London Heathrow (LHR)
	3. Fill the 'To' field with FCO + choose: Rome Fiumicino (FCO)
	4. Press the 'Search Flights' button
	5. Print first result
	NOTE - the site might block you for being a Robot !
 	*/
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.skyscanner.co.il");
		System.out.println("Test on: " + driver.getCurrentUrl());

		driver.findElement(By.cssSelector("#fsc-origin-search")).sendKeys("LHR");
		Thread.sleep(1000); // ----
		List<WebElement> listFrom = driver.findElements(By.cssSelector("#react-autowhatever-fsc-origin-search li"));
		for (WebElement from : listFrom) {
			if (from.getText().toLowerCase().contains("(lhr)")) {
				from.click();
				break; // to step out of loop - because if clicked, the list closes!
			}
		}
		driver.findElement(By.cssSelector("#fsc-destination-search")).sendKeys("FCO");
		List<WebElement> listTo = driver.findElements(By.cssSelector("#react-autowhatever-fsc-destination-search li"));
		for (WebElement to : listTo) {
			if (to.getText().toLowerCase().contains("(fco)")) {
				to.click();
				break; // to step out of loop - because if clicked, the list closes!
			}
		}
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[data-e2e='search-summary-places']")).getText());
		driver.quit();
		System.out.println("-- end --");
	}
}
