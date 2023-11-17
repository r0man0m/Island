package Abstract;

import GameObjects.Cell;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Herbivorous extends Animal{
    public  void eat(Cell[][] cells){
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();
        Cell[][] playerCells = cells;
        ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
        for (GameObject O: queues) {
            if(this.getWeight() < this.getMaxWeight()){
                if(getProbability(O.getTypes())){
                   if(O.getWeight() > this.getMaxFood()){
                       int food = this.getMaxFood();
                       O.setWeight(O.getWeight() - food);
                       System.out.println(this + " eats " + O);
                       if((this.getWeight() + food) > this.getMaxWeight()){
                           this.setWeight(this.getMaxWeight());
                       }
                       else {
                           this.setWeight(food);
                       }
                   }else {
                       int food = O.getWeight();
                       queues.remove(O);
                       System.out.println(this + " eats " + O);
                       if((this.getWeight() + food) > this.getMaxWeight()){
                           this.setWeight(this.getMaxWeight());
                       }else {
                           this.setWeight(food);
                       }

                   }
                }
            }
        }
    }
    public boolean getProbability(Types types){
        int propertyObject = getPropery(types);
        if(propertyObject == 100) {
            return true;
        }else {
            return false;
        }

    }
}
