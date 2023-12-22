package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import io.qameta.allure.Story;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest extends BaseTest {

    @Test
    @Feature("Calculator")
    @Story("Addition")
    @Description("Test for checking the addition of two integers")
    public void testAddition() {

        googleCalculatorPage
                .clickNumber3()
                .clickAddButton()
                .clickNumber5()
                .clickEqualsButton();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("8", result);
    }
}
