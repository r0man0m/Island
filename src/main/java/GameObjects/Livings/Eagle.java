package GameObjects.Livings;

import Abstract.Predator;
import Annotations.PredatorAnnotation;

import java.io.Serializable;

@PredatorAnnotation
public class Eagle extends Predator implements Serializable {
    public Eagle() {
        super.setName("Eagle");
        super.setWeight(6000);
        super.setMaxQuantity(20);
        super.setMaxMove(3);
        super.setMaxFood(1000);
    }
}
