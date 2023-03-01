package com.task3.weapons;

import MyArrayList.MyArrayList;
import com.task3.weapons.actualWeapons.*;

public class WeaponArray {
    private final static MyArrayList<WeaponStrategy> originalArray = arrayInitializer();

    private static MyArrayList<WeaponStrategy> arrayInitializer() {
        MyArrayList<WeaponStrategy> array = new MyArrayList<WeaponStrategy>();
        array.add(new WeaponDagger());
        array.add(new WeaponSword());
        array.add(new WeaponAxe());
        return array;
    }

    public static WeaponStrategy getWeapon(int index) {
        return originalArray.get(index);
    }

    public static int length() {
        return originalArray.size();
    }

}
