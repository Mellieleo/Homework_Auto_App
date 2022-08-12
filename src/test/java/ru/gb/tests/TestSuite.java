package ru.gb.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)

public class TestSuite extends BaseTest {
    public static final String LOGIN_EXPECTED = "Please enter a valid email address";
    public static final String SECURE_PASS = "qwer123";
    public static final String DROPDOWN_EXPECTED = "This app is awesome";


    @Test
    public void checkEmptyEmail() {
        openApp().clickLoginButton().fillPassForm(SECURE_PASS).clickLogin().checkErrorText(LOGIN_EXPECTED);
    }

    @Test
    public void checkDropdownForm() {
        openApp().clickFormsPage().clickDropdown().selectVar().checkText(DROPDOWN_EXPECTED);
    }

    @Test
    public void checkMainScreen() {
        openApp().checkScreenshot();
    }
}
