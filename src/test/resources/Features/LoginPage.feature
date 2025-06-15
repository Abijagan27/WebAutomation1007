Feature: Home Page Functionality

  Scenario Outline: Verify user login in the home page

    Given I am on the home page
    Then I enter login details
    Then I should be able to login

    Examples:
      | user    |
      | test123 |