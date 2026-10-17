package testCases;

import org.testng.annotations.Test;

import pageObjectClasses.CategoryPage;
import pageObjectClasses.CheckOutPage;
import pageObjectClasses.HomePage;
import pageObjectClasses.MyAccountPage;
import pageObjectClasses.ProductPage;
import pageObjectClasses.SignInPage;

public class TC_CheckOutPage extends BaseClass {
	
	@Test
	public void verifyCheckOut() throws Exception
	{
try {
			
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickSignIn();
			
			//SignInPage
			
			SignInPage signin=new SignInPage(driver);
			
			//System.out.println(driver.getCurrentUrl());
			
			signin.enterEmail("saisneha@gmail.com");
			
			signin.enterPassword("Saisneha@9876");
			
			signin.clickLogin();
			
			//MyAccountPage
			
			MyAccountPage  myAccount=new MyAccountPage(driver);
			
			//myAccount.clickBtnCategories();  //clicking categories btn
			
			myAccount.selectCategory("Power Tools");
			
			//category Page
			CategoryPage cp=new CategoryPage(driver);
			cp.clickItem("Sheet Sander");
			
			//ProductPage
			ProductPage pp=new ProductPage(driver);
			  pp.clickAddToCart();
			  pp.clickIconCart();
			
			//CheckOut Page
			  CheckOutPage cp1=new CheckOutPage(driver);
			  cp1.clickCheckOutButton();
			  
}
           catch(Exception e) {

              throw e;
		
		           }
	}

}
