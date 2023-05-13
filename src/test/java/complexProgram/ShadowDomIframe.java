package complexProgram;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowDomIframe {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(500);
		
		driver.switchTo().frame("pact");
		System.out.println("Switch to Iframe window");
		Thread.sleep(500);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		WebElement element =(WebElement)js.executeScript("return document.querySelector(\"#snacktime\")"
				+ ".shadowRoot.querySelector(\"#tea\")");
	    
		String text ="arguments[0].setAttribute('value','Green Tea')";
		System.out.println("enter the Green tea as text");
		js.executeScript(text, element);
		
		//for lunch 
		WebElement element2 =(WebElement)js.executeScript("return  document.querySelector(\"#snacktime\")."
				+ "shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
		String lunch ="arguments[0].setAttribute('value','Veg Biriyani')";
		System.out.println(" Entered the Lunch ");
		js.executeScript(lunch, element2);
		
	}

}
