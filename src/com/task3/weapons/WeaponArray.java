package com.task3.weapons;

public class WeaponArray {
    private static final WeaponStrategy[] originalArray = {new WeaponDagger(), new WeaponSword(), new WeaponAxe()};

    public static WeaponStrategy getWeapon(int index) {
        return originalArray[index];
    }

    public static int length() {
        return originalArray.length;
    }

}
