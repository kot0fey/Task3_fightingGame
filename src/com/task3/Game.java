package com.task3;

import com.utils.*;

import java.util.Scanner;

public class Game {
    static private final Scanner input = new Scanner(System.in);

    public static boolean start() {
        System.out.println(Messages.startMessage);
        if (input.nextInt() == 0) {
            return false;
        } else {
            System.out.println(Messages.underLine24);
            choosingCharacters();
        }
        return rematchRequest();
    }

    private static void choosingCharactersString() {
        System.out.println(Messages.choosingMessage);
        for (int i = 0; i < EntityCharacter.length(); i++) {
            System.out.println((i + 1) + ")" + EntityCharacter.getCharacter(i).getName());
        }
        System.out.println(Messages.underLine48);
    }

    private static void choosingCharacters() {
        EntityCharacter.refresh();
        choosingCharactersString();
        Entity playerEntity;
        int userCharacterChoice = input.nextInt();
        if (userCharacterChoice > 0 && userCharacterChoice < EntityCharacter.length() + 1) {
            playerEntity = EntityCharacter.getCharacter(userCharacterChoice - 1);
        } else {
            playerEntity = EntityCharacter.getCharacter(0);
        }

        Entity machineEntity;
        int randArrayIndex = Rand.nextInt(0, EntityCharacter.length(), userCharacterChoice);
        machineEntity = EntityCharacter.getCharacter(randArrayIndex);

        fight(playerEntity, machineEntity);
    }

    private static void fightMessages(Entity playerEntity, Entity machineEntity) {
        System.out.println(Messages.fightStartMessage);
        String[] entityNameMessageArray = {"You", "Enemy"};
        int[] numberChoiceArray = {input.nextInt(), Rand.nextInt(1, 4)};
        Entity[] kickingEntityArray = {machineEntity, playerEntity};
        Entity[] gettingKickedEntityArray = {playerEntity, machineEntity};
        for (int i = 0; i < 2; i++) {
            switch (numberChoiceArray[i]) {
                case 2 -> {
                    kickingEntityArray[i].getDamage(gettingKickedEntityArray[i].handKick());
                    System.out.println(entityNameMessageArray[i] + " used hand punch");
                }
                case 3 -> {
                    kickingEntityArray[i].getDamage(gettingKickedEntityArray[i].legKick());
                    System.out.println(entityNameMessageArray[i] + " used leg kick");
                }
                default -> {
                    kickingEntityArray[i].getDamage(gettingKickedEntityArray[i].headKick());
                    System.out.println(entityNameMessageArray[i] + " used head punch");
                }
            }
        }
        System.out.println(Messages.healthPointsStatusMessage_1 + playerEntity.getHealthPoints() + Messages.healthPointsStatusMessage_2 + machineEntity.getHealthPoints());
    }

    private static void fight(Entity playerEntity, Entity machineEntity) {
        System.out.println(Messages.fightTitleMessage_1 + playerEntity.getName() + Messages.fightTitleMessage_2 + machineEntity.getName());
        while (playerEntity.getHealthPoints() > 0 && machineEntity.getHealthPoints() > 0) {
            fightMessages(playerEntity, machineEntity);
        }
        if (playerEntity.getHealthPoints() <= 0) {
            loose(playerEntity);
        } else {
            win(machineEntity);
        }
    }

    private static void win(Entity machineEntity) {
        machineEntity.death();
        System.out.println(Messages.winMessage);
    }

    private static void loose(Entity playerEntity) {
        playerEntity.death();
        System.out.println(Messages.looseMessage);
    }

    private static boolean rematchRequest() {
        System.out.println(Messages.rematchMessage);
        return input.nextInt() == 1;
    }
}
