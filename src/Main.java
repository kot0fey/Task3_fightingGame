import com.task3.Game;

public class Main {
    public static void main(String[] args) {
        boolean continueFlag = true;
        while (continueFlag){
            continueFlag = Game.start();
        }
    }
}