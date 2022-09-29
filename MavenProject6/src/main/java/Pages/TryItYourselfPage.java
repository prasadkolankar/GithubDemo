package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TryItYourselfPage {
	private WebDriver driver;
	
	@FindBy (xpath="//input[@name='subdomain']")
	private WebElement favoredName;
	
	@FindBy (xpath="//input[@name='Name']")
	private WebElement name ;
	
	@FindBy (xpath="//input[@name='Email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@name='Contact']")
	private WebElement phoneno;
	
	@FindBy (xpath="//select[@name='Country']")
	private WebElement country ;
	
	@FindBy (xpath="//div[@class='recaptcha-checkbox-border']")
	private WebElement checkbox ;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement submit ;
	
	
	
	public TryItYourselfPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	public void enterFavoredName(String favoredname) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		favoredName.sendKeys(favoredname);
	}
	
	public void enterName(String names) {
		name.sendKeys(names);
	}
	
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void enterPhoneNo(String no) {
		phoneno.sendKeys(no);
	}
	
	public void selectCountry() {
		Select s=new Select(country);
		s.selectByVisibleText("India");
		
	}
	
	public void hitCheckBox() {
		checkbox.click();
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	

}
