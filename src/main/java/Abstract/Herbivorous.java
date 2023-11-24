package Abstract;

import GameObjects.Cell;
import GameObjects.GameField;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;



public abstract class Herbivorous extends Animal{
    public  void eat(GameField gameField){
        Cell[][]playerCells = gameField.getField();
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();
        ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
        for (GameObject O: queues) {
            if(this.getWeight() < this.getMaxWeight()){
                if(getProbability(O.getTypes())){
                   if((O.getWeight() != 0) && (O.getWeight() > this.getMaxFood())){
                       int food = this.getMaxFood();
                       O.setWeight(O.getWeight() - food);
                       if(O.getWeight() < 0){
                           O.setWeight(0);
                       }
                       gameField.setEatenGrassWeight((int) (gameField.getEatenGrassWeight() + food));
                       this.setWeight(this.getWeight() + food);
                       if(this.getWeight() > this.getMaxWeight()){
                           this.setWeight(this.getMaxWeight());
                           System.out.println(this + " ate " + O);
                       }
                   }else if((O.getWeight() != 0) && (O.getWeight() < this.getMaxFood())){
                       int food = O.getWeight();
                       O.setWeight(0);
                       gameField.setEatenGrassWeight((int) (gameField.getEatenGrassWeight() + food));
                       System.out.println(this + " ate " + O);
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
        int propertyObject = getProperty(types);
        if(propertyObject == 100) {
            return true;
        }else {
            return false;
        }

    }
}
