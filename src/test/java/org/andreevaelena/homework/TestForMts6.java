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

public class TestForMts6 {

    @Test
    public void testTimeField() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage(driver);
        webPageManager.fillInThePaymentFields(driver);

        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement timeField = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']")));
        String timeFieldInputText = timeField.getText();
        Assertions.assertTrue(timeFieldInputText.contains("Срок действия"));
    }
}
