package Abstract;

import Annotations.WormAnnotation;
import GameObjects.Cell;
import GameObjects.GameEngine;
import GameObjects.Livings.Worm;
import GameObjects.Types;
import Interfaces.GameObject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public boolean getProbability(Types types){
        int propertyObject = getPropery(types);
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
