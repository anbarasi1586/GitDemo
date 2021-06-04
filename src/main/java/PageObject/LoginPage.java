package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	//Objects
	By wEEmail = By.cssSelector("#user_email");
	By wEPassword = By.cssSelector("#user_password");
	By wELoginBtn = By.cssSelector("input[name='commit']");
	
	public WebElement enterEmail() {
		
		return driver.findElement(wEEmail);
		
		}
	
	public WebElement enterPwd() {
		
		return driver.findElement(wEPassword);
		
		}
	
	public WebElement clickLogin() {
		
		return driver.findElement(wELoginBtn);
		
		}
}
