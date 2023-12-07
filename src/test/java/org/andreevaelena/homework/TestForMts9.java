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
import java.util.ArrayList;
import java.util.List;

public class TestForMts9 {

    @Test
    public void testFieldInputIcons() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage(driver);
        webPageManager.fillInThePaymentFields(driver);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iconsContainer = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='icons-container ng-tns-c47-1']")));

        List<String> logoElement = getLogosFromField();

        List<WebElement> foundLogos = new ArrayList<>();
        for (String selector : logoElement) {
            List<WebElement> logos = driver.findElements(By.xpath(selector));
            foundLogos.addAll(logos);
        }

        Assertions.assertFalse(foundLogos.isEmpty(), "No logos were found on the page");
    }

    private static List<String> getLogosFromField() {
        List<String> logoElement = new ArrayList<>();
        logoElement.add("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
        logoElement.add("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
        logoElement.add("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");

        return logoElement;
    }
}

