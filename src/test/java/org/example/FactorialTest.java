package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.math.BigInteger;


public class FactorialTest {

    @Test
    public void FactorialFive() {
        BigInteger result = Factorial.getFactorial(5);
        Assert.assertEquals(result, BigInteger.valueOf(120));
    }

    @Test
    public void FactorialSix() {
        BigInteger result = Factorial.getFactorial(6);
        Assert.assertEquals(result, BigInteger.valueOf(720));
    }
}