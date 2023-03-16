package com.task3;

import MyArrayList.MyArrayList;
import com.task3.characters.Entity;
import com.task3.characters.EntityArray;
import com.task3.weapons.WeaponArray;
import com.task3.utils.*;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    static private final Scanner input = new Scanner(System.in);

    public static boolean start() throws IOException {
        Message.startMessage();
        EntityArray.refresh();

        switch (input.nextInt()) {
            case 1 -> {
                Stats.start();
                return true;
            }
            case 0 -> {
                return false;
            }
            default -> {
                choosingCharacters();
            }
        }

        return rematchRequest();
    }


    private static void choosingCharacters() throws IOException {
        //EntityArray.getInstance()
        Message.choosingCharacter();
        Entity playerEntity;
        int userCharacterChoice = input.nextInt();
        if (userCharacterChoice > 0 && userCharacterChoice < EntityArray.length() + 1) {
            playerEntity = EntityArray.getCharacter(userCharacterChoice - 1);
        } else {
            playerEntity = EntityArray.getCharacter(0);
        }

        Entity machineEntity;
        int randArrayIndex = Rand.nextInt(0, EntityArray.length(), userCharacterChoice - 1);
        machineEntity = EntityArray.getCharacter(randArrayIndex);
        choosingWeapon(playerEntity, machineEntity);
        fight(playerEntity, machineEntity);
    }

    private static void choosingWeapon(Entity playerEntity, Entity machineEntity) {
        Message.underLine48();
        Message.choosingWeapon();
        int userWeaponChoice = input.nextInt();
        if (userWeaponChoice > 0 && userWeaponChoice < WeaponArray.length() + 1) {
            playerEntity.setWeapon(WeaponArray.getWeapon(userWeaponChoice - 1));
        } else {
            playerEntity.setWeapon(WeaponArray.getWeapon(0));
        }

        Message.chosenWeaponPlayer(playerEntity);
        machineEntity.setWeapon(WeaponArray.getWeapon(Rand.nextInt(0, WeaponArray.length())));
        Message.chosenWeaponMachine(machineEntity);
    }

    private static void fightMessages(Entity playerEntity, Entity machineEntity) {
        Message.fightStartMessage();
        MyArrayList<String> entityNameMessageArray = new MyArrayList<String>();
        entityNameMessageArray.add("You");
        entityNameMessageArray.add("Enemy");
        MyArrayList<Integer> numberChoiceArray = new MyArrayList<Integer>();
        numberChoiceArray.add(input.nextInt());
        numberChoiceArray.add(Rand.nextInt(1, 4));
        MyArrayList<Entity> kickingEntityArray = new MyArrayList<Entity>();
        kickingEntityArray.add(machineEntity);
        kickingEntityArray.add(playerEntity);
        MyArrayList<Entity> gettingKickedEntityArray = new MyArrayList<Entity>();
        gettingKickedEntityArray.add(playerEntity);
        gettingKickedEntityArray.add(machineEntity);
        int currentDamage;
        for (int i = 0; i < 2; i++) {
            switch (numberChoiceArray.get(i)) {
                case 2 -> {
                    currentDamage = kickingEntityArray.get(i).getDamage(gettingKickedEntityArray.get(i).handKick());
                    Message.handPunch(entityNameMessageArray.get(i), currentDamage);
                }
                case 3 -> {
                    currentDamage = kickingEntityArray.get(i).getDamage(gettingKickedEntityArray.get(i).legKick());
                    Message.legKick(entityNameMessageArray.get(i), currentDamage);
                }
                default -> {
                    currentDamage = kickingEntityArray.get(i).getDamage(gettingKickedEntityArray.get(i).headKick());
                    Message.headPunch(entityNameMessageArray.get(i), currentDamage);
                }
            }
        }
        Message.healthPointsStatus(playerEntity, machineEntity);
    }

    private static void fight(Entity playerEntity, Entity machineEntity) throws IOException {
        Logger.createFile();
        Message.fightTitle(playerEntity, machineEntity);
        while (playerEntity.getHealthPoints() > 0 && machineEntity.getHealthPoints() > 0) {
            fightMessages(playerEntity, machineEntity);
        }
        if (playerEntity.getHealthPoints() == 0 && machineEntity.getHealthPoints() > 0) {
            loose(playerEntity);
        } else if (machineEntity.getHealthPoints() == 0 && playerEntity.getHealthPoints() > 0) {
            win(machineEntity);
        } else {
            draw(playerEntity, machineEntity);
        }
        Message.underLine48();
        Logger.setLog(playerEntity, machineEntity);
        Logger.writeToFile();
    }

    private static void win(Entity machineEntity) {
        machineEntity.death();
        Message.winMessage();
    }

    private static void loose(Entity playerEntity) {
        playerEntity.death();
        Message.looseMessage();
    }

    private static void draw(Entity playerEntity, Entity machineEntity) {
        playerEntity.death();
        machineEntity.death();
        playerEntity.setWinFlag('D');
        machineEntity.setWinFlag('D');
        Message.drawMessage();
    }

    private static boolean rematchRequest() {
        Message.rematchMessage();
        return input.nextInt() == 1;
    }
}
