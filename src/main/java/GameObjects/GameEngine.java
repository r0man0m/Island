package GameObjects;

import Interfaces.GameObject;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class GameEngine implements Runnable{
   private final Cell[][]cells;
   private GameField gameField;
   private StatisticalMonitor monitor;


    public GameEngine(GameField gameField)  {
        this.gameField = gameField;
        cells = gameField.getField();
        monitor = new StatisticalMonitor();

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
        System.out.println("All animals quantity");
        monitor.showAllCounter(gameField.getTotalCount());
        System.out.println("All reproduced animals");
        monitor.showAllCounter(gameField.getReproduceCountMap());
        System.out.println("All eaten animals");
        monitor.showAllCounter(gameField.getEatenCountMap());
        System.out.println("All died animals");
        monitor.showAllCounter(gameField.getDiedCountMap());
        System.out.println("All growing plants");
        monitor.showAllGrowings(gameField.getGrowMap());
        System.out.println("Total mass of plants eaten  " + gameField.getEatenGrassWeight() / 1000 + " kilo");

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
        System.out.println("First animals quantity");
        monitor.showAllCounter(gameField.getTotalCount());
    }


    public void playGame() {
            FactoryThread factory = new FactoryThread();
            Arrays.stream(cells).forEach(c -> Arrays.stream(c).forEach(q -> q.getQueue().forEach(o -> {
                Thread thread = factory.newThread(o);
                thread.start();

            })));
            ScheduledExecutorService service = Executors.newScheduledThreadPool(8, factory);
            service.shutdown();


   }
   public void showStatistic(){

            System.out.println();
            System.out.println("All animals quantity");
            monitor.showAllCounter(gameField.getTotalCount());
            System.out.println("All reproduced animals");
            monitor.showAllCounter(gameField.getReproduceCountMap());
            System.out.println("All eaten animals");
            monitor.showAllCounter(gameField.getEatenCountMap());
            System.out.println("All died animals");
            monitor.showAllCounter(gameField.getDiedCountMap());
            System.out.println("All growing plants");
            monitor.showAllGrowings(gameField.getGrowMap());
            System.out.println("Total mass of plants eaten  " + gameField.getEatenGrassWeight() / 1000 + " kilo");

   }

    @Override
    public void run() {
        showStatistic();
    }

    public  Cell[][] getCells() {
        return cells;
    }
}
