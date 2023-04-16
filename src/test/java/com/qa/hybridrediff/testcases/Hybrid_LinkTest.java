package com.qa.hybridrediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;
import com.qa.hybridrediff.pages.HyBridLinkTestPage;

public class Hybrid_LinkTest extends TestBase_HybridRediff {
	public Hybrid_LinkTest() throws Exception {
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
	public void rediffLinks() {
		HyBridLinkTestPage linktestpage = new HyBridLinkTestPage(driver);
		linktestpage.clickOnRediffMailLink();
		linktestpage.rediffMailLogo();
		//driver.findElement(By.linkText("Rediffmail")).click();
		//WebElement rediffMailLogo = driver.findElement(By.cssSelector("div.logtext"));
		softassert.assertTrue(linktestpage.rediffMailLogo().isDisplayed(), "Rediff Mail logo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linktestpage.clickOnMoneyLink();
		linktestpage.rediffMoneyLogo();
		//driver.findElement(By.linkText("Money")).click();
		//WebElement rediffMoneyLogo = driver.findElement(By.cssSelector("div.floatL a span"));
		softassert.assertTrue(linktestpage.rediffMoneyLogo().isDisplayed(), "Rediff Money logo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linktestpage.clickOnBusinessEmailLink();
		linktestpage.businessMailForWorkLogo();
		//driver.findElement(By.linkText("Business Email")).click();
		//WebElement rediffMailForWorkLogo = driver.findElement(By.cssSelector("a.logo img"));
		softassert.assertTrue(linktestpage.businessMailForWorkLogo().isDisplayed(), "Rediff Business Mail logo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linktestpage.clickOnVideosLink();
		linktestpage.rediffIShareLogo();
		//driver.findElement(By.linkText("Videos")).click();
		//WebElement rediffiShareLogo = driver.findElement(By.cssSelector("img.othersprite.isharelogo"));
		softassert.assertTrue(linktestpage.rediffIShareLogo().isDisplayed(), "Rediff iShare logo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linktestpage.clickOnShoppingLink();
		linktestpage.rediffShoppingLogo();
		//driver.findElement(By.linkText("Shopping")).click();
		//WebElement rediffShoppingLogo = driver.findElement(By.cssSelector("img.shsprite.shoptoplogo"));
		softassert.assertTrue(linktestpage.rediffShoppingLogo().isDisplayed(), "Rediff Shopping logo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
