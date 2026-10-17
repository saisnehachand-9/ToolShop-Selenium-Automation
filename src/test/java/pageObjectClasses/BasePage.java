package pageObjectClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	 WebDriverWait wait ;
	 JavascriptExecutor js;
	BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		js=(JavascriptExecutor)driver;
	}

	public void waitForElementToBeClickable(WebElement element) {
       
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	public void waitForElementToBeVisible(WebElement element) {
        
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	
public void waitForAllElementsToBeVisible(List<WebElement> categoryList) {
        
        wait.until(ExpectedConditions.visibilityOfAllElements(categoryList));
    }
public void waitForAttributeToBeNotEmpty(WebElement element) {
    
    wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
}
}
