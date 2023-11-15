import GameObjects.*;
import GameObjects.Livings.Bear;
import Interfaces.GameObject;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Configurator configurator = new Configurator();
        //configurator.crateYmlFiles();
        GameEngine gameEngine = new GameEngine(configurator.initGameField());
        Cell[][] cells = gameEngine.getCells();
        int row = 0;
        for (Cell[] C:cells) {
            System.out.println("Row " + row);
            for (Cell Cell:C) {
                System.out.println(Cell);
                ArrayBlockingQueue<GameObject> queue =  Cell.getQueue();
                queue.forEach(c->{
                        try {
                            c.play(cells);
                        }catch (NullPointerException n) {
                        }
                    }

                );
                System.out.println();
            }
            row++;
        }
        System.out.println("Worm quantity = " + configurator.getCounter(Types.WORM));


    }
}
