package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
	public static WebDriver d;
	public static EventFiringWebDriver ed;

public WebDriver getDriver()
{
	
	return d;
	
}

public void initializeDriver(String url)
{
	 //tell the path of drivers to selenium

	 System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
	 d=new ChromeDriver();
	 ed=new EventFiringWebDriver(d);
	 WebDriverListener w = new WebDriverListener();
	 ed.register(w);
	 d=ed;
	 d.manage().window().maximize();
	 d.get(url);
	 
}


}
