package Abstract;

import GameObjects.Cell;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;



public abstract class Herbivorous extends Animal{
    public  void eat(Cell[][] cells){
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();
        Cell[][] playerCells = cells;
        ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
        for (GameObject O: queues) {
            if(this.getWeight() < this.getMaxWeight()){
                if(getProbability(O.getTypes())){
                   if((O.getWeight() != 0) && (O.getWeight() > this.getMaxFood())){
                       int food = this.getMaxFood();
                       O.setWeight(O.getWeight() - food);
                       System.out.println(this + " eats " + O);
                       if((this.getWeight() + food) > this.getMaxWeight()){
                           this.setWeight(this.getMaxWeight());
                       }
                       else {
                           this.setWeight(food);
                       }
                   }else if(O.getWeight() != 0 ){
                       int food = O.getWeight();
                       O.setWeight(0);
                       System.out.println(this + " eats " + O);
                       if((this.getWeight() + food) > this.getMaxWeight()){
                           this.setWeight(this.getMaxWeight());

                       }else {
                           this.setWeight(food + this.getWeight());

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
