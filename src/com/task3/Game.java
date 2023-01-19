package com.task3;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static private final Scanner input = new Scanner(System.in);
    static private final Random rand = new Random();

    public static boolean start(){
        System.out.println("      FIGHTER GAME\n________________________\n         Press:\nAny number)    To start\n         0)    To exit\n________________________\n      Your choice: ");
        if (input.nextInt() == 0){
            return false;
        } else {
            System.out.println("________________________");
            choosingCharacters();
        }
        return rematchRequest();
    }
    private static void choosingCharacters(){
        System.out.println("  Choose your fighter:\n________________________________________________\n1)Scorpio(default)    |    3)Jonny Cage\n2)Subzero             |    4)Khabib Nurmagomedov\n________________________________________________");
        //Entity[] characterArray = {new Scorpio(), new Subzero(), new JonnyCage(), new KhabibNurmagomedov()};
        Entity playerEntity;
        int characterArrayIndex = input.nextInt();
        if (characterArrayIndex > 0 && characterArrayIndex < EntityCharacter.characterArray.length - 1){
            playerEntity = EntityCharacter.characterArray[characterArrayIndex];
        } else {
            playerEntity = EntityCharacter.characterArray[0];
        }

        Entity machineEntity;
        int randArrayIndex = rand.nextInt(0, EntityCharacter.characterArray.length - 1);
            machineEntity = EntityCharacter.characterArray[randArrayIndex];

        fight(playerEntity, machineEntity);
    }
    private static void fight(Entity playerEntity, Entity machineEntity){
        System.out.println("________________________\n        !!! FIGHT !!!\n________________________\n" + playerEntity.getName() + " VS " + machineEntity.getName());
        while(playerEntity.getHealthPoints() > 0 && machineEntity.getHealthPoints() > 0){
            System.out.println("\n________________________\n  Choose your skill:\n1)Head punch (default)\n2)Hand punch\n3)Leg kick");
            switch (input.nextInt()){
                case 2 -> {
                    machineEntity.getDamage(playerEntity.handKick(rand));
                    System.out.println("You used hand punch");
                }
                case 3 -> {
                    machineEntity.getDamage(playerEntity.legKick(rand));
                    System.out.println("You used leg kick");
                }
                default -> {
                    machineEntity.getDamage(playerEntity.headKick( rand));
                    System.out.println("You used head punch");
                }
            }
            switch (rand.nextInt(1, 3)){
                case 2 -> {
                    playerEntity.getDamage(machineEntity.handKick(rand));
                    System.out.println("Enemy used hand punch");
                }
                case 3 -> {
                    playerEntity.getDamage(machineEntity.legKick(rand));
                    System.out.println("Enemy used leg kick");
                }
                default -> {
                    playerEntity.getDamage(machineEntity.headKick(rand));
                    System.out.println("Enemy used head punch");
                }
            }
            System.out.println("Your HP is: " + playerEntity.getHealthPoints() + "\nEnemy's HP is: " + machineEntity.getHealthPoints());
        }
        if (playerEntity.getHealthPoints() <= 0){
            loose(playerEntity);
        } else {
            win(machineEntity);
        }
    }
    private static void win(Entity machineEntity){
        machineEntity.death();
        System.out.println("!!! YOU WON !!!");
    }
    private static void loose(Entity playerEntity){
        playerEntity.death();
        System.out.println("!!! YOU LOST !!!");
    }
    private static boolean rematchRequest(){
        System.out.println("Do you want to restart?\n1)Yes  |   2)No (default)");
        if (input.nextInt() == 1) {
            return true;
        }
        return false;
    }
}
