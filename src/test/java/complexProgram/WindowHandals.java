package complexProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandals {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		Thread.sleep(1000);
		String parentWindowId = driver.getWindowHandle();
		// driver.findElement(By.xpath("(//*[local-name()='svg'])[1]")).click(); //if
		// index not need
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer']"
				+ "//div/child::a[contains(@href,'linkedin')]//*[local-name()='svg']")).click();
		Thread.sleep(500);
		System.out.println("Clicked on Linkedin Page");
		driver.findElement(By.xpath("(//*[local-name()='svg'])[2]")).click();
		System.out.println("Clicked on faceBook Page");
		driver.findElement(By.xpath("(//*[local-name()='svg'])[3]")).click();
		System.out.println("Clicked on Twitter Page");
		driver.findElement(By.xpath("(//*[local-name()='svg'])[4]")).click();
		System.out.println("Clicked on Utube Page");
		Set<String> handles = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(handles);
		SwithToRightWindow(driver, "twitter", hList);
		System.out.println(" : " + driver.getTitle());
		getParentWindow(driver, parentWindowId);
		System.out.println(driver.getTitle());
		closeAllWindow(driver, hList, parentWindowId);

	}

	public static void getParentWindow(WebDriver driver, String parentWindowId) {
		driver.switchTo().window(parentWindowId);
	}

	public static void closeAllWindow(WebDriver driver, List<String> hList, String parentWindowId) {
		for (String e : hList) {
			if (!e.equals(parentWindowId)) {
				driver.switchTo().window(e).close();
			}
		}
	}

	public static boolean SwithToRightWindow(WebDriver driver, String windowTitle, List<String> hList) {
		for (String e : hList) {
			String title = driver.switchTo().window(e).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("found the Right Window....");
				return true;
			}
		}
		return false;

	}
}


