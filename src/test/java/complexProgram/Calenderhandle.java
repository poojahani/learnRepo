package complexProgram;

import java.time.Duration;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calenderhandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

		selectDate(driver, "29", "February", "2023");

	}

	public static String[] getMonthYear(String monthYearval) {
		return monthYearval.split("");

	}

	public static void selectDate(WebDriver driver, String exDay, String exMonth, String exYear) {
		
		if(exMonth.equals("February")&& Integer.parseInt(exDay)>29) {
			System.out.println("Wrong date please select ");
			return;
		}if(Integer.parseInt(exDay)>31) {
			System.out.println("wrong date please select");
			return;
		}
		String monthYearval = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearval + " printing the the array");// may 2023

		while (!(getMonthYear(monthYearval)[0].equals(exMonth) && getMonthYear(monthYearval)[1].equals(exYear)))	 {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYearval = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthYearval);// may 2023

		} try {
			driver.findElement(By.xpath("//a[text()='" + exDay + "']")).click();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
