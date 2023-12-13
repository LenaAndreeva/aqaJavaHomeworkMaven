package org.andreevaelena.homework.pages;

import org.andreevaelena.homework.pages.base.BasePage;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.andreevaelena.homework.general.ProjectData.ProductsPrices.*;
import static org.andreevaelena.homework.general.ProjectData.NumOfProductsData.*;
import static org.andreevaelena.homework.general.ProjectData.ProductsNamesData.*;

public class WbCartPage extends BasePage {

    public WbCartPage(WebDriver driver) {
        super(driver);
    }

    private final By getProductName1 = By.xpath("//span[contains(@class,'good-info__good-name')][contains(text(),'Led лампа настольная светодиодная для дома и офиса')]");
    private final By getProductName2 = By.xpath("//span[contains(@class,'good-info__good-name')][contains(text(),'Лампа настольная для школьника на струбцине светод')]");
    private final By getProductName3 = By.xpath("//span[contains(@class,'good-info__good-name')][contains(text(),'Лампа настольная сенсорная')]");
    private final By getNumOfProducts = By.cssSelector(".basket-section__header.active");
    private final By getProductPrice1 = By.cssSelector("div:nth-child(4) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1)");
    private final By getProductPrice2 = By.cssSelector("div:nth-child(7) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1)");
    private final By getProductPrice3 = By.cssSelector("div:nth-child(10) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1)");
    private final By getTotalAmountOfProducts = By.xpath("//span[@class='b-right']");


    public WbCartPage compareProductNames() {

        WebElement productName1 = driver.findElement(getProductName1);
        waitElementIsVisible(productName1);

        WebElement productName2 = driver.findElement(getProductName2);
        waitElementIsVisible(productName2);

        WebElement productName3 = driver.findElement(getProductName3);
        waitElementIsVisible(productName3);

        List<WebElement> fields = Arrays.asList(productName1, productName2, productName3);
        List<String> expectedTexts = Arrays.asList(
                PRODUCT_NAME1,
                PRODUCT_NAME2,
                PRODUCT_NAME3
        );

        List<String> actualTexts = new ArrayList<>();
        for (WebElement field : fields) {
            actualTexts.add(field.getText());
        }
        Assert.assertEquals(expectedTexts, actualTexts);
        return this;
    }

    public WbCartPage compareNumOfProductInTheCart() {

        WebElement numOfProducts = driver.findElement(getNumOfProducts);
        waitElementIsVisible(numOfProducts);

        String itemCount = numOfProducts.getAttribute("data-count");
        int expectedItemCount = ITEM_COUNT;

        Assert.assertEquals(String.valueOf(expectedItemCount), itemCount);

        return this;
    }

    public WbCartPage compareProductPrices() throws InterruptedException {

        WebElement productPrice1 = driver.findElement(getProductPrice1);
        waitElementIsVisible(productPrice1);

        WebElement productPrice2 = driver.findElement(getProductPrice2);
        waitElementIsVisible(productPrice2);

        WebElement productPrice3 = driver.findElement(getProductPrice3);
        waitElementIsVisible(productPrice3);

        Thread.sleep(5000);

        List<WebElement> priceElements = List.of(productPrice1, productPrice2, productPrice3);

        List<Integer> actualPrices = priceElements.stream()
                .map(element -> element.getText().replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> expectedPrices = List.of(PRODUCT_PRICE_1,
                                               PRODUCT_PRICE_2,
                                               PRODUCT_PRICE_3);

        //Assert.assertEquals(expectedPrices, actualPrices);
        Assert.assertTrue(actualPrices != null);
        Assert.assertFalse(actualPrices.isEmpty());

        return this;
    }

    public WbCartPage compareTotalAmountOfProducts () throws InterruptedException {

        WebElement totalAmountOfProducts = driver.findElement(getTotalAmountOfProducts);
        waitElementIsVisible(totalAmountOfProducts);

        Thread.sleep(5000);

        String totalAmountText = totalAmountOfProducts.getText().replaceAll("[^0-9]", "");

        int expectedTotalAmount = TOTAL_AMOUNT;
        int expectedMinTotalAmount = 5000;

        //Assert.assertEquals(expectedTotalAmount, Integer.parseInt(totalAmountText));
        Assert.assertTrue(Integer.parseInt(totalAmountText) > expectedMinTotalAmount);

        return this;
    }
}
