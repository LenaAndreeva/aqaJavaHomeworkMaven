package org.andreevaelena.homework.TestForDropdownList;

import org.andreevaelena.homework.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestForServiceConnectionFields extends BaseTests {

    @Test
    @DisplayName("Проверка надписей в незаполненных полях в блоке 'Услуги связи'")
    public void testServiceConnectionFieldsText() {

        WebDriver driver = initializeChromeDriver();
        visitMtsHomePage();

        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement paymentAmountField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@id='connection-email']"));

        List<WebElement> fields = Arrays.asList(phoneNumberField, paymentAmountField, emailField);
        List<String> expectedFieldsText = Arrays.asList(
                DropdownListOptionsData.SERVICE_CONNECTION_PHONE_NUM,
                DropdownListOptionsData.SERVICE_CONNECTION_SUM,
                DropdownListOptionsData.SERVICE_CONNECTION_EMAIL
        );
        List<String> actualFieldsText = new ArrayList<>();
        for (WebElement field : fields) {
            actualFieldsText.add(field.getAttribute("placeholder"));
        }

        Assertions.assertEquals(expectedFieldsText, actualFieldsText);
        driver.quit();
    }
}
