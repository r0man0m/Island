package Abstract;

import GameObjects.Cell;
import GameObjects.Types;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Omnivorous extends Animal{
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
