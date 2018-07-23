package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class PHPTravelsDashboardPage {
	
	private WebDriver driver;
	public PHPTravelsDashboardPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
	public WebElement bookings;
	
	@FindBy(xpath="//button[@class='btn btn-info btn-block']")
	public WebElement cms_pages;
	
	@FindBy(xpath="//button[@class='btn btn-success btn-block']")
	public WebElement blog;
	
	@FindBy(xpath="//button[@class='btn btn-warning btn-block']")
	public WebElement send_newsletter;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-block']")
	public WebElement backup_database;
	
	@FindBy(linkText="Things To Do This Weekend")
	public WebElement myLink;
	
	@FindBy(xpath="//td[@class='xcrud-current xcrud-num']")
	public List<WebElement> count;

	@FindBy(xpath="//button[@class='btn btn-default active xcrud-action']")
	public WebElement all_button;

		
	
	
}