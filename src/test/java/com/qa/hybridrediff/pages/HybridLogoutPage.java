package com.qa.hybridrediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HybridLogoutPage {
	
	public WebDriver driver;
	
@FindBy(css = "a.rd_logout")
private WebElement logOutButton;

@FindBy(css = "div.panel p")
private WebElement logOutConfirmationMessage;

public HybridLogoutPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public WebElement logOutButton() {
	return logOutButton;
}
public String retreivelogoutConfirmationMessage() {
	String logoutConfirmationmsg = logOutConfirmationMessage.getText();
	return logoutConfirmationmsg;
	
}


}
