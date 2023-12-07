package org.andreevaelena.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestForMts4 {

    @Test
    public void testPhoneNumberInformation() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage(driver);
        webPageManager.fillInThePaymentFields(driver);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phoneNumberDisplayed = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header__payment-info']")));
        String phoneNumberText = phoneNumberDisplayed.getText().replaceAll("\\s+", " ");

        Assertions.assertTrue(phoneNumberText.contains("Оплата: Услуги связи Номер:375297777777"));
    }
}
