Feature: Insert Task
  Description: The purpose of these test are cover CRUD functionalities

  Scenario: Users can add new tasks
    Given A list of tasks is available
    When I add a new task
    Then The task is added to the list and stored in database
