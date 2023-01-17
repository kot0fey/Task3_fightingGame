package com.task3;

import com.task3.Entity;

import java.util.Random;

class Subzero extends Entity {
    private int healthPoints = 90;
    private final int power = 40;
    private final String name = "com.task3.Subzero";

    Random rand = new Random();
    @Override
    public int headKick() {
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int legKick() {
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return rand.nextInt(minDamage, maxDamage);    }

    @Override
    public void getDamage(int damage) {
        healthPoints -= damage;
    }

    @Override
    public void death() {
        System.out.println("com.task3.Subzero is dead.");
    }
    public String getName(){
        return "com.task3.Subzero";
    }
    public int getHealthPoints(){
        return healthPoints;
    }
}