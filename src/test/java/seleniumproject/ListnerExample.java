package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListnerExample {
	WebDriver driver;

	@BeforeClass()
	void setup() throws Exception {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);
	}

	@Test(priority = 1)

	void loginApp() {
		try {
			boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(status, true);
		} catch (Exception e) {
			Assert.fail("logo is not displaying");
		}

	}

	@Test(priority = 2)
	void homePageTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Titles are not matched");
	}

	@AfterClass
	void closeApp() {
		driver.quit();
	}
}
