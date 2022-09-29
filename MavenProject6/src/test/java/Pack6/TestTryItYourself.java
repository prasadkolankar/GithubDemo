package Pack6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPageO;
import Pages.OrangeHRMPage;
import Pages.TryItYourselfPage;
import Setup.Base;
import Utils.Utilities;

public class TestTryItYourself extends Base {
	
	private WebDriver driver;
	private OrangeHRMPage orangeHRMPage;
	private ArrayList<String> addr;
	private TryItYourselfPage tryityourself;
	private LoginPageO loginpage;
	private int testid;
	private String data;
	
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
		tryityourself=new TryItYourselfPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		loginpage.clickonOrangeHRM();
		addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
	}
		
	@Test
	public void verifytryityourself() throws InterruptedException, IOException {
//		Thread.sleep(2000);
//		orangeHRMPage.clickAcceptC();
//		Thread.sleep(2000);
		testid=31;
		orangeHRMPage.tryItYourself();
		data= Utilities.getDataFromExcelSheet("Sheet2",8, 0);
		tryityourself.enterFavoredName(data);
		data= Utilities.getDataFromExcelSheet("Sheet2",9, 0);
		tryityourself.enterName(data);
		data= Utilities.getDataFromExcelSheet("Sheet2",10, 0);
		tryityourself.enterEmail(data);
		data= Utilities.getDataFromExcelSheet("Sheet2",11, 0);
		tryityourself.enterPhoneNo(data);
		tryityourself.selectCountry();
		Thread.sleep(3000);
		tryityourself.clickSubmit();
		System.out.println(driver.getCurrentUrl());
//		Utilities.captureScreenshot(testid, driver);
	}
	
	@AfterMethod
	public void goBackward(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			Utilities.captureScreenshot(testid, driver);
		}
		driver.navigate().back();
	}
	
	@AfterClass
	public void clearPOMobjects() {
		loginpage=null;
		orangeHRMPage=null;
		tryityourself=null;
	}
	
	@AfterTest
	public void afterTest() {
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
