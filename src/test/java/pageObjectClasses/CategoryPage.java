package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends BasePage{

	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Category Heading
	@FindBy(xpath="//h2[contains(text(),'Category')]")
	WebElement categoryHeading;
	
	//Storing all the tools 
	//@FindBy(xpath="//div[@class='col-md-9']//div[@class='container']//a")
	//List<WebElement> allTools;
	
	public boolean isCategoryFound(String str)
	{
		if(categoryHeading.getText().contains(str))
			  return true;
		else
			return false;
		
	}
	
	public void clickItem(String toolName) throws InterruptedException
	{
		
		System.out.println("Before searching products: " + driver.getCurrentUrl());
	   // System.out.println("Tools found: " + allTools.size());
		
	    By allToolsPath=By.cssSelector("a.card");   //By.xpath("//div[@class='col-md-9']//div[@class='container']//a");
	    try {
	        // Wait for product cards to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(allToolsPath));
	    } catch (TimeoutException e) {
	        System.out.println("Cards didn't render on client-side routing. Refreshing page to force API fetch...");
	        
	        // Force Angular to initialize component & pull API data
	        driver.navigate().refresh(); 
	        
	        // Retry wait after refresh
	        wait.until(ExpectedConditions.presenceOfElementLocated(allToolsPath));
	    }
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allToolsPath));
	    List<WebElement> products = driver.findElements(allToolsPath);
	    System.out.println("Products loaded :  " + products.size());
	    
	    boolean itemFound = false;

	   // System.out.println("Contains Sheet Sander = " +   driver.getPageSource().contains("Sheet Sander"));

	    /*wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allToolsPath));
	    List<WebElement> allTools=driver.findElements(allToolsPath);
		 System.out.println("Total tools found: " + allTools.size());  */
		
		for(WebElement tool:products)
		{
			
		     if(tool.getText().contains(toolName))
		     {
		    	 itemFound=true;
		    	 System.out.println("Found matching product: " + toolName);

		            // Scroll element into view (helps prevent click interception)
		           js.executeScript("arguments[0].scrollIntoView({block: 'center'});", tool);

		            // Wait until element is clickable
		            wait.until(ExpectedConditions.elementToBeClickable(tool));
		            
		            try {
		                tool.click();
		            } catch (Exception e) {
		                // Fallback to JS Click if Angular overlays block standard click
		                System.out.println("Standard click intercepted, falling back to JavaScript click...");
		                js.executeScript("arguments[0].click();", tool);
		            }
		            break;
		     }
		}
		if (!itemFound) {
	        throw new RuntimeException("Product with name '" + toolName + "' was not found on the page.");
	    }
	}

}
