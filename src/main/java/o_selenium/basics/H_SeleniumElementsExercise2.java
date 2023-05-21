package o_selenium.basics;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_SeleniumElementsExercise2 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform these steps:
		1. Open this site "https://alitalia.com/en_il" >
		2. Find all links on page (elements of type a having href) >
		3. Put them in list of all link’s -and get the list size >
		4. Search for links that contains ‘Tel Aviv’ and print those links...
	 	*/// Test Steps below (add sleep if needed):
		driver.get("https://alitalia.com/en_il");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		List<WebElement> aList = driver.findElements(By.cssSelector("a[href]")); // all links
		System.out.println(aList.size()); // the size of list
		for (WebElement wEl : aList) { // for each loop
//			if (!wEl.getText().equals("")) { // print all links with some text
//				System.out.println(wEl.getText());
//			}
			if (wEl.getText().toLowerCase().contains("aviv")) { // print links with 'Aviv'
				System.out.println(wEl.getText());
			}
		}
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
