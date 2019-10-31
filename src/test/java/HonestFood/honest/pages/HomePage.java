package HonestFood.honest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class HomePage {

	//Page setup
		WebDriver oDriver;
		ExtentReports oExtentReport;
		ExtentTest oExtentTest;
		
		
		
		public HomePage(WebDriver oDriver, ExtentReports oExtentReport, ExtentTest oExtentTest ) {
		 this.oDriver = oDriver;
		 this.oExtentReport = oExtentReport;
		 this.oExtentTest = oExtentTest;
		 
		
		}

		//Objects
		By AddCart = By.xpath("//li[1]/a/span[@class='btn__text' and text()='Zur Speisekarte']");
	//	By RestrauntIcon = By.xpath("//section/div[4]/div/div/a[@href='/speisekarte/mamacita/semperstr/']");
		By Cookieele = By.xpath("//*[@id='cookie-policy']/div/div[2]/button");
		
		By RestrauntIcon = By.xpath("//section/div/div/div/div/div[10]/section/div[2]/div/a");
		
		//UI Methods
		
		public boolean fAddUserForMamacitaBrand()  {
			try {
			WebElement cookieclose = oDriver.findElement(Cookieele);
			cookieclose.click();
			oDriver.switchTo().defaultContent();
		//	((JavascriptExecutor) oDriver).executeScript("window.scrollBy(0,1200)");
			
				Thread.sleep(100);
			
			WebElement restrauntElement = oDriver.findElement(RestrauntIcon);
			WebElement restrauntpara = oDriver.findElement(By.xpath("//section/div/div/div/div/div[10]/section/div[2]/div/p"));
			((JavascriptExecutor) oDriver).executeScript("arguments[0].scrollIntoView();", restrauntpara);
			 
			
			
			if(restrauntElement.isDisplayed()) {
				restrauntElement.click();
				oExtentTest.log(LogStatus.PASS,"Mamacita Brand Added to user");
				System.out.println("Clickon Mamacita Brand");
				return true;
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
				oExtentTest.log(LogStatus.FAIL,"Mamacita Brand icon is not Displayed");
				return false;
			}
			return false;
		}
		
	
}
