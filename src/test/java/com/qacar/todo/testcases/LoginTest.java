package com.qacar.todo.testcases;

import com.qacar.todo.Base.BaseTest;
import com.qacar.todo.factory.DriverFactory;
import com.qacar.todo.pages.LoginPage;
import com.qacar.todo.pages.TodoPage;
import com.qacar.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login with Email and Password")
    @Description("It will login by filling the email and password and navigate to the todo page")
@Test (description = "Test the login functionality using email and password")
public void shouldBeAbleToLoginWithEmailAndPassword(){
    LoginPage loginPage = new LoginPage(getDriver());
    boolean isWelcomeDisplayed=
            loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .isWelcomeMessageDisplayed();


    Assert.assertTrue(isWelcomeDisplayed);

}

}
