package com.qacar.todo.api;

import com.qacar.todo.config.EndPoint;
import com.qacar.todo.objects.Task;
import com.qacar.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
    public void addTask(String token){
        Task task = new Task("learn Selenium",false);
        Response response =
    given()
            .baseUri(ConfigUtils.getInstance().getBaseUrl())
           .header("Content-Type","application/json")
           .body(task)
           .auth().oauth2(token)
    .when()
           .post(EndPoint.API_TASK_ENDPOINT)
     .then()
           .log().all().extract().response();
        if (response.statusCode()!=201)
            throw new RuntimeException("something went wrong in adding the todo error");
    }
}
