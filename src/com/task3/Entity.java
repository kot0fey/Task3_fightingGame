package com.task3;

import com.utils.*;

abstract class Entity implements Actions {
    private int healthPoints;
    protected int power;
    private final String name;
    final private int maxHealthPoints;
    protected Entity(int maxHealthPoints, int power, String name){
        this.healthPoints = maxHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.power = power;
        this.name = name;
    }

    void getDamage(int damage){
        healthPoints -= damage;
    }
    void death(){System.out.println(name + " is dead.");}
    int getHealthPoints(){
        return healthPoints;
    }
    int getMaxHealthPoints(){
        return maxHealthPoints;
    }
    String getName(){
        return name;
    }
    public int headKick(){
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return Rand.Int(minDamage, maxDamage);
    }
    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return Rand.Int(minDamage, maxDamage);
    }
    public int legKick(){
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return Rand.Int(minDamage, maxDamage);
    }
}