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

public class TestPhoneNumberInfo extends BaseTests {

    @Test
    @DisplayName("Проверка отображения введенного номера телефона во фрейме")
    public void testPhoneNumberInformation() {

        WebDriver driver = initializeChromeDriver();
        visitMtsSiteAndFillInPaymentFields();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phoneNumberDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header__payment-info']")));
        String phoneNumberText = phoneNumberDisplayed.getText().replaceAll("\\s+", " ");

        Assertions.assertTrue(phoneNumberText.contains(FrameTextsData.PHONE_NUMBER_TEXT));
        driver.quit();
    }
}
