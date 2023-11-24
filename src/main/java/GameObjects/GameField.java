package GameObjects;

import java.util.HashMap;

public class GameField {
    private Cell[][] cells;
    private final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};
    private final HashMap<Types, Integer> AllCounterMap = new HashMap<>();
    private final HashMap<Types, Integer> diedCountMap = new HashMap<>();
    private final HashMap<Types, Integer> reproduceCountMap = new HashMap<>();
    private final HashMap<Types, Integer> eatenCountMap = new HashMap<>();
    private final HashMap<String, Integer> growMap = new HashMap<>();
    private long eatenGrassWeight = 0L;


    public GameField() {
        for (Types T: names) {
            AllCounterMap.put(T, 0);
            diedCountMap.put(T, 0);
            reproduceCountMap.put(T, 0);
            eatenCountMap.put(T, 0);
        }
    }

    public Cell[][] getField(){
        return this.cells;
    }
    public void setGameField(Cell[][]cells){
        this.cells = cells;
    }
    public void   setCounterMap(Types types, int count) {
        AllCounterMap.put(types, count);
    }
    public int getCount(Types types){
        return AllCounterMap.get(types);
    }

    public HashMap<Types, Integer> getDiedCountMap() {
        return diedCountMap;
    }
    public void setDieCountMap(Types types, int count){
        diedCountMap.put(types, count);
    }

    public HashMap<Types, Integer> getReproduceCountMap() {
        return reproduceCountMap;
    }
    public void setReproduceCountMap(Types types, int count){
        reproduceCountMap.put(types, count);
    }

    public HashMap<Types, Integer> getEatenCountMap() {
        return eatenCountMap;
    }
    public void setEatenCountMap(Types types, int count){
        eatenCountMap.put(types, count);
    }

    public HashMap<String, Integer> getGrowMap(){
        return growMap;
    }
    public void setGrowMap(String name, int id){
        growMap.put(name, id);
    }

    public long getEatenGrassWeight() {
        return eatenGrassWeight;
    }

    public void setEatenGrassWeight(int eatenGrassWeight) {
        this.eatenGrassWeight += eatenGrassWeight;
    }
    public HashMap<Types, Integer> getTotalCount(){
        return AllCounterMap;
    }

}
