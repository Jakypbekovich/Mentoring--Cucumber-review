package com.app.step_definitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.pages.PHPTravelsDashboardPage;
import com.app.pages.PHPTravelsLoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstStepTest {
	private WebDriver driver = Driver.getDriver();
	PHPTravelsLoginPage loginPage = new PHPTravelsLoginPage();
	PHPTravelsDashboardPage dashboardPage = new PHPTravelsDashboardPage();

	@Given("I logged in the PHP website and entered credentials")
	public void i_logged_in_the_PHP_website_and_entered_credentials() {
		driver.get(ConfigurationReader.getProperty("url"));

		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	}

	@When("I see dashboard page buttons are visible")
	public void i_see_dashboard_page_buttons_are_visible() {
		 	assertTrue(dashboardPage.bookings.isDisplayed());
			assertTrue(dashboardPage.cms_pages.isDisplayed());
			assertTrue(dashboardPage.blog.isDisplayed());
			assertTrue(dashboardPage.send_newsletter.isDisplayed());
			assertTrue(dashboardPage.send_newsletter.isDisplayed());
	}

	@Then("Blog box contains my link")
	public void blog_box_contains_my_link() {
		dashboardPage.blog.click();
		assertTrue(dashboardPage.myLink.isDisplayed());
		
	}
	
	@When("I go into Bookings Tab")
	public void i_go_into_Bookings_Tab() {
	   dashboardPage.bookings.click();
	   dashboardPage.all_button.click();
	}

	@Then("I get count of cutomers")
	public void i_get_count_of_cutomers() {
		
		System.out.println(dashboardPage.count.size());
	   assertTrue(dashboardPage.count.size()==52);
	}

}