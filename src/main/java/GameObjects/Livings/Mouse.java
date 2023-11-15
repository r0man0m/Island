package GameObjects.Livings;

import Abstract.Herbivorous;
import Abstract.Omnivorous;
import Annotations.HerbivorousAnnotation;
import Annotations.OmnivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@OmnivorousAnnotation
public class Mouse extends Omnivorous implements Serializable {
    public Mouse() {
        super.setTypes(Types.MOUSE);
        super.setName("Mouse");
        super.setMaxWeight(50);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(100);
        super.setMaxMove(1);
        super.setMaxFood(10);
    }
}
