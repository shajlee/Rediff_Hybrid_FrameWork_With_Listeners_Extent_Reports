package com.qa.hybridrediff.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hybrid_CreateAnAccountPageTest1 {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Create Account")).click();
	}
	@Test(priority=1)
	public void invalidUserCredentials() throws Exception {
		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys("John Snow");
		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys("jonsnow");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.btn_checkavail")).click();
		String actualIdUnavaibilityMessage = driver.findElement(By.cssSelector("div#check_availability br+font b")).getText();
		String expectedIdUnavaibilityMessage = "Sorry, the ID that you are looking for is taken.";
		softassert.assertTrue(actualIdUnavaibilityMessage.contains(expectedIdUnavaibilityMessage), "Actual Id Unavaibility not displayed");
	
		List<WebElement> idRadioButton = driver.findElements(By.cssSelector("input#radio_login"));
		for(int i=0; i<idRadioButton.size(); i++) {
			if(idRadioButton.get(i).getAttribute("value").equalsIgnoreCase("jonsnow.2023")) {
				idRadioButton.get(i).click();
				break;
			}
			driver.findElement(By.cssSelector("input#newpasswd")).sendKeys("Shajlee1@");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input#newpasswd1")).sendKeys("Shajlee1@");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input.nomargin")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input#mobno")).sendKeys("5405756079");
		
			
			}
		
		}
		
		
		
		
		
		
		
	}
	
	
	


