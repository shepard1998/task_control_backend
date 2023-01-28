package com.technicaltest.taskcontrol;

import com.technicaltest.taskcontrol.task.Task;
import groovy.util.logging.Log4j2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions
{
    @LocalServerPort
    private int port;

    private static final String BASE_URL = "http://localhost";
    private static Response response;
    private static String jsonString;
    private static RestTemplate restTemplate = new RestTemplate();
    private static Long taskId;
    private static Long tagId_1;
    private static Long tagId_2;

    @Given("A list of tasks is empty")
    public void a_list_of_tasks_is_empty()
    {
        String url = BASE_URL + ":" + port + "/api/v1/task";
        List<Task> tasks = restTemplate.getForObject(url, List.class);
        assertTrue(tasks.isEmpty());
    }
    @When("I add a new task")
    public void i_add_a_new_task() {
        String url = BASE_URL + ":" + port + "/api/v1/task";
        Task newTask = new Task();
        Task task = restTemplate.postForObject(url, newTask, Task.class);
        taskId = task.getId();
        assertNotNull(task);
    }
    @Then("The task is added to the list and stored in database")
    public void the_task_is_added_to_the_list_and_stored_in_database() {
        String url = BASE_URL + ":" + port + "/api/v1/task";
        List<Task> tasks = restTemplate.getForObject(url, List.class);
        assertTrue(!tasks.isEmpty());
    }

}
