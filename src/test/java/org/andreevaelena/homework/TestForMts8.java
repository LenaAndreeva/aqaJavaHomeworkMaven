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

public class TestForMts8 {

    @Test
    public void testNameInputField() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage(driver);
        webPageManager.fillInThePaymentFields(driver);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nameInputField = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']")));

        String nameInputFieldText = nameInputField.getText();
        Assertions.assertTrue(nameInputFieldText.contains("Имя держателя (как на карте)"));
    }
}
