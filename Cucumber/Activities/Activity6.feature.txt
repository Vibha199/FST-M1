@activity6
Feature: DataTable

  Scenario: Testing the To-Do app
    Given user is on ToDo list page
    When User enters the following tasks
      | task1 |
      | task2 |
      | task3 |
    Then tasks are added