@regression
Feature: user should be able to login to the system

  Background: user open Browser
    Given user open browser
    And user navigates to login page

  #Test Scenario 1
    Scenario: user login with valid username and password

      When user enter "tomsmith" and "SuperSecretPassword!"
      And user click on login button
      #Expected Result
      Then user could login successfully
      And go to home page

  #Test Scenario 2
    Scenario: user login with invalid username and password
      Given user open browser
      And user navigates to login page
      When user enter "invalid" and "Password!"
      And user click on login button
      #Expected Result
      Then user could not login successfully
      And go to home page