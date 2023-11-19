package GameObjects;

import Interfaces.GameObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

public class GameField {
    private Cell[][] cells;
    private final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};
    private final HashMap<Types, Integer> counterMap = new HashMap<>();

    public Cell[][] getField(){
        return this.cells;
    }
    public void setGameField(Cell[][]cells){
        this.cells = cells;
    }
    public void   setCounterMap(Types types, int id) {
        counterMap.put(types, id);
    }
    public int getCount(Types types){
        return counterMap.get(types);
    }

}
