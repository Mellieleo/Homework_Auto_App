package ru.gb.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MainPageLocators {
    public By loginMenuButton() {
        return AppiumBy.accessibilityId("Login");
    }

    public By formsMenuButton() {
        return AppiumBy.accessibilityId("Forms");
    }

    public By homeScreen() {
        return AppiumBy.accessibilityId("Home-screen");
    }
}
