package GameObjects;

import java.util.HashMap;

public class StatisticalMonitor {
    public void showAllCounter(HashMap<Types, Integer> map){
        System.out.println("-----------------------");
        for (Types T:map.keySet()) {
            System.out.print("[" + T + "-");
            System.out.print(" " + map.get(T) + "] ");
        }
        System.out.println();

        System.out.println();
    }
    public void showAllGrowings(int count){
        System.out.println(count);
    }
    public void showEatenGrassWeight(GameField gameField){
        System.out.println("Total mass of plants eaten  " + gameField.getEatenGrassWeight() / 1000 + " kilo" + '\n' + '\n');
    }

}
