
import GameObjects.Configurator;
import GameObjects.GameEngine;
import GameObjects.GameField;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Configurator configurator = new Configurator();
                int choice = 0;
                while (choice != 1) {
                    try {
                        System.out.println("If you want to change the parameters Livings or size the Game Field,  you must change YMl files in YMLfiles directory");
                        System.out.println("To do this enter \"1\" then restart the game");
                        System.out.println("Otherwise  enter any number");
                        Scanner scanner = new Scanner(System.in);
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            return;
                        } else {
                            choice = 1;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("You must enter the number \n");
                    }

                }
                choice = 0;
            while (choice != 1) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("If you want to apply the new settings enter 1");
                    System.out.println("If you want to continue playing with the default settings enter any number");
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\n You must enter the number\n");
                }
                if (choice == 1) {
                    configurator.crateYmlFiles();
                    System.out.println("YML files was updated");

                }


                    GameField gameField = configurator.initGameField();
                    GameEngine gameEngine = new GameEngine(gameField);

                    gameEngine.show();
                    Thread.sleep(5000);

                    while (true) {
                        try {
                            gameEngine.playGame();
                            gameEngine.statistic();
                            System.out.println();

                            Scanner scanner = new Scanner(System.in);
                            String s = scanner.nextLine();
                            if (s.equalsIgnoreCase("stop")) {
                                Thread.currentThread().interrupt();
                            }

                            Thread.sleep(5000);

                        } catch (InterruptedException | ExecutionException | InputMismatchException |
                                 TimeoutException e) {

                            return;
                        } finally {
                            System.out.println("Game over");

                        }
                    }

            }
    }
}


