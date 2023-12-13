package org.andreevaelena.homework.pages;

import org.andreevaelena.homework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WbProductsListPage extends BasePage {

    public WbProductsListPage(WebDriver driver) {
        super(driver);
    }



 private final By getSortDropdownBtn = By.cssSelector(".dropdown-filter__btn.dropdown-filter__btn--sorter");
 private final By getSortByRatingBtn = By.xpath("//li[2]//div[1]//span[1]");
 private final By getproduct1 = By.xpath("//article[@id='c65848828']//a[contains(@aria-label,'Лампа настольная сенсорная Cosmo Group')]");
 private final By getProduct2 = By.xpath("//a[contains(@aria-label,'Лампа настольная для школьника на струбцине светодиодная Real Master')]");
 private final By getProduct3 = By.xpath("//article[@id='c90033232']//a[contains(@aria-label,'Led лампа настольная светодиодная для дома и офиса LunaLight')]");

 private final By getAddProduct1Btn = By.xpath("//article[@id='c65848828']//a[contains(@class,'product-card__add-basket j-add-to-basket btn-main-sm')]");
 private final By getAddProduct2Btn = By.xpath("//article[@id='c65906646']//a[contains(@class,'product-card__add-basket j-add-to-basket btn-main-sm')]");
 private final By getGetAddProduct3Btn = By.xpath("//article[@id='c90033232']//a[contains(@class,'product-card__add-basket j-add-to-basket btn-main-sm')]");



   public WbProductsListPage sortProducts() {
       WebElement sortDropdownBtn = driver.findElement(getSortDropdownBtn);
       waitElementIsVisible(sortDropdownBtn).click();

       WebElement sortByRatingBtn = driver.findElement(getSortByRatingBtn);
       waitElementIsVisible(sortByRatingBtn).click();

       return this;
   }

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
}
