package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_SeleniumElementsByCSS {
/** Locate Element in DOM using By CSS Selector (more examples at the bottom):
	Locate it on Page > right-click on it in chrome browser + select "inspect" to open DevTool & see the element -
	Find the uniqueness of the element (so it will be pinned specifically -> open Find by [ctrl+f] in DevTool Elements
	Note that the Search field is for string, selector or xPath -and- it will work according to your input !
	Also, make sure to use a location method that will stay solid without changes in the future
	Example:
	NEXT button: <input id="next" type="button" class="btn btn-next" name="next" value="Next">
	Could be located by: id= \ type= class= \ name= \ value=
	Upon using By.id, you just use the sting of ID [driver.findElement(By.id("next")).click();]
	But, upon using By.cssSelector -> id = #id [driver.findElement(By.cssSelector("#next")).click(); ]
	Try also on Element in DevTool > right-click copy selector -> paste --> not always works the best!
	Example: <tag id="ID"...> -> DevTool [ctrl+f] Find by: #ID if unique, use By.cssSelector("#ID") !!
	IF you want more flexibility, you can use the other CSS location methods --> see how below :
		-> CSS Selector Syntax - https://www.w3schools.com/cssref/css_selectors.asp
		-> XPath Syntax - https://www.w3schools.com/xml/xpath_syntax.asp (will be shown later-on) ...
	There are 3+1 main rules for Locating Elements using Selectors, in a unique manner which is unlikely to be changed
		- id -> #id --> preferred for mostly being: unique to that element -and- not change tomorrow !!!
		- class name chain -> .cssClassName1.cssClassName2 --> if the several collected classes are unique
		- attribute -> [attribute=value] --> if can only be located by inner attribute (multi: tag[attr1=X][attr2=Y] )
		-> if none works --> combine several of the above, in tree hierarchy of element: trunk (space) branch > leaf !
			[ > ] for stating that the next element is directly below, one level only
			[   ] space between selectors, stating that the next element is somewhat below, one -or- more levels under
			[tag] tag name upon tree hierarchy, sometimes if parent is located, the tag below is enough for uniqueness
		-> if this is also not enough (in a case of <ul> with several <li>) use list of elements -> pick by identifier
			[ :nth-child(1) ] pick the first child of same several located
			Complex combo Selector example: "div .class>a:nth-child(2)" ->
			> pick the 2ed link (a) directly under the element having .class which is under (several layers above) div
	Don't use text to locate because it is not Localization compliment !!!
	Important: if you find it hard to locate, after inspect + DevTool opened, right-click on element & copy selector !
	Note that the above (copy locator) is not the best way - it needs an edit & some-times there are better ways to do
	CSS Selector Reference -> https://www.w3schools.com/cssref/css_selectors.php
	*/
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
		System.out.println("Test on: " + driver.getCurrentUrl());
		// tell the program to stop for a while (in milliseconds) -> Note: sleep requires a "throws"...
		Thread.sleep(1000); // ----
		// find textBox element by tagID (for first & last name + email) -> insert Text to textBoxFields...
		driver.findElement(By.cssSelector("#firstname")).sendKeys("First"); // by # id
		driver.findElement(By.cssSelector("#lastname")).sendKeys("Last");
		driver.findElement(By.cssSelector("#email")).sendKeys("eMail@automation.co.il");
		Thread.sleep(1000); // ----
		// find NEXT button element by Class (more then one use: .class1.class2, and click on it -> next...
		driver.findElement(By.cssSelector(".btn.btn-next")).click(); // by . class btn usually stands for button
		// find BEGINNER button and click on it -> selected... -and- INTERMEDIATE -and- NEXT (this time by Attribute)
		driver.findElement(By.cssSelector(".fa.fa-blind")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector(".fa.fa-child")).click();
		Thread.sleep(1000); // ----
		driver.findElement(By.cssSelector("[name='next']")).click(); // by any [attribute=value"]
		// find textBox element by ID (for address) -> clear existing text (if needed) & insert text...
		driver.findElement(By.cssSelector("#streetname")).clear();
		driver.findElement(By.cssSelector("#streetname")).sendKeys("Street");
		driver.findElement(By.cssSelector("#streetnumber")).sendKeys("0");
		driver.findElement(By.cssSelector("#city")).sendKeys("City");
		// find FINISH button and click on it -> Fin...
		driver.findElement(By.cssSelector("[name='finish']")).click();
		Thread.sleep(1000); // another sleep to see before close all went well...
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
/** More Examples: https://www.w3schools.com/cssref/css_selectors.php
1.
> HTML- We have a tag a with id=help
<a id="help" href="http://www.automation.co.il">click to open help</a> 
> JAVA- find element by the id (in cssSelector we are adding # to define that it is an id)
driver.findElement(By.cssSelector("#help")).click();
2.
> HTML- We have a tag a with class="btn-primary btn-payment"
<button class="btn-primary btn-payment" >click here</button> 
> JAVA- find element by the class name (in cssSelector we are adding '.' to define that it is class)
driver.findElement(By.cssSelector(".btn-primary.btn-payment")).click();
	Note that: if you get several appearances of the same element by locator, you van go up 1 level and ->
	start the locator in the level above & after space (or using > if its 1 level only) chain to it the element needed
	cssSelector(".parentClassA.parentClassB .elementClassA.elementClassB")
	<div class="container">
        <div class="container">Visit us on...
    driver.findElement(By.cssSelector(".container .container"));  [a class container > within a class container]
3.
> HTML- We have a tag a 
<a href="http://www.automation.co.il">click to open help</a>
> JAVA- find element by the tag name a (in cssSelector we just writing the tag name
driver.findElement(By.cssSelector("a")).click();
4.
> HTML- In this example We have 2 tags with the same class and name
<div id="area1">
  <a id="help" href="http://www.automation.co.il">click to open help</a> 
</div>
<div id="area2">
  <a id="help" href="http://www.automation.co.il">click to open help</a> 
</div>
> JAVA- find element by the parent and a tag name
driver.findElement(By.cssSelector("#area1>a")).click();
5.
> HTML- We have a tag a with attribute called for and a value = help
<a for="help" href="http://www.automation.co.il">click to open help</a> 
> JAVA- find element by the attribute and value
driver.findElement(By.cssSelector("[for='help']")).click();
*/
