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
        return true;
    }
    public static void choosingCharacters(){
        System.out.println("  Choose your fighter:\n________________________________________________\n1)Scorpio(default)    |    3)Jonny Cage\n2)Subzero             |    4)Khabib Nurmagomedov\n________________________________________________");
        Entity playerEntity;
        switch(input.nextInt()){
            case 2 -> playerEntity = new Subzero();
            case 3 -> playerEntity = new JonnyCage();
            case 4 -> playerEntity = new KhabibNurmagomedov();
            default -> playerEntity = new Scorpio();

        }
        Entity machineEntity;
        switch(rand.nextInt(1, 4)){
            case 2 -> machineEntity = new Subzero();
            case 3 -> machineEntity = new JonnyCage();
            case 4 -> machineEntity = new KhabibNurmagomedov();
            default -> machineEntity = new Scorpio();
        }

        fight(playerEntity, machineEntity);
    }
    public static void fight(Entity playerEntity, Entity machineEntity){
        System.out.println("________________________\n        !!! FIGHT !!!\n________________________\n" + playerEntity.getName() + " VS " + machineEntity.getName());
        while(playerEntity.getHealthPoints() > 0 && machineEntity.getHealthPoints() > 0){
            System.out.println("\n________________________\n  Choose your skill:\n1)Head punch (default)\n2)Hand punch\n3)Leg kick");
            switch (input.nextInt()){
                case 2 -> {
                    machineEntity.getDamage(playerEntity.handKick());
                    System.out.println("You used hand punch");
                }
                case 3 -> {
                    machineEntity.getDamage(playerEntity.legKick());
                    System.out.println("You used leg kick");
                }
                default -> {
                    machineEntity.getDamage(playerEntity.headKick());
                    System.out.println("You used head punch");
                }
            }
            switch (rand.nextInt(1, 3)){
                case 2 -> {
                    playerEntity.getDamage(machineEntity.handKick());
                    System.out.println("Enemy used hand punch");
                }
                case 3 -> {
                    playerEntity.getDamage(machineEntity.legKick());
                    System.out.println("Enemy used leg kick");
                }
                default -> {
                    playerEntity.getDamage(machineEntity.headKick());
                    System.out.println("Enemy used head punch");
                }
            }
            System.out.println("Your HP is: " + playerEntity.getHealthPoints() + "\nEnemy's HP is: " + machineEntity.getHealthPoints());
        }
        if (playerEntity.getHealthPoints() < 0){
            loose(playerEntity);
        } else {
            win(machineEntity);
        }
    }
    public static void win(Entity machineEntity){
        machineEntity.death();
        System.out.println("!!! YOU WON !!!");
    }
    public static void loose(Entity playerEntity){
        playerEntity.death();
        System.out.println("!!! YOU LOST !!!");
    }
    public static boolean rematchRequest(){
        System.out.println("Do you want to restart?\n1)Yes  |   2)No (default)");
        if (input.nextInt() == 1) {
            return true;
        }
        return false;
    }
}
