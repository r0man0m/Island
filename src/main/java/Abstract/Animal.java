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
   public abstract boolean getProbability(Types types);


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
                  stayHere(queues, x, y);
               } else if ((x - move) >= 0) {
                  if(testCell(playerCells[y][x - move])) {
                     this.setCoordinate(x - move, y);
                     this.setWeight((int)(this.getWeight() * 0.9));
                     playerCells[y][x - move].getQueue().add(this);
                     System.out.println(this + " move left on " + move + " steps ");
                  }else {
                     System.out.println("This sell is full for " + this);
                     stayHere(queues, x, y);
                  }
               }else {
                  stayHere(queues, x, y);
               }
               break;
            case 2: // Top direction
               if (y == 0) {
                  stayHere(queues, x, y);
               } else if ((y - move) >= 0) {
                  if(testCell(playerCells[y - move][x])) {
                     this.setCoordinate(x, y - move);
                     this.setWeight((int)(this.getWeight() * 0.9));
                     playerCells[y - move][x].getQueue().add(this);
                     System.out.println(this + " move top " + move + " steps ");
                  }else {
                     System.out.println("This sell is full for " + this);
                     stayHere(queues, x, y);
                  }
               }else {
                  stayHere(queues, x, y);
               }
               break;
            case 3: //Right direction
               if (x == playerCells[0].length - 1) {
                  stayHere(queues, x, y);
               } else if ((x + move) < playerCells.length) {
                  if(testCell(playerCells[y][x + move])) {
                     this.setCoordinate(x + move, y);
                     this.setWeight((int)(this.getWeight() * 0.9));
                     playerCells[y][x + move].getQueue().add(this);
                     System.out.println(this + " move right on " + move + " steps ");
                  }else {
                     System.out.println("This sell is full for " + this);
                     stayHere(queues, x, y);
                  }
               }else {
                  stayHere(queues, x, y);
               }
               break;
            case 4: //Down direction
               if (y == playerCells.length - 1) {
                  stayHere(queues, x, y);
               } else if ((y + move) < playerCells.length) {
                  if(testCell(playerCells[y + move][x])) {
                     setCoordinate(x, y + move);
                     this.setWeight((int)(this.getWeight() * 0.9));
                     playerCells[y + move][x].getQueue().add(this);
                     System.out.println(this + " move down " + move + " steps ");
                  }else {
                     System.out.println("This sell is full for " + this);
                     stayHere(queues, x, y);
                  }
               }else {
                  stayHere(queues, x, y);
               }
               break;

         }


      }
   }
   public boolean testCell(Cell cell){
      int quantity = (int)cell.getQueue().stream().filter(c->c.getTypes().equals(this.getTypes())).count();
      if(quantity < this.getMaxQuantity()){
         return true;
      }
      else {
         return false;
      }
   }
   public void stayHere(ArrayBlockingQueue<GameObject> queues, int x, int y){
      setCoordinate(x, y);
      queues.add(this);
      System.out.println(this + " stay here ");
   }
}
