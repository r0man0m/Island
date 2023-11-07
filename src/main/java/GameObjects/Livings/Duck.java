package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;

import java.io.Serializable;

@HerbivorousAnnotation
public class Duck extends Herbivorous implements Serializable {
    public Duck() {
        super.setName("Duck");
        super.setWeight(1000);
        super.setMaxQuantity(200);
        super.setMaxMove(4);
        super.setMaxFood(150);
    }
}
