package shoppingcart.pageobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.AbstractComponents.AbstractComponents;

public class ProductsPage extends AbstractComponents{

	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
//	@FindBy(css=".col-sm-4")
//	List<WebElement> products;

	@FindBy(css=".single-products")
	List<WebElement> products;
	
	@FindBy(id="search_product")
	WebElement searchProduct;
	
	@FindBy(id="submit_search")
	WebElement submit_search;
	
	@FindBy(css=".add-to-cart")
	WebElement AddToCart;
	
	@FindBy(css="p[class='text-center'] a")
	WebElement viewCart;
	
	@FindBy(css="a[href='/product_details/1']")
	WebElement ViewfirstProduct;
	
	@FindBy(xpath="//div[@class='features_items']")
	WebElement ProductListLocator;
	
	@FindBy(xpath="//h2[contains(.,'All Products')]")
	WebElement AllProductsLocator;
	
		
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By addtoCart=By.cssSelector(".add-to-cart");
	By toastContainer=By.cssSelector("#toast-container");
	
	
	public WebElement getProductByName(String productName) {
		return products.stream()
		        .filter(product -> {
		            try {
		                // 3. Find the name within the specific product wrapper
		                return product.findElement(By.cssSelector(".productinfo p"))
		                              .getText().equalsIgnoreCase(productName);
		            } catch (NoSuchElementException e) {
		                return false; // Skip divs that don't have product text
		            }
		        })
		        .findFirst()
		        .orElse(null);
	}
	
	
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	
	
//	public WebElement getProductByName(String productName) {
//		WebElement prod=products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().contains(productName)).findFirst().orElse(null);
//		return prod;
//	}
	
	public CartPage addProductToCart(String productName) throws InterruptedException {
		
		WebElement prod=getProductByName(productName);
		prod.findElement(addtoCart).click();
		//waitForElementToAppear(toastContainer);
		waitForElementToDisappear(spinner);
		viewCart.click();
		return new CartPage(driver);
	}
}
