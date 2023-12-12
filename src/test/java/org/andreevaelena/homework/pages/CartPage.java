package org.andreevaelena.homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By getProductName1 = By.xpath("//span[contains(@class,'good-info__good-name')][contains(text(),'Лампа Настольная Беспроводная для дома и офиса')]");
    private final By getProductName2 = By.xpath("//div[contains(@class,'accordion__body j-b-list-content')]//div[2]//div[1]//div[1]//div[1]//a[1]//span[1]");
    private final By getGetProductName3 = By.xpath("//div[3]//div[1]//div[1]//div[1]//a[1]//span[1]");

    private final By getPoductQuantity = By.xpath("//h1[@class='basket-section__header active']");




    public CartPage compareProductsNames() throws InterruptedException {

        Thread.sleep(10000);

        WebElement productName1 = driver.findElement(getProductName1);
        waitElementIsVisible(productName1);

        WebElement productName2 = driver.findElement(getProductName2);
        waitElementIsVisible(productName2);

        WebElement productName3 = driver.findElement(getGetProductName3);
        waitElementIsVisible(productName3);

        List<WebElement> fields = Arrays.asList(productName1, productName2, productName3);
        List<String> expectedTexts = Arrays.asList(
                "Лампа Настольная Беспроводная для дома и офиса",
                "Лампа настольная светодиодная светильник на стол",
                "Лампа настольная светодиодная светильник на стол"
        );

        List<String> actualTexts = new ArrayList<>();
        for (WebElement field : fields) {
            actualTexts.add(field.getText().replaceAll("\\s+", " "));
        }

        Assertions.assertEquals(expectedTexts, actualTexts);

        return this;
    }

    public CartPage compareNumberOfProducts() {

        WebElement productQuantity = driver.findElement(getPoductQuantity);

        String itemCount = productQuantity.getAttribute("data-count");
        int expectedItemCount = 3;

        Assertions.assertEquals(String.valueOf(expectedItemCount), itemCount,
                "Количество товаров в корзине не соответствует ожидаемому значению");

        return this;
    }

}

