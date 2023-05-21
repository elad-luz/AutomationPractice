package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class M_SeleniumOnFrames {
/*	working with iFrames: https://www.guru99.com/handling-iframes-selenium.html -> TODO: Add capabilities to handle Frames!
	iFrame in Selenium WebDriver is a web page or an in-line frame which is embedded in another web page -or-
	an HTML document embedded inside another HTML document.
	the iFrame is often used to add content from other sources like an advertisement into a web page.
	the iFrame is defined with the <iframe> tag.
	when selenium driver reach a page with frame & needs to do something within frame it needs to be told to switch to it &
	afterwards it needs to switch back to the orig page if wishes to continue in it, otherwise it can't locate the elements
	we can even identify total number of iFrames by using:
	Int size = driver.findElements(By.tagName("iframe")).size();
	basically, we can switch over the elements and handle frames in Selenium using 3 ways:
	- by Index
	- by Name or Id  -> driver.switchTo().frame("a077aa5e"); //switching the frame by ID
	- by Web Element -> driver.switchTo().frame(WebElement); // properly located element
	to move back to the parent frame, you can either use: switchTo().parentFrame() -or-
	if you want to get back to the main (or most parent) Frame, you can use: switchTo().defaultContent();
	example of working with several frames:
		int size = driver.findElements(By.tagName("iframe")).size();
	    for(int i=0; i<=size; i++){
		driver.switchTo().frame(i);
		int total=driver.findElements(By.xpath("html/body/a/img")).size();
		System.out.println(total);
	    driver.switchTo().defaultContent();

	NOTE -> there are inner & outer frames!
	*/
/** Performed steps:
	0. open url = https://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_attributes_value
	1. click on change theme button (to change background black or white) within main frame
	2. within Frame (needing a switch) - if you'll skip switch you'll get NoSuchElementException: Unable to locate...
	3. fill text (clear + sendKeys) in First & Last name 
	4. click submit button & validate (for some reason it needs to switch to the frame once more)
	5. switch back to main page & re-click theme button to change once more...
 	*/ // Example:
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_attributes_value");
		System.out.println("Test on: " + driver.getCurrentUrl());
		
		// click on Theme Btn -> driver.findElement(By.cssSelector(".w3-bar>[title='Change Theme']")).click();
		WebElement themeBtn = driver.findElement(By.cssSelector(".w3-bar>[title='Change Theme']"));
		themeBtn.click();
		System.out.println("Theme Changed to black");
		// switchTo Frame - by Web Element -> driver.switchTo().frame(WebElement); Needs properly located element before
		WebElement frameElement = driver.findElement(By.cssSelector("#iframewrapper > iframe"));
		driver.switchTo().frame(frameElement);
		System.out.println("Switched To Frame");
		// work within frame
		driver.findElement(By.cssSelector("#fname")).clear();
		driver.findElement(By.cssSelector("#fname")).sendKeys("elad");
		driver.findElement(By.cssSelector("#lname")).clear();
		driver.findElement(By.cssSelector("#lname")).sendKeys("luz");
		System.out.println("Filled Text");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println("Clicked Submit");
		
		/* for some reason I need to switch back & forth to proceed otherwise elements in iFram not located
		   if I don'y go back & forth again, I will get a NoSuchElementException: Unable to locate element!
		   TODO -> understand why context switch needed to relocate elements in frame after submit (is OK)?
		   ----------------------------------------------------------------------------------------------*/
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameElement); //WebElement already found above
		
		// validate: fname=elad & lname=luz within frame
		String result = driver.findElement(By.cssSelector("div.w3-container.w3-large.w3-border")).getText();
		System.out.println(result);
		
		// switch back - move to main window page & re-click theme button
		driver.switchTo().defaultContent();
		// driver.findElement(By.cssSelector(".w3-bar>[title='Change Theme']")).click();
		themeBtn.click(); // using as prev without locating again --> will give you: NoSuchElementException !
		System.out.println("Theme Changed to white");
		
		driver.quit();
		System.out.println("-- end --");
	}
}
