package HonestFood.honest.finaltest;

import org.testng.Assert;
import org.testng.annotations.Test;

import HonestFood.honest.DataDriver;
import HonestFood.honest.MyTestNGBaseClass;
import HonestFood.honest.pages.CartPage;
import HonestFood.honest.pages.HomePage;



public class TestWeb  extends MyTestNGBaseClass{
		
	static DataDriver obj = new DataDriver();
	
	@Test
	public void validation() throws Throwable{
		
		oExtentTest= oExtentReport.startTest("Add item to cart");
		HomePage obj = new HomePage(oDriver, oExtentReport, oExtentTest);
		Assert.assertTrue(obj.fAddUserForMamacitaBrand());
		
		
		CartPage obj1 = new CartPage(oDriver, oExtentReport, oExtentTest);
		Assert.assertTrue(obj1.fAddAddress());
		Assert.assertTrue(obj1.fAddFoodToCart());
		Assert.assertTrue(obj1.fValidateQuantity());
	
	}

}
