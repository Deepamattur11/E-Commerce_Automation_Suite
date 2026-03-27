package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents{

	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name_on_card")
	WebElement name_on_card;
	
	@FindBy(name="card_number")
	WebElement card_number;
	
	@FindBy(name="cvc")
	WebElement cvc;
	
	@FindBy(name="expiry_month")
	WebElement expiry_month;
	
	@FindBy(name="expiry_year")
	WebElement expiry_year;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement confirmOrder;
	
	@FindBy(css="#success_message")
	WebElement successMsgEle;
	
	
	public void enterPaymentDetails() {
		name_on_card.sendKeys("Deepa");
		card_number.sendKeys("12344567890");
		cvc.sendKeys("123");
		expiry_month.sendKeys("10");
		expiry_year.sendKeys("2026");
		
	}
	
	public OrderConfirmationPage confirmOrder() {
		enterPaymentDetails();
		scrollToElement(confirmOrder);
		confirmOrder.click();
		return  new OrderConfirmationPage(driver);
	}
	
	
}
