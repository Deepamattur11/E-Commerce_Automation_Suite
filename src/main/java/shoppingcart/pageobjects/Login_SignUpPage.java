package shoppingcart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingcart.AbstractComponents.AbstractComponents;

public class Login_SignUpPage extends AbstractComponents {

	WebDriver driver;

	public Login_SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	@FindBy(name = "name")
	WebElement userName;

	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement loginPwd;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginButton;
	
	
	
	
	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signUpButton;

	private By SignUpForm = By.cssSelector(".signup-form");
	
	private By loginForm = By.cssSelector(".login-form");
	
	@FindBy(xpath = "//p[contains(text(),'Email Address already exist')]")
	WebElement emailExistError;

	public void waitForSignUpForm() {
		waitForElementToAppear(SignUpForm);
	}

	public void signUp(String name, String email) {
		waitForSignUpForm();
		userName.sendKeys(name);
		userEmail.sendKeys(email);
		signUpButton.click();
		
	}
	
	public String getErrorMessageIfPresent() {
	    try {
	        // Use a short explicit wait to check if the error pops up
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        shortWait.until(ExpectedConditions.visibilityOf(emailExistError));
	        return emailExistError.getText();
	    } catch (Exception e) {
	        return null; // No error appeared, registration can proceed
	    }
	}

	public void waitForLoginForm() {
		waitForElementToAppear(loginForm);
	}
	
	public HomePage login(String email,String pwd) {
		waitForLoginForm();
		loginEmail.sendKeys(email);
		loginPwd.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
		
	}
	
}
