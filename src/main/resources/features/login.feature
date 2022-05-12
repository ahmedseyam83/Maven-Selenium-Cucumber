@regression
Feature: user should be able to register to the system

  Background: user open Browser
    Given user open browser
    And user navigates to Register page

  #Test Scenario 2:
    Scenario: user could not register with valid data
      When user enter "invalid firstname" and "invalid lastname" and "invalid email" and "invalid password"
      And user click on register button
      #Expected Result
      Then user could not register successfully
  #Test Scenario 1:
    Scenario: User could register with valid data
      When user enter "valid firstname" and "valid lastname" and "valid email" and "valid password"
      And user click on register button
      #Expected Result
      Then user registered successfully
      And go to home page



Feature: user should be able to login to the system

  Background: user open Browser
    Given user open browser
    And user navigates to login page

  #Test Scenario 1:
    Scenario: user login with invalid username and password
      When user enter "invalid username" and "invalid password"
      And user click on login button
      #Expected Result
      Then user could not login successfully


  #Test Scenario 2:
    Scenario: user login with valid username and password
      When user enter "valid username" and "valid password"
      And user click on login button
      #Expected Result
      Then go to home page



Feature: user could reset password
  Background: user open Browser
    Given user open browser
    And user navigates to login page

  #Test Scenario 1:
    Scenario: Reset password success
      When user click on forget password link
      And user click on reset Button
      #Expected Result
      Then instruction sent to user


 Feature: Search for any thing
   Background: user open Browser
     Given user open browser
     And user navigates to home page

  #Test Scenario 1:
  Scenario: Search about a product successfully
    When user search about "laptops" products
    #Expected Result
    Then navigates to search result

  #Test Scenario 2:
   Scenario: Search about a product fails
     When user search about "doctor" products
     Then navigates to search result
     #Expected Result
     And Not found a result


 Feature: Switch between US-Euro
   Background: user open Browser
     Given user open browser
     And user navigates to home page
     And user search about "laptops" products

  #Test Scenario 1:
   Scenario: Change from US - Euro successfully
     When user change currency from US-Euro
     #Expected Result
     Then the price of products change by 0.95*price
   #Test Scenario 2:
   Scenario: Change from Euro - US successfully
   #Test Scenario 2:
   Scenario: Change from US - Euro fail
   #Test Scenario 2:
   Scenario: Change from Euro - US fail









