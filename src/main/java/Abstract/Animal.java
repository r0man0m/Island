package Abstract;


import GameObjects.Cell;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public abstract class Animal extends Living {
   private int maxMove;
   private int maxFood;

   @Override
   public void play(Cell[][] cells) {
      go(cells);
      eat(cells);
      die(cells);
      reproduce(cells);
   }



   public  void die(Cell[][] cells){
      Cell[][] playerCells = cells;
   }
   public  void reproduce(Cell[][] cells){
      Cell[][] playerCells = cells;

   }
   public abstract void eat(Cell[][] cells);



   public int getMaxMove() {
      return maxMove;
   }

   public void setMaxMove(int maxMove) {
      this.maxMove = maxMove;
   }

   public int getMaxFood() {
      return maxFood;
   }

   public void setMaxFood(int maxFood) {
      this.maxFood = maxFood;
   }

   public  void go(Cell[][]cells) {
      if ((this.getTypes().equals(Types.GRASS)) || ((this.getTypes().equals(Types.WORM)))) {
         return;
      } else {
         int x = getCoordinate().getX();
         int y = getCoordinate().getY();
         Cell[][] playerCells = cells;
         ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
         ArrayList<GameObject> objects = (ArrayList<GameObject>) queues.stream().collect(Collectors.toList());
         for (GameObject O : objects) {
            if (O.getId() == this.getId()) {
               queues.remove(O);
               break;
            }
         }

         int direction = ThreadLocalRandom.current().nextInt(1, 5);
         int move = ThreadLocalRandom.current().nextInt(1, maxMove + 1);

         switch (direction) {
            case 1:// Left direction
               if (x == 0) {
                  setCoordinate(x, y);
                  queues.add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Stay here ");
               } else if ((x - move) >= 0) {
                  this.setCoordinate(x - move, y);
                  playerCells[y][x - move].getQueue().add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Move left on " + move + " steps ");
               }
               break;
            case 2: // Top direction
               if (y == 0) {
                  setCoordinate(x, y);
                  queues.add(this);
                  System.out.println(this.getName() + " " + getId() + " Stay here ");
               } else if ((y - move) >= 0) {
                  this.setCoordinate(x, y - move);
                  playerCells[y - move][x].getQueue().add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Move top " + move + " steps ");
               }
               break;
            case 3: //Right direction
               if (x == playerCells[0].length - 1) {
                  setCoordinate(x, y);
                  queues.add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Stay here");
               } else if ((x + move) < playerCells.length) {
                  this.setCoordinate(x + move, y);
                  playerCells[y][x + move].getQueue().add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Move right on " + move + " steps ");
               }
               break;
            case 4: //Down direction
               if (y == playerCells.length - 1) {
                  setCoordinate(x, y);
                  queues.add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Stay here");
               } else if ((y + move) < playerCells.length) {
                  setCoordinate(x, y + move);
                  playerCells[y + move][x].getQueue().add(this);
                  System.out.println(this.getName() + " " + this.getId() + " Move down " + move + " steps ");
               }
               break;

         }


      }
   }
}
