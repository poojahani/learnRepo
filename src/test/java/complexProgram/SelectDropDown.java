package complexProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		By Cars = By.id("cars");
		By entries = By.name("tablepress-1_length");

		// Select select1 = new Select(driver.findElement(Cars));
		// select1.selectByValue("opel");
		//
		// Select select2 = new Select(driver.findElement(entries));
		// select2.selectByIndex(0);

		// 2 nd method
		// selectByvisibleText(driver,Cars,"Saab") ;
		// selectByvisibleText(driver,entries, "100");

		// 3 rd method
		selectDropDownValue(driver, Cars, DropDown.VALUE.toString(), "audi");
		selectDropDownValue(driver, entries, DropDown.INDEX.toString(), "2");

	}

	public static void selectDropDownValue(WebDriver driver, By locator, String type, String value) {
		Select select = new Select(getElement(driver, locator));

		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("please pass the correct selection criteria ...");

		}

	}

	public static WebElement getElement(WebDriver driver, By loctaor) {
		return driver.findElement(loctaor);

	}

	public static void selectByvisibleText(WebDriver driver, By locator, String value) {
		try {
			Select select = new Select(getElement(driver, locator));
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectByIndex(WebDriver driver, By locator, int value) {
		try {
			Select select = new Select(getElement(driver, locator));
			select.selectByIndex(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectByValue(WebDriver driver, By locator, String value) {
		try {
			Select select = new Select(getElement(driver, locator));
			select.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
