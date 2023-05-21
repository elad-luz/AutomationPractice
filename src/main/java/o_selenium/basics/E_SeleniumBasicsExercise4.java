package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_SeleniumBasicsExercise4 {  /** comment */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
		System.out.println("Test on: " + driver.getCurrentUrl());
	/** Look for 3 elements and print the next information
		The methods exist in each WebElement - find it and do . (dot) to expose the methods
		the text (use getText() to get the text)
		the id name (use getAttribute(“id”))
		the tag name (use getTagName())
		is it displayed (use isDisplayed())
		is it enabled (use isEnabled())
	 	*/
		Thread.sleep(1000); // ----
		// ABOUT button -> aboutBtn. [clear(), click(), ... etc.]
		WebElement aboutBtn  = driver.findElement(By.cssSelector(".moving-tab"));
		String aboutBtnClass = aboutBtn.getAttribute("class"); // using String var
		System.out.println("aboutBtn Class: " + aboutBtnClass); // printing -> var
		System.out.println("aboutBtn Text: " + aboutBtn.getText());
		System.out.println("aboutBtn Tag: " + aboutBtn.getTagName());
		System.out.println("aboutBtn isD: " + aboutBtn.isDisplayed());
		System.out.println("aboutBtn isE: " + aboutBtn.isEnabled());
		// First Name text-field 
		WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
		System.out.println("firstName Class: " + firstName.getAttribute("class"));
		System.out.println("firstName Text: " + firstName.getText());
		System.out.println("firstName Tag: " + firstName.getTagName());
		System.out.println("firstName isD: " + firstName.isDisplayed());
		System.out.println("firstName isE: " + firstName.isEnabled());
		// Same element -> Using the method below
		printInfo(firstName);
		// Avatar pic
		WebElement avatarPic = driver.findElement(By.cssSelector("#wizardPicturePreview"));
		System.out.println("avatarPic Class: " + avatarPic.getAttribute("class"));
		System.out.println("avatarPic Text: " + avatarPic.getText());
		System.out.println("avatarPic Tag: " + avatarPic.getTagName());
		System.out.println("avatarPic isD: " + avatarPic.isDisplayed());
		System.out.println("avatarPic isE: " + avatarPic.isEnabled());
		// NEXT button
		WebElement nextBtn   = driver.findElement(By.cssSelector(".btn.btn-next"));
		System.out.println("nextBtn Class: " + nextBtn.getAttribute("class"));
		System.out.println("nextBtn Text: " + nextBtn.getText());
		System.out.println("nextBtn Tag: " + nextBtn.getTagName());
		System.out.println("nextBtn isD: " + nextBtn.isDisplayed());
		System.out.println("nextBtn isE: " + nextBtn.isEnabled());
		// more...
		System.out.println("nextBtn value: " + nextBtn.getAttribute("value"));
		System.out.println("nextBtn type: " + nextBtn.getAttribute("type"));
		System.out.println("nextBtn name: " + nextBtn.getAttribute("name"));
		System.out.println("nextBtn sise: " + nextBtn.getSize());
		System.out.println("nextBtn id: " + nextBtn.getAttribute("id"));

		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
	// using a method for this get the WebElement and print its info
	public static void printInfo(WebElement we) { // there can be a case you'll get the selector
		String Class = we.getAttribute("class");
		String text = we.getText();
		String tag = we.getTagName();
		String id = we.getAttribute("id");
		boolean display = we.isDisplayed();
		boolean enabled = we.isEnabled();
		System.out.println("--> WebElement info: " + Class + ", " + text + ", " + tag + ", " + id + ", " + display + ", " + enabled);	
	}
}