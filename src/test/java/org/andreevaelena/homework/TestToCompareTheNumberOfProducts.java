package org.andreevaelena.homework;
import org.andreevaelena.homework.base.BaseTest;
import org.junit.Test;

import static org.andreevaelena.homework.general.ProjectData.Urls.*;

public class TestToCompareTheNumberOfProducts extends BaseTest {

    @Test
    public void testNumOfProductsInTheCart() throws InterruptedException {

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
                .compareNumOfProductInTheCart();

    }
}
