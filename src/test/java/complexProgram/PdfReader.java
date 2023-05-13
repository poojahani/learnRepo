package complexProgram;

import static org.testng.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PdfReader {

  WebDriver driver;
 // String url ="https://cloud.google.com/docs/security/infrastructure/design/resources/google_infrastructure_whitepaper_fa.pdf";
  String url ="file:///C:/Users/User/Downloads/1458450_OHS_Assessment_Completion_Certificate.pdf";
  @BeforeTest
  
	public void setup() {
	  ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	//	co.setHeadless(true);
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);
		driver.get(url);

	}
  @Test
  public void pdfReaderTest() throws IOException { 
	  
	  URL pdfUrl =new URL(url);	
	  InputStream ip = pdfUrl.openStream();
	  BufferedInputStream bf = new BufferedInputStream(ip);
	  
	  PDDocument pdDocumnet=PDDocument.load(bf);
	  //page Count
	  int pageCount =pdDocumnet.getNumberOfPages();
	  System.out.println("Number of pages :"+pageCount);
	//  Assert.assertEquals(pageCount, 14);
	  
	  
	  //page Context/text
	  System.out.println("The pdf content is *******************");
	  PDFTextStripper pdfStipper = new PDFTextStripper();
	  
	  String pdfText =pdfStipper.getText(pdDocumnet);
	  System.out.println(pdfText);
	  Assert.assertTrue(pdfText.contains("POOJA M"));
	 // Assert.assertTrue(pdfText.contains("Inter-service access management"));
	//  Assert.assertTrue(pdfText.contains("Kubernetes Engine"));
	//  Assert.assertTrue(pdfText.contains("DoS protection"));
	  
	  
	  
	  //point to only perticular page
	//  pdfStipper.setStartPage(2);
	//  String pdfText =pdfStipper.getText(pdDocumnet);
	//  System.out.println(pdfText);
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}
