package com.qacar.todo.testcases;

import com.qacar.todo.Base.BaseTest;
import com.qacar.todo.api.RegisterApi;
import com.qacar.todo.api.TasksApi;
import com.qacar.todo.factory.DriverFactory;
import com.qacar.todo.pages.LoginPage;
import com.qacar.todo.pages.NewToDoPage;
import com.qacar.todo.pages.TodoPage;
import com.qacar.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Todo Feature")
public class ToDoTest extends BaseTest {
    @Story("Add Todo")
    @Test (description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewToDo(){

        RegisterApi registerApi=new RegisterApi();
        registerApi.register();
        NewToDoPage newToDoPage = new NewToDoPage(getDriver());
        newToDoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult= newToDoPage
               .load()
               .addNewTask("learn Selenium")
               .getToDoText();
        Assert.assertEquals(actualResult,"learn Selenium");

    }
    @Story("Delete Todo")
    @Test (description = "Should be able to delete a todo correctly")
    public void shouldBeAbleToDeleteToDo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean isNoToDoMessageDisplayed = todoPage
                .load()
                .clickOnDeleteButton()
                .isNoMessageDisplayed();
        Assert.assertTrue(isNoToDoMessageDisplayed);
    }

}
