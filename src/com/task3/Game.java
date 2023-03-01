package com.task3;

import MyArrayList.MyArrayList;
import com.task3.characters.Entity;
import com.task3.characters.EntityCharacter;
import com.task3.weapons.WeaponArray;
import com.task3.utils.*;

import java.util.Scanner;

public class Game {
    static private final Scanner input = new Scanner(System.in);

    public static boolean start() {
        Message.startMessage();
        if (input.nextInt() == 0) {
            return false;
        } else {
            choosingCharacters();
        }
        return rematchRequest();
    }


    private static void choosingCharacters() {
        EntityCharacter.refresh();
        Message.choosingCharacter(EntityCharacter.getInstance());
        Entity playerEntity;
        int userCharacterChoice = input.nextInt();
        if (userCharacterChoice > 0 && userCharacterChoice < EntityCharacter.length() + 1) {
            playerEntity = EntityCharacter.getCharacter(userCharacterChoice - 1);
        } else {
            playerEntity = EntityCharacter.getCharacter(0);
        }

        Entity machineEntity;
        int randArrayIndex = Rand.nextInt(0, EntityCharacter.length(), userCharacterChoice - 1);
        machineEntity = EntityCharacter.getCharacter(randArrayIndex);
        choosingWeapon(playerEntity, machineEntity);
        fight(playerEntity, machineEntity);
    }

    private static void choosingWeapon(Entity playerEntity, Entity machineEntity) {
        Message.underLine48();
        Message.choosingWeapon();
        playerEntity.setWeapon(WeaponArray.getWeapon(input.nextInt() - 1));
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

    private static void fight(Entity playerEntity, Entity machineEntity) {
        Message.fightTitle(playerEntity, machineEntity);
        while (playerEntity.getHealthPoints() > 0 && machineEntity.getHealthPoints() > 0) {
            fightMessages(playerEntity, machineEntity);
        }
        if (playerEntity.getHealthPoints() <= 0) {
            loose(playerEntity);
        } else {
            win(machineEntity);
        }
        Message.underLine48();
    }

    private static void win(Entity machineEntity) {
        machineEntity.death();
        Message.winMessage();
    }

    private static void loose(Entity playerEntity) {
        playerEntity.death();
        Message.looseMessage();
    }

    private static boolean rematchRequest() {
        Message.rematchMessage();
        return input.nextInt() == 1;
    }
}
