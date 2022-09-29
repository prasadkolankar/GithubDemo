package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageO {
	
	@FindBy (xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy (xpath="//a[@href='http://www.orangehrm.com']")
	private WebElement orangeHRM;
	
	
	public LoginPageO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginOrange() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		login.click();
	}
	//or
	public void enterUsername(String name) {
		username.sendKeys(name);
	}
	public void enterPassword(String passwords) {
		password.sendKeys(passwords);
	}
	public void clickLoginButton() {
		login.click();
	}
	public void clickonOrangeHRM() {
		orangeHRM.click();
	}

}
