package ru.gb.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FormsPageLocators {
    public By dropdownForm(){
        return AppiumBy.accessibilityId("select-Dropdown");
    }

    public By selectVariant(){
        return AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]");
    }

    public By filledForm(){
        return AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"select-Dropdown\"]/android.widget.TextView[2]");
    }
}
