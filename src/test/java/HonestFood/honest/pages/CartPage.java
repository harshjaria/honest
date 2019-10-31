package HonestFood.honest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CartPage {
	//Page setup
			WebDriver oDriver;
			ExtentReports oExtentReport;
			ExtentTest oExtentTest;
			
			
			
			public CartPage(WebDriver oDriver, ExtentReports oExtentReport, ExtentTest oExtentTest ) {
			 this.oDriver = oDriver;
			 this.oExtentReport = oExtentReport;
			 this.oExtentTest = oExtentTest;
			 
			
			}

			//Objects
			By AddAddress = By.xpath("//input[@id='address-input']");
			By AddAddressButton = By.xpath("//input[@type='submit' and @value='zum menü']");
			
			By Fooditem= By.xpath("//form/a[@title='Cheesy Pork Burrito']/button");
			By Fooditemselect= By.xpath("//div[2]/div[2]/div[1]/div[2]/div/div[2]/div[4]");
			By FinalSubmissionFooditem = By.id("topup-modal--close");
			
			By ItemQuantityAddedtocart = By.xpath("//div/div[3]/div/div[3]/span[@class='item--quantity']");
			//Actions
			
			public boolean fAddAddress() throws InterruptedException {
				
				Thread.sleep(500);
				WebDriverWait wait=new WebDriverWait(oDriver, 100);
				WebElement AddAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AddAddress));
				WebElement AddAddressButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AddAddressButton));
				if(AddAddressElement.isDisplayed()) {
					AddAddressElement.sendKeys("Semperstraße 44, 1180 Wien, Austria");
					AddAddressButtonElement.click();
					oExtentTest.log(LogStatus.PASS,"Address added");
					System.out.println("Address added");
					return true;
				}else {
					oExtentTest.log(LogStatus.FAIL,"Address added");
					return false;
				}
				
			}
			
public boolean fAddFoodToCart() throws InterruptedException {
				
	
	JavascriptExecutor js = (JavascriptExecutor) oDriver;
	WebDriverWait wait=new WebDriverWait(oDriver, 200);
	WebElement WaitingObject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='category--header']/h1[text()=' Burritos']")));
	WebElement FooditemElement = oDriver.findElement(Fooditem);
    js.executeScript("arguments[0].scrollIntoView();", FooditemElement);

	Thread.sleep(500); 
	WebElement FooditemselectElement = oDriver.findElement(Fooditemselect);
	if(FooditemselectElement.isDisplayed()) {
		FooditemselectElement.click();
	    Thread.sleep(500); 
	    WebElement FinalSubmissionFooditemElement = oDriver.findElement(FinalSubmissionFooditem);
	    js.executeScript("arguments[0].scrollIntoView();", FinalSubmissionFooditemElement);
	    FinalSubmissionFooditemElement.click();
		oExtentTest.log(LogStatus.PASS,"Fooditem Added to cart for user");
		System.out.println("Fooditem Added to cart for user");
		return true;
	}else {
		oExtentTest.log(LogStatus.FAIL,"Fooditem Element is not Displayed");
		return false;
	}
	
				
				
			}	


public boolean fValidateQuantity()  {
	
	WebDriverWait wait=new WebDriverWait(oDriver, 300);
	WebElement ItemQuantityAddedtocartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ItemQuantityAddedtocart));
	String Quantity =ItemQuantityAddedtocartElement.getText();
	if(Quantity.equalsIgnoreCase("1x")){
		oExtentTest.log(LogStatus.PASS,"Food item Quantity correct added");
	return true;
}else {
	oExtentTest.log(LogStatus.FAIL,"Food item Quantity wrong added");
	return false;
}
	
	
	
}
}
