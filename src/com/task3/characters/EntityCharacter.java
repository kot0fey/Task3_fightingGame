package com.task3.characters;

import MyArrayList.MyArrayList;
import com.task3.characters.actualCharacters.*;

public class EntityCharacter {
    private static EntityCharacter instance;
    private static MyArrayList<Entity> characterArray = new MyArrayList<Entity>();

    private EntityCharacter() {
        characterArray.add(new Scorpio());
        characterArray.add(new Subzero());
        characterArray.add(new JonnyCage());
        characterArray.add(new KhabibNurmagomedov());
    }

    public static EntityCharacter getInstance() {
        if (instance == null) {
            instance = new EntityCharacter();
        }
        return instance;
    }

    public static Entity getCharacter(int index) {
        return characterArray.get(index);
    }

    public static void clear() {
        instance = null;
    }

    public static void refresh() {
        clear();
        getInstance();
    }

    public static int length() {
        return characterArray.size();
    }

}