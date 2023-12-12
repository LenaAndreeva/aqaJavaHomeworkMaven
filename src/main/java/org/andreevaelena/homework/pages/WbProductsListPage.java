package org.andreevaelena.homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WbProductsListPage extends BasePage {

    public WbProductsListPage(WebDriver driver) {
        super(driver);
    }

 private final By getproduct1 = By.xpath("//article[@id='c67296866']//a[@aria-label='Лампа настольная светодиодная светильник на стол Light&Style']");
 private final By getProduct2 = By.xpath("//article[@id='c109428224']//a[contains(@aria-label,'Лампа настольная светодиодная светильник на стол Light&Style')]");
 private final By getProduct3 = By.xpath("//a[contains(@aria-label,'Лампа Настольная Беспроводная для дома и офиса Homely store')]");

 private final By getAddProduct1Btn = By.xpath("//article[@id='c67296866']//a[contains(@class,'product-card__add-basket j-add-to-basket btn-main-sm')]");
 private final By getAddProduct2Btn = By.xpath("//article[@id='c109428224']//a[contains(@class,'product-card__add-basket j-add-to-basket btn-main-sm')]");
 private final By getGetAddProduct3Btn = By.xpath("//article[@id='c182832631']//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']");



    public WbProductsListPage addProduct1ToShoppingCart () {

        WebElement productCard1 = driver.findElement(getproduct1);
        waitElementIsVisible(productCard1);

        Actions actions = new Actions(driver);
        actions.moveToElement(productCard1).perform();

        WebElement addProduct1ToCart = driver.findElement(getAddProduct1Btn);
        waitElementIsVisible(addProduct1ToCart).click();

        return this;
    }

    public WbProductsListPage addProduct2ToShoppingCart() {

        WebElement productCard2 = driver.findElement(getProduct2);
        waitElementIsVisible(productCard2);

        Actions actions = new Actions(driver);
        actions.moveToElement(productCard2).perform();

        WebElement addProduct2ToCart = driver.findElement(getAddProduct2Btn);
        waitElementIsVisible(addProduct2ToCart).click();

        return this;
    }


    public WbProductsListPage addProduct3ToShoppingCart() {

        WebElement productCard3 = driver.findElement(getProduct3);
        waitElementIsVisible(productCard3);

        Actions actions = new Actions(driver);
        actions.moveToElement(productCard3).perform();

        WebElement addProduct3ToCard = driver.findElement(getGetAddProduct3Btn);
        waitElementIsVisible(addProduct3ToCard).click();

        return this;
    }



    //private final By paramsBtn = By.cssSelector(".dropdown-filter__btn.dropdown-filter__btn--sorter");
// private final By sortingBtn = By.cssSelector("div[class='wrapper'] li:nth-child(2) div:nth-child(1) span:nth-child(1)");



    //public WbProductsListPage chooseTheParam() {
//
//        WebElement checkParamsBtn = driver.findElement(paramsBtn);
//        waitElementIsVisible(checkParamsBtn).click();
//
//        WebElement sortProductsBtn = driver.findElement(sortingBtn);
//        waitElementIsVisible(sortProductsBtn).click();
//
//        //Assertions.assertTrue(productCard1.isDisplayed());
//
//        return this;
//    }

}
