package com.task3;

import com.utils.*;

import java.util.Scanner;

public class Game {
    static private final Scanner input = new Scanner(System.in);

    public static boolean start() {
        System.out.println("      FIGHTER GAME\n________________________\n         Press:\nAny number)    To start\n         0)    To exit\n________________________\n      Your choice: ");
        if (input.nextInt() == 0) {
            return false;
        } else {
            System.out.println("________________________");
            choosingCharacters();
        }
        return rematchRequest();
    }

    private static void choosingCharactersString() {
        System.out.println("  Choose your fighter:\n________________________________________________");
        for (int i = 0; i < EntityCharacter.length(); i++) {
            System.out.println((i + 1) + ")" + EntityCharacter.getCharacter(i).getName());
        }
        System.out.println("________________________________________________");
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
        System.out.println("________________________\n  Choose your skill:\n1)Head punch (default)\n2)Hand punch\n3)Leg kick");
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
        System.out.println("Your HP is: " + playerEntity.getHealthPoints() + "\nEnemy's HP is: " + machineEntity.getHealthPoints());
    }

    private static void fight(Entity playerEntity, Entity machineEntity) {
        System.out.println("________________________\n        !!! FIGHT !!!\n________________________\n" + playerEntity.getName() + " VS " + machineEntity.getName());
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
        System.out.println("!!! YOU WON !!!");
    }

    private static void loose(Entity playerEntity) {
        playerEntity.death();
        System.out.println("!!! YOU LOST !!!");
    }

    private static boolean rematchRequest() {
        System.out.println("Do you want to restart?\n1)Yes  |   2)No (default)");
        return input.nextInt() == 1;
    }
}
