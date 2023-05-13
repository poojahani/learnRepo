package complexProgram;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadFIle {

	public static void main(String[] args) throws Exception {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.foundit.in/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'secondaryBtn')]")).click();
		Thread.sleep(500);
		//sendKeys method---if Type ==File then only this method works  
	//	driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys("C:\\Users\\User\\Downloads\\Resume_PM.pdf");
	//	System.out.println("File has uploaded");
		try {
		//click() method wont work so using javaScript Executor
		WebElement  button=driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		//Robot class works 
	    //1)copy the path, ctl+v,   Enter
		Robot robot =new Robot();
		robot.delay(2000);
		//put path file to clipboard
		StringSelection ss = new StringSelection("C:\\Users\\User\\Downloads\\Resume_PM.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//ctl+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("File has uploaded succesfully printing the text"+button.getAttribute("value"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	//	driver.quit();
	}
		

}
