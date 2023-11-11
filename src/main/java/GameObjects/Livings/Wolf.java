package GameObjects.Livings;

import Abstract.Predator;
import Annotations.PredatorAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@PredatorAnnotation
public class Wolf extends Predator implements Serializable {
    public Wolf() {
        super.setTypes(Types.WOLF);
        super.setName("Wolf");
        super.setWeight(50000);
        super.setMaxQuantity(30);
        super.setMaxMove(3);
        super.setMaxFood(8000);
    }
}
