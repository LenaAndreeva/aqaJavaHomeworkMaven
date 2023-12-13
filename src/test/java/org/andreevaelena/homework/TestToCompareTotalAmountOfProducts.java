package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.andreevaelena.homework.general.ProjectData;
import org.junit.Test;

import static org.andreevaelena.homework.general.ProjectData.Urls.*;

public class TestToCompareTotalAmountOfProducts extends BaseTest {

    @Test
    public void testTheCorrectDisplayOfTheTotalAmountOfProducts() throws InterruptedException {
        basePage.openPage(WILDBERRIES_HOME_PAGE);

        wbHomePage
                .enterTheProductNameInTheSearchField();
        wbProductsListPage
                .addProduct1ToShoppingCart()
                .addProduct2ToShoppingCart()
                .addProduct3ToShoppingCart();
        wbHomePage
                .goToCart();
        wbCartPage
                .compareTotalAmountOfProducts();

    }
}
