package org.andreevaelena.homework;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionTest extends BaseTest {

    @Test
    @Feature("Calculator")
    @Story("Division")
    @Description("Test for checking the division of two integers")
    public void testDivision() {

        googleCalculatorPage
                .clickNumber9()
                .clickDivideButton()
                .clickNumber3()
                .clickEqualsButton();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("3", result);
    }
}
