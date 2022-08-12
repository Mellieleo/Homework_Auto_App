package ru.gb.actions;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import ru.gb.locators.MainPageLocators;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class MakeScreenshot {
    private MainPageLocators locator() {
        return new MainPageLocators();
    }

    public MakeScreenshot checkScreenshot() {
        BufferedImage expectedImage =
                ImageComparisonUtil.readImageFromResources("screenshots/expected/exp_img.png");
        File actualScreenshot = $(locator().homeScreen()).screenshot();
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());
        File resultDestination = new
                File("diff/diff_CheckFailMainPageScreenshot.png");
        ImageComparisonResult imageComparisonResult = new
                ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH,
                imageComparisonResult.getImageComparisonState());
        return this;
    }

    public MakeScreenshot createScreenshot() {
        $(locator().homeScreen()).screenshot();
        return null;
    }
}
