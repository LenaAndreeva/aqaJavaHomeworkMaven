package org.andreevaelena.homework.TestsForPaymentFields;

import org.andreevaelena.homework.WebPageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

import java.time.Duration;

public class TestForFields {

    @Test
    public void testFieldsText() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage();
        webPageManager.fillInThePaymentFields();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    WebElement cardNumInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content ng-tns-c47-1']")));
    WebElement cardValidityPeriodField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']")));
    WebElement cvcField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']")));
    WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']")));

    List<WebElement> fields = Arrays.asList(cardNumInputField, cardValidityPeriodField, cvcField, nameField);
        List<String> expectedTexts = Arrays.asList(
                FieldsTextData.CARD_NUMBER,
                FieldsTextData.VALIDITY_PERIOD,
                FieldsTextData.CVC,
                FieldsTextData.HOLDER_NAME
        );

    List<String> actualTexts = new ArrayList<>();
    for (WebElement field : fields) {
        actualTexts.add(field.getText());
    }

    Assertions.assertEquals(expectedTexts, actualTexts);
}
}
