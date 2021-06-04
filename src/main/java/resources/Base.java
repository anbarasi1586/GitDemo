package resources;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;




public class Base {
	
	//Variable declaration
	public WebDriver driver;
	public Properties property;
	//Using property file for Data
	
			
	public WebDriver BrowserInit() throws IOException {
		
		property = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Anbu\\Selenium\\E2EFramework\\src\\main\\java\\Resources\\Data");
		
		property.load(fis);
		
		String sBrowser = property.getProperty("browser");	
		
		//System.out.println(property.getProperty("url"));
	//Browser Chrome	
		if(sBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Anbu\\Selenium\\Driver\\ChromeDriver\\chromedriver.exe");
			 driver = new ChromeDriver();
	
		}
	//Browse Firefox	
		else if(sBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Anbu\\Selenium\\Driver\\FirefoxDriver\\geckodriver.exe");
			 driver = new FirefoxDriver();
	
		}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
	}

	public String TakeScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String sDestinationfile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		
		
		FileUtils.copyFile(source, new File(sDestinationfile));
		return sDestinationfile;
	}

}




