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

public class TestForInstallmentFields extends BaseTests{

    @Test
    @DisplayName("Проверка надписей в незаполненных полях в блоке 'Рассрочка'")
    public void testInstallmentFieldsText() {

        WebDriver driver = initializeChromeDriver();
        visitMtsHomePage();

        WebElement dropdownBtn = driver.findElement(By.xpath("//span[@class='select__arrow']//*[name()='svg']"));
        WebElement InstallmentBtn = driver.findElement(By.xpath("//p[contains(text(),'Рассрочка')]"));
        dropdownBtn.click();
        InstallmentBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement accountNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='score-instalment']")));
        WebElement paymentAmountField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='instalment-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='instalment-email']")));

        List<WebElement> fields = Arrays.asList(accountNumberField, paymentAmountField, emailField);
        List<String> expectedFieldsText = Arrays.asList(
                DropdownListOptionsData.INSTALLMENT_ACCOUNT_NUM,
                DropdownListOptionsData.INSTALLMENT_SUM,
                DropdownListOptionsData.INSTALLMENT_EMAIL
        );

        List<String> actualFieldsText = new ArrayList<>();
        for (WebElement field : fields) {
            actualFieldsText.add(field.getAttribute("placeholder"));
        }

        Assertions.assertEquals(expectedFieldsText, actualFieldsText);
        driver.quit();
    }
}
