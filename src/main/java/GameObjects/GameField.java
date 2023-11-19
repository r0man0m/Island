package GameObjects;

import java.util.HashMap;
import java.util.Iterator;

public class GameField {
    private Cell[][] cells;
    private final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};
    private final HashMap<Types, Integer> counterMap = new HashMap<>();
    private final HashMap<Types, Integer> diedCountMap = new HashMap<>();
    private final HashMap<Types, HashMap<String, Integer>> diedNamesMaps = new HashMap<>();
    private final HashMap<Types, Integer> reproduceCountMap = new HashMap<>();
    private final HashMap<Types, HashMap<String, Integer>> reproducedNamesMap = new HashMap<>();
    private final HashMap<Types, HashMap<String, Integer>> eatenNamesMap = new HashMap<>();
    private final HashMap<Types, Integer> eatenCountMap = new HashMap<>();
    private final HashMap<String, Integer> growMap = new HashMap<>();
    private int eatenGrassWeight = 0;

    public GameField() {
        for (Types T: names) {
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
    public void   setCounterMap(Types types, int id) {
        counterMap.put(types, id);
    }
    public int getCount(Types types){
        return counterMap.get(types);
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
    public void setDiedNamesMap(Types types, String name, int id){
        HashMap<String , Integer>namesIdMap = new HashMap<>();
        namesIdMap.put(name, id);
        diedNamesMaps.put(types, namesIdMap);
    }
    public HashMap<String, Integer> getDiedNames(Types types){
        return diedNamesMaps.get(types);
    }
    public void setReproducedNamesMap(Types types, String name, int id){
        HashMap<String, Integer> namesIdMap = new HashMap<>();
        namesIdMap.put(name, id);
        reproducedNamesMap.put(types, namesIdMap);
    }
    public HashMap<String, Integer> getReproducedNames(Types types){
        return reproducedNamesMap.get(types);
    }
    public void setEatenNamesMap(Types types, String name, int id){
        HashMap<String, Integer> namesIdMap = new HashMap<>();
        namesIdMap.put(name, id);
        eatenNamesMap.put(types, namesIdMap);
    }
    public HashMap<String, Integer> getEatenNames(Types types){
        return eatenNamesMap.get(types);
    }
    public HashMap<String, Integer> getGrowMap(){
        return growMap;
    }
    public void setGrowMap(String name, int id){
        growMap.put(name, id);
    }

    public int getEatenGrassWeight() {
        return eatenGrassWeight;
    }

    public void setEatenGrassWeight(int eatenGrassWeight) {
        this.eatenGrassWeight += eatenGrassWeight;
    }
}
