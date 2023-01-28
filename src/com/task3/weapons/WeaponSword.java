package com.task3.weapons;

public class WeaponSword implements WeaponStrategy {
    int healthPerk = 30;//percent
    int powerPerk = 20;//percent
    String name = "Sword";

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
