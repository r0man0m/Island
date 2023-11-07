package GameObjects.Livings;

import Abstract.Herbivorous;
import Abstract.Omnivorous;
import Annotations.HerbivorousAnnotation;
import Annotations.OmnivorousAnnotation;

import java.io.Serializable;

@OmnivorousAnnotation
public class Mouse extends Omnivorous implements Serializable {
    public Mouse() {
        super.setName("Mouse");
        super.setWeight(50);
        super.setMaxQuantity(100);
        super.setMaxMove(1);
        super.setMaxFood(10);
    }
}
