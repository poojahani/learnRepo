package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Selenium_program {

	public static void main(String[] args) throws Exception {
		// WebDriverManager.chromedriver().setup();
		 ChromeOptions co = new ChromeOptions();
	        co.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(co);
	        
		driver.get("http://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
		 String cc=driver.getTitle();
		 String e_cc="OrangeHRM";
		 if(cc.equals(e_cc)) {
			 System.out.println("Test Passed");
		 }else
		 {
			 System.out.println("Test failed");
		 }
		 
		driver.quit();
	
		
		
	
				

	}

}
