
import GameObjects.Configurator;
import GameObjects.GameEngine;
import GameObjects.GameField;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Configurator configurator = new Configurator();
        //configurator.crateYmlFiles();
        GameField gameField = configurator.initGameField();
        GameEngine gameEngine = new GameEngine(gameField);
        gameEngine.show();
        while (!Thread.currentThread().isInterrupted()){
            long count = gameField.getAllAnimalslCount(gameField.getTotalCount());
            if(count > 150000) {

                Thread.currentThread().interrupt();
            }else {
                Thread.sleep(2000);
                gameEngine.playGame();
            }
        }

        Thread.sleep(5000);
            Thread thread = new Thread(gameEngine);
            thread.start();


    }
}
