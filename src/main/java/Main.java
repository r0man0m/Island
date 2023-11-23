
import GameObjects.Configurator;
import GameObjects.FactoryThread;
import GameObjects.GameEngine;
import GameObjects.GameField;

import java.io.IOException;
import java.util.Scanner;



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
