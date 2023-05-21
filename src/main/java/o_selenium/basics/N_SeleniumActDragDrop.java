package o_selenium.basics;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class N_SeleniumActDragDrop {
/*	How to do "drag-and-drop" in Selenium - Examples:
		a. https://www.guru99.com/drag-drop-selenium.html
		b. https://www.javatpoint.com/selenium-webdriver-drag-and-drop
		c. https://www.toolsqa.com/selenium-webdriver/drag-and-drop-in-selenium/
		
		// set 2 elements as from & to -> what to drag & drop destination
		Actions act=new Actions(driver); // Using Action class for drag and drop (needs import)
		act.dragAndDrop(from, to).build().perform(); // Dragged and dropped
	*/
/** Performed steps:
	0. open url = https://automation.co.il/tutorials/html/
	1. D&D to do...
 	*/ // Example:
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		// as usual... start with:
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/html");
		System.out.println("Test on: " + driver.getCurrentUrl());
		// print the h1 of page
		String s = driver.findElement(By.cssSelector("h1")).getText();
		System.out.println(s); // "Index of /tutorials/html/"
		
		// click the link with text: DragAndDrop1.html
		// driver.findElement(By.linkText("DragAndDrop1.html")).click(); //   <--------   one of one (try with list)!
		// get all the <a> elements into list & locate + click on it
		List<WebElement> linkList= driver.findElements(By.cssSelector("#table-content a"));
		// also possible by using: driver.findElements(By.tagName("a"));
		
		/** print the list of all items (using for each) -> not as order of appearance in page...
		 	for (WebElement el : linkList) {
				System.out.println(el.getText());
			}
		*/
		// now go over the list and check which link meets my need & click it
		for (int i=0 ; i<linkList.size() ; i++) {
		    if(linkList.get(i).getAttribute("href").contains("DragAndDrop2.html")) {
		        linkList.get(i).click();
		        break;
		    }
		}
		System.out.println(driver.getCurrentUrl()); // https://automation.co.il/tutorials/html/DragAndDrop2.html
		Thread.sleep(5000);
		
		// get all elements in D&D list #1 -> print list (using for each)
		List<WebElement> dd1List= driver.findElements(By.cssSelector("#sortable1 > li"));
		
		// get all elements in D&D list #2 -> print list (using for each)
		List<WebElement> dd2List= driver.findElements(By.cssSelector("#sortable2 > li"));
		
		// print list #1 all items (using regular for loop, to iterate over the list and print all elements)
		System.out.println("Before 1:");
		for (int i = 0; i < dd1List.size(); i++) {
			System.out.println(dd1List.get(i).getText());
		}
		// print list #2 all items (using regular for loop, to iterate over the list and print all elements)
		System.out.println("Before 2:");
		for (int i = 0; i < dd2List.size(); i++) {
			System.out.println(dd2List.get(i).getText());
		}
		// set the 1st in list#1 elements as from -> to be dragged & dropped
		WebElement from = dd1List.get(0);
		

		// set the 2ed in list#2 elements as to -> to be the drop destination
		WebElement to = dd2List.get(1);
		
		//Using Action class for drag and drop
		Actions act=new Actions(driver); // needs: import org.openqa.selenium.interactions.Actions;

		// Dragged and dropped
		act.dragAndDrop(from, to).build().perform();
		
		// print BOTH lists after D&D...
		System.out.println("After 1:");
		List<WebElement> dd1AfterList= driver.findElements(By.cssSelector("#sortable1 > li"));
		for (int i = 0; i < dd1AfterList.size(); i++) {
			System.out.println(dd1AfterList.get(i).getText());
		}
		System.out.println("After 2:");
		List<WebElement> dd2AfterList= driver.findElements(By.cssSelector("#sortable2 > li"));
		for (int i = 0; i < dd2AfterList.size(); i++) {
			System.out.println(dd2AfterList.get(i).getText());
		}
		
		Thread.sleep(10000);
		driver.quit(); // close both tabs
		System.out.println("-- end --");
	}
}
