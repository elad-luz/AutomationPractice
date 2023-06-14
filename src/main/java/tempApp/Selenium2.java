package tempApp;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2 {
	/*  See also: o_selenium.basics -> K_SeleniumYouTubeTask for another of this kind...
		Perform these steps (in Selenium Java):
		1. set & init ChromeDriver & open chrome in maximum size
		2. browse to https://www.youtube.com webpage -> find search field & enter to it: "Your Song" (text) and submit search
		3. upon results displayed - find the first video and click it
		4. verify video page opened (current url contains: "watch?v=")
		5. determine if video advertising preview (.ytp-ad-text.ytp-ad-preview-text) is shown 
			if yes, wait till its gone... and verify the video is playing
			-> determine if video advertising skip (.ytp-ad-text.ytp-ad-skip-button-text) is shown
				- if yes, wail 1.5 sec, then click it
				- else do nothing!
		6. after 15 seconds of video played, close the browser...
	 */
	// Auto-generated method By ChatCPT & Edit by Me :)
	public static void main(String[] args) throws InterruptedException {
		// Step .1
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe"); // set path to chromedriver executable
		WebDriver driver = new ChromeDriver(); // create a new instance of the Chrome driver
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // define & Create a WebDriverWait with timeout of 30 sec.
		driver.manage().window().maximize(); // maximize the browser window
		String songTitle ="Your Song"; // "Your Song" - by Elton John  -or-  any other: "Last Night I Dreamt That Somebody Loved Me"  etc.
		String setSong = songTitle.toLowerCase() ; // title taken to lower-cases & used as input !
		// Step .2
		driver.get("https://www.youtube.com"); // navigate to the YouTube webpage
		WebElement searchField = driver.findElement(By.name("search_query")); // find search field
		searchField.sendKeys(setSong); // enter the set-Song to search field
		WebElement searchButton = driver.findElement(By.id("search-icon-legacy")); // find the search button (to submit search)
		searchButton.click(); // click it...
		// Step .3
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("video-title"))); // wait for the results to be displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#video-title"))).click();// find & click the first video
		// Step .4
		String currentUrl = driver.getCurrentUrl(); // verify that the video page has opened
		assertTrue(currentUrl.contains("watch?v="), "url don't match condition!"); // dBug System.out.println("Current Url: "+currentUrl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#title > h1 > yt-formatted-string")));
		String videoTitle = driver.findElement(By.cssSelector("#title > h1 > yt-formatted-string")).getText(); // get the video title
		assertTrue(videoTitle.toLowerCase().contains(setSong), "title don't match condition!"); // make sure the right video opened !
		// Step .5
		Thread.sleep(500); // give it half a second to render...
		WebElement adPreview = null;
		try {
			adPreview = driver.findElement(By.cssSelector(".ytp-ad-text.ytp-ad-preview-text")); // is the video advertise-preview shown
			System.out.println("Video will play after ad"); // do nothing !
		} catch (org.openqa.selenium.NoSuchElementException e) { // If the ad preview element is not found, do nothing...
		}
		if (adPreview != null) { // if the ad preview is shown (element was located)
			wait.until(ExpectedConditions.invisibilityOf(adPreview)); // wait until it's gone and print video is playing
			System.out.println("Video is now playing ...");
			WebElement skipBtnTxt = null;
			try {
				skipBtnTxt = driver.findElement(By.cssSelector(".ytp-ad-text.ytp-ad-skip-button-text")); // is the ad-skip-txt shown
				System.out.println("Skip video shown"); // do nothing !
			} catch (org.openqa.selenium.NoSuchElementException e) { // if the skip button element is not found, do nothing...
			}
			if (skipBtnTxt != null) { // if the skip button is shown (element located)
				Thread.sleep(1500); // Wait 1.5 sec...
				skipBtnTxt.click(); // click to skip !
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ytp-ad-skip-button-icon"))).click(); // option
				System.out.println("Skipped video ad");
			}
		}
		System.out.println("all was OK till now, closing in 15 sec."); //----------------------------------------------------------------|        
		// Step .6
		Thread.sleep(15000); // Wait for 15 seconds of video playback
		driver.quit(); // Close the browser
	}
}
