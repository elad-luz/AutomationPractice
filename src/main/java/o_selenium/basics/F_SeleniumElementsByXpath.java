package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F_SeleniumElementsByXpath {
/** Locate Element in DOM using By Xpath (more complicated then CSS selectors):
	HTML is actually an XML with saved words...
	XPath: query language to identify elements from an XML forming a path from the start -
	Allows you to navigate up the DOM when looking for elements to test...
	Creating in XPath is more flexible than in CSS Selector (but can easily brake upon changes) -
	When you don’t know the name of element, you can use contains to search for possible matches.
	- Syntax: //*[something] > meaning start from top & go down x levels till reaching something!
						.//tagName[@attribute='value']
						//*[contains(@id,'wrapper')]
						//body/*[contains(text(),'ad')]
						//div[@class='bubble-title' and contains(text(), 'Cover')]
	partial match:		//span[contains(text(), 'Assign Rate')]
	starts-with:		//input[starts-with(@id,'reportcombo')
	Why CSS (instead of Xpath)? -- Advantages of Using CSS Selector:
		It’s faster than XPath.
		It’s Simpler than XPath & much easier to learn and implement.
		You have a high chance of finding your elements.
		It’s compatible with most browsers to date.
	-> https://www.testim.io/blog/xpath-vs-css-selector-difference-choose/
	NOTE: use Relative path to node (not the Absolute one, starting from body) - Syntax Diff:
			|	Xpath							|	CSS
			|	//*[@id='id']					|	#id
			|	//*[@class='class1']			|	.class1
			|	//*[@attribute='value']			|	[attribute='value']
			|	/								|	>
			|	/* /							|	space
			|	[2]								|	:nth-child(2)
			|	.//tagName						|	tagName
			|	.//tagName[@attribute='value']	|	tagName[attribute='value']
			|	../		(climb up to parent)	|	in CSS you can't locate child & climb up to parent	
	NOTE: You can use attribute without value a[href] -or- with empty value input[checked='']
 	*/
	public static void main(String[] args) throws InterruptedException {
	/** Performed steps:
		0. Must run this on Chrome in, 100% !
		1. Open "https://login.salesforce.com"
		2. Fill in the User + Password + Remember me (check)
		3. Click on ‘Login’ button
		4. Get the error message and print it.
		5. Click the ‘Forgot your password’ link
		6. Insert your name
		7. Click on ‘Continue’ button
		8. Get the error message and print it
	 	*/
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		System.out.println("Test on: " + driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("user.name@salesforce.com"); // id
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("pass!1");
		driver.findElement(By.xpath("//*[@id='rememberUn']")).click();
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		Thread.sleep(2000); // ----
		String error = driver.findElement(By.xpath("//*[@id='error']")).getText();
		System.out.println("login error:\n" + error);
		driver.findElement(By.xpath("//*[@id='forgot_password_link']")).click();
		Thread.sleep(2000); // ----
		driver.findElement(By.xpath("//*[@id='un']")).sendKeys("user.name@salesforce.com");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		Thread.sleep(2000); // ----
		String message = driver.findElement(By.xpath("//*[@class='message']")).getText(); // class
		System.out.println("reset password message:\n" + message);
		Thread.sleep(2000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
	// method out of main to be used for ...
}
