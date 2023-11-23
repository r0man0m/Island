
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

           // while (!current.isInterrupted()) {

            for (int i = 0; i < 10; i++) {
                System.out.println("Before play###########################################################");
                try {
                    gameEngine.playGame();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("After play##############################################################");
                synchronized (lock){
                    lock.notify();
                }
            }


            //}


        });
        Thread statistic = new Thread(()->{
            Thread current = Thread.currentThread();

            synchronized (lock) {
                while (!current.isInterrupted()) {
                    try {
                        System.out.println("Before lock--------------------------------------------");
                        lock.wait();
                        System.out.println("After wait-----------------------------------------------");
                        //Thread.sleep(12000);

                        System.out.println("Before statistic-----------------------------------------");
                        gameEngine.statistic();
                        System.out.println("After statistic-----------------------------------------");


                             try {
                                 //int e = Integer.parseInt(scanner.next());
                                 Thread.sleep(5000);

                             }catch (NumberFormatException n){

                             }

                    } catch (InterruptedException e) {
                        current.interrupt();
                    }

                }
            }
        });

     Thread.sleep(3000);
    // play.start();
        while (!Thread.currentThread().isInterrupted()){
            gameEngine.playGame();
        }


     statistic.start();
        Thread.sleep(5000);
        Thread.currentThread().interrupt();
        statistic.interrupt();



    }

}
