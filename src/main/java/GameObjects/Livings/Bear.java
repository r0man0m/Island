package GameObjects.Livings;

import Abstract.Omnivorous;
import Abstract.Predator;
import Annotations.OmnivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;


@OmnivorousAnnotation
public class Bear extends Predator implements Serializable {


    public Bear() {
        super.setTypes(Types.BEAR);
        super.setName("Bear");
        super.setWeight(500000);
        super.setMaxQuantity(5);
        super.setMaxMove(2);
        super.setMaxFood(80000);

    }
}
