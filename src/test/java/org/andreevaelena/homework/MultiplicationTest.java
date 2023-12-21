package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest extends BaseTest {

    @Test
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
