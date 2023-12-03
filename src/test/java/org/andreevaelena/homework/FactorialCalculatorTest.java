package org.andreevaelena.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {
    @Test(description = "Calculating the factorial of 0")
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test(description = "Calculating the factorial of a positive number")
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(6), 720);
    }

    @Test(description = "Calculating the factorial of a negative number",
            expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-5);
    }
}
