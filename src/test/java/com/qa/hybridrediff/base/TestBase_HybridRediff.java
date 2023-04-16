package com.qa.hybridrediff.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.hybridrediff.utilities.RediffHybrid_Utilities;

public class TestBase_HybridRediff {

public static WebDriver driver;
public static ChromeOptions options;
public static FirefoxOptions options1;
public static EdgeOptions options2;
public static Properties prop;

public TestBase_HybridRediff() throws Exception {
	prop = new Properties();
	FileInputStream Ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\hybridrediff\\propertiesfiles\\configurationHybridRediff.Properties");
	prop.load(Ip);
}
public WebDriver initializeBrowserAndOpenApplication(String browserName) {
	if(browserName.equalsIgnoreCase("chrome")) {
		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
	
	}else if(browserName.equalsIgnoreCase("firefox")){
		
		options1 = new FirefoxOptions();
		options1.addArguments("-private");
		driver = new FirefoxDriver(options1);
	}else if(browserName.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver(options2);
	}
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(RediffHybrid_Utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(RediffHybrid_Utilities.PAGELOAD_TIME));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(RediffHybrid_Utilities.SCRIPT_TIMEOUT));
	
	return driver;
		
	}
	
	
	
	
}




