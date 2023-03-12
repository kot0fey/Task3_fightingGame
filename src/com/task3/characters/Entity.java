package com.task3.characters;

import com.task3.utils.Message;
import com.task3.weapons.WeaponStrategy;
import com.task3.utils.*;

public abstract class Entity implements Actions {
    private int healthPoints;
    protected int power;
    private final String name;
    private int maxHealthPoints;
    private WeaponStrategy weapon;

    private char winFlag = 'W';

    protected Entity(int maxHealthPoints, int power, String name) {
        this.healthPoints = maxHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.power = power;
        this.name = name;
    }

    public int getDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        return damage;
    }

    public void death() {
        Message.underLine24();
        System.out.println(name + " is dead.");
        winFlag = 'L';
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public String getName() {
        return name;
    }

    public char getWinFlag() {
        return winFlag;
    }

    public void setWinFlag(char winFlag) {
        this.winFlag = winFlag;
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

    public void setWeapon(WeaponStrategy weapon) {
        this.weapon = weapon;
        setPerks();
    }

    private void setPerks() {
        if (weapon != null) {
            maxHealthPoints = weapon.setMaxHealthPointsPerk(maxHealthPoints);
            power = weapon.setPowerPerk(power);
        }
    }

    public String getPickedWeaponName() {
        return weapon.getName();
    }

    public int getHealthPointsPerk() {
        return weapon.getHealthPointsPerk();
    }

    public int getPowerPerk() {
        return weapon.getPowerPerk();
    }

    public int getPower() {
        return power;
    }
}