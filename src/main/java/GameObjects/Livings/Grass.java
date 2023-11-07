package GameObjects.Livings;

import Abstract.Plant;
import Annotations.PlantAnnotation;

import java.io.Serializable;

@PlantAnnotation
public class Grass extends Plant implements Serializable {
    public Grass() {
        super.setName("Plant");
        super.setWeight(1000);
        super.setMaxQuantity(200);

    }
}
