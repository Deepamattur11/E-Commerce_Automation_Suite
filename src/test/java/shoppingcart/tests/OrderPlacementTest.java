package shoppingcart.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingcart.pageobjects.CartPage;
import shoppingcart.pageobjects.HomePage;
import shoppingcart.pageobjects.Login_SignUpPage;
import shoppingcart.pageobjects.OrderConfirmationPage;
import shoppingcart.pageobjects.PaymentPage;
import shoppingcart.pageobjects.ProductsPage;
import shoppingcart.TestComponents.BaseTest;

public class OrderPlacementTest extends BaseTest{


	@Test(dataProvider = "getjsonData", groups = { "Search&Order" })
	public void loginUser(HashMap<String, String> Details) throws InterruptedException, IOException {
		Login_SignUpPage loginSignUpPage = landingPage.clickOnSignUp();
		HomePage homePage = loginSignUpPage.login(Details.get("email"), Details.get("pwd"));
		ProductsPage productsPage=homePage.clickOnProductsButton(); 
		forceClearAds();
		CartPage cartPage=productsPage.addProductToCart(Details.get("productName"));
		PaymentPage paymentPage=cartPage.placeOrder();
		OrderConfirmationPage orderConfirmationPage=paymentPage.confirmOrder();
		 Assert.assertEquals(orderConfirmationPage.getSuccessMsg(), "ORDER PLACED!");
		
	}

	
	@DataProvider
	public Object[][] getjsonData() throws IOException {

		List<HashMap<String, String>> data = getJSONDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\shoppingcart\\data\\ProductDetails.json");
		Object[][] dataArray = new Object[data.size()][1];
	    
	    for (int i = 0; i < data.size(); i++) {
	        dataArray[i][0] = data.get(i);
	    }
	    
	    return dataArray;
}
}
