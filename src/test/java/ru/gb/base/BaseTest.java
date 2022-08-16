package ru.gb.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import ru.gb.pages.MainPage;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    WebDriver driver;

    public MainPage openApp() {
        driver = getDriver();
        WebDriverRunner.setWebDriver(driver);
        return new MainPage();
    }

    private WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "/home/dominic/Desktop/Android-NativeDemoApp-0.2.1.apk");
        Configuration.reportsFolder = "screenshots/actual";
        try {
            return new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
