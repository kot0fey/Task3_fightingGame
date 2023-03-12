package com.task3.utils;

import MyHashSet.MyHashSet;
import MyMap.MyMap;
import com.task3.characters.EntityArray;
import com.task3.weapons.WeaponArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Stats {

    private static final MyHashSet<Object> entities = new MyHashSet<>();
    private static final MyHashSet<Object> weapons = new MyHashSet<>();
    private static final MyMap<String, Integer> entitiesToChoices = new MyMap<String, Integer>();
    private static final MyMap<String, Integer> weaponsToChoices = new MyMap<String, Integer>();
    private static final MyMap<String, Integer> entitiesToWins = new MyMap<String, Integer>();
    private static final MyMap<String, Integer> entitiesToLoses = new MyMap<String, Integer>();
    private static final MyMap<String, Integer> entitiesToDraws = new MyMap<String, Integer>();

    private static String getFavorite(MyMap<String, Integer> smthToChoices) {
        String favorite = "";
        int numberOfChoices = 0;
        for (Object smth : smthToChoices.keySet()) {
            if (numberOfChoices < (int) smthToChoices.get(smth)) {
                favorite = (String) smth;
                numberOfChoices = (int) smthToChoices.get(smth);
            }
        }
        return favorite;
    }

    private static void initializer() {

        for (int i = 0; i < EntityArray.length(); i++) {
            entities.add(EntityArray.getCharacter(i).getName());
        }

        for (int i = 0; i < WeaponArray.length(); i++) {
            weapons.add(WeaponArray.getWeapon(i).getName());
        }

        for (Object o : entities) {
            entitiesToChoices.put(o, 0);
        }
        for (Object o : weapons) {
            weaponsToChoices.put(o, 0);
        }

        for (Object o : entities) {
            entitiesToWins.put(o, 0);
        }

        for (Object o : entities) {
            entitiesToLoses.put(o, 0);
        }

        for (Object o : entities) {
            entitiesToDraws.put(o, 0);
        }

    }

    private static void dataCollector() throws FileNotFoundException {
        File logs = new File("logs");//mkdir
        String[] logFiles = logs.list();


        for (String name : logFiles) {
            FileReader reader = new FileReader("logs//" + name);
            Scanner scanner = new Scanner(reader);
            String currentString;
            while (scanner.hasNextLine()) {
                currentString = scanner.nextLine();
                int cutIndex = currentString.indexOf(';');
                currentString = currentString.substring(0, cutIndex);
                Object[] dataArray = currentString.split(":");


                entitiesToChoices.put(dataArray[0], (int) entitiesToChoices.get(dataArray[0]) + 1);
                weaponsToChoices.put(dataArray[1], (int) weaponsToChoices.get(dataArray[1]) + 1);
                switch ((String) dataArray[2]) {
                    case "W" -> {
                        entitiesToWins.put(dataArray[0], (Integer) entitiesToWins.get(dataArray[0]) + 1);
                    }
                    case "L" -> {
                        entitiesToLoses.put(dataArray[0], (Integer) entitiesToLoses.get(dataArray[0]) + 1);
                    }
                    case "D" -> {
                        entitiesToDraws.put(dataArray[0], (Integer) entitiesToDraws.get(dataArray[0]) + 1);
                    }
                }
            }
        }
    }

    public static void print() {
        Message.statsFavorites(getFavorite(entitiesToChoices), getFavorite(weaponsToChoices));
        Message.statsWLD(entities, entitiesToWins, entitiesToLoses, entitiesToDraws);
        Message.statsExit();
    }

    public static void start() throws IOException {
        Logger.writeToFile();
        initializer();
        dataCollector();
        print();
        Logger.createFile();
    }
}
