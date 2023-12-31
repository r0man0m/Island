package GameObjects.Livings;

import Abstract.Herbivorous;

import Annotations.HerbivorousAnnotation;
import Annotations.WormAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@WormAnnotation
public class Worm extends Herbivorous implements Serializable {
    public Worm() {
        super.setTypes(Types.WORM);
        super.setName("Worm");
        super.setMaxWeight(10);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(1000);
    }

}
