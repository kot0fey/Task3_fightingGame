package com.task3.weapons;

public interface WeaponStrategy {


    int setMaxHealthPointsPerk(int maxHealthPoints);


    int setPowerPerk(int power);

    String getName();

    int getHealthPointsPerk();

    int getPowerPerk();
}
