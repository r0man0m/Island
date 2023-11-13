package GameObjects.Livings;

import Abstract.Herbivorous;

import Annotations.HerbivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@HerbivorousAnnotation
public class Worm extends Herbivorous implements Serializable {
    public Worm() {
        super.setTypes(Types.WORM);
        super.setName("Worm");
        super.setWeight(10);
        super.setMaxQuantity(1000);
    }

}
