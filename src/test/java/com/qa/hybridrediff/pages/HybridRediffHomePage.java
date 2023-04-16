package com.qa.hybridrediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HybridRediffHomePage {
	public WebDriver driver;
	
@FindBy(css = "div.header div a+span a+a b")
private WebElement rediffHomeLink;

@FindBy(css = "span.hmsprite.logo")
private WebElement rediffLogo;

public HybridRediffHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void rediffHome() {
	rediffHomeLink.click();
}
public boolean rediffLogoIsDisplayed() {
	boolean displayStatus = rediffLogo.isDisplayed();
	return displayStatus;
	
}




}
