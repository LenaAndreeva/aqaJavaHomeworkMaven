package org.andreevaelena.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestForMts2 {
    @Test
    public void testPaymentFormButtonFunctionality() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage(driver);
        webPageManager.fillInThePaymentFields(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement amountDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header__payment-amount']")));
        String amountText = amountDisplayed.getText().replaceAll("\\s+", " ");;
        Assertions.assertTrue(amountText.contains("5.00 BYN"));
    }
}
