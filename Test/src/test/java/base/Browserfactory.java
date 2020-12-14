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

public class Browserfactory {

	public  static WebDriver createDriver(String url,String browserName,String broswerType,String node)
	{
		WebDriver d=null;
		 EventFiringWebDriver ed;
		 if(browserName.equals("chrome") && broswerType.equals("local") )
		 {
		 System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
		 d=new ChromeDriver();
		 }
		 if(browserName.equals("firefox") && broswerType.equals("local") )
		 {
		 System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
		 d=new ChromeDriver();
		 }
		 if(browserName.equals("chrome") && broswerType.equals("remote") )
		 {
				ChromeOptions o = new ChromeOptions();
				o.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				o.setCapability(CapabilityType.BROWSER_NAME, "chrome");
				URL ip;
				 try {
					 // ip address of Machine B : port for the node
					ip= new URL(node);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ip=null;
				}
				  
				  d=new RemoteWebDriver(ip,o);
		 }
		 if(browserName.equals("firefox") && broswerType.equals("remote") )
		 {
				FirefoxOptions o = new FirefoxOptions();
				o.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				o.setCapability(CapabilityType.BROWSER_NAME, "firefox");
				URL ip;
				 try {
					 // ip address of Machine B : port for the node
					ip= new URL(node);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ip=null;
				}
				  
				  d=new RemoteWebDriver(ip,o);
		 }
		 
		 ed=new EventFiringWebDriver(d);
		 WebDriverListener w = new WebDriverListener();
		 ed.register(w);
		 d=ed;
		 d.manage().window().maximize();
		 d.get(url);
		 return d;
		 
	}
}
