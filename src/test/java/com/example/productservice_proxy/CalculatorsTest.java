package com.example.productservice_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorsTest {
    @Test
    @DisplayName("Testing add method")
    public void Test_addtwoIntreturnInt(){
        Calculators calculators = new Calculators();
        int result = calculators.add(10,20);
        assertEquals(30,result);
    }
    @Test
    @DisplayName("Testing when denominator is zero")
    public void Test_divideByZero(){
        Calculators calculators = new Calculators();
        assertThrows(ArithmeticException.class,()->calculators.divide(10,0));
    }

}