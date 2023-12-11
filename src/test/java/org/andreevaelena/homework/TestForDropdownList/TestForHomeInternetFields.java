package org.andreevaelena.homework.TestForDropdownList;

import org.andreevaelena.homework.WebPageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
public class TestForHomeInternetFields {
    @Test
    @DisplayName("Проверка надписей в незаполненных полях в блоке 'Домашний интернет'")
    public void testHomeInternetFieldsText() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        driver.manage().window().maximize();
        webPageManager.visitMtsHomePage();

        WebElement dropdownBtn = driver.findElement(By.xpath("//span[@class='select__arrow']//*[name()='svg']"));
        WebElement homeInternetBtn = driver.findElement(By.cssSelector("div[id='pay-section'] li:nth-child(2) p:nth-child(1)"));
        dropdownBtn.click();
        homeInternetBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phoneNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='internet-phone']")));
        WebElement paymentAmountField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='internet-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='internet-email']")));

        List<WebElement> fields = Arrays.asList(phoneNumberField, paymentAmountField, emailField);
        List<String> expectedFieldsText = Arrays.asList(
                "Номер абонента",
                "Сумма",
                "E-mail для отправки чека"
        );

        List<String> actualFieldsText = new ArrayList<>();
        for (WebElement field : fields) {
            actualFieldsText.add(field.getAttribute("placeholder"));
        }

        Assertions.assertEquals(expectedFieldsText, actualFieldsText);
        driver.quit();


    }

}
