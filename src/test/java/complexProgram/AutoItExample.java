package complexProgram;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoItExample {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(1000);
		WebElement  button=driver.findElement(By.xpath("//div[@class='form-file']/child::label/following-sibling::input[@id='uploadPicture']"));
		//execute script on AutoIt
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(1000);
	//	Runtime.getRuntime().exec("\"C:\\Users\\User\\OneDrive\\Desktop\\FileUpload.exe\"");
		
		
	}

}
