package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;

import java.io.Serializable;

@HerbivorousAnnotation
public class Buffalo extends Herbivorous implements Serializable {
    public Buffalo() {
        super.setName("Buffalo");
        super.setWeight(700000);
        super.setMaxQuantity(10);
        super.setMaxMove(3);
        super.setMaxFood(100000);
    }
}
