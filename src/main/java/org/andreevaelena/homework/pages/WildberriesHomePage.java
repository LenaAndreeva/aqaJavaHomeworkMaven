package org.andreevaelena.homework.pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WildberriesHomePage extends BasePage {

    public WildberriesHomePage(WebDriver driver) {
        super(driver);
    }

    private final By fieldForSearching = By.cssSelector("#searchInput");
    private final By searchBtn = By.xpath("//button[@id='applySearchBtn']");
    private final By getCartLogo = By.xpath("//span[contains(@class,'navbar-pc__icon navbar-pc__icon--basket')]");




    public WildberriesHomePage enterTheProductNameInTheSearchField () throws InterruptedException {

        WebElement searchField = driver.findElement(fieldForSearching);
        Thread.sleep(5000);
        waitElementIsVisible(searchField).sendKeys("светильник настольный");
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(15000);

        return this;
    }

    public WildberriesHomePage goToCart() {
        WebElement cartLogo = driver.findElement(getCartLogo);
        waitElementIsVisible(cartLogo).click();

        return this;
    }

}
