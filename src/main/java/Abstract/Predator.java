package Abstract;

import GameObjects.Cell;
import GameObjects.GameField;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public synchronized void eat(GameField gameField){
        Cell[][]cells = gameField.getField();
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
                    synchronized (gameField.getEatenCountMap()) {
                        gameField.setEatenCountMap(O.getTypes(), gameField.getEatenCountMap().get(O.getTypes()) + 1);
                    }
                    synchronized (gameField.getTotalCount()) {
                        if (gameField.getCount(this.getTypes()) != 0) {
                            gameField.setCounterMap(O.getTypes(), gameField.getCount(O.getTypes()) - 1);
                        }
                    }

                    System.out.println(this + " ate " + O);
                }
            }
        }
    }
    public synchronized boolean getProbability(Types types){
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
