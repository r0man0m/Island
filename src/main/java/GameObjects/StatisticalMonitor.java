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
    public void showAllGrowings(HashMap<String, Integer> map){
        for (String S: map.keySet()) {
            System.out.print(S + "-");
            System.out.println(" " + map.get(S));
        }
        System.out.println("--------------------------");
        System.out.println();
    }

}
