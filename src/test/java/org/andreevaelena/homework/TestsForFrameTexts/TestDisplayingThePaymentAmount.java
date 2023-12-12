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

public class TestDisplayingThePaymentAmount extends BaseTests {
    @Test
    @DisplayName("Проверка отображения введенной суммы оплаты внутри фрейма")
    public void testDisplayingThePaymentAmount() {

        WebDriver driver = initializeChromeDriver();
        visitMtsSiteAndFillInPaymentFields();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement paymentAmountDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header__payment-amount']")));
        String paymentAmountDisplayedText = paymentAmountDisplayed.getText().replaceAll("\\s+", " ");

        Assertions.assertTrue(paymentAmountDisplayedText.contains(FrameTextsData.PAYMENT_AMOUNT));
        driver.quit();
    }
}
