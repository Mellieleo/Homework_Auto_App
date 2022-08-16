package ru.gb.pages;

import io.qameta.allure.Step;
import ru.gb.locators.LoginPageLocators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private LoginPageLocators locator(){
        return new LoginPageLocators();
    }

    @Step("Fill the password")
    public LoginPage fillPassForm(String pswd){
        $(locator().passForm()).setValue(pswd);
        return this;
    }

    @Step("Click the submit button")
    public LoginPage clickLogin(){
        $(locator().loginButton()).click();
        return this;
    }

    @Step("Check if the message appears")
    public LoginPage checkErrorText(String errorText){
        $(locator().errorText()).is(text(errorText));
        return this;
    }
}
