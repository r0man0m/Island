package GameObjects.Livings;

import Abstract.Omnivorous;
import Annotations.OmnivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@OmnivorousAnnotation
public class Boar extends Omnivorous implements Serializable {
    public Boar() {
        super.setTypes(Types.BOAR);
        super.setName("Boar");
        super.setWeight(400000);
        super.setMaxQuantity(50);
        super.setMaxMove(2);
        super.setMaxFood(50000);
    }
}