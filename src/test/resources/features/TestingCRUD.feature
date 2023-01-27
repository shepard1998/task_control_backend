Feature: Insert Task
  Description: The purpose of these test are cover CRUD functionalities

  Scenario: Users can add new tasks
    Given A list of tasks is empty
    When I add a new task
    Then The task is added to the list and stored in database
    And new Tag list is created
    And Tag list is assigned to the Task
