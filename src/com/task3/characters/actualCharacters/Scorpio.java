package com.task3.characters.actualCharacters;

import com.task3.characters.Entity;
import com.task3.utils.Rand;

public class Scorpio extends Entity {
    public Scorpio() {
        super(100, 50, "Scorpio");
    }

    public int headKick() {
        int k;
        if (getHealthPoints() < getMaxHealthPoints() * 0.3) {
            k = 2;
        } else {
            k = 1;
        }
        int maxDamage = k * power * 50 / 100;
        int minDamage = k * power * 20 / 100;
        return Rand.nextInt(minDamage, maxDamage);
    }
}
