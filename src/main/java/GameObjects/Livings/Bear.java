package GameObjects.Livings;

import Abstract.Predator;
import Annotations.PredatorAnnotation;
import GameObjects.Types;

import java.io.Serializable;


@PredatorAnnotation
public class Bear extends Predator implements Serializable {


    public Bear() {
        super.setTypes(Types.BEAR);
        super.setName("Bear");
        super.setMaxWeight(500000);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(5);
        super.setMaxMove(2);
        super.setMaxFood(80000);

    }

}
