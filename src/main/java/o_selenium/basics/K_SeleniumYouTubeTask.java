package o_selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class K_SeleniumYouTubeTask {

	public static void main(String[] args) throws InterruptedException {
		/** Perform these steps:
		1. open https://www.youtube.com
		2. search "elton john" (insert text + click submit button) -or- or any other singer
		3. validate results are displayed
		4. scroll down till find title "your song" (+ print songs in result till found) -or- other song
		5. click it to start play
		6. determine if video starts with an advertising or not (and print option)
		7. wait 30 seconds to here the song and quit...
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		String search = "elton john"; // or any other singer
		String songName = "your song"; // or any other song
		driver.findElement(By.cssSelector("#search-input > #search")).sendKeys(search);
		WebElement submitBtn = driver.findElement(By.cssSelector("button#search-icon-legacy"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement resultsList = driver.findElement(By.cssSelector(".style-scope.ytd-section-list-renderer"));
		wait.until(ExpectedConditions.visibilityOf(resultsList));
		boolean substrNotFound = true;
		while (substrNotFound) {
			List<WebElement> resList = driver.findElements(By.cssSelector("#video-title > yt-formatted-string"));
			for (WebElement el : resList) {
				System.out.println(el.getText());
				if (el.getText().toLowerCase().contains(songName)) {
					System.out.println("-- Video FOUND !");
					wait.until(ExpectedConditions.elementToBeClickable(el)).click();
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ytp-ad-image"))));
						System.out.println("-- Advertising is found !");

					} catch (NoSuchElementException e) {
						System.out.println("-- NO advertising found !");
					}
					substrNotFound = false;
					break;
				}
			}
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
		Thread.sleep(30000); // 30 sec of song :)
		driver.quit();
		System.out.println("-- end --");
	}
}
/** OLD:
		Perform these steps:
		1. open https://www.youtube.com
		2. search "madona" (insert text + click submit button) ==> Got madona with typo instead of madonna !
		3. validate results displayed
		4. scroll till find song "don't tell me" (+ print songs in result till found)
		5. click it to start play
		6. determine if video starts with an advertising or not (+ print option)
		7. if no ad, wait 20 seconds to here the song...
		Note: I could not remember what to assert on, but the flow works :)
		-------------------------------------------------------------------
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		String search = "madona";
		String songName = "holiday"; // "don't tell me"
		driver.findElement(By.cssSelector("#search-input > #search")).sendKeys(search);
		WebElement submitBtn = driver.findElement(By.cssSelector("button#search-icon-legacy"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement resultsTitle = driver.findElement(By.cssSelector("#corrected-link > span.italic.style-scope.yt-formatted-string"));
		wait.until(ExpectedConditions.visibilityOf(resultsTitle));
		boolean substrNotFound = true;
		while (substrNotFound) {
		List<WebElement> resList = driver.findElements(By.cssSelector("#video-title > yt-formatted-string"));
			for (WebElement el : resList) {
				System.out.println(el.getText());
				if (el.getText().toLowerCase().contains(songName)) {
					System.out.println("-- Video FOUND !");
					wait.until(ExpectedConditions.elementToBeClickable(el)).click();
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ytp-ad-image"))));
						System.out.println("-- Advertising is found !");
					} catch (NoSuchElementException e) {
					 	System.out.println("-- NO advertising found !");
					 	Thread.sleep(20000); // I know I already failed the exam, so I had to put sleep here, because it is a great song :)
					}
					substrNotFound = false;
					break;
				}
			}
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
		driver.quit();
		System.out.println("-- end --");
 */
