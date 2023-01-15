        import java.util.Random;
import  java.util.Scanner;
interface Actions{
    public int headKick();
    public int handKick();
    public int legKick();
}
abstract class Entity implements Actions{
    protected int healthPoints;
    protected int power;
    protected String name;
    void getDamage(int damage){};
    void death(){};
    int getHealthPoints(){
        return healthPoints;
    }
    String getName(){
        return name;
    };
    }

class Scorpio extends Entity{
    private int healthPoints = 100;
    private final int power = 50;
    private final String name = "Scorpio";
    Random rand = new Random();
    @Override
    public int headKick() {
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int legKick() {
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return rand.nextInt(minDamage, maxDamage);    }

    @Override
    public void getDamage(int damage) {
        healthPoints -= damage;
    }

    @Override
    public void death() {
        System.out.println("Scorpio is dead.");
    }
}

class Subzero extends Entity{
    private int healthPoints = 90;
    private final int power = 40;
    private final String name = "Subzero";

    Random rand = new Random();
    @Override
    public int headKick() {
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int legKick() {
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return rand.nextInt(minDamage, maxDamage);    }

    @Override
    public void getDamage(int damage) {
        healthPoints -= damage;
    }

    @Override
    public void death() {
        System.out.println("Subzero is dead.");
    }
    public String getName(){
        return "Subzero";
    }
}

class JonnyCage extends Entity{
    private int healthPoints = 80;
    private final int power = 60;
    private final String name = "Jonny Cage";

    Random rand = new Random();
    @Override
    public int headKick() {
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int legKick() {
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return rand.nextInt(minDamage, maxDamage);    }

    @Override
    public void getDamage(int damage) {
        healthPoints -= damage;
    }

    @Override
    public void death() {
        System.out.println("Jonny Cage is dead.");
    }
    public String getName(){
        return "Jonny Cage";
    }
}

class KhabibNurmagomedov extends Entity{
    private int healthPoints = 150;
    private final int power = 70;
    private final String name = "Khabib Nurmagomedov";

    Random rand = new Random();
    @Override
    public int headKick() {
        int maxDamage = power * 50 / 100;
        int minDamage = power * 20 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int handKick() {
        int maxDamage = power * 80 / 100;
        int minDamage = power * 40 / 100;
        return rand.nextInt(minDamage, maxDamage);
    }

    @Override
    public int legKick() {
        int maxDamage = power * 100 / 100;
        int minDamage = power * 70 / 100;
        return rand.nextInt(minDamage, maxDamage);    }

    @Override
    public void getDamage(int damage) {
        healthPoints -= damage;
    }

    @Override
    public void death() {
        System.out.println("Khabib Nurmagomedov is dead.");
    }
}

class Game {
    static private Scanner input = new Scanner(System.in);
    static private Random rand = new Random();

    public static boolean start(){
        System.out.println("Press:\nAny number: To start\n0: To exit\nYour choice: ");
        switch (input.nextInt()){
            case 0 -> {
                return false;
            }
            default -> choosingCharacters();
        }
        return true;
    }
    public static void choosingCharacters(){
        System.out.println("Choose your fighter:\n1)Scorpio(default)    |    3)Jonny Cage\n2)Subzero         |    4)Khabib Nurmagomedov");
        Entity playerEntity;
        switch(input.nextInt()){
            case 1 -> playerEntity = new Scorpio();
            case 2 -> playerEntity = new Subzero();
            case 3 -> playerEntity = new JonnyCage();
            case 4 -> playerEntity = new KhabibNurmagomedov();
            default -> playerEntity = new Scorpio();

        }
        Entity machineEntity;
        switch(rand.nextInt(1, 4)){
            case 1 -> machineEntity = new Scorpio();
            case 2 -> machineEntity = new Subzero();
            case 3 -> machineEntity = new JonnyCage();
            case 4 -> machineEntity = new KhabibNurmagomedov();
            default -> machineEntity = new Scorpio();
        }

        fight(playerEntity, machineEntity);
    }
    public static void fight(Entity playerEntity, Entity machineEntity){
        System.out.println("!!! FIGHT !!!");
        while(playerEntity.getHealthPoints() > 0 && machineEntity.getHealthPoints() > 0){
            System.out.println("Choose your skill:\n1)Head punch (default)\n2)Hand punch\n3)Leg kick");
            switch (input.nextInt()){
                case 1 -> {
                    machineEntity.getDamage(playerEntity.headKick());
                    System.out.println("You used head punch");
                }
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
                case 1 -> {
                    playerEntity.getDamage(machineEntity.headKick());
                    System.out.println("Enemy used head punch");
                }
                case 2 -> {
                    playerEntity.getDamage(machineEntity.handKick());
                    System.out.println("You used hand punch");
                }
                case 3 -> {
                    playerEntity.getDamage(machineEntity.legKick());
                    System.out.println("You used leg kick");
                }
                default -> {
                    playerEntity.getDamage(machineEntity.headKick());
                    System.out.println("Enemy used head punch");
                }
            }
            System.out.println("Your HP is: " + playerEntity.getHealthPoints() + "\nEnemy's HP is: " + machineEntity.getHealthPoints());
        }
        if (playerEntity.getHealthPoints() < 0){
            loose();
        } else {
            win();
        }
    }
    public static void win(){
        System.out.println("!!! YOU WON !!!");
    }
    public static void loose(){
        System.out.println("!!! YOU LOST !!!");
    }
    public static boolean rematchRequest(){
        System.out.println("Do you want to restart?\n1)Yes  |   2)No (default)");
        switch (input.nextInt()){
            case 1 -> {
                return true;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        boolean continueFlag = true;
        while (continueFlag){
            continueFlag = Game.start();
            if (!continueFlag){
                break;
            }
            continueFlag = Game.rematchRequest();//////////////////////
        }
    }
}