package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
		//Email
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	//Password
	@FindBy(xpath="//input[@id='password']")
	WebElement pwd;
	
	@FindBy(xpath="//h3[normalize-space()='Login']")
	WebElement loginHeading;
	
		//RegisterAccount
		@FindBy(xpath="//a[normalize-space()='Register your account']")
		WebElement RegisterAccount;
		
		//Login
		@FindBy(xpath="//input[@value='Login']")
		WebElement login;
		
		//Invalid Email&Password
		@FindBy(xpath="//div[@class='help-block']")
		WebElement wrongFields;
		
		public void enterEmail(String EMAIL)
		{
			waitForElementToBeClickable(email);
			email.sendKeys(EMAIL);
		}
		public void enterPassword(String password)
		{
			waitForElementToBeClickable(pwd);
			   pwd.sendKeys(password);
		}
		
			
		public void clickLogin()
		{
			waitForElementToBeClickable(login); // calling the Wait method which is present in basepage
			login.click();
			
		}
		
		public void clickRegister()
		{
			waitForElementToBeClickable(RegisterAccount);
			RegisterAccount.click();
		}

		
		public boolean isLoginPageDisplayed()
		{
			waitForElementToBeVisible(loginHeading);
		    return loginHeading.isDisplayed();
		}
		
		public void clearFields()
		{
			waitForElementToBeVisible(email);
			waitForElementToBeVisible(pwd);
			email.clear();
			pwd.clear();
			
		}
		public boolean isInvalidEmailPasswordTextPresent()
		{
			waitForElementToBeVisible(wrongFields);
			boolean found=wrongFields.isDisplayed();
			
			return found;
		}
}
