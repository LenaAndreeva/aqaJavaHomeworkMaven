package org.andreevaelena.homework;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Story;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractionTest extends BaseTest {

    @Test
    @Feature("Calculator")
    @Story("Subtraction")
    @Description("Test for subtracting two integers")
    public void testSubtraction() {

        googleCalculatorPage
                .clickNumber5()
                .clickSubtractButton()
                .clickNumber3()
                .clickEqualsButton();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("2", result);
    }
}
