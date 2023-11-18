import GameObjects.*;
import Interfaces.GameObject;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;



public class Main {
    public static  Configurator configurator = new Configurator();
    public static GameEngine gameEngine;

    static {
        try {
            gameEngine = new GameEngine(configurator.initGameField());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
       // initGame();
       play();

    }
    public static void play() throws InterruptedException {
        Cell[][] cells = gameEngine.getCells();
        show(cells);
        Thread.sleep(10000);
        System.out.println("Start playing");
        System.out.println("-------------");
        System.out.println();


            int row = 0;
            for (Cell[] C : cells) {
                System.out.println("Row " + row);
                for (Cell Cell : C) {
                    System.out.println(Cell);
                    ArrayBlockingQueue<GameObject> queue = Cell.getQueue();
                    queue.forEach(c -> {
                                try {
                                    c.play(cells);
                                } catch (NullPointerException n) {
                                } catch (CloneNotSupportedException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                    );
                    System.out.println();
                }
                row++;
            }


    }
    public static void initGame() throws IOException {
        configurator.crateYmlFiles();
    }
    public static void show(Cell[][]cells) throws InterruptedException {
        System.out.println("Let`s begin!");
        System.out.println("_____________");
        Thread.sleep(2000);
        int row = 0;
        for (Cell[] C:cells) {
            System.out.println("Row " + row);
            for (Cell Cell:C) {
                System.out.println(Cell);
                ArrayBlockingQueue<GameObject> queue =  Cell.getQueue();
                queue.forEach(c->{
                            System.out.print(c);
                        }

                );
                System.out.println();
            }
            row++;
        }
        System.out.println();
        System.out.println("Worm quantity = " + configurator.getCounter(Types.WORM));
        System.out.println();
    }
}
