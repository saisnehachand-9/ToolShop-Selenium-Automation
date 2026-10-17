package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.HomePage;
import pageObjectClasses.MyAccountPage;
import pageObjectClasses.SignInPage;

public class TC_Login extends BaseClass {
	
	@Test
	public void verifyLogin()
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		
		SignInPage login=new SignInPage(driver);
		login.enterEmail("saisneha@gmail.com");
		login.enterPassword("Saisneha@9875"); //  6
		
		login.clickLogin();
		
		//MyAccount
		MyAccountPage mp=new MyAccountPage(driver);
		boolean status =mp.isAccountPageExists();
		System.out.println("Status = " + status);
		Assert.assertEquals(status,true); 
		
		
		}
		catch(Exception e )
		{
			Assert.fail();
		}
		
	}

}
