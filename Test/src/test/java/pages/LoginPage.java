package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	
public LoginPage() 
{
	PageFactory.initElements(getDriver(),this);
}
	@FindBy(id="Email")
	WebElement Txtbox_Username;
	
	@FindBy(name="Password")
	WebElement Txtbox_Password;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement Btn_Login;
	
	@FindBy(xpath="//a[@href='/customer/info']")
	WebElement Link_Username;
	
	
public String getUsername()
{
	return Link_Username.getText();
}
	
public void enterLoginData(String u,String p)
{
	Txtbox_Username.sendKeys(u);
	Txtbox_Password.sendKeys(p);
	Btn_Login.click();
	
}
	
	
}
