package com.training.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.SalesforceCucumberPOM.pages.homepages.HomePage;
import com.SalesforceCucumberPOM.pages.loginpages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepsPOM {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	
@Before(order=0)
public void setUp1() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

@Given("User open Salesforce application")
public void user_open_salesforce_application() {
	driver.get("https://login.salesforce.com");
}

@When("user on {string}")
public void user_on(String page) {
	 if(page.equalsIgnoreCase("loginpage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	System.out.println("creating new object for home");
	    	home=new HomePage(driver);
}

@When("user enters value into username textbox as {string}")
public void user_enters_value_into_username_textbox_as(String data) {
	login.enterUsername(data);
	
	System.out.println("user name entered");
}

@When("user enters value into password textbox as {string}")
public void user_enters_value_into_password_textbox_as(String data) {
	login.enterPassword(data);
	System.out.println("password entered");
}

@When("click on Login button")
public void click_on_login_button() {
	login.clickLoginButton();
	System.out.println("login button clicked");
}

@Then("verify page title as {string}")
public void verify_page_title_as(String expectedString) throws InterruptedException {
	Thread.sleep(5000);
	String actual=home.GetTextFromSalesforceHomePageTitle();
	Assert.assertEquals(actual, expectedString);
}

@When("password textbox field should be empty")
public void password_textbox_field_should_be_empty() {
	login.clearPassword(null);
}

@Then("error message should be displayed as {string}")
public void error_message_should_be_displayed_as(String expected) {
	String actual="Please enter your password.";
	Assert.assertEquals(actual, expected);
}

@When("remember username checkbox should be selected")
public void remember_username_checkbox_should_be_selected() {
	login.remember_me_btn();
}

@Then("logout of SFDC application")
public void logout_of_sfdc_application() {
	login.logout();
}


@Then("validate username displayed in the username texbox field as {string}")
public void validate_username_displayed_in_the_username_texbox_field_as(String expected) {
	String actual="archana.dhokane@gmail.com";
	Assert.assertEquals(actual, expected);
}

@When("user click on forgot your password")
public void user_click_on_forgot_your_password() {
    login.click_forgot_password();
}

@When("user enters value into username forgot textbox as {string}")
public void user_enters_value_into_username_forgot_textbox_as(String string) {
  login.forgotPassword(string);  
}

@Then("password reset message should be displayed as {string}")
public void password_reset_message_should_be_displayed_as(String expected) {
	String actual =login.check_email_message();
	Assert.assertEquals(actual, expected);
}
@Then("incorrect error message should be displayed as {string}")
public void incorrect_error_message_should_be_displayed_as(String expected) {
	String actual ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	Assert.assertEquals(actual, expected);
}

@After
public void tearDown() {
	driver.quit();
}
}