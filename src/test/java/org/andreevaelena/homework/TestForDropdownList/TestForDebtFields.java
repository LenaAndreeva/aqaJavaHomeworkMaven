package org.andreevaelena.homework.TestForDropdownList;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestForDebtFields extends BaseTests {

    @Test
    @DisplayName("Проверка надписей в незаполненных полях в блоке 'Задолженность'")
    public void testDebtFieldsText() {

        WebDriver driver = initializeChromeDriver();
        visitMtsHomePage();

        WebElement dropdownBtn = driver.findElement(By.xpath("//span[@class='select__arrow']//*[name()='svg']"));
        WebElement DebtBtn = driver.findElement(By.xpath("//p[contains(text(),'Задолженность')]"));
        dropdownBtn.click();
        DebtBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement accountNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='score-arrears']")));
        WebElement paymentAmountField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='arrears-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='arrears-email']")));

        List<WebElement> fields = Arrays.asList(accountNumberField, paymentAmountField, emailField);
        List<String> expectedFieldsText = Arrays.asList(
                DropdownListOptionsData.DEBT_ACCOUNT_NUM,
                DropdownListOptionsData.DEBT_SUM,
                DropdownListOptionsData.DEBT_EMAIL
        );

        List<String> actualFieldsText = new ArrayList<>();
        for (WebElement field : fields) {
            actualFieldsText.add(field.getAttribute("placeholder"));
        }

        Assertions.assertEquals(expectedFieldsText, actualFieldsText);
        driver.quit();
    }
}
