package complexProgram;
/*if we r unable to inspect dropdowns that time that time should pause the page to inspect on the element should fallow the steps are 
 * 1)chrodev --Event Listner --see the dropdown "blur" property remove all 3 coloums
 * 2) go to Source--snippet--run javascript code as debugger; then run snippet BY RIGHT CLICK ON IT   */
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropDownDisapper {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone");
		Thread.sleep(1000);
		String searchElement ="iphone12";
		List<WebElement> sugestList=driver.findElements(By.xpath("//div[contains(@class,'lrtEPN')]"));
		System.out.println("List of all the elements :");
		int count=0;
		for(WebElement list:sugestList) {
			System.out.println(list.getText());
			count++;
		}
		System.out.println("Count of the list is  "+count);
		WebElement clickedEmt=driver.findElement(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']"
				+ "/child::li/div[contains(@data-tkid,'iphone 12 mini')]"));
		String ppp=clickedEmt.getText();
		clickedEmt.click();
		System.out.println("The clicked on the element  text is :"+ppp);
		Thread.sleep(5000);
		WebElement output =driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 12 mini (Blue, 128 GB)')]"));
		String qqq=output.getText();
		System.out.println("Expected element: "+output.getText());
		driver.quit();

	}

}
