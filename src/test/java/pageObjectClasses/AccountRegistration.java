package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// first name
	@FindBy(xpath="//input[@id='first_name']")
	WebElement txtFname;
	
	//last Name
	 @FindBy(xpath="//input[@id='last_name']")
	 WebElement txtLname;
	 
	 // D.O.B
	 @FindBy(xpath="//input[@id='dob']")
	 WebElement txtDob;
	 
	 //Country
	 @FindBy(xpath="//select[@id='country']")
	 WebElement drpDownCountry;
	 
	 //PostalCode
	 @FindBy(xpath="//input[@id='postal_code']")
	 WebElement txtPostalCode;
	 
	 //housenum
	 @FindBy(xpath="//input[@id='house_number']")
	 WebElement txtHouseNum;
	 
	 //street
	 @FindBy(xpath="//input[@id='street']")
	 WebElement txtStreet;
	 
	 //City
	 @FindBy(xpath="//input[@id='city']")
	 WebElement txtCity;
	 
	 //State
	 @FindBy(xpath="//input[@id='state']")
	 WebElement txtState;
	 
	 //phonenum
	 @FindBy(xpath="//input[@id='phone']")
	 WebElement txtPhoneNum;
	 
	 //email
	 @FindBy(xpath="//input[@id='email']")
	 WebElement txtEmail;
	 
	 //password
	 @FindBy(xpath="//input[@id='password']")
	 WebElement txtPwd;
	 
	 //RegisterButton
	 @FindBy(xpath="//button[normalize-space()='Register']")
	 WebElement btnRegister;
	 
	 public void setFirstName(String fname)
     {
  	  txtFname.sendKeys(fname);
  	  }
	 
	 public void setLastName(String lname)
     {
  	  txtLname.sendKeys(lname);
  	  }
	 
	 public void setDob(String dob)
     {
  	  txtDob.sendKeys(dob);
  	  }
	 
	 public void setCountry(String country)
     {
		 Select drpCountry=new Select(drpDownCountry);
  	  drpCountry.selectByVisibleText(country);
  	  }
	 
	 public void setPostalCode(String pcode)
     {
  	  txtPostalCode.sendKeys(pcode);
  	  }
	 
	 public void setHouseNumber(String HouseNo)
     {
  	  txtHouseNum.sendKeys(HouseNo);
  	  }
	 
	 public void setStreet(String street)
     {
		 txtStreet.sendKeys(street);
  	  }
	 public void setCity(String city)
     {
  	  txtCity.sendKeys(city);
  	  }
	 public void setState(String state)
     {
  	  txtState.sendKeys(state);
  	  }
	 
	 public void setPhoneNum(String phnNo)
     {
  	  txtPhoneNum.sendKeys(phnNo);
  	  }
	 
	 public void setEmail(String email)
     {
  	  txtEmail.sendKeys(email);
  	  }
	 
	 public void setPassword(String pwd)
     {
  	  txtPwd.sendKeys(pwd);
  	  }
	 
	 public void clickRegisterButton()
	 {
		 btnRegister.click();
	 }

}
