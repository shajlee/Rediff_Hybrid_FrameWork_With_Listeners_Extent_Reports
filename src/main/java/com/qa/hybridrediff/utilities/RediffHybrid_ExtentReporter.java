package com.qa.hybridrediff.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class RediffHybrid_ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
		
		//Step 1: Create Object of the ExtentReports
		
		ExtentReports extentreports = new ExtentReports();
		
		//Step 2: Create the folder in test-output and pass the extentReport as an html file
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
		//Step 3: Create the Object of ExtentSparkReporter
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile); //sparkReporter will help us get configurations
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("REDIFF HYBRID FRAMEWORK TEST RESULTS");
		sparkReporter.config().setDocumentTitle("REDIFF AUTOMATION TESTS");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		extentreports.attachReporter(sparkReporter);
		
		Properties configprop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\hybridrediff\\propertiesfiles\\configurationHybridRediff.Properties");
		configprop.load(ip);
		
		extentreports.setSystemInfo("Application Url", configprop.getProperty("url"));
		extentreports.setSystemInfo("Browser Name", configprop.getProperty("browser1"));
		extentreports.setSystemInfo("Username", configprop.getProperty("validEmail"));
		extentreports.setSystemInfo("Password", configprop.getProperty("validPassword"));
		extentreports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreports.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extentreports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentreports.setSystemInfo("Tester Name", System.getProperty("user.name"));
		extentreports.setSystemInfo("Tester Country", System.getProperty("user.country"));
		
		return extentreports;
		
	
		
		
		
		
		
	}

}
