package GameObjects;

import java.math.BigInteger;
import java.util.HashMap;

public class GameField {
    private Cell[][] cells;
    private final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};
    private  final HashMap<Types, BigInteger> AllCounterMap = new HashMap<>();
    private final HashMap<Types, BigInteger> diedCountMap = new HashMap<>();
    private final HashMap<Types, BigInteger> reproduceCountMap = new HashMap<>();
    private final HashMap<Types, BigInteger> eatenCountMap = new HashMap<>();
    private  BigInteger allGrowQuantity = BigInteger.ZERO;
    private BigInteger eatenGrassWeight = BigInteger.ZERO;


    public GameField() {
        for (Types T: names) {
            AllCounterMap.put(T, BigInteger.ZERO);
            diedCountMap.put(T, BigInteger.ZERO);
            reproduceCountMap.put(T, BigInteger.ZERO);
            eatenCountMap.put(T, BigInteger.ZERO);
        }
    }

    public Cell[][] getField(){
        return this.cells;
    }
    public void setGameField(Cell[][]cells){
        this.cells = cells;
    }
    public void   setCounterMap(Types types, BigInteger count) {
        AllCounterMap.put(types, count);
    }
    public BigInteger getCount(Types types){
        return AllCounterMap.get(types);
    }

    public HashMap<Types, BigInteger> getDiedCountMap() {
        return diedCountMap;
    }
    public void setDieCountMap(Types types, BigInteger count){
        diedCountMap.put(types, count);
    }

    public HashMap<Types, BigInteger> getReproduceCountMap() {
        return reproduceCountMap;
    }
    public void setReproduceCountMap(Types types, BigInteger count){
        reproduceCountMap.put(types, count);
    }

    public HashMap<Types, BigInteger> getEatenCountMap() {
        return eatenCountMap;
    }
    public void setEatenCountMap(Types types, BigInteger count){
        eatenCountMap.put(types, count);
    }

    public BigInteger getAllGrowQuantity() {
        return allGrowQuantity;
    }

    public void setAllGrowQuantity(BigInteger allGrowQuantity) {

        this.allGrowQuantity = this.allGrowQuantity.add(allGrowQuantity);
    }

    public BigInteger getEatenGrassWeight() {
        return eatenGrassWeight;
    }

    public void setEatenGrassWeight(BigInteger eatenGrassWeight) {
        this.eatenGrassWeight = this.eatenGrassWeight.add(eatenGrassWeight);
    }
    public HashMap<Types, BigInteger> getTotalCount(){
        return AllCounterMap;
    }

}
