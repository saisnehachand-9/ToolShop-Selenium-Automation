package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//CheckOutButton
	@FindBy(xpath="//div[@class='d-flex justify-content-between ng-star-inserted']//button[@type='button'][normalize-space()='Proceed to checkout']")
	WebElement btnCheckOut;
	
	
	public void clickCheckOutButton()

	{
		waitForElementToBeClickable(btnCheckOut);
		btnCheckOut.click();
	}

	public boolean isProceedToCheckoutPresent()
	{
		waitForElementToBeVisible(btnCheckOut);
		return (btnCheckOut.isDisplayed());
	}
}
