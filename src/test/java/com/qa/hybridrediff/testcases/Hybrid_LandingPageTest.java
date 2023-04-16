package com.qa.hybridrediff.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;

public class Hybrid_LandingPageTest extends TestBase_HybridRediff {
	public Hybrid_LandingPageTest() throws Exception {
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
	public void validateCurrentUrlAndTitle() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		String actualCurrentUrl = prop.getProperty("actualCurrentUrl");
		String expectedCurrentUrl = driver.getCurrentUrl();
		
		String actualTitle = prop.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();
		
		if(actualCurrentUrl.equals(expectedCurrentUrl) && actualTitle.equals(expectedTitle)) {
			System.out.println("Landing Page is Valid");
		}else {
			System.out.println("Landing Page is not Valid");
		}
	}
	@Test(priority =2)
	public void signInButtonisDisplayedandEnabled() {
		WebElement signInButton = driver.findElement(By.linkText("Sign in"));
		softassert.assertTrue(signInButton.isDisplayed() && signInButton.isEnabled());
		softassert.assertAll();
	}
	@Test(priority =3)
	public void rediffLogoPresence() {
		WebElement rediffLogo = driver.findElement(By.cssSelector("span.hmsprite.logo"));
		softassert.assertTrue(rediffLogo.isDisplayed() && rediffLogo.isEnabled());
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	}

		
	
	


