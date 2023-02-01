package com.task3.characters;

import com.task3.characters.actualCharacters.*;

public class EntityCharacter {
    private static EntityCharacter instance;
    private static Entity[] characterArray;

    private EntityCharacter() {
        characterArray = new Entity[]{new Scorpio(), new Subzero(), new JonnyCage(), new KhabibNurmagomedov()};
    }

    public static EntityCharacter getInstance() {
        if (instance == null) {
            instance = new EntityCharacter();
        }
        return instance;
    }

    public static Entity getCharacter(int index) {
        return characterArray[index];
    }

    public static void clear() {
        instance = null;
    }

    public static void refresh() {
        clear();
        getInstance();
    }

    public static int length() {
        return characterArray.length;
    }

}