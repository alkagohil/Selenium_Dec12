package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class ScreenShotUtitlity {

public String captureScreenshot(WebDriver d)
{
	TakesScreenshot ts = (TakesScreenshot)d;
	File f= ts.getScreenshotAs(OutputType.FILE);
	File target=new File("test-output//screenshots//myscreenshot_"+System.currentTimeMillis()+".png");
	try {
		FileUtils.copyFile(f, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String screenshotPath= target.getAbsolutePath();
	return screenshotPath;
	
}
@Attachment
public byte[] captureScreenshotFile(WebDriver d)
{
	TakesScreenshot ts = (TakesScreenshot)d;
return(ts.getScreenshotAs(OutputType.BYTES));
	
	
}
}
