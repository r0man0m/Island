import GameObjects.Cell;
import GameObjects.Configurator;
import GameObjects.GameEngine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Configurator configurator = new Configurator();
        configurator.crateYmlFiles();
        configurator.initGameField();
        Cell[][]cells = configurator.initGameField();
        GameEngine gameEngine = new GameEngine(cells);
        gameEngine.show();
        gameEngine.play();

    }
}
