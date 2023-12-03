package org.andreevaelena.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    @Test
    @DisplayName("Calculating the factorial of 0")
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    @DisplayName("Calculating the factorial of a positive number")
    public void testFactorialOfPositiveNumber() {
        assertEquals(720, FactorialCalculator.calculateFactorial(6));
    }

    @Test
    @DisplayName("Calculating the factorial of a negative number")
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(-5));
    }
}
