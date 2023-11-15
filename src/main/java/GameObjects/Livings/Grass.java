package GameObjects.Livings;

import Abstract.Plant;
import Annotations.PlantAnnotation;
import GameObjects.Types;

import java.io.Serializable;

@PlantAnnotation
public class Grass extends Plant implements Serializable {
    public Grass() {
        super.setTypes(Types.GRASS);
        super.setName("Plant");
        super.setMaxWeight(1000);
        super.setWeight(getMaxWeight());
        super.setMaxQuantity(200);

    }
}
