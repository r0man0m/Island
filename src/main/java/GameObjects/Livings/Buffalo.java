package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@HerbivorousAnnotation
public class Buffalo extends Herbivorous implements Serializable {
    public Buffalo() {
        super.setTypes(Types.BUFFALO);
        super.setName("Buffalo");
        super.setMaxWeight(700000);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(10);
        super.setMaxMove(3);
        super.setMaxFood(100000);
    }
}
