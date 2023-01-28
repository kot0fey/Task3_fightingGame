package com.task3;

import com.task3.weapons.WeaponStrategy;
import com.utils.*;

abstract class Entity implements Actions {
    private int healthPoints;
    protected int power;
    private final String name;
    private int maxHealthPoints;
    private WeaponStrategy weapon;

    protected Entity(int maxHealthPoints, int power, String name) {
        this.healthPoints = maxHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.power = power;
        this.name = name;
    }

    int getDamage(int damage) {
        healthPoints -= damage;
        return damage;
    }

    void death() {
        Message.underLine24();
        System.out.println(name + " is dead.");
        Message.underLine48();
    }

    int getHealthPoints() {
        return healthPoints;
    }

    int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    String getName() {
        return name;
    }

    public int headKick() {
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return Rand.nextInt(minDamage, maxDamage);
    }

    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return Rand.nextInt(minDamage, maxDamage);
    }

    public int legKick() {
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return Rand.nextInt(minDamage, maxDamage);
    }

    protected void setWeapon(WeaponStrategy weapon) {
        this.weapon = weapon;
        setPerks();
        System.out.println(maxHealthPoints);
    }

    private void setPerks() {
        if (weapon != null) {
            maxHealthPoints = weapon.setMaxHealthPointsPerk(maxHealthPoints);
            power = weapon.setPowerPerk(power);
        }
    }

    protected String getPickedWeaponName() {
        return weapon.getName();
    }

    protected int getHealthPointsPerk() {
        return weapon.getHealthPointsPerk();
    }

    protected int getPowerPerk() {
        return weapon.getPowerPerk();
    }

    public int getPower() {
        return power;
    }
}