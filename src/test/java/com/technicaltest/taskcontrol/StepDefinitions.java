package com.technicaltest.taskcontrol;

import com.technicaltest.taskcontrol.task.Task;
import groovy.util.logging.Log4j2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

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

    @Given("A list of tasks is available")
    public void a_list_of_tasks_is_available() {
        /*RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("api/v1/task");

        jsonString = response.asString();
        List<Map<String, String>> tasks = JsonPath.from(jsonString).get("task");
        Assert.assertTrue(tasks.size() > 0);

        String id = tasks.get(0).get("isbn");*/

        String url = BASE_URL + ":" + port + "/api/v1/task";
        List<Task> tasks = restTemplate.getForObject(url, List.class);
        assertTrue(tasks.isEmpty());

    }
    @When("I add a new task")
    public void i_add_a_new_task() {
        // Write code here that turns the phrase above into concrete actions
        String url = BASE_URL + ":" + port + "/api/v1/task";
        Task newTask = new Task();
        Task task = restTemplate.postForObject(url, newTask, Task.class);
        assertNotNull(task);

    }
    @Then("The task is added to the list and stored in database")
    public void the_task_is_added_to_the_list_and_stored_in_database() {
        // Write code here that turns the phrase above into concrete actions
        String url = BASE_URL + ":" + port + "/api/v1/task";
        List<Task> tasks = restTemplate.getForObject(url, List.class);
        assertTrue(!tasks.isEmpty());

    }

}
