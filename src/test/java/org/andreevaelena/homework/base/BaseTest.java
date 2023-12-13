package org.andreevaelena.homework.base;

import org.andreevaelena.homework.general.GeneralActions;
import org.andreevaelena.homework.pages.base.BasePage;
import org.andreevaelena.homework.pages.WbCartPage;
import org.andreevaelena.homework.pages.WbHeader;
import org.andreevaelena.homework.pages.WbProductsListPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver = GeneralActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected WbHeader wbHomePage = new WbHeader(driver);
    protected WbProductsListPage wbProductsListPage = new WbProductsListPage(driver);
    protected WbCartPage wbCartPage = new WbCartPage(driver);


    @After
    public void close() {
        driver.quit();
    }
}
