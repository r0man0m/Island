package GameObjects;

import java.util.HashMap;

public class GameField {
    private Cell[][] cells;
    private final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};
    private final HashMap<Types, Long> AllCounterMap = new HashMap<>();
    private final HashMap<Types, Long> diedCountMap = new HashMap<>();
    private final HashMap<Types, Long> reproduceCountMap = new HashMap<>();
    private final HashMap<Types, Long> eatenCountMap = new HashMap<>();
    private  long allGrowQuantity = 0;
    private long eatenGrassWeight = 0L;


    public GameField() {
        for (Types T: names) {
            AllCounterMap.put(T, 0L);
            diedCountMap.put(T, 0L);
            reproduceCountMap.put(T, 0L);
            eatenCountMap.put(T, 0L);
        }
    }

    public Cell[][] getField(){
        return this.cells;
    }
    public void setGameField(Cell[][]cells){
        this.cells = cells;
    }
    public void   setCounterMap(Types types, long count) {
        AllCounterMap.put(types, count);
    }
    public long getCount(Types types){
        return AllCounterMap.get(types);
    }

    public HashMap<Types, Long> getDiedCountMap() {
        return diedCountMap;
    }
    public void setDieCountMap(Types types, long count){
        diedCountMap.put(types, count);
    }

    public HashMap<Types, Long> getReproduceCountMap() {
        return reproduceCountMap;
    }
    public void setReproduceCountMap(Types types, long count){
        reproduceCountMap.put(types, count);
    }

    public HashMap<Types, Long> getEatenCountMap() {
        return eatenCountMap;
    }
    public void setEatenCountMap(Types types, long count){
        eatenCountMap.put(types, count);
    }

    public long getAllGrowQuantity() {
        return allGrowQuantity;
    }

    public void setAllGrowQuantity(int allGrowQuantity) {
        this.allGrowQuantity += allGrowQuantity;
    }

    public long getEatenGrassWeight() {
        return eatenGrassWeight;
    }

    public void setEatenGrassWeight(int eatenGrassWeight) {
        this.eatenGrassWeight += eatenGrassWeight;
    }
    public HashMap<Types, Long> getTotalCount(){
        return AllCounterMap;
    }

}
