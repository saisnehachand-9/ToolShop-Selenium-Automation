package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class checkOut2ndStep_SignIn  extends BasePage {

	public checkOut2ndStep_SignIn(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Login
	@FindBy(xpath="//h3[normalize-space()='Login']")
	WebElement loginHeading;
	
	//Email
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	//PassWord
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	//LoginBtn
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	
     // 2 - ProceedToCheckOut
	
	@FindBy(xpath="//div[@class='float-end ng-star-inserted']//button[@type='button'][normalize-space()='Proceed to checkout']")
	WebElement btnCheckOut1;
	
	//HouseNumber
	@FindBy(xpath="//input[@id='house_number']")
	WebElement txtHouseNum;
	
	//Checkout Button2
	@FindBy(xpath="//app-address//button[@type='button'][normalize-space()='Proceed to checkout']")
	WebElement btnCheckOut2;
	
	//Street
	@FindBy(xpath="//input[@id='street']")
	WebElement Street;
	
	//Street
		@FindBy(xpath="//input[@id='city']")
		WebElement City;
		
		//Street
		@FindBy(xpath="//input[@id='state']")
		WebElement State;
		
		//Payment Method
		@FindBy(xpath="//select[@id='payment-method']")
		WebElement paymentMethod;
		
		//confirm Button
		@FindBy(xpath="//button[normalize-space()='Confirm']")
		WebElement btnConfirm;
		
		//Payment successfulMessage
		@FindBy(xpath="//div[@class='help-block']")
		WebElement paymentMsg;
		
		
	public boolean checkLoginHeadingExists()
	{
		waitForElementToBeVisible(loginHeading);
		return (loginHeading.isDisplayed());
	}
	
	public void enterEmail(String email)
	{
		waitForElementToBeVisible(Email);
		Email.sendKeys(email);
	}
	public void enterPassword(String pwd)
	{
		waitForElementToBeVisible(Email);
		Password.sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		waitForElementToBeClickable(loginBtn);
		
		loginBtn.click();
	}
	
	public void click_ProceedToCheckOut1()
	{
		
		waitForElementToBeClickable(btnCheckOut1);
		btnCheckOut1.click();
	}
	
	public void enterHouseNo(String hno)
	{
		// 1. Wait until house number field is visible
	    WebElement houseInput = wait.until(ExpectedConditions.visibilityOf(txtHouseNum));

	    // 2. Set value using Native Prototype Setter (Prevents Angular from erasing it)
	    txtHouseNum.clear();
	    txtHouseNum.sendKeys(hno);
	    
	    // 2. CRITICAL: Tab out of the field to trigger Angular's blur event & auto-fill
	    txtHouseNum.sendKeys(Keys.TAB);
	    
		waitForAttributeToBeNotEmpty(Street);
		System.out.println(Street.getAttribute("value"));
		waitForAttributeToBeNotEmpty(City);
		System.out.println(City.getAttribute("value"));
		waitForAttributeToBeNotEmpty(State);
		System.out.println(State.getAttribute("value"));
		
		txtHouseNum.sendKeys(hno);
	
	}
	public void click_ProceedToCheckOut2()
	{
		
		try {
	        // Try standard Selenium click first
	        waitForElementToBeClickable(btnCheckOut2);
	        btnCheckOut2.click();
	    } catch (Exception e) {
	        // Fallback: Force click if Angular DOM disabled state lags behind
	       
	        js.executeScript("arguments[0].click();", btnCheckOut2);
	    }
		// Verify navigation actually occurred to Step 3
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("app-payment, [data-test='payment-method']")
	    ));

	}
	  public void setPaymentMethod(String PaymentType)
	  {
		  Select drpPayment=new Select(paymentMethod);
		  
		  drpPayment.selectByVisibleText(PaymentType);
		  
	  }
	  
	  public void clickConfirm()
	  {
		  waitForElementToBeClickable(btnConfirm);
		  btnConfirm.click();
		  
	  }
	
	  public boolean checkPaymenetStatus()
	  {
		  waitForElementToBeVisible(paymentMsg);
		  boolean found=paymentMsg.isDisplayed();
		  return found;
	  }
	
}
