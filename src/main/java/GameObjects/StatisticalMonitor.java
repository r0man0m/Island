package GameObjects;

import java.math.BigInteger;
import java.util.HashMap;

public class StatisticalMonitor {
    public void showAllCounter(HashMap<Types, BigInteger> map){
        System.out.println("-----------------------");
        for (Types T:map.keySet()) {
            System.out.print("[" + T + "-");
            System.out.print(" " + map.get(T) + "] ");
        }
        System.out.println();

        System.out.println();
    }
    public void showAllGrowings(BigInteger count){
        System.out.print(" " +  count + " ");
    }
    public void showEatenGrassWeight(GameField gameField){
        System.out.println("Total mass of plants eaten  " + gameField.getEatenGrassWeight().divide(BigInteger.valueOf(1000)) + " kilo" + '\n' + '\n');
    }

}
