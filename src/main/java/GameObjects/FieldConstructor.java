package GameObjects;

import Annotations.FieldAnnotation;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;

@FieldAnnotation
public class FieldConstructor implements Serializable {
    private int length = 100;
    private int height = 20;


    public Cell[][] initF() {
        BigInteger id = BigInteger.ZERO;
        Cell[][]cells = new Cell[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setId(id);
                id = id.add(BigInteger.ONE);
            }
        }
        return cells;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
