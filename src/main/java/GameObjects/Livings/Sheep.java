package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@HerbivorousAnnotation
public class Sheep extends Herbivorous implements Serializable {
    public Sheep() {
        super.setTypes(Types.SHEEP);
        super.setName("Sheep");
        super.setWeight(70000);
        super.setMaxQuantity(140);
        super.setMaxMove(3);
        super.setMaxFood(15);
    }
}
