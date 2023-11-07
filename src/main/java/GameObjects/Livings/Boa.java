package GameObjects.Livings;

import Abstract.Predator;
import Annotations.PredatorAnnotation;

import java.io.Serializable;

@PredatorAnnotation
public class Boa extends Predator implements Serializable {
    public Boa() {
        super.setName("Boa");
        super.setWeight(1500);
        super.setMaxQuantity(30);
        super.setMaxMove(1);
        super.setMaxFood(3000);
    }
}
