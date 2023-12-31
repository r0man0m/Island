package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@HerbivorousAnnotation
public class Goat extends Herbivorous implements Serializable {
    public Goat() {
        super.setTypes(Types.GOAT);
        super.setName("Goat");
        super.setMaxWeight(60000);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(140);
        super.setMaxMove(3);
        super.setMaxFood(10000);
    }
}
