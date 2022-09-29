package Pack6;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPageO;
import Setup.Base;
import Utils.Utilities;

public class LoginOrange extends Base {
	
	private WebDriver driver;
	private LoginPageO loginpage;
	private String data;
	private int testId;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		if (browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		if (browserName.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMobject() {
		loginpage=new LoginPageO(driver);
	}
	
	@BeforeMethod
	public void loginInOrange() throws EncryptedDocumentException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		data=Utilities.getDataFromExcelSheet("Sheet2", 8, 1);
		loginpage.enterUsername(data);
		data=Utilities.getDataFromExcelSheet("Sheet2", 9, 1);
		loginpage.enterPassword(data);
		loginpage.clickLoginButton();
	}
	
	@Test
	public void verifyUrlTitle() {
		testId=11;
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		System.out.println(url);
		System.out.println(title);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			Utilities.captureScreenshot(testId, driver);
		}
	}
	
	@AfterClass
	public void clearPOMobject() {
		loginpage=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Test");
		driver.close();
		driver=null;
		System.gc();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
