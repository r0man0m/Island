package GameObjects.Livings;

import Abstract.Omnivorous;
import Annotations.OmnivorousAnnotation;

import java.io.Serializable;

@OmnivorousAnnotation
public class Bear extends Omnivorous implements Serializable {
    public Bear() {
        super.setName("Bear");
        super.setWeight(500000);
        super.setMaxQuantity(5);
        super.setMaxMove(2);
        super.setMaxFood(80000);
    }
}
