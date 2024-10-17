package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {


    @Test
    void getFactorialFive() {
        var factorial = new Factorial();
        assertEquals(BigInteger.valueOf(120), factorial.getFactorial(5));
    }
    @Test
    void getFactorialSix() {
        var factorial = new Factorial();
        assertEquals(BigInteger.valueOf(720), factorial.getFactorial(6));
    }
}