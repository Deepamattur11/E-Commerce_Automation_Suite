package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".check_out")
	WebElement checkout;
	
	@FindBy(xpath="//a[text()='Place Order']")
	WebElement placeOrder;
	
//	@FindBy(css="//a[normalize-space()='Place Order'])[1]")
//	WebElement placeOrder;
	

	
	public PaymentPage placeOrder() {
		checkout.click();
		scrollToElement(placeOrder);
		waitForWebElementToAppear(placeOrder);
		placeOrder.click();
		return new PaymentPage(driver);
	}
}
