import GameObjects.Cell;
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
        gameEngine.play();

    }
}
