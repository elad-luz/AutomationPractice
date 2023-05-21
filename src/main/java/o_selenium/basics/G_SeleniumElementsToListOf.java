package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class G_SeleniumElementsToListOf {
	/** working with findElements (s = plural) -> putting a bunch of elements, into a List of W.Es.
	 	COLLECTION is framework that provide architecture to store & manipulate a group of objects:
		list: is a bit different from regular array, it is more flexible, and is easier to operate!
		using collection you don't need to pre-define a size, you create the object & add \ remove.
		list, is also an object by itself & can use predefined methods imported as a class of util:
	 	-> import java.util.List; // import the List class to work with
		-> List<data-type> listName = new ArrayList<data-type>(); // List deceleration & Initiation
		Using findElements() for list is not as using findElement() stand-alone
		- no element found returns an empty list (not an exception)
		- 1 el found return list with 1 element in it
		- many el found return list of all matching elements in it by location order
		_____________
		MORE Locators
		name
		tag name -> 
		className
		linkText -> driver.findElement(By.linkText(“Element LINKTEXT”));
		partialLinkText -> driver.findElement(By.partialLinkText(“Element LINKTEXT”));
		*/
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** On  ebay - perform search & work on the list of results:
	 	*/ // browse to site
		driver.get("https://www.ebay.com/sch/ebayadvsearch");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// search for 'tent'
		driver.findElement(By.cssSelector("#_nkw")).sendKeys("tent");
		driver.findElement(By.cssSelector(".btn.btn-prim")).click();
		// get list of all results (there's many) links (a) [residing within the div with class, under div with id]
		List<WebElement> list = driver.findElements(By.cssSelector("#srp-river-results .s-item__info.clearfix>a"));
		// print the total length of the list (of all results in page)
		System.out.println("length of all results in page: " + list.size());
		// print the list of all items (using for each) -> not as order of appearance in page...
		for (WebElement el : list) {
			System.out.println(el.getText());
		}
		System.out.println(" -- end of for each -- \n");
		// print the list of all items (using regular for loop, to iterate over the list and print all elements)
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		System.out.println(" -- end of for loop -- \n");
		// click on one of the elements (2ed in list) -> it is being opened in a New Page (not in focus)
		System.out.println(list.get(2).getText());
		list.get(2).click();
		System.out.println("page was opened");
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
