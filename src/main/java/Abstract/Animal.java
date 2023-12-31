package Abstract;


import GameObjects.Cell;
import GameObjects.GameField;
import GameObjects.Types;
import Interfaces.GameObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public abstract class Animal extends Living implements Cloneable{
   private int maxMove;
   private int maxFood;


   @Override
   public void play(GameField gameField) throws CloneNotSupportedException, InterruptedException {
      go(gameField);
      eat(gameField);
      reproduce(gameField);
      die(gameField);
   }

   public void die(GameField gameField){
      Cell[][] playerCells = gameField.getField();
      int x = getCoordinate().getX();
      int y = getCoordinate().getY();
      ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
      if(this.getWeight() < this.getMaxWeight() / 4){
         if(!gameField.getCount(this.getTypes()).equals(BigInteger.ZERO)) {
            synchronized (gameField.getTotalCount()) {
               gameField.setCounterMap(this.getTypes(), gameField.getCount(this.getTypes()).add(BigInteger.valueOf(-1)));
            }
            }
            synchronized (gameField.getDiedCountMap()) {
               gameField.setDieCountMap(this.getTypes(), gameField.getDiedCountMap().get(this.getTypes()).add(BigInteger.ONE));
            System.out.println(this + " died(");
            queues.remove(this);
      }

      }
   }



   public  void reproduce(GameField gameField) throws CloneNotSupportedException, InterruptedException {
      Cell[][]playerCells = gameField.getField();
      int x = getCoordinate().getX();
      int y = getCoordinate().getY();
      if(testCell(playerCells[y][x]) && (playerCells[y][x].getQueue().stream().anyMatch(o->o.getTypes().equals(this.getTypes())))){
         GameObject child = (GameObject) this.clone();
         child.setWeight(child.getMaxWeight());
         child.setCoordinate(x, y);
         child.setAvatar(this.getAvatar());
            synchronized (gameField.getTotalCount()) {
               child.setId(gameField.getCount(child.getTypes()).add(BigInteger.ONE));
               gameField.setCounterMap(child.getTypes(), gameField.getCount(child.getTypes()).add(BigInteger.ONE));
           }
           synchronized (gameField.getReproduceCountMap()) {
              gameField.setReproduceCountMap(child.getTypes(), gameField.getReproduceCountMap().get(child.getTypes()).add(BigInteger.ONE));
              System.out.println(this + " birth " + child);
              playerCells[y][x].getQueue().add(child);
           }
      }

   }
   public abstract void eat(GameField gameField);
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


   public synchronized void go(GameField gameField) {
      Cell[][]cells = gameField.getField();
      if (!((this.getTypes().equals(Types.GRASS)) || ((this.getTypes().equals(Types.WORM))))) {
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
                     this.setWeight((int)(this.getWeight() * 0.7));
                     playerCells[y][x - move].getQueue().add(this);
                     System.out.println(this + " moved left on " + move + " steps ");
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
                     this.setWeight((int)(this.getWeight() * 0.7));
                     playerCells[y - move][x].getQueue().add(this);
                     System.out.println(this + " moved top " + move + " steps ");
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
                     this.setWeight((int)(this.getWeight() * 0.7));
                     playerCells[y][x + move].getQueue().add(this);
                     System.out.println(this + " moved right on " + move + " steps ");
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
                     this.setWeight((int)(this.getWeight() * 0.7));
                     playerCells[y + move][x].getQueue().add(this);
                     System.out.println(this + " moved down " + move + " steps ");
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
   public synchronized boolean testCell(Cell cell){
      int quantity = (int)cell.getQueue().stream().filter(c->c.getTypes().equals(this.getTypes())).count();
      if(quantity < this.getMaxQuantity()){
         return true;
      }
      else {
         return false;
      }
   }
   public synchronized void stayHere(ArrayBlockingQueue<GameObject> queues, int x, int y){
      setCoordinate(x, y);
      this.setWeight((int)(this.getWeight() * 0.5));
      queues.add(this);
      System.out.println(this + " don`t move ");
   }
}
