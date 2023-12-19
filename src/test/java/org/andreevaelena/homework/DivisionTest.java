package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionTest extends BaseTest {

    @Test
    public void testDivision() {

        googleCalculatorPage
                .clickNumber9()
                .clickDivideButton()
                .clickNumber3()
                .clickEquals();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("3", result);
    }
}
