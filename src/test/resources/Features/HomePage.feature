Feature: Home Page Functionality

  Scenario Outline: Verify home page title and presence of a logo
    Given I am on the home page
    Then I should see the title
    And I should see the current url
    Then I should register
    Examples:
      | user    |
      | test123 |
