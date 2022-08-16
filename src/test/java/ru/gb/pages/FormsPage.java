package ru.gb.pages;

import io.qameta.allure.Step;
import ru.gb.locators.FormsPageLocators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FormsPage {
    private FormsPageLocators locator(){
        return new FormsPageLocators();
    }

    @Step("Calling the dropdown menu")
    public FormsPage clickDropdown(){
        $(locator().dropdownForm()).click();
        return this;
    }

    @Step("Selecting the variant")
    public FormsPage selectVar(){
        $(locator().selectVariant()).click();
        return this;
    }

    @Step("Checking if the variant is selected")
    public FormsPage checkText(String expectText){
        $(locator().filledForm()).is(text(expectText));
        return this;
    }
}
