package com.task3.weapons;

public abstract class WeaponEntity implements WeaponStrategy {
    protected int healthPerk;//percent
    protected int powerPerk;//percent
    protected String name;

    protected WeaponEntity(int healthPerk, int powerPerk, String name) {
        this.healthPerk = healthPerk;
        this.powerPerk = powerPerk;
        this.name = name;
    }

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
