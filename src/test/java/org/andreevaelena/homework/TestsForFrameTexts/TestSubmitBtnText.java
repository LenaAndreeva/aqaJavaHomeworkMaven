package org.andreevaelena.homework.TestsForFrameTexts;

import org.andreevaelena.homework.WebPageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSubmitBtnText {
    @Test
    public void testSubmitBtnText() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsSiteAndFillInPaymentFields();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='colored disabled ng-star-inserted']")));
        String submitButtonText = submitButton.getText().replaceAll("\\s+", " ");

        Assertions.assertTrue(submitButtonText.contains(FrameTextsData.SUBMIT_BUTTON_TEXT));
        driver.quit();
    }
}
