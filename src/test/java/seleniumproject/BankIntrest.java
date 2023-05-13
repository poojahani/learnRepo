package seleniumproject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.model.CalculationChain;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankIntrest {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

		driver.manage().window().maximize();

		WebElement inideposit = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement length = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement apr = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement callbtn = driver
				.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']"));
		System.out.println("user has defined all elements to calculate CD");

		String file = System.getProperty("user.dir") + "\\testdata\\Book2.xlsx";
		int row = ExcelUtility.getRowCount(file, "Sheet1");
		System.out.println("Row count is :" + row);

		for (int i = 1; i <= row; i++) {
			// reading data from excel
			String init_dep = ExcelUtility.getCellData(file, "Sheet1", i, 0);
			String int_rat = ExcelUtility.getCellData(file, "Sheet1", i, 1);
			String len = ExcelUtility.getCellData(file, "Sheet1", i, 2);
			String comp = ExcelUtility.getCellData(file, "Sheet1", i, 3);
			String exp_val = ExcelUtility.getCellData(file, "Sheet1", i, 4);
			System.out.println("Expected value will be compared to actaul value");
             
			inideposit.clear();
			length.clear();
			apr.clear();
			Thread.sleep(4000);

			inideposit.sendKeys(init_dep);
			length.sendKeys(len);
			apr.sendKeys(int_rat);

			// Dropdown (Bootstrap)-Not having select Tag

			WebElement compounddrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
			// select the drp down by using id
			compounddrp.click();

			List<WebElement> options = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));

			for (WebElement Option : options) {
				if (Option.getText().equals(comp)) {
					Option.click();
				}
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();",callbtn);
				//callbtn.click();

			}

			String act_value = driver.findElement(By.xpath("(//span[@id='displayTotalValue'])")).getText();
			System.out.println("Actual total is :" + act_value);

			System.out.println("Expected total is :" + exp_val);

			if (act_value.equals(exp_val)) {
				ExcelUtility.setCellData(file, "Sheet1", i, 6, "passed");
				ExcelUtility.fillGreenColor(file, "Shhet1", i, 6);
			} else {
				ExcelUtility.setCellData(file, "Sheet1", i, 6, "Failed");
				ExcelUtility.fillRedColor(file, "Shhet1", i, 6);
				
			}

		}
		System.out.println("calculation has completed ***");
   
		driver.close();

	}

}
