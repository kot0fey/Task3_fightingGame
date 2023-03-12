package com.task3.characters;

import MyArrayList.MyArrayList;
import com.task3.characters.actualCharacters.*;

public class EntityArray {
    private static EntityArray instance;
    private static final MyArrayList<Entity> characterArray = new MyArrayList<Entity>();

    private EntityArray() {
        characterArray.add(new Scorpio());
        characterArray.add(new Subzero());
        characterArray.add(new JonnyCage());
        characterArray.add(new KhabibNurmagomedov());
    }

    public static EntityArray getInstance() {
        if (instance == null) {
            instance = new EntityArray();
        }
        return instance;
    }

    public static Entity getCharacter(int index) {
        return characterArray.get(index);
    }

    public static void clear() {
        characterArray.clear();
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