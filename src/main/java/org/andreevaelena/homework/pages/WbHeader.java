package org.andreevaelena.homework.pages;

import org.andreevaelena.homework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.andreevaelena.homework.general.ProjectData.DataForSearchingProducts.*;

public class WbHeader extends BasePage {

    public WbHeader(WebDriver driver) {
        super(driver);
    }

    private final By fieldForSearching = By.cssSelector("#searchInput");
    private final By getCartLogo = By.xpath("//span[contains(@class,'navbar-pc__icon navbar-pc__icon--basket')]");



    public WbHeader enterTheProductNameInTheSearchField () throws InterruptedException {

        WebElement searchField = driver.findElement(fieldForSearching);
        Thread.sleep(5000);
        waitElementIsVisible(searchField).sendKeys(SEARCH_PRODUCT_NAME);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(10000);

        return this;
    }

    public WbHeader goToCart() {
        WebElement cartLogo = driver.findElement(getCartLogo);
        waitElementIsVisible(cartLogo).click();

        return this;
    }

}
