package Pack6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import org.testng.asserts.SoftAssert;

import Pages.LoginPageO;
import Pages.OrangeHRMPage;
import Setup.Base;
import Utils.Utilities;


public class TestOfOrangeHrm extends Base{
	private WebDriver driver;
	private OrangeHRMPage orangeHRMPage;
	private ArrayList<String> addr;
	private LoginPageO loginpage;
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
	public void openBrowser() {
		loginpage=new LoginPageO(driver);
		orangeHRMPage=new OrangeHRMPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		loginpage.clickonOrangeHRM();;
		addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
	}
	
	@Test (priority=1)
	public void verifyHrAdminIsDisplayed() throws InterruptedException {
		testId=21;
		orangeHRMPage.moveToPlatform();
		orangeHRMPage.moveToPeopleM();
		Thread.sleep(3000);
		SoftAssert soft=new SoftAssert();
		boolean rs=(orangeHRMPage.hrAdminis());
		soft.assertEquals(rs, true, "is not displayed");
		soft.assertAll();
	}
	
	@Test (priority=2)
	public void verifyCaseStudyIsDisplayed() {
		testId=22;
		orangeHRMPage.moveToWhyOrange();
		orangeHRMPage.moveToOurCustomer();
		boolean rc=orangeHRMPage.caseStudy();
		Assert.assertEquals(rc, true, "is not displayed");
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			Utilities.captureScreenshot(testId, driver);
		}
	}
	
	@AfterClass
	public void clearPOMobjects() {
		loginpage = null;
		orangeHRMPage=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	

}
