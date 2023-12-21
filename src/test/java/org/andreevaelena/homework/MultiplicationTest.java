package org.andreevaelena.homework;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest extends BaseTest {

    @Test
    @Feature("Calculator")
    @Story("Multiplication")
    @Description("Test for checking the multiplication of two integers")
    public void testMultiplication() {

        googleCalculatorPage
                .clickNumber3()
                .clickMultiplyButton()
                .clickNumber5()
                .clickEqualsButton();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("15", result);
    }
}
