package ru.gb.pages;

import io.qameta.allure.Step;
import ru.gb.actions.MakeScreenshot;
import ru.gb.locators.MainPageLocators;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private MainPageLocators locator(){
        return new MainPageLocators();
    }

    @Step("Entering the login page")
    public LoginPage clickLoginButton(){
        $(locator().loginMenuButton()).click();
        return new LoginPage();
    }

    @Step("Entering the forms page")
    public FormsPage clickFormsPage(){
        $(locator().formsMenuButton()).click();
        return new FormsPage();
    }

    @Step("Comparing the shots")
    public MakeScreenshot checkScreenshot(){
        return new MakeScreenshot().checkScreenshot();
    }
}
