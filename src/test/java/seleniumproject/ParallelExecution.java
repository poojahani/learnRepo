package seleniumproject;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {

	WebDriver driver;
	
	@BeforeClass()
	@Parameters({"Browser","url"})
	void setup(String br,String appurl) throws Exception{
		if(br.equals("chrome")) {
			ChromeOptions co = new ChromeOptions();
			 co.addArguments("--remote-allow-origins=*");    
			driver =new ChromeDriver(co);
		}else if(br.equals("edge")) {
			driver =new EdgeDriver();
			
		}else {
			driver =new FirefoxDriver();
		}
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(appurl);
		Thread.sleep(5000);
		
	}
	
	@Test(priority=1)
	
	void loginApp() {
		try {
			boolean status =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(status, true);
		}
		catch(Exception e) {
			Assert.fail("logo is not displaying");
		}
		
	}
	@Test(priority=2)
	void homePageTitle()
	{
	Assert.assertEquals(driver.getTitle(), "OrangeHRM","Titles are not matched");	
	}
	
	@AfterClass
	void closeApp()
	{
		driver.quit();
	}
}
