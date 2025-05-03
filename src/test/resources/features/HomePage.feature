@Regression
Feature: Account Page Feature

  Background:
    Given user has already logged in to application
      |username|password|
      |nabanita@gmail.com|test123@|

  @accounts @Smoke
  Scenario: Accounts page title
    Given user is on Home page
    When user gets the title of the page
    Then page title should be "Automation Exercise"

  @accounts @Smoke
  Scenario: Accounts section count
    Given user is on Home page
    Then user gets HomePage section
      |Products|
      |Cart|
      |Contact us|
      |Home|
      |Logged in as Nabanita|
      |Logout|
    And accounts section count should be 9