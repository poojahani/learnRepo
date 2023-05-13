package complexProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleFramesAndIframes {

	public static void main(String[] args) throws Exception {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		Thread.sleep(1000);
		driver.switchTo().frame("packageListFrame");
		WebElement frtFrame = driver.findElement(By.xpath("//ul[@title='Packages']/child::li/a[text()='org.openqa.selenium']"));
		frtFrame.click();
		System.out.println("Succesfuly clicked on First Element ");
		driver.switchTo().defaultContent();
		System.out.println("Switched to default frame tab");
		
		driver.switchTo().frame("packageFrame");
		WebElement secFrame =driver.findElement(By.xpath("//ul[@title='Interfaces']/child::li/a[contains(@href,'Alert.html')]"));
		secFrame.click();
		System.out.println("Cliked on Alert link as second Frame as Interface");
		WebElement secFrame2 =driver.findElement(By.xpath("//ul[@Title='Exceptions']/child::li/a[contains(@href,'ElementClickInterceptedException')]"));
		secFrame.click();
		System.out.println("Cliked on  as second Frame as exception");
		driver.switchTo().defaultContent();
		System.out.println("Switched to default frame tab");
		Thread.sleep(1000);
		driver.switchTo().frame("classFrame");
		//driver.switchTo().frame(2);
		Thread.sleep(1000);
		WebElement trdFrame =driver.findElement(By.xpath("//ul[@class='navList']/child::li/a[text()='Use']"));
		 trdFrame.click();
		 System.out.println("Cliked on Help as Third Frame as Use :");
	
		
		driver.quit();
		
    
	}

}
