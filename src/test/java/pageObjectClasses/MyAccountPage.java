package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 
	
	//MyAccount Text
	@FindBy(xpath="//h1[normalize-space()='My account']")
	WebElement msgHeading;
	
	//Categories
	@FindBy(xpath="//button[normalize-space()='Categories']")   // giving staleelement exception
	WebElement btnCategories;
	
	//categoriesList
	/*@FindBy(xpath="//ul[@aria-label='nav-categories']//li")
	List<WebElement> categoryList;
	*/
	
	// AccountHolderName
	@FindBy(xpath="//button[@id='menu']")
	WebElement accountHolderName;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']//a")
	List<WebElement> menu;
	
	//SignoutLink
	@FindBy(xpath="//a[normalize-space()='Sign out']")
	WebElement signOut;
	
  
	public boolean isAccountPageExists()
	{
		try
		{
			
			waitForElementToBeVisible(msgHeading);
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickBtnCategories()
	{
		waitForElementToBeClickable(btnCategories);
		btnCategories.click();
	}
	
	public void selectCategory(String category) {
		String slug = category.toLowerCase().trim().replace(" ", "-");
	    
	    // Direct URL navigation triggers clean backend API fetch
	    driver.get("https://practicesoftwaretesting.com/category/" + slug);

	    // Waits to ensure page & products loaded completely
	    wait.until(ExpectedConditions.urlContains("/category/" + slug));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("h2[data-test='page-title']")));
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.cssSelector("a.card")));
	}
	
	
	public void clickSignOut()
	{
		waitForElementToBeVisible(accountHolderName);
		accountHolderName.click();
		waitForAllElementsToBeVisible(menu);
		signOut.click();
		
		
	}
}
