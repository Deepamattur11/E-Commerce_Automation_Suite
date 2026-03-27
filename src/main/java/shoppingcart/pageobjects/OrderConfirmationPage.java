package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents {

	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[text()='Order Placed!']")
	WebElement successMsg;
	
	@FindBy(xpath="//a[text()='Download Invoice']")
	WebElement downloadInvoice;
	
	public String getSuccessMsg() {
		return successMsg.getText();
	}
	
	
}
