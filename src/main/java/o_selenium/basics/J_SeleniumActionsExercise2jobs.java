package o_selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class J_SeleniumActionsExercise2jobs {
/** Performed the same as in J_SeleniumActionsExercise2, but divided to: main + jobs
	 */
	private WebDriver driver;

	public J_SeleniumActionsExercise2jobs(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void printAllJobs(String text) {
		List<WebElement> jobs = driver.findElements(By.cssSelector("li.hover > a"));
		for (WebElement el : jobs) {
			if (el.getText().toLowerCase().contains(text)) {
				System.out.println("- " + el.getText());
			}
		}
	}

}
