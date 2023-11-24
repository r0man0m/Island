
import GameObjects.Configurator;
import GameObjects.GameEngine;
import GameObjects.GameField;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        Configurator configurator = new Configurator();
        //configurator.crateYmlFiles();
        GameField gameField = configurator.initGameField();
        GameEngine gameEngine = new GameEngine(gameField);
        System.out.println("Wait please.....");
        gameEngine.show();
        Thread.sleep(5000);

        for (int i = 0; i < 10; i++) {
            try {
                gameEngine.playGame();

                gameEngine.statistic();

                Thread.sleep(10000);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
