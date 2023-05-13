package seleniumproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameterization {
	  
	WebDriver driver;
	
	@BeforeClass
	void testqq() {
		ChromeOptions co = new ChromeOptions();
		 co.addArguments("--remote-allow-origins=*");    
			 driver = new ChromeDriver(co);
	}
	@Test(dataProvider ="dp")//here datarovider is a parameter to acheive parameterization
	
	void testLogin(String email,String pwd) throws IOException, InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fprivacy-notice");
		driver.findElement(By.id("Email")).sendKeys(email);
		System.out.println("click on the user  name");
		driver.findElement(By.id("Password")).sendKeys(pwd);
		System.out.println("click on the password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String exp_title="nopCommerce demo store";
		String act_title=driver.getTitle();
		
		
		Assert.assertEquals(exp_title, act_title);
		
		
		
	}
	
	@AfterClass
	void tearDown() {
		
	}
	@DataProvider(name="dp")
	 String[][] loginData()
	{
		
	String data[][]= {{"telecom@gmail.com","null"},
	                  {"abcadmin@gmail.com","test123"},
	                  {"abcrep@gmail.com","tes1t23"},
	                  {"abcsec@gmail.com","tes213"},
	                  {"abcemp@gmail.com","test132"}
			
			
	};
	return data;
	
	}
}
