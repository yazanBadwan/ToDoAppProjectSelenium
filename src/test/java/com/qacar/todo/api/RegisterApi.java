package com.qacar.todo.api;

import com.qacar.todo.config.EndPoint;
import com.qacar.todo.objects.User;
import com.qacar.todo.utils.ConfigUtils;
import com.qacar.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;

    private String userId;

    private String firstName;

    public String getFirstName(){
        return this.firstName;
    }

    public String getToken(){
        return this.accessToken;
    }
    public String getUserId(){
        return this.userId;
    }
    public List<Cookie> getCookies(){
        return this.restAssuredCookies;
    }

    public void register(){
        //Given:any things write its connect with request
        //When:the type of request and end point
        //Then:all things in response and we have accesses on

        User user = UserUtils.generateRandomUser();

        Response response=
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                .when()
                         .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                         .extract().response();
        if(response.statusCode()!=201){
            throw  new RuntimeException("Something went wrong with the request");
        }
        restAssuredCookies = response.detailedCookies().asList();
        accessToken=response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
