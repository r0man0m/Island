package Abstract;

import GameObjects.Cell;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Omnivorous extends Animal{
    public  void eat(Cell[][] cells){
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();
        Cell[][] playerCells = cells;
        ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
        for (GameObject O: queues) {
            if(O.getTypes().equals(Types.GRASS)) {
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
            }else {
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
    }
    public boolean getProbability(Types types){
        int propertyObject = getPropery(types);
        if(propertyObject == 100){
            return true;
        }
        else if(propertyObject != 0) {
            int probability = ThreadLocalRandom.current().nextInt(1, 100);
            if(probability > (100 - propertyObject)){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }
}
