package com.task3;

public class EntityCharacter {
    static Entity[] characterArray = {new Scorpio(), new Subzero(), new JonnyCage(), new KhabibNurmagomedov()};
    static final Entity[] initialiseCharacterArray = {new Scorpio(), new Subzero(), new JonnyCage(), new KhabibNurmagomedov()};
    public static void restart(){
        characterArray = initialiseCharacterArray;
    }

}