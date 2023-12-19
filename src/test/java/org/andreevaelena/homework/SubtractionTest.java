package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractionTest extends BaseTest {

    @Test
    public void testSubtraction() {

        googleCalculatorPage
                .clickNumber5()
                .clickSubtractButton()
                .clickNumber3()
                .clickEquals();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("2", result);
    }
}
