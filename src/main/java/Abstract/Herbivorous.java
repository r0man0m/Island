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
            if(this.getWeight() < this.getMaxWeight()){ // If this is hungry
                if(getProbability(O.getTypes())){ // If Object is Grass
                   if((O.getWeight() != 0) && (O.getWeight() > this.getMaxFood())){ // If Grass weight != 0 and
                                                                                    // Grass weight > this maxFood
                       int food = this.getMaxFood();   // set weight food = this maxFood
                       O.setWeight(O.getWeight() - food); // set Grass weight = Grass weight - food
                       synchronized (gameField) {
                           gameField.setEatenGrassWeight(food); // set Map for Grass
                       }
                       this.setWeight(this.getWeight() + food); // set this weight = this weight + food
                         if(this.getWeight() > this.getMaxWeight()){ // check if this weight > this max weight
                           this.setWeight(this.getMaxWeight()); // set this weight = this maxWeight
                           System.out.println(this + " ate " + O); // print eat
                       }else {
                             this.setWeight(this.getWeight() + food); // else set this weight = this weight + food
                             System.out.println(this + " ate " + O); // print eat
                         }

                   }else if((O.getWeight() != 0) && (O.getWeight() < this.getMaxFood())){ // If Grass weight != 0 and
                                                                                          // Grass weight < this maxFood
                       int food = O.getWeight(); // set food weight = Grass weight
                       if(this.getWeight() + food < this.getMaxWeight()) { // check if this may eat all Grass
                           O.setWeight(0); // set Grass weight = 0
                           synchronized (gameField) {
                               gameField.setEatenGrassWeight(food); // set Map Grass
                           }
                           this.setWeight(this.getWeight() + food); // set this weight = this weight + food
                           System.out.println(this + " ate " + O); // print eat
                       } else {                                   // else this can`t eat all Grass
                           if(O.getWeight() > this.getMaxWeight() - this.getWeight()){ // check if Grass weight >
                                                                                       // this maxWeight - this weight
                                food = this.getMaxWeight() - this.getWeight(); // set food = this maxWeight - this weight
                               O.setWeight(O.getWeight() - food);//set Grass weight = Grass weight - food
                               synchronized (gameField) {
                                   gameField.setEatenGrassWeight(food); // set Map Grass
                               }
                               this.setWeight(this.getMaxWeight()); // set this weight = this maxWeight
                               System.out.println(this + " ate " + O); // print eat
                           }
                           else { // else if Grass weight < this maxWeight - this weight
                               food = O.getWeight(); // food  = Grass weight
                               O.setWeight(0); // set Grass weight = 0
                               synchronized (gameField) {
                                   gameField.setEatenGrassWeight(food); // set Map Grass
                               }
                               this.setWeight(this.getWeight() + food); // set this weight  = this weight + food
                               System.out.println(this + " ate " + O); // print eat
                           }
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
