package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.AccountRegistration;
import pageObjectClasses.HomePage;
import pageObjectClasses.SignInPage;

public class TC_1_AccountRegistration  extends BaseClass{

	
	@Test
	void verifyAccountRegistration()
	{
		try
		{
			// create object for homepage
			
			HomePage hp=new HomePage(driver);
			hp.clickSignIn();   //clicking signIn
			
			SignInPage lp=new SignInPage(driver); //clickinglogin
		    lp.clickRegister();
		    
		    // AccountRegistration
		    AccountRegistration ac=new AccountRegistration(driver);
		    ac.setFirstName(randomAlphabets(6));   //FirstName
		    ac.setLastName(randomAlphabets(4));       //LastName
		    ac.setDob("2001-06-17");      //D.O.B
		    ac.setCountry("India");       // Country
		    ac.setPostalCode(randomNumbers(6));   // Postal COde
		    ac.setHouseNumber(randomNumbers(2));     // HouseNo
		    ac.setStreet(randomAlphabets(8));  // Street
		    ac.setCity(randomAlphabets(8));     // City
		    ac.setState(randomAlphabets(10)); // State
		    ac.setPhoneNum(randomNumbers(10)); // Phone  
		    ac.setEmail("saisneha@gmail.com"); // Email    -randomAlphabets(8)+"@gmail.com"
	ac.setPassword("Saisneha@9876"); // Password  -randomAlphabets(1).toUpperCase()+randomAlphabets(4).toLowerCase()+"@"+randomNumbers(4)
		    ac.clickRegisterButton();     // Register
		    
		    
		    SignInPage sp = new SignInPage(driver);
		    Assert.assertTrue(sp.isLoginPageDisplayed());
			
		}
		catch (Exception e) {
		    e.printStackTrace();
		    throw e;
		}
	}
	
	
}
