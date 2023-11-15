package GameObjects.Livings;

import Abstract.Herbivorous;
import Annotations.HerbivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@HerbivorousAnnotation
public class Deer extends Herbivorous implements Serializable {
    public Deer() {
        super.setTypes(Types.DEER);
        super.setName("Deer");
        super.setMaxWeight(300000);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(20);
        super.setMaxMove(4);
        super.setMaxFood(50000);
    }
}
