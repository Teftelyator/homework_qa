package org.example;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger getFactorial(int f) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= f; i++)
            result = result.multiply(BigInteger.valueOf(i));
        System.out.println(result);
        return result;
    }
}
