package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
WebDriver driver;
public HomePage()
{
	this.driver=getDriver();
	PageFactory.initElements(driver,this);
}
	
@FindBy(linkText="Log in") 
public WebElement Link_Login;
@FindBy(linkText="Log out") 
public WebElement Link_Logout;

public void clickLoginLink()
{
	Link_Login.click();
	
}
public void clickLogout()
{
	Link_Logout.click();
	}

	//d.findElement(By.linkText("Log in")).click();
}
