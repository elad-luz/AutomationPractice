package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class I_SeleniumSelectOptionElements {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform these steps to operate a drop-down selection menu build like:
			<select id="id" name="nm" class="cl">
				<option value=A"> A </option>
				<option value=B"> B </option>
			</select>
		WebElement el = driver.findElement(By.cssSelector("#id")); // or any other locator
		Select selectX = new Select(el); // instead of el you could have enter the locator
		-	selectX.selectByVisibleText("A");
		-	selectX.selectByIndex(1);
		-	selectX.selectByValue("A");
		de-selecting is possible in multi-selection
		-	selectX.deselectByVisibleText(" A ")
		-	selectX.deselectAll()
	 	*/// Test Steps below (add sleep if needed):
		
		driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(2000); // ----
		// insert Text to textBoxFields (not to lastname to create an error)...
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Frst"); // if missing #firstname-error
		driver.findElement(By.cssSelector("#lastname")).sendKeys("Last"); // if missing #lastname-error
		driver.findElement(By.cssSelector("#email")).sendKeys("FL@com"); // if missing #email-error
		Thread.sleep(1000); // ----
		// click next button...
		driver.findElement(By.cssSelector(".btn.btn-next")).click(); // missing field > relevant UI error
		Thread.sleep(1000); // ----
		// find BEGINNER button and click on it -> selected... -then- NEXT (having same id, as before)...
		driver.findElement(By.id("Beginner")).click();
		driver.findElement(By.id("next")).click();
		// find textBox element by ID (for address) -> clear existing text (if needed) & insert text...
		driver.findElement(By.id("streetname")).clear();
		driver.findElement(By.id("streetname")).sendKeys("Street");
		driver.findElement(By.id("streetnumber")).sendKeys("0");
		driver.findElement(By.id("city")).sendKeys("City");
//  ->	// Country Selection
		WebElement countrySelection = driver.findElement(By.cssSelector("#country"));
		Select selectCountry = new Select(countrySelection); // or as seen below, in one line
		// Select selectCountry = new Select(driver.findElement(By.cssSelector("#country")));
		System.out.println("default selection is: " + selectCountry.getFirstSelectedOption().getText());
		selectCountry.selectByVisibleText(" Argentina ");
		System.out.println("new selection is: " + selectCountry.getFirstSelectedOption().getText());
		selectCountry.selectByIndex(0);
		System.out.println("new selection is: " + selectCountry.getFirstSelectedOption().getText());
		selectCountry.selectByValue("Italy");
		System.out.println("new selection is: " + selectCountry.getFirstSelectedOption().getText());
		Thread.sleep(1000); // ----
		// find FINISH button and click on it -> Fin...
		driver.findElement(By.id("finish")).click(); // can use: submit()...
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
