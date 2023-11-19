package Interfaces;

import GameObjects.Cell;
import GameObjects.Coordinate;
import GameObjects.Types;

import java.util.HashMap;

public interface GameObject extends Runnable{
    public void play(Cell[][] cells) throws CloneNotSupportedException;
    public int getMaxQuantity();
    public void setId(int id);
    public int getId();
    public Types getTypes();
    public void setCoordinate(int x, int y);
    public Coordinate getCoordinate();
    public void setWeight(int weight);
    public void setMaxWeight(int weight);
    public int getMaxWeight();
    public int getWeight();
    public void setProperty(HashMap<Types, Integer> propertyMap);
    public int getProperty(Types types);
    public String getAvatar();
    public void setAvatar(String avatar);
    public void setIdChild(int idChild);

}
