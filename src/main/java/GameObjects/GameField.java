package GameObjects;

import java.io.Serializable;

public class GameField implements Serializable {
    private int length = 20;
    private int height = 10;
    public  Cell[][] getField(){
        return new Cell[length][height];
    }

}
