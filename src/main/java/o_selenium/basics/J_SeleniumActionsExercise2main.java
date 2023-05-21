package o_selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class J_SeleniumActionsExercise2main {
/** Performed the same as in J_SeleniumActionsExercise2, but divided to: main + jobs
 	*/
	public static void main(String[] args) throws InterruptedException { // Thread.sleep(1000);
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.wix.com/jobs/locations/tel-aviv");
		Thread.sleep(2000); // ----
		System.out.println("Test on: " + driver.getCurrentUrl());
		// declare, initiate & use jobs from its class' object...
		J_SeleniumActionsExercise2jobs Jobs = new J_SeleniumActionsExercise2jobs(driver);
		Jobs.printAllJobs("engineer"); // given "engineer" to be filtered by that method.
		driver.quit();
		System.out.println("-- end --");
	}
}
