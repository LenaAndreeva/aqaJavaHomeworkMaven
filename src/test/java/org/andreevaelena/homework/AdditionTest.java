package org.andreevaelena.homework;

import org.andreevaelena.homework.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest extends BaseTest {

    @Test
    public void testAddition() {

        googleCalculatorPage
                .clickNumber3()
                .clickAddButton()
                .clickNumber5()
                .clickEquals();

        String result = googleCalculatorPage.getDisplayedResult();
        assertEquals("8", result);
    }
}
