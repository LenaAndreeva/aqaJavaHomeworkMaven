package org.andreevaelena.homework;
import org.andreevaelena.homework.base.BaseTest;
import org.junit.Test;

import static org.andreevaelena.homework.general.ProjectData.Urls.*;

public class TestToCompareTheNumberOfProducts extends BaseTest {

    @Test
    public void testNumOfProductsInTheCart() throws InterruptedException {

        basePage.openPage(WILDBERRIES_HOME_PAGE);

        wbHeader
                .enterTheProductNameInTheSearchField();
        wbProductsListPage
                .sortProducts()
                .addProduct1ToShoppingCart()
                .addProduct2ToShoppingCart()
                .addProduct3ToShoppingCart();
        wbHeader
                .goToCart();
        wbCartPage
                .compareNumOfProductInTheCart();
    }
}
