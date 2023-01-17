package com.task3;

import java.util.Random;

abstract class Entity implements Actions {
    private int healthPoints;
    private int power;
    private String name;
    public Entity(int healthPoints, int power, String name){
        this.healthPoints = healthPoints;
        this.power = power;
        this.name = name;
    }

    void getDamage(int damage){healthPoints -= damage;}
    void death(){System.out.println(name + " is dead.");}
    int getHealthPoints(){
        return healthPoints;
    }
    String getName(){
        return name;
    }
    public int headKick(Random rand){
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }
    public int handKick(Random rand){
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return rand.nextInt(minDamage, maxDamage);}

    public int legKick(Random rand){
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }
}