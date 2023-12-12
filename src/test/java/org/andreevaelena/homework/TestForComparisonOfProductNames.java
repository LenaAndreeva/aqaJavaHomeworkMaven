package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

public class TestForComparisonOfProductNames extends BaseTest {


    @Test
    public void compareProductNames() throws InterruptedException {
        basePage.openPage("https://www.wildberries.ru");

        wildberriesHomePage
                .enterTheProductNameInTheSearchField();
        wbProductsListPage
                .addProduct1ToShoppingCart()
                .addProduct2ToShoppingCart()
                .addProduct3ToShoppingCart();
        wildberriesHomePage
                .goToCart();
        cartPage
                .compareProductsNames();

    }

}