package Interfaces;

import GameObjects.*;

import java.util.HashMap;

public interface GameObject extends Runnable{
    public void play(GameField gameField) throws CloneNotSupportedException;
    public int getMaxQuantity();
    public void setId(int id);
    public int getId();
    public String getName();
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
    public GameField getGameField();
    public void setGameField(GameField gameField);
}
