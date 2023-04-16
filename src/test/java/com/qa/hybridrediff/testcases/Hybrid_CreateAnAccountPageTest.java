package com.qa.hybridrediff.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridrediff.base.TestBase_HybridRediff;

public class Hybrid_CreateAnAccountPageTest extends TestBase_HybridRediff {
	public Hybrid_CreateAnAccountPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser1"));
		driver.findElement(By.linkText("Create Account")).click();
	}
	@Test(priority=1)
	public void userInformation() throws Exception {
		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(prop.getProperty("createAccountName"));
		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys(prop.getProperty("CreateAccountId"));
		driver.findElement(By.className("btn_checkavail")).click();
		Thread.sleep(2000);
		
		String actualIdTakenMessage = driver.findElement(By.cssSelector("div#check_availability br+font b")).getText();
		String expectedIdTakenMessage = prop.getProperty("UserInformationExpectedTakenMessage");
		softassert.assertTrue(actualIdTakenMessage.contains(expectedIdTakenMessage), "Expected id taken message not displayed");
		softassert.assertAll();
		
		List<WebElement>EmailIdRadioButton = driver.findElements(By.cssSelector("input#radio_login"));
		for(int i = 0; i<EmailIdRadioButton.size(); i++) {
			if(EmailIdRadioButton.get(i).getAttribute("value").equalsIgnoreCase("ravenclawsmailbox")) {
				EmailIdRadioButton.get(i).click();
				break;
			}
			driver.findElement(By.cssSelector("input#newpasswd")).sendKeys(prop.getProperty("UserInformationPassword"));
			driver.findElement(By.cssSelector("input#newpasswd1")).sendKeys(prop.getProperty("UserInformationPasswordConfirmation"));
			driver.findElement(By.name("chk_altemail89162b78")).click();
			Thread.sleep(3000);
			
			WebElement securityQuestionDropdown = driver.findElement(By.name("hintq89162b78"));
			Select securityQuestion = new Select(securityQuestionDropdown);
			securityQuestion.selectByVisibleText(prop.getProperty("SecurityQuestion"));
			driver.findElement(By.name("hinta89162b78")).sendKeys(prop.getProperty("SecurityAnswer"));
			Thread.sleep(3000);
			
			driver.findElement(By.name("mothername89162b78")).sendKeys(prop.getProperty("MothersName"));
			driver.findElement(By.cssSelector("input#mobno")).sendKeys(prop.getProperty("CellPhoneNumner"));
			Thread.sleep(3000);
			
			WebElement birthDayDropdown = driver.findElement(By.name("DOB_Day89162b78"));
			Select birthDay = new Select(birthDayDropdown);
			birthDay.selectByVisibleText(prop.getProperty("BirthDay"));
			Thread.sleep(3000);
			
			WebElement birthmonthDropDown = driver.findElement(By.name("DOB_Month89162b78"));
			Select birthMonth = new Select(birthmonthDropDown);
			birthMonth.selectByVisibleText(prop.getProperty("BirthMonth"));
			Thread.sleep(3000);
			
			WebElement birthYearDropDown = driver.findElement(By.name("DOB_Year89162b78"));
			Select birthYear = new Select(birthYearDropDown);
			birthYear.selectByVisibleText(prop.getProperty("BirthYear"));
			Thread.sleep(3000);
			
			List<WebElement>GenderRadioButton = driver.findElements(By.name("gender89162b78"));
			for(int j=0; j<GenderRadioButton.size(); j++) {
				if(GenderRadioButton.get(j).getAttribute("value").equalsIgnoreCase("f")) {
					GenderRadioButton.get(j).click();
					break;
				}
			
			
			
			
			}
			
		}
		
		
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
		
	}
	

}
