package com.task3.utils;

import java.util.Random;

public class Rand {
    private static final Random rand = new Random();

    public static int nextInt(int min, int max) {
        return rand.nextInt(min, max);
    }

    public static int nextInt(int min, int max, int exception) {
        int returnRand;
        do {
            returnRand = rand.nextInt(min, max);
        } while (returnRand == exception);
        return returnRand;
    }
}
