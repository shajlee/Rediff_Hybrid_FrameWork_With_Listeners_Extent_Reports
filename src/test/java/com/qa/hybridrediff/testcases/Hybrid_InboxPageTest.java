package com.qa.hybridrediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;
import com.qa.hybridrediff.pages.HybridInboxPage;
import com.qa.hybridrediff.pages.HybridLandingPage;
import com.qa.hybridrediff.pages.HybridLoginPage;

public class Hybrid_InboxPageTest extends TestBase_HybridRediff {
	public Hybrid_InboxPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser1"));
		
	}
	@Test(priority =1)
	public void logInInboxButtonPresence() {
		HybridLandingPage landingpage = new HybridLandingPage(driver);
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		HybridInboxPage inboxpage = new  HybridInboxPage(driver);
		landingpage.clickOnSignInLink();
		loginpage.enterUserName(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnSignInButton();
		softassert.assertTrue(inboxpage.inboxButtonIsDisplayedOrNot());
		
		//driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		//WebElement inboxButton = driver.findElement(By.cssSelector("a.rd_active"));
		//softassert.assertTrue(inboxButton.isDisplayed() && inboxButton.isEnabled());
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		
		
		
	}

}
