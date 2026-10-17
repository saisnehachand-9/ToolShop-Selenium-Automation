package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.CategoryPage;
import pageObjectClasses.HomePage;
import pageObjectClasses.MyAccountPage;
import pageObjectClasses.SignInPage;

public class TC_MyAccount extends BaseClass {
	
	
	@Test
	public void verifyCategoriesSection() throws Exception
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		
		
		SignInPage signin=new SignInPage(driver);
		
		//System.out.println(driver.getCurrentUrl());
		
		signin.enterEmail("saisneha@gmail.com");
		
		signin.enterPassword("Saisneha@9876");
		
		signin.clickLogin();
		
		MyAccountPage  myAccount=new MyAccountPage(driver);
		
		myAccount.clickBtnCategories();  //clicking categories btn
		
		Thread.sleep(3000); 
		
		myAccount.selectCategory("Power Tools");
		Thread.sleep(3000); 
		
		// getting whether it found the category or not
		
		CategoryPage cat=new CategoryPage(driver);
		boolean found=cat.isCategoryFound("Power Tools");
		Assert.assertEquals(found, true);
		
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

}
