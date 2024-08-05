#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: GoogleSearch

  @Search
  Scenario: Verify the user is able to access Demo_blaze website on Google search
    Given User is on WebBrowser
    When User launches Google Home page
    And User enters the Demo_blaze url and Clicks on DemoBlaze URL from search result
    Then User should navigate to DemoBlazeHome page

  @Greetings
  Scenario Outline: Verify the user greetings is displayed in DemoBlaze Home page after login
    Given User is on WebBrowser
    And User launches Google Home page
    And User enters the Demo_blaze url and Clicks on DemoBlaze URL from search result
    And User clicks on Login 
    When User enters valid <username> and <password>
    Then Greetings message displayed with <username>

  @Signin
  Scenario: To verify that Sign up page should open
    Given User is on WebBrowser
    When User launches DemoBlaze Home page
    And Click on Sign Up
    Then Sign Up page should open
    
  @SignInSuccess
  Scenario: To verify that the Sign up should be successful
  	Given User is on WebBrowser
    When User launches DemoBlaze Home page
    And Click on Sign Up
    And Enter the details and click on sign in
    Then Sign in should be successful

		
   Examples: 
      | username | password |
      | aa1bb2cc3| aa1bb2cc3|
      | 11q22w33e| 11q22w33e|
