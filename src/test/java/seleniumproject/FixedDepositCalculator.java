package seleniumproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

		driver.manage().window().maximize();

		String file = System.getProperty("user.dir") + "\\testdata\\please.xlsx";

		int row = ExcelUtility.getRowCount(file, "Sheet1");

		for (int i = 1; i <= row; i++) {
			// read the data from excel and pass the same data and do the validation
			String prince = ExcelUtility.getCellData(file, "Sheet1", i, 0);
			String rateofIntrest = ExcelUtility.getCellData(file, "Sheet1", i, 1);
			String per1 = ExcelUtility.getCellData(file, "Sheet1", i, 2);
			String per2 = ExcelUtility.getCellData(file, "Sheet1", i, 3);
			String frequency = ExcelUtility.getCellData(file, "Sheet1", i, 4);
			String exp_value = ExcelUtility.getCellData(file, "Sheet1", i, 5);
			// pass the data
			driver.findElement(By.xpath("//input[@id=\"principal\"]")).sendKeys(prince);
			driver.findElement(By.id("interest")).sendKeys(rateofIntrest);
			driver.findElement(By.id("tenure")).sendKeys(per1);

			Select perdrp = new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);

			Select drpfre = new Select(driver.findElement(By.id("frequency")));
			drpfre.selectByVisibleText(frequency);
            Thread.sleep(4000);
            JavascriptExecutor js =(JavascriptExecutor)driver;
            WebElement calculate_btn=driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
			js.executeScript("arguments[0].click();",calculate_btn);
			 Thread.sleep(4000);
			// validation and update in excel
          
           
			String act_value = driver.findElement(By.xpath("(//span[@id='resp_matval'])[1]")).getText();

			if (Double.parseDouble(exp_value) == Double.parseDouble(act_value)) {
				System.out.println("Test passed");
				ExcelUtility.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtility.fillGreenColor(file, "Sheet1", row, 7);
			} else {
				System.out.println("Test failed");
			ExcelUtility.setCellData(file, "Sheet1", i, 7, "failed");
			ExcelUtility.fillRedColor(file, "Sheet1", row, 7);

		}
			Thread.sleep(3000);
	WebElement clear_btn=driver.findElement(By.xpath("//img[@class='PL5']"));
	js.executeScript("arguments[0].click();",clear_btn);

	}
	}
	
}
