package ru.gb.listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        if (result.getName().contains("Screenshot")) {
            String filePath = "diff/diff_" + testName + ".png";
            try {
                saveScreenshot(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            saveScreenshot(Selenide.screenshot(OutputType.BYTES));
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
