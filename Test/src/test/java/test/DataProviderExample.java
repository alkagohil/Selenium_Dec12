package test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderExample {
  @Test(dataProvider = "regData")
  public void regTest(String u,String p,String ph,String n) {
	  System.out.println("Username "+u);
	  System.out.println("Password "+p);
	//  System.out.println("Phone no "+ph);
  }

  @DataProvider
  public Object[][] regData() {
    return new Object[][] {
      new Object[] { "mercury", "mercury123" ,"1234"},
      new Object[] {"Itest@test.com", "Itest@test","34345" },
      new Object[] {"admin", "admin123","34345" },
    };
  }
}
