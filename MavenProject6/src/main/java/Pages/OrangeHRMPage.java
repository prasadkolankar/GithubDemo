package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPage {
	private WebDriver driver;
	private Actions act;
	
	@FindBy (xpath="(//a[@class='nav-link-hed'])[1]")
	private WebElement platform ;
	
	@FindBy (xpath="(//li[@class='sub-menu-title menu-title-row pt-2 pb-2'])[1]")
	private WebElement peopleManagement;
	
	@FindBy (xpath="//a[@href='features/hr-administration']")
	private WebElement hrAdministration ;
	
	@FindBy (xpath="(//a[@class='nav-link-hed'])[2]")
	private WebElement whyOrange;
	
	@FindBy (xpath="(//li[@class='sub-menu-title menu-title-row pt-2 pb-2'])[5]")
	private WebElement ourCoustomer;
	
	@FindBy (xpath="(//a[@href='resources/success-stories/case-studies/'])[1]")
	private WebElement caseStudies;
	
	@FindBy (xpath="(//button[@type='submit'])[1]")
	private WebElement tryityourself;
	
	@FindBy (xpath="(//button[@class='btn btn-ohrm btn-contact-sales'])[2]")
	private WebElement bookaFreeDemo;
	
	@FindBy (xpath="(//button[@class='btn btn-ohrm btn-free-demo'])[2]")
	private WebElement contactSales;
	
	@FindBy (xpath="//a[@aria-label='Accept Cookies']")
	private WebElement acceptc;
	
	public OrangeHRMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void moveToPlatform() {
		act=new Actions(driver);
		act.moveToElement(platform).perform();;
	}
	
	public void moveToPeopleM() {
		act= new Actions(driver);
		act.moveToElement(peopleManagement).perform();;
	}
	
	public boolean hrAdminis() {
		return hrAdministration.isDisplayed();	
	}
	
	public void moveToWhyOrange() {
		act=new Actions(driver);
		act.moveToElement(whyOrange).perform();
	}
	
	public void moveToOurCustomer() {
		act= new Actions(driver);
		act.moveToElement(ourCoustomer).perform();
	}
	
	public boolean caseStudy() {
		return caseStudies.isDisplayed();	
	}
	
	public void tryItYourself() throws InterruptedException {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,4900)");
//		Thread.sleep(2000);
		tryityourself.click();
	}
	
	public void bookaFreedemo () {
		bookaFreeDemo.click();
	}
	
	public void contactSale() {
		contactSales.click();
	}
	
	public void clickAcceptC() {
		acceptc.click();
	}
	
	

}
