package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class J_SeleniumActionsExercise5 {
/** Performed steps:
	0. Must run this on Chrome in, 100% !
	1. Open "https://www.ebay.com/sch/ebayadvsearch"
	2. Search for 'guitar'
	3. Change category to 'Musical Instruments & Gear' (Use Select object)
	4. Update price between 50-60ILS
	5. Click 'Auction' option (Buying formats)
	6. Press the Search button on the bottom of the page
	7. Check that all prices are between 50-60 ILS
 	*/
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/sch/ebayadvsearch");
		System.out.println("Test on: " + driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#_nkw")).sendKeys("guitar");
		WebElement e = driver.findElement(By.cssSelector("select#e1-1"));
		Select s = new Select(e); // Select s = new Select(driver.findElement(By.cssSelector("select#e1-1"))); 
		s.selectByValue("619");  // s.selectByVisibleText("Musical Instruments & Gear");
		driver.findElement(By.cssSelector("[name='_mPrRngCbx']")).click();
		driver.findElement(By.cssSelector("[name='_udlo']")).sendKeys("50");
		driver.findElement(By.cssSelector("[name='_udhi']")).sendKeys("60");
		driver.findElement(By.cssSelector("#LH_Auction")).click();
		driver.findElement(By.cssSelector("#searchBtnLowerLnk")).click(); // or in Xpath: "//*[@id="searchBtnLowerLnk"]"
		// get the 'stn' price as string of text & number > remove from it, the textual part (with space), and the number to double !
		List<WebElement> stnPriceList = driver.findElements(By.cssSelector("li.s-item.s-item__pl-on-bottom.s-item--watch-at-corner span.s-item__price"));
		for (WebElement stn : stnPriceList) { // 'stn' = string of text & number
			String stnPrice = stn.getText(); // get the String, BUT this is not good for price - because, its a String with Text, not a Number!
			// System.out.println(stnPrice); // -> 'ILS 52.08' - note it has a string "ILS " part needed to be removed !
			String snPrice = stnPrice.replace("ILS ", ""); // remove the partial string to be left with only a number
			// System.out.println(snPrice); // -> '52.08'
			double dPrice = Double.parseDouble(snPrice); // converts a string into a double-number == Same as: double dPrice = Double.valueOf(snPrice);
			// System.out.println(dPrice);
			if (!(dPrice >= 50 && dPrice <= 60)) { // if price is not in the given range its an error => to get error, change 60 to 58...
				System.out.println("error price is not in the given range " + dPrice);
			}
		}
		System.out.println("if no price out of limit -> it's looking good !");
		driver.quit();
		System.out.println("-- end --");
	}
}
/**
 		List<WebElement> list = driver.findElements(By.cssSelector("li.s-item.s-item__pl-on-bottom.s-item--watch-at-corner span.s-item__price"));
		for (WebElement el : list) {
			String sPrice = el.getText();
			sPrice = sPrice.replace("ILS", "");
//			double price = Double.parseDouble(sPrice);
			System.out.println("--" +sPrice);
		}
*/