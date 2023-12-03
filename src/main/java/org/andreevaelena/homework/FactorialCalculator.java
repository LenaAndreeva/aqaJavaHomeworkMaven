package org.andreevaelena.homework;

public class FactorialCalculator {
    public static int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The factorial of a negative number is undefined");
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
