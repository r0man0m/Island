package Abstract;

import GameObjects.Cell;
import GameObjects.Types;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivorous extends Animal{
    public boolean getProbability(Types types){
        int propertyObject = getPropery(types);
        if(propertyObject == 100) {
            return true;
        }else {
            return false;
        }

    }
}
