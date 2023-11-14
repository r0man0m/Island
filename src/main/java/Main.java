import GameObjects.*;
import Interfaces.GameObject;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Configurator configurator = new Configurator();
        //configurator.crateYmlFiles();
        GameEngine gameEngine = new GameEngine(configurator.initGameField());
        Cell[][] cells = gameEngine.getCells();

        for (Cell[] C:cells) {
            for (Cell Cell:C) {
                System.out.println(Cell);
                ArrayBlockingQueue<GameObject> queue =  Cell.getQueue();
                queue.forEach(c->{
                    System.out.print(c + " ");
                });
                System.out.println();
            }

        }
        System.out.println("Worm quantity = " + configurator.getCounter(Types.WORM));

    }
}
