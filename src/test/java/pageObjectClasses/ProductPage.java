package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage  extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//productName
	@FindBy(xpath="//h1[@data-test=\"product-name\"]")
	WebElement productName;
	
	//product Price
	@FindBy(xpath="//span[@aria-label='unit-price']")
	WebElement productPrice;
	
	//AddToCart
	@FindBy(xpath="//button[@id='btn-add-to-cart']")
	WebElement btnAddCart;
	
	//CartSymbol
	@FindBy(xpath="//a[@aria-label='cart']")
	WebElement iconCart;
	
	
	public boolean checkProductName(String str)
	{
	  
		
		waitForElementToBeVisible(productName);
		//System.out.println("productName : "+productName.getText());
		if(productName.getText().equalsIgnoreCase(str))
			 return true;
		else
			return false;
		
	}
	
    public void clickAddToCart()
    {
    	waitForElementToBeClickable(btnAddCart);
    	btnAddCart.click();
    }
    
    public void clickIconCart()
    {
    	waitForElementToBeClickable(iconCart);
    	//iconCart.click();
    	js.executeScript("arguments[0].click()",iconCart);
    }
}
