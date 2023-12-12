package org.andreevaelena.homework.TestsForFrameTexts;

import org.andreevaelena.homework.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSubmitBtnText extends BaseTests {
    @Test
    @DisplayName("Проверка текста на кнопке для оплаты внутри фрейма")
    public void testSubmitBtnText() {

        WebDriver driver = initializeChromeDriver();
        visitMtsSiteAndFillInPaymentFields();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='colored disabled ng-star-inserted']")));
        String submitButtonText = submitButton.getText().replaceAll("\\s+", " ");

        Assertions.assertTrue(submitButtonText.contains(FrameTextsData.SUBMIT_BUTTON_TEXT));
        driver.quit();
    }
}
