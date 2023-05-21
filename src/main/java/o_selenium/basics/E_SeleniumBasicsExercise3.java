package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_SeleniumBasicsExercise3 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com/sch/ebayadvsearch");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// add key word to text-field + excluded word to ignore field
		driver.findElement(By.cssSelector("#_nkw")).sendKeys("tent");
		driver.findElement(By.cssSelector("#_ex_kw")).sendKeys("army");
		// Selecting the "Buy It Now" CheckBox (bit_cb)
		// mouse-over "findElement" show it returns a "WebElement" object (needing import) which can be initiated with name
		// if you just add var name > see red underline > mouse-over > "create local var" > choose automatically right type
		 WebElement bit_cb = driver.findElement(By.cssSelector("#LH_BIN")); // this is good for ease of re-use the element!
		bit_cb.click(); //= driver.findElement(By.cssSelector("#LH_BIN")).click(); -> the line determine pre-selected \ not
		// Check whether the Check box is pre-selected (toggled on) or not, and if not click it to select it -> toggle on !
        if (bit_cb.isSelected()) {					
            System.out.println("checkbox was already pre-selected beforehand...");			
        } else {			
        	bit_cb.click();
        	System.out.println("checkbox was selected, and is now toggled on...");
        }
        Thread.sleep(1000); // ----
        // click search
        driver.findElement(By.cssSelector("#searchBtnLowerLnk")).click();
        Thread.sleep(1000); // ----
        // get info from result page search field Title & Field
        System.out.println("results page title: (excluding army) " + driver.getTitle());
        String res_kw = driver.findElement(By.cssSelector("#gh-ac")).getAttribute("value").toLowerCase(); // -> tent
        if (res_kw.contains("tent")) {
			System.out.println("results = expected!");
		}
        // back to prev page & get the title
        driver.navigate().back();
        Thread.sleep(1000); // ----
        System.out.println("< first page title: " + driver.getTitle());
        // clear excluded word from field and change it to black
        WebElement ex = driver.findElement(By.cssSelector("#_ex_kw"));
        Thread.sleep(1000); // ----
        ex.clear();
		ex.sendKeys("black");
        // click top search button (which reside in a dive with classes)
        driver.findElement(By.cssSelector("div.adv-s.mb.space-top > button")).click();
        Thread.sleep(1000); // ----
        // get title from new results page after excluding black
        System.out.println("results page title: (excluding black) " + driver.getTitle());
        Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}