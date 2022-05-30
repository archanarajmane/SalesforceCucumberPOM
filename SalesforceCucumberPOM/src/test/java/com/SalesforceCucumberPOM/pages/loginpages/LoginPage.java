package com.SalesforceCucumberPOM.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.SalesforceCucumberPOM.base.SFCucumberbasePagePOM;
import java.lang.reflect.Method;

public class LoginPage extends SFCucumberbasePagePOM {

WebDriver driver;
	
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "password") WebElement password;
	@FindBy(xpath = "//input[@id='Login']") WebElement loginButton;
	@FindBy(xpath="//*[@id=\"error\"]") WebElement errormsg;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement remember_me_btn;
	@FindBy(xpath="//span[@id='userNavLabel']") WebElement user_name_lable;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement log_out;
	@FindBy(xpath="//*[@id=\"idcard-identity\"]") WebElement user_name_validation;
	@FindBy(xpath="//a[@id='forgot_password_link']") WebElement forgot_pwd;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]") WebElement forgot_user_name;
	@FindBy(xpath="//input[@id='continue']") WebElement continue_btn;
	@FindBy(xpath="//*[@id=\"header\"]") WebElement check_email;
	@FindBy(id="error") WebElement wrong_pwd_error;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String username) {
		waitUntilVisible(userName,"user name field");
		clearElement(userName,"user name field");
		enterText(userName, username, "user name field");
		
	}
	
	public void enterPassword(String passWord) {
		
		enterText(password, passWord, "password field");
		
		}
	
	public void clearPassword(String passWord)
	{
		clearElement(password,passWord);
	}
	
	public void clickLoginButton() {
		clickElement(loginButton,"login button");
		
	}
	
	public void login(String usrname,String passWrd) 
	{
		enterUsername(usrname);
		enterPassword(passWrd);
		clickLoginButton();
	}

	
	public String check_email_message()
	{
		return check_email.getText();
	}
	
	public void click_forgot_password() {
		clickElement(forgot_pwd, "forgot password link");
		
	}
	public String forgotPassword(String user_nm)
	{
		enterText(forgot_user_name,user_nm,"usernm");
		clickElement(continue_btn,"continue button");
		return check_email.getText();
	}
	
	public void remember_me_btn()
	{
		clickElement(remember_me_btn,"remember button");
	}
	
	public void logout()
	{
		clickElement(user_name_lable, "user name lable");
		clickElement(log_out, "log out");
	}
}
