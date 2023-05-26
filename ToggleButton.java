package testNGPractical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToggleButton {

	// Global Declaration
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String driverPath = "C:\\Users\\nethr\\eclipse-workspace\\LunchBrowser\\ResourceFiles\\ChromeDriver\\V112.exe";
	public WebDriver driver;

	@BeforeTest
	public void lunchBrowser() {
		System.out.println("launching Chrome Browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		// Define the Web Driver
		driver = new ChromeDriver();
		// Maximize the browser window size
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println("Navigate To OrangHRM Portal");
	}

	@Test(priority = 1)
	public void verfiyHomepgeTittle() throws InterruptedException {
		String expectedTitle = "OrangeHRM";
		String actualTittle = driver.getTitle();
		Assert.assertEquals(actualTittle, actualTittle);
		Thread.sleep(3000);
	}

	// Valid Password & Username
	@Test(priority = 2)
	public void ValidUsernamePassword() throws InterruptedException {
		Thread.sleep(5000);
		// enter a username in the email textbox
		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.clear();
		username.sendKeys("Admin");
		System.out.println("Valid Username Enterted as Admin ");

		Thread.sleep(3000);

		// enter a password in the password textbox
		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.clear();
		password.sendKeys("admin123");
		System.out.println("Valid Password Enterted as admin123 ");

		Thread.sleep(3000);

		// click on the Sign in button
		WebElement SignInButton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		SignInButton.click();
		System.out.println("Sign in Button Has Been Selected");
	}

	// ToggleButtonClick
	@Test(priority = 3)

	public void ToggleButtonClick() throws InterruptedException {
		Thread.sleep(5000);
		// Find the toggle button and verify that it is initially enabled
		WebElement toggleButton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button/i"));
		boolean initialToggleButtonState = toggleButton.isEnabled();
		if (initialToggleButtonState) {
			System.out.println("The toggle button is initially enabled.");
		} else {
			System.out.println("The toggle button is initially disabled.");
		}

		Thread.sleep(3000);

		// Click the toggle button to disable it
		toggleButton.click();
		boolean disabledToggleButtonState = !toggleButton.isEnabled();
		if (disabledToggleButtonState) {
			System.out.println("The toggle button has been disabled.");
		} else {
			System.out.println("The toggle button was not disabled.");
		}
		Thread.sleep(3000);
		// Click the toggle button again to enable it
		toggleButton.click();
		boolean enabledToggleButtonState = toggleButton.isEnabled();
		if (enabledToggleButtonState) {
			System.out.println("The toggle button has been enabled.");
		} else {
			System.out.println("The toggle button was not enabled.");
		}

	}

	@AfterTest
	public void terminateBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Browser Closed");
	}
}
