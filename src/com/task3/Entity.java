package com.task3;

import com.task3.Actions;

abstract class Entity implements Actions {
    protected int healthPoints;
    protected int power;
    protected String name;
    void getDamage(int damage){}
    abstract void death();
    int getHealthPoints(){
        return healthPoints;
    }
    String getName(){
        return name;
    }
}