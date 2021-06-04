package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
//chkpoint1
 //By sHomeCheckpt=By.xpath("//div[@class='text-center']/h2");
	By sHomeCheckpt1=By.xpath("//div[@class='header-text hidden-xs']");
	By sHomeChkptText = By.xpath("//div[@class='pull-left']/h2");
	
	//Login
	By btnLoginHome = By.cssSelector("a[class='theme-btn register-btn']");
 
 public WebElement getChkpt1title() {
	 
	  return driver.findElement(sHomeCheckpt1);
	 
 }
 
 public WebElement getChkptText() {
	 
	 return driver.findElement(sHomeChkptText);
	 
 }
 
 public WebElement clickLoginHome() {
	 
	 return driver.findElement(btnLoginHome);
	 
 }
 
}

