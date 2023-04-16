package com.qa.hybridrediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HybridInboxPage {
	
	public WebDriver driver;

@FindBy(css = "a.rd_active")
private WebElement inboxButton;

public HybridInboxPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public boolean inboxButtonIsDisplayedOrNot() {
	boolean displayStatus = inboxButton.isDisplayed();
	return displayStatus;
	
	


}

	
}