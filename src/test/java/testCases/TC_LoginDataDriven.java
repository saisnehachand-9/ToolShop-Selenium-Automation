package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjectClasses.HomePage;
import pageObjectClasses.MyAccountPage;
import pageObjectClasses.SignInPage;

public class TC_LoginDataDriven extends BaseClass  {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verifyLoginDataDriven(String email,String pwd,String expected_res)
	{
		
		try {
			HomePage hp=new HomePage(driver);
			hp.clickSignIn();
			
			SignInPage login=new SignInPage(driver);
			
			//System.out.println("Status = " + targetPage);
			if(expected_res.equalsIgnoreCase("Valid"))
			{
				login.enterEmail(email);
				login.enterPassword(pwd);
				login.clickLogin();
				//MyAccount
				MyAccountPage mp=new MyAccountPage(driver);
				boolean targetPage =mp.isAccountPageExists();
				
				if(targetPage==true) {
					mp.clickSignOut();
					Assert.assertTrue(true);
				}
				else
					Assert.assertTrue(false);
					
		      }
		   
			
			if(expected_res.equalsIgnoreCase("Invalid"))
			{
				login.clearFields();
				login.enterEmail(email);
				login.enterPassword(pwd);
				login.clickLogin();
				boolean present=login.isInvalidEmailPasswordTextPresent();
				if(present==true)
				  Assert.assertTrue(false);
				else
					 Assert.assertTrue(true); 
				
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
		
		
	