package GameObjects;

import Interfaces.GameObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GameEngine {
   private final Cell[][]cells;
   private GameField gameField;
   private StatisticalMonitor monitor;


    public GameEngine(GameField gameField)  {
        this.gameField = gameField;
        cells = gameField.getField();
        monitor = new StatisticalMonitor();

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


    public  void playGame() throws InterruptedException, ExecutionException, TimeoutException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(20);

            Collection<GameObject> gameObjectList = Arrays.stream(cells)
                    .flatMap(Arrays::stream).map(Cell::getQueue).flatMap(Collection::stream).toList();

            service.invokeAll(gameObjectList);

            service.shutdown();
   }
   public  void statistic(){
        Thread thread = new Thread(()->{
            showStatistic();

        });
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        //service.schedule(thread, 1, TimeUnit.SECONDS);
        service.execute(thread);

        service.shutdown();

   }
   public void showStatistic(){


           /* System.out.println('\n' + "All animals quantity");
            monitor.showAllCounter(gameField.getTotalCount());*/
            System.out.println('\n' + "All reproduced animals quantity");
            monitor.showAllCounter(gameField.getReproduceCountMap());
            System.out.println("All eaten animals quantity");
            monitor.showAllCounter(gameField.getEatenCountMap());
            System.out.println("All died animals quantity");
            monitor.showAllCounter(gameField.getDiedCountMap());
            System.out.println("All growing plants quantity");
            monitor.showAllGrowings(gameField.getAllGrowQuantity());
            monitor.showEatenGrassWeight(gameField);

       System.out.println("Enter s");
       System.out.println();

   }

}
