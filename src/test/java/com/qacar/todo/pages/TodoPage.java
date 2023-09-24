package com.qacar.todo.pages;

import com.qacar.todo.Base.BasePage;
import com.qacar.todo.config.EndPoint;
import com.qacar.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css="[data-testid=\"todo-item\"]")
    private WebElement toDoItem;

    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement noToDoMessage;
    @Step
    public boolean isWelcomeMessageDisplayed(){
       return welcomeMessage.isDisplayed();
    }
    @Step
    public NewToDoPage clickOnPlusButton(){
        addButton.click();
        return new NewToDoPage(driver);
    }
    @Step
    public String getToDoText(){
        return toDoItem.getText();
    }
    @Step
    public TodoPage clickOnDeleteButton(){
        deleteButton.click();
        return this;
    }
    @Step
    public boolean isNoMessageDisplayed(){
      return  noToDoMessage.isDisplayed();
    }
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }
}


