package com.qa.hybridrediff.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;
import com.qa.hybridrediff.pages.HybridLandingPage;
import com.qa.hybridrediff.pages.HybridLoginPage;
import com.qa.hybridrediff.pages.HybridLogoutPage;

public class Hybrid_LogoutTest extends TestBase_HybridRediff {
	public Hybrid_LogoutTest() throws Exception {
		super();
	}	
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser1"));
	}
	@Test(priority=1)
	public void logInLogOutLogOutConfirmation() {
		HybridLandingPage landingpage = new HybridLandingPage(driver);
		HybridLoginPage loginpage = new HybridLoginPage(driver);
		HybridLogoutPage logoutpage = new HybridLogoutPage(driver);
		landingpage.clickOnSignInLink();
		loginpage.enterUserName(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnSignInButton();
		logoutpage.logOutButton();
		//WebElement logoutButton = driver.findElement(By.cssSelector("a.rd_logout"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutpage.logOutButton()));
		logoutpage.logOutButton().click();
		//Thread.sleep(4000);
		String actualLogOutConfirmationMessage = logoutpage.retreivelogoutConfirmationMessage();
		String expectedLogOutConfirmationMessage = prop.getProperty("LogOutConfirmationMessage");
		softassert.assertTrue(actualLogOutConfirmationMessage.contains(expectedLogOutConfirmationMessage), "Expected Log Out Confirmation Message Not Displayed");
		softassert.assertAll();
		
		//driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		//driver.findElement(By.cssSelector("a.rd_logout")).click();
		//String actualLogOutConfirmationMessage = driver.findElement(By.cssSelector("div.panel p")).getText();
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		

		
	}

}
