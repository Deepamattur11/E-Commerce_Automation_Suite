package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import shoppingcart.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/login']")
	private WebElement signUpLoginLink;

	public void goTo() {
		driver.get("https://automationexercise.com/");
	}

	public Login_SignUpPage clickOnSignUp() {
		waitForWebElementToAppear(signUpLoginLink);
		signUpLoginLink.click();
		return new Login_SignUpPage(driver);
	}

}
