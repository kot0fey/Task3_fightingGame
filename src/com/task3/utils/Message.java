package com.task3.utils;

import com.task3.characters.EntityCharacter;
import com.task3.characters.Entity;
import com.task3.weapons.WeaponArray;

public class Message {
    public static void startMessage() {
        System.out.println("\n      FIGHTER GAME");
        Message.underLine24();
        System.out.println("         Press:\nAny number)    To start\n         0)    To exit");
        Message.underLine24();
        System.out.print("      Your choice: ");
    }

    public static void underLine24() {
        System.out.println("________________________");
    }

    public static void underLine48() {
        System.out.println("________________________________________________");
    }

    public static void fightStartMessage() {
        Message.underLine24();
        System.out.println("  Choose your skill:\n1)Head punch (default)\n2)Hand punch\n3)Leg kick");
    }

    public static void rematchMessage() {
        System.out.println("Do you want to restart?\n1)Yes  |   2)No (default)");
        Message.underLine48();
    }

    public static void winMessage() {
        System.out.println("!!! YOU WON !!!");
    }

    public static void looseMessage() {
        System.out.println("!!! YOU LOST !!!");
    }

    public static void choosingWeapon() {
        System.out.println("Choose your weapon");
        Message.underLine24();
        for (int i = 0; i < WeaponArray.length(); i++) {
            System.out.println((i + 1) + ")" + WeaponArray.getWeapon(i).getName());
        }
        Message.underLine24();
        System.out.print("      Your choice: ");

    }

    public static void finalStates(Entity entity) {
        System.out.println("HP: " + entity.getMaxHealthPoints() + " Power: " + entity.getPower());
    }

    public static void chosenWeaponPlayer(Entity playerEntity) {
        System.out.println(playerEntity.getName() + " (player) picks " + playerEntity.getPickedWeaponName() + "\n+" + playerEntity.getHealthPointsPerk() + "% HP\n+" + playerEntity.getPowerPerk() + "% Power");
        finalStates(playerEntity);
        Message.underLine24();
    }

    public static void chosenWeaponMachine(Entity machineEntity) {
        System.out.println(machineEntity.getName() + " (machine) picks " + machineEntity.getPickedWeaponName() + "\n+" + machineEntity.getHealthPointsPerk() + "% HP\n+" + machineEntity.getPowerPerk() + "% Power");
        finalStates(machineEntity);
        Message.underLine48();
    }

    public static void choosingCharacter(EntityCharacter entityCharacter) {
        Message.underLine48();
        System.out.println("  Choose your fighter:");
        Message.underLine24();
        for (int i = 0; i < EntityCharacter.length(); i++) {
            System.out.println((i + 1) + ")" + EntityCharacter.getCharacter(i).getName());
        }
        Message.underLine24();
        System.out.print("      Your choice: ");
    }

    public static void handPunch(String entityNameMessage, int damage) {
        System.out.println(entityNameMessage + " used hand punch (-" + damage + ")");
    }

    public static void legKick(String entityNameMessage, int damage) {
        System.out.println(entityNameMessage + " used leg kick (-" + damage + ")");
    }

    public static void headPunch(String entityNameMessage, int damage) {
        System.out.println(entityNameMessage + " used head punch (-" + damage + ")");
    }

    public static void healthPointsStatus(Entity playerEntity, Entity machineEntity) {
        System.out.println("Your HP is: " + playerEntity.getHealthPoints() + "\nEnemy's HP is: " + machineEntity.getHealthPoints());
    }

    public static void fightTitle(Entity playerEntity, Entity machineEntity) {
        System.out.println("        !!! FIGHT !!!");
        Message.underLine24();
        System.out.println(playerEntity.getName() + " VS " + machineEntity.getName());
    }


}
