package GameObjects.Livings;

import Abstract.Predator;
import Annotations.PredatorAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@PredatorAnnotation
public class Boa extends Predator implements Serializable {
    public Boa() {
        super.setTypes(Types.BOA);
        super.setName("Boa");
        super.setMaxWeight(1500);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(30);
        super.setMaxMove(1);
        super.setMaxFood(3000);
    }
}
