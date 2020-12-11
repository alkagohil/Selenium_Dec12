package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExcelUtility;
import base.TestBase;
import base.TestListener;
import pages.HomePage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends TestBase {
	WebDriver d;
	HomePage h;
	LoginPage l;
	ExcelUtility ex;
	int r=1;
	int resultColumn=2;

  @Test(priority=1,dataProvider="loginData")
  public void loginTest(String u,String p) {
	 h.clickLoginLink();
	 l.enterLoginData(u,p);

	 String ER="Itest@test.com";
	 String AR;
	 try {
		 AR=l.getUsername();
		 h.clickLogout();
		 ex.writeExcel("C:\\alka\\testdata.xls", "LoginData", r, resultColumn, "pass");
	 }
	 catch(Exception e)
	 {
		AR=null; 
		ex.writeExcel("C:\\alka\\testdata.xls", "LoginData", r, resultColumn, "fail");
	 }
	 r=r+1;
	 Assert.assertEquals(AR, ER);
  }	
 /* @Test(priority=2)
  public void loginInvalidData()
  {
	  String ER="Pass";
		 String AR="Pass";
		 Assert.assertEquals(AR, ER);
  }
  @Test(priority=3,dependsOnMethods= {"loginTest"})
  public void loginAdmin()
  {
	  
  }*/
  @DataProvider
  public Object[][] loginData()
  {
	 Object data[][]=ex.readExcel("C:\\alka\\testdata.xls", "LoginData");
	 return data;
  }
  @AfterTest
  public void tearDown()
  {
	 
	  //close only the current window
	//  d.close();
	  
	    }
  

 @BeforeTest
 public void setup()
 {
	 
	 
	
	 initializeDriver("http://demowebshop.tricentis.com/");
	 //normal intialization
	 h=new HomePage();
	l=new LoginPage();
	ex=new ExcelUtility();
	 
	 //intialize the page factory
	//  h=PageFactory.initElements(getDriver(),HomePage.class);
	//  l=PageFactory.initElements(getDriver(),LoginPage.class);
}
}