package com.qa.hybridrediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HybridLoginPage {
	
	public WebDriver driver;
	
	//Objects

@FindBy(css = "input#login1")
private WebElement userNameTextBox;

@FindBy(css = "input#password")
private WebElement passwordTextBox;

@FindBy(css = "input#password")
private WebElement passwordWithTimeStamp;

@FindBy(css = "input.signinbtn")
private WebElement signInButton;

@FindBy(css = "div#div_login_error")
private WebElement logInWithInvalidCredentialsMessage;

@FindBy(css = "div#div_login_error")
private WebElement logInWithValidEmailInvalidPassword;

@FindBy(css = "div#div_login_error")
private WebElement logInWithInValidEmailValidPassword;

public HybridLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Actions

public void enterUserName(String usernameText) {
	userNameTextBox.sendKeys(usernameText);
	}
public void enterPassword(String passwordText) {
	passwordTextBox.sendKeys(passwordText);
	}
public void enterPasswordWithTimeStamp(CharSequence passwordWithTimeStampText) {
	passwordWithTimeStamp.sendKeys(passwordWithTimeStampText);
}
public void clickOnSignInButton() {
    signInButton.click();
}
public String retreiveLogInWithInvalidCredentialsMessage() {
	String loginInvalidCredMsg = logInWithInvalidCredentialsMessage.getText();
	return loginInvalidCredMsg;
}
public String retreiveLogInWithValidEmailInvalidPassword() {
	String loginValidEmailInvalidPasswordMsg = logInWithValidEmailInvalidPassword.getText();
	return loginValidEmailInvalidPasswordMsg;
}
public String retreiveLogInWithInvalidEmailValidPassword() {
	String loginInvalidEmailValidPasswordMsg = logInWithInValidEmailValidPassword.getText();
	return loginInvalidEmailValidPasswordMsg;
	

    }
}
