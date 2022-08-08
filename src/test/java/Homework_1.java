
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;

public class Homework_1 {
    public static final String LOGIN_EXPECTED = "Please enter a valid email address";
    public static final String SECURE_PASS = "qwer123";
    public static final String XPASS_LOGIN = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]";
    public static final String DROP_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]";
    public static final String DROPDOWN_EXPECTED = "This app is awesome";
    MobileDriver driver;

    @BeforeTest
    void initApp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "/home/dominic/Desktop/Android-NativeDemoApp-0.2.1.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    public void CheckEmptyEmail() throws Exception {
        Thread.sleep(3000);
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(3000);
        MobileElement passForm = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passForm.sendKeys(SECURE_PASS);
        Thread.sleep(3000);
        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(3000);
        MobileElement errorText = (MobileElement) driver.findElementByXPath(XPASS_LOGIN);
        Assert.assertEquals(errorText.getText(), LOGIN_EXPECTED);
    }

    @Test
    public void CheckDropdownForm () throws Exception {
        Thread.sleep(3000);
        MobileElement formsMenu = (MobileElement) driver.findElementByAccessibilityId("Forms");
        formsMenu.click();
        Thread.sleep(3000);
        MobileElement dropForm = (MobileElement) driver.findElementByAccessibilityId("select-Dropdown");
        dropForm.click();
        Thread.sleep(3000);
        MobileElement selectVar = (MobileElement) driver.findElementByXPath(DROP_XPATH);
        selectVar.click();
        Thread.sleep(3000);
        MobileElement filledForm = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"select-Dropdown\"]/android.widget.TextView[2]");
        Assert.assertEquals(filledForm.getText(), DROPDOWN_EXPECTED);
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
