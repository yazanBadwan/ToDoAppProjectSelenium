package com.qacar.todo.pages;

import com.qacar.todo.Base.BasePage;
import com.qacar.todo.config.EndPoint;
import com.qacar.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToDoPage extends BasePage {
    public NewToDoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newToDoInput;

    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement NewToDoSubmit;
    @Step
    public NewToDoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_END_POINT);

   return this;}
    @Step
    public TodoPage addNewTask(String item){
        newToDoInput.sendKeys(item);
        NewToDoSubmit.click();
        return new  TodoPage(driver);
    }



}
