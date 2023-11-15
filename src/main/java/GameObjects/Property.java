package GameObjects;

import java.util.HashMap;
import java.util.Hashtable;

public class Property {
    private  final Integer[][] properties = new Integer[15][15];
    public final  Types[] names = {Types.WOLF, Types.BOA, Types.FOX, Types.BEAR, Types.EAGLE, Types.HORSE,
            Types.DEER, Types.RABBIT, Types.MOUSE, Types.GOAT, Types.SHEEP, Types.BOAR, Types.BUFFALO,
            Types.DUCK, Types.WORM, Types.GRASS};

    public Property() {

    }
    public  Integer[]getProperty(int i){
        properties[0] = new Integer[]{0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0};//Wolf
        properties[1] = new Integer[]{0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0};//Boa
        properties[2] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0};//Fox
        properties[3] = new Integer[]{0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0};//Bear
        properties[4] = new Integer[]{0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0};//Eagle
        properties[5] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Horse
        properties[6] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Deer
        properties[7] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Rabbit
        properties[8] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100};//Mouse
        properties[9] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Goat
        properties[10] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Sheep
        properties[11] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100};//Boar
        properties[12] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Buffalo
        properties[13] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100};//Duck
        properties[14] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};//Worm
        return properties[i];
    }
    public HashMap<Types, Integer> setPropertyMap(Types type, int p){
        Integer[]arr = getProperty(p);
        HashMap<Types, Integer> propertyMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            propertyMap.put(names[i], arr[i]);
        }
        return propertyMap;
    }
    public HashMap<Types, Integer> getMap(Types type){
        HashMap<Types, HashMap<Types, Integer>> map = new HashMap<>();
        for (int i = 0; i < names.length - 1; i++) {
            map.put(names[i], setPropertyMap(type, i));
        }
        return map.get(type);
    }


}
