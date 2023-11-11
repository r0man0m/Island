package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@HerbivorousAnnotation
public class Rabbit extends Herbivorous implements Serializable {
    public Rabbit() {
        super.setTypes(Types.RABBIT);
        super.setName("Rabbit");
        super.setWeight(2000);
        super.setMaxQuantity(150);
        super.setMaxMove(2);
        super.setMaxFood(450);
    }
}
