package tempApp;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium1 {

	public static void main(String[] args) throws InterruptedException {
	/** Perform these steps:
		1. open https://www.google.com
		2. enter to search field 'Biggie'
		3. choose option 'biggie rapper' & submit
		4. validate results title displayed: 'The Notorious B.I.G.'
		4. filter to see only 'Videos'
		5. go over all videos and locate that which contains: 'Juicy'... & click it
		6. validate youtube webpage title contains "The Notorious B.I.G. - Juicy"
		7. wait 5 seconds and quit...
 		*/
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // ??
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String search = "Biggie";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[type=\"search\"]"))).sendKeys(search);
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("li[data-view-type] div[aria-label=\"biggie\"]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("[data-st-cnt=\"mode\"] a[href*=\"vid&\"]")))).click();
		List<WebElement> vidList = driver.findElements(By.cssSelector("h3>span[dir=\"ltr\"]")); // gather all videos under one list
		for (WebElement el : vidList) { // looping over list, to find the needed video
			if (el.getText().contains("Juicy"));
				el.click();
				break; // break loop after click !
			}
		String vidTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#title > h1"))).getText();
		assertTrue(vidTitle.toLowerCase().contains("b.i.g. - juicy"), "title don't match condition!"); // make sure right video opened !
		System.out.println("now playing: " + vidTitle);
		Thread.sleep(5000);
		driver.quit();
	}
}
