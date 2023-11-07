package GameObjects.Livings;

import Abstract.Living;
import Annotations.AnimalAnnotation;

import java.io.Serializable;

@AnimalAnnotation
public class Worm extends Living implements Serializable {
    public Worm() {
        super.setName("Worm");
        super.setWeight(10);
        super.setMaxQuantity(1000);
    }

    @Override
    public void play() {

    }
}
