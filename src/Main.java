import com.task3.Game;
import com.task3.utils.Logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean continueFlag = true;
        //Logger.createFile();
        while (continueFlag) {
            continueFlag = Game.start();
        }
        //Logger.writeToFile();
    }
}