package shoppingcart.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingcart.TestComponents.BaseTest;
import shoppingcart.pageobjects.AccCreationPage;
import shoppingcart.pageobjects.Login_SignUpPage;

public class RegistrationTest extends BaseTest {

	@Test(dataProvider = "getjsonData", groups = { "Registration" })
	public void registerUser(HashMap<String, String> userDetails) throws InterruptedException, IOException {
		Login_SignUpPage loginSignUpPage = landingPage.clickOnSignUp();
		loginSignUpPage.signUp(userDetails.get("name"), userDetails.get("email"));
		String error = loginSignUpPage.getErrorMessageIfPresent();
	    if (error != null) {
	        System.out.println("SKIP/FAIL: Registration failed for " + userDetails.get("email") + " -> " + error);
	        Assert.fail("Test failed: " + error);
	        return; 
	    }
	    AccCreationPage accCreationPage = new AccCreationPage(driver); 
	    forceClearAds();
	    String accCreationMsg = accCreationPage.createAcc(userDetails);
	    Assert.assertEquals(accCreationMsg, "ACCOUNT CREATED!");
	}

	@DataProvider
	public Object[][] getjsonData() throws IOException {

		List<HashMap<String, String>> data = getJSONDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\shoppingcart\\data\\UserData.json");
		Object[][] dataArray = new Object[data.size()][1];
	    
	    for (int i = 0; i < data.size(); i++) {
	        dataArray[i][0] = data.get(i);
	    }
	    
	    return dataArray;
	//	return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
