
Feature: Salesforce Login
Background:
		Given User open Salesforce application
		 
  @tag1
  Scenario: Navigate to SFDC
   	When user on "LoginPage"
   	When user enters value into username textbox as "archana.dhokane@gmail.com"
   	When password textbox field should be empty
   	When click on Login button
   	Then error message should be displayed as "Please enter your password."
   	
 @tag2
  Scenario: Login to SFDC
   	When user on "LoginPage"
   	When user enters value into username textbox as "archana.dhokane@gmail.com"
   	When user enters value into password textbox as "asd@12345"
   	When click on Login button
   	Then verify page title as "Home Page ~ Salesforce - Developer Edition"
   	
  @tag3
  Scenario: Test the remember username checkbox
  	When user on "LoginPage"
  	When user enters value into username textbox as "archana.dhokane@gmail.com"
  	When user enters value into password textbox as "asd@12345"
   	When remember username checkbox should be selected
   	When click on Login button
   	Then verify page title as "Home Page ~ Salesforce - Developer Edition"
   	Then logout of SFDC application
   	Then validate username displayed in the username texbox field as "archana.dhokane@gmail.com"
   	
  @tag4
  Scenario: Test forgot password
  	When user on "LoginPage"
  	When user click on forgot your password
  	When user enters value into username forgot textbox as "archana.dhokane@gmail.com"
  	Then password reset message should be displayed as "Check Your Email"
  	
  @tag5 
  Scenario: Test Login with wrong username and password
   	When user on "LoginPage"
   	When user enters value into username textbox as "123"
   	When user enters value into password textbox as "22131"
   	When click on Login button
   	Then incorrect error message should be displayed as "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
  	