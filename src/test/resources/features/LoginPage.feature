@Regression
Feature: Login Page feature

#
#  @chapter1Validation
#  Scenario Outline: validation of header option
#    Given User navigates to the application
#    When User clicks on "<linkName>" option
#    Then Verify if the logo is displayed correctly
#
#  Examples:
#    |linkName |
#    |My Account|
#    |Shopping Cart|
#    |Wish List (0)|
#    |Checkout|

@Smoke @Regression
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Automation Exercise - Signup / Login"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "nabanita@gmail.com"
    And user enters password "test123@"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "Automation Exercise"