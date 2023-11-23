package GameObjects;

import Interfaces.GameObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
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
   /* public  void play() throws InterruptedException {
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

    }*/
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


    public void playGame() throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(20);
        //System.out.println("Game number: " + i + " #########################################################");
            //FactoryThread factory = new FactoryThread();
            //Arrays.stream(cells).forEach(c -> Arrays.stream(c).forEach(q -> q.getQueue().forEach(o -> {
                //Thread thread = factory.newThread(o);
                //thread.start();
                //System.out.println("Game number: " + i + " #########################################################");
                //service.execute(o);

            //})));
            Collection<GameObject> gameObjectList = Arrays.stream(cells)
                    .flatMap(Arrays::stream).map(Cell::getQueue).flatMap(Collection::stream).toList();
            service.invokeAll(gameObjectList);
            service.shutdown();


   }
   public void statistic(){
        Thread thread = new Thread(()->{
            System.out.println('\n' + "---------------------------------------");
            System.out.println("For continue enter any number or letter");
            System.out.println("---------------------------------------");
            showStatistic();
        });
        ScheduledExecutorService service = Executors.newScheduledThreadPool(8);
        service.execute(thread);
        service.shutdown();
   }
   public void showStatistic(){


            System.out.println('\n' + "All animals quantity");
            monitor.showAllCounter(gameField.getTotalCount());
            System.out.println("All reproduced animals quantity");
            monitor.showAllCounter(gameField.getReproduceCountMap());
            System.out.println("All eaten animals quantity");
            monitor.showAllCounter(gameField.getEatenCountMap());
            System.out.println("All died animals quantity");
            monitor.showAllCounter(gameField.getDiedCountMap());
            System.out.println("All growing plants quantity");
            monitor.showAllGrowings(gameField.getGrowMap());
            System.out.println("Total mass of plants eaten  " + gameField.getEatenGrassWeight() / 1000 + " kilo" + '\n' + '\n');


   }


    public  Cell[][] getCells() {
        return cells;
    }
}
