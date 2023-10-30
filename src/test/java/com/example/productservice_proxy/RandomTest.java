package com.example.productservice_proxy;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {
    @Test
    public void testRandom(){
        Random random = new Random();
        int randomInt = random.nextInt(10);

        assert(randomInt < 5);
    }

    @Test
    public void testRandom2(){

        int a = 10*10;

        assert(a == 100);
    }
}
