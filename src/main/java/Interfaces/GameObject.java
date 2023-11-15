package Interfaces;

import GameObjects.Cell;
import GameObjects.Coordinate;
import GameObjects.Types;

import java.util.HashMap;

public interface GameObject extends Runnable{
    public void play(Cell[][] cells);
    public int getMaxQuantity();
    public void setId(int id);
    public int getId();
    public Types getTypes();
    public void setCoordinate(int x, int y);
    public Coordinate getCoordinate();
    public void setWeight(int weight);
    public void setMaxWeight(int weight);
    public int getWeight();
    public void setProperty(HashMap<Types, Integer> propertyMap);
    public int getPropery(Types types);

}
