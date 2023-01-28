package com.task3.weapons;

public class WeaponAxe implements WeaponStrategy {
    int healthPerk = 0;//percent
    int powerPerk = 50;//percent
    String name = "Axe";

    public int setMaxHealthPointsPerk(int maxHealthPoints) {
        maxHealthPoints *= (100 + healthPerk);
        maxHealthPoints /= 100;
        return maxHealthPoints;
    }

    public int setPowerPerk(int power) {
        power *= (100 + powerPerk);
        power /= 100;
        return power;
    }

    public String getName() {
        return name;
    }

    public int getHealthPointsPerk() {
        return healthPerk;
    }

    public int getPowerPerk() {
        return powerPerk;
    }
}
