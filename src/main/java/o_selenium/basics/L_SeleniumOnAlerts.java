package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L_SeleniumOnAlerts {
/*	working with Alert pop-up: https://www.guru99.com/alert-popup-handling-selenium.html -> TODO: Add capabilities to handle Alerts!
	to learn on alert-types -> https://www.w3schools.com/js/js_popup.asp
		- window.alert()	- Alert-text only + OK button
		- window.confirm()	- Alert-text + Cancel & OK buttons
		- window.prompt()	- Alert-text + Input-field + Cancel & OK buttons
	public void handleAlertDo(String text) {   // need several methods to deal with actions needed !!!
		driver.switchTo().alert().getText();  // if needed for verification
		driver.switchTo().alert().dismiss(); // to click on Cancel
		driver.switchTo().alert().accept(); // to click on OK
		driver.switchTo().alert().sendKeys(text); // if any input is needed
	}
	*/
/** Performed steps:
	0. 
	1. 
	2. 
 	*/ // might not work
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mytinytodo.net/demo");
		System.out.println("Test on: " + driver.getCurrentUrl());
		driver.findElement(By.cssSelector(".mtt-tabs-new-button>.tab-height-wrapper")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();	// can also use dismiss() accept()

		// driver.quit();
		System.out.println("-- end --");
	}
}
