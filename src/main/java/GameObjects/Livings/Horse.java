package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;

import java.io.Serializable;

@HerbivorousAnnotation
public class Horse extends Herbivorous implements Serializable {
    public Horse() {
        super.setName("Horse");
        super.setWeight(400000);
        super.setMaxQuantity(20);
        super.setMaxMove(4);
        super.setMaxFood(60000);
    }
}
