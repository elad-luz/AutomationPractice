package o_selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_SeleniumElementsExercise1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/** Perform these steps:
		1. Open this site "https://prd.canvusapps.com/signup" >
		2. Fill in valid email -and- Complete the form with illegal information >
		3. Press the ‘Sign Up’ button (you should get an error) >
		4. Print the text you get in the error message >
		5. Press the ‘already an existing user’ link >
		6. Press the ‘Forgotten Password’ link >
		7. Verify that you are in the ‘Forgot Your Password’ page >
		8. Fill in your email >
		9. Press the ‘Reset Password’ button >
	 	*/// Test Steps below (add sleep if needed):
		// 1
		driver.get("https://prd.canvusapps.com/signup");
		System.out.println("Test on: " + driver.getCurrentUrl());
		Thread.sleep(1000); // ----
		// 2
		WebElement eMail = driver.findElement(By.cssSelector("#user_email"));
		eMail.sendKeys("first.last@mail.com");
		driver.findElement(By.cssSelector("#user_name")).sendKeys("First Last");
		driver.findElement(By.cssSelector("#user_password")).sendKeys("pass0!"); // not matching
		driver.findElement(By.cssSelector("#user_password_confirmation")).sendKeys("pass!0");
		driver.findElement(By.cssSelector("#company_name")).sendKeys("comix.com");
		Thread.sleep(1000); // ----
		// 3
		driver.findElement(By.cssSelector(".submit.btn.btn-primary")).click();
		Thread.sleep(1000); // ----
		// 4
		String errorM = driver.findElement(By.cssSelector(".alert.alert-error.alert-block.error")).getText();
		System.out.println("error message text: " + errorM);
		Thread.sleep(1000); // ----
		// 5
		driver.findElement(By.cssSelector(".span6.text-right small>a")).click();
		Thread.sleep(1000); // ----
		// 6 (if you don't want to locate it by hierarchy: cssSelector(".form-vertical.well p a) -> you can try: linkText
		driver.findElement(By.linkText("forgotten password?")).click(); // note- selected the text of link: By.linkText !
		String validate = driver.findElement(By.cssSelector("h3")).getText(); // to be more precise, use: ".loginForm>h3"
		// 7
		if (validate.equalsIgnoreCase("Forgot Your Password")) {
			System.out.println(validate + " is the proper page");
			// 8
			driver.findElement(By.cssSelector("#email")).sendKeys("first.last@mail.com");
			// 9
			driver.findElement(By.cssSelector("input[type=submit]")).click(); // or use abbreviated way = "[type=submit]"
			Thread.sleep(1000); // ----
			if (driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice")).getText().toLowerCase().contains("mail sent with password")) {
				System.out.println("SUCCESS !!!");
			} else {
				System.out.println("Failed !!!");
			}
		} else {
			System.out.println(validate + " NOT page !!!");
		}
		Thread.sleep(1000); // ----
		// close browser
		driver.quit();
		System.out.println("-- end --");
	}
}
