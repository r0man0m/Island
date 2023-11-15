package GameObjects.Livings;

import Abstract.Herbivorous;
import Abstract.Omnivorous;
import Annotations.HerbivorousAnnotation;
import Annotations.OmnivorousAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@OmnivorousAnnotation
public class Duck extends Omnivorous implements Serializable {
    public Duck() {
        super.setTypes(Types.DUCK);
        super.setName("Duck");
        super.setMaxWeight(1000);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(200);
        super.setMaxMove(4);
        super.setMaxFood(150);
    }
}
