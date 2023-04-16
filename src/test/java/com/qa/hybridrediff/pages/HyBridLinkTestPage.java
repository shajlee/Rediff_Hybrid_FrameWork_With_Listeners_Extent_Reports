package com.qa.hybridrediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyBridLinkTestPage {
	
public WebDriver driver;

@FindBy(className = "mailicon")
private WebElement rediffMailLink;

@FindBy(css = "div.logtext")
private WebElement rediffMailLogo;

@FindBy(css = "a.moneyicon.relative")
private WebElement moneyLink;

@FindBy(css = "div.floatL a span")
private WebElement rediffMoneyLogo;

@FindBy(css = "a.bmailicon.relative")
private WebElement businessEmailLink;

@FindBy(css = "a.logo img")
private WebElement businessMailForWorkLogo;

@FindBy(className = "vdicon")
private WebElement videosLink;

@FindBy(css = "img.othersprite.isharelogo")
private WebElement rediffIShareLogo;

@FindBy(css = "a.shopicon.relative")
private WebElement shoppingLink;

@FindBy(css = "img.shsprite.shoptoplogo")
private WebElement rediffShoppingLogo;

public HyBridLinkTestPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnRediffMailLink() {
	rediffMailLink.click();
}
public WebElement rediffMailLogo() {
	return rediffMailLogo;
}
public void clickOnMoneyLink() {
	moneyLink.click();
}
public WebElement rediffMoneyLogo() {
	return rediffMoneyLogo;
}
public void clickOnBusinessEmailLink() {
	businessEmailLink.click();
}
public WebElement businessMailForWorkLogo() {
	return businessMailForWorkLogo;
}
public void clickOnVideosLink() {
	videosLink.click();
}
public WebElement rediffIShareLogo() {
	return rediffIShareLogo;
}
public void clickOnShoppingLink() {
	shoppingLink.click();
}
public WebElement rediffShoppingLogo() {
	return rediffShoppingLogo;
	
}

}
