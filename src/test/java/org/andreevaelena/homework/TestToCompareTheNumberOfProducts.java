package org.andreevaelena.homework;
import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

public class TestToCompareTheNumberOfProducts extends BaseTest {

    @Test
    public void compareNumOfProducts() throws InterruptedException {

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
                .compareNumberOfProducts();




    }
}
