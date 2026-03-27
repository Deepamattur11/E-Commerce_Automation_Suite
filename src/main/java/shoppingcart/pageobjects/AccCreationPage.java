package shoppingcart.pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import shoppingcart.AbstractComponents.AbstractComponents;

public class AccCreationPage extends AbstractComponents {

	WebDriver driver;

	public AccCreationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(id = "id_gender2")
//	WebElement femaleGender;
	
	@FindBy(xpath="//label[@for='id_gender2']")
	WebElement femaleGender;
	
	@FindBy(xpath="//label[@for='id_gender1']")
	WebElement maleGender;

//	@FindBy(id = "id_gender1")
//	WebElement maleGender;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "days")
	WebElement date;

	@FindBy(id = "months")
	WebElement month;

	@FindBy(id = "years")
	WebElement year;

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(name = "address2")
	WebElement address2;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement mobilenumber;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement createAcc;

	private By accinfoForm = By.xpath("//b[text()='Enter Account Information']");

	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement AccCreatedMsg;
	
	
	@FindBy(css="iframe[id^='aswift']")
	WebElement Adframe;
	

	public String getErrorMessage() {
		waitForElementToBeClickable(AccCreatedMsg);
		String msg = AccCreatedMsg.getText();
		return msg;
	}

	public void waitForaccinfoForm() {
		waitForElementToAppear(accinfoForm);
	}

	public String createAcc(HashMap<String, String> accDetails) {
		waitForaccinfoForm();
		
		String gender = accDetails.get("gender");
		if ("Mrs".equalsIgnoreCase(gender)) {
	        femaleGender.click();
	    } else {
	        maleGender.click(); 
	    }
		pwd.sendKeys(accDetails.get("pwd"));
		Select selectdate = new Select(date);
		selectdate.selectByVisibleText(accDetails.get("day"));
		Select selectmonth = new Select(month);
		selectmonth.selectByVisibleText(accDetails.get("month"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText(accDetails.get("year"));
		firstname.sendKeys(accDetails.get("firstname"));
		lastname.sendKeys(accDetails.get("lastname"));
		address1.sendKeys(accDetails.get("address"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText(accDetails.get("country"));
		state.sendKeys(accDetails.get("state"));
		city.sendKeys(accDetails.get("city"));
		zipcode.sendKeys(accDetails.get("zipcode"));
		mobilenumber.sendKeys(accDetails.get("mobilenumber"));
		waitForElementToDisappear(Adframe);
		createAcc.click();
		String msg = getErrorMessage();
		return msg;
	}
}
