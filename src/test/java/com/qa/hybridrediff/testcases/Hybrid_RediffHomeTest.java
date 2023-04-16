package com.qa.hybridrediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;
import com.qa.hybridrediff.pages.HybridLandingPage;
import com.qa.hybridrediff.pages.HybridLoginPage;
import com.qa.hybridrediff.pages.HybridLogoutPage;
import com.qa.hybridrediff.pages.HybridRediffHomePage;

public class Hybrid_RediffHomeTest extends TestBase_HybridRediff {
	public Hybrid_RediffHomeTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser1"));
		
	}
	@Test(priority=1)
	public void rediffHome() throws Exception {
		HybridLandingPage landingpage = new HybridLandingPage(driver);
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		HybridLogoutPage logoutpage = new  HybridLogoutPage(driver);
		HybridRediffHomePage homepage = new HybridRediffHomePage(driver);
		landingpage.clickOnSignInLink();
		loginpage.enterUserName(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		Thread.sleep(2000);
		loginpage.clickOnSignInButton();
		logoutpage.logOutButton().click();
		homepage.rediffHome();
		softassert.assertTrue(homepage.rediffLogoIsDisplayed());
		softassert.assertAll();
		
		//driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		//driver.findElement(By.cssSelector("a.rd_logout")).click();
		//driver.findElement(By.cssSelector("div.header div a+span a+a b")).click();
	
		
		//WebElement rediffLogo = driver.findElement(By.cssSelector("span.hmsprite.logo"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
	}
	

}
