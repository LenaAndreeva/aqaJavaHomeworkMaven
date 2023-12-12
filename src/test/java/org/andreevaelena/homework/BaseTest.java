package org.andreevaelena.homework;

import org.andreevaelena.homework.general.GeneralActions;
import org.andreevaelena.homework.pages.BasePage;
import org.andreevaelena.homework.pages.CartPage;
import org.andreevaelena.homework.pages.WildberriesHomePage;
import org.andreevaelena.homework.pages.WbProductsListPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    //тут создаем экземпляры всех страниц, используемых в тесте
    protected WebDriver driver = GeneralActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected WildberriesHomePage wildberriesHomePage = new WildberriesHomePage(driver);
    protected WbProductsListPage wbProductsListPage = new WbProductsListPage(driver);
    protected CartPage cartPage = new CartPage(driver);

    //методы

    //закрытие браузера
//    @AfterEach                   // настроить под конкретный suit
//    public void close() {
//        driver.quit();
//    }






//    // куки будут очищаться после каждого теста
//    @AfterEach
//    public void clearCookie() {
//        driver.manage().deleteAllCookies();
//    }

}
