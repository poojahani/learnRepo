package complexProgram;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
        driver.get("https://the-internet.herokuapp.com/key_presses?");
        Thread.sleep(1000);
        
        Actions act =new Actions(driver);
        
        act.sendKeys(Keys.ENTER).perform();
        
        act.sendKeys(Keys.ALT).build().perform();
        
        act.sendKeys(Keys.BACK_SPACE).perform();
        
        
         
	}

}
