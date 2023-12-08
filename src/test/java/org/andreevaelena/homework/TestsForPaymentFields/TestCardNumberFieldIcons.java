package org.andreevaelena.homework.TestsForPaymentFields;

import org.andreevaelena.homework.WebPageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCardNumberFieldIcons {

    @Test
    public void testCardNumberFieldIcons() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsSiteAndFillInPaymentFields();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iconsContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='icons-container ng-tns-c47-1']")));

        List<String> logoElement = Arrays.asList(
                "//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']",
                "//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']",
                "//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"
        );

        List<WebElement> foundLogos = new ArrayList<>();
        for (String selector : logoElement) {
            WebElement logo = driver.findElement(By.xpath(selector));
            foundLogos.add(logo);
        }

        Assertions.assertFalse(foundLogos.isEmpty());
    }
}

