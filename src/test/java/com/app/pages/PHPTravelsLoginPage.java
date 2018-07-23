package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.app.utilities.Driver;

public class PHPTravelsLoginPage {
	
	private WebDriver driver;
	
	public PHPTravelsLoginPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-block ladda-button fadeIn animated']")
	public WebElement login;
	
	public void login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		login.click();
	}
	
	
}
