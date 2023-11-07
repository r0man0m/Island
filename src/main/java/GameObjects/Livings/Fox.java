package GameObjects.Livings;

import Abstract.Predator;
import Annotations.PredatorAnnotation;

import java.io.Serializable;

@PredatorAnnotation
public class Fox extends Predator implements Serializable {
    public Fox() {
        super.setName("Fox");
        super.setWeight(8000);
        super.setMaxQuantity(30);
        super.setMaxMove(2);
        super.setMaxFood(2000);
    }
}
