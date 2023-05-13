package complexProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionMultiple {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://text-compare.com/");
		Thread.sleep(1000);
		
		WebElement  input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement  input2 =driver.findElement(By.id("inputText2"));
		
		Actions act =new Actions(driver);
		
		input1.sendKeys("Welcome to Selenium");
		
		//Ctl+A
		
		act.keyDown(Keys.CONTROL).sendKeys("a");
		act.keyUp(Keys.CONTROL).perform();
		
		//ctl+c
		
		act.keyDown(Keys.CONTROL).sendKeys("c");
		act.keyUp(Keys.CONTROL).perform();
		
		//Tab
	    act.sendKeys(Keys.TAB).perform();
		
		//ctc+v
		
		act.keyDown(Keys.CONTROL).sendKeys("v");
		act.keyUp(Keys.CONTROL).perform();
		
		//comapare text
		if(input1.getAttribute("value").equals(input2.getAttribute("value"))) {
			System.out.println("texts are equal");
		}else {
			System.out.println("textes are not equal");
		}
		
		
		
		
		

		
	}

}
