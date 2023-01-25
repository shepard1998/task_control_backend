package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps
{
    private static final String BASE_URL = "http://localhost:8080/api/v1/task";

    @Given("A list of tasks is available")
    public void a_list_of_tasks_is_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I add a new task")
    public void i_add_a_new_task() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The task is added to the list and stored in database")
    public void the_task_is_added_to_the_list_and_stored_in_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
