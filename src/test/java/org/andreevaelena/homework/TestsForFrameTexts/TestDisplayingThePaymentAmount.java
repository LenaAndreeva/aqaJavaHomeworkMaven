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

public class TestDisplayingThePaymentAmount {
    @Test
    public void testDisplayingThePaymentAmount() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsSiteAndFillInPaymentFields();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement paymentAmountDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header__payment-amount']")));
        String paymentAmountDisplayedText = paymentAmountDisplayed.getText();

        Assertions.assertTrue(paymentAmountDisplayedText.contains(FrameTextsData.PAYMENT_AMOUNT));
        driver.quit();
    }
}
