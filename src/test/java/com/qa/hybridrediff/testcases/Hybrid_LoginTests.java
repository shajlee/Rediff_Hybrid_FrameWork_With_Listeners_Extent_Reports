package com.qa.hybridrediff.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;
import com.qa.hybridrediff.pages.HybridInboxPage;
import com.qa.hybridrediff.pages.HybridLandingPage;
import com.qa.hybridrediff.pages.HybridLoginPage;
import com.qa.hybridrediff.testdata.SupplyTestData;
import com.qa.hybridrediff.utilities.RediffHybrid_Utilities;

public class Hybrid_LoginTests extends TestBase_HybridRediff {
	
	public Hybrid_LoginTests() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser1"));
		HybridLandingPage landingpage = new HybridLandingPage(driver);              //create the object of the landing page
		landingpage.clickOnSignInLink();                                           // with this object we can call on actions.
		//driver.findElement(By.cssSelector("a.signin")).click();                 // don't need this anymore
	}
	@Test(priority=1, dataProvider = "rediffExcellDataWithDataProvider", dataProviderClass = SupplyTestData.class)
	public void logInWithValidCredentials(String username, String password) {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		HybridInboxPage inboxpage = new HybridInboxPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();
		softassert.assertTrue(inboxpage.inboxButtonIsDisplayedOrNot());
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(username);
		//driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		//softassert.assertTrue(driver.findElement(By.cssSelector("a.rd_active")).isDisplayed(), "Inbox Button is not Displayed");
		softassert.assertAll();
	}
	
	@Test(priority=2)
	public void logInWithInValidCredentials() {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		loginpage.enterUserName(RediffHybrid_Utilities.generateEmailWithTimeStamp());
		loginpage.enterPasswordWithTimeStamp(RediffHybrid_Utilities.generatePasswordTimeStamp());
		loginpage.clickOnSignInButton();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(RediffHybrid_Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.cssSelector("input#password")).sendKeys(RediffHybrid_Utilities.generatePasswordTimeStamp());
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		String actualWarningMessage = loginpage.retreiveLogInWithInvalidCredentialsMessage();
		//String actualWarningMessage = driver.findElement(By.cssSelector("div#div_login_error")).getText();
		String expectedWarningMessage = prop.getProperty("logInWithInvalidCredExpectedWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message Not Displayed");
		softassert.assertAll();
	}
	@Test(priority=3)
	public void logInWithValidEmailInvalidPassword() {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		loginpage.enterUserName(prop.getProperty("validEmail"));
		loginpage.enterPasswordWithTimeStamp("RediffHybrid_Utilities.generatePasswordTimeStamp()");
		loginpage.clickOnSignInButton();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.cssSelector("input#password")).sendKeys(RediffHybrid_Utilities.generatePasswordTimeStamp());
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		String actualWarningMessage = loginpage.retreiveLogInWithValidEmailInvalidPassword();
		//String actualWarningMessage = driver.findElement(By.cssSelector("div#div_login_error")).getText();
		String expectedWarningMessage = prop.getProperty("logInWithValidEmailInvalidPasswordWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message Not Displayed");
		softassert.assertAll();
	}
	@Test(priority=4)
	public void logInWithInValidEmailValidPassword() {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		loginpage.enterUserName(RediffHybrid_Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnSignInButton();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(RediffHybrid_Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		String actualWarningMessage = loginpage.retreiveLogInWithInvalidEmailValidPassword();
		//String actualWarningMessage = driver.findElement(By.cssSelector("div#div_login_error")).getText();
		String expectedWarningMessage = prop.getProperty("logInWithInValidEmailValidPasswordWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message Not Displayed");
		softassert.assertAll();
	}
	@Test(priority=5)
	public void logInWithEmptyUsernameValidPassword() {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnSignInButton();
		//driver.findElement(By.cssSelector("input#login1"));
		//driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = prop.getProperty("logInWithEmptyUsernameValidPasswordWarningMessage");
		softassert.assertTrue(actualAlertText.contains(expectedAlertText), "Expected Alert Text Not Displayed");
		softassert.assertAll();
	}
	@Test(priority=6)
	public void logInWithValidUsernameEmptyPassword() {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		loginpage.enterUserName(prop.getProperty("validEmail"));
		loginpage.clickOnSignInButton();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.cssSelector("input#password"));
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = prop.getProperty("logInWithValidUsernameEmptyPasswordWarningMessage");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if(actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		}else {
			alert.dismiss();
		}
		softassert.assertAll();
		
	}
	@Test(priority=7)
	public void logInWithNoCredentials() {
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		loginpage.clickOnSignInButton();
		//driver.findElement(By.cssSelector("input#login1"));
		//driver.findElement(By.cssSelector("input#password"));
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = prop.getProperty("logInWithNoCredentialsWarningMessage");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if(actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		}else {
			alert.dismiss();
		}
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
	
	


