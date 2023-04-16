package com.qa.hybridrediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;
import com.qa.hybridrediff.pages.HybridLandingPage;
import com.qa.hybridrediff.pages.HybridSignInLinkPage;

public class Hybrid_SignInLinkTest extends TestBase_HybridRediff {
	public Hybrid_SignInLinkTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void setUp()  {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser1"));
		
	}
	@Test(priority=1)
	public void clickOnSignInButton() {
		HybridLandingPage landingpage = new HybridLandingPage(driver);
		HybridSignInLinkPage signinlinkpage = new HybridSignInLinkPage(driver);
		landingpage.clickOnSignInLink();
		softassert.assertTrue(signinlinkpage.rediffMailLogoIsDisplayed());
		softassert.assertAll();
		
		//driver.findElement(By.linkText("Sign in")).click();
		//WebElement rediffMailLogo = driver.findElement(By.cssSelector("div.logtext"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


}
