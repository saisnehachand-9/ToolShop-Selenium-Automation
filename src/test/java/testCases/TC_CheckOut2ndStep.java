package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.CategoryPage;
import pageObjectClasses.CheckOutPage;
import pageObjectClasses.HomePage;
import pageObjectClasses.MyAccountPage;
import pageObjectClasses.ProductPage;
import pageObjectClasses.SignInPage;
import pageObjectClasses.checkOut2ndStep_SignIn;

public class TC_CheckOut2ndStep extends BaseClass {
	
	@Test
	public void verifyCheckOut2ndStep() throws Exception
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
			  
			  //checkOut2ndPage
			  checkOut2ndStep_SignIn csi=new checkOut2ndStep_SignIn(driver);
			  if(csi.checkLoginHeadingExists())
			  {
				  csi.enterEmail("saisneha@gmail.com");
				  csi.enterPassword("Saisneha@9876");
				  csi.clickLoginBtn();
				  csi.click_ProceedToCheckOut1();
				  csi.enterHouseNo("24");
				  csi.click_ProceedToCheckOut2();
				  csi.setPaymentMethod("Cash on Delivery");
				  csi.clickConfirm();
				  
				 Assert.assertTrue(csi.checkPaymenetStatus()); 
			  }
			  
			  
			  
}
           catch(Exception e) {

              throw e;
		
		           }
	
		
		
		
		
	}

}
