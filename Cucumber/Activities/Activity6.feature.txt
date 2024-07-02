@SmokeTest
@activity5
Feature: Data driven test with Data Table

  Scenario: Testing with Data from Data Table
    Given User is on Login page
    When User enters Usernames and Password
      | usernames | password |
      | admin     | password |
    Then Read the page title and confirmation message
    And Close the Browser