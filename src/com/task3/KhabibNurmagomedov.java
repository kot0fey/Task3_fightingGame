package com.task3;

import com.task3.Entity;

import java.util.Random;

class KhabibNurmagomedov extends Entity {
    private int healthPoints = 150;
    private final int power = 70;
    private final String name = "Khabib Nurmagomedov";

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
        System.out.println("Khabib Nurmagomedov is dead.");
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public String getName(){
        return name;
    }
}
