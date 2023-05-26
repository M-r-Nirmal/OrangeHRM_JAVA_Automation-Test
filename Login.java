package testNGPractical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
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

	// without username & Password
	@Test(priority = 2)
	public void ValidationCheck() throws InterruptedException {

		// click on the Sign in button
		WebElement SignInButton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		SignInButton.click();
		Thread.sleep(3000);
		System.out.println("Sign in Button Has Been Clicked Fill Requied Fields");
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	// with Invalid Username & Correct Password
	@Test(priority = 3)
	public void InvalidUsername() throws InterruptedException {
		// enter a username in the email textbox
		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.clear();
		username.sendKeys("Nirmal");
		System.out.println("Worng Username Enterted as Nirmal");

		Thread.sleep(3000);

		// enter a password in the password textbox
		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.clear();
		password.sendKeys("admin123");
		System.out.println("Correct Password Enterted as admin123 ");

		Thread.sleep(3000);

		// click on the Sign in button
		WebElement SignInButton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		SignInButton.click();
		System.out.println("Sign in Button Has Been Clicked");

		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1000);

	}

	// with wrong Password & Correct Username
	@Test(priority = 4)
	public void InvalidPassword() throws InterruptedException {
		Thread.sleep(5000);
		// enter a username in the email textbox
		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.clear();
		username.sendKeys("Admin");
		System.out.println("Correct Username Enterted as Admin");

		Thread.sleep(3000);

		// enter a password in the password textbox
		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.clear();
		password.sendKeys("Nirmal46");
		System.out.println("Incorrect Password Enterted as Nirmal46");

		Thread.sleep(3000);

		// click on the Sign in button
		WebElement SignInButton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		SignInButton.click();
		System.out.println("Sign in Button Has Been Selected");

		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	// Valid Password & Username
	@Test(priority = 5)
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

		Thread.sleep(3000);
	}

	@AfterTest
	public void terminateBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Browser Closed");
	}
}
