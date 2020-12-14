package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	private static final ThreadLocal<WebDriver> drivers=new ThreadLocal<WebDriver>();
	public static EventFiringWebDriver ed;

public WebDriver getDriver()
{
	
	return drivers.get();
	
}

public void intializeBrowser(String url,String browserName,String broswerType,String node)
{
	WebDriver d=Browserfactory.createDriver(url, browserName, broswerType,node);
	drivers.set(d);
}


}
