package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	
WebDriver d;
  @Test
  public void chromeTest() {
	  //intialize
	  //d=new ChromeDriver();
	ChromeOptions o = new ChromeOptions();
	o.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	o.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	  //remotWebDriver constructor
	  //1.URL - ip address of the machine
	  //2. object of desired capabilities or ChromeOptions
	 URL ip;
	 try {
		 // ip address of Machine B : port for the node
		ip= new URL("http://172.26.87.81:5544/wd/hub");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ip=null;
	}
	  
	  d=new RemoteWebDriver(ip,o);
  }
}
