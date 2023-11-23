
import GameObjects.Configurator;
import GameObjects.FactoryThread;
import GameObjects.GameEngine;
import GameObjects.GameField;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        FactoryThread factoryThread = new FactoryThread();
        Configurator configurator = new Configurator();
        //configurator.crateYmlFiles();
        GameField gameField = configurator.initGameField();
        GameEngine gameEngine = new GameEngine(gameField);
        Object lock = new Object();
        Scanner scanner = new Scanner(System.in);
        gameEngine.show();

        Thread play = new Thread(()->{
            Thread current = Thread.currentThread();

            while (!current.isInterrupted()) {
                   /* try {
                        Thread.sleep(1000);
                        gameEngine.playGame();
                    }catch (InterruptedException e){
                        current.interrupt();
                    }*/
                    gameEngine.playGame();

                synchronized (lock){
                    lock.notify();
                }

            }


        });
        Thread statistic = new Thread(()->{
            Thread current = Thread.currentThread();
            synchronized (lock) {
                while (!current.isInterrupted()) {
                    try {
                        lock.wait();
                        Thread.sleep(10000);
                        gameEngine.statistic();

                             System.out.println();
                             System.out.println("---------------------------------------");
                             System.out.println("For continue enter any number or letter");
                             System.out.println("---------------------------------------");
                             try {
                                 int e = Integer.parseInt(scanner.next());
                             }catch (NumberFormatException n){

                             }



                    } catch (InterruptedException e) {
                        current.interrupt();
                    }

                }
            }
        });

     Thread.sleep(3000);
     play.start();
     statistic.start();
        Thread.sleep(120000);
        play.interrupt();
        statistic.interrupt();




    }

}
