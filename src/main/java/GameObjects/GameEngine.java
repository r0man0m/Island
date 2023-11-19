package GameObjects;

import Interfaces.GameObject;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class GameEngine {
   private final Cell[][]cells;
   private GameField gameField;


    public GameEngine(GameField gameField)  {
        this.gameField = gameField;
        cells = gameField.getField();

    }
    public  void play() throws InterruptedException {
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
                                c.play(gameField);
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
    public  void show() throws InterruptedException {
        System.out.println("Game table!");
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
    }


    public void playGame(){
       FactoryThread factory = new FactoryThread();
       Arrays.stream(cells).forEach(c->Arrays.stream(c).forEach(q->q.getQueue().forEach(o->{
           Thread thread = factory.newThread(o);
           thread.start();
           ScheduledExecutorService service = Executors.newScheduledThreadPool(8, factory);
           service.shutdown();
       })));
   }


    public  Cell[][] getCells() {
        return cells;
    }
}
