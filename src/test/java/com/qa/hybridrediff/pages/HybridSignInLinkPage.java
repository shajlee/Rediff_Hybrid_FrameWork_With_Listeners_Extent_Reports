package com.qa.hybridrediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HybridSignInLinkPage {
	public WebDriver driver;
	
@FindBy(css = "div.logtext")
private WebElement rediffMailLogo;

public HybridSignInLinkPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public boolean rediffMailLogoIsDisplayed() {
	boolean displayStatus = rediffMailLogo.isDisplayed();
	return displayStatus;
}

}
