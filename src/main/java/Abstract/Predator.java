package Abstract;

import GameObjects.Cell;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public  void eat(Cell[][] cells){
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();
        Cell[][] playerCells = cells;
        ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
        for (GameObject O: queues) {
            if(this.getWeight() < this.getMaxWeight()){
                if(getProbability(O.getTypes())){
                    int w = O.getWeight();
                    if(w < this.getMaxFood()){
                        int food = this.getMaxFood();
                        if((this.getWeight() + food) < this.getMaxWeight()){
                            this.setWeight(this.getWeight() + food);
                        }else {
                            this.setWeight(this.getMaxWeight());
                        }
                    }else if((this.getWeight() + w) < this.getMaxWeight()){
                        this.setWeight(this.getWeight() + w);
                    }
                    else {
                        this.setWeight(this.getMaxWeight());
                    }
                    queues.remove(O);
                    System.out.println(this + " eats " + O);
                }
            }
        }
    }
    public boolean getProbability(Types types){
        int propertyObject = getProperty(types);
        if(propertyObject != 0) {
            int probability = ThreadLocalRandom.current().nextInt(1, 100);
            if(probability > (100 - propertyObject)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
