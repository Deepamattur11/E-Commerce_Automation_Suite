package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="a[href='/products']")
	WebElement ProductsButton;
	
	@FindBy(css="a[href='/view_cart']")
	WebElement CartButton;
	
	@FindBy(css="a[href='/logout']")
	WebElement logoutButton;
	
	@FindBy(css="a[href='/delete_account']")
	WebElement deleteAccButton;
	
	
	public ProductsPage clickOnProductsButton() {
		ProductsButton.click();
		return new ProductsPage(driver);
	
	}
	
//	public CartPage clickOnCart() {
//		CartButton.click();
//		return new CartPage;
//	}
//	
	
}


	