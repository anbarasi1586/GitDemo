package Academy.E2EFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import junit.framework.Assert;
import resources.Base;



public class HomePageTest extends Base {
	
	public WebDriver driver;
	 
	
	
	//public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initiliaze() throws IOException {
		
		//initialise browser without extends
				
				driver = BrowserInit();
				
		
	}
	

	@Test (dataProvider = "getLoginData")
	public void basePageNavigation(String sEmail, String sPwd) throws IOException{
		
		
		driver.get(property.getProperty("url"));
		System.out.println(property.getProperty("url"));
		
		//driver.get("https://www.rahulshettyacademy.com/");
		
		/*
		//initialise browser with extends
		driver = BrowserInit();
		driver.get("https://www.rahulshettyacademy.com/");
		*/
		
		//verify Homepage
		HomePage objHome = new HomePage(driver);
		String sChptText = objHome.getChkptText().getText().toLowerCase();
		System.out.println(sChptText);
		Assert.assertEquals("featured courfgses", sChptText);
		
		Assert.assertFalse(objHome.getChkpt1title().isDisplayed());
		
		//Click Login Buttona
		objHome.clickLoginHome().click();
		
		LoginPage objLogin = new LoginPage(driver);
		
		//Enter Emailid
		objLogin.enterEmail().sendKeys(sEmail);
		//Enter Password
		objLogin.enterPwd().sendKeys(sPwd);
		//Click Login button
		objLogin.clickLogin().click();
			
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] objLogin = new Object[2][2];
		objLogin[0][0] = "dskjh@gmail.com";
		objLogin[0][1] = "awefs12";
		
		objLogin[1][0] = "dsfdsf@gmail.com";
		objLogin[1][1] = "ytyt";
		
		return objLogin;
	
		
	}
		
	@AfterTest
	public void tearDown() {
		
		driver.close();
		
	}
	

}
 
