package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_SeleniumElementsExercise3 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform these steps:
		1. Open this site "http://www.echoecho.com/htmlforms10.htm" >
		2. Find & Click the Example second option radio button (in the middle) >
		3. Find & Click the Example third option radio button  (in the bottom) >
		4. Part 2
		   Find & Click the 2 first options of the radio buttons: Milk & Water >
	 	*/// Test Steps below (add sleep if needed):
		// open...
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// locate radius buttons by using child(#)
		WebElement r1 = driver.findElement(By.cssSelector(".table8 > input[type=radio]:nth-child(1)")); // 1st Radio Btn in top Table
		System.out.println("r1" + rBtnSelectStat(r1));
		WebElement r2 = driver.findElement(By.cssSelector(".table8 > input[type=radio]:nth-child(2)")); // 2ed Radio Btn in top Table
		System.out.println("r2" + rBtnSelectStat(r2));
	/** same but without using method:
		if (!r2.isSelected()) { // verify if not (!)
			System.out.println("r2 not selected");
		}
		if (r2.isSelected()) { // verify if yes
			System.out.println("r2  is selected");
		}
		*/
		System.out.println("switch to 2ed radio btn ---");
		r2.click(); // click the 2ed Radio Btn to select it
		System.out.println("r2" + rBtnSelectStat(r2));
		Thread.sleep(1000); // ----
		// Another way (example) to fined the 3edR is by using List
		List<WebElement> radios = driver.findElements(By.cssSelector(".table8 > input[type='radio']")); // all radio Btn
		if (!radios.get(2).isSelected()) {
			System.out.println("r3 not selected");
		}
		System.out.println("switch to 3ed radio btn ---");
		radios.get(2).click(); // 2 is the third in list (starting with zero)
		if (radios.get(2).isSelected()) {
			System.out.println("r3 is selected");
		}
		System.out.println("r1" + rBtnSelectStat(r1));
		System.out.println("r2" + rBtnSelectStat(r2));
		Thread.sleep(1000); // ----
		// part 2 -----------------  NOTE: I could have used the below method here as well !!!
		List<WebElement> lEl = driver.findElements(By.cssSelector(".table5 input[checked='']")); // all checked radio buttons
		System.out.println("Part 2 --------------\n" + lEl.size() + " The selected elements in 2ed table (to later make a switches) are: "); // the size of list
		for (WebElement el : lEl) {
			System.out.println("- " + el.getAttribute("value"));
		}
		// before switching selection of radio buttons
		if (!driver.findElement(By.cssSelector("input[type='radio'][value='Milk']")).isSelected()) {
			System.out.println("- Milk  Not selected");
		}
		if (!driver.findElement(By.cssSelector("input[type='radio'][value='Water']")).isSelected()) {
			System.out.println("- Water Not selected");
		}
		// click to switch both radios in table 2
		driver.findElement(By.cssSelector("input[type='radio'][value='Milk']")).click(); // will also work with reduced selector: "[value='Milk']"
		driver.findElement(By.cssSelector("input[type='radio'][value='Water']")).click();
		// after
		System.out.println("after switching selection of radio buttons:");
		if (driver.findElement(By.cssSelector("input[type='radio'][value='Milk']")).isSelected()) {
			System.out.println("- Milk  is Selected");
		}
		if (driver.findElement(By.cssSelector("input[type='radio'][value='Water']")).isSelected()) {
			System.out.println("- Water is Selected");
		}
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
	// using method to print radio btn selected status
	public static String rBtnSelectStat(WebElement we) {
		if (we.isSelected()) {
			return "  is selected";
		} else {
			return " not selected";
		}
	}
}
