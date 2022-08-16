package ru.gb.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPageLocators {
    public By passForm() {
        return AppiumBy.accessibilityId("input-password");
    }

    public By loginButton() {
        return AppiumBy.accessibilityId("button-LOGIN");
    }

    public By errorText() {
        return AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    }
}
