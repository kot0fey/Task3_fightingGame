package com.utils;
import java.util.Random;
public class Rand {
    private static final Random rand = new Random();

    public static int Int(int min, int max){
        return rand.nextInt(min, max);
    }
}
