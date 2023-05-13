package complexProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Innerframes {

	public static void main(String[] args) throws Exception {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(1000);
		WebElement frame=driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", frame);
		Thread.sleep(500);
		System.out.println("It clicked first Tab");
	    WebElement outerframe =driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
	    driver.switchTo().frame(outerframe);
	    System.out.println("Here we are passing webElement as frame and clicked the Outer Tab");
	    
	    WebElement innerFrame= driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
	    innerFrame.click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello Pooja U r doing good job keep going");
	    

	}

}
